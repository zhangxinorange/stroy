<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no" />
<title>主页</title>
<link rel="stylesheet" href="${ctx}/static/fonts/iconfont.css" />
<link rel="stylesheet" href="${ctx}/static/css/style.min.css">
<link rel="stylesheet" href="${ctx}/static/css/swiper.min.css">
<script src="${ctx}/static/js/loading.js"></script>
</head>
<body>
	<header class="header flex flex-vc">
		<div class="l">
			<a href="#"><i class="icon-zhuye1"></i></a>
		</div>
		<div class="c box-flex-1 text-center">
			<h1>悦享小说阅读网</h1>
		</div>
		<div class="r text-right">
			<a href="${ctx}/static/login.html"><i class="icon-zhuye"></i></a>
		</div>
	</header>
	<!--导航-->
	<div class="banner">
		<div class="swiper-container">
			<!--banner图懒加载 data.src-->
			<div class="swiper-wrapper">
				<c:forEach items="${lunbo }" var="content">
					<div class="swiper-slide">
					<img data-src="${ctx}/${content.cPicStr}" alt=""
						class="img-bespread swiper-lazy" style="width: 100%;height: 100%;"/>
					<div class="swiper-lazy-preloader"></div>
				</div>
				
				</c:forEach>
				
				<%-- <div class="swiper-slide">
					<img data-src="${ctx}/static/images/banner.jpg" alt=""
						class="img-bespread swiper-lazy" />
					<div class="swiper-lazy-preloader"></div>
				</div>
				<div class="swiper-slide">
					<img data-src="${ctx}/static/images/banner.jpg" alt=""
						class="img-bespread swiper-lazy" />
					<div class="swiper-lazy-preloader"></div>
				</div> --%>
			</div>
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<div class="nav-box section">
		<nav>
			<ul class="flex flex-vc none text-center color-white fz16rem">
				<li class="box-flex-1"><a href="${ctx}/static/index.html">
						<div class="nav-div home">
							<i class="icon icon-zhuye1"></i>
						</div> <span>首页</span>
				</a></li>
				<li class="box-flex-1"><a href="${ctx}/static/recharge.html">
						<div class="nav-div cz fz22rem">
							<i class="icon icon-qianbao1 fz22rem"></i>
						</div> <span>充值</span>
				</a></li>
				<li class="box-flex-1"><a href="${ctx}/static/bookshelf.html">
						<div class="nav-div sj">
							<i class="icon icon-yuedu1"></i>
						</div> <span>书架</span>
				</a></li>
				<li class="box-flex-1"><a href=" ${ctx}/static/bookzoom.html">
						<div class="nav-div sk">
							<i class="icon icon-yuedu"></i>
						</div> <span>书库</span>
				</a></li>
				<li class="box-flex-1"><a href="${ctx}/static/search.html">
						<div class="nav-div ss">
							<i class="icon icon-chakan"></i>
						</div> <span>搜索</span>
				</a></li>>
			</ul>
		</nav>
	</div>
	<!--限时免费-->
	<div class="public-title section mt1rem">
		<h2 class="none fz16rem">限时免费</h2>
	</div>
	<div class="section apps-free recharge-col">
		<ul class="flex none text-center">
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
		</ul>
	</div>
	<div class="public-title section mt1rem">
		<h2 class="none fz16rem">最热作品</h2>
	</div>
	<div class="section apps-free  recharge-col">
		<ul class="flex none text-center">
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
		</ul>
		<!--推荐-->
		<div class="clearfix recommend-title">
			<ul class="none">
				<li><a href="#"><span class="title">[现言]</span>霸道总裁爱：亿万逃妻萌萌哒</li>
				</a>
				<li><a href="#"><span class="title">[现言]</span>霸道总裁爱：亿万逃妻萌萌哒</li>
				</a>
			</ul>
		</div>
	</div>
	<div class="public-title section mt1rem">
		<h2 class="none fz16rem">最新推荐</h2>
	</div>
	<div class="section apps-free recharge-col">
		<ul class="flex none text-center">
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
		</ul>
		<!--推荐-->
		<div class="clearfix recommend-title">
			<ul class="none">
				<li><a href="#"><span class="title">[现言]</span>霸道总裁爱：亿万逃妻萌萌哒</li>
				</a>
				<li><a href="#"><span class="title">[现言]</span>霸道总裁爱：亿万逃妻萌萌哒</li>
				</a>
			</ul>
		</div>
	</div>
	<!--推荐书籍-->
	<div class="recommend mt1rem">
		<ul class="none">
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
		</ul>
	</div>
	<div class="section apps-free mt1rem recharge-col">
		<ul class="flex none text-center">
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
		</ul>
	</div>
	<!--推荐书籍-->
	<div class="recommend mt1rem">
		<ul class="none">
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
		</ul>
	</div>
	<div class="section apps-free mt1rem recharge-col">
		<ul class="flex none text-center">
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
			<li><a href="#">
					<figure>
						<img src="${ctx}/static/images/132.jpg" class="img-bespread"
							alt="loading">
						<p>限时免费</p>
					</figure>
					<h5 class="none">小说名字</h5>
			</a></li>
		</ul>
	</div>
	<!--推荐书籍-->
	<div class="recommend mt1rem">
		<ul class="none">
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
			<li class="section flex mt1rem recharge-col">
				<div class=recommend-img>
					<img src="${ctx}/static/images/111.jpg" alt="loading..">
				</div>
				<div class="box-flex-1">
					<h4 class="none">推荐书籍标题</h4>
					<p class="fz14rem">内容内容内容收到反馈技术开发建设的jfk受到激发复试独家刊发开始的jfk受到激发撒地方就是打开房间</p>
				</div>
			</li>
		</ul>
	</div>
	<footer class="footer">
		<ul class="none">
			<li class=""><a href="#">登录</a></li>
			<span class="fg">|</span>
			<li class=""><a href="#">首页</a></li>
			<span class="fg">|</span>
			<li class=""><a href="#">充值</a></li>
		</ul>
		<p class="none">客服QQ：123435666</p>
	</footer>
</body>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/script.js"></script>
<script src="${ctx}/static/js/swiper.min.js"></script>
<script>
    
    $(function(){
        var mySwiper = new Swiper('.swiper-container', {
            autoplay: 4000,
            pagination: '.swiper-pagination',
            paginationClickable: true,
            lazyLoading : true,
        });
    })
</script>
</html>
>
