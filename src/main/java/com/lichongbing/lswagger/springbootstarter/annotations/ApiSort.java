package com.lichongbing.lswagger.springbootstarter.annotations;


import java.lang.annotation.*;

/**
 * Deprecated since 2.0.3,see {@link ApiSupport}
 * @since:Lswagger 2.0.0
 * @author <a href="mailto:873610008@qq.com">873610008@qq.com</a>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiSort {

    /**
     * tag order value, Deprecated since 2.0.3,see {@link ApiSupport} order field
     * @return order
     */
   int value() default Integer.MAX_VALUE;
}
