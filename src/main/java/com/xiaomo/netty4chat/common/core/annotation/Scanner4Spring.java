package com.xiaomo.netty4chat.common.core.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description:  spring 扫描器，扫描自定义注解
 */

@Component
public class Scanner4Spring implements BeanPostProcessor{

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("开始注解扫描bean - " + beanName);

        // 获取 bean 的所有接口（使用注解时面向接口编程）
        Class<?>[] interfaces = bean.getClass().getInterfaces();
        if(interfaces != null && interfaces.length > 0){
            // 获取使用了 Module 注解的接口
            for(Class<?> inface : interfaces){
                MoModule module = inface.getAnnotation(MoModule.class);
                MoConfig config = inface.getAnnotation(MoConfig.class);
                if(module != null){
                    // 获取接口中的使用了 Cmd 注解的方法
                    Method[] methods = inface.getMethods();
                    if(methods != null && methods.length > 0){
                        for(Method method : methods){
                            MoCmd cmd = method.getAnnotation(MoCmd.class);
                            if(cmd == null){
                                continue;
                            }

                            // 注册 invoker
                            short moduleVal = module.module();
                            short cmdVal = cmd.cmd();
                            Invoker invoker = Invoker.valueOf(bean, method);
                            InvokerHolder.putInvoker(moduleVal, cmdVal, invoker);

                            System.out.println("注册处理器：模块号-"+moduleVal + ",命令号-" + cmdVal);

                        }
                    }
                }
                if(config != null){
                    Method[] methods = inface.getMethods();
                    if(methods != null && methods.length > 0){
                        for(Method method : methods){
                            InactiveHandler inactiveHandler = method.getAnnotation(InactiveHandler.class);
                            if(inactiveHandler == null){
                                continue;
                            }
                            Invoker invoker = Invoker.valueOf(bean,method);
                            InvokerHolder.putConfigInvoker("InactiveHandler",invoker);

                            System.out.println("注册处理器：断开连接处理器");
                        }
                    }
                }
            }
        }

        return bean;

    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
