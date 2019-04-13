package com.project.wangyimingcongraduation.service.impl;

import com.project.wangyimingcongraduation.domain.WeiboUser;
import com.project.wangyimingcongraduation.mapper.WeiboUserMapper;
import com.project.wangyimingcongraduation.service.WeiboUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        String chinaZhiXiaShi = "北京,上海,重庆,天津,海外";
        String chinaSheng = "河北:石家庄,山西:太原,辽宁:沈阳,吉林:长春,黑龙江:哈尔滨,江苏:南京,浙江:杭州,安徽:合肥,福建:福州,台湾:台北,江西:南昌,山东:济南,河南:郑州,湖北:武汉,湖南:长沙,广东:广州,海南:海口,四川:成都,贵州:贵阳,云南:昆明,陕西:西安,甘肃:兰州,青海:西宁";

        String[] shengAndShenghui = chinaSheng.split(",");
        // map<省，省会>
        Map<String, String> shengAndShenghuiMap = new HashMap<>(shengAndShenghui.length);
        for (String sas : shengAndShenghui) {
            String[] temp = sas.split(":");
            shengAndShenghuiMap.put(temp[0], temp[1]);
        }

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


            /** 分割地域信息 */
            String zone = weiboUser.getZone();
            String[] zoneArray = zone.split(" ");
            if (zoneArray.length == 1) {
                if (!shengAndShenghuiMap.keySet().contains(zone)) {
                    weiboUser.setShi(zone);
                } else {
                    String shiTemp = shengAndShenghuiMap.get(zone);
                    if (shiTemp != null) {
                        weiboUser.setShi(shiTemp);
                    } else {
                        System.out.println("超出范围的：" + zone);
                    }
                }
            } else if (zoneArray.length == 2) {
                if (chinaZhiXiaShi.contains(zoneArray[0])) {
                    weiboUser.setShi(zoneArray[0]);
                } else {
                    weiboUser.setShi(zoneArray[1]);
                }
            } else {
                System.out.println("长度超过了2的：" + zone);
            }
        }
        return weiboUserList;
    }

    @Override
    public List<Integer> peopleAgeFeature() throws ParseException {
        List<Integer> resultList = new ArrayList<>();

        List<WeiboUser> weiboUserList = weiboUserMapper.findAllWeiboUser();
        int underEighteenNum = 0;// 18岁以下
        int eighteenToTwentyFour = 0;// 18-24
        int twentyFiveToTherityFour = 0;// 25-34
        int therityFiveToFortyFour = 0;// 35-44
        int fortyFiveAndMoreThanFortyFive = 0;// 45及以上
        int sumPeople = 0;// 总人数

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

                if (age < 18) {
                    underEighteenNum++;
                } else if (age >= 18 && age <= 24) {
                    eighteenToTwentyFour++;
                } else if (age >= 25 && age <= 34) {
                    twentyFiveToTherityFour++;
                } else if (age >= 35 && age <= 44) {
                    therityFiveToFortyFour++;
                } else if (age >= 45) {
                    fortyFiveAndMoreThanFortyFive++;
                }
                sumPeople++;
            }
        }

        double underEighteenNumPersent = new BigDecimal((float)underEighteenNum/sumPeople).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double eighteenToTwentyFourPersent = new BigDecimal((float)eighteenToTwentyFour/sumPeople).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double twentyFiveToTherityFourPersent = new BigDecimal((float)twentyFiveToTherityFour/sumPeople).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double therityFiveToFortyFourPersent = new BigDecimal((float)therityFiveToFortyFour/sumPeople).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double fortyFiveAndMoreThanFortyFivePersent = new BigDecimal((float)fortyFiveAndMoreThanFortyFive/sumPeople).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        resultList.add((underEighteenNum*100)/(sumPeople));
        resultList.add((eighteenToTwentyFour*100)/(sumPeople));
        resultList.add((twentyFiveToTherityFour*100)/(sumPeople));
        resultList.add((therityFiveToFortyFour*100)/(sumPeople));
        resultList.add((fortyFiveAndMoreThanFortyFive*100)/(sumPeople));

        return resultList;
    }

    @Override
    public List<WeiboUser> getUserSex() {
        return weiboUserMapper.getUserSex();
    }
}
