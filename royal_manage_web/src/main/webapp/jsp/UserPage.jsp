<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户信息管理页面</title>

</head>
<style type="text/css">
    html, body {
        overflow: auto;
        height: 100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }


</style>

<script>
    function changePageSize() {
        //获取下拉框的值
        var pageSize = $("#changePageSize").val();
        //向服务器发送请求，改变每页显示条数
        location.href = "${pageContext.request.contextPath}/user/findAll.do?page=1&size=" + pageSize;
    }

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="commom/head.jsp" %>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="commom/leftsidebar.jsp" %>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div>
                    <ol class="breadcrumb">
                        <li><a href="/user/findAll.do">用户管理</a></li>
                        <li class="active">用户信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form action="${pageContext.request.contextPath}/user/findByLike.do">
                            <div class="dropdown">
                                <b>用户名：</b>
                                <input type="text" class="dropdown-toggle seek " name="username">

                                <b>用户组:</b>
                                <select name="role">
                                    <option value="1">普通用户</option>
                                    <option value="2">高级用户</option>
                                    <option value="3">超级管理员</option>
                                </select>

                                <button type="submit" class="btn btn-primary btn-xs">查询</button>
                            </div>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>用户组</th>
                        <th>邮箱</th>
                        <th>是否禁言</th>
                        <th>最近登录时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="user">
                        <tr>
                            <td width="10%">${user.userName}</td>
                            <td width="15%" class="line-limit-length">${user.roleStr}</td>
                            <td width="20%" class="line-limit-length">${user.email}</td>
                            <td width="10%" class="line-limit-length">${user.talkStatusStr}</td>
                            <td width="20%" class="line-limit-length">${user.lastLoginTimeStr}</td>
                            <td width="5%">
                                <c:if test="${user.role==1}">
                                <a href="/user/upUserRole.do?id=${user.userId}&username=${user.userName}"
                                   role="button" class="btn btn-primary">升级</a>
                                </c:if>
                            </td>
                            <td width="5%">
                                <c:if test="${user.talkStatus==0}">
                                    <c:if test="${user.role!=3}">
                                        <a href="/user/forbiddenUser1.do?id=${user.userId}&username=${user.userName}"
                                           role="button" class="btn btn-danger">禁言</a>
                                    </c:if>
                                </c:if>
                                <c:if test="${user.talkStatus==1}">
                                    <a href="/user/forbiddenUser0.do?id=${user.userId}&username=${user.userName}"
                                       role="button" class="btn btn-info">恢复</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div><!-- /.hrms_dept_body -->

            <%--分页导航栏--%>
            <div class="box-footer">
                <div class="pull-left">
                    <div class="form-group form-inline">
                        总共${pageInfo.pages}页,共${pageInfo.total}条数据。每页
                        <select class="form-control" style="height: 25px;width: 15px" id="changePageSize"
                                onchange="changePageSize()">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>条
                    </div>
                </div>

                <div class="box-tools pull-right">
                    <ul class="pagination">
                        <li>
                            <a href="${pageContext.request.contextPath}/user/findAll.do?page=1&size=${pageInfo.pageSize}"
                               aria-label="Previous">首页</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                        </li>
                        <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                            <li>
                                <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                               aria-label="Next">尾页</a>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- /.box-footer-->


            <!-- 尾部信息-->
            <%@ include file="commom/foot.jsp" %>

        </div><!-- /.hrms_dept_container -->
        <!-- .box-footer-->


        <%--<%@ include file="ArticleAdd.jsp"%>--%>
        <%@ include file="ArticleUpdate.jsp" %>
</body>
</html>
