<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@    taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 当前Context的根目录赋值给ctx --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>
    <title>管理系统</title>
    <link rel="stylesheet" href="../css/main/main.css">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <style>
        .fixed_e {
            margin-right: calc(70%);
            min-width: 180px;
        }
    </style>
</head>

<body>
<!-- 如定义一个墨绿背景色的导航 -->
<ul class="layui-nav header">
    <li class="layui-nav-item fixed_e">
        <a href="" style="text-underline-mode: node">计算机学院系统管理系统</a>
    </li>
    <li class="layui-nav-item" style="position: absolute;right: 250px; width: 100px;">
        <a href="">控制台<span class="layui-badge">9</span></a>
    </li>
    <li class="layui-nav-item" style="position: absolute;right: 150px;width: 100px;">
        <a href="">个人中心<span class="layui-badge-dot"></span></a>
    </li>
    <li class="layui-nav-item" style="position: absolute;right: 50px;width: 100px;">
        <a href="">我</a>
        <dl class="layui-nav-child">
            <dd><a href="javascript:">修改信息</a></dd>
            <dd><a href="javascript:">安全管理</a></dd>
            <dd><a href="javascript:">退了</a></dd>
        </dl>
    </li>
</ul>
<div class="container">
    <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree" lay-filter="nav" lay-shrink="all"></ul>
    </div>

    <div class="content">
        <!-- <iframe src="../system/index?userId=${userId}" name="mainFrame" frameborder="0" marginheight="0" -->
        <iframe src="user" name="mainFrame" frameborder="0" marginheight="0"
                marginwidth="0" height="100%" width="100%" padding="10"></iframe>
    </div>
</div>
<input type="hidden" id="userId" value="${userId}">

</body>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/layui/layui.all.js"></script>
<script type="text/javascript" src="${ctx}/js/main.js"></script>

</html>