package com.cola.lambda;

import lombok.Data;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2020/01/15 17:03
 * @description:
 */
@Data
public class UserOptVo {
    /** 操作员人员 ***/
    private Long userId;
    /** 操作员名称 ***/
    private String userName;
    /** 操作员电话 ***/
    private String userPhone;

    public UserOptVo(Long userId) {
        this.userId = userId;
    }
}
