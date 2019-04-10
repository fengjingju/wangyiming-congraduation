package com.project.wangyimingcongraduation.service;

import com.project.wangyimingcongraduation.domain.WeiboUser;

import java.util.List;

/**
 * @author create by FENGJINGJU
 * @Date 2019-04-09 16:46
 */
public interface WeiboUserService {

    List<WeiboUser> findAllWeiboUser() throws Exception;

    /**评论人群的性别比例*/
    List<WeiboUser> getUserSex();
}
