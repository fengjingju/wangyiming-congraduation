package com.project.wangyimingcongraduation.Controller;

import com.project.wangyimingcongraduation.domain.User;
import com.project.wangyimingcongraduation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 11:14
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String adminLogin(User user, ModelMap map, HttpServletRequest request) {
        User userResult = adminService.adminLogin(user);
        if (userResult != null) {// 登录成功
            request.getSession().setAttribute("admin", userResult);
            return "success";
        } else {
            map.addAttribute("loginError", "用户名或密码错误！");
            return "index";
        }
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String adminRegist(User user, ModelMap map, HttpServletRequest request) {
        try {
            adminService.adminRegist(user);
            return "success";
        } catch (Exception e) {
            map.addAttribute("registError", "注册失败！");
            return "index";
        }
    }
}
