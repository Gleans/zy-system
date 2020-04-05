<%@page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>我的项目</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all">
    <style>
    </style>
</head>
<body>

<fieldset class="layui-elem-field site-demo-button" style="padding-left: 20px;margin-left: 20px;margin-right: 20px">
    <legend>操作管理</legend>
    <blockquote class="layui-elem-quote">
        <a href="javascript:;" class="layui-btn layui-btn-small" id="add">
            <i class="layui-icon">&#xe608;</i> 添加项目
        </a>
        <a href="#" class="layui-btn layui-btn-small" id="edit">
            <i class="layui-icon">&#xe642;</i> 修改项目
        </a>
        <a href="javascript:;" class="layui-btn layui-btn-small" id="delete">
            <i class="layui-icon">&#xe640;</i> 删除项目
        </a>
    </blockquote>
</fieldset>

<%--表格start--%>
<fieldset class="layui-elem-field site-demo-button" style="padding-left: 20px;margin-left: 20px;margin-right: 20px">
    <legend>项目</legend>
    <table id="majorInfoTable" class="layui-table" lay-filter="majorInfoTable"></table>
</fieldset>
<%--表格end--%>

<%--表单添加模块start--%>
<form id="add_form" class="layui-form layui-layer1" action="" lay-filter="add_form"
      style="display: none;padding-left: 25px;padding-top: 25px;">
    <fieldset class="layui-elem-field site-demo-button" style="padding-left: 20px;margin-left: 20px;margin-right: 20px">
        <legend><span id="form_title"></span></legend>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">项目编号:</label>
            <div class="layui-input-block">
                <input name="projectId" id="projectId" lay-verify="required" autocomplete="off" placeholder="请输入项目编号"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">项目名称:</label>
            <div class="layui-input-block">
                <label for="projectName"></label><input name="projectName" id="projectName" lay-verify="required"
                                                        placeholder="请输入项目名称"
                                                        class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">项目来源:</label>
            <div class="layui-input-block">
                <input name="majorname" id="majorname" lay-verify="required" autocomplete="off" placeholder="请输入项目来源"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">起止时间:</label>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="dateTime" class="layui-input" id="test8" placeholder=" - ">
                </div>
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">承担角色:</label>
            <div class="layui-input-block">
                <input name="assumeRole" id="assumeRole" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">项目类别:</label>
            <div class="layui-input-block">
                <select name="itemCategory">
                    <option value="">请选择一个项目类别</option>
                    <option value="横向项目">横向项目</option>
                    <option value="纵向项目">纵向项目</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addsubmit">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </fieldset>
</form>
<%--表单添加模块end--%>

<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/layui/layui.js"></script>
<script src="${ctx}/js/myproject.js"></script>
</body>
</html>