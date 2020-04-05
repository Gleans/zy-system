<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>用户组管理</title>

    <link rel="stylesheet" href="../layui/css/layui.css">
    <style>
        #create {
            padding: 10px;
        }
    </style>
</head>

<body>
<h1>用户管理</h1>
<br>
<hr/>
<button type="button" class="layui-btn layui-btn-normal" onclick="create_user()">新增</button>
<button type="button" class="layui-btn" onclick="edit_user()">修改</button>
<button type="button" class="layui-btn layui-btn-danger" onclick="del_user()">删除</button>
<button type="button" class="layui-btn layui-btn-primary" onclick="refresh()">刷新</button>
<table id="demo" lay-filter="test" lay-data="{id: 'userTest'}"></table>


</body>

<div id="create" style="display: none;">
    <form class="layui-form" lay-filter="userForm">
        <div style="text-align: center;">
            <h3>新增用户</h3>
        </div>
        <br>
        <hr />
        <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
        <div class="layui-form-item">
            <label class="layui-form-label">用戶名</label>
            <div class="layui-input-block">
                <input type="text" name="username" placeholder="请输入" autocomplete="off" class="layui-input"
                    lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" placeholder="请输入" autocomplete="off" class="layui-input"
                    lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input type="text" name="phone" placeholder="请输入" autocomplete="off" class="layui-input" />
                <!-- lay-verify="phone"> -->
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email" placeholder="请输入" autocomplete="off" class="layui-input" />
                <!-- lay-verify="email"> -->
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked>
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户组</label>
            <div class="layui-input-block">
                <c:forEach items="${menuList}" var="menu">
                    <input type="checkbox" name='role' value="${menu.roleId}" title='${menu.roleName}'>
                </c:forEach>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="userSubmit">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        <input type="hidden" name="userId"/>
    </form>
</div>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../layui/layui.all.js"></script>
<script type="text/javascript" src="../js/user.js"></script>

</html>