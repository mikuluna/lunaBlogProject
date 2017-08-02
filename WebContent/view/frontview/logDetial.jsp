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
<title>${lunaLog.title }</title>
<link rel="stylesheet" href="<%=path %>/css/detial.css" />
</head>
<body>
<div class="leanrnNotedetial_contain_main">
			<div class="pd_title"><h1>${lunaLog.title }</h1>
				<p class="time">${lunaLog.time }</p>
			</div>
			<div class="jianjie">
			<div class=" pd_p">
				<p>简介</p>
				<p>${lunaLog.introduction }</p>
			</div>
			</div>
			<div class="detial_contain">
				<div class="learnNotesomedetial">
				${lunaLog.contain}
				</div>
				</div>
		</div>
</body>
</html>