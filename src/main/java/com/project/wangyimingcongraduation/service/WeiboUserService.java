package com.project.wangyimingcongraduation.service;

import com.project.wangyimingcongraduation.domain.WeiboUser;

import java.text.ParseException;
import java.util.List;

/**
 * @author create by FENGJINGJU
 * @Date 2019-04-09 16:46
 */
public interface WeiboUserService {

    /**评论人群的年龄，地域分布*/
    List<WeiboUser> findAllWeiboUser() throws Exception;

    /** 获取不同年龄阶段的人评论人数 */
    List<Integer> peopleAgeFeature() throws ParseException;

    /**评论人群的性别比例*/
    List<WeiboUser> getUserSex();
}
