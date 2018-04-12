<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="l"><a href="${ctx }/index"><i class="icon-zhuye1"></i></a></div>
    <div class="c box-flex-1 text-center"><h1>哈哈哈中午网</h1></div>
    <div class="r text-right"><a href="login.html"><i class="icon-zhuye"></i></a></div>
</header>

<!--我的书架-->
<div class="section bookzoom-box">
    <h3 class="fz2rem"><i class="icon-yuedu"></i></h3>
    <!--分类-->
    <div class="bookzoom-classify flex">
        <span style="width: 9.3rem;">查看方式:</span>
        <div class="box-flex-1">
         	<a href="javascript:search(1);" class="active">最新上架</a>
            <a href="javascript:search(2);" >下载量</a>
             <a href="javascript:search(3);" >阅读量</a>
        </div>
    </div>
</div>
<div class="section bookzoom-books mt1rem">
    <ul class="none" id="tesk">
    </ul>
    <!--分页-->
    <div class="text-center recharge-col page-list mt1rem" id="pageDiv">
       
    </div>
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
	function search(num)
	{
		 $.ajax({
             url: "${ctx}/user/searchOrder",
             data: { num:num},
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
            			 html+='<a href="book-detail.html">'+obj.cTitle+'</a></h4><p class="none fz14rem">简介 ：'+obj.cDesc+'</p>';
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
        })
        search("1");
    })
    
</script>
</html>