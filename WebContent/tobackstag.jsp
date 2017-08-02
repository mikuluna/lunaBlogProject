<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
	<link rel="stylesheet" href="<%=path %>/css/animate.css">
	<link rel="stylesheet" href="<%=path %>/css/styleLogin.css">
<link rel="stylesheet" href="<%=path %>/js/modernizr-2.6.2.min.js">
</head>
<body class="style-3">

		<div class="container">
			
			<div class="row">
				<div class="col-md-4 col-md-push-8">
					

					<!-- Start Sign In Form -->
					<form action="goBackStag.do" class="fh5co-form animate-box" data-animate-effect="fadeInRight" method="post">
						<h2>小轩专用登录通道</h2>
						<div class="form-group">
							<label for="userName" class="sr-only">用户名</label>
							<input type="text" name="userName" class="form-control" id="username" placeholder="用户名" required autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" name="password" class="form-control" id="password" placeholder="密码" required autocomplete="off">
						</div>
					
					
						<div class="form-group">
							<input type="submit" value="登录" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->


				</div>
			</div>
		</div>
	
	<!-- jQuery -->
	<script src="<%=path %>/js/jquery.js"></script>
	<!-- Bootstrap -->
	<script src="<%=path %>/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="<%=path %>/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=path %>/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="<%=path %>/js/main.js"></script>

	</body>
</html>