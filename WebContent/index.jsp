<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小轩博客</title>
	<link rel="stylesheet" href="<%=path %>/css/layui.css" />
	<link rel="stylesheet" href="<%=path %>/css/style.css" />
	<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
	 <script type="text/javascript" src="<%=path %>/js/angular.min.js" ></script>
	 <script type="text/javascript" src="<%=path %>/js/angular-ui-router.min.js" ></script>
	 <script type="text/javascript" src="<%=path %>/js/App.js" ></script>
</head>
<body data-ng-app="myApp">
		<div data-ui-view=""></div>
	</body>
</html>