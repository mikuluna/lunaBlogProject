<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
 
		<!--头部开始-->

		<!--头部结束-->
		<!--中间内容部分开始-->
		<div class="dance_contain_main">
			<ul class="mydance" id="danceul">
				<li ng-repeat="lunadance in lunadanceList">
					<!--一个盒子-->
					<div class="dance_contain_my">
						<a href="{{lunadance.danceUrl}}" class="dance_click" title="{{lunadance.danceTitle}}" target="view_window">
						<div class="mydanceimg">
							<img src="<%=path %>/upload/{{lunadance.imgFace}}"/>
						</div>
						<div class="mydancetitle" >
							{{lunadance.danceTitle}}
						</div>
						
						</a>
					</div>
					<!--一个盒子结束-->
				</li>
				</ul>
				<div style="clear: both;"></div>
				<div class="jiazai {{hidden?'':'thishidden'}}" ><a  ng-click="addList()">加 载...</a></div>
				
				
			

		</div>
		<!--中间内容部分结束-->
		<script>
		
		</script>
