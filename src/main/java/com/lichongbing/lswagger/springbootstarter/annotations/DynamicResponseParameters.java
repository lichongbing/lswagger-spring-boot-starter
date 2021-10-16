/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.lichongbing.lswagger.springbootstarter.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @since:Lswagger 2.0.0
 * @author <a href="mailto:873610008@qq.com">873610008@qq.com</a>
 * 2019-7-31 12:54:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicResponseParameters {

    /***
     * dynamic Model name
     * @return 类名
     */
    String name() default "";

    /***
     * list of properties
     * @return 类属性集合
     */
    DynamicParameter[] properties() default @DynamicParameter;


}
