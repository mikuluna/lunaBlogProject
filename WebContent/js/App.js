
var myApp = angular.module("myApp", ['ui.router']);

myApp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.when("", "/PageTab/me");
	$stateProvider
		.state("PageTab", {
			url: "/PageTab",
			templateUrl: "view/frontview/nav.jsp"
			
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
		templateUrl: "view/frontview/handwork.jsp"
	});
});
myApp.controller('danceController', function($scope, $http){
	$http({
        method : 'POST',
        url:'http://localhost:8080/lunaBlogProject/getLunaDance.do?currentPage=1',
        headers : {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          }}).success(function (data) {
		$scope.lunadanceList = data;
		});
	
});
