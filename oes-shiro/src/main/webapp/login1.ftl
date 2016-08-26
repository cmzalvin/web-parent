<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/oes/resources/css/login.css"/>
    <script type="text/javascript" src="/oes/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/oes/resources/js/MD5.js"></script>
</head>
<body>
<div id="topBackground" class="ccdiv1">
    <p class="topFont">保密考试系统</p>
</div>
<div id="bottomBackground" class="ccdiv2">
    <table id="loginTable" class="loginTable">
        <tr class="login-tab">
            <td id="secrecyTab" colspan="2" class="login-tab-item">用&nbsp;户&nbsp;登&nbsp;录</td>
        </tr>
        <tr>
            <td class="loginTableCell" colspan="2" id="showName1">用&nbsp;&nbsp;户:</td>
        </tr>
        <tr>
            <td class="loginTableCell" colspan="2">
                <div id="div1" class="input-field"><input type="text" id="field1" "></div>
            </td>
        </tr>
        <tr>
            <td class="loginTableCell" colspan="2" id="showName2">密&nbsp;&nbsp;码:</td>
        </tr>
        <tr>
            <td class="loginTableCell" colspan="2">
                <div id="div2" class="input-field"><input type="password" id="field2" "></div>
            </td>
        </tr>
        <tr>
            <td id="examCollegeTab" align="center"><img id='loadingImage' src='resources/icons/waiting.gif'
                                                        style="display: none" align="left"/> <a id="msg"></a></td>
            <td id="adminTab" class="loginButtonCell" align="center"><a href="javascript:;" class="confirm_btn"
                                                                        id="submitButton"><span>登录</span></a></td>
        </tr>
    </table>
</div>
<div id="topBackground" class="ccdiv3">
    <p class="copyright">电子政务实验室研制&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2016年3月</p>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $(".confirm_btn").click(function () {
            if (($.trim($("#field1").val()) == "") && ($.trim($("#field2").val()) == "")) {
                $("#msg").html("<font color=red>用户和密码不能为空</font>");
                return;
            }
            if ($.trim($("#field1").val()) == "") {
                $("#msg").html("<font color=red>用户不能为空</font>");
                return;
            }
            if ($.trim($("#field2").val()) == "") {
                $("#msg").html("<font color=red>密码不能为空</font>");
                return;
            }
            $("#loadingImage").css({"display": "block"});
            $("#msg").html("<font color=green>正在登陆</font>");
            setTimeout(loginAjax, 3000);
            function loginAjax() {
                var url;
                var params;
                url = "/oes/login.do";
                params = {
                    username: $.trim($("#field1").val()),
//                    password: hex_md5($.trim($("#field2").val()))
                    password: $.trim($("#field2").val())
                };
                $.ajax({
                    url: url,
                    dataType: "json",
                    data: params,
                    type: "post",
                    //contentType:"application/x-www-form-urlencoded",
                    success: function (data) {
                        alert("sucsess");
                        $("#msg").html("<font color=green>正在跳转,请稍等...</font>");
                    },
                    error: function (data) {
                        alert("error!!!!!");
                    }
                })
            }
        });
    });
</script>
</html>