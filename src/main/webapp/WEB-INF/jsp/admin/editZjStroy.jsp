<%@page import="com.zhangxin.mybatis.util.StroyContants"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value="<%=request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY) %>" />
    
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
        <style type="text/css">
        	.controlsDel{
        		position:relative;
        	}
        	.controlsDelBtn{
        		position: absolute;
				right: 64px;
				top: 92px;
        	}
        	.controlsSaveBtn{
        		position: absolute;
				right: 64px;
				top: 30px;
        	}
        </style>
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
					<li ><a href="${ctx }/type/list"><i class="icon-chevron-right"></i>
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
                                <div class="muted pull-left">维护文章章节</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal" action="${ctx }/stroy/update" method="post" enctype="multipart/form-data" >
                                      <fieldset id="fileSet">
                                        <legend>小说管理</legend>
                                        <div class="control-group" style="border-bottom:1px dashed #ccc;padding-bottom:15px;">
                                          <label class="control-label" for="focusedInput" >文章标题</label>
                                          <div class="controls">
                                          <input class="input-xlarge focused" id="cId" name="cId" type="hidden" value="${content.cId }">
                                            <input class="input-xlarge focused" id="cTitle" name="cTitle" type="text" readonly="readonly" value="${content.cTitle }">
                                          </div>
                                        </div>
                                        
                                        <div id="detailDiv">
                                        	
                                        	
                                        </div>
                                        
                                       <%-- <div class="control-group">
                                          <label class="control-label" for="focusedInput">章节标题</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" id="title" name="title" type="text"  value="${content.cTitle }">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="textarea2">文章内容</label>
                                          <div class="controls controlsDel">
                                          	 <button type="button" class="btn btn-danger btn-lg controlsDelBtn " onclick="delete('1')">&times;</button>
                                          	  <button type="button" class="btn primary btn-lg controlsSaveBtn " onclick="save('1')">&times;</button>
                                            <textarea class="input-xlarge textarea" placeholder="文章内容" id="cContent" name="cContent" style="width: 810px; height: 200px" ></textarea>
                                          </div>
                                        </div>  --%>
                                        
                                         <div class="form-actions">
                                         <button type="button" class="btn btn-success">添加章节</button>
                                         <!--  <button type="button" class="btn btn-primary">保存</button> -->
                                          <button type="reset"  id="goback" class="btn">取消</button>
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
        </div>
        <!--/.fluid-container-->
        <link href="${ctx }/static/vendors/uniform.default.css" rel="stylesheet" media="screen">
		<link href="${ctx }/static/vendors/chosen.min.css" rel="stylesheet" media="screen">
        <link href="${ctx }/static/vendors/wysiwyg/bootstrap-wysihtml5.css" rel="stylesheet" media="screen">

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
            $(".datepicker").datepicker();
            $(".uniform_on").uniform();
            $(".chzn-select").chosen();
            $('.textarea').wysihtml5();

            $('#rootwizard').bootstrapWizard({onTabShow: function(tab, navigation, index) {
                var $total = navigation.find('li').length;
                var $current = index+1;
                var $percent = ($current/$total) * 100;
                $('#rootwizard').find('.bar').css({width:$percent+'%'});
                // If it's the last tab then hide the last button and show the finish instead
                if($current >= $total) {
                    $('#rootwizard').find('.pager .next').hide();
                    $('#rootwizard').find('.pager .finish').show();
                    $('#rootwizard').find('.pager .finish').removeClass('disabled');
                } else {
                    $('#rootwizard').find('.pager .next').show();
                    $('#rootwizard').find('.pager .finish').hide();
                }
            }});
            $('#rootwizard .finish').click(function() {
                alert('Finished!, Starting over!');
                $('#rootwizard').find("a[href*='tab1']").trigger('click');
            });
            
            
            if('${tvalue}'!='')
           	{
            	var sjon='${tvalue}';
            	var obj = eval ("(" + sjon + ")");

            	
                for (var i in obj) {
                    $(".chzn-select option[value='" + obj[i].tId + "'] ").attr("selected", true);
                }
                $(".chzn-select").trigger("liszt:updated");
                $(".chzn-select").chosen();
           	}
           
            
            $(".btn-primary").click(function(){
            	var title =$("#cTitle").val();
            	if(title=="")
            		{
            		alert("文章标题不能为空");
            		return;
            		}
            	var selected = [];
            	$("#multiSelect").each(function () {
            		selected.push($(this).val());
            	});
            	$("#tType").val(selected);
            	$(".form-horizontal").submit();
            });
            
            $("#goback").click(function(){
            	window.location.href="${ctx}/stroy/list";
            });
            
            
            $(".btn-success").click(function(){
            	//debugger;
            	var size=$("[id^=title]").size();
            	size++;
            	var html='<div class="control-group" id="divlabel'+size+'"><label class="control-label" for="focusedInput">章节标题</label>';
            	html+='<div class="controls"><input class="input-xlarge focused" id="title'+size+'" name="title" type="text"  value="">';
            	html+='<input  id="id'+size+'" name="id" type="hidden"  value=""> </div></div>';
            	html+='<div class="control-group" id="divtxt'+size+'"><label class="control-label" for="textarea2">文章内容</label>';
            	html+='<div class="controls controlsDel"> <button type="button" class="btn btn-danger btn-lg controlsDelBtn " onclick="deleteZj('+size+')">&times;</button>';
            	html+='<button type="button" class="btn btn-primary  controlsSaveBtn " onclick="saveZj('+size+')">保存</button>'
            	html+='<textarea class="input-xlarge textarea" placeholder="文章内容" id="content'+size+'" name="cContent" style="width: 810px; height: 200px" ></textarea></div></div>';
            	$("#detailDiv").append(html);
            	$('#content'+size+'').wysihtml5();
            });
            
            
            $.ajax({
                url: "${ctx}/stroy/readZj",
                data: { cid: $("#cId").val()},
                type: "post",
                dataType:'json',
                success: function (data) {
               		if(data.code==0)
            		{
               			$("#detailDiv").empty();;
               			var jsonList=data.data;
               			$(jsonList).each(function(index,item){ 
               				var html='<div class="control-group" id="divlabel'+index+'"><label class="control-label" for="focusedInput">章节标题</label>';
                        	html+='<div class="controls"><input class="input-xlarge focused" id="title'+index+'" name="title" type="text"  value="'+item.title+'">';
                        	html+='<input  id="id'+index+'" name="id" type="hidden"  value="'+item.bId+'"> </div></div>';
                        	html+='<div class="control-group" id="divtxt'+index+'"><label class="control-label" for="textarea2">文章内容</label>';
                        	html+='<div class="controls controlsDel"> <button type="button" class="btn btn-danger btn-lg controlsDelBtn " onclick="deleteZj('+index+')">&times;</button>';
                        	html+='<button type="button" class="btn btn-primary  controlsSaveBtn " onclick="saveZj('+index+')">保存</button>'
                        	html+='<textarea class="input-xlarge textarea" placeholder="文章内容" id="content'+index+'" name="cContent" style="width: 810px; height: 200px" >'+item.contentText+'</textarea></div></div>';
               			
                        	$("#detailDiv").append(html);
                        	$('#content'+index+'').wysihtml5();
               			});
            		}
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
            
            
        });
        
        function deleteZj(num)
        {
        	if(confirm("确定删除此章节吗？"))
        	{
	        	var id=$("#id"+num).val();
	        	if(id!='')
	        	{
		        	$.ajax({
		                url: "${ctx}/stroy/deleteZj",
		                data: { id: id},
		                type: "post",
		                dataType:'json',
		                success: function (data) {
		               		if(data.code==0)
		            		{
		               			$("#divlabel"+num).remove();
		               			$("#divtxt"+num).remove();
		            		}
		                },
		                error: function (jqXHR, textStatus, errorThrown) {
		                    alert(jqXHR.responseText);
		                }
		            });
	        	}
	        	else
        		{
	        		$("#divlabel"+num).remove();
           			$("#divtxt"+num).remove();
        		}
        	}
        }
        function saveZj(num)
        {
        	var id=$("#id"+num).val();
        	var title=$("#title"+num).val();
        	var text=$("#content"+num).val();
        	
        	var cId=$("#cId").val();
        	$.ajax({
                url: "${ctx}/stroy/saveOrUpdateZj",
                data: { bid: id,cId:cId,title:title,text:text},
                type: "post",
                dataType:'json',
                success: function (data) {
               		if(data.code==0)
            		{
               			alert("保存成功");
            		}
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
        </script>
    </body>

</html>