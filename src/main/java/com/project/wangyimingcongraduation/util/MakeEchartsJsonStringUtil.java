package com.project.wangyimingcongraduation.util;

import java.util.List;
import java.util.Map;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/13 17:52
 */
public class MakeEchartsJsonStringUtil {

    /**
     * 根据入参String返回echart需要json格式String
     *
     * @param fieldAndValueString  格式：field1:value1,field2:value2;field1:value1,field2:value2
     * @return 例：{value: 60, name: '访问'},{value: 40, name: '咨询'}
     */
    public static String makeJsonArrayString(String fieldAndValueString) {
        String[] fieldAndValueArray = fieldAndValueString.split(";");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        for (int i = 0; i < fieldAndValueArray.length; i++) {
            stringBuffer.append("{");
            String[] single = fieldAndValueArray[i].split(",");
            for (int j = 0; j < single.length; j++) {
                String[] fieldAndValue = single[j].split(":");
                stringBuffer.append(fieldAndValue[0]);
                stringBuffer.append(":");
                try {
                    int value = Integer.parseInt(fieldAndValue[1]);
                    stringBuffer.append(value);
                } catch (Exception e) {
                    if("true".equals(fieldAndValue[1])|| "false".equals(fieldAndValue[1])){
                        stringBuffer.append(fieldAndValue[1]);
                    }else {
                        try {
                            double value = Double.valueOf(fieldAndValue[1]);
                            stringBuffer.append(value);
                        } catch (Exception eee) {
                            stringBuffer.append("'");
                            stringBuffer.append(fieldAndValue[1]);
                            stringBuffer.append("'");
                        }
                    }
                }
                stringBuffer.append(",");
            }
            stringBuffer.append("}");
            stringBuffer.append(",");
        }
        stringBuffer.append("]");
        return stringBuffer.toString().replace(",},]", "}]");
    }

    /**
     * 根据入参String返回echart需要标题格式String
     *
     * @param titleString  格式：title1,title2,title3....(逗号分隔)
     * @return 例：['点击','访问','咨询','订单']
     */
    public static String makeEchartTitle(String titleString){
        String[] titleArray = titleString.split(",");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for(String title:titleArray){
            stringBuffer.append("'");
            stringBuffer.append(title);
            stringBuffer.append("'");
            stringBuffer.append(",");
        }
        stringBuffer.append("]");
        return stringBuffer.toString().replace(",]", "]");
    }
}