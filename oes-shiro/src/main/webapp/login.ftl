<!DOCTYPE html>
<html lang="en" class="login_page">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>在线考试系统</title>
    <!-- Bootstrap framework -->
    <link rel="stylesheet" href="admin/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="admin/css/bootstrap-responsive.min.css"/>
    <!-- theme color-->
    <link rel="stylesheet" href="admin/css/blue.css"/>
    <!-- tooltip -->
    <link rel="stylesheet" href="admin/css/jquery.qtip.min.css"/>
    <!-- main styles -->
    <link rel="stylesheet" href="admin/css/style.css"/>
    <!-- favicon -->
    <link rel="shortcut icon" href="favicon.ico"/>
</head>
<body>

<div class="login_box">
    <form method="post" id="login_form">
        <div class="top_b">欢迎登陆</div>
        <div class="cnt_b">
            <div class="formRow">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-user"></i> </span>
                    <input type="text" id="username" name="username" placeholder="Username" value=""/>
                </div>
            </div>
            <div class="formRow">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i> </span>
                    <input type="password" id="password" name="password" placeholder="Password" value=""/>
                </div>
            </div>
            <div class="formRow">
                <span class="add-on"><button type="button" id="showCode" class="btn btn-default btn-lg disabled">
                    fasdfaf
                </button></span>
                <button type="button" id="getCode" class="btn btn-default">获取验证码</button>
            </div>
            <div class="formRow">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-check"></i> </span>
                    <input type="text" id="validation" name="validation" maxlength="4" placeholder="Valiation"
                           value=""/>
                </div>
            </div>
            <div class="formRow clearfix">
                <label class="checkbox"><input type="checkbox" name="rememberMe" value="true"/> 下次自动登陆</label>
            </div>
        </div>
        <div class="btm_b clearfix">
            <div style="float:right">
                <button class="btn btn-inverse" type="reset">重置</button>
                <button class="btn btn-inverse" type="submit">登陆</button>
            </div>
            <span class="link_reg"><a href="#reg_form">没有注册？点击这里</a> </span>
        </div>
    </form>

    <form action="http://tzd-themes.com/gebo_admin/index.php?uid=1&page=dashboard"
          method="post" id="pass_form" style="display:none">
        <div class="top_b">不能登陆？</div>
        <div class="alert alert-info alert-login">请输入Email，您将会收到一个新的密码，登陆后请自行修改。</div>
        <div class="cnt_b">
            <div class="formRow clearfix">
                <div class="input-prepend">
                    <span class="add-on">@</span><input type="text" placeholder="Your email address"/>
                </div>
            </div>
        </div>
        <div class="btm_b tac">
            <button class="btn btn-inverse" type="submit">发送</button>
        </div>
    </form>

    <form action="registration.action" method="post" id="reg_form" style="display:none">
        <div class="top_b">欢迎新用户注册</div>
        <div class="alert alert-login">
            请查看相关的 <a data-toggle="modal" href="#terms">注册条款</a>.
        </div>
        <div id="terms" class="modal hide fade" style="display:none">
            <div class="modal-header">
                <a class="close" data-dismiss="modal">X</a>
                <h3>注册条款</h3>
            </div>
            <div class="modal-body">
                <p>注册的条款：啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p>
            </div>
            <div class="modal-footer">
                <a data-dismiss="modal" class="btn" href="#">关闭</a>
            </div>
        </div>
        <div class="cnt_b">

            <div class="formRow">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-user"></i> </span><input type="text" placeholder="Username"/>
                </div>
            </div>
            <div class="formRow">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i> </span><input type="text" placeholder="Password"/>
                </div>
            </div>
            <div class="formRow">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i> </span><input type="text"
                                                                                 placeholder="PasswordConfirm"/>
                </div>
            </div>
            <div class="formRow">
                <div class="input-prepend">
                    <span class="add-on">@</span><input type="text" placeholder="Your email address"/>
                </div>
                <small>Email地址必须是能收到邮件的地址，否则 您将收不到邮件</small>
            </div>

        </div>
        <div class="btm_b tac">
            <button class="btn btn-inverse" type="submit">注册</button>
        </div>
    </form>

    <div class="links_b links_btm clearfix">
        <span class="linkform"><a href="#pass_form">忘记密码？</a> </span>
        <span class="linkform" style="display:none"><a href="#login_form">返回</a></span>
    </div>

</div>

<script src="admin/js/jquery.min.js"></script>
<script src="admin/js/jquery.actual.min.js"></script>
<script src="admin/js/jquery.validate.js"></script>
<script src="admin/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        //* boxes animation
        form_wrapper = $('.login_box');
        function boxHeight() {
            form_wrapper.animate({
                marginTop: (-(form_wrapper.height() / 2) - 24)
            }, 400);
        }

        form_wrapper.css({
            marginTop: (-(form_wrapper.height() / 2) - 24)
        });
        $('.linkform a,.link_reg a').on('click', function (e) {
            var target = $(this).attr('href'), target_height = $(target).actual('height');
            $(form_wrapper).css({
                'height': form_wrapper.height()
            });
            $(form_wrapper.find('form:visible')).fadeOut(400, function () {
                form_wrapper.stop().animate({
                    height: target_height,
                    marginTop: (-(target_height / 2) - 24)
                }, 500, function () {
                    $(target).fadeIn(400);
                    $('.links_btm .linkform').toggle();
                    $(form_wrapper).css({'height': ''});
                });
            });
            e.preventDefault();
        });

        //* validation
        $('#login_form').validate({
            onkeyup: false,
            errorClass: 'error',
            validClass: 'valid',
            rules: {
                username: {
                    required: true,
                    minlength: 3
                },
                password: {
                    required: true,
                    minlength: 3
                },
                validation: {
                    required: true,
                    minlength: 4
                }
            },
            highlight: function (element) {
                $(element).closest('div').addClass("f_error");
                setTimeout(function () {
                    boxHeight()
                }, 200);
            },
            unhighlight: function (element) {
                $(element).closest('div').removeClass("f_error");
                setTimeout(function () {
                    boxHeight()
                }, 200)
            },
            errorPlacement: function (error, element) {
                $(element).closest('div').append(error);
            }
        });
        $('#login_form').bind('submit', function () {
            var showCode=$('#showCode').text().toLowerCase();
            var validation = $('#validation').val().toLowerCase();
            if (showCode!==validation) {
                alert('验证码不匹配!');
                return false;
            }
            var url;
            var params;
            url = "/oes/login.do";
            params = {
                username: $.trim($("#username").val()),
                password: $.trim($("#password").val())
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
            });
            return false;
        });
    });
    function createCode(len) {
        //创建需要的数据数组
        var seed = new Array('abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', '0123456789');
        var idx, i;
        var result = ''; //返回的结果变量
        for (i = 0; i < len; i++) //根据指定的长度
        {
            idx = Math.floor(Math.random() * 3); //获得随机数据的整数部分-获取一个随机整数
            result += seed[idx].substr(Math.floor(Math.random() * (seed[idx].length)), 1);//根据随机数获取数据中一个值
        }
        return result; //返回随机结果
    }
    $('#getCode').click(function () {
        var code = createCode(4);
        $('#showCode').text(code);
    });
</script>

<script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-32339645-1']);
    _gaq.push(['_trackPageview']);

    (function () {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl'
                        : 'http://www')
                + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();

    $(function () {
        $('#showCode').text(createCode(4));
    });
</script>

</body>
</html>
