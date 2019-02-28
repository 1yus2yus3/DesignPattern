package com.cola.singletom;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/27 09:59
 * @description: 单列模式
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    //私有：保证没有外部创建实例的入口
    private Singleton() {
    }

    //获取实例的唯一入口
    public static Singleton getInstance(String mes){
        System.out.println("======"+mes);
        return singleton;
    }

    /***
     * 非延时加载 ： 资源利用率差 真正需要使用的时候去创建
     * @param args
     */
    public static void main(String[] args) {
        //Singleton.getInstance();
    }
}
