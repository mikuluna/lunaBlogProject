<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${lunaPhoto.title}</title>
<link rel="stylesheet" href="<%=path %>/css/detial.css" />
<script src="<%=path %>/js/jquery.js"></script>	
	 <script type="text/javascript" src="<%=path %>/js/sonpScroll.js" ></script>
	 
</head>
<body>

<!--中间内容部分开始-->
		<div class="photodetial_contain_main sonp-section sonp-parallax">
			<div class="pd_title_photo"><h1>「${lunaPhoto.title}」</h1>
				<p class="time">${lunaPhoto.time}</p>
			</div>
			<div class=" pd_p">
				<p>${lunaPhoto.intro}</p>
			</div>
			</div>
			<c:if test="${not empty lunaPhoto.lunaphodet}">
			<c:forEach items="${lunaPhoto.lunaphodet}" var="photoDetial">
			<div class="photodetial_contain_main myphoto sonp-section sonp-parallax">
				<img src="<%=path %>/lunaimg/photos/${photoDetial.img }" />
			</div>
			</c:forEach>
			</c:if>
			
		
		<!--中间内容部分结束-->
	</body>
</html>