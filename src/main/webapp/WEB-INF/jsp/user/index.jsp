<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="member" value="${sessionScope.member}" />
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no" />
<title>主页</title>
<link rel="stylesheet" href="${ctx}/static/fonts/iconfont.css" />
<link rel="stylesheet" href="${ctx}/static/css/style.min.css">
<link rel="stylesheet" href="${ctx}/static/css/swiper.min.css">
<script src="${ctx}/static/js/loading.js"></script>
</head>
<body>
	<header class="header flex flex-vc">
		<div class="l">
			<a href="${ctx }/user/index"><i class="icon-zhuye1"></i></a>
		</div>
		<div class="c box-flex-1 text-center">
			<h1>悦享小说阅读网</h1>
		</div>
		<div class="r text-right">
			<c:choose>
				<c:when test="${empty member }">
					<a href="${ctx}/user/login"><i class="icon-zhuye"></i></a>
				</c:when>
				<c:otherwise>
				<form id="forq" action="${ctx }/user/userCenter" method="post">
					<table>
						<tr>
						<td><a style="font-size: 1.3rem;" href="javascript:$('#forq').submit();">${member.mName }</a></td></tr>
						
						<tr>
						<td><a style="font-size: 0.8rem;"  href="javascript:loginOut();" >退出登录</a></td></tr>
					</table>
					</form>
				</c:otherwise>
			</c:choose>
		
		
			
		</div>
	</header>
	<!--导航-->
	<div class="banner" style="height: 20rem;">
		<div class="swiper-container">
			<!--banner图懒加载 data.src-->
			<div class="swiper-wrapper">
				<c:forEach items="${lunbo }" var="news">
					<div class="swiper-slide" style="text-align: center;">
					<%-- <a href="javascript:window.location.href='${ctx }/user/detail?cId=${content.cId }'; "><img data-src="${ctx}/${content.cPicStr}" alt=""
						class="img-bespread swiper-lazy" style="width: 100%;height: 30rem;"/></a>
					<div class="swiper-lazy-preloader"></div> --%>
					<a href="#">
					
						<div style="text-align: center;"><h2>${news.nTitle } </h2></div>
						<c:if test="${fn:length(news.nContent)>1000 }">  
								                         <div style="text-align: center;font-size: 0.7rem;">${news.nContent}</div>  
								                   </c:if>
						<c:if test="${fn:length(news.nContent)<1000 && fn:length(news.nContent)>500}">  
								                         <div style="text-align: center;font-size: 1.0rem;">${news.nContent}</div>  
								                   </c:if>		                   
								                   
								                    <c:if test="${fn:length(news.nContent)<=500 }">  
								                         <div style="text-align: center;font-size: 1.4rem;">${news.nContent}</div>
                  									 </c:if>
						
					</a>
				</div>
				
				</c:forEach>
				
				<%-- <div class="swiper-slide">
					<img data-src="${ctx}/static/images/banner.jpg" alt=""
						class="img-bespread swiper-lazy" />
					<div class="swiper-lazy-preloader"></div>
				</div>
				<div class="swiper-slide">
					<img data-src="${ctx}/static/images/banner.jpg" alt=""
						class="img-bespread swiper-lazy" />
					<div class="swiper-lazy-preloader"></div>
				</div> --%>
			</div>
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<div class="nav-box section">
		<nav>
			<ul class="flex flex-vc none text-center color-white fz16rem">
				<li class="box-flex-1"><a href="${ctx}/user/index">
						<div class="nav-div home">
							<i class="icon icon-zhuye1"></i>
						</div> <span>首页</span>
				</a></li>
				<%-- <li class="box-flex-1"><a href="${ctx}/static/recharge.html">
						<div class="nav-div cz fz22rem">
							</i>
						</div> <span>充值</span>
				</a></li> 
				<li class="box-flex-1"><a href="${ctx}/static/bookshelf.html">
						<div class="nav-div sj">
							<i class="icon icon-yuedu1"></i>
						</div> <span>书架</span>--%>
				</a></li>
				<li class="box-flex-1"><a href=" ${ctx}/user/search">
						<div class="nav-div sk">
							<i class="icon icon-chakan"><!-- <i class="icon icon-yuedu"> --></i>
						</div> <span>书库</span>
				</a></li>
				<li class="box-flex-1"><a href="${ctx}/user/login">
						<div class="nav-div ss">
							<i class="icon icon-yuedu1"></i>
						</div> <span>我的</span>
				</a></li>
			</ul>
		</nav>
	</div>
	<!--限时免费-->
	<div class="public-title section mt1rem">
		<h2 class="none fz16rem"><b style="text-align: left;">下载排行</b><b style="text-align: right;float:right"><a style="font-size: 0.8rem;" href="javascript: window.location.href='${ctx }/user/gotoDown'">查看更多</a></b></h2>
	</div>
	<div class="section apps-free recharge-col">
		<ul class="flex none text-center">
			<c:forEach items="${cList }" var="content">
				<li><a href="javascript:window.location.href='${ctx }/user/detail?cId=${content.cId }'; ">
						<figure>
							<img src="${ctx}/${content.cPicStr}" class="img-bespread" style="height: 650px;" 
								alt="loading">
							<c:if test="${content.cAdmin eq 0 }">
							<p>限时免费</p>
							</c:if>
							<c:if test="${content.cAdmin eq 1 }">
							<p>会员专享</p>
							</c:if>
						</figure>
						<h5 class="none">${content.cTitle}</h5>
				</a></li>
			
			</c:forEach>
		</ul>
	</div>
	
	<footer class="footer" >
		<ul class="none">
        <li class=""><a href="${ctx }/user/login">登录</a></li>
        <span class="fg">|</span>
        <li class=""><a href="${ctx }/user/index">首页</a></li>
        <span class="fg">|</span>
        <li class=""><a href="${ctx }/user/search">搜索</a></li>
    </ul>
	</footer>
</body>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/script.js"></script>
<script src="${ctx}/static/js/swiper.min.js"></script>
<script>
    
    $(function(){
        var mySwiper = new Swiper('.swiper-container', {
            autoplay: 4000,
            pagination: '.swiper-pagination',
            paginationClickable: true,
            lazyLoading : true,
        });
    })
    
    function loginOut()
    {
    	if(confirm("确认退出吗?"))
    	{
    		//window.location.href='${ctx}/user/loginout';
    		
    		$.ajax({
                url: "${ctx}/user/loginout",
                /* data: { userName: $("#userName").val() ,password:$("#password").val()}, */
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
