package com.project.wangyimingcongraduation.service.impl;

import com.project.wangyimingcongraduation.domain.Weibo;
import com.project.wangyimingcongraduation.domain.WeiboUser;
import com.project.wangyimingcongraduation.mapper.WeiboMapper;
import com.project.wangyimingcongraduation.service.WeiboService;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;

@Service
public class WeiboServiceImpl implements WeiboService {

    @Autowired
    private WeiboMapper weiboMapper;

    @Override
    public List<Weibo> getWeiboCount(){
        return weiboMapper.getWeiboCount();
    }

    @Override
    public List<Weibo> getCommentCount(){
        return weiboMapper.getCommentCount();
    }

    @Override
    public Integer getAvgComment(Integer weiboCount,Integer commentCount){
        return commentCount/weiboCount;
    }

}
