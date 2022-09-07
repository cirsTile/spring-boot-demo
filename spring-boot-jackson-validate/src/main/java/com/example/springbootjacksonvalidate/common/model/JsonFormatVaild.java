package com.example.springbootjacksonvalidate.common.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author panyi
 * @ClassName JsonFormatVaild.java
 * @Description TODO
 * @date Created in 2022/9/7 22:44
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormatVaild {
    String message() default "";
}