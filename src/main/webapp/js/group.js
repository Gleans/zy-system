var layer = layui.layer
var _table = layui.table
var _form = layui.form
var isAdd = true
var tableData

$(function () {
    // 加载表格
    load_table()
})


//加载table
function load_table() {
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#demo'
            , id: 'userTest'
            , url: '../group/get'
            , parseData: function (res) { //res 即为原始返回的数据
                tableData = res.data.records
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": res.data.records //解析数据列表
                };
            }
            , page: true //开启分页
            , limit: 10
            , cols: [[ //表头
                { title: '选择', type: 'checkbox', align: 'center' }
                , { field: 'roleId', title: '用户组编号', sort: true }
                , { field: 'roleName', title: '用户组名称', sort: true }
                , { field: 'roleKey', title: '用户组代码', sort: true }
            ]]
        });

    });
}



// 添加或更新
_form.on('submit(userSubmit)', function (data) {

    console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
    console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
    console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
    var arr = new Array();
    $("input:checkbox[name='role']:checked").each(function (i) {
        arr[i] = $(this).val();
    });
    data.field.roleList = arr
    if (isAdd) {
        $.ajax({
            type: "post",
            url: "add",
            contentType: "application/json", //必须有  
            dataType: "json", //表示返回值类型，不必须  
            data: JSON.stringify(data.field),
            success: function (res) {
                if (res.code === 0) {
                    layer.msg('添加成功,等待跳转...', { icon: 6 });
                    load_table()
                    return true;
                } else {
                    layer.alert(res.msg, { icon: 2 });
                    return false;
                }
            }
        });
    } else {
        $.ajax({
            type: "post",
            url: "update",
            contentType: "application/json", //必须有  
            dataType: "json", //表示返回值类型，不必须  
            data: JSON.stringify(data.field),
            success: function (res) {
                if (res.code === 0) {
                    layer.msg('修改成功,等待跳转...', { icon: 6 });
                    load_table()
                    return true;
                } else {
                    layer.alert(res.msg, { icon: 2 });
                    return false;
                }
            }
        });
    }

});


function create_user() {
    console.log("創建用戶")
    isAdd = true
    $('input:checkbox').each(function () {
        $(this).attr('checked', false);
    });
    $('h3').text(function (n, cur_item) {
        return "新增用户";
    })
    layer.open({
        type: 1,
        offset: 'auto',
        anim: 0,
        maxWidth: 600,
        maxHeight: 600,
        top: 100,
        content: $('#create') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
    });
    _form.val("userForm", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
        "username": '', // "name": "value"
        "password": '' // "name": "value"
        , "sex": '男'
        , "phone": ''
        , "email": ''
    });
}

// 修改用户
function edit_user() {
    console.log("修改用戶")
    isAdd = false
    $('h3').text(function (n, cur_item) {
        return "修改用戶";
    })
    layui.use('table', function () {
        var table = layui.table;
        var checkStatus = table.checkStatus('userTest'); //idTest 即为基础参数 id 对应的值
        if (checkStatus.data.length !== 1) {
            layer.alert('请选择一行修改', {
                skin: 'layui-layer-molv' //样式类名
                , closeBtn: 0
            })
        } else {
            var user = checkStatus.data[0]
            _form.val("userForm", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                "username": user.username, // "name": "value"
                "password": user.password // "name": "value"
                , "sex": user.sex
                , "phone": user.phone
                , "email": user.email,
                "userId": user.userId
            });
            console.log(user.roleList)
            $('input:checkbox').each(function () {
                $(this).attr('checked', false);
            });
            if (user.roleList) {
                for (var i = 0; i < user.roleList.length; i++) {
                    console.log(user.roleList[i])
                    $("input:checkbox[value='" + user.roleList[i] + "']").attr("checked", true);
                }
            }

            _form.render();
            layer.open({
                type: 1,
                offset: 'auto',
                anim: 0,
                maxWidth: 600,
                maxHeight: 600,
                top: 100,
                content: $('#create') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            });

        }
    })
}

// 刷新
function refresh() {
    load_table()
}



// 删除用户
function del_user() {
    var checkStatus = _table.checkStatus('userTest');
    if (checkStatus.data.length !== 1) {
        layer.alert('请选择一行修改', {
            skin: 'layui-layer-molv' //样式类名
            , closeBtn: 0
        })
    } else {
        //询问框
        layer.confirm('确认删除吗?', {
            btn: ['确定', '取消'] //按钮
        }, function () {
            var user = checkStatus.data[0]
            console.log("删除用户", user.userId)
            $.get("del-user", { userId: user.userId }, function (res) {
                console.log(res)
                if (res.code === 0) {
                    layer.msg('删除成功！', { icon: 1 });
                    load_table()
                } else {
                    console.log(res.msg)
                    layer.msg('删除失败,联系管理员查看！', { icon: 2 });
                }
            });
        }, function () {
            layer.msg('已取消！');
        });
    }
}
