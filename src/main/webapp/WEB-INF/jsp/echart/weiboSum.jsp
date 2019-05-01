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

<div style="float: left;height: 100%;background-color: #1c2b36;width: 15%">
    <%@ include file="/jsp/index.jsp" %>
</div>
<div class="wrapper wrapper-content animated fadeInRight" style="float:left;width: 85%">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>基本表单
                        <small>简单登录表单示例</small>
                    </h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
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
        backgroundColor: '#ffffff',

        title: {
            text: 'Customized Pie',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#262626'
            }
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'访问来源',
                type:'pie',
                radius : '55%',
                center: ['50%', '50%'],
                data:[
                    {value:57, name:'直接访问'},
                    {value:5, name:'邮件营销'},
                    {value:64, name:'联盟广告'},
                    {value:212, name:'视频广告'},
                    {value:781, name:'搜索引擎'}
                ].sort(function (a, b) { return a.value - b.value; }),
                <%--data:${weiboCount}.sort(function (a, b) { return a.value - b.value; }),--%>
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            color: '#262626'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: '#262626'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#c23531',
                        shadowBlur: 200,
                        shadowColor: '#ffffff'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };

    myChart.setOption(option);

    var option2 =option = {
        title: {
            text: '政府新媒体微博数量组成（单位:条）',
            subtext: 'From ExcelHome',
            sublink: 'http://e.weibo.com/1341556070/AjQH99che'
        },
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            },
            formatter: function (params) {
                var tar = params[1];
                return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type : 'category',
            splitLine: {show:false},
            data : ['总费用','房租','水电费','交通费','伙食费','日用品数']
        },
        yAxis: {
            type : 'value'
        },
        series: [
            {
                name: '辅助',
                type: 'bar',
                stack:  '总量',
                itemStyle: {
                    normal: {
                        barBorderColor: 'rgba(0,0,0,0)',
                        color: 'rgba(0,0,0,0)'
                    },
                    emphasis: {
                        barBorderColor: 'rgba(0,0,0,0)',
                        color: 'rgba(0,0,0,0)'
                    }
                },
                data: [0, 1700, 1400, 1200, 300, 0]
            },
            {
                name: '生活费',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'inside'
                    }
                },
                data:[2900, 1200, 300, 200, 900, 300]
            }
        ]
    };

    myChart2.setOption(option2);
</script>
</body>
</html>
