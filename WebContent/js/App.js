
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
			templateUrl: "view/frontview/learnNote.jsp",
			controller:"learnNoteController"
		})
	.state("PageTab.photo", {
		url: "/photo",
		templateUrl: "view/frontview/photo.jsp",
		controller:"photoController"
	})
	.state("PageTab.log", {
		url: "/log",
		templateUrl: "view/frontview/log.jsp",
		controller:"logController"
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
	var count = 1;
	$scope.addToBack=false;
	$scope.supOnclick=function(){
		count++;
		if(count==10){
			$scope.addToBack = true;
		}
	}
});

myApp.controller('danceController', function($scope, $http){
	$scope.navClick=2;
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
	        			 +'<div class="mydanceimg"><img src="/lunaimg/'+data[i].imgFace+'"/>'
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
	        			 +'<div class="mydanceimg"><img src="/lunaimg/'+data[i].faceimg+'"/>'
	        			 +'</div><div class="mydancetitle" ><h1>'+data[i].danceTitle+'</h1><p>'+data[i].uploadDate+'</p></div></a></div></li>';
	        	 }
	        	 angular.element(document.querySelector('#danceul')).append(appenddate);					
	          });
	}	
});
//学习笔记查看以及分页
myApp.controller('learnNoteController', function($scope, $http){
	var zoneId=0;
	var currentPage=1;
	$scope.hidden=true;
	$scope.hiddenUp=true;
	$http({
        method : 'POST',
        url:'getAllLearnNote.do?currentPage=1&zoneId='+zoneId,
        headers : {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          }}).success(function (data) {
        	  if(data.length<5){
	        		 $scope.hidden=false;
	        	 }
        	  else{
	        		 $scope.hidden=true;
	        	 }
		$scope.lunaLearnNotelist = data;
		});
	$scope.queryLearnNote=function(id){
		currentPage=1;
		var addlunaList = angular.element(".addlunaList");
		if(addlunaList.length>0){
			addlunaList.remove();
		}
		zoneId=id;
		$http({
	        method : 'POST',
	        url:'getAllLearnNote.do?currentPage=1&zoneId='+zoneId,
	        headers : {
	            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
	          }}).success(function (data) {
	        	  var ihaveit = angular.element(".ihaveit");
	        	  if($scope.hiddenUp||ihaveit.length!=5){
	        		  if(data.length!=5){
		        		 $scope.hidden=false;
		        	 }else{
		        		 $scope.hidden=true;
		        	 }
	        	  }else{
	        		  $scope.hidden=false;
	        	  }
			$scope.lunaLearnNotelist = data;
			});
	}
	
	
	$scope.addList=function(){
		currentPage++;
		$http({
	        method : 'POST',
	        url:'getAllLearnNote.do?currentPage='+currentPage+'&zoneId='+zoneId,
	        headers : {
	            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
	          }}).success(function (data) {
	        	 var appenddate="";
	        	 
	        	 if(data.length!=5){
	        		 $scope.hidden=false;
	        		 $scope.hiddenUp=false;
	        	 }
	        	 else{
	        		 $scope.hidden=true;
	        	 }
	        	
	        	 for(var i=0;i<data.length;i++){
	        		 appenddate=appenddate+'<li class="addlunaList">'
	        			 +'<a href="getLearnNoteDetial.do?id='+data[i].id+'"  target="view_window">'
	        			 +'<div class="contain_text_in">'
	        			 +'<h1>'+data[i].title+'</h1><p>'+data[i].introduction+'</p></div></a></li>';
	        	 }
	        	 angular.element(document.querySelector('#learnNoteUl')).append(appenddate);			
	          });
	}
	
});
//日志查看分页等
myApp.controller('logController', function($scope, $http){
	$scope.hidden=true;
	
	$http({
        method : 'POST',
        url:'getLunaLog.do?currentPage=1',
        headers : {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          }}).success(function (data) {
        	  if(data.length<4){
	        		 $scope.hidden=false;
	        	 }
		$scope.lunaLoglist = data;
		
		});
	var currentPage=1;
	$scope.addList=function(){
		currentPage++;
		$http({
	        method : 'POST',
	        url:'getLunaLog.do?currentPage='+currentPage,
	        headers : {
	            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
	          }}).success(function (data) {
	        	 var appenddate="";
	        	 if(data.length<4){
	        		 $scope.hidden=false;
	        	 }
	        	 for(var i=0;i<data.length;i++){
	        		 appenddate=appenddate+'<li>'
        			 +'<a href="getLogDetial.do?id='+data[i].id+'"  target="view_window">'
        			 +'<div class="contain_text_in">'
        			 +'<h1>'+data[i].title+'</h1><p>'+data[i].introduction+'</p></div></a></li>';
	        	 }
	        	 angular.element(document.querySelector('#danceul')).append(appenddate);					
	          });
	}	
});


//照片查看分页等
myApp.controller('photoController', function($scope, $http){
	$scope.hidden=true;
	$scope.navitClick=5;
	$http({
        method : 'POST',
        url:'getLunaPhoto.do?currentPage=1',
        headers : {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          }}).success(function (data) {
        	  if(data.length<6){
	        		 $scope.hidden=false;
	        	 }
		$scope.lunaPhotolist = data;
		
		});
	var currentPage=1;
	$scope.addList=function(){
		currentPage++;
		$http({
	        method : 'POST',
	        url:'getLunaPhoto.do?currentPage='+currentPage,
	        headers : {
	            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
	          }}).success(function (data) {
	        	 var appenddate="";
	        	 if(data.length<6){
	        		 $scope.hidden=false;
	        	 }
	        	 for(var i=0;i<data.length;i++){
	        		 appenddate=appenddate+'<li class="photo"><a href="getPhotoDetial.do?id='+data[i].id+'"><div class="cover">'
	        		 +'<img class="coverphoto" src="/upload/photos/'+data[i].imgFace
	        		 +'" /></div><div class="imgtitle"><h1>「'+data[i].title+'」</h1></div></a></li>'
	        	 }
	        	 angular.element(document.querySelector('#danceul')).append(appenddate);					
	          });
	}	
});


