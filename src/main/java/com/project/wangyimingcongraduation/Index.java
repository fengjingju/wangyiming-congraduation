package com.project.wangyimingcongraduation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 14:30
 */
@Controller
public class Index {

    @RequestMapping("/index")
    public String index(){
        System.out.println("访问首页成功");
        return "index";
    }

    @RequestMapping("/echart")
    public String echartTest(){
        return "echart/pieChart";
    }
}
