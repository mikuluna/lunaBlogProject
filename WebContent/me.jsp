<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/head_main.css" />
<link rel="stylesheet" href="css/me.css" />
<style type="text/css">
	.contain_foot{
				background:url(img/myblogbackground.png) ;
				background-size:100% 100%;
			}
</style>
<script>
			! function(c, b) { if(b = c.search.slice(1)) { c.href = "/#" + b } }(location);
</script>
	 <script src='js/jquery.js'></script>	
	 <script type="text/javascript" src="js/sonpScroll.js" ></script>
	</head>
<body>
	<!--头部开始-->
		<div class="sonp-section sonp-small">
		<div class="nav_head ">
			<a href="#" class="a dianji">
				<img src="img/nav_luna.png" />
			<p>my</p>
			</a>
			<a href="# "><img  src="img/nav_dance.png" /><p>舞蹈</p></a>
			<a href="# "><img  src="img/nav_cos.png "/><p>学习笔记</p></a>
			<a href="# "><img  src="img/nav_day.png "/><p>照片</p></a>
			<a href="# "><img  src="img/nav_journal.png "/><p>日志</p></a>
			<a href="# "><img  src="img/nav_messageBoard.png "/><p>留言板</p></a>
			<a href="# "><img  src="img/nav_handmade.png "/><p>手工</p></a>
			<div style="clear: both; "></div>
		</div>
		</div>
		<!--头部结束-->
		<!--中间内容部分开始-->
		<div class="me_contain_my sonp-section sonp-parallax">
		
		<div class="contain_my_title">
		<img src="img/touxiang.png" />
			<h1>诗小轩</h1>
			<p>一个元气不衰减，一直不断努力的孩子，也许终有一天能成为一个厉害的人 <span  onclick="supOnclick()">www</span></p>
			<p>微博地址：<a href="http://www.weibo.com/2462058527/" target="view_window">@诗小轩luna</a></p>
			<br />
			<br/>
			<p>希望自己能变得越来越好，做越来越多的项目w</p>
			<p></p>
			<p>诗小轩，一个喜欢跳舞，偶尔cos，喜欢手工，充满无限正能量的孩子</p>
			<br />
			<br/>
			<p>如果可以的话</p>
			<p>请往下看</p>
			<br/>
		</div>
			
		<div style="clear: both;"></div>
		
		</div>
		<!--中间内容部分结束-->
		<!--页脚-->
		<div class="contain_foot sonp-section sonp-full">
			<div class="myzan">
				<h1>如果你真的喜欢的我的话</h1>
			</div>
			<div class="myhobbycontain">
				<h2><a href="http://www.weibo.com/2462058527/" target="view_window">开始新冒险</a></h2>
			</div>
			<div class="myhobbycontain">
				<h2><a href="http://space.bilibili.com/565389/" target="view_window">读取存档</a></h2>
			</div>
			<div class="myhobbycontain">
				<h2><a href="https://github.com/mikuluna" target="view_window">关于我</a></h2>
			</div>
			<div class="myhobbycontain">
				<h2><a href="exit.html">退出</a></h2>
			</div>
			<div></div>
		</div>
		<div style="clear: both;"></div>
		
		
		
<section class="cont" id="supCont" >
  <div class="button">✹</div>
  <div class="button">◎</div>
  <div class="button">✧</div>
  <div class="button">◈</div>
  <div class="button">✮</div>
  <div class="button clicked"></div>
  <div class="close" onclick="supContclose() ">关闭</div>
</section>
		</div>
		
		 <script type="text/javascript" src="js/prefixfree.min.js" ></script> 
		 <script type="text/javascript" src="js/index.js" ></script>
		
 		
  	<script>
  		var supCont = document.getElementById('supCont');
  		function supOnclick(){
  			
  			if(supCont.style.display == 'block'){
				supCont.style.display ='none';
			}
  			else{
  				supCont.style.display = 'block';
  			}
		}
  		function supContclose(){
  			supCont.style.display ='none';
  		}
  	</script>
	</body>
</html>