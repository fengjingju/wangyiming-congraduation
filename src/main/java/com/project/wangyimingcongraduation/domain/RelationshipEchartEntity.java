package com.project.wangyimingcongraduation.domain;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/5/20 21:35
 */
@Data
public class RelationshipEchartEntity {
    @Expose
    private Set<Data> data;

    @Expose
    private Set<Link> links;

    @lombok.Data
    public static class Data {
        @Expose
        private String name;
        @Expose
        private Boolean draggable;
        @Expose
        private Integer[] symbolSize;
        @Expose
        private ItemStrle itemStyle;
    }

    @lombok.Data
    public static class Link {
        @Expose
        private String target;
        @Expose
        private String source;
        @Expose
        private String category = "";
    }

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ItemStrle {
        @Expose
        private String color;// 此处color不是双引号字符串，后期转换成jsonString再行替换
    }
}
