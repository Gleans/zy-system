<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>科研动态</title>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="author" content=""/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="stylesheet" type="text/css" href=""/>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <style type="text/css">
        body {
            background-color: #edeadf;
        }

        .layui-timeline-item::before, hr {
            background-color: black;
        }

        .title_p {
            font-size: 18px;
            font-family: arial, serif;
            color: #289789;
            font-weight: bold;
            padding-left: 20px;
        }

        .title_context {
            font-size: 14px;
            font-family: arial, serif;
            padding-left: 30px;
        }

        .layui-tab-content {
            padding-left: 20px!important;
            margin-top: 20px;
        }
    </style>
</head>

<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>科研动态</legend>
</fieldset>
<hr class="layui-bg-green">
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
    </ul>
    <div class="layui-tab-content"></div>
</div>
</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../layui/layui.all.js"></script>

<script>
    const element = layui.element
    const layer = layui.layer

    const data = [
        {
            context: "系统提醒测试1",
            title: "审批通过",
            time: "2020-04-05",
            typeId: 1,
            type: "系统提醒"
        },
        {
            context: "系统提醒测试2",
            title: "审批通过",
            time: "2020-04-05",
            typeId: 1,
            type: "系统提醒"
        },
        {
            context: "系统通知1...",
            title: "审批通过",
            time: "2020-04-03",
            typeId: 2,
            type: "系统通知"
        },
        {
            context: "用户消息测试...",
            title: "审批通过",
            time: "2020-04-03",
            typeId: 3,
            type: "用户消息"
        }
    ]

    $(function () {
        load_tab()
    });


    function string_connect_str(str) {
        this._str_ = [];
        this._str_.push(str)
    }

    string_connect_str.prototype.append = function (a) {
        this._str_.push(a);
    }
    string_connect_str.prototype.toString = function () {
        return this._str_.join("");
    }

    function load_tab() {
        const ul_default = "<ul class=\"layui-timeline\">"
        let ul_0 = new string_connect_str(ul_default)
        let ul_1 = new string_connect_str(ul_default);
        let ul_2 = new string_connect_str(ul_default);
        let ul_3 = new string_connect_str(ul_default);
        for (let i = 0; i < data.length; i++) {
            let item = data[i];
            let li = "<li class=\"layui-timeline-item\"><i class=\"layui-icon layui-timeline-axis\"></i>" +
                "<div class=\"layui-timeline-content layui-text\">" +
                "<div class=\"layui-timeline-title\"><p class='title_p'>" + item.type + " : " + item.title + "</p>" +
                "<span class='title_context'>" + item.context + "</span></div></div></li>";

            ul_0.append(li);

            // 系统提醒
            if (item.typeId === 1) {
                ul_1.append(li)
            }
            if (item.typeId === 2) {
                ul_2.append(li)
            }
            if (item.typeId === 3) {
                ul_3.append(li)
            }

        }
        ul_0.append("</ul>");
        ul_1.append("</ul>");
        ul_2.append("</ul>");
        ul_3.append("</ul>");
        element.tabAdd('docDemoTabBrief', {
            title: '全部'
            , content: ul_0.toString() //支持传入html
            , id: '0'
        });
        element.tabAdd('docDemoTabBrief', {
            title: '系统提醒'
            , content: ul_1.toString() //支持传入html
            , id: '1'
        });
        element.tabAdd('docDemoTabBrief', {
            title: '系统通知'
            , content: ul_2.toString()
            , id: '2'
        });
        element.tabAdd('docDemoTabBrief', {
            title: '用户消息'
            , content: ul_3.toString()
            , id: '3'
        });
        element.tabChange('docDemoTabBrief', '0');
    }
</script>

</html>