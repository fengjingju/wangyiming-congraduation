<%--
  Created by IntelliJ IDEA.
  User: wangyiming
  Date: 2019-04-11
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>评论人群特征分析</title>

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
<%--<div class="col-sm-10" style="margin-top:15px;">--%>
    <%--<div class="ibox float-e-margins">--%>
        <%--<div class="ibox-title">--%>
            <%--<h5>基本表单</h5>--%>
        <%--</div>--%>
        <%--<div class="ibox-content">--%>
            <%--<!-- 为ECharts准备一个具备大小（宽高）的Dom -->--%>
            <%--<div id="main" style="width: 500px;height:400px;"></div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<div style="margin:15px;float:left;border-color:red;width: 85%;height: 100%;">
    <div style="background-color: #f6f8f8;height: 45px;border: 1px solid #dee5e7;padding: 12px;">
        <h5 style="font-family: 微软雅黑;color:#343434;font-size: 13px;">评论人群特征分析</h5>
    </div>
    <div style="background-color: white;padding: 25px;height: 100%;border-left: 1px solid #dee5e7;border-right: 1px solid #dee5e7;border-bottom: 1px solid #dee5e7;">
        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="main" style="width: 70%;height:70%;margin: 0 auto;"></div>
    </div>
</div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '评论人群特征分析',
            subtext: '评论人群特征分析'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c}%"
        },
        toolbox: {
            feature: {
                dataView: {readOnly: false},
                restore: {},
                saveAsImage: {}
            }
        },
        legend: {
            data: ['18岁及以下','点击','访问','咨询','订单']
        },
        series: [
            {
                name: '预期',
                type: 'funnel',
                left: '10%',
                width: '80%',
                label: {
                    normal: {
                        formatter: '{b}预期'
                    },
                    emphasis: {
                        position:'inside',
                        formatter: '{b}预期: {c}%'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                itemStyle: {
                    normal: {
                        opacity: 0.7
                    }
                },
                data: [
                    {value: 60, name: '访问'},
                    {value: 40, name: '咨询'},
                    {value: 20, name: '订单'},
                    {value: 80, name: '点击'},
                    {value: 100, name: '展现'}
                ]
            },
            {
                name: '实际',
                type: 'funnel',
                left: '10%',
                width: '80%',
                maxSize: '80%',
                label: {
                    normal: {
                        position: 'inside',
                        formatter: '{c}%',
                        textStyle: {
                            color: '#fff'
                        }
                    },
                    emphasis: {
                        position:'inside',
                        formatter: '{b}实际: {c}%'
                    }
                },
                itemStyle: {
                    normal: {
                        opacity: 0.5,
                        borderColor: '#fff',
                        borderWidth: 2
                    }
                },
                data: ${peopleAgeFeature}
            }
        ]
    };
    myChart.setOption(option);
</script>
</body>
</html>
