var baseUrl = "/admin";

var childVisitReport = angular.module("childVisitReport", ["ngTable", "bw.paging"]);

childVisitReport.controller('childVisitReportController', function ($scope, $http, NgTableParams) {

    $scope.date = new Date();


    $scope.init = function () {
        $scope.fromDate = new Date();
        $scope.toDate = new Date();

        callServerGetApi(baseUrl+"/is_admin", "", "", $http, $scope).then((result)=>$scope.isAdmin = result);

        $scope.tableParams = new NgTableParams({ count: 20 }, {
            counts: [],
            getData: function () {
                return callServerPostApi(baseUrl+"/report/child_visit_report/get", "", filter($scope.fromDate, $scope.toDate), $http, $scope);
            }
        });

    }

    $scope.applyDateFilter = () => {
        $scope.tableParams = new NgTableParams({ count: 20 }, {
            counts: [],
            getData: function () {
                return callServerPostApi(baseUrl+"/report/child_visit_report/get", "", filter($scope.fromDate, $scope.toDate), $http, $scope);
            }
        });
    }

    $scope.deleteChildVisitDetail = (id) => {
        callServerGetApi(baseUrl+"/report/child_visit_report/delete/", id, "", $http, $scope)
        .then(() => {
            $scope.applyDateFilter();
        })
    }

});


/* ============================================ Child Visit Transaction ==================================== */

var childTransactionReport = angular.module("childTransactionReport", ["ngTable", "bw.paging"]);

childTransactionReport.controller('childTransactionReportController', function ($scope, $http, NgTableParams) {

    $scope.init = function () {
        $scope.fromDate = new Date();
        $scope.toDate = new Date();

        callServerGetApi(baseUrl+"/is_admin", "", "", $http, $scope).then((result)=>$scope.isAdmin = result);
        $scope.tableParams = new NgTableParams({ count: 20 }, {
            counts: [],
            getData: function () {
                return callServerPostApi(baseUrl+"/report/child_transaction_report/get", "", filter($scope.fromDate, $scope.toDate), $http, $scope);
            }
        });

    }
    
    $scope.applyDateFilter = () => {
        $scope.tableParams = new NgTableParams({ count: 20 }, {
            counts: [],
            getData: function () {
                return callServerPostApi(baseUrl+"/report/child_transaction_report/get", "", filter($scope.fromDate, $scope.toDate), $http, $scope);
            }
        });
    }

    $scope.deleteChildTransactionDetail = (id) => {
        callServerGetApi(baseUrl+"/report/child_transaction_report/delete/", id, "", $http, $scope)
        .then(() => {
            $scope.applyDateFilter();
        })
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