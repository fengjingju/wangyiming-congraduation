package com.project.wangyimingcongraduation.domain;

import lombok.Data;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 11:09
 */
@Data
public class User {
    private String uid;// 用户主键
    private String userName;// 用户名
    private String password;// 密码
}
