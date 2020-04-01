var PathURL = 'user'

$(function () {
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    var userId = $("#userId").val()
    console.log(userId)
    layui.use('element', function () {
        var element = layui.element;
        // 左侧导航区域（可配合layui已有的垂直导航）
        $.get("../menu/get?userId=" + userId, function (data) {
            if (data != null) {
                getMenus(data.data);
                element.render('nav');
            } else {
                layer.alert("权限不足，请联系管理员", function () {
                    //退出
                    window.location.href = "/logout";
                });
            }
        });
    });
});


var getMenus = function (data) {
    //回显选中
    var ul = $("<ul class='layui-nav layui-nav-tree side' lay-filter='nav' lay-shrink='all'></ul>");
    for (var i = 0; i < data.length; i++) {
        var node = data[i];
        if (i === 0) {
            var li = $("<li class='layui-nav-item layui-nav-itemed' flag='" + node.id + "'></li>");
        } else {
            var li = $("<li class='layui-nav-item' flag='" + node.id + "'></li>");
        }
        var a = $("<a class='' href='javascript:;'>" + node.label + "</a>");
        li.append(a);
        //获取子节点
        var childArry = node.childMenus;
        if (childArry.length > 0) {
            a.append("<span class='layui-nav-more'></span>");
            var dl = $("<dl class='layui-nav-child'></dl>");
            for (var y = 0; y < childArry.length; y++) {
                var dd = $("<dd><a href='" + childArry[y].path + "' target='mainFrame'>" + childArry[y].label + "</a></dd>");
                //判断选中状态
                if (childArry[y].path === PathURL) {
                    li.addClass("layui-nav-itemed");
                    dd.addClass("layui-this")
                }
                dl.append(dd);
            }
            li.append(dl);
        }
        ul.append(li);
    }
    $(".layui-side-scroll").append(ul);
}