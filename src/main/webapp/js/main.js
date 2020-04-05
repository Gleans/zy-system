var PathURL = 'dean'
var sessionStorage = window.sessionStorage
var layer = layui.layer
var _element = layui.element

$(function () {
    // 加载userName
    // let userName = sessionStorage.getItem("userName")
    // if(userName){
    //     $("#user-name-label").innerText = userName
    // }else {
    //     $("#user-name-label").innerText = userName
    // }

    load_menus()
})

function load_menus() {
    let userId = $("#userId").val()
    // 左侧导航区域（可配合layui已有的垂直导航）
    $.get("../menu/get?userId=" + userId, function (res) {
        if (res && res.code === 0) {
            build_menus(res.data)
            _element.render('nav')
        } else {
            layer.alert("获取菜单失败,请联系管理员!", 2)
            // layer.alert("权限不足，请联系管理员", function () {
            //退出
            // window.location.href = "/logout"
            // })
        }
    })
}


function build_menus(data) {
    //回显选中
    var ul = $("<ul class='layui-nav layui-nav-tree side' lay-filter='nav' lay-shrink='all'></ul>")
    for (var i = 0; i < data.length; i++) {
        var node = data[i]
        let li = $("<li class='layui-nav-item' flag='" + node.id + "'></li>")
        var a = $("<a class='' href='javascript:;'>" + node.label + "</a>")
        li.append(a)
        //获取子节点
        var childArry = node.childMenus
        if (childArry.length > 0) {
            a.append("<span class='layui-nav-more'></span>")
            var dl = $("<dl class='layui-nav-child'></dl>")
            for (var y = 0; y < childArry.length; y++) {
                var dd = $("<dd><a href='" + childArry[y].path + "' target='mainFrame'>" + childArry[y].label + "</a></dd>")
                //判断选中状态
                if (childArry[y].path === PathURL) {
                    li.addClass("layui-nav-itemed")
                    dd.addClass("layui-this")
                }
                dl.append(dd)
            }
            li.append(dl)
        }
        ul.append(li)
    }
    $(".layui-side-scroll").append(ul)
}