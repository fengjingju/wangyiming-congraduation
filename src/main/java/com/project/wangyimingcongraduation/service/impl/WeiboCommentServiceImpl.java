package com.project.wangyimingcongraduation.service.impl;

import com.project.wangyimingcongraduation.domain.WeiboComment;
import com.project.wangyimingcongraduation.mapper.WeiboConmmentMapper;
import com.project.wangyimingcongraduation.mapper.WeiboMapper;
import com.project.wangyimingcongraduation.service.WeiboCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeiboCommentServiceImpl implements WeiboCommentService {

    @Autowired
    private WeiboConmmentMapper weiboConmmentMapper;

    @Override
    public List<WeiboComment> getEmotionTendency(){

        return weiboConmmentMapper.getemotionTendency();
    }

    @Override
    public List<WeiboComment> getclassifyEmotion(){
        return weiboConmmentMapper.getclassifyEmotion();
    }
}
