/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.lichongbing.lswagger.springbootstarter.annotations;
import java.lang.annotation.*;

/**
 * <p>Help Java development engineers build powerful Swagger documents</p>
 * <p>This annotation belongs to the enhanced annotation of @Api, which is unique to Knife4j and provides Swagger's extended attributes.</p>
 * @since:Lswagger 2.0.0
 * @author <a href="mailto:873610008@qq.com">873610008@qq.com</a>
 * 2020/03/31 12:26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiSupport {

    /***
     * Sort Fields
     * @return 排序
     */
    int order() default Integer.MAX_VALUE;


    /***
     * author
     * @return 开发者
     */
    String author() default "";

}
