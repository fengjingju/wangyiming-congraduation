package com.project.wangyimingcongraduation.service.impl;

import com.project.wangyimingcongraduation.domain.User;
import com.project.wangyimingcongraduation.mapper.AdminMapper;
import com.project.wangyimingcongraduation.service.AdminService;
import com.project.wangyimingcongraduation.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 14:01
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public User adminLogin(User user) {
        return adminMapper.adminLogin(user);
    }

    @Override
    public void adminRegist(User user) {
        user.setUid(UuidUtil.getUuid());
        adminMapper.adminRegist(user);
    }
}
