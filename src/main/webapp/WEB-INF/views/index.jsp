<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bootstrap Material Admin</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
</head>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>欢迎登录</h1>
                            </div>
                            <p>计算机学院系统管理系统</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" action="user/login" class="form-validate" id="loginFrom">
                                <div class="form-group">
                                    <label for="login-username"></label>
                                    <input id="login-username" type="text" name="username" required data-msg="请输入用户名"
                                                                               placeholder="用户名" value="admin" class="input-material">
                                </div>
                                <div class="form-group">
                                    <label for="login-password">

                                    </label><input id="login-password" type="password" name="password" required data-msg="请输入密码"
                                                                               placeholder="密码" class="input-material">
                                </div>
                                <button id="login" type="button" class="btn btn-primary">登录</button>
                                <div style="margin-top: -40px;">
                                    <div class="custom-control custom-checkbox " style="float: right;">
                                        <input type="checkbox" class="custom-control-input" id="check2">
                                        <label class="custom-control-label" for="check2">自动登录</label>
                                    </div>
                                    <div class="custom-control custom-checkbox " style="float: right;">
                                        <input type="checkbox" class="custom-control-input" id="check1">
                                        <label class="custom-control-label" for="check1">记住密码&nbsp;&nbsp;</label>
                                    </div>
                                </div>
                            </form>
                            <br/>
                            <small>没有账号?</small><a href="register.jsp" class="signup">&nbsp;注册</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- JavaScript files-->
<script src="/js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.validate.min.js"></script><!--表单验证-->
<!-- Main File-->
<script src="js/front.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script src="js/login.js"></script>

</body>
</html>
