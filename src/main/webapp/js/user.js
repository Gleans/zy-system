var layer = layui.layer
var _table = layui.table;
var _form = layui.form;


// 添加或更新
_form.on('submit(userSubmit)', function (data) {
    console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
    console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
    console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
    var arr = new Array();
    $("input:checkbox[name='role']:checked").each(function (i) {
        arr[i] = $(this).val();
    });
    data.form.roleList = arr

    $.ajax({
        type: "post",
        url: "add",
        contentType: "application/json", //必须有  
        dataType: "json", //表示返回值类型，不必须  
        data: JSON.stringify(data.form),
        success: function (res) {
            if (res.code === 0) {
                // layer.msg('添加成功,等待跳转...', { icon: 6 });
                console.log(res)
            } else {
                layer.alert(res.msg, { icon: 2 });
            }
        }
    });
    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。

});







function create_user() {
    console.log("創建用戶")
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



function addOrSave() {
    var data1 = form.val("userForm");

    console.log(data1)
}

function edit_user() {
    console.log("修改用戶")
    layui.use('table', function () {
        var table = layui.table;
        var checkStatus = table.checkStatus('userTest'); //idTest 即为基础参数 id 对应的值
        if (checkStatus.data.length !== 1) {
            layer.alert('请选择一行修改', {
                skin: 'layui-layer-molv' //样式类名
                , closeBtn: 0
            })
        } else {
            console.log(checkStatus.data) //获取选中行的数据
            console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
            console.log(checkStatus.isAll) //表格是否全选
            var user = checkStatus.data[0]
            _form.val("userForm", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                "username": user.username, // "name": "value"
                "password": user.password // "name": "value"
                , "sex": user.sex
                , "like[teacher]": true
                , "phone": user.phone
                , "email": user.email
            });
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

    // layer.open({
    //     type: 1,
    //     offset: 'auto',
    //     anim: 0,
    //     maxWidth: 600,
    //     maxHeight: 600,
    //     top: 100,
    //     content: $('#create') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
    // });
}

layui.use('table', function () {
    var table = layui.table;
    // $.get("user/get", function (res) {
    //     if (res.code === 0) {
    //         //执行一个laypage实例
    //         laypage.render({
    //             elem: 'demo' //注意，这里的 test1 是 ID，不用加 # 号
    //             , count: res.data.total //数据总数，从服务端得到
    //         });
    //     } else {
    //         layer.alert("获取角色失败", function () {
    //             //退出
    //             // window.location.href = "/logout";
    //         });
    //     }
    // });

    table.render({
        elem: '#demo'
        , id: 'userTest'
        , url: 'get'
        , parseData: function (res) { //res 即为原始返回的数据
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
            , { field: 'userId', title: '用户编号', sort: true }
            , { field: 'username', title: '用户名', sort: true }
            , { field: 'sex', title: '性别', sort: true }
            , { field: 'phone', title: '手机号' }
            , { field: 'email', title: '电子邮箱' }
        ]]
    });
    // //第一个实例
    // table.render({
    //     elem: '#demo'
    //     , height: 700
    //     , url: 'user/get' //数据接口

    // });

});