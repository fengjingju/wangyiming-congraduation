package com.project.wangyimingcongraduation.domain;

import lombok.Data;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:22
 *
 * 微博评论信息实体
 */
@Data
public class WeiboComment {
    private String wCid;
    private Integer commentNumber;
    private Integer commentUser;
    private Integer commentWeiBoNumber;
    private String commentContent;
    private Integer emotionTendency;
}
