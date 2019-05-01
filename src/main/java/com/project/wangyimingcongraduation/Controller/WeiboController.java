package com.project.wangyimingcongraduation.Controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        return "echart/user";
    }

    @RequestMapping("/getWeiboCount")
    public  String getWeiboCount(ModelMap map){
        List<Weibo> weiboList = weiboService.getWeiboCount();

        //获取每个sender名称以及发博数量
        /*String[] weiboCount = new String[6];
        for (Weibo weibo : weiboList){
            int i = 0;
            weiboCount[i++] = String.valueOf(weibo.getWeiboCount());
        }*/

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
        String makeString2 = "";//实际数量
        String makeString_2 = "";//总量-实际数量
        Integer allWeiboCount = 0;//总量
        for (int i=0;i<weiboList.size();i++) {
            Integer weiboCount = weiboList.get(i).getWeiboCount();
            allWeiboCount = allWeiboCount + weiboCount;
        }
        for (int i = 0; i < weiboList.size(); i++) {
            Integer weiboCount = weiboList.get(i).getWeiboCount();
            switch (i) {
                case 0: {
                    makeString += "value:" + weiboCount + ",name:" + grovernment0;
                    makeString2 = allWeiboCount + ",";
                    makeString_2 = String.valueOf(allWeiboCount - allWeiboCount) + ",";
                }
                break;
                case 1: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment1;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString2 + String.valueOf(allWeiboCount - weiboCount) + ",";
                }
                break;
                case 2: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment2;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString2 + String.valueOf(allWeiboCount - weiboCount) + ",";
                }
                break;
                case 3: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment3;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString2 + String.valueOf(allWeiboCount - weiboCount) + ",";
                }
                break;
                case 4: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment4;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString2 + String.valueOf(allWeiboCount - weiboCount) + ",";
                }
                break;
                case 5: {
                    makeString += ";value:" + weiboCount + ",name:" + grovernment5;
                    makeString2 = makeString2 + weiboCount + ",";
                    makeString_2 = makeString2 + String.valueOf(allWeiboCount - weiboCount) + ",";
                }
                break;
            }
        }

        //通用方法
        map.addAttribute("weiboCount", MakeEchartsJsonStringUtil.makeJsonArrayString(makeString));
        System.out.println("政府微博活跃度展示");

        //拼装坐标
        String title = grovernment0 +","+ grovernment1 +","+ grovernment2 +","+ grovernment3 +","+ grovernment4 +","+ grovernment5;

        // 想看json结果你不会debug的话可以打印出来一行结果在控制台看
        System.out.println("政府微博活跃度展示结果："+MakeEchartsJsonStringUtil.makeJsonArrayString(makeString));
        map.addAttribute("weiboCountTitle", MakeEchartsJsonStringUtil.makeEchartTitle(title));
        return "echart/weiboSum";
    }


    @RequestMapping("getCommentCount")
    public List<Weibo> getCommentCount() {
        return weiboService.getCommentCount();
    }
    @RequestMapping("/getEmotionTendency")
    public String getEmotionTendency(ModelMap map) {
        List<WeiboComment> weiboCommentList = weiboCommentService.getEmotionTendency();

        //获取每种情感的整体数量
        /*String[] emotionNum = new String[3];
        for(WeiboComment weiboComment : weiboCommentList){
            int i = 0;
            emotionNum[i++] = String.valueOf(weiboComment.getCountnum());
        }*/

        String negEmotion = "消极情绪";
        String neuEmotion = "中立情绪";
        String posEmotion = "积极情绪";

        //拼装数据
        String makeString = "";
        for(int i=0;i<weiboCommentList.size();i++){
            Integer commentNum = weiboCommentList.get(i).getCountnum();
            switch (i){
                case 0:makeString+="value:" + commentNum+",name:" +negEmotion;break;
                case 1:makeString+=";value:" + commentNum+",name:" +neuEmotion;break;
                case 2:makeString+=";value:" + commentNum+",name:" +posEmotion;break;
            }
        }

        //通用方法
        map.addAttribute("commentEmotion", MakeEchartsJsonStringUtil.makeJsonArrayString(makeString));
        System.out.println("评论整体舆情倾向分析");

        // 想看json结果你不会debug的话可以打印出来一行结果在控制台看
        System.out.println("这就是那行结果："+MakeEchartsJsonStringUtil.makeJsonArrayString(makeString));

        return "echarts/useremotion";
    }

    @RequestMapping("getUserSex")
    List<WeiboUser> getUserSex() {
        return weiboUserService.getUserSex();
    }

    @RequestMapping("/getclassifyEmotion")
    List<WeiboComment> getclassifyEmption(){
        return weiboCommentService.getclassifyEmotion();
    }

    @RequestMapping("/weibo")
    public String getAllWeibo(ModelMap map){
        List<Weibo> weiboList = weiboService.getAllWeibo();
        map.addAttribute("weiboList", weiboList);
        return "templet/table_data_tables";
    }

}
