
var myApp = angular.module("myApp", ['ui.router']);

myApp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.when("", "/PageTab/me");
	$stateProvider
		.state("PageTab", {
			url: "/PageTab",
			templateUrl: "view/frontview/nav.jsp",
				controller:"mainController"
		})
		.state("PageTab.me", {
			url: "/me",
			templateUrl: "view/frontview/me.jsp"
		})
		.state("PageTab.dance", {
			url: "/dance",
			templateUrl: "view/frontview/dance.jsp",
			controller:"danceController"
			
		})
		.state("PageTab.learnnote", {
			url: "/learnNote",
			templateUrl: "view/frontview/learnNote.jsp"
		})
	.state("PageTab.photo", {
		url: "/photo",
		templateUrl: "view/frontview/photo.jsp"
	})
	.state("PageTab.log", {
		url: "/log",
		templateUrl: "view/frontview/log.jsp"
	})
	.state("PageTab.leavewords", {
		url: "/leavewords",
		templateUrl: "view/frontview/leavewords.jsp"
	})
	.state("PageTab.handwork", {
		url: "/handwork",
		templateUrl: "view/frontview/handwork.jsp",
		controller:"handWorkController"
	});
});
myApp.controller('mainController', function($scope){
	$scope.navClick=1;
});

myApp.controller('danceController', function($scope, $http){
	$scope.hidden=true;
	$http({
        method : 'POST',
        url:'getLunaDance.do?currentPage=1',
        headers : {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          }}).success(function (data) {
        	  if(data.length<9){
	        		 $scope.hidden=false;
	        	 }
		$scope.lunadanceList = data;
		
		});
	var currentPage=1;
	$scope.addList=function(){
		currentPage++;
		$http({
	        method : 'POST',
	        url:'getLunaDance.do?currentPage='+currentPage,
	        headers : {
	            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
	          }}).success(function (data) {
	        	 var appenddate="";
	        	 if(data.length<9){
	        		 $scope.hidden=false;
	        	 }
	        	 for(var i=0;i<data.length;i++){
	        		 appenddate=appenddate+'<li><div class="dance_contain_my">'
	        			 +'<a href="'+data[i].danceUrl+'" class="dance_click" title="'+data[i].danceTitle+'" target="view_window">'
	        			 +'<div class="mydanceimg"><img src="<%=path %>/upload/{{lunadance.imgFace}}"/>'
	        			 +'</div><div class="mydancetitle" >'+data[i].danceTitle+'</div></a></div></li>';
	        	 }
	        	 angular.element(document.querySelector('#danceul')).append(appenddate);					
	          });
	}	
});
//手工查看分页等
myApp.controller('handWorkController', function($scope, $http){
	$scope.hidden=true;
	$http({
        method : 'POST',
        url:'getLunaHandWork.do?currentPage=1',
        headers : {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          }}).success(function (data) {
        	  if(data.length<6){
	        		 $scope.hidden=false;
	        	 }
		$scope.lunaHandWorklist = data;
		
		});
	var currentPage=1;
	$scope.addList=function(){
		currentPage++;
		$http({
	        method : 'POST',
	        url:'getLunaHandWork.do?currentPage='+currentPage,
	        headers : {
	            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
	          }}).success(function (data) {
	        	 var appenddate="";
	        	 if(data.length<6){
	        		 $scope.hidden=false;
	        	 }
	        	 for(var i=0;i<data.length;i++){
	        		 appenddate=appenddate+'<li><div class="dance_contain_my">'
	        			 +'<a href="'+data[i].handWorkUrl+'" class="dance_click" title="'+data[i].title+'" target="view_window">'
	        			 +'<div class="mydanceimg"><img src="'+data[i].faceimg+'"/>'
	        			 +'</div><div class="mydancetitle" ><h1>'+data[i].danceTitle+'</h1><p>'+data[i].uploadDate+'</p></div></a></div></li>';
	        	 }
	        	 angular.element(document.querySelector('#danceul')).append(appenddate);					
	          });
	}	
});
