$(function () {
    /*错误class  form-control is-invalid
    正确class  form-control is-valid*/
    var flagName = false;
    var flagPas = false;
    var flagPass = false;
    /*验证用户名*/
    var name, passWord, passWords;
    $("#register-username").change(function () {
        name = $("#register-username").val();
        if (name.length < 2 || name.length > 10) {
            $("#register-username").removeClass("form-control is-valid")
            $("#register-username").addClass("form-control is-invalid");
            flagName = false;
        } else {
            $("#register-username").removeClass("form-control is-invalid")
            $("#register-username").addClass("form-control is-valid");
            flagName = true;
        }
    })
    /*验证密码*/
    $("#register-password").change(function () {
        passWord = $("#register-password").val();
        if (passWord.length < 6 || passWord.length > 18) {
            $("#register-password").removeClass("form-control is-valid")
            $("#register-password").addClass("form-control is-invalid");
            flagPas = false;
        } else {
            $("#register-password").removeClass("form-control is-invalid")
            $("#register-password").addClass("form-control is-valid");
            flagPas = true;
        }
    })
    /*验证确认密码*/
    $("#register-passwords").change(function () {
        passWords = $("#register-passwords").val();
        if ((passWord != passWords) || (passWords.length < 6 || passWords.length > 18)) {
            $("#register-passwords").removeClass("form-control is-valid")
            $("#register-passwords").addClass("form-control is-invalid");
            flagPass = false;
        } else {
            $("#register-passwords").removeClass("form-control is-invalid")
            $("#register-passwords").addClass("form-control is-valid");
            flagPass = true;
        }
    })


    $("#regbtn").click(function () {
        if (flagName && flagPas && flagPass) {
            let username = $("#register-username").val();
            let pwd = $("#register-passwords").val();
            var opt={
                    "username": username,
                    "password": pwd
            }
            $.ajax({
                type: "post",
                url: "user/add",
                // dataType : "json",
                contentType : "application/json;charset=utf-8",      //网上很多介绍加上此参数的，后来我发现不加入这个参数才会请求成功。
                data: JSON.stringify(opt),
                success: function (d) {
                    if(d.code === 0){
                        alert("注册成功！");
                    }else {
                        alert("注册失败！");
                    }
                }
            });
            // $.ajax({
            //     url: "",
            //     data: {
            //         name: $("#register-username"),
            //         password: $("#register-passwords")
            //     },
            //     method: "POST",
            //     dataType: "json",
            //     success: function (data) {
            //         // var  data = jQuery.parseJSON(data);  //dataType指明了返回数据为json类型，故不需要再反序列化
            //         console.log(data)
            //     }
            // });
        } else {
            if (!flagName) {
                $("#register-username").addClass("form-control is-invalid");
            }
            if (!flagPas) {
                $("#register-password").addClass("form-control is-invalid");
            }
            if (!flagPass) {
                $("#register-passwords").addClass("form-control is-invalid");
            }
        }
    })
})