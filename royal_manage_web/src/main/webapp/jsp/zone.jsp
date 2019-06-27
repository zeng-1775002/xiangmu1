<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>王者荣耀论坛管理系统</title>


</head>
<body>

<script type="text/javascript">
    function allow(){
        $("#apply").attr('action','${pageContext.request.contextPath}/zoneApply/applyAllow.do');
        $("#apply").submit();
    }

    function reject(){
        $("#apply").attr('action','${pageContext.request.contextPath}/zoneApply/applyReject.do');
        $("#apply").submit();
    }
</script>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>

    <!-- 中间部分-->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <div class="hrms_main_ad col-sm-10">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 style="text-align: center;">版块审核</h3>

                        <table border="3px" width="100%" style="text-align: center" >
                            <tr>
                                <td width="30px">ID</td>
                                <td>新增板块名称</td>
                                <td>用户名</td>
                                <td>申请原因</td>
                                <td>操作</td>

                            </tr>
                            <c:forEach items="${list}" var="list" varStatus="i">
                                <form id="apply"  method="post">
                                    <input type="hidden" name="zoneName" value="${list.zoneName}">
                                    <input type="hidden" name="userName" value="${list.userName}">
                                <tr>
                                    <td>${i.count}</td>
                                    <td width="150px" >${list.zoneName}</td>
                                    <td width="100px" >${list.userName}</td>
                                    <td >${list.reason}</td>
                                    <td width="120px">
                                        <input type="button"  value="允许"  onclick="allow()">
                                        <input type="button"  value="驳回"  onclick="reject()">
                                    </td>

                                </tr>
                                </form>
                            </c:forEach>
                        </table>

                </div>
            </div>
        </div>



    </div>
    <!-- 尾部 -->
    <%@ include file="./commom/foot.jsp"%>
</div>

</body>
</html>
