<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_info.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
    <style type="text/css">
        .hm-header-b { border-bottom: 1px solid #d9d9d9; }
    </style>
    <script>
        $(function () {
           /* $("#btn").click(function () {
                    $("#form").submit();

            })*/


            $("#oldPassword").blur(function () {
                var oldPassword= $("#oldPassword").val();
                var userName=$("#username").text();
               /* alert(oldPassword);
                alert(userName);*/

                $.post("${pageContext.request.contextPath}/user/findOldUserPass.do",{oldPassword:oldPassword,userName:userName},function (data) {
                      if(data=="true"){

                          $("#btn").removeAttr("disabled");
                      }else{
                          alert(data);
                        $("#btn").attr("disabled",true);

                }
                })
            })

        })

    </script>
</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<!--头部信息-->
<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="images/logo.png" alt=""/></a>
            </h1>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="index.do">首页</a><span>></span>修改密码
        </div>
    </div>
</div>


<!--修改密码-->
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img src="${pageContext.request.contextPath}/${user.picUrl}" alt=""/>
                    <div id="username" class="username">${user.userName}</div>
                </div>
                <ul class="user-info-l-b">
                    <li><i class="info-icon"></i>我的资料</li>
                    <li class="cur"><i class="safe-icon"></i>修改密码</li>
                </ul>
            </div>


            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li><a href="${pageContext.request.contextPath}/jsp/userInfo.jsp">个人信息</a></li>
                    <li class="cur"><a href="${pageContext.request.contextPath}/jsp/userPwd.jsp">修改密码</a></li>
                    <c:if test="${user.role==1}">
                        <li ><a href="${pageContext.request.contextPath}/jsp/userUpdate.jsp">申请高级用户</a></li>
                    </c:if>
                    <c:if test="${user.role==2}">
                        <li ><a href="${pageContext.request.contextPath}/jsp/userOpen.jsp">开辟新版块</a></li>
                    </c:if>
                </ul>
                <form id="form" action="${pageContext.request.contextPath}/user/updateUserPass.do" method="post">
                    <input type="hidden" name="userName" value="${user.userName}">
                  <ul class="bd">
                    <li class="clearfix">
                        <div class="info-l"><i class="red">*</i>旧密码：</div>
                        <div class="info-r"><input id="oldPassword" type="password" name="oldPassword" class="txt"/></div>
                    </li>
                    <li class="clearfix">
                        <div class="info-l"><i class="red">*</i>新密码：</div>
                        <div class="info-r"><input type="password" name="newPassword" class="txt"/></div>
                    </li>
                    <li class="clearfix">
                        <div class="info-l"></div>
                        <div class="info-r" id="btnDiv">
						  <input id="btn" type="submit" class="btn" value="保存" />
						  <span style="color:red;"></span>
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