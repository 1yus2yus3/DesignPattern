package com.cola.singletom;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/27 09:59
 * @description: 单列模式
 */
public class Singleton1 {

    private static Singleton1 instance = null;

    //私有：保证没有外部创建实例的入口
    private Singleton1() {
    }

    //并发时会创建过个对象实例
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
    //同步锁能保证产生的实例唯一 资源消耗大
    public synchronized static Singleton1 getInstance1(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

    //同步锁能保证产生的实例唯一 一旦实例存在 线程不会进入同步代码锁 减少资源浪费
    public static Singleton1 getInstance2(){
        if(instance == null){
            synchronized (Singleton1.class){
                if(instance == null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

    //volatile修饰静态成员变量
    private volatile static Singleton1 instance1 = null;
    //同步锁能保证产生的实例唯一 一旦实例存在 线程不会进入同步代码锁 减少资源浪费
    public static Singleton1 getInstance3(){
        if(instance1 == null){
            synchronized (Singleton1.class){
                if(instance1 == null){
                    instance1 = new Singleton1();
                }
            }
        }
        return instance1;
    }


    /***
     * 内部内实现单列模式 较优解
     */
    private static class SingletonInner {
        private static Singleton1 singletonInner = new Singleton1();
    }
    public static Singleton1 getInstance4(){
        return SingletonInner.singletonInner;
    }

    /***
     * 非延时加载 ： 资源利用率差 真正需要使用的时候去创建
     * @param args
     */
    public static void main(String[] args) {
        Singleton1.getInstance();
    }
}
