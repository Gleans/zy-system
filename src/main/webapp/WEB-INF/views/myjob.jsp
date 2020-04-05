<%@page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>我的项目</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all">
</head>
<body>

<fieldset class="layui-elem-field site-demo-button"style="padding-left: 20px;margin-left: 20px;margin-right: 20px">
    <legend>我的项目</legend>
    <blockquote class="layui-elem-quote">
        <a href="javascript:;" class="layui-btn layui-btn-small" id="add">
            <i class="layui-icon">&#xe608;</i> 添加专业信息
        </a>
        <a href="#" class="layui-btn layui-btn-small" id="edit">
            <i class="layui-icon">&#xe642;</i> 修改专业信息
        </a>
        <a href="javascript:;" class="layui-btn layui-btn-small" id="delete" >
            <i class="layui-icon">&#xe640;</i> 删除专业信息
        </a>
    </blockquote>
</fieldset>


<%--表格start--%>
<fieldset class="layui-elem-field site-demo-button"style="padding-left: 20px;margin-left: 20px;margin-right: 20px">
    <legend>专业信息</legend>
    <table id="majorInfoTable" class="layui-table"  lay-filter="majorInfoTable" ></table>
</fieldset>
<%--表格end--%>

<%--表单添加模块start--%>
<form id="addform" class="layui-form" action="" lay-filter="addform" style="display: none;padding-left: 25px;padding-top: 25px">
    <fieldset class="layui-elem-field site-demo-button"style="padding-left: 20px;margin-left: 20px;margin-right: 20px">
        <legend>新增专业</legend>
        <div  class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">专业编号:</label>
            <div class="layui-input-block">
                <input name="majornum" id="majornum" lay-verify="required" autocomplete="off" placeholder="请输入专业编号" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">系院名称:</label>
            <div class="layui-input-block">
                <select  id="deptnum" name="deptnum" lay-verify="required" lay-filter="select">
                </select>
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">专业名称:</label>
            <div class="layui-input-block">
                <input name="majorname" id="majorname" lay-verify="required" autocomplete="off" placeholder="请输入专业名称" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">辅导员名称:</label>
            <div class="layui-input-block">
                <input name="majorassistant" id="majorassistant" lay-verify="required" autocomplete="off" placeholder="请输入辅导员名称" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">辅导员联系方式:</label>
            <div class="layui-input-block">
                <input name="majortel" id="majortel" lay-verify="required" autocomplete="off" placeholder="辅导员联系方式" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addsubmit">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        </div>
    </fieldset>
</form>
<%--表单添加模块end--%>


<%--表单修改模块start--%>
<form id="editform" class="layui-form" action="" lay-filter="editform" style="display: none;padding-left: 25px;padding-top: 25px">
    <fieldset class="layui-elem-field site-demo-button"style="padding-left: 20px;margin-left: 20px;margin-right: 20px">
        <legend>修改专业</legend>
        <div  class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">专业编号:</label>
            <div class="layui-input-block">
                <input name="majornum"  disabled id="editmajornum" lay-verify="required" autocomplete="off" placeholder="请输入专业编号" class="layui-input">
            </div>
        </div>
        <%--<div class="layui-form-item" style="width: 400px">--%>
        <%--<label class="layui-form-label">系院编号:</label>--%>
        <%--<div class="layui-input-block">--%>
        <%--<input name="deptnum"  disabled  id="editdeptnum" lay-verify="required" autocomplete="off" placeholder="请输入系院编号" class="layui-input">--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">系院名称:</label>
            <div class="layui-input-block">
                <select  id="deptnum2" name="deptnum" lay-verify="required" lay-filter="select">
                </select>
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">专业名称:</label>
            <div class="layui-input-block">
                <input name="majorname"  id="editmajorname" lay-verify="required" autocomplete="off" placeholder="请输入专业名称" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">辅导员名称:</label>
            <div class="layui-input-block">
                <input name="majorassistant" id="editmajorassistant" lay-verify="required" autocomplete="off" placeholder="请输入辅导员名称" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label">辅导员联系方式:</label>
            <div class="layui-input-block">
                <input name="majortel" id="editmajortel" lay-verify="required" autocomplete="off" placeholder="辅导员联系方式" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="editsubmit">修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        </div>
    </fieldset>
</form>
<%--表单修改模块end--%>

