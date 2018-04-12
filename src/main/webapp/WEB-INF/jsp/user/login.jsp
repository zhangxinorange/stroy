<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
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
    <div class="l"><a href="../index.html"><i class="icon-zhuye1"></i></a></div>
    <div class="c box-flex-1 text-center"><h1>哈哈哈中午网</h1></div>
    <div class="r text-right"><a href="login.html"><i class="icon-zhuye"></i></a></div>
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
    <div>邮箱：<input type="text" name="userName" id="userName"/></div>
         <div>密码：<input type="password" name="password" id="password"/></div>
         <div style="margin-left: 50px;"><input type="button" id="loginCoustmer" title="登录" value="登录">&nbsp;<input type="button" id="regist" title="注册" value="注册"></div>
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
		});
	});
</script>
</html>