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
        <th>标题</th>
        <th>地址</th>
        <th>图片</th>
        <th>上传时间</th>
        <th>是否删除</th>
      </tr> 
    </thead>
    <tbody>
    <c:if test="${not empty luhandList}">
    <c:forEach items="${luhandList}" var="lunaHandWork">
      <tr>
        <td><input type="checkbox" name="" lay-skin="primary"></td>
        <td>${lunaHandWork.id}</td>
        <td>${lunaHandWork.title}</td>
        <td>${lunaHandWork.handWorkUrl}</td>
        <td>${lunaHandWork.faceimg}</td>
        <td>${lunaHandWork.uploadDate }</td>
        <td><a href="deletehandWork.do?id=${lunaHandWork.id}">删除</a></td>
      </tr>
     </c:forEach>
     
     </c:if>
    </tbody>
  </table>
</div>
</body>
</html>