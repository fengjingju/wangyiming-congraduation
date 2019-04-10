package com.project.wangyimingcongraduation.service.impl;

import com.project.wangyimingcongraduation.domain.WeiboUser;
import com.project.wangyimingcongraduation.mapper.WeiboUserMapper;
import com.project.wangyimingcongraduation.service.WeiboUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author create by FENGJINGJU
 * @Date 2019-04-09 16:47
 */
@Service
public class WeiboUserServiceImpl implements WeiboUserService {

    @Autowired
    private WeiboUserMapper weiboUserMapper;

    @Override
    public List<WeiboUser> findAllWeiboUser() throws Exception {
        List<WeiboUser> weiboUserList = weiboUserMapper.findAllWeiboUser();
        for (WeiboUser weiboUser : weiboUserList) {

            /** 计算年龄 */
            String birth = weiboUser.getBirth();
            Calendar cal = Calendar.getInstance();
            int yearNow = cal.get(Calendar.YEAR);  //当前年份
            int monthNow = cal.get(Calendar.MONTH);  //当前月份
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
            if (birth != null && birth.contains("-") && (birth.startsWith("1") || birth.startsWith("2")) && birth.length() == 10) {
                Date birthDay = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
                if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
                    throw new IllegalArgumentException(
                            "The birthDay is before Now.It's unbelievable!");
                }
                cal.setTime(birthDay);
                int yearBirth = cal.get(Calendar.YEAR);
                int monthBirth = cal.get(Calendar.MONTH);
                int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
                int age = yearNow - yearBirth;   //计算整岁数
                if (monthNow <= monthBirth) {
                    if (monthNow == monthBirth) {
                        if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
                    } else {
                        age--;//当前月份在生日之前，年龄减一
                    }
                }
                weiboUser.setAge(age);
            }


            /**评论人群的性别比例*/
            public List<WeiboUser> getUserSex();{
                return weiboUserMapper.getUserSex();
            }


            /** 分割地域信息 */
            String zone = weiboUser.getZone();
        }
        return weiboUserList;
    }
}
