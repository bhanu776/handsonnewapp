var baseUrl = "/admin";
var childApp = angular.module("evenApp", ["ngTable", "bw.paging"]);

childApp.controller('eventCotroller', function ($scope, $http, NgTableParams) {

    var eventId;

    $scope.setEventId = (id) => {
        eventId = id;
    }


    $scope.tableParams = new NgTableParams({ count: 20 }, {
        counts: [], getData: function () {
            return callServerGetApi(baseUrl+"/event/list", "", "", $http, $scope);
        }
    });

    $scope.getEventDetail = () => {
        callServerGetApi(baseUrl+"/event/get/", eventId, "", $http, $scope)
            .then(function (success) {
                $scope.eventDetail = success;
            });
    }

});


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
