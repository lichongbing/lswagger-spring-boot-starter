/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.lichongbing.lswagger.springbootstarter.annotations;

import com.lichongbing.lswagger.springbootstarter.configuration.LswaggerAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/***
 * Enable Knife4j enhanced annotation and use @EnableSwagger2 annotation together.
 *
 * inlude:
 * <ul>
 *     <li>Interface sorting </li>
 *     <li>Interface document download  (word)</li>
 * </ul>
 * @author lichongbing
 * @since 2.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({LswaggerAutoConfiguration.class})
@ConditionalOnWebApplication
public @interface EnableLswagger {
}
