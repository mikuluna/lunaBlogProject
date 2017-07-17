<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//项目地址
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>css/layui.css" />
<link rel="stylesheet" href="<%=path %>/css/upload.css" />
</head>
<body>
		
		<div class="login-fullmain" name="containmain">
			<div class="login-top"><h1>舞蹈上传</h1></div>
			<form action="<%=path %>/uploadDance.do" method="post" enctype="multipart/form-data">
				<div class="login-contain">
					<label class="layui-form-label">封面上传</label>
					<div class="layui-input-block">
						<input type="file" class="layui-input" name="file">
					</div>
				</div>
				<div class="login-contain">
					<label class="layui-form-label">视频地址</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input">
					</div>
				</div>
				<div class="login-contain">
					<label class="layui-form-label">视频标题</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input">
					</div>
				</div>
				<div class="login-button">
					<button type="submit" class="layui-btn layui-btn-normal layui-btn-radius">上传</button>
					<button type="reset" class="layui-btn layui-btn-normal layui-btn-radius">重置</button>
				</div>
		</div>
		</form>
		</div>
		
		
		
</body>
</html>