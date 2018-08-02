var childApp = angular.module("childApp", ["ngTable"]);

var childId;

childApp.controller('childController',function($scope,$http,NgTableParams){

	$scope.setChildId = function(id){
		childId = id;
	}
	
    $scope.tableParams = new NgTableParams({count:20}, {counts: [],
        getData: function() {
          // ajax request to api
          return  $http({
			        method : "GET",
			        url : "/admin/getchilddetails"
				    }).then(function mySuccess(response) {
				    	console.log(response.data);
				        return response.data;
				    }, function myError(response) {
				        $scope.error = response.statusText;
				    });
	        }
		  });
		  
	$scope.getChildDetails = function(){
		$http({
			method : "GET",
			url : "/admin/getchildinfo/"+childId
			}).then(function mySuccess(response) {
				console.log(response.data);
				$scope.childInfo = response.data;
			}, function myError(response) {
				$scope.error = response.statusText;
			});
	}
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

/* ==================================================Membership cost======================================= */

var membership = angular.module("membership",["ngTable"]);
membership.controller("membershipController",function($scope,$http,NgTableParams){

	var memberId;

	$scope.setMemberId = function(id){
		memberId = id;
	}

	$scope.getMemberDetail = function(){
		
		return  $http({
			method : "GET",
			url : "/admin/membership/get/"+memberId
			}).then(function mySuccess(response) {
				console.log(response.data);
				$scope.memberDetails = response.data;
			}, function myError(response) {
				$scope.error = response.statusText;
	});
	}

	$scope.tableParams = new NgTableParams({count:20}, {counts: [],
        getData: function() {
          // ajax request to api
          return  $http({
			        method : "GET",
			        url : "/admin/membership_list/get"
				    }).then(function mySuccess(response) {
				    	console.log(response.data);
				        return response.data;
				    }, function myError(response) {
				        $scope.error = response.statusText;
		    });
	    }
	});
});

$(document).ready(function(){

	$( "#search-child" ).autocomplete({
    	autoFocus:true,
        source: function(request, response) {
        	//console.log(request.term);
              $.ajax({
                  url: "/admin/search_child/"+request.term,
                  dataType: "json",
                  success: function( data, textStatus, jqXHR) {
                      var items={};	  
                      console.log(data);
                      $.each(data,function(key,value){
                      	items[value.id]=[value.firstname+" "+value.lastname];
                      	//console.log(data);
                      });
                      response($.map(items, function (value, key) {
                          return {
                              label: value[0],
                              value: function(event,ui){
                              	$("input[name=child_id]").val(key);
                              		return value[0];
                              	}
                          }
                      }));
                  },
                  error: function(jqXHR, textStatus, errorThrown){
                       console.log( textStatus);
                  }
              });
          }
    });

});
  
