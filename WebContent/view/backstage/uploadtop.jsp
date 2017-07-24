<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
	//项目地址
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/css/layui.css" />
</head>
<body>
<div class="hou_top">
<ul class="layui-nav">
<li class="layui-nav-item layui-this">
					<a href="javascript:;">上传</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="uploaddance.jsp">舞蹈</a>
						</dd>
						<dd>
							<a href="uploadlearnnote.jsp">学习笔记</a>
						</dd>
						<dd>
							<a href="">照片</a>
						</dd>
						<dd>
							<a href="">日志</a>
						</dd>
						<dd>
							<a href="">手工</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">查看</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="uploaddance.jsp">舞蹈</a>
						</dd>
						<dd>
							<a href="">学习笔记</a>
						</dd>
						<dd>
							<a href="">照片</a>
						</dd>
						<dd>
							<a href="">日志</a>
						</dd>
						<dd>
							<a href="">手工</a>
						</dd>
					</dl>
				</li>
				
			</ul>
		</div>
		<script type="text/javascript" src="<%=path %>/js/layui.all.js" ></script>
<script>
			layui.use('element', function() {
				var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块

				//监听导航点击
				element.on('nav(demo)', function(elem) {
					//console.log(elem)
					layer.msg(elem.text());
				});
			});
		</script>
</body>
</html>