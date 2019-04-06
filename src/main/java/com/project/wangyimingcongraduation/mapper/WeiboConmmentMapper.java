package com.project.wangyimingcongraduation.mapper;

import com.project.wangyimingcongraduation.domain.WeiboComment;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:47
 */
public interface WeiboConmmentMapper {

    @Insert("INSERT INTO tbl_weibo_comment (wCid,commentNumber,commentUser,commentWeiBoNumber,commentContent,emotionTendency) VALUES (#{wCid},#{commentNumber},#{commentUser},#{commentWeiBoNumber},#{commentContent},#{emotionTendency})")
    void insertWeiboComment(WeiboComment weiboComment);
}
