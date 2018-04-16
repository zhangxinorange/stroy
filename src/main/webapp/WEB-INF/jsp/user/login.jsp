<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <title>主页</title>
    <link rel="stylesheet" href="${ctx }/static/fonts/iconfont.css"/>
    <link rel="stylesheet" href="${ctx }/static/css/style.min.css">
    <script src="${ctx }/static/js/loading.js"></script>
</head>
<body>
<header class="header flex flex-vc">
    <div class="l"><a href="${ctx }/user/index"><i class="icon-zhuye1"></i></a></div>
    <div class="c box-flex-1 text-center"><h1>小说在线</h1></div>
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
<!--登录-->
<div class="login-box" style="text-align: center;">
    <h4 class="text-center">
        <span>用户登录</span>
    </h4>
    <ul class="none flex text-center">
        <!-- <li>
            <a href="#">
                <div class="color-white"><i class="icon-weibo fz2rem"></i></div>
                <p>微博登录</p>
            </a>
        </li>
        <li>
            <a href="#">
                <div class="color-white"><i class="icon-baidu fz2rem"></i></div>
                <p>百度登录</p>
            </a>
        </li>
        <li>
            <a href="user-center.html">
                <div class="color-white"><i class="icon-qq fz2rem"></i></div>
                <p>QQ登录</p>
            </a>
        </li> -->
       <!--  <li>
        	<input type="text" name="userName"/><br/>
        </li>
        <li>
        	<input type="text" name="password"/><br/>
        </li>
        <li>
        	<input type="button" id="loginCoustmer"/>登录
        </li> -->
    </ul>
    <!-- <div class="search-box">
    <div class="search">
        <form action="#" method="get">
        <input type="text" class="inp inp-block search-inp" placeholder="请输入关键字">
        <input type="submit" class="btn search-btn" value="搜索">
        </form>
    </div>
</div> -->
    <div >
    	<div>
    	<input type="text" class="inp inp-block search-inp" placeholder="用户名" name="userName" id="userName"/> 
    	</br>   	
    	<input type="password" class="inp inp-block search-inp" placeholder="密码" name="password" id="password"/>
    	</br>    	
    	</div>
    	<div class="recharge-col">
        <input type="button" class="btn btn-primary btn-block go-to-recharge" id="loginCoustmer" title="登录" value="登录">
   		</div>
    </div>    
    
         <!-- <div>密码：<input type="password" name="password" id="password"/></div> -->
         <p class="text-center select-recharge-info">
         	<a id="regist">新用户注册</a>
    	</p>
		
</div>
</body>
<script src="${ctx }/static/js/jquery.min.js"></script>
<script src="${ctx }/static/js/script.js"></script>
<script>
	$(function(){
		$("#loginCoustmer").click(function(){
			if($("#userName").val()=="")
			{
				alert("用户名不能为空");
			}
			if($("#password").val()=="")
			{
				alert("密码不能为空");
			}
			else
			{
				$.ajax({
	                url: "${ctx}/user/login",
	                data: { userName: $("#userName").val() ,password:$("#password").val()},
	                type: "post",
	                dataType:'json',
	                success: function (data) {
	               		if(data.code==0)
	            		{
	               			if('${returnUrl}'!='')
               				{
	               				window.location.href='${ctx}/user/detail?cId=${returnUrl}';
               				}
	               			else
	               			{
	               				window.location.href="${ctx}/user/index";
	               			}
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
		});
		$("#regist").click(function(){
			window.location.href="${ctx}/user/regist";
		})
	});
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