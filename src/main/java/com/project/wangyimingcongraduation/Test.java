package com.project.wangyimingcongraduation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 14:30
 *
 * 最初测试程序，hello World
 */
@Controller
public class Test {
    @RequestMapping("/hello")
    public String out(){
        System.out.println("springBoot启动成功");
        return "echart/weiboSum";
    }
}
