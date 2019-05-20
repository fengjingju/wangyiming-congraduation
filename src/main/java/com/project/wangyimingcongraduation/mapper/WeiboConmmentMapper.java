package com.project.wangyimingcongraduation.mapper;

import com.project.wangyimingcongraduation.domain.WeiboComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:47
 */
@Mapper
@Repository
public interface WeiboConmmentMapper {

    @Insert("INSERT INTO tbl_weibo_comment (wCid,commentNumber,commentUser,commentWeiBoNumber,commentContent,emotionTendency) VALUES (#{wCid},#{commentNumber},#{commentUser},#{commentWeiBoNumber},#{commentContent},#{emotionTendency})")
    void insertWeiboComment(WeiboComment weiboComment);

    @Select("SELECT emotionTendency,COUNT(wCid) as countnum FROM tbl_weibo_comment GROUP BY emotionTendency ORDER BY emotionTendency")
    List<WeiboComment> getemotionTendency();

    @Select("SELECT temp.sender,count(*) as emotionnum,temp.emotionTendency from(SELECT tbl_weibo.sender,tbl_weibo_comment.emotionTendency FROM tbl_weibo,tbl_weibo_comment WHERE tbl_weibo.weiboNumber = tbl_weibo_comment.commentWeiBoNumber ORDER BY sender)AS temp GROUP BY temp.sender,temp.emotionTendency ORDER BY temp.sender")
    List<WeiboComment> getclassifyEmotion();

    @Select("SELECT * FROM tbl_weibo_comment")
    List<WeiboComment> findAllWeiboComment();
}
