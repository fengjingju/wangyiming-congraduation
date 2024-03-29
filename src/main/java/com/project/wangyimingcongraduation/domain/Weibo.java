package com.project.wangyimingcongraduation.domain;

import lombok.Data;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:22
 *
 * 微博信息实体
 */
@Data
public class Weibo {
    private String wid;
    private Integer weiboNumber;
    private String sender;
    private String title;
    private String content;
}
