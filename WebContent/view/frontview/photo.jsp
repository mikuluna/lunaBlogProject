<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
		<!--中间内容部分开始-->
		<div class="photo_contain_main">
			<ul id="danceul">
				<li class="photo" ng-repeat="lunaPhoto in lunaPhotolist">
					<a href="getPhotoDetial.do?id={{lunaPhoto.id}}" target="view_window">
						<div class="cover">
							<img class="coverphoto" src="<%=path %>/lunaimg/photos/{{lunaPhoto.imgFace}}" />
						</div>
						<div class="imgtitle">
							<h1>「{{lunaPhoto.title}}」</h1>
						</div>
					</a>
				</li>
				
				<div style="clear: both;"></div>
			</ul>
		</div>
		<div style="clear: both;"></div>
		<div class="jiazai {{hidden?'':'thishidden'}}" ><a  ng-click="addList()">加 载...</a></div>
				