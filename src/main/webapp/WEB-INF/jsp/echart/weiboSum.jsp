<%--
  Created by IntelliJ IDEA.
  User: wangyiming
  Date: 2019-04-09
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>政府微博活跃度展示</title>

    <!--bootstrap-->
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <!--echart-->
    <script src="/incubator-echarts-4.2.1/dist/echarts.js"></script>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">

<div style="float: left;height: 100%;background-color: #1c2b36;">
    <%@ include file="/jsp/index.jsp" %>
</div>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div class="col-sm-12">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>基本表单</h5>
        </div>
        <div class="ibox-content">
            <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
            <div id="main" style="width: 400px;height:300px;"></div>
        </div>
    </div>
</div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var builderJson = {
        "all": 10887,
        "charts": {
            "map": 3237,
            "lines": 2164,
            "bar": 7561,
            "line": 7778,
            "pie": 7355,
            "scatter": 2405,
            "candlestick": 1842,
            "radar": 2090,
            "heatmap": 1762,
            "treemap": 1593,
            "graph": 2060,
            "boxplot": 1537,
            "parallel": 1908,
            "gauge": 2107,
            "funnel": 1692,
            "sankey": 1568
        },
        "ie": 9743
    };

    var downloadJson = {
        "echarts.min.js": 17365,
        "echarts.simple.min.js": 4079,
        "echarts.common.min.js": 6929,
        "echarts.js": 14890
    };

    var themeJson = {
        "dark.js": 1594,
        "infographic.js": 925,
        "shine.js": 1608,
        "roma.js": 721,
        "macarons.js": 2179,
        "vintage.js": 1982
    };

    var waterMarkText = 'ECHARTS';

    var canvas = document.createElement('canvas');
    var ctx = canvas.getContext('2d');
    canvas.width = canvas.height = 100;
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    ctx.globalAlpha = 0.08;
    ctx.font = '20px Microsoft Yahei';
    ctx.translate(50, 50);
    ctx.rotate(-Math.PI / 4);
    ctx.fillText(waterMarkText, 0, 0);
    var option =option = {
        backgroundColor: {
            type: 'pattern',
            image: canvas,
            repeat: 'repeat'
        },
        tooltip: {},
        title: [{
            text: '在线构建',
            subtext: '总计 ' + builderJson.all,
            x: '25%',
            textAlign: 'center'
        }, {
            text: '各版本下载',
            subtext: '总计 ' + Object.keys(downloadJson).reduce(function (all, key) {
                return all + downloadJson[key];
            }, 0),
            x: '75%',
            textAlign: 'center'
        }],
        grid: [{
            top: 50,
            width: '50%',
            bottom: '45%',
            left: 10,
            containLabel: true
        }, {
            top: '55%',
            width: '50%',
            bottom: 0,
            left: 10,
            containLabel: true
        }],
        xAxis: [{
            type: 'value',
            max: builderJson.all,
            splitLine: {
                show: false
            }
        }],
        yAxis: [{
            type: 'category',
            data: Object.keys(builderJson.charts),
            axisLabel: {
                interval: 0,
                rotate: 30
            },
            splitLine: {
                show: false
            }
        }],
        series: [{
            type: 'bar',
            stack: 'chart',
            z: 3,
            label: {
                normal: {
                    position: 'right',
                    show: true
                }
            },
            data: Object.keys(builderJson.charts).map(function (key) {
                return builderJson.charts[key];
            })
        }, {
            type: 'bar',
            stack: 'chart',
            silent: true,
            itemStyle: {
                normal: {
                    color: '#eee'
                }
            },
            data: Object.keys(builderJson.charts).map(function (key) {
                return builderJson.all - builderJson.charts[key];
            })
        }, {
            type: 'pie',
            radius: [0, '30%'],
            center: ['75%', '25%'],
            data: Object.keys(downloadJson).map(function (key) {
                return {
                    name: key.replace('.js', ''),
                    value: downloadJson[key]
                }
            })
        }]
    };
    myChart.setOption(option);
</script>
</body>
</html>
