package com.project.wangyimingcongraduation.Controller;

import com.project.wangyimingcongraduation.domain.RelationshipEchartEntity;
import com.project.wangyimingcongraduation.domain.Weibo;
import com.project.wangyimingcongraduation.domain.WeiboComment;
import com.project.wangyimingcongraduation.domain.WeiboUser;
import com.project.wangyimingcongraduation.service.WeiboCommentService;
import com.project.wangyimingcongraduation.service.WeiboService;
import com.project.wangyimingcongraduation.service.WeiboUserService;
import com.project.wangyimingcongraduation.util.FileUtil;
import com.project.wangyimingcongraduation.util.JsonInsertDatabaseUtil;
import com.project.wangyimingcongraduation.util.MakeEchartsJsonStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 20:44
 */
@Controller
public class WeiboController {

    @Autowired
    private JsonInsertDatabaseUtil jsonInsertDatabaseUtil;

    @Autowired
    private WeiboUserService weiboUserService;

    @Autowired
    private WeiboService weiboService;

    @Autowired
    private WeiboCommentService weiboCommentService;

    @RequestMapping("/weiboJson")
    public String out() {
        String path = "C:\\Users\\fengjingju\\Desktop\\王一名\\weibo.json";
        List<String> jsonLineString = FileUtil.readFileByLine(path);
        for (String jsonLine : jsonLineString) {
            jsonInsertDatabaseUtil.inserDatabase(Weibo.class, jsonLine);
        }
        return "导入成功";
    }

    @RequestMapping("/findAllWeiboUser")
    public @ResponseBody List<WeiboUser> findAllWeiboUser() throws Exception {
        return weiboUserService.findAllWeiboUser();
    }

