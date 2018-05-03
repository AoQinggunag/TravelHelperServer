package com.xiaomo.netty4chat.common.core.annotation;

import java.lang.reflect.Method;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description:  基于反射业务处理封装类
 */
public class Invoker {

    /**业务类对象*/
    private Object target;
    /**业务方法*/
    private Method method;


    public Invoker() {
        super();
    }

    public Invoker(Object target, Method method) {
        super();
        this.target = target;
        this.method = method;
    }


    public static Invoker valueOf(Object target,Method method) {
        return new Invoker(target, method);
    }

    /**通过反射执行业务方法*/
    public Object invoke(Object ... args) throws Exception{

        return method.invoke(target, args);

    }
}
