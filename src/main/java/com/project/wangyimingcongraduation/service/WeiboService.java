package com.project.wangyimingcongraduation.service;

import com.project.wangyimingcongraduation.domain.Weibo;

import java.awt.*;

public interface WeiboService {
    List<Weibo> getWeiboCount();
    List<Weibo> getCommentCount();
    Integer getAvgComment(Integer weiboCount,Integer commentCount);
}
