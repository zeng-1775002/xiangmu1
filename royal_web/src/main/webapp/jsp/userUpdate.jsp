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
      function load() {
          var userName=$("#username").text();
          $.post("${pageContext.request.contextPath}/article/selectArticle.do",{userName:userName},function (data) {
            $("#count").text(data);
            if(data<5){
               $("#btn").attr("disabled",true);
            }else{
                $("#btn").removeAttr("disabled");
            }
          })
      }

    </script>
    </head>
    <body onload="load()">


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<!--头部信息-->
<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="../images/logo.png" alt=""/></a>
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
                    <li ><i class="safe-icon"></i>修改密码</li>
                </ul>
            </div>


            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li><a href="${pageContext.request.contextPath}/jsp/userInfo.jsp">个人信息</a></li>
                    <li ><a href="${pageContext.request.contextPath}/jsp/userPwd.jsp">修改密码</a></li>
                    <c:if test="${user.role==1}">
                        <li class="cur"><a href="getUser.do?method=userPwd">申请高级用户</a></li>
                    </c:if>
                    <c:if test="${user.role==2}">
                        <li class="cur"><a href="getUser.do?method=userPwd">开辟新版块</a></li>
                    </c:if>
                </ul>
                <form action="${pageContext.request.contextPath}/user/updateUserRole.do" method="post">
                    <input type="hidden" name="userName" value="${user.userName}">
                  <ul class="bd">
                    <li class="clearfix">
                        <div style="font-size:20px"><i class="red">高级特权：</i>开辟新版块</div>
                    </li>
                      <br>
                    <li class="clearfix">
                        <div style="font-size:20px"><i class="red">申请条件：</i>发帖数 ≥5 </div>
                    </li>
                      <br>
                      <li class="clearfix">
                          <div style="font-size:20px"><i class="red">当前发帖数：</i><span id="count"></span></div>
                      </li>
                      <br>
                    <li class="clearfix">
                        <div class="info-l"></div>
                        <div class="info-r">
						  <input id="btn" type="submit" class="btn" value="申请"/>
						  <span style="color:red;">${str}</span>
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