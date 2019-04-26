<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>政府新政务媒体效能展示</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body>
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">新媒体政务展示</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        <div class="logo-element">新媒体政务展示
                        </div>
                    </li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">总览</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="/index">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">主页</span>
                        </a>
                    </li>
                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">新媒体政务数据展示</span>
                    </li>
                    <!--mailbox-->
                    <!--新媒体政务数据展示-->
                    <li>
                        <a href="/weibo"><i class="fa fa-table"></i> <span class="nav-label">微博原文展示</span></a>
                        <a href="/weibosum"><i class="fa fa-edit"></i> <span class="nav-label">政府微博活跃度展示</span></a>
                        <a href="/weibocommentsum"><i class="fa fa-desktop"></i> <span class="nav-label">微博评论聚集度展示</span></a>
                    </li>
                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">新媒体政务效能展示</span>
                    </li>
                    <li>
                        <a href="/peopleAgeFeature"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">评论人群特征分析</span></a>
                        <a href="/userarea"><i class="fa fa-flask"></i> <span class="nav-label">评论人群分布分析</span></a>
                        <a href="/useremotion"><i class="fa fa-magic"></i> <span class="nav-label">评论舆情倾向分析</span></a>
                    </li>
                    </li>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <%--<!--右侧部分开始-->--%>
        <%--<div id="page-wrapper" class="gray-bg dashbard-1">--%>
            <%--<div class="row border-bottom">--%>
            <%--</div>--%>
            <%--<div class="row J_mainContent" id="content-main">--%>
                <%--<iframe id="J_iframe" width="100%" height="100%" src="index_v1.html?v=4.0" frameborder="0" data-id="index_v1.html" seamless></iframe>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<!--右侧部分结束-->--%>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="js/hAdmin.js?v=4.1.0"></script>
    <script type="text/javascript" src="js/index.js"></script>

    <!-- 第三方插件 -->
    <script src="js/plugins/pace/pace.min.js"></script>
</body>

</html>
