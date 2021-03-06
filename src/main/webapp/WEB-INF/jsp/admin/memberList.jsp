<%@page import="com.zhangxin.mybatis.util.StroyContants"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
　<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user"
	value="<%=request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY)%>" />


<head>
<title>小说列表</title>
<!-- Bootstrap -->
<link href="${ctx }/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="${ctx }/static/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="${ctx }/static/assets/styles.css" rel="stylesheet"
	media="screen">
<link href="${ctx }/static/assets/DT_bootstrap.css" rel="stylesheet"
	media="screen">
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
						<li class="active"><a href="#">注册用户管理</a></li>
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
					<li ><a href="${ctx }/type/list"><i class="icon-chevron-right"></i>
							文章类别</a></li>
					<li class="active"><a href="${ctx }/admin/memberList"><i class="icon-chevron-right"></i>
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
			<div class="span9" id="content">

				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">注册用户列表</div>
						</div>
						<div class="block-content collapse in">
							<div class="span12">
								<div class="table-toolbar">
									<div class="btn-group">
									</div>
								</div>
								<table cellpadding="0" cellspacing="0" border="0"
									class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
											<th>用户名</th>
											<th>用户邮箱</th>
											<th>用户电话</th>
											<th>是否管理员</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${data.data}" var="down">
											<tr class="gradeA">
												<td>${down.cTitle }</td>
												<td>${down.mName}</td>
												<td><fmt:formatDate value="${down.dCreateDate}" pattern="yyyy-MM-dd" /></td>
											</tr>
										</c:forEach>
										 <c:forEach items="${pageInfo.list}" var="member">
                    <tr class="gradeA">
                   		<td>${member.mName}</td>
                        <td>${member.mEmail}</td>
                        <td>${member.mPhone}</td>
                        <td>
                        	<c:if test="${member.mType eq 0 }">是</c:if>
                        	<c:if test="${member.mType eq 1 }">否</c:if>
                        </td>
                        <td style="text-align:center;">
                            [<a href="javascript: deleteMember('${ member.mId}');">删除</a>]
                        </td>
                    </tr>
                </c:forEach>

									</tbody>
								</table>
								<div class="row">
									<div class="span6">
										<div class="dataTables_info" id="example_info"
											style="margin-left: 40px;">共有数据${pageInfo.total}条</div>
									</div>
									<div class="span6">
										<div class="dataTables_paginate paging_bootstrap pagination">
											<ul>
											<c:if test="${pageInfo.hasPreviousPage }">
												<li class="prev 
												"><a href="${ctx }/admin/memberList?page=${pageInfo.prePage}">← 上一页</a></li></c:if>
												<c:forEach items="${pageInfo.navigatepageNums}" var="nav">
													<c:if test="${nav == pageInfo.pageNum}">
							                           <%--  <td style="font-weight: bold;">${nav}</td> --%>
							                            <li class="active"><a href="#">${nav}</a></li>
							                        </c:if>
							                        <c:if test="${nav != pageInfo.pageNum}">
							                        	<li ><a href="${ctx }/admin/memberList?page=${nav}">${nav}</a></li>
							                        </c:if>
												</c:forEach>
												<c:if test="${pageInfo.hasNextPage }">
												<li class="next"><a href="${ctx }/admin/memberList?page=${pageInfo.nextPage}">下一页 → </a></li></c:if>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /block -->
				</div>

			</div>
		</div>
		<hr>
		<footer> </footer>
	</div>
	<!--/.fluid-container-->

	<script src="${ctx }/static/vendors/jquery-1.9.1.js"></script>
	<script src="${ctx }/static/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx }/static/assets/scripts.js"></script>
	<%-- 
	<script
		src="${ctx }/static/vendors/datatables/js/jquery.dataTables.min.js"></script>



	<script src="${ctx }/static/assets/DT_bootstrap.js"></script>--%>
	<script>
		$(function() {

		});
		function deleteContent(id)
		{
			confirm("删除会导致文章评论、阅读量、下载量清空，确认删除吗？")
			{
				window.location.href="${ctx}/stroy/delete?cId="+id;
			}
		}
		
		function deleteMember(id)
		{
			if(confirm("确定删除吗?"))
			{
				window.location.href="${pageContext.request.contextPath}/admin/delete?mId="+id;
			}
		}
	</script>
</body>

</html>