<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="member" value="${sessionScope.member}" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <title>书库</title>
    <link rel="stylesheet" href="${ctx }/static/fonts/iconfont.css"/>
    <link rel="stylesheet" href="${ctx }/static/css/style.min.css">
    <script src="${ctx }/static/js/loading.js"></script>
</head>
<body>
<header class="header">
    <div class="flex flex-vc color-white book-detail-title">
        <div class="left" onclick="back()"><i class="icon-zuoleft157"></i></div>
        <div class="box-flex-1 title"><h4 class="fz14rem">${content.cTitle }</h4></div>
        <div class="right"><a href="${ctx }/user/index"><i class="icon-yuedu"></i></a><span class="fg"></span><a href="${ctx }/user/index"><i class="icon-zhuye1"></i></a></div>
    </div>
</header>
<!--书籍详情-->
<div class="section recharge-col book-detail-box flex">
    <div class="book-detail-img">
        <img src="${ctx }/${content.cPicStr }" alt="loading.." class="img-bespread">
    </div>
    <div class="box-flex-1 book-detail-info">
        <h4 class="none color-blue title">${content.cTitle }</h4>
        <span class="state ing"><i class="icon-yuedu"></i>连载中</span>
        <!--<span class="state end">已完结</span>-->
        <div class="fz12rem mt1rem">
            <p class="none ">作者：${content.cAuthor }</p>
            <p class="none ">分类：${type }</p>
        </div>
    </div>
</div>
 <div class="section flex recharge-col book-operation">
    <a id="dLoadA" href="javascript:download();" class="btn btn-primary box-flex-1"><i class="icon-kongxin"></i>下载图书<font color="red">(消费金币:${content.downScore })</font></a>
    <span class="fg"></span>
    <a href="javascript:read();" class="btn btn-success box-flex-1"><i class="icon-chakan"></i>开始阅读<font color="red">(消费金币:${content.readScore })</font></a>
</div> 
<!--书籍简介-->
<div class="section recharge-col book-intro">
    <h3 class="fz2rem book-detail-titles"><i class="icon-yuedu1"></i>书籍简介</h3>
    <article class="fz14rem book-intro-article">
        <p>${content.cDesc }</p>
    </article>
   <!--  <div class="text-center book-intro-unfold">展开更多介绍 <i class="icon-xia"></i></div> -->
</div>
<!--书籍目录-->
 <div class="section recharge-col mt1rem book-mulu">
    <h3 class="fz2rem book-detail-titles"><i class="icon-mulu"></i>书籍目录</h3>
    <div class="book-all-mulu color-blue"><i class="icon-xia pull-right"></i>全部章节</div>
    <ul class="none book-mulu-items fz16rem">
    	<c:forEach items="${bookList }" var="book">
    		<li><a href="javascript:readDetail('${book.bId }');">${book.title}</a></li>
    		
    	</c:forEach>
        <!-- <li><a href="#">第一章：喜洋洋与灰太狼的爱情故事</a></li>
        <li><a href="#">第一章：喜洋洋与灰太狼的爱情故事</a></li>
        <li><a href="#">第一章：喜洋洋与灰太狼的爱情故事</a></li>
        <li><a href="#">第一章：喜洋洋与灰太狼的爱情故事</a></li>    
        <li><a href="#"><i class="icon-vip"></i>第一章：喜洋洋与灰太狼的爱情故事</a></li>
        <li><a href="#"><i class="icon-vip"></i>第一章：喜洋洋与灰太狼的爱情故事</a></li>        --> 
    </ul>
</div> 
<!--书籍评论-->
<div class="section recharge-col mt1rem book-mulu">
    <h3 class="fz2rem book-detail-titles"><i class="icon-mulu"></i>评论</h3>
    <div class="book-all-mulu color-blue"><i class="icon-xia pull-right"></i>全部评论</div>
    <ul class="none book-mulu-items fz16rem" id="repicst">
        <!-- <li>
        	<h4 class="none">张三</h4>
            <p class="none">好看好看还想再看！</a></p>
        </li>
        <li>
        	<h4 class="none">张三</h4>
            <p class="none">好看好看还想再看！</a></p>
        </li>
        <li>
        	<h4 class="none">张三</h4>
            <p class="none">好看好看还想再看！</a></p>
        </li> -->
    </ul>    
    <div class="recharge-col">
    	<textarea maxlength="500" id="msgText" style="border: solid 2px cadetblue;width: 100%;height: 150px;">请发表您的看法！</textarea>
        <a href="javascript: saveMsg();"  class="btn btn-primary btn-block go-to-recharge">发布</a>
    </div>
</div>
<!--搜索框
<div class="search-box">
    <div class="search">
        <form action="#" method="get">
        <input type="text" class="inp inp-block search-inp" placeholder="请输入关键字">
        <input type="submit" class="btn search-btn" value="搜索">
        </form>
    </div>
</div>-->
<!--底部-->
<footer class="footer">
    <ul class="none">
        <li class=""><a href="${ctx }/user/login">登录</a></li>
        <span class="fg">|</span>
        <li class=""><a href="${ctx }/user/index">首页</a></li>
        <span class="fg">|</span>
        <li class=""><a href="${ctx }/user/search">搜索</a></li>
    </ul>
