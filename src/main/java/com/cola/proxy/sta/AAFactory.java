package com.cola.proxy.sta;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/27 18:09
 * @description: 真正提供服务的工厂
 */
public class AAFactory implements ManToolFactory{

    public void sellManTools(String size) {
        System.out.println("根据你的需求提供 Size : "+size + "给您");
    }
}
