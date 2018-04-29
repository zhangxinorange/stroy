<%@page import="com.zhangxin.mybatis.util.StroyContants"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user"
	value="<%=request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY)%>" />
<head>
<title>Forms</title>
<!-- Bootstrap -->
<link href="${ctx }/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="${ctx }/static/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="${ctx }/static/assets/styles.css" rel="stylesheet"
	media="screen">
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<script
	src="${ctx }/static/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
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
						<li class="active"><a href="#">文章内容管理</a></li>
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
					<li class="active"><a href="${ctx }/stroy/list"><i
							class="icon-chevron-right"></i> 小说文章管理</a></li>
					<li><a href="${ctx }/type/list"><i class="icon-chevron-right"></i>
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
								<form class="form-horizontal" action="${ctx }/stroy/save"
									method="post" enctype="multipart/form-data">
									<fieldset>
										<legend>小说管理</legend>
										<div class="control-group">
											<label class="control-label" for="focusedInput">文章标题</label>
											<div class="controls">
												<input class="input-xlarge focused" id="cTitle"
													name="cTitle" type="text" value="${content.cTitle }">
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="focusedInput">是否下载阅读</label> 
											<div class="controls">
												<input class="input-xlarge focused" 
													name="cAdmin" type="radio" value="0" checked="checked"/>否
													&nbsp;
												<input class="input-xlarge focused" 
													name="cAdmin" type="radio" value="1" />是
											</div>
											
										</div>


										<div class="control-group">
											<label class="control-label" for="focusedInput">文章作者</label>
											<div class="controls">
												<input class="input-xlarge focused" id="cAuthor"
													name="cAuthor" type="text" value="${content.cAuthor }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="focusedInput">文章简介</label>
											<div class="controls">
												<input class="input-xlarge focused" id="cDesc" name="cDesc"
													type="text" value="${content.cDesc }">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="focusedInput">下载消费金币</label>
											<div class="controls">
												<input class="input-xlarge focused" id="downScore" name="downScore"
													type="number" value="0">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="focusedInput">阅读消费金币</label>
											<div class="controls">
												<input class="input-xlarge focused" id="readScore" name="readScore"
													type="number" value="0">
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="multiSelect">文章类别</label>
											<div class="controls">
												<select multiple="multiple" id="multiSelect"
													class="chzn-select span4">
													<c:forEach items="${tList }" var="type">
														<option value="${type.tId }">${type.tName }</option>
													</c:forEach>
												</select> <input type="hidden" name="tType" id="tType">
												<p class="help-block">可选择多种类别</p>
											</div>

										</div>




										<div class="control-group">
											<label class="control-label" for="fileInput">标题图</label>
											<div class="controls">
												<input class="input-file uniform_on" id="fileInput"
													name="cPic" type="file">
											</div>
										</div>

										<!-- <div class="control-group">
											<label class="control-label" for="textarea2">文章内容</label>
											<div class="controls">
												<textarea class="input-xlarge textarea" placeholder="文章内容"
													id="cContent" name="cContent"
													style="width: 810px; height: 200px"></textarea>
											</div>
										</div> -->

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
	<footer> </footer>
	</div>
	<!--/.fluid-container-->
	<link href="${ctx }/static/vendors/uniform.default.css"
		rel="stylesheet" media="screen">
	<link href="${ctx }/static/vendors/chosen.min.css" rel="stylesheet"
		media="screen">
	<link href="${ctx }/static/vendors/wysiwyg/bootstrap-wysihtml5.css"
		rel="stylesheet" media="screen">

	<script src="${ctx }/static/vendors/jquery-1.9.1.js"></script>
	<script src="${ctx }/static/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/vendors/jquery.uniform.min.js"></script>
	<script src="${ctx }/static/vendors/chosen.jquery.min.js"></script>
	<script src="${ctx }/static/vendors/bootstrap-datepicker.js"></script>

	<script src="${ctx }/static/vendors/wysiwyg/wysihtml5-0.3.0.js"></script>
	<script src="${ctx }/static/vendors/wysiwyg/bootstrap-wysihtml5.js"></script>

	<script
		src="${ctx }/static/vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

	<script type="text/javascript"
		src="${ctx }/static/vendors/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="${ctx }/static/assets/form-validation.js"></script>

	<script src="${ctx }/static/assets/scripts.js"></script>
	<script>
		jQuery(document).ready(function() {
			FormValidation.init();
		});

		$(function() {
			$(".datepicker").datepicker();
			$(".uniform_on").uniform();
			$(".chzn-select").chosen();
			$('.textarea').wysihtml5();

			$('#rootwizard').bootstrapWizard(
					{
						onTabShow : function(tab, navigation, index) {
							var $total = navigation.find('li').length;
							var $current = index + 1;
							var $percent = ($current / $total) * 100;
							$('#rootwizard').find('.bar').css({
								width : $percent + '%'
							});
							// If it's the last tab then hide the last button and show the finish instead
							if ($current >= $total) {
								$('#rootwizard').find('.pager .next').hide();
								$('#rootwizard').find('.pager .finish').show();
								$('#rootwizard').find('.pager .finish')
										.removeClass('disabled');
							} else {
								$('#rootwizard').find('.pager .next').show();
								$('#rootwizard').find('.pager .finish').hide();
							}
						}
					});
			$('#rootwizard .finish').click(function() {
				alert('Finished!, Starting over!');
				$('#rootwizard').find("a[href*='tab1']").trigger('click');
			});

			$(".btn-primary").click(function() {
				var title = $("#cTitle").val();
				if (title == "") {
					alert("文章标题不能为空");
					return;
				}
				
				if(!isPositiveInteger($("#downScore").val()))
				{
					alert("下载金币请输入正整数");
					return;
				}
				if(!isPositiveInteger($("#readScore").val()))
				{
					alert("阅读金币请输入正整数");
					return;
				}
				
				var selected = [];
				$("#multiSelect").each(function() {
					selected.push($(this).val());
				});
				$("#tType").val(selected);

				$(".form-horizontal").submit();
			});
		});
		function isPositiveInteger(s){//是否为正整数
		     var re = /^[0-9]+$/ ;
		     return re.test(s)
		 }  
	</script>
</body>

</html>