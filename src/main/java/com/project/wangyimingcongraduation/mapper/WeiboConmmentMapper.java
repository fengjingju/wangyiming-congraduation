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

    @Select("SELECT emotionTendency,COUNT(wCid) as countnum FROM tbl_weibo_comment GROUP BY emotionTendency")
    List<WeiboComment> getemotionTendency();
}
