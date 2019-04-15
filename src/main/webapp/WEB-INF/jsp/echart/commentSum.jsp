<%--
  Created by IntelliJ IDEA.
  User: wangyiming
  Date: 2019-04-11
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>微博评论聚集度展示</title>

    <!--bootstrap-->
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <!--echart-->
    <script src="/incubator-echarts-4.2.1/dist/echarts.js"></script>
</head>

<body class="gray-bg">

<div style="float: left;height: 100%;background-color: #1c2b36;">
    <%@ include file="/jsp/index.jsp" %>
</div>

<div style="margin:15px;float:left;width: 80%;height: 100%;">
    <div style="background-color: #f6f8f8;height: 45px;border: 1px solid #dee5e7;padding: 12px;">
        <h5 style="font-family: 微软雅黑;color:#343434;font-size: 13px;">微博评论聚集度展示</h5>
    </div>
    <div style="background-color: white;padding: 25px;height: 100%;border-left: 1px solid #dee5e7;border-right: 1px solid #dee5e7;border-bottom: 1px solid #dee5e7;overflow: scroll;">
        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="chartone" style="width: 80%;height:70%;margin: 0 auto;"></div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div id="charttwo" style="width: 80%;height:70%;margin: 0 auto;"></div>
        <br>
        <br>
        <br>
        <br>
        <br>
    </div>
</div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartone'));
    var myChart2 = echarts.init(document.getElementById('charttwo'));
    // 指定图表的配置项和数据
    var option = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [120, 200, 150, 80, 70, 110, 130],
            type: 'bar'
        }]
    };
    myChart.setOption(option);

    var option2 = {
        title: {
            text: '基础雷达图'
        },
        tooltip: {},
        legend: {
            data: ['预算分配（Allocated Budget）', '实际开销（Actual Spending）']
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                { name: '销售（sales）', max: 6500},
                { name: '管理（Administration）', max: 16000},
                { name: '信息技术（Information Techology）', max: 30000},
                { name: '客服（Customer Support）', max: 38000},
                { name: '研发（Development）', max: 52000},
                { name: '市场（Marketing）', max: 25000}
            ]
        },
        series: [{
            name: '预算 vs 开销（Budget vs spending）',
            type: 'radar',
            // areaStyle: {normal: {}},
            data : [
                {
                    value : [4300, 10000, 28000, 35000, 50000, 19000],
                    name : '预算分配（Allocated Budget）'
                },
                {
                    value : [5000, 14000, 28000, 31000, 42000, 21000],
                    name : '实际开销（Actual Spending）'
                }
            ]
        }]
    };
    myChart2.setOption(option2);
</script>
</body>
</html>

