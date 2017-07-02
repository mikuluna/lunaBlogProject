<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/froala_editor.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/upload.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/upload.css" />
</head>
<body>
<%@ include file="uploadtop.jsp"%>
		<div class="contain_all">
			<div class="login-top"><h1>学习笔记上传</h1></div>
			<section id="editor">
				<form action="" method="post">
					<div class="login-contain">
						<label class="layui-form-label">标题</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input">
						</div>
					</div>
					<div class="login-contain">
						<label class="layui-form-label">简介</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input">
						</div>
					</div>
					<div class="login-contain">
						<label class="layui-form-label">分区</label>
						<div class="layui-input-block">
							<select name="partitionId" lay-filter="aihao" style="font-size: 20px;">
								<option value="1" selected="">Java基础</option>
								<option value="2">后端框架</option>
								<option value="3" >SQL</option>
								<option value="4">JSP</option>
								<option value="5">JavaScript</option>
								<option value="6">前端框架</option>
								<option value="7">其他</option>
							</select>
						</div>
					</div>

					<textarea id='edit' style="margin-top: 30px;">
      				</textarea>
					<button id="sdfdsf" type="button" class="layui-btn layui-btn-normal layui-btn-radius">查看填入内容</button>
					<input type="submit" class="layui-btn layui-btn-normal layui-btn-radius">
				</form>
			</section>
		</div>

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery-1.11.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/froala_editor.min.js"></script>
		<!--[if lt IE 9]>
    	<script src="../js/froala_editor_ie8.min.js"></script>
  		<![endif]-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/tables.min.js"></script>
		<script type="text/javascript" src="js/plugins/lists.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/colors.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/media_manager.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/font_family.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/font_size.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/block_styles.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/video.min.js"></script>

		<script>
			$(function() {
				$('#edit')
					.editable({ inlineMode: false })
			});
			$('#sdfdsf').click(function() {
				var text = $('#edit').val();
				alert(text);

			})
		</script>
</body>
</html>