var baseUrl = "/handson/admin";

$(document).ready(function () {
    $(".current-status-div").click(function (event) {
        var attr = event.currentTarget.id;
        $(".current-status-div").css("height", "31");
        $("#" + attr).css("height", "540");
        $("#" + attr).css("overflow-y", "auto");
    });
});

var dashboard = angular.module("dashboard", []);
dashboard.controller('dashboardController', function ($scope, $http, $interval) {

    $scope.currentActiveChildren = 0;

    $http({
        method: "GET",
        url: "checkedin_children/get"
    }).then(function mySuccess(response) {
        $scope.checkedinChildren = response.data;
        $scope.currentActiveChildren = response.data.length;
    }, function myError(response) {
        $scope.error = response.statusText;
        $scope.childDetails = [];
    })

    $interval(() => {
        $scope.checkedinChildren.forEach(d=>{
            var startDate = new Date(d.start_date);
            d.start_time = timedifference(startDate);
        });
    }, 1000);

    $scope.searchChild = function () {
        console.log($scope.keyword);
        $http({
            method: "GET",
            url: "search_child/" + $scope.keyword
        }).then(function mySuccess(response) {
            $scope.childDetails = response.data;
        }, function myError(response) {
            $scope.error = response.statusText;
            $scope.childDetails = [];
        });
    }
});

timedifference = (startDate) =>{
    var endDate = new Date();
    var milisecondsDiff = endDate - startDate;
      return Math.floor(milisecondsDiff/(1000*60*60)).toLocaleString(undefined, {minimumIntegerDigits: 2}) + ":" + (Math.floor(milisecondsDiff/(1000*60))%60).toLocaleString(undefined, {minimumIntegerDigits: 2})  + ":" + (Math.floor(milisecondsDiff/1000)%60).toLocaleString(undefined, {minimumIntegerDigits: 2}) ;  
}
