package com.project.wangyimingcongraduation.mapper;

import com.project.wangyimingcongraduation.domain.Weibo;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:42
 */
public interface WeiboMapper {

    @Insert("INSERT INTO tbl_weibo (wid,weiboNumber,sender,title,content) VALUES (#{wid},#{weiboNumber},#{sender},#{title},#{content})")
    void insertWeibo(Weibo weibo);
}
