$(document).ready(function(){
    $( ".current-status-div" ).click(function( event ) {
        var attr = event.currentTarget.id;
        $( ".current-status-div" ).css( "height" , "30" );
        $( "#"+attr ).css("height","500");
      });
});

var dashboard = angular.module("dashboard",[]);
	dashboard.controller('dashboardController',function($scope, $http){
        
        $http({
            method : "GET",
            url : "checkedin_children/get"
            }).then(function mySuccess(response) {
                $scope.checkedinChildren = response.data;
            }, function myError(response) {
                $scope.error = response.statusText;
                $scope.childDetails=[];
            });
        
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
                 
