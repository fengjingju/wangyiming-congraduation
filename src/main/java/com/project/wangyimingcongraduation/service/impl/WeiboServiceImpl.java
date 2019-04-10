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
        /*各个政府部门发微博的总数统计*/
        return weiboMapper.getWeiboCount();
    }

    @Override
    public List<Weibo> getCommentCount(){
        /*各个政府部门一共收到的微博评论数量*/
        return weiboMapper.getCommentCount();
    }

    @Override
    public Integer getAvgComment(Integer weiboCount,Integer commentCount){
        /*各政府平均每条微博得到的评论数量*/
        return commentCount/weiboCount;
    }

}
