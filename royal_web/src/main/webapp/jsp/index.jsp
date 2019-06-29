<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index-new.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
</head>
<body >

<!-- 头部 -->
<jsp:include page="common/header.jsp"/>


<!-- 主体部分 -->
<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="hm-banner"></div>





        <!--头部，帖子统计，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="${pageContext.request.contextPath}/images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix"><h2 class="l">王者荣耀</h2></div>
                <p>
                    <span>今日帖子<strong id="timepost"></strong></span>
                    <span>/全部帖子<strong id="allpost"></strong></span>
                </p>
            </div>
            <div class="search-box l">
                <form action="${pageContext.request.contextPath}/article/search.do" method="post">
                    <input type="text" class="txt l" placeholder="请输入关键字" name="msg">
                    <input type="submit" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>




        <!-- 导航 -->
        <ul id="ul" class="hm-bbs-nav border-lrb clearfix">
            <li class="current">
                <a href="${pageContext.request.contextPath}/article/getArticle.do?zoneId=1"><em></em>综合交流区</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/article/getArticle.do?zoneId=2"><em></em>BUG反馈区</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/article/getArticle.do?zoneId=3"><em></em>新闻公告区</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/article/getArticle.do?zoneId=4"><em></em>活动专区</a>
            </li>

            <c:forEach items="${zoneList}" var="list" varStatus="i">
                <li>
                    <a href="${pageContext.request.contextPath}/article/getArticle.do?zoneId=${i.count+4}"><em></em>${list.zoneName}</a>
                </li>
            </c:forEach>
        </ul>




        <!-- 主体部分 -->
        <div class="hm-bbs-main border-lrb clearfix">
            <!-- 左侧列表 -->
            <div class="list-view l">
                <ul>
                    <c:forEach items="${pageInfo.list}" var="article">

                        <c:if test="${article.isTop==1}">
                            <li class="clearfix ding">
                                <div class="hm-index-title">

                                    <i class="set-to-top">顶</i>
                                    <a href="${pageContext.request.contextPath}/article/articleDetail.do?articleId=${article.articleId}">${article.title}</a>
                                </div>
                                <div class="hm-index-con">${article.content}</div>
                                <div class="hm-index-info l">
                                    <span class="article-username">${article.senderName}</span>
                                    <span class="post-time">${article.sendTime}</span>
                                </div>
                                <div class="hm-index-fun r">
                                    <span class="icon-like"><i></i>${article.upvoteCount}</span>
                                    <span class="icon-talk"><i></i>${article.replyCount}</span>
                                </div>
                            </li>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${pageInfo.list}" var="article">
                        <c:if test="${article.isTop==0}">
                            <li class="clearfix">
                                <div class="hm-index-title">
                                    <i class="set-to-top">顶</i>
                                    <a href="${pageContext.request.contextPath}/article/articleDetail.do?articleId=${article.articleId}">${article.title}</a>
                                </div>
                                <div class="hm-index-con">${article.content}</div>
                                <div class="hm-index-info l">
                                    <span class="article-username">${article.senderName}</span>
                                    <span class="post-time">${article.sendTime}</span>
                                </div>
                                <div class="hm-index-fun r">
                                    <span class="icon-like"><i></i>${article.upvoteCount}</span>
                                    <span class="icon-talk"><i></i>${article.replyCount}</span>
                                </div>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>




            <!-- 右侧侧边栏,在线用户 -->
            <div class="aside l">
                <div class="aside-box">
                    <h3 class="t">
                        <a href="javascript:;">在线用户(${users.size()})</a>
                    </h3>
                    <ul class="b clearfix">
                        <c:forEach items="${users}" var="user1" varStatus="vs">
                        <li>
                            <div><img src="../${user1.picUrl}" height="55"/> </div>
                            <p>${user1.userName}</p>
                        </li>
                        </c:forEach>

                    </ul>
                </div>
            </div>



        </div>
        <%--分页导航栏--%>
        <div class="box-footer">
            <div class="pull-left">
                <div class="form-group form-inline">
                    总共${pageInfo.pages}页,共${pageInfo.total}条数据。<%--每页--%>
                  <%--  <select class="form-control" style="height: 25px;width: 15px" id="changePageSize" onchange="changePageSize()">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>条--%>
                </div>
            </div>
          <%--  <div class="box-tools pull-right">
                <ul class="pagination">
                    <li>
                        <a href="${pageContext.request.contextPath}/article/getArticle.do?page=1&size=${pageInfo.pageSize}"
                           aria-label="Previous">首页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/article/getArticle.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                    </li>
                    <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                        <li>
                            <a href="${pageContext.request.contextPath}/article/getArticle.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                        </li>
                    </c:forEach>
                    <li>
                        <a href="${pageContext.request.contextPath}/article/getArticle.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/article/getArticle.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                           aria-label="Next">尾页</a>
                    </li>
                </ul>
            </div>
        </div>--%>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>



<!-- 右边发帖，回顶部 -->
<div class="fixedBar" id="j_fixedBar">
    <c:if test="${user!=null}">
        <a id="newTopicBtn" href="javascript:;" class="newTopic"><span></span>发帖</a>
    </c:if>
    <c:if test="${user==null}">
        <a  onclick="alert('请登录')" class="newTopic"><span></span>发帖</a>
    </c:if>
    <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
</div>

<!-- 发帖弹出框 -->
<form action="${pageContext.request.contextPath}/article/save.do" method="post">
    <div class="pop-box ft-box">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">主题帖</h4><span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_t">
                    <input type="text" id="title" name="title" placeholder="帖子标题"/>
                </div>
                <div class="win_bd_b">
                    <textarea id="content" name="content" placeholder="正文"></textarea>
                </div>
            </div>
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="submit" class="btn" value="发表"/>
                </div>
            </div>
        </div>
    </div>
</form>
<%--定义显示帖子数ajax--%>
<script>
    $(function () {
        $.post("${pageContext.request.contextPath}/article/findByTimePost.do",{},function (data) {
            $("#timepost").append(data)
        })
    });
    $(function () {
        $.post("${pageContext.request.contextPath}/article/findAllPost.do",{},function (data) {
            $("#allpost").append(data)
        })
    })
</script>

</body>
</html>