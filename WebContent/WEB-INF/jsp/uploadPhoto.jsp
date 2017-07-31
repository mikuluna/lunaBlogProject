<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//项目地址
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/css/layui.css" />
<link rel="stylesheet" href="<%=path %>/css/upload.css" />
<style type="text/css">

</style>
</head>
<body>
	<div class="login-fullmain">
			<div class="login-top"><h1>照片上传</h1></div>
			<div style="display:none">
				<div class="step">
				<div class="myimgpreview">
					<img id="preview" class="preview">
					</div>
					<button class="deletestep" onclick="deletestep(this)">删除</button>
				</div>
			</div>
			<div class="coursestepbutton">
				<label class="upload">
			<b>上传图片</b>
 			<input class="change" name="file" type="file" multiple="multiple" onchange="imgPreview(this)" >
		</label>
			</div>
			<mvc:form modelAttribute="lunaPhoto" action="uploadPhoto.do" enctype="multipart/form-data">
				<div class="steps">
				</div>
				<div class="login-contain">
					<label class="layui-form-label">标题</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" name="title">
					</div>
				</div>
				<div class="login-contain">
					<label class="layui-form-label">简介</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" name="intro">
					</div>
				</div>

				<div style="clear: both;"></div>
				<input type="submit" class="layui-btn layui-btn-normal layui-btn-radius">
			</mvc:form>

		</div>

		<script>
			//			addstep.onclick = function() {
			//				var newstep = document.querySelector('.coursesteps').cloneNode(1);
			//				steps.appendChild(newstep);
			//			}
		</script>
		<script type="text/javascript">
			var
				step_demo = document.querySelector('.step');

			function imgPreview(fileDom) {
				//判断是否支持FileReader
				if(window.FileReader) {
					var reader = new FileReader();
				} else {
					alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
				}

				//获取文件
				var file = fileDom.files[0];
				var imageType = /^image\//;
				//是否是图片
				if(!imageType.test(file.type)) {
					alert("请选择图片！");
					return;
				}
				//读取完成
				reader.onload = function(e) {
					var change = document.querySelector('.change');
					var change1 = change.cloneNode(1);
					var step = step_demo.cloneNode(1);

					change1.style.display = 'none';
					document.querySelector('.steps').appendChild(step);
					document.querySelector('.steps').appendChild(change1);
					//获取图片dom
					var img = step.querySelector('img');
					//图片路径设置为读取的图片
					img.src = e.target.result;
				};
				reader.readAsDataURL(file);
			}

			function deletestep(deletethis) {
				deletethis.parentNode.remove();
			}
		</script>
</body>
</html>