package com.weiye.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 *自定义注解 拦截Controller  
 */    
    
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface SystemControllerLog {    
    /** 需要打印的日志 */
    String value() default "";
    /** 排除不打印参数下表，从0开始 */
    int[] exclude() default {};
    
} 