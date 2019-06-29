<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>帖信息管理页面</title>

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
    $(function () {

        function changePageSize() {
            //获取下拉框的值
            var pageSize = $("#changePageSize").val();
            //向服务器发送请求，改变每页显示条数
            location.href = "${pageContext.request.contextPath}/manageReport/findAll.do?page=1&size="+pageSize;
        }

    });




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
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">帖子信息</li>
                    </ol>
                </div>
                <hr>

                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>帖子ID</th>
                        <th>举报内容</th>
                        <th>举报人</th>
                        <th>举报时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="report">
                        <tr>
                            <td width="5%">${report.articleId}</td>
                            <td width="10%" class="line-limit-length">${report.reportContent}</td>
                            <td width="10%" class="line-limit-length">${report.reportUserName}</td>
                            <td width="25%" class="line-limit-length">${report.reportTime}</td>
                            <td width="20%">
                                <a href="${pageContext.request.contextPath}/pageManage/findById.do?id=${article.articleId}"
                                   role="button" class="btn btn-info">相关帖子</a>
                                    <c:if test="${report.reportStatus==0}">
                                        <a href="/manageReport/updateReport1.do?id=${report.reportId}"
                                           role="button" class="btn btn-danger">屏蔽</a>
                                    </c:if>
                                    <c:if test="${report.reportStatus==1}">
                                        <a href="/manageReport/updateReport2.do?id=${report.reportId}"
                                           role="button" class="btn btn-info">驳回</a>
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
                        <select class="form-control" style="height: 25px;width: 15px" id="changePageSize" onchange="changePageSize()">
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
                            <a href="${pageContext.request.contextPath}/manageReport/findAll.do?page=1&size=${pageInfo.pageSize}"
                               aria-label="Previous">首页</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/manageReport/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                        </li>
                        <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                            <li>
                                <a href="${pageContext.request.contextPath}/manageReport/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="${pageContext.request.contextPath}/manageReport/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/manageReport/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
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
<%--<script>--%>
    <%--function showArticle(id) {--%>
        <%--$.ajax({--%>
            <%--url:'/article/findById.do?id='+id,--%>
            <%--type:'get',--%>
            <%--success:function (res) {--%>
                <%--$("#detail_title").val(res.title);--%>
                <%--$("#detail_content").val(res.content);--%>
                <%--$("#article_detail").modal();--%>
            <%--}--%>
        <%--})--%>
    <%--}--%>
<%--</script>--%>
</html>
