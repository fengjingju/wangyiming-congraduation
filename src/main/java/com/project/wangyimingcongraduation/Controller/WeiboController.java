package com.project.wangyimingcongraduation.Controller;

import com.project.wangyimingcongraduation.domain.Weibo;
import com.project.wangyimingcongraduation.domain.WeiboComment;
import com.project.wangyimingcongraduation.domain.WeiboUser;
import com.project.wangyimingcongraduation.service.WeiboUserService;
import com.project.wangyimingcongraduation.util.FileUtil;
import com.project.wangyimingcongraduation.util.JsonInsertDatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 20:44
 */
@RestController
public class WeiboController {

    @Autowired
    private JsonInsertDatabaseUtil jsonInsertDatabaseUtil;

    @Autowired
    private WeiboUserService weiboUserService;

    @RequestMapping("/weiboJson")
    public String out(){
        String path="C:\\Users\\fengjingju\\Desktop\\王一名\\weibo.json";
        List<String> jsonLineString = FileUtil.readFileByLine(path);
        for(String jsonLine:jsonLineString) {
            jsonInsertDatabaseUtil.inserDatabase(Weibo.class, jsonLine);
        }
        return "导入成功";
    }

    @RequestMapping("/findAllWeiboUser")
    public List<WeiboUser> findAllWeiboUser() throws Exception {
        return weiboUserService.findAllWeiboUser();
    }

    @RequestMapping("/weibo")
}
