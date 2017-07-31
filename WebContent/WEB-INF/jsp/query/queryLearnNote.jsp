<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/css/layui.css" />
</head>
<body>
<jsp:include page="/WEB-INF/jsp/backstagenav.jsp" flush="true"/>
<link rel="stylesheet" href="<%=path %>/css/style.css" />

<ul class="contain_ul">
				<li><a class="layui-btn layui-btn-normal layui-btn-radius" href="upIndexLearnNote.do?">全部</a></li>
				<li><a class="layui-btn layui-btn-normal layui-btn-radius" href="upIndexLearnNote.do?zoneId=1">Java基础</a></li>
				<li><a class="layui-btn layui-btn-normal layui-btn-radius" href="upIndexLearnNote.do?zoneId=2">后端框架</a></li>
				<li><a class="layui-btn layui-btn-normal layui-btn-radius" href="upIndexLearnNote.do?zoneId=3">SQL</a></li>
				<li><a class="layui-btn layui-btn-normal layui-btn-radius" href="upIndexLearnNote.do?zoneId=4">JSP</a></li>
				<li><a class="layui-btn layui-btn-normal layui-btn-radius" href="upIndexLearnNote.do?zoneId=5">JavaScript</a></li>
				<li><a class="layui-btn layui-btn-normal layui-btn-radius" href="upIndexLearnNote.do?zoneId=6">前端框架</a></li>
				<li><a class="layui-btn layui-btn-normal layui-btn-radius" href="upIndexLearnNote.do?zoneId=7">其他</a></li>
			</ul>

<div class="layui-form">
  <table class="layui-table">
    <colgroup>
      <col width="50">
      <col width="150">
      <col width="150">
      <col width="200">
      <col>
    </colgroup>
    <thead>
      <tr>
        <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
        <th>id</th>
        <th>分区</th>
        <th>标题</th>
        <th>简介</th>
        <th>上传时间</th>
        <th>是否删除</th>
      </tr> 
    </thead>
    <tbody>
    <c:if test="${not empty lulearnnoteList}">
    <c:forEach items="${lulearnnoteList}" var="lunaLearnNote">
      <tr>
        <td><input type="checkbox" name="" lay-skin="primary"></td>
        <td>${lunaLearnNote.id}</td>
        <td>${lunaLearnNote.zoneId}</td>
        <td>${lunaLearnNote.title}</td>
        <td>${lunaLearnNote.introduction}</td>
        <td>${lunaLearnNote.time}</td>
        <td><a href="deleteLearnNote.do?id=${lunaLearnNote.id}">删除</a></td>
      </tr>
     </c:forEach>
     
     </c:if>
    </tbody>
  </table>
</div>
</body>
</html>