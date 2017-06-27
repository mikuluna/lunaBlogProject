<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/learnnote.css" />
</head>
<body>
	<!--头部开始-->
	<div class="nav_head">
		<a href="#"><img src="img/nav_luna.png" />
		<p>my</p></a> <a href="#"><img src="img/nav_dance.png" />
		<p>舞蹈</p></a> <a href="#" class="a dianji"><img src="img/nav_cos.png" />
		<p>学习笔记</p></a> <a href="# "><img src="img/nav_day.png" />
		<p>照片</p></a> <a href="# "><img src="img/nav_journal.png" />
		<p>日志</p></a> <a href="# "><img src="img/nav_messageBoard.png" />
		<p>留言板</p></a> <a href="# "><img src="img/nav_handmade.png" />
		<p>手工</p></a>
		<div style="clear: both;"></div>
	</div>
	<!--头部结束-->
	<!--中间内容部分开始-->
	<div class="ln_contain_main">
		<div class="contain_course">
			<ul class="contain_ul">
				<li><a href="#">全部</a></li>
				<li><a href="#">Java基础</a></li>
				<li><a href="#">后端框架</a></li>
				<li><a href="#">SQL</a></li>
				<li><a href="#">JSP</a></li>
				<li><a href="#">JavaScript</a></li>
				<li><a href="#">前端框架</a></li>
				<li><a href="#">其他</a></li>
				<div style="clear: both;"></div>
			</ul>
		</div>
		<div class="search_contain">
			<div class="search_kong"></div>
			<form action="" method="post">
				<input type="text" placeholder="(oﾟ▽ﾟ)o请输入查找项ヾ(ﾟ∀ﾟゞ)"
					class="layui-input" />
				<button type="submit" class="search_button">开始查找</button>
			</form>
		</div>
		<div class="contain_main">
			<ul class="contain_text_ul">
				<li><a href="#">
						<div class="contain_text_in">
							<h1>Spring核心特性</h1>
							<p>一些简介而已</p>
						</div>
				</a></li>
			</ul>
		</div>

		<div class="jiazai">
			<a href="#">加 载...</a>
		</div>

	</div>
	<!--中间内容部分结束-->
</body>
</html>
