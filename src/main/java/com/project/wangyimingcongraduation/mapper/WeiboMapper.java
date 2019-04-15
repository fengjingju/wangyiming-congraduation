package com.project.wangyimingcongraduation.mapper;

import com.project.wangyimingcongraduation.domain.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:42
 */
@Mapper
@Repository
public interface WeiboMapper {

    @Insert("INSERT INTO tbl_weibo (wid,weiboNumber,sender,title,content,commentNum) VALUES (#{wid},#{weiboNumber},#{sender},#{title},#{content},#{commentNum})")
    void insertWeibo(Weibo weibo);

    @Select("SELECT sender,COUNT(*) as weiboCount FROM tbl_weibo GROUP BY sender ORDER BY sender")
    List<Weibo> getWeiboCount();

    @Select("SELECT sender , SUM(commentNum) as commentCount FROM tbl_weibo GROUP BY sender")
    List<Weibo> getCommentCount();

    @Select("SELECT sender FROM tbl_weibo GROUP BY sender")
    List<Weibo> getSenderList();

    //@Select("select sender ,ROUND(avg(commentNum)) AS avgcomment from tbl_weibo GROUP BY sender")

}
