var childApp = angular.module("evenApp", ["ngTable","bw.paging"]);

childApp.controller('eventCotroller',function($scope,$http,NgTableParams){


    $scope.tableParams = new NgTableParams({ count:20 }, { counts: [], getData: function() {
		return $http({
                    method : "GET",
                    data:"",
                    url : "/admin/event/list"
                    }).then(function mySuccess(response) {
                        console.log(response.data);
                        return response.data;
                    }, function myError(response) {
                        $scope.error = response.statusText;
            });
    }
});
    

   callServerGetApi = function(url,path_variable,request_data){
        $http({
            method : "GET",
            data:request_data,
			url : url+path_variable
			}).then(function mySuccess(response) {
				console.log(response.data);
				$scope.memberDetails = response.data;
			}, function myError(response) {
				$scope.error = response.statusText;
	});
    }
});



