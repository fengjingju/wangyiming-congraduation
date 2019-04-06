package com.project.wangyimingcongraduation.util;

import com.project.wangyimingcongraduation.domain.Weibo;
import com.project.wangyimingcongraduation.domain.WeiboComment;
import com.project.wangyimingcongraduation.domain.WeiboUser;
import com.project.wangyimingcongraduation.mapper.WeiboConmmentMapper;
import com.project.wangyimingcongraduation.mapper.WeiboMapper;
import com.project.wangyimingcongraduation.mapper.WeiboUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 20:00
 */
public class JsonInsertDatabaseUtil {

    @Autowired
    private WeiboMapper weiboMapper;

    @Autowired
    private WeiboUserMapper weiboUserMapper;

    @Autowired
    private WeiboConmmentMapper weiboConmmentMapper;

    public <T> void inserDatabase(Class<T> tClass, String jsonString) {
        T object = GsonUtil.transferJsonStringToObject(jsonString, tClass);
        if (object instanceof Weibo) {
            ((Weibo) object).setWid(UuidUtil.getUuid());
            weiboMapper.insertWeibo((Weibo) object);
        } else if (object instanceof WeiboUser) {
            ((WeiboUser) object).setWUid(UuidUtil.getUuid());
            weiboUserMapper.insertWeiboUser((WeiboUser) object);
        } else if (object instanceof WeiboComment) {
            ((WeiboComment) object).setWCid(UuidUtil.getUuid());
            weiboConmmentMapper.insertWeiboComment((WeiboComment) object);
        }
    }
}
