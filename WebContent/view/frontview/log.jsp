<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<!--中间内容部分开始-->
		<div class="log_contain_main">
		<div class="search_contain">
			<div class="search_kong"></div>
			<form action="" method="post">
			<input type="text" placeholder="(oﾟ▽ﾟ)o请输入查找项ヾ(ﾟ∀ﾟゞ)" class="layui-input"/>
			<button type="submit" class="search_button">开始查找</button>
			</form>		
		</div>
		<div class="contain_main">
				<ul class="contain_text_ul" id="danceul">
					<li ng-repeat="lunaLog in lunaLoglist"><a href="#" >
						<div class="contain_text_in">
						<h1>{{lunaLog.title}}</h1>
						<p>{{lunaLog.introduction}}</p>
						</div>
						</a>
					</li>
				</ul>
			</div>
			
		</div>
		<div class="jiazai {{hidden?'':'thishidden'}}" ><a  ng-click="addList()">加 载...</a></div>
