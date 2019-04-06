package com.project.wangyimingcongraduation;

import com.project.wangyimingcongraduation.domain.Weibo;
import com.project.wangyimingcongraduation.util.FileUtil;
import com.project.wangyimingcongraduation.util.JsonInsertDatabaseUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WangyimingCongraduationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WangyimingCongraduationApplication.class, args);
        System.out.println("===============Springboot启动成功！===============");
    }
}
