package com.cola.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/12/17 15:50
 * @description:
 */
public class ClassAttributeResovel {

    static Map<Long,String> BASE_DATA_USER_NAME_MAP = new HashMap<>();
    static Map<Long,String> BASE_DATA_USER_PHONE_MAP = new HashMap<>();

    static {

        BASE_DATA_USER_NAME_MAP.put(1L,"ADMIN_001");
        BASE_DATA_USER_NAME_MAP.put(2L,"ADMIN_002");
        BASE_DATA_USER_NAME_MAP.put(3L,"ADMIN_003");
        BASE_DATA_USER_NAME_MAP.put(4L,"ADMIN_004");


        BASE_DATA_USER_PHONE_MAP.put(1L,"111111111111");
        BASE_DATA_USER_PHONE_MAP.put(2L,"222222222222");
        BASE_DATA_USER_PHONE_MAP.put(3L,"333333333333");
        BASE_DATA_USER_PHONE_MAP.put(4L,"444444444444");

    }


    public static <T> void resovelAttribute(List<T> targetList, Function<T,Long> function , AttributeReplace<T> resovel){
        targetList.forEach(item->{
            resovel.resovel(item,BASE_DATA_USER_NAME_MAP.get(function.apply(item)),BASE_DATA_USER_PHONE_MAP.get(function.apply(item)));
        });
    }


    @FunctionalInterface
    public interface AttributeReplace<T>{
       void resovel(T object,String nickName,String userHeadPic);
    }


    public static void main(String[] args) {
        List<UserOptVo> testOptList = new ArrayList<>();
        testOptList.add(new UserOptVo(1L));
        testOptList.add(new UserOptVo(2L));
        testOptList.add(new UserOptVo(3L));
        testOptList.add(new UserOptVo(4L));

        //将控制填充数据
        resovelAttribute(testOptList,UserOptVo::getUserId,((object, nickName, userPhone) -> {
            object.setUserName(nickName);
            object.setUserPhone(userPhone);
        }));

        testOptList.forEach(item->System.out.print(item));
    }

}