<script src="${ctx}/layui/layui.js"></script>
<script>
    layui.use(['jquery','layer','form','table'], function(){
        var $ = layui.$;
        var layer=layui.layer;
        var table=layui.table;
        var form=layui.form;
        //        动态生成select start
        function selajax() {
            $.ajax({
                url: '/listDeptinfoselect',
                type: 'post',
                dataType: 'json',
                success: function (result) {
                    for(var i=0;i<result.length;i++){
                        var deptname=result[i]['deptname'];
                        var deptnum=result[i]['deptnum'];
                        $('#deptnum').append('<option value='+ deptnum+'>'+deptname+'</option>');
                        $('#deptnum2').append('<option value='+ deptnum+'>'+deptname+'</option>');
                        form.render();
                    }
                } });
        }
        selajax();
        form.render();
//        动态生成select end
//            表格start
        var tabb=table.render({
            id:'majorInfoTable',
            elem: '#majorInfoTable',
            url: '/majorInfoListAll',
            cols:  [[ //标题栏
                {checkbox: true, LAY_CHECKED: false}
                ,{field: 'majornum', align:'center',title: '专业编号', width: 150}
                ,{field: 'deptname', align:'center',title: '院系编号', width: 150}
                ,{field: 'majorname',align:'center', title: '专业名称', width: 150}
                ,{field: 'majorassistant', align:'center',title: '辅导员名称', width: 150}
                ,{field: 'majortel', title: '辅导员电话', width: 150}
            ]],
            page:true,
            limits: [10,20,30],
            limit:10,
            height:800,
        });
//            表格end

//            添加start
        $('#add').on('click',function () {
            layer.open({
                title:"新增专业",
                area:['600px','500px'],
                skin:'layui-anim-upbit',
                type: 1,
                content: $('#addform'),
                success:function () {
                    form.on('submit(addsubmit)', function(data){
                        $.ajax({
                            url: '/addMajorInfo',
                            type: 'post',
                            data: data.field,
                            dataType: 'json',
                            //                async: false,这个能把ajax变同步
                            success: function (result) {
                                if(result.status===400){
                                    layer.msg(result.msg, {
                                        time: 2000, //2s后自动关闭
                                    });
                                }
                                if(result.status===200){
                                    layer.msg(result.msg, {
                                        time: 2000, //2s后自动关闭
                                    });
                                    $('#majornum').val("");
                                    $('#majorassistant').val("");
                                    $('#deptnum').val("");
                                    $('#majorname').val("");
                                    $('#majortel').val("");
                                    table.reload('majorInfoTable', {
                                    });
                                    layer.closeAll('page');
                                    form.render();
                                }
                            }
                        });
                        return false;
                    });
                },
                cancel: function(){
                }
            });
        })
//      添加 end
//      修改 start
        $('#edit').on('click',function () {
            var checkStatus = table.checkStatus('majorInfoTable'); //test即为基础参数id对应的值
            if(checkStatus.data.length==0){
                layer.msg("请选中一行进行编辑", {
                    time: 2000, //2s后自动关闭
                });
            }
            if(checkStatus.data.length>1){
                layer.msg("请不要多选", {
                    time: 2000, //2s后自动关闭
                });
            }
            if(checkStatus.data.length===1) {
                layer.open({
                    title: "修改专业",
                    area: ['600px', '500px'],
                    skin: 'layui-anim-upbit',
                    type: 1,
                    content: $('#editform'),
                    success: function () {
                        var premajornum=JSON.stringify((checkStatus.data)[0].majornum).replace(/["“”]/g, "");
                        $('#editmajortel').val(JSON.stringify((checkStatus.data)[0].majortel).replace(/["“”]/g, ""));
                        $('#editmajorassistant').val(JSON.stringify((checkStatus.data)[0].majorassistant).replace(/["“”]/g, ""));
                        $('#editmajorname').val(JSON.stringify((checkStatus.data)[0].majorname).replace(/["“”]/g, ""));
                        $('#editmajornum').val(JSON.stringify((checkStatus.data)[0].majornum).replace(/["“”]/g, ""));
                        $('#editdeptnum').val(JSON.stringify((checkStatus.data)[0].deptnum).replace(/["“”]/g, ""));
                        //                        select的渲染start
                        var optionsel=(checkStatus.data)[0]['deptname'];
                        $("#deptnum2").find('option').each(function(){
                            if($(this).html()===optionsel){
                                $(this).prop("selected",true);
                            }else {
                                $(this).prop("selected",false);
                            }
                        });
//                        select的渲染end
                        form.render();
                        form.on('submit(editsubmit)', function (data) {
//                                (data.field)['premajornum']=premajornum;
                            $.ajax({
                                url: '/editMajorInfo',
                                type: 'post',
                                data: data.field,
                                dataType: 'json',
                                //                async: false,这个能把ajax变同步
                                success: function (result) {
                                    if (result.status === 400) {
                                        layer.msg(result.msg, {
                                            time: 2000, //2s后自动关闭
                                        });
                                    }
                                    if (result.status === 200) {
                                        layer.msg(result.msg, {
                                            time: 2000, //2s后自动关闭
                                        });
                                        layer.closeAll('page');
                                    }
                                    table.reload('majorInfoTable', {
                                    });
                                }
                            });
                            return false;
                        });
                    }
                });
            }
        })
//      修改 end
//       删除 start
        $('#delete').on('click',function () {
            var checkStatus = table.checkStatus('majorInfoTable');
            if(checkStatus.data.length==0){
                layer.msg("请选中再删除", {
                    time: 2000, //2s后自动关闭
                });
            }else {
                var nums=[];
                for(var i=0;i<checkStatus.data.length;i++){
                    nums.push((checkStatus.data)[i]['majornum']);
                }
                $.ajax({
                    traditional: true,//传输组专用
                    url: '/delMajorInfo',
                    type: 'post',
                    data: {"nums":nums},
                    dataType: 'json',
                    //                async: false,这个能把ajax变同步
                    success: function (result) {
                        if (result.status === 400) {
                            layer.msg(result.msg, {
                                time: 2000, //2s后自动关闭
                            });
                        }
                        if (result.status === 200) {
                            layer.msg(result.msg, {
                                time: 2000, //2s后自动关闭
                            });
                            layer.closeAll('page');
                        }
                        table.reload('majorInfoTable', {
                        });
                    }
                });
            }
        })
//       删除 end
    });
</script>
</body>
</html>