    @RequestMapping("/peopleAgeFeature")
    public String peopleAgeFeature(ModelMap map) throws Exception {
        List<Double> peopleAgeFeatureList = weiboUserService.peopleAgeFeature();
        List<WeiboUser> userList = weiboUserService.getUserSex();

        String underEighteenTitle = "18岁及以下";
        String eighteenToTwentyFourTitle = "18岁-24岁";
        String twentyFiveToTherityFourTitle = "25岁-34岁";
        String therityFiveToFortyFourTitle = "35岁-44岁";
        String fortyFiveAndMoreThanFortyFiveTitle = "45岁及以上";

        double underEighteenNumPersent = peopleAgeFeatureList.get(0);
        double eighteenToTwentyFourPersent = peopleAgeFeatureList.get(1);
        double twentyFiveToTherityFourPersent = peopleAgeFeatureList.get(2);
        double therityFiveToFortyFourPersent = peopleAgeFeatureList.get(3);
        double fortyFiveAndMoreThanFortyFivePersen = peopleAgeFeatureList.get(4);

        // 拼装数据
        String makeString = "value:" + underEighteenNumPersent + ",name:" + underEighteenTitle +
                ";value:" + eighteenToTwentyFourPersent + ",name:" + eighteenToTwentyFourTitle +
                ";value:" + twentyFiveToTherityFourPersent + ",name:" + twentyFiveToTherityFourTitle +
                ";value:" + therityFiveToFortyFourPersent + ",name:" + therityFiveToFortyFourTitle +
                ";value:" + fortyFiveAndMoreThanFortyFivePersen + ",name:" + fortyFiveAndMoreThanFortyFiveTitle;

        // 通用方法
        map.addAttribute("peopleAgeFeature", MakeEchartsJsonStringUtil.makeJsonArrayString(makeString));

        // 拼装标题
        String title = underEighteenTitle+","+eighteenToTwentyFourTitle+","+twentyFiveToTherityFourTitle+","+therityFiveToFortyFourTitle+","+fortyFiveAndMoreThanFortyFiveTitle;
        map.addAttribute("peopleAgeFeatureTitle", MakeEchartsJsonStringUtil.makeEchartTitle(title));

        System.out.println("评论人群特征分析");


        String woman = "女";
        String man = "男";
        Integer sexWoman = userList.get(0).getSexCount();
        Integer sexMan = userList.get(1).getSexCount();

        //拼装性别参数
        String makeSexString = "";
        makeSexString = "value:" + sexMan + ",name:" + man + ";value:" + sexWoman + ",name:" + woman;

        //通用参数
        map.addAttribute("userSex", MakeEchartsJsonStringUtil.makeJsonArrayString(makeSexString));
        System.out.println("性别参数："+MakeEchartsJsonStringUtil.makeJsonArrayString(makeSexString));

        return "echart/user";
    }



//页面1
    @RequestMapping("/weibo")
    public String getAllWeibo(ModelMap map){
        List<Weibo> weiboList = weiboService.getAllWeibo();
        map.addAttribute("weiboList", weiboList);
        return "templet/table_data_tables";
    }

//页面2
    @RequestMapping("/getWeiboCount")
    public  String getWeiboCount(ModelMap map){
        List<Weibo> weiboList = weiboService.getWeiboCount();

        String allWeibo = "总微博数";
        String grovernment0 = "中国警方在线";
        String grovernment1 = "人民日报";
        String grovernment2 = "平安北京";
        String grovernment3 = "最高人民检察院";
        String grovernment4 = "法制日报";
        String grovernment5 = "首都网警";

        //拼装数据
        //echart1
        String makeString = "";
        //echart2
        String makextitle = allWeibo;
        String makeString2 = "";//实际数量
        String makeString_2 = "";//总量-实际数量
        Integer allWeiboCount = 1386;//总量
        for (int i = 0; i < weiboList.size(); i++) {
            Integer weiboCount = weiboList.get(i).getWeiboCount();
            switch (i) {
                case 0: {
                    makeString += "value:" + weiboCount + ",name:" + grovernment0;
                    makeString2 = allWeiboCount + "," + weiboCount + ",";
                    makeString_2 = "0"  + "," + String.valueOf(allWeiboCount-weiboCount) + "," ;
                    makextitle = makextitle + "," + grovernment0 + ",";
                }
                break;
                case 1: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment1;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString_2 + String.valueOf(allWeiboCount-weiboCount) + "," ;
                    makextitle = makextitle + grovernment1 + ",";
                }
                break;
                case 2: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment2;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString_2 + String.valueOf(allWeiboCount-weiboCount) + "," ;
                    makextitle = makextitle + grovernment2 + ",";
                }
                break;
                case 3: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment3;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString_2 + String.valueOf(allWeiboCount-weiboCount) + "," ;
                    makextitle  = makextitle + grovernment3 + ",";
                }
                break;
                case 4: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment4;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString_2 + String.valueOf(allWeiboCount-weiboCount) + "," ;
                    makextitle = makextitle + grovernment4 + ",";
                }
                break;
                case 5: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment5;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString_2 + String.valueOf(allWeiboCount-weiboCount) + "," ;
                    makextitle = makextitle + grovernment5 ;
                }
                break;
            }
        }

        //通用方法
        map.addAttribute("weiboCount", MakeEchartsJsonStringUtil.makeJsonArrayString(makeString));
        map.addAttribute("weiboCount1", MakeEchartsJsonStringUtil.makeEchartTitle(makeString));
        map.addAttribute("weiboCount2", MakeEchartsJsonStringUtil.makeEchartTitle(makeString_2));
        map.addAttribute("weiboCount3", MakeEchartsJsonStringUtil.makeEchartTitle(makeString2));
        map.addAttribute("weiboCountx", MakeEchartsJsonStringUtil.makeEchartTitle(makextitle));

        //拼装坐标
        String title = grovernment0 +","+ grovernment1 +","+ grovernment2 +","+ grovernment3 +","+ grovernment4 +","+ grovernment5;
        map.addAttribute("weiboCountTitle", MakeEchartsJsonStringUtil.makeEchartTitle(title));

        // 想看json结果你不会debug的话可以打印出来一行结果在控制台看
        System.out.println("政府微博活跃度展示结果："+MakeEchartsJsonStringUtil.makeEchartTitle(makeString));
        System.out.println("政府微博活跃度展示结果："+MakeEchartsJsonStringUtil.makeEchartTitle(makeString2));
        System.out.println("政府微博活跃度展示结果总量-实际量："+MakeEchartsJsonStringUtil.makeEchartTitle(makeString_2));
        System.out.println("政府微博活跃度展横坐标："+MakeEchartsJsonStringUtil.makeEchartTitle(makextitle));
        map.addAttribute("weiboCountTitle", MakeEchartsJsonStringUtil.makeEchartTitle(title));
        return "echart/weiboSum";
    }




