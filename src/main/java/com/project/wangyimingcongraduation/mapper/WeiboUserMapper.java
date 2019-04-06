package com.project.wangyimingcongraduation.mapper;

import com.project.wangyimingcongraduation.domain.WeiboUser;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 19:44
 */
public interface WeiboUserMapper {

    @Insert("INSERT INTO tbl_weibo_user (wUid,userNumber,nickname,userCertificate,sex,zone,birth,introduction,tag) VALUES (#{wUid},#{userNumber},#{nickname},#{userCertificate},#{sex},#{zone},#{birth},#{introduction},#{tag})")
    void insertWeiboUser(WeiboUser weiboUser);
}
