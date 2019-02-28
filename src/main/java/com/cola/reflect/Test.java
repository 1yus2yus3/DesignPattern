package com.cola.reflect;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/27 09:59
 * @description: 单列模式
 */
public class Test {

    private int age;

    private static Test singleton = new Test();

    //私有：保证没有外部创建实例的入口
    public Test() {
    }

    private static Test getInstance(String mes){
        System.out.println("======"+mes);
        return singleton;
    }

    public static void main(String[] args) {
        Test.getInstance("");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
