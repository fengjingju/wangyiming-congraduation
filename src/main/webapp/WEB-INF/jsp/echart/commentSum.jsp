<%--
  Created by IntelliJ IDEA.
  User: wangyiming
  Date: 2019-04-11
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<body style="display: flex; height: auto">

<div style="background-color: #1c2b36;width: 18%;">
    <%@ include file="/jsp/index.jsp" %>
</div>

<div class="wrapper wrapper-content animated fadeInRight" style="flex: 1">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>微博评论聚集度展示
                    </h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                        <br>
                        <br>
                        <br>
                        <br>
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
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartone'));
    var myChart2 = echarts.init(document.getElementById('charttwo'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '政府部门微博评论数统计',
            subtext: '统计分析政府部门微博所收到的评论的数量详情'
        },
        xAxis: {
            type: 'category',
            //data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            data:${weiboCommentY},
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            //data: [120, 200, 150, 80, 70, 110, 130],
            data:${weiboCommentX},
            type: 'bar'
        }]
    };
    myChart.setOption(option);

    var option2 = {
        title: {
            text: '微博数量与评论数量雷达图'
        },
        tooltip: {},
        legend: {
            data: ['预算分配（Allocated Budget）', '实际开销（Actual Spending）']
            //data: ['微博数量','评论数量']
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
                {name: '最高人民检察院', max: 5000},
                {name: '平安北京', max: 5000},
                {name: '法制日报', max: 5000},
                {name: '首都网警', max: 5000},
                {name: '人民日报', max: 5000},
                {name: '中国警方在线', max: 5000}
            ]
        },
        series: [{
            name: '微博 vs 评论 ',
            type: 'radar',
            // areaStyle: {normal: {}},
            data: [
                {
                    //value: [4300, 10000, 28000, 35000, 50000, 19000],
                    value: ${weiboCountString},
                    name: '微博数量 '
                },
                {
                    //value: [5000, 14000, 28000, 31000, 42000, 21000],
                    value: ${weiboCommentX},
                    name: '评论数量 '
                }
            ]
        }]
    };
    myChart2.setOption(option2);
</script>
</body>
</html>