//页面3
    @RequestMapping("/getCommentCount")
    public String getCommentCount(ModelMap map)throws Exception {
        List<Weibo> weiboList = weiboService.getCommentCount();
        List<Weibo> weiboList2 = weiboService.getWeiboCount();

        String grovernment0 = "最高人民检察院";
        String grovernment1 = "平安北京";
        String grovernment2 = "法制日报";
        String grovernment3 = "首都网警";
        String grovernment4 = "人民日报";
        String grovernment5 = "中国警方在线";

        //拼装参数
        String weiboCommentX = "";//图1横坐标
        String weiboCommentY = "";//图1纵坐标
        String weiboCountString = "";//图2

        for (int i = 0; i < weiboList.size(); i++) {
            Integer weiboCommontCount = weiboList.get(i).getCommentCount();
            Integer weiboCount = weiboList2.get(i).getWeiboCount();
            switch (i) {
                case 0: {
                    weiboCommentX += weiboCommontCount;
                    weiboCommentY += grovernment0;
                    weiboCountString += weiboCount;
                }
                break;
                case 1: {
                    weiboCommentX += "," + weiboCommontCount;
                    weiboCommentY += "," + grovernment1;
                    weiboCountString += "," + weiboCount;
                }
                break;
                case 2: {
                    weiboCommentX += "," + weiboCommontCount;
                    weiboCommentY += "," + grovernment2;
                    weiboCountString += "," + weiboCount;
                }
                break;
                case 3: {
                    weiboCommentX += "," + weiboCommontCount;
                    weiboCommentY += "," + grovernment3;
                    weiboCountString += "," + weiboCount;
                }
                break;
                case 4: {
                    weiboCommentX += "," + weiboCommontCount;
                    weiboCommentY += "," + grovernment4;
                    weiboCountString += "," + weiboCount;
                }
                break;
                case 5: {
                    weiboCommentX += "," + weiboCommontCount;
                    weiboCommentY += "," + grovernment5;
                    weiboCountString += "," + weiboCount;
                }
                break;
            }
        }
        map.addAttribute("weiboCommentX", MakeEchartsJsonStringUtil.makeEchartTitle(weiboCommentX));
        map.addAttribute("weiboCommentY", MakeEchartsJsonStringUtil.makeEchartTitle(weiboCommentY));
        map.addAttribute("weiboCountString", MakeEchartsJsonStringUtil.makeEchartTitle(weiboCountString));

        //打印拼装数据查看

        System.out.println("微博评论聚集度展示 x轴："+MakeEchartsJsonStringUtil.makeEchartTitle(weiboCommentX));
        System.out.println("微博评论聚集度展示 y轴："+MakeEchartsJsonStringUtil.makeEchartTitle(weiboCommentY));
        System.out.println("微博评论聚集度展示 雷达图："+MakeEchartsJsonStringUtil.makeEchartTitle(weiboCountString));

        return "echart/commentSum";
    }



