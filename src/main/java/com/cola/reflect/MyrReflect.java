package com.cola.reflect;

import com.cola.singletom.Singleton;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/27 15:35
 * @description:
 */
public class MyrReflect {
    public static void main(String[] args) throws Exception{
        //根据类获取类中的所有方法
        Method[] methods = Test.class.getMethods();
        for (Method method:methods) {
            System.out.println(method);
        }

        //根据反射调用方法
        Class cls = Class.forName("com.cola.reflect.Test");
        Method m1 = cls.getDeclaredMethod("getInstance",String.class);//参数类型需要
        m1.setAccessible(true);//私有方法设置权限
        m1.invoke(cls.newInstance(),"test1");//这里不需要newInstance  静态方法直接用类名调用

        //根据反射给私有变量赋值
        Class cls1 = Class.forName("com.cola.reflect.Test");
        //示例话一个对象
        Object obj = cls1.newInstance();
        Field fieldAge = cls1.getDeclaredField("age");
        fieldAge.setAccessible(true); //私有变量 需要开启权限
        fieldAge.set(obj,23);
        System.out.println(fieldAge.get(obj));
    }
}
