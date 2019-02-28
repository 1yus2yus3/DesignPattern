package com.cola.proxy.sta;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/02/27 18:16
 * @description: 代理类：搬运工，可能需要业务增强
 */
public class PersonAgent implements ManToolFactory{

    ManToolFactory manToolFactory;

    public PersonAgent(ManToolFactory manToolFactory) {
        this.manToolFactory = manToolFactory;
    }

    public void sellManTools(String size) {
        //业务前置增强
        dosomethingBefore();
        manToolFactory.sellManTools(size);
        //业务后置增强
        dosomethingEnd();
    }

    private void dosomethingBefore() {
        System.out.println("时长调研,需求分析....");
    }
    private void dosomethingEnd() {
        System.out.println("统计用户偏好....");
    }


}
