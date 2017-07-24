<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div >
<div class="nav_head">
			<div class="jidiao"></div>
			<a ui-sref=".me" ng-class="navClick==1?'dianji':''" ng-click="navClick=1"><img  src="img/nav_luna.png"/><p>my</p></a>
			<a ui-sref=".dance" ng-class="navClick==2?'dianji':''" ng-click="navClick=2"><img  src="img/nav_dance.png" /><p>舞蹈</p></a>
			<a ui-sref=".learnnote" ng-class="navClick==3?'dianji':''" ng-click="navClick=3"><img  src="img/nav_cos.png "/><p>学习笔记</p></a>
			<a ui-sref=".photo" ng-class="navClick==4?'dianji':''" ng-click="navClick=4"><img  src="img/nav_day.png "/><p>照片</p></a>
			<a ui-sref=".log" ng-class="navClick==5?'dianji':''" ng-click="navClick=5"><img  src="img/nav_journal.png "/><p>日志</p></a>
			<a ui-sref=".leavewords" ng-class="navClick==6?'dianji':''" ng-click="navClick=6"><img  src="img/nav_messageBoard.png "/><p>留言板</p></a>
			<a ui-sref=".handwork" ng-class="navClick==7?'dianji':''" ng-click="navClick=7"><img  src="img/nav_handmade.png "/><p>手工</p></a>
			<div style="clear: both;"></div>
		</div>
		</div>
		<div data-ui-view="" class="sonp-section sonp-small"></div>