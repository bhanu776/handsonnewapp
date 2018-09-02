var childVisitReport = angular.module("childVisitReport", ["ngTable", "bw.paging"]);

childVisitReport.controller('childVisitReportController', function ($scope, $http, NgTableParams) {
    
    $scope.init = function () {
		$scope.tableParams = new NgTableParams({ count: 20 }, {
            counts: [],
            getData: function () {
               return callServerGetApi("/admin/report/child_visit_report/get","","",$http);
            }
        });
    
    }
});

/* ============================================ Utility Methods ========================================= */

callServerGetApi = (url, path_variable, request_data, $http) => {
    return $http({
        method: "GET",
        data: request_data,
        url: url + path_variable
    }).then(function mySuccess(response) {
        return response.data;
    }, function myError(response) {
        $scope.error = response.statusText;
    });
}