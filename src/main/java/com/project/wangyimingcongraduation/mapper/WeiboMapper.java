package com.project.wangyimingcongraduation.mapper;

import com.project.wangyimingcongraduation.domain.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:42
 */
@Mapper
@Repository
public interface WeiboMapper {

    @Insert("INSERT INTO tbl_weibo (wid,weiboNumber,sender,title,content,commentNum) VALUES (#{wid},#{weiboNumber},#{sender},#{title},#{content},#{commentNum})")
    void insertWeibo(Weibo weibo);
}
