/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.lichongbing.lswagger.springbootstarter.configuration;

import com.lichongbing.lswagger.springbootstarter.core.extend.OpenApiExtendSetting;
import com.lichongbing.lswagger.springbootstarter.core.model.MarkdownProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/***
 * 配置文件
 * @since:Lswagger 2.0.0
 * @author <a href="mailto:873610008@qq.com">873610008@qq.com</a>
 * 2019/08/27 15:40
 */
@Component
@ConfigurationProperties(prefix = "lswagger")
public class LswaggerProperties {
    /**
     * 是否开启Knife4j增强模式
     */
    private boolean enable=false;
    /**
     * 是否开启默认跨域
     */
    private boolean cors=false;

    /**
     * 是否开启BasicHttp验证
     */
    private LswaggerHttpBasic basic;

    /**
     * 是否生产环境
     */
    private boolean production=false;

    /**
     * 个性化配置
     */
    private OpenApiExtendSetting setting;

    /**
     * 分组文档集合
     */
    private List<MarkdownProperty> documents;

    public LswaggerHttpBasic getBasic() {
        return basic;
    }

    public void setBasic(LswaggerHttpBasic basic) {
        this.basic = basic;
    }

    public boolean isProduction() {
        return production;
    }

    public void setProduction(boolean production) {
        this.production = production;
    }

    public List<MarkdownProperty> getDocuments() {
        return documents;
    }

    public void setDocuments(List<MarkdownProperty> documents) {
        this.documents = documents;
    }

    public OpenApiExtendSetting getSetting() {
        return setting;
    }

    public void setSetting(OpenApiExtendSetting setting) {
        this.setting = setting;
    }

    public boolean isCors() {
        return cors;
    }

    public void setCors(boolean cors) {
        this.cors = cors;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
