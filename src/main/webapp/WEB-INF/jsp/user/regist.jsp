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
        <span>用户注册</span>
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
    <form id="from1" action="${ctx }/user/regist" method="post">
    	<div>用户名：<input type="text" name="mName" id="mName"/></div>
    	<div>登录邮箱：<input type="text" name="mEmail" id="mEmail"/></div>
    	<div>手机号：<input type="text" name="mPhone" id="mPhone"/></div>
         <div>密码：<input type="password" name="mPassword" id="mPassword"/><input type="hidden" name="mType" id="mType" value="1"/></div>
         <input type="button" id="regist" title="注册" value="注册"></div>
	</form>
</div>
</body>
<script src="${ctx }/static/js/jquery.min.js"></script>
<script src="${ctx }/static/js/script.js"></script>
<script>
	$(function(){
		$("#regist").click(function(){
			//window.location.href="${ctx}/user/regist";
			if($("#mName").val()=="")
			{
				alert("用户名不能为空");
				return;
			}
			
			if($("#mEmail").val()=="")
			{
				alert("登录用邮箱不能为空");
				return;
			}
			if($("#mPassword").val()=="")
			{
				alert("登录密码不能为空");
				return;
			}
			
			$.ajax({
                url: "${ctx}/user/validate",
                 data: { eMail: $("#mEmail").val()},
                type: "post",
                dataType:'json',
                success: function (data) {
               		if(data.code==0)
            		{
               			//window.location.href="${ctx}/user/index";
               			confirm("注册成功");
               			$("#from1").submit();
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