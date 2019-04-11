package com.project.wangyimingcongraduation.service;

import com.project.wangyimingcongraduation.domain.Weibo;

import java.util.List;


public interface WeiboService {
    /**各个政府部门发微博的总数统计*/
    List<Weibo> getWeiboCount();

    /**各个政府部门一共收到的微博评论数量*/
    List<Weibo> getCommentCount();

    /**平均各个政府部门一共收到的微博评论数量*/
    List<Weibo> getAvgComment();
}
