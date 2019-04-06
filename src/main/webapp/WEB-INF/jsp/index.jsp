<%--
  Created by IntelliJ IDEA.
  User: fengjingju
  Date: 2019/4/6
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <!--bootstrap-->
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-8 col-md-offset-2 col-lg-4 col-lg-offset-4">
            <a href="#" class="thumbnail">
                <img src="/image/微信图片_20190331200824.jpg"
                     alt="通用的占位符缩略图">
            </a>
        </div>
    </div>
    <form action="/admin/login" method="post">
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2 col-lg-4 col-lg-offset-4">
                <input type="text" class="form-control" name="userName" placeholder="请输入用户名">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2 col-lg-4 col-lg-offset-4">
                <input type="password" class="form-control" name="password" placeholder="请输入用密码">
            </div>
        </div>
        <button class="btn btn-primary col-xs-12 col-md-8 col-md-offset-2 col-lg-4 col-lg-offset-4">登录
        </button>
    </form>
</div>


<form action="/admin/login" method="post">
    用户名：<input type="text" name="userName">
    密码：<input type="password" name="password">
    <button>登录</button>
    <span style="color: red;">${loginError}</span>
</form>

<form action="/admin/regist" method="post">
    用户名：<input type="text" name="userName">
    密码：<input type="password" name="password">
    <button>注册</button>
    <span style="color: red;">${registError}</span>
</form>

<form action="/echart" method="get">
    <button>查看echart</button>
</form>

</body>
</html>
