package com.cola.proxy.dynamic;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/28 10:50
 * @description:
 */
public class Client {

    public static void main(String[] args) throws Exception{
        //接口示例话具体工厂
        ManToolFactory factory = new AAFactory();
        //代理示例化
        PersonAgent zhangsan = new PersonAgent();
        //告诉代理使用具体那个工厂
        zhangsan.setFactory(factory);
        //通过代理获取到具体真是对象
        ManToolFactory manToolFactory = (ManToolFactory)zhangsan.getProxyInstance();
        //执行真是方法
        manToolFactory.sellManTools("D");


        //ManToolFactory 代理对象的源码文件
        /*byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                manToolFactory.getClass().getName(), manToolFactory.getClass().getInterfaces());

        FileOutputStream outputStream = new FileOutputStream(new File(
                "$Proxy0.class"));
        outputStream.write(proxyClassFile);
        outputStream.flush();
        outputStream.close();*/

    }
}
