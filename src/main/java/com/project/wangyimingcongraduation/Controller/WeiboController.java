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
    private WeiboService weiboService;
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
    public List<WeiboUser> findAllWeiboUser() throws Exception {
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

    @RequestMapping("getWeiboCount")
    public List<Weibo> getWeiboCount() {
        return weiboService.getWeiboCount();
    }

    @RequestMapping("getCommentCount")
    public List<Weibo> getCommentCount() {
        return weiboService.getCommentCount();
    }

    @RequestMapping("/getEmotionTendency")
    public String getEmotionTendency(ModelMap map) {
        List<WeiboComment> weiboCommentList = weiboCommentService.getEmotionTendency();

        //获取每种情感的整体数量
        String[] emotionNum = new String[3];
        for(WeiboComment weiboComment : weiboCommentList){
            int i = 0;
            emotionNum[i++] = String.valueOf(weiboComment.getCountnum());
        }

        String negEmotion = "消极情绪";
        String neuEmotion = "中立情绪";
        String posEmotion = "积极情绪";

        //String negNum = weiboCommentList.get(0).get;
        //String neuNum = weiboCommentList.get(1).get;
        //String neuNum = weiboCommentList.get(2).get;

        //拼装数据
        String makeString ="value:" + negEmotion + ",name:" + emotionNum[0] +
                ";value" + neuEmotion + ",name:" + emotionNum[1] +
                ";value" + posEmotion + ",name:" + emotionNum[2];
        //通用方法
        map.addAttribute("commentEmotion", MakeEchartsJsonStringUtil.makeJsonArrayString(makeString));
        System.out.println("评论整体舆情倾向分析");
        return "echarts/useremotion";
    }

    @RequestMapping("getUserSex")
    List<WeiboUser> getUserSex() {
        return weiboUserService.getUserSex();
    }

}
