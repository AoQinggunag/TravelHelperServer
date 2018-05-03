package com.xiaomo.netty4chat.common.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: 命令号注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MoCmd {

    /**请求命令号*/
    short cmd();

}