</footer>
</body>
<script src="${ctx }/static/js/jquery.min.js"></script>
<script src="${ctx }/static/js/script.js"></script>
<script>
    $(function(){
        var article = $(".book-intro-article>p"),
            text = article.text();          //保存当前所有文字
        toggle_mulu();
        init_subStr(article,text,50);
        toggle_intro(article,text,50);
        getALLMsg();
    })
    //展开更多介绍
    function toggle_intro(ele, alltext,len ){
        len = len ? len : 50;
       $(".book-intro-unfold").on('click',function(){
           var $this = $(this);
           if( alltext.length < len ){
               return;
           }

        if( $this.hasClass('isAll') ){
            $this.addClass('rotate').removeClass('isAll')
            ele.html(alltext);
        }else{
            $this.addClass('isAll').removeClass('rotate');
            ele.html(sub_str(alltext,len));
        }
          
       }) 
    }
    //截取字符
    function sub_str( ele,length ){
        return ele.replace(/\s/g,"").substr(0,length)+"。。。";
    }
    //初始化截取50个字
    function init_subStr(ele,alltext,len){
        len = len ? len : 50;
        if( alltext.length < len ){
            return;
            $(".book-intro-unfold").addClass('rotate')
        }
        $(".book-intro-unfold").addClass('isAll')
        ele.html(sub_str(alltext,len));
    }
    //展开目录
    function toggle_mulu( ){
        var $book = $('.book-all-mulu');
        $book.on('click',function(){
            var $this = $(this);
            $this.toggleClass('toggle rotate');
        });
    }
    function download()
    {
    	if('${member}'==''&&'${content.cAdmin}'==1)
   		{
   			if(confirm("小说${content.cTitle}需要您登陆才能下载,确定跳转登陆页面吗？"))
 			{
 				window.location.href='${ctx}/user/login?url=${content.cId}';
 			}
   		}
    	else if('${member}'==''&&'${content.downScore}'!='0')
   		{
    		if(confirm("小说${content.cTitle}需要${content.downScore}金币才能下载，您暂时没有足够金币,确定跳转登陆页面吗？"))
 			{
 				window.location.href='${ctx}/user/login?url=${content.cId}';
 			}
   		}
    	else if('${member}'!=''&&  ${member.mScore}-${content.downScore}<0)
   		{
    		if(confirm("小说${content.cTitle}需要${content.downScore}金币才能下载，您暂时没有足够金币,确定跳转充值页面吗？"))
 			{
 				window.location.href='${ctx}/user/gotoRecharge';
 			}
   		}
    	else
   		{
    		/* if('${member}'=='' && ${content.downScore}==0)
   			{
   				window.open('${ctx}/user/startDownload?cId=${content.cId}&mId=${member.mId}','_blank');
   			}
    		else
   			{
   			
   			}
    		if(${content.downScore}!=0 && confirm("下载此小说需要花费${content.downScore}金币,您当前的")) */
    			
    		window.open('${ctx}/user/startDownload?cId=${content.cId}&mId=${member.mId}','_blank');
   		}
    }
    
    function read(){
    	if('${member}'==''&&'${content.readScore}'!='0')
   		{
    		if(confirm("小说${content.cTitle}需要${content.readScore}金币才能阅读，您暂时没有足够金币,确定跳转登陆页面吗？"))
 			{
 				window.location.href='${ctx}/user/login?url=${content.cId}';
 			}
   		}
    	else if ('${member}'!=''&&  ${member.mScore}-${content.readScore}<0)
   		{
    		if(confirm("小说${content.cTitle}需要${content.readScore}金币才能阅读，您暂时没有足够金币,确定跳转充值页面吗？"))
 			{
 				window.location.href='${ctx}/user/gotoRecharge';
 			}
   		}
    	else
   		{
    		window.location.href='${ctx}/user/read?cId=${content.cId}&mId=${member.mId}';
   		}
    	
    }
    function readDetail(id){
    	debugger;
    	if('${member}'==''&&'${content.readScore}'!='0')
   		{
    		if(confirm("小说${content.cTitle}需要${content.downScore}金币才能阅读，您暂时没有足够金币,确定跳转登陆页面吗？"))
 			{
 				window.location.href='${ctx}/user/login?url=${content.cId}';
 			}
   		}
    	else if ('${member}'!=''&&  ${member.mScore}-${content.readScore}<0)
   		{
    		if(confirm("小说${content.cTitle}需要${content.readScore}金币才能阅读，您暂时没有足够金币,确定跳转充值页面吗？"))
 			{
 				window.location.href='${ctx}/user/gotoRecharge';
 			}
   		}
    	else
   		{
    		window.location.href='${ctx}/user/readDetail?bId='+id+'&mId=${member.mId}';
   		}
    }
    
    function back()
    {
    	window.location.href="${ctx}/user/index";
    }
    function getALLMsg()
    {
    	var cId='${content.cId}';
    	$.ajax({
            url: "${ctx}/user/allMsg",
            data: { cId: cId}, 
            type: "post",
            dataType:'json',
            success: function (data) {
           		if(data.code==0)
        		{
           			/* window.location.href="${ctx}/user/index"; */
           			debugger;
           			$("#repicst").empty();
           		 var html="";
           		 $.each(data.data, function(idx, obj) {
           			 
           			html+="<li><h4 class=none'>"+obj.mName+"</h4>"
           			html+="<p class=\"none\">"+obj.mContent+"</a></p></li>";
           			});
           		 $("#repicst").html(html);
           			
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
    function saveMsg()
    {
    	if('${member}'=="")
   		{
   			alert("登录后才能评价呦");
   			return;
   		}
    	var cId='${content.cId}';
    	var text=$("#msgText").val();
    	if(text==""||text=="请发表您的看法！")
   		{
   			alert("请填写评论后再保存");
   			return;
   		}
    	$.ajax({
            url: "${ctx}/user/saveMsg",
            data: { cId: cId,msg:text}, 
            type: "post",
            dataType:'json',
            success: function (data) {
           		if(data.code==0)
        		{
           			confirm("评论成功");
           			getALLMsg();
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
</script>
</html>