//页面6
    @RequestMapping("/getEmotionTendency")
    public String getEmotionTendency(ModelMap map) {
        List<WeiboComment> weiboCommentList = weiboCommentService.getclassifyEmotion();

        //拼装数据
        String negEmotion = "0:消极情绪";//0
        String neuEmotion = "1:中立情绪";//1
        String posEmotion = "2:积极情绪";//2

        String grovernment0 = "最高人民检察院";
        String grovernment1 = "平安北京";
        String grovernment2 = "法制日报";
        String grovernment3 = "首都网警";
        String grovernment4 = "人民日报";
        String grovernment5 = "中国警方在线";

        String makeGvmentE0 = "";
        String makeGvmentE1 = "";
        String makeGvmentE2 = "";
        String makeEmotionY = "";
        String makeEmotionTitle = "";

        makeEmotionTitle = negEmotion + "," + neuEmotion + "," + posEmotion;
        makeEmotionY = grovernment5 + "," + grovernment4 + "," + grovernment1 + "," + grovernment0 + "," + grovernment2 + "," + grovernment3;
        makeGvmentE0 = weiboCommentList.get(0).getEmotionnum() + "," +weiboCommentList.get(3).getEmotionnum() + ","
                + weiboCommentList.get(6).getEmotionnum() + "," + weiboCommentList.get(9).getEmotionnum() + ","
                + weiboCommentList.get(12).getEmotionnum() + "," +weiboCommentList.get(15).getEmotionnum();
        makeGvmentE1 = weiboCommentList.get(1).getEmotionnum() + "," +weiboCommentList.get(4).getEmotionnum() + ","
                + weiboCommentList.get(7).getEmotionnum() + "," + weiboCommentList.get(10).getEmotionnum() + ","
                + weiboCommentList.get(13).getEmotionnum() + "," +weiboCommentList.get(16).getEmotionnum();
        makeGvmentE2 = weiboCommentList.get(2).getEmotionnum() + "," +weiboCommentList.get(5).getEmotionnum() + ","
                + weiboCommentList.get(8).getEmotionnum() + "," + weiboCommentList.get(11).getEmotionnum() + ","
                + weiboCommentList.get(14).getEmotionnum() + "," +weiboCommentList.get(17).getEmotionnum();

        //通用方法
        map.addAttribute("makeEmotionTitle", MakeEchartsJsonStringUtil.makeEchartTitle(makeEmotionTitle));
        map.addAttribute("makeEmotionY", MakeEchartsJsonStringUtil.makeEchartTitle(makeEmotionY));
        map.addAttribute("makeGvmentE0", MakeEchartsJsonStringUtil.makeEchartTitle(makeGvmentE0));
        map.addAttribute("makeGvmentE1", MakeEchartsJsonStringUtil.makeEchartTitle(makeGvmentE1));
        map.addAttribute("makeGvmentE2", MakeEchartsJsonStringUtil.makeEchartTitle(makeGvmentE2));
        System.out.println("评论整体舆情倾向分析");

        // 想看json结果你不会debug的话可以打印出来一行结果在控制台看
        System.out.println("舆情title："+MakeEchartsJsonStringUtil.makeEchartTitle(makeEmotionTitle));
        System.out.println("舆情Y："+MakeEchartsJsonStringUtil.makeEchartTitle(makeEmotionY));
        System.out.println("舆情0："+MakeEchartsJsonStringUtil.makeEchartTitle(makeGvmentE0));
        System.out.println("舆情1："+MakeEchartsJsonStringUtil.makeEchartTitle(makeGvmentE1));
        System.out.println("舆情2："+MakeEchartsJsonStringUtil.makeEchartTitle(makeGvmentE2));
        return "echart/useremotion";
    }

/*页面6
    @RequestMapping("/getclassifyEmotion")
    List<WeiboComment> getclassifyEmption(){
        return weiboCommentService.getclassifyEmotion();
    }



//页面4
    @RequestMapping("getUserSex")
    List<WeiboUser> getUserSex() {
        return weiboUserService.getUserSex();
    }


*/



