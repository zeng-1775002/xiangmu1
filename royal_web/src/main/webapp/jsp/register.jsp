<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛注册页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>


    <script type="text/javascript">
        function checkUserName() {
            //1.获取用户名
            var userName = $("#userName1").val();
            //2.定义正则
            var reg_userName =/^[a-zA-Z0-9_]{5,9}$/;
            //3.判断
            var flag = reg_userName.test(userName);
            if (flag) {
                $.post("${pageContext.request.contextPath}/user/findByName.do", {userName: userName}, function (data) {
                    if (data=="true") {
                        //用户名不存在
                        $("#userNameTips").text("用户名可用");

                    } else if(data=="false"){
                        //用户名存在
                        $("#userNameTips").text("用户名已存在");
                    }
                })
            } else {
                $("#userNameTips").text("用户名不符合格式");
            }
            return flag;
        }

        function checkUserPass() {

            var userPass = $("#userPass").val();

            var reg_userPass = /^[0-9]*$/;

            var flag = reg_userPass.test(userPass);

            if (flag) {
                $("#userPassTips").text("密码可用");
            } else {
                $("#userPassTips").text("密码不可用");
            }
            return flag;
        }

        function checkEmail() {

            var email = $("#email").val();

            var reg_email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

            var flag = reg_email.test(email);

            if (flag) {
                $("#emailTips").text("邮箱可用");
            } else {
                $("#emailTips").text("邮箱不可用");
            }
            return flag;
        }


        $(function () {

            $("#registerForm").submit(function () {
                return checkUserName() && checkUserPass() && checkEmail();
            });

        })


    </script>

</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp"/>


<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="${pageContext.request.contextPath}"><img src="images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="submit" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="index.do">首页</a><span>></span>注册页面
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="reg-box">
            <h2>用户注册<span>（红色型号代表必填）</span></h2>
            <div class="reg-info">
                <form action="${pageContext.request.contextPath}/user/register.do" method="post" id="registerForm">
                    <ul>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 用户名：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="userName1" name="userName" class="txt" value=""
                                       onblur="checkUserName()"/>
                            </div>
                            <span class="tips" id="userNameTips">用户名必须是由英文、数字、下划线组成</span>
                        </li>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 密&nbsp;&nbsp;&nbsp;码：
                            </div>
                            <div class="reg-c">
                                <input type="passwordt" id="userPass" name="userPass" class="txt" value=""
                                       onblur="checkUserPass()"/>
                            </div>
                            <span class="tips" id="userPassTips">密码长度必须6~10位的英文或数字</span>
                        </li>
                        <li class="no-tips">
                            <div class="reg-l">&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱：</div>
                            <div class="reg-c">
                                <input type="text" id="email" name="email" class="txt" value=""
                                       onblur="checkEmail()"/>
                            </div>
                            <span class="tips" id="emailTips">请输入邮箱地址</span>
                        </li>
                        <li>
                            <div class="reg-l"></div>
                            <div class="reg-c">
                                <input type="submit" class="submit-btn" value="注册" id="buttonForm"/><br/>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>


</body>
</html>