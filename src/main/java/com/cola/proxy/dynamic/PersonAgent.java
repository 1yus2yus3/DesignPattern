package com.cola.proxy.dynamic;

import com.cola.proxy.sta.ManToolFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/27 18:16
 * @description: 代理类：两个要素：包含正式代理对象 + 实现InvocationHandler接口
 */
public class PersonAgent implements InvocationHandler {

    //实际真是工厂 预定义
    Object factory;

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    /***
     * 动态代理关键代码
     * public Class<?> apply(ClassLoader loader, Class<?>[] interfaces)
     * 这个方法根据传入的示例对象 构建一个$Proxy0 反射得到一个一样的class对象 包含所有方法和成员变量以及Object自带的方法
     * @return
     */

    //通过代理获取真是工厂对象
    public Object getProxyInstance(){
        //代理对象
        //代理对象的接口
        //InvocationHandler 当前以实现的对象
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),this);
    }

    //执行方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        dosomethingBefore();
        //调用真实对象的方法执行
        Object ret = method.invoke(factory,args);
        dosomethingEnd();
        return ret;
    }

    private void dosomethingBefore() {
        System.out.println("时长调研,需求分析....");
    }
    private void dosomethingEnd() {
        System.out.println("统计用户偏好....");
    }


}
