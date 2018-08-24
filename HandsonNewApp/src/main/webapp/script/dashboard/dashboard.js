$(document).ready(function(){
    $( ".current-status-div" ).click(function( event ) {
        var attr = event.currentTarget.id;
        $( ".current-status-div" ).css( "height" , "31" );
        $( "#"+attr ).css("height","540");
        $( "#"+attr ).css("overflow-y", "auto");
      });
});

var dashboard = angular.module("dashboard",[]);
	dashboard.controller('dashboardController',function($scope, $http, $interval){
        
        $interval(function(){
            $http({
                    method : "GET",
                    url : "checkedin_children/get"
                    }).then(function mySuccess(response) {
                        $scope.checkedinChildren = response.data;
                    }, function myError(response) {
                        $scope.error = response.statusText;
                        $scope.childDetails=[];
                    })
                },1000);
        
		$scope.searchChild = function(){
			console.log($scope.keyword);
			$http({
		        method : "GET",
		        url : "/admin/search_child/"+$scope.keyword
			    }).then(function mySuccess(response) {
			    	$scope.childDetails = response.data;
			    }, function myError(response) {
			        $scope.error = response.statusText;
			        $scope.childDetails=[];
			    });
        }
        
        
        
        
	});
                 
