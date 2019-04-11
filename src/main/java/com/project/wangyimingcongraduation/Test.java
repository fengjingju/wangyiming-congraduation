package com.project.wangyimingcongraduation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 14:30
 *
 * 最初测试程序，hello World
 */
@Controller
public class Test {
    @RequestMapping("/weibo")
    public String outWeibo(){
        System.out.println("微博原文展示");
        return "echart/weibo";
    }

    @RequestMapping("/weibosum")
    public String outWeiboSum(){
        System.out.println("政府微博活跃度展示");
        return "echart/weiboSum";
    }

    @RequestMapping("/weibocommentsum")
    public String outCommentSum(){
        System.out.println("微博评论聚集度展示");
        return "echart/commentSum";
    }

    @RequestMapping("/user")
    public String outUser(){
        System.out.println("评论人群特征分析");
        return "echart/user";
    }

    @RequestMapping("/userarea")
    public String outUserarea(){
        System.out.println("评论人群地域分布");
        return "echart/userarea";
    }

    @RequestMapping("/useremotion")
    public String outUseremotion(){
        System.out.println("评论情感分布");
        return "echart/useremoion";
    }
}
