<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<!--中间内容部分开始-->
		<div class="hw_contain_main">
		<ul class="mydance">
		
		
				<li ng-repeat = "lunaHandWork in lunaHandWorklist" >
					<!--一个盒子-->
					<div class="dance_contain_my">
						<a href="{{lunaHandWork.handWorkUrl}}" target="view_window" class="dance_click" title="{{lunaHandWork.title}}">
						<div class="mydanceimg">
							<img src="<%=path %>/lunaimg/{{lunaHandWork.faceimg}}"/>
						</div>
						<div class="mydancetitle" >
							<h1>{{lunaHandWork.title}}</h1>
							<p>{{lunaHandWork.uploadDate}}</p>
						</div>
						
						</a>
					</div>
					<!--一个盒子结束-->
				</li>
				<div style="clear: both;"></div>
				<div class="jiazai {{hidden?'':'thishidden'}}"><a ng-click="addList()">加 载...</a></div>
				
				
			</ul>

		</div>
		<!--中间内容部分结束-->