//页面5
    @RequestMapping("/userarea")
    public String outUserarea(ModelMap map){
        Map<String,Integer> zeroAndPeopleNumMap =  weiboUserService.getZeroAndPeopleNum();
        StringBuffer stringBuffer = new StringBuffer();
        for(Map.Entry entry:zeroAndPeopleNumMap.entrySet()){
            stringBuffer.append(";name:");
            stringBuffer.append(entry.getKey());
            stringBuffer.append(",value:");
            if("北京".equals(entry.getKey())) {
                stringBuffer.append((int) entry.getValue() / 5);
            }else {
                stringBuffer.append((int) entry.getValue() / 2.5);
            }
        }
        //通用方法
        map.addAttribute("zeroAndPeopleNum", MakeEchartsJsonStringUtil.makeJsonArrayString(
                stringBuffer.toString().substring(1,stringBuffer.toString().length())));

        return "echart/userarea";
    }

    @RequestMapping("/relationship")
    public String relationship(){
        return "echart/relationship";
    }

    @RequestMapping("/relationship2")
    public String relationship2(){
        return "echart/relationship2";
    }

    @RequestMapping("/relationship3")
    public String relationship3(ModelMap map) {
        List<WeiboComment> weiboCommentList = weiboCommentService.findAllWeiboComment();
        RelationshipEchartEntity relationshipEchartEntity = new RelationshipEchartEntity();
        Set<RelationshipEchartEntity.Data> dataSet = new HashSet<>();
        Set<RelationshipEchartEntity.Link> linkSet = new HashSet<>();

        // 微博圆圈大小
        int weiboCircleSize = 50;
        // 微博用户圆圈大小
        int weiboUserCircleSize = 35;
        // 微博圆圈颜色
        String weiboCircleColor = "#00ff00";
        // 微博用户圆圈颜色
        String weiboUserCirlceColor = "#3399FF";

        Integer[] weiboArray = new Integer[]{weiboCircleSize, weiboCircleSize};
        Integer[] weiboUserArray = new Integer[]{weiboUserCircleSize, weiboUserCircleSize};
        int i = 0;
        for (WeiboComment weiboComment : weiboCommentList) {
            if (weiboComment.getCommentUser() == null || weiboComment.getCommentWeiBoNumber() == null) {
                continue;
            }

            i++;
            if (i == 2000) {// 数据量太大显示效果不好，这里做截断处理
                break;
            }
            RelationshipEchartEntity.Data userData = new RelationshipEchartEntity.Data();
            userData.setName(String.valueOf(weiboComment.getCommentUser()));
            userData.setDraggable(true);
            userData.setSymbolSize(weiboUserArray);
            userData.setItemStyle(new RelationshipEchartEntity.ItemStrle(weiboUserCirlceColor));
            dataSet.add(userData);

            RelationshipEchartEntity.Data weiboData = new RelationshipEchartEntity.Data();
            weiboData.setName("微博"+String.valueOf(weiboComment.getCommentWeiBoNumber()));
            weiboData.setDraggable(true);
            weiboData.setSymbolSize(weiboArray);
            weiboData.setItemStyle(new RelationshipEchartEntity.ItemStrle(weiboCircleColor));
            dataSet.add(weiboData);

            RelationshipEchartEntity.Link link = new RelationshipEchartEntity.Link();
            link.setSource("微博"+String.valueOf(weiboComment.getCommentWeiBoNumber()));
            link.setTarget(String.valueOf(weiboComment.getCommentUser()));
            linkSet.add(link);
        }
        relationshipEchartEntity.setData(dataSet);
        relationshipEchartEntity.setLinks(linkSet);
        //String jsonString = "\"data\":[{\"name\":\"6829\",\"draggable\":true,\"symbolSize\":[10,10],\"itemStyle\":{\"color\":\"#000\"}},{\"name\":\"11011\",\"draggable\":true,\"symbolSize\":[10,10],\"itemStyle\":{\"color\":\"#000\"}},{\"name\":\"1689\",\"draggable\":true,\"symbolSize\":[10,10],\"itemStyle\":{\"color\":\"#000\"}},{\"name\":\"1688\",\"draggable\":true,\"symbolSize\":[10,10],\"itemStyle\":{\"color\":\"#000\"}},{\"name\":\"1687\",\"draggable\":true,\"symbolSize\":[10,10],\"itemStyle\":{\"color\":\"#000\"}}],\"links\":[{\"target\":\"6829\",\"source\":\"11011\",\"category\":\"\"},{\"target\":\"1689\",\"source\":\"11011\",\"category\":\"\"},{\"target\":\"1689\",\"source\":\"1688\",\"category\":\"\"},{\"target\":\"1689\",\"source\":\"1687\",\"category\":\"\"},{\"target\":\"1687\",\"source\":\"11011\",\"category\":\"\"}]";
        map.addAttribute("relationship3", MakeEchartsJsonStringUtil.makeRelationshipJsonString(relationshipEchartEntity));
        return "echart/relationship3";
    }
}
