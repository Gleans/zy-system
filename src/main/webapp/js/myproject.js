var _form = layui.form

layui.use(['jquery', 'layer', 'form', 'table', 'laydate'], function () {
    var $ = layui.$
    var layer = layui.layer
    var table = layui.table
    var laydate = layui.laydate
    var form = layui.form

    // 表格


    // 新增项目


//年月范围
    laydate.render({
        elem: '#test8'
        , type: 'month'
        , range: true
    })

//        动态生成select start
    function selajax() {
        $.ajax({
            url: '/listDeptinfoselect',
            type: 'post',
            dataType: 'json',
            success: function (result) {
                for (var i = 0; i < result.length; i++) {
                    var deptname = result[i]['deptname']
                    var deptnum = result[i]['deptnum']
                    $('#deptnum').append('<option value=' + deptnum + '>' + deptname + '</option>')
                    $('#deptnum2').append('<option value=' + deptnum + '>' + deptname + '</option>')
                    form.render()
                }
            }
        })
    }

    selajax()
    form.render()
//        动态生成select end
//            表格start
    var tabb = table.render({
        id: 'majorInfoTable',
        elem: '#majorInfoTable',
        url: '',
        parseData: function (res) { //res 即为原始返回的数据
            tableData = res.data.records
            return {
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.records //解析数据列表
            }
        },
        cols: [[ //标题栏
            {checkbox: true, LAY_CHECKED: false}
            , {field: 'projectId', align: 'center', title: '项目编号', width: 150}
            , {field: 'projectName', align: 'center', title: '项目名称', width: 150}
            , {field: 'projectSource', align: 'center', title: '项目来源', width: 150}
            , {field: 'startAndEndTime', align: 'center', title: '起止时间', width: 150}
            , {field: 'assumeRole', title: '承担角色', width: 150}
            , {field: 'itemCategory', title: '项目类别', width: 150}
        ]],
        page: true,
        limits: [10, 20, 30],
        limit: 10,
        height: 500
    })
//            表格end

//            添加start
    $('#add').on('click', function () {
        layer.open({
            type: 1 //Page层类型
            , area: ['500px', '600px', '100px']
            , title: '新增项目'
            , shade: 0.6 //遮罩透明度
            , maxmin: true //允许全屏最小化
            , anim: 1 //0-6的动画形式，-1不开启
            , content: $('#add_form')
            , success: function () {
                form.on('submit(addsubmit)', function (data) {
                    console.log(data)
                    return false;
                    $.ajax({
                        url: '/addMajorInfo',
                        type: 'post',
                        data: data.field,
                        dataType: 'json',
                        success: function (result) {
                            if (result.status === 0) {
                                layer.msg(result.msg, {time: 2000})
                                reset_form()
                                table.reload('majorInfoTable', {})
                                layer.closeAll('page')
                                form.render()
                            } else {
                                console.log(result.msg)
                                layer.msg("操作返回错误...", {
                                    time: 2000, //2s后自动关闭
                                })
                            }
                        }
                    })
                    return false;
                })
            },
            cancel: function () {
                reset_form()
            }
        })
    })
//      添加 end
//      修改 start
    $('#edit').on('click', function () {
        var checkStatus = table.checkStatus('majorInfoTable') //test即为基础参数id对应的值
        if (checkStatus.data.length == 0) {
            layer.msg("请选中一行进行编辑", {
                time: 2000, //2s后自动关闭
            })
        }
        if (checkStatus.data.length > 1) {
            layer.msg("请不要多选", {
                time: 2000, //2s后自动关闭
            })
        }
        if (checkStatus.data.length === 1) {
            layer.open({
                title: "修改专业",
                area: ['600px', '500px'],
                skin: 'layui-anim-upbit',
                type: 1,
                content: $('#editform'),
                success: function () {
                    var preprojectId = JSON.stringify((checkStatus.data)[0].projectId).replace(/["“”]/g, "")
                    $('#editmajortel').val(JSON.stringify((checkStatus.data)[0].majortel).replace(/["“”]/g, ""))
                    $('#editmajorassistant').val(JSON.stringify((checkStatus.data)[0].majorassistant).replace(/["“”]/g, ""))
                    $('#editmajorname').val(JSON.stringify((checkStatus.data)[0].majorname).replace(/["“”]/g, ""))
                    $('#editprojectId').val(JSON.stringify((checkStatus.data)[0].projectId).replace(/["“”]/g, ""))
                    $('#editdeptnum').val(JSON.stringify((checkStatus.data)[0].deptnum).replace(/["“”]/g, ""))
                    //                        select的渲染start
                    var optionsel = (checkStatus.data)[0]['deptname']
                    $("#deptnum2").find('option').each(function () {
                        if ($(this).html() === optionsel) {
                            $(this).prop("selected", true)
                        } else {
                            $(this).prop("selected", false)
                        }
                    })
//                        select的渲染end
                    form.render()
                    form.on('submit(editsubmit)', function (data) {
//                                (data.field)['preprojectId']=preprojectId;
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
                                    })
                                }
                                if (result.status === 200) {
                                    layer.msg(result.msg, {
                                        time: 2000, //2s后自动关闭
                                    })
                                    layer.closeAll('page')
                                }
                                table.reload('majorInfoTable', {})
                            }
                        })
                        return false
                    })
                }
            })
        }
    })
//      修改 end
//       删除 start
    $('#delete').on('click', function () {
        var checkStatus = table.checkStatus('majorInfoTable')
        if (checkStatus.data.length == 0) {
            layer.msg("请选中再删除", {
                time: 2000, //2s后自动关闭
            })
        } else {
            var nums = []
            for (var i = 0; i < checkStatus.data.length; i++) {
                nums.push((checkStatus.data)[i]['projectId'])
            }
            $.ajax({
                traditional: true,//传输组专用
                url: '/delMajorInfo',
                type: 'post',
                data: {"nums": nums},
                dataType: 'json',
                //                async: false,这个能把ajax变同步
                success: function (result) {
                    if (result.status === 400) {
                        layer.msg(result.msg, {
                            time: 2000, //2s后自动关闭
                        })
                    }
                    if (result.status === 200) {
                        layer.msg(result.msg, {
                            time: 2000, //2s后自动关闭
                        })
                        layer.closeAll('page')
                    }
                    table.reload('majorInfoTable', {})
                }
            })
        }
    })

    //       删除 end
    var EmptyForm = getobj()

    function getobj() {
        var elms = $("#add_form [name]") //formid 包含name属性的所有元素
        var obj = {}
        $.each(elms, function (i, item) {
            var name = $(item).attr("name")
            obj[name] = ""
        })
        return obj
    }

    // 重置表格数据
    function reset_form() {
        form.val("add_form", EmptyForm)
    }
})


