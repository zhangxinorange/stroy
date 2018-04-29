<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
　<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="member" value="${sessionScope.member}" />

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <title>交易记录</title>
    <link rel="stylesheet" href="${ctx }/static/fonts/iconfont.css"/>
    <link rel="stylesheet" href="${ctx }/static/css/style.min.css">
    <script src="${ctx }/static/js/loading.js"></script>
</head>
<body>
<header class="header flex flex-vc">
     <div class="l"><a href="${ctx }/user/index"><i class="icon-zhuye1"></i></a></div>
    <div class="c box-flex-1 text-center"><h1>悦享小说阅读网</h1></div>
    <div class="r text-right"><a href="${ctx }/user/login"><i class="icon-zhuye"></i></a></div>
</header>
<div class="pay-history">
    <div class="public-title section">
        <h2 class="none fz16rem">充值记录</h2>
    </div>
    <div class="pay-history-table section recharge-col mt1rem text-center" >
        <table>
            <thead>
                <tr>
                    <td><i class="icon-yuedu1"></i>充值时间</td>
                    <td><i class="icon-qianbao1"></i>充值金额</td>
                    <td><i class="icon-qianbao1"></i>充值金币</td>
                </tr>
            </thead>
            <tbody>
                <!-- <tr>
                    <td>我不是潘金莲</td>
                    <td>446</td>
                    <td><a href="javascript:;">删除</a></td>
                </tr> -->
                <c:forEach items="${rList }" var="chat" >
	                <tr>
	                    <td><fmt:formatDate value="${chat.createTime}" pattern="yyyy-MM-dd" /></td>
	                    <td>${chat.total/100 }元</td>
	                    <td>${chat.total }</td>
	                </tr>
                </c:forEach>
            </tbody>
        </table>
        <!--没有记录显示这个
        <div class="text-center book-null">
            <p>
                <i class="icon-shape"></i>
            </p>
            <p>暂无记录</p>
        </div>-->
    </div>
</div>
<!--底部-->
<footer class="footer" style="position:absolute;bottom:0;width:100%;">
    <ul class="none">
        <li class=""><a href="${ctx }/user/login">登录</a></li>
        <span class="fg">|</span>
        <li class=""><a href="${ctx }/user/index">首页</a></li>
        <span class="fg">|</span>
        <li class=""><a href="${ctx }/user/search">搜索</a></li>
    </ul>
</footer>
</body>
</html>