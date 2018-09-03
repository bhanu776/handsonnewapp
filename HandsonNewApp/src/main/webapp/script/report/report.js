var childVisitReport = angular.module("childVisitReport", ["ngTable", "bw.paging"]);

childVisitReport.controller('childVisitReportController', function ($scope, $http, NgTableParams) {

    $scope.date = new Date();


    $scope.init = function () {
        $scope.fromDate = new Date();
        $scope.toDate = new Date();

        $scope.tableParams = new NgTableParams({ count: 20 }, {
            counts: [],
            getData: function () {
                return callServerPostApi("/admin/report/child_visit_report/get", "", filter($scope.fromDate, $scope.toDate), $http, $scope);
            }
        });

    }

    $scope.applyDateFilter = () => {
        $scope.tableParams = new NgTableParams({ count: 20 }, {
            counts: [],
            getData: function () {
                return callServerPostApi("/admin/report/child_visit_report/get", "", filter($scope.fromDate, $scope.toDate), $http, $scope);
            }
        });
    }

});


/* ============================================ Child Visit Transaction ==================================== */

var childTransactionReport = angular.module("childTransactionReport", ["ngTable", "bw.paging"]);

childTransactionReport.controller('childTransactionReportController', function ($scope, $http, NgTableParams) {

    $scope.init = function () {
        $scope.fromDate = new Date();
        $scope.toDate = new Date();

        $scope.tableParams = new NgTableParams({ count: 20 }, {
            counts: [],
            getData: function () {
                return callServerPostApi("/admin/report/child_transaction_report/get", "", filter($scope.fromDate, $scope.toDate), $http, $scope);
            }
        });

        $scope.applyDateFilter = () => {
            $scope.tableParams = new NgTableParams({ count: 20 }, {
                counts: [],
                getData: function () {
                    return callServerPostApi("/admin/report/child_transaction_report/get", "", filter($scope.fromDate, $scope.toDate), $http, $scope);
                }
            });
        }

    }

});

/* ============================================ Utility Methods ========================================= */

callServerGetApi = (url, path_variable, request_data, $http, $scope) => {
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

callServerPostApi = (url, path_variable, request_data, $http, $scope) => {
    return $http({
        method: "POST",
        data: request_data,
        url: url + path_variable
    }).then(function mySuccess(response) {
        return response.data;
    }, function myError(response) {
        $scope.error = response.statusText;
    });
}

filter = (fromDate, toDate) => {
    return {
        "fromDate": fromDate,
        "toDate": toDate
    }
}