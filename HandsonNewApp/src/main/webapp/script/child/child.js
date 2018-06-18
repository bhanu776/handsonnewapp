var childApp = angular.module("childApp", ["ngTable"]);

childApp.controller('childController',function($scope,$http,NgTableParams){
	$scope.firstName = "Shanu";
	
    $scope.tableParams = new NgTableParams({count:20}, {counts: [],
        getData: function() {
          // ajax request to api
          return  $http({
			        method : "GET",
			        url : "/admin/getchilddetails"
				    }).then(function mySuccess(response) {
				    	console.log(response);
				        return response.data;
				    }, function myError(response) {
				        $scope.error = response.statusText;
				    });
	        }
	      });
	
});

/*	childApp.directive('fixedTableHeaders', ['$timeout', function($timeout) {
	  return {
	    restrict: 'A',
	    link: function(scope, element, attrs) {
	      $timeout(function () {
	          container = element.parentsUntil(attrs.fixedTableHeaders);
		        element.stickyTableHeaders({ scrollableArea: container, "fixedOffset": 2 });
	      }, 0);
	    }
	  }
	}]);*/



/*=========================================================Advance ampont page==================================================================*/

var advanceAmount = angular.module("advanceAmount",[]);
advanceAmount.controller('advanceAmountController',function($scope,$http){
	$http({
        method : "GET",
        url : "/admin/getsettings"
	    }).then(function mySuccess(response) {
	    	console.log(response);
	    	$scope.settings = response.data;
	    }, function myError(response) {
	        $scope.error = response.statusText;
	    });
});


/*=========================================================PlayZone Billing Page==================================================================*/

var playzonebilling = angular.module("playzonebilling",[]);
playzonebilling.controller("playzoneBillingController",function($scope,$http){
	/*$http({
        method : "GET",
        url : "/admin/playzonebillingdetails"
	    }).then(function mySuccess(response) {
	    	console.log(response);
	    	$scope.settings = response.data;
	    }, function myError(response) {
	        $scope.error = response.statusText;
	    });*/
});

