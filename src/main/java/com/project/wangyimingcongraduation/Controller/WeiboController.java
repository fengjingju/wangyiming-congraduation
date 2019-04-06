package com.project.wangyimingcongraduation.Controller;

import com.project.wangyimingcongraduation.domain.Weibo;
import com.project.wangyimingcongraduation.domain.WeiboComment;
import com.project.wangyimingcongraduation.domain.WeiboUser;
import com.project.wangyimingcongraduation.mapper.WeiboConmmentMapper;
import com.project.wangyimingcongraduation.mapper.WeiboMapper;
import com.project.wangyimingcongraduation.mapper.WeiboUserMapper;
import com.project.wangyimingcongraduation.util.FileUtil;
import com.project.wangyimingcongraduation.util.GsonUtil;
import com.project.wangyimingcongraduation.util.JsonInsertDatabaseUtil;
import com.project.wangyimingcongraduation.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 20:44
 */
@Controller
public class WeiboController {

//    @RequestMapping("/weiboJson")
//    public String out(){
//        String path="C:\\Users\\fengjingju\\Desktop\\王一名\\weibo.json";
//        List<String> jsonLineString = FileUtil.readFileByLine(path);
//        for(String jsonLine:jsonLineString) {
//            JsonInsertDatabaseUtil.inserDatabase(Weibo.class, jsonLine);
//        }
//        return "hello world!";
//    }
}
