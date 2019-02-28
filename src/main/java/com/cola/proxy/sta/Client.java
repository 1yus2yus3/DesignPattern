package com.cola.proxy.sta;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/27 18:21
 * @description:
 */
public class Client {

    /***
     * 静态代理 ：
     * @param args
     */
    public static void main(String[] args) {
        //1:AA公司
        ManToolFactory manToolFactory = new AAFactory();
        //2:张三专业代购 代理该公司的Man用品业务
        PersonAgent zhangsan = new PersonAgent(manToolFactory);
        //3:李四购买张三的产品
        zhangsan.sellManTools("A");

        //如果此时业务发生变化 张三 需要售卖Woman用品其他产品
        //1)需要新增接口 2）新增工厂 3)代理实现新增接口

    }
}
