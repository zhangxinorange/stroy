<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <title>阅读</title>
    <link rel="stylesheet" href="${ctx }/static/fonts/iconfont.css"/>
    <link rel="stylesheet" href="${ctx }/static/css/style.min.css">
    <script src="${ctx }/static/js/loading.js"></script>
</head>
<body>
<header class="header">
    <div class="flex flex-vc color-white book-detail-title">
        <div class="left" onclick="back()"><i class="icon-zuoleft157"></i></div>
        <div class="box-flex-1 title"><h4 class="fz14rem">${content.cTitle }</h4></div>
        <div class="right"><!-- <a href="book-catalogue.html"><i class="icon-mulu"></i></a> --><span class="fg"></span><a href="${ctx }/user/index"><i class="icon-zhuye1"></i></a></div>
    </div>
</header>
<!--书籍详情-->
<div class="recharge-col book-read-box">
    <h4 class="fz2rem">${content.cTitle }</h4>
    <div>
        <ul class="none flex text-center color-blue">
            <li class="box-flex-1 book-read-setting setting-light"><i class="icon-qingyewan"></i><span>关灯</span></li>
            <li class="box-flex-1 book-read-setting setting-upfont"><i class="icon-edite"></i>放大字体</li>
            <li class="box-flex-1 book-read-setting setting-downfont"><i class="icon-fontm"></i>缩小字体</li>
        </ul>
    </div>
    <article class="" style="line-height: 5rem;">
    	${content.detailHtml }
    </article>
  <!--   <div class="flex text-center color-white">
        <a href="#" class="btn-page box-flex-1">上一章</a>
        <a href="#" class="btn-page box-flex-1">目录</a>
        <a href="#" class="btn-page box-flex-1">下一章</a>
    </div> -->
</div>
<!--推荐书籍
<div class="recommend mt1rem">
    <ul class="none">
        <li class="section flex mt1rem recharge-col">
            <div class=recommend-img>
                <img src="images/111.jpg" alt="loading..">
            </div>
            <div class="box-flex-1">
                <h4 class="none">推荐书籍标题</h4>
                <p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
            </div>
        </li>
        <li class="section flex mt1rem recharge-col">
            <div class=recommend-img>
                <img src="images/111.jpg" alt="loading..">
            </div>
            <div class="box-flex-1">
                <h4 class="none">推荐书籍标题</h4>
                <p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
            </div>
        </li>
    </ul>
</div> -->
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
    //设置字体
    function set_font( article, fontArray ){
        if(window.localStorage){
            localStorage.setItem('fontsize',fontArray.index)
            article.removeClass().addClass(fontArray.font);
        }else{
            article.addClass(fontArray.font);
        }
        
    }
    //初始化字体
    function init_font( article,fontArray ){
        article.addClass(fontArray )
    }
    $(function(){
        //字体选择
        var fontArray = [{
            index:0,
            font:"fz12rem"
        },
        {
            index:1,
            font:"fz14rem"
        },
        {
            index:2,
            font:"fz16rem"
        },
        {
            index:3,
            font:"fz18rem"
        },
        {
            index:4,
            font:"fz2rem"
        }]
        var i = localStorage.getItem("fontsize") || 1; //默认fz14rem
        var article = $('article'), //文章
            font = fontArray[i].font;     //当前本地存储的字体大小
        init_font(article,fontArray[i].font);  //初始化字体大小

        //关灯
        $('.setting-light').on('click',function(){
            var $this = $(this);
            var $body = $('body');
            $body.toggleClass('read-light');
            var text = $this.find('span');
            if($body.hasClass('read-light')){
                text.html('开灯')
            }else{
                text.html('关灯')
            }
            
        })

        $(".setting-upfont").on('click',function(){
            if(i == fontArray.length -1){
                return;
            }else{
                 i++;
            }
            set_font(article,fontArray[i]);
        })

        $(".setting-downfont").on('click',function(){
            if(i == 0){
                return;
            }else{
                 i--;
            }
            set_font(article,fontArray[i]);
        })

    })
    function back()
    {
    	window.location.href="${ctx}/user/detail?cId=${content.cId}";
    }
</script>
</html>