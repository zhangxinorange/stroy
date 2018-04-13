<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="member" value="${sessionScope.member}" />
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <title>书库</title>
    <link rel="stylesheet" href="${ctx }/static/fonts/iconfont.css"/>
    <link rel="stylesheet" href="${ctx }/static/css/style.min.css">
    <script src="${ctx }/static/js/loading.js"></script>
    <script type="text/javascript">
    
    </script>
</head>
<body>
<header class="header flex flex-vc">
    <div class="l"><a href="${ctx }/user/index"><i class="icon-zhuye1"></i></a></div>
    <div class="c box-flex-1 text-center"><h1>哈哈哈中午网</h1></div>
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
<!--搜索框-->
<div class="search-box">
    <div class="search" style="text-align: center;">
        
        <table style="width: 90%;">
        	<tr>
        		<td style="margin-right: 3px;"><input type="text" class="inp inp-block search-inp" style="width: 100%" id="title" placeholder="书名搜索"></td>
        		<td style="margin-right: 3px;"><input type="text" class="inp inp-block search-inp" style="width: 100%" id="author" placeholder="作者搜索"></td>
        		<td > <input type="button" onclick="seachBook()" class="btn search-btn" id="searchBtn" value="搜索"></td>
        	</tr>
        </table>
    </div>
</div>
<!--我的书架-->
<div class="section bookzoom-box">
    <h3 class="fz2rem"><i class="icon-yuedu"></i></h3>
    <!--分类-->
    <div class="bookzoom-classify flex">
        <span style="width: 5rem;">分类:</span>
        <div class="box-flex-1">
            <a href="#" title="a" class="active">全部</a>
            <c:forEach items="${tList }" var="type">
            	  <a href="#"  title="${type.tId }" >${type.tName }</a>
            	  <input type="hidden" id="typeStr">
            </c:forEach>
        </div>
    </div>
    <div class="bookzoom-classify flex">
        <span style="width: 5rem;">免费:</span>
        <div class="box-flex-1">
           	<input type="checkbox" name="isAdmin" value="0" onclick="seachBook()">是
           	<input type="checkbox" name="isAdmin" value="1" onclick="seachBook()">否
        </div>
    </div>
</div>
<div class="section bookzoom-books mt1rem">
    <ul class="none" id="tesk">
        <li class="recharge-col flex flex-vc">
            <div class="box-flex-1">
                <h4 class="none">
                    <i class="icon-vip"></i>
                    <a href="book-detail.html">权利的游戏之喜洋洋与灰太狼</a>
                </h4>
                <p class="none fz14rem">最新：村长的斗争</p>
                <p class="none fz12rem color-grey">作者：村上春树<span class="fg"></span></p>
            </div>
            <div class="text-right color-grey fz12rem">10-14 9:00</div>
        </li>
    </ul>
    <!--分页-->
    <div class="text-center recharge-col page-list mt1rem" id="pageDiv">
       
    </div>
      <input type="hidden" id="pageS" />
    <div class="text-center book-null" style="display: none;">
        <p>
            <i class="icon-shape"></i>
        </p>
        <p>书架空空的~什么都没有</p>
    </div>
</div>
<!--底部-->
<footer class="footer">
    <ul class="none">
        <li class=""><a href="#">登录</a></li>
        <span class="fg">|</span>
        <li class=""><a href="#">首页</a></li>
        <span class="fg">|</span>
        <li class=""><a href="#">充值</a></li>
    </ul>
</footer>
</body>
<script src="${ctx }/static/js/jquery.min.js"></script>
<script src="${ctx }/static/js/script.js"></script>
<script>
	function changePage(num)
	{
		$("#pageS").val(num);
		seachBook();
	}
	function seachBook(tId)
	{
		var title=$("#title").val();
		var author=$("#author").val();
		var pageIndex=$("#pageS").val();
		var type="";
		if(typeof(tId)!="undefined")
		{
			type=tId;
		}
		var admni="";
		 $.each($('input:checkbox'),function(){
	         if(this.checked){
	            /*  window.alert("你选了："+
	                 $('input[type=checkbox]:checked').length+"个，其中有："+$(this).val()); */
	        	 admni=admni+$(this).val()+",";
	         }
	     });
		 
		 $.ajax({
             url: "${ctx}/user/search",
             data: { title: title ,author:author,type:type,isAdmin:admni,pageIndex:pageIndex},
             type: "post",
             dataType:'json',
             success: function (data) {
            	 if(data.code==0)
           		 {
            		 $("#tesk").empty();
            		 var html="";
            		 $.each(data.data.data, function(idx, obj) {
            			 html+='<li class="recharge-col flex flex-vc"><div class="box-flex-1">  <h4 class="none">' ;
            			 if(obj.cAdmin==1)
           				 {	
            				 html+='<i class="icon-vip"></i>';
           				 }
            			 html+='<a href="javascript:window.location.href=\'${ctx }/user/detail?cId='+obj.cId+'\';">'+obj.cTitle+'</a></h4><p class="none fz14rem">简介 ：'+obj.cDesc+'</p>';
            			 html+='<p class="none fz12rem color-grey">作者：'+obj.cAuthor+'<span class="fg"></span></p></div>';
            			 html+='<div class="text-right color-grey fz12rem">'+obj.cCreateDate+'</div>'
            			});
            		 $("#tesk").html(html);
            		 
            		 
            		 var pageIndex=data.data.pageIndex;
            		 var pageCount=data.data.pageCount;
            		 $("#pageDiv").empty();
            		 var pHtml="";
            		 if(pageIndex>1)
            		{
            			 pHtml+='<a href="javascript: changePage('+(pageIndex-1)+');">上一页</a>'
            		}
            		 else
           			 {
            			 pHtml+='<a href="javascript: changePage('+pageIndex+');">上一页</a>'
           			 }
            		 for(var i=1;i<=pageCount;i++)
           			 {
           			 	if(i==pageIndex)
         			 	{
         			 		pHtml+='<span>'+pageIndex+'</span>'
         			 	}
           			 	else
         			 		{
           			 	pHtml+=' <a href="javascript: changePage('+i+');">'+i+'</a>'
         			 		}
           			 }
            		if(pageIndex<pageCount)
           			{
            			pHtml+='<a href="javascript: changePage('+(pageIndex+1)+');">末页</a>'
           			}
            		else
           			{
            			pHtml+='<a href="javascript: changePage('+pageCount+');">末页</a>'
           			}
            		$("#pageDiv").html(pHtml);
           		 }
             },
             error: function (jqXHR, textStatus, errorThrown) {
                 alert(jqXHR.responseText);
             }
         });
		 
	}

    $(function(){
        //选项卡切换
        var $bookshelf_title = $(".box-flex-1>a");
        $bookshelf_title.on('click',function(){
            var $this = $(this),
                $content = $(".bookshelf-content").find(".bookshelf-read"),
                $index= $bookshelf_title.index(this);
            $this.addClass('active').siblings().removeClass('active');
            $content.eq($index).show().siblings().hide();
            seachBook($this.attr("title"));
        })
        seachBook();
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