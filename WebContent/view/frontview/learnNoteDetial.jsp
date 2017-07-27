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
<link rel="stylesheet" href="<%=path %>/css/detial.css" />
</head>
<body>
<div class="leanrnNotedetial_contain_main">
			<div class="pd_title"><h1>${lunaLearnNote.title }</h1>
				<p class="time">${lunaLearnNote.time }</p>
			</div>
			<div class="jianjie">
			<div class=" pd_p">
				<p>简介</p>
				<p>${lunaLearnNote.introduction }</p>
			</div>
			</div>
			<div class="detial_contain">
				<div class="learnNotesomedetial">
				${lunaLearnNote.contain}
				</div>
				</div>
		</div>
</body>
</html>