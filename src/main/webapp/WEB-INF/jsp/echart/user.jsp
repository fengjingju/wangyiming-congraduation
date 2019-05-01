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

</head>
<body class="gray-bg">

<div style="float: left;height: 100%;background-color: #1c2b36;width: 18%">
    <%@ include file="/jsp/index.jsp" %>
</div>

<div class="wrapper wrapper-content animated fadeInRight" style="float:left;width: 82%">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>评论人群特征分析
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
            data: ${peopleAgeFeatureTitle}
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
                    {value: 60, name: '18岁及以下'},
                    {value: 40, name: '45岁及以上'},
                    {value: 20, name: '35岁-44岁'},
                    {value: 80, name: '25岁-34岁'},
                    {value: 100, name: '18岁-24岁'}
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

    option2 = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        },
        series: [
            {
                name:'访问来源',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:234, name:'联盟广告'},
                    {value:135, name:'视频广告'},
                    {value:1548, name:'搜索引擎'}
                ]
            }
        ]
    };
    myChart2.setOption(option2);
</script>
</body>
</html>
