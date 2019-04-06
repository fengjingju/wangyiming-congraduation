package com.project.wangyimingcongraduation.util;

import java.util.UUID;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 14:58
 */
public class UuidUtil {

    /**
     * 获取32位随机数
     * */
    public static String getUuid(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}
