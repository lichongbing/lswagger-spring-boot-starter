/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.lichongbing.lswagger.springbootstarter.configuration;

import com.lichongbing.lswagger.springbootstarter.core.extend.OpenApiExtendSetting;
import com.lichongbing.lswagger.springbootstarter.spring.extension.OpenApiExtensionResolver;
import com.lichongbing.lswagger.springbootstarter.spring.filter.ProductionSecurityFilter;
import com.lichongbing.lswagger.springbootstarter.spring.filter.SecurityBasicAuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/***
 * Lswagger 基础自动配置类
 * @since:Lswagger 2.0.0
 * @author <a href="mailto:873610008@qq.com">873610008@qq.com</a>
 * 2021/02/28 21:08
 */
@Configuration
@EnableConfigurationProperties({LswaggerProperties.class})
@ComponentScan(
        basePackages = {
                "com.lichongbing.lswagger.spring.plugin"
        }
)
@ConditionalOnProperty(name = "lswagger.enable",havingValue = "true")
public class LswaggerAutoConfiguration {

    @Autowired
    private Environment environment;
    Logger logger= LoggerFactory.getLogger(LswaggerAutoConfiguration.class);

    /**
     * 配置Cors
     * @since 2.0.4
     * @return
     */
    @Bean("lswaggerCorsFilter")
    @ConditionalOnMissingBean(CorsFilter.class)
    @ConditionalOnProperty(name = "lswagger.cors",havingValue = "true")
    public CorsFilter corsFilter(){
        logger.info("init CorsFilter...");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setMaxAge(10000L);
        //匹配所有API
        source.registerCorsConfiguration("/**",corsConfiguration);
        CorsFilter corsFilter=new CorsFilter(source);
        return corsFilter;
    }


    @Bean(initMethod = "start")
    @ConditionalOnMissingBean(OpenApiExtensionResolver.class)
    @ConditionalOnProperty(name = "lswagger.enable",havingValue = "true")
    public OpenApiExtensionResolver markdownResolver(LswaggerProperties lswaggerProperties){
        OpenApiExtendSetting setting=lswaggerProperties.getSetting();
        if (setting==null){
            setting=new OpenApiExtendSetting();
        }
        return new OpenApiExtensionResolver(setting, lswaggerProperties.getDocuments());
    }

    @Bean
    @ConditionalOnMissingBean(SecurityBasicAuthFilter.class)
    @ConditionalOnProperty(name = "lswagger.basic.enable",havingValue = "true")
    public SecurityBasicAuthFilter securityBasicAuthFilter(LswaggerProperties lswaggerProperties){
        boolean enableSwaggerBasicAuth=false;
        String dftUserName="admin",dftPass="123321";
        SecurityBasicAuthFilter securityBasicAuthFilter=null;
        if (lswaggerProperties==null){
            if (environment!=null){
                String enableAuth=environment.getProperty("lswagger.basic.enable");
                enableSwaggerBasicAuth=Boolean.valueOf(enableAuth);
                if (enableSwaggerBasicAuth){
                    //如果开启basic验证,从配置文件中获取用户名和密码
                    String pUser=environment.getProperty("lswagger.basic.username");
                    String pPass=environment.getProperty("lswagger.basic.password");
                    if (pUser!=null&&!"".equals(pUser)){
                        dftUserName=pUser;
                    }
                    if (pPass!=null&&!"".equals(pPass)){
                        dftPass=pPass;
                    }
                }
                securityBasicAuthFilter=new SecurityBasicAuthFilter(enableSwaggerBasicAuth,dftUserName,dftPass);
            }
        }else{
            //判断非空
            if(lswaggerProperties.getBasic()==null){
                securityBasicAuthFilter=new SecurityBasicAuthFilter(enableSwaggerBasicAuth,dftUserName,dftPass);
            }else{
                securityBasicAuthFilter=new SecurityBasicAuthFilter(lswaggerProperties.getBasic().isEnable(),lswaggerProperties.getBasic().getUsername(),lswaggerProperties.getBasic().getPassword());
            }
        }
        return securityBasicAuthFilter;
    }


    @Bean
    @ConditionalOnMissingBean(ProductionSecurityFilter.class)
    @ConditionalOnProperty(name = "lswagger.production",havingValue = "true")
    public ProductionSecurityFilter productionSecurityFilter(LswaggerProperties lswaggerProperties){
        boolean prod=false;
        ProductionSecurityFilter p=null;
        if (lswaggerProperties==null){
            if (environment!=null){
                String prodStr=environment.getProperty("lswagger.production");
                if (logger.isDebugEnabled()){
                    logger.debug("swagger.production:{}",prodStr);
                }
                prod=Boolean.valueOf(prodStr);
            }
            p=new ProductionSecurityFilter(prod);
        }else{
            p=new ProductionSecurityFilter(lswaggerProperties.isProduction());
        }

        return p;
    }


}
