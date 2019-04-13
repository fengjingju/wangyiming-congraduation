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
    <title>微博原文展示</title>

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

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 500px;height:400px;float: left;margin-left: 300px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = option = {
        title: {
            text: '漏斗图',
            subtext: '纯属虚构'
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
            data: ['展现','点击','访问','咨询','订单']
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
                data: [
                    {value: 30, name: '访问'},
                    {value: 10, name: '咨询'},
                    {value: 5, name: '订单'},
                    {value: 50, name: '点击'},
                    {value: 80, name: '展现'}
                ]
            }
        ]
    };
    myChart.setOption(option);
</script>
</body>
</html>
