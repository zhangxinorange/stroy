<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
  <head>
    <title>管理员登录</title>
    <!-- Bootstrap -->
    <link href="${ctx }/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${ctx }/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="${ctx }/static/assets/styles.css" rel="stylesheet" media="screen">
     <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]
    <script src="${ctx }/static/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>-->
  </head>
  <body id="login" style="background: url('${ctx}/static/images/1@2x.jpg')top center no-repeat;">
    <div style="margin-top: 13%;">
		
      <form class="form-signin" method="post">
        <h2 class="form-signin-heading">后台登录</h2>
        <input type="text" name="mEmail" class="input-block-level" placeholder="登录邮箱">
        <input type="password" name="mPassword" class="input-block-level" placeholder="密码">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 记住密码
        </label>
        <button class="btn btn-large btn-block btn-primary" type="button">登录</button>
      </form>

    </div> <!-- /container -->
    <script src="${ctx }/static/vendors/jquery-1.9.1.min.js"></script>
    <script src="${ctx }/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$(".btn-primary").click(function(){
    			var name =$("input[name='mEmail']").val();
    			var pwd =$("input[name='mPassword']").val();
    			if(name==""||pwd=="")
   				{
   					alert("用户名或者密码不能为空");
   					return;
   				}
    			else
   				{
    				$.ajax({
    	                url: "${ctx}/admin/login",
    	                data: { mEmail: name ,mPassword:pwd},
    	                type: "post",
    	                dataType:'json',
    	                success: function (data) {
    	               		if(data.code==0)
    	            		{
    	               			window.location.href="${ctx}/stroy/list";
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
  </body>
</html>

