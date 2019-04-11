package com.project.wangyimingcongraduation.service;

import com.project.wangyimingcongraduation.domain.WeiboComment;

import java.util.List;

public interface WeiboCommentService {
    /**得到评论舆情倾向，并统计数量*/
    List<WeiboComment> getEmotionTendency();
}
