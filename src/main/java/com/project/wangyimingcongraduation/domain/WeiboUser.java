package com.project.wangyimingcongraduation.domain;

import lombok.Data;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:22
 *
 * 微博用户信息实体
 */
@Data
public class WeiboUser {
    private String wUid;
    private Integer userNumber;
    private String nickname;
    private String userCertificate;
    private String sex;
    private String zone;
    private String birth;
    private String introduction;
    private String tag;
}
