<%@page import="com.zhangxin.mybatis.util.StroyContants"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value="<%=request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY) %>" />
<html>
    
    <head>
        <title>Forms</title>
        <!-- Bootstrap -->
        <link href="${ctx }/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/static/assets/styles.css" rel="stylesheet" media="screen">
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]
        <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>-->
    </head>
    
    <body>
        <div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">管理员 页面</a>
				<div class="nav-collapse collapse">
					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" role="button"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="icon-user"></i> ${user.mEmail } <i class="caret"></i>

						</a>
							<ul class="dropdown-menu">
								<!-- <li>
                                        <a tabindex="-1" href="#">Profile</a>
                                    </li> -->
								<li class="divider"></li>
								<li><a tabindex="-1" href="javascript: window.location.href='${ctx }/admin/loginOut'">退出</a></li>
							</ul></li>
					</ul>
					<ul class="nav">
						<li class="active"><a href="#">文章类别管理</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
				<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
					<li ><a href="${ctx }/stroy/list"><i
							class="icon-chevron-right"></i> 小说文章管理</a></li>
					<li class="active"><a href="${ctx }/type/list"><i class="icon-chevron-right"></i>
							文章类别</a></li>
					<li ><a href="${ctx }/admin/memberList"><i class="icon-chevron-right"></i>
							注册用户管理</a></li>
					<li ><a href="${ctx }/stroy/downList" ><i class="icon-chevron-right"></i>
							下载量查询</a></li>
					<li><a href="${ctx }/stroy/readList"><i class="icon-chevron-right"></i>
							阅读量查询</a></li>
					<li><a href="${ctx }/news/newsList"><i class="icon-chevron-right"></i>
							新闻通知管理</a></li>
					<li><a href="${ctx }/news/messageList"><i class="icon-chevron-right"></i>
							文章评论</a></li>
				</ul>
			</div>
			<!--/span-->
                <!--/span-->
                <div class="span9" id="content">
                      <!-- morris stacked chart -->
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">维护文章</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal" action="${ctx }/type/update" method="post">
                                      <fieldset>
                                        <legend>小说类别管理</legend>
                                        <div class="control-group">
                                          <label class="control-label" for="focusedInput">类别名称</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" id="tName" name="tName" type="text" value="${type.tName }">
                                            <input type="hidden" name="tId" value="${type.tId }"/>
                                          </div>
                                        </div>
                                         <div class="form-actions">
                                          <button type="button" class="btn btn-primary">保存</button>
                                          <button type="reset" class="btn">取消</button>
                                        </div>
                                      </fieldset>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>

			    </div>
			</div>
                     	<!-- /block -->
		    </div>
                     <!-- /validation -->


            <hr>
            <footer>
            </footer>
        <!--/.fluid-container-->
        <link href="${ctx }/static/vendors/uniform.default.css" rel="stylesheet" media="screen"/>

        <link href="${ctx }/static/vendors/wysiwyg/bootstrap-wysihtml5.css" rel="stylesheet" media="screen"/>

        <script src="${ctx }/static/vendors/jquery-1.9.1.js"></script>
        <script src="${ctx }/static/bootstrap/js/bootstrap.min.js"></script>
        <script src="${ctx }/static/vendors/jquery.uniform.min.js"></script>
        <script src="${ctx }/static/vendors/chosen.jquery.min.js"></script>
        <script src="${ctx }/static/vendors/bootstrap-datepicker.js"></script>

        <script src="${ctx }/static/vendors/wysiwyg/wysihtml5-0.3.0.js"></script>
        <script src="${ctx }/static/vendors/wysiwyg/bootstrap-wysihtml5.js"></script>

        <script src="${ctx }/static/vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

	<script type="text/javascript" src="${ctx }/static/vendors/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="${ctx }/static/assets/form-validation.js"></script>
        
	<script src="${ctx }/static/assets/scripts.js"></script>
        <script>

	jQuery(document).ready(function() {   
	   FormValidation.init();
	});
	

        $(function() {
            
            $(".btn-primary").click(function(){
            	var title =$("#cName").val();
            	if(title=="")
            		{
            		alert("文章标题不能为空");
            		return;
            		}
            	$(".form-horizontal").submit();
            });
        });
        </script>
    </body>

</html>