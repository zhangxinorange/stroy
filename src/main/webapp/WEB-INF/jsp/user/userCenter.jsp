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
    <title>用户中心</title>
    <link rel="stylesheet" href="${ctx }/static/fonts/iconfont.css"/>
    <link rel="stylesheet" href="${ctx }/static/css/style.min.css">
    <script src="${ctx }/static/js/loading.js"></script>
</head>
<body>
<header class="header flex flex-vc">
    <div class="l"><a href="${ctx }/user/index"><i class="icon-zhuye1"></i></a></div>
    <div class="c box-flex-1 text-center"><h1>个人中心</h1></div>
    <div class="r text-right">
    	<c:choose>
				<c:when test="${empty member }">
					<a href="${ctx}/user/login"><i class="icon-zhuye"></i></a>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
						<td>${member.mName }</td></tr>
						
						<tr>
						<td><a style="font-size: 0.8rem;"  href="javascript:loginOut();" >退出登录</a></td></tr>
					</table>
				</c:otherwise>
			</c:choose>
    </div>
</header>
<!--个人中心-->

<div class="section recharge-col mt1rem user-info-box flex">
    <div class="user-image">
        <img src="${ctx }/static/images/111.jpg" alt="">
    </div>
    <div class="user-info box-flex-1">
        <p class="none">${member.mName }</p>
        <p class="none">注册时间<fmt:formatDate value="${member.mCreateDate}" pattern="yyyy-MM-dd" /></p>
        <!-- <p class="none color-vip"><a href="#">成为vip用户</a></p> -->
    </div>
</div>
<div class="section mt1rem user-link">
    <ul class="none">
        <li class="recharge-col">
             <i class="icon icon-yuedu"></i>
             <span class="title">我的阅读</span>
             <c:forEach items="${rList}" var="content">
             	<a href="javascript:window.location.href='${ctx }/user/detail?cId=${content.cId}';"><b class="color-red read-gold">${content.cTitle}</b> </a>
             </c:forEach>
             <!-- <b class="color-red read-gold">红楼梦</b> 
             <b class="color-red read-gold">呐喊</b>  -->
            <!--  <i class="icon icon-xia pull-right"></i> -->
        </li>
        <li class="recharge-col">
                <i class="icon icon-qianbao1 fz18rem"></i>
                <span class="title">我的下载</span>
                <c:forEach items="${dList}" var="content">
             	<a href="javascript:window.location.href='${ctx }/user/detail?cId=${content.cId}';"><b class="color-red read-gold">${content.cTitle}</b> </a>
             </c:forEach>
        </li>
       
    </ul>
</div>
<!--底部-->
<a href="javascript:loginOut();" class="footer-logout btn btn-block btn-primary">退出</a>
</body>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/script.js"></script>
<script type="text/javascript">

function loginOut()
{
	if(confirm("确认退出吗?"))
	{
		
		$.ajax({
            url: "${ctx}/user/loginout",
            type: "post",
            dataType:'json',
            success: function (data) {
           		if(data.code==0)
        		{
           			window.location.href="${ctx}/user/index";
        		}
           		else
          		{
          			alert(data.msg);
          			location.reload();
          		}
           		
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
	}
}
</script>
</html>