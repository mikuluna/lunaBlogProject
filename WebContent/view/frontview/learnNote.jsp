<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!--中间内容部分开始-->
		<div class="ln_contain_main">
		<div class="contain_course">
			<ul class="contain_ul">
				<li><a ng-click="queryLearnNote(zoneId=0)">全部</a></li>
				<li><a ng-click="queryLearnNote(zoneId=1)">Java基础</a></li>
				<li><a ng-click="queryLearnNote(zoneId=2)">后端框架</a></li>
				<li><a ng-click="queryLearnNote(zoneId=3)">SQL</a></li>
				<li><a ng-click="queryLearnNote(zoneId=4)">JSP</a></li>
				<li><a ng-click="queryLearnNote(zoneId=5)">JavaScript</a></li>
				<li><a ng-click="queryLearnNote(zoneId=6)">前端框架</a></li>
				<li><a ng-click="queryLearnNote(zoneId=7)">其他</a></li>
				<div style="clear: both;"></div>
			</ul>
		</div>
		<div class="search_contain">
			<div class="search_kong"></div>
			<form action="" method="post">
			<input type="text" placeholder="(oﾟ▽ﾟ)o请输入查找项ヾ(ﾟ∀ﾟゞ)" class="layui-input"/>
			<button type="submit" class="search_button">开始查找</button>
			</form>
			
		</div>
		<div class="contain_main">
				<ul class="contain_text_ul" id="learnNoteUl">
					<li ng-repeat="lunaLearnNote in lunaLearnNotelist">
					<a href="getLearnNoteDetial.do?id={{lunaLearnNote.id}}" target="view_window">
						<div class="contain_text_in">
						<h1>{{lunaLearnNote.title}}</h1>
						<p>{{lunaLearnNote.introduction}}</p>
						</div>
						</a>
					</li>
					
				</ul>
			</div>

		</div>
		<div class="jiazai {{hidden?'':'thishidden'}}" ><a  ng-click="addList()">加 载...</a></div>