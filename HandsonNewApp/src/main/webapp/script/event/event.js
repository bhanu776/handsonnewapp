var baseUrl = "/admin";
var childApp = angular.module("evenApp", ["ngTable", "bw.paging"]);

childApp.controller('eventCotroller', function ($scope, $http, NgTableParams) {

    var eventId;

    $scope.setEventId = (id) => {
        eventId = id;
    }

    $scope.init = () => {
    }

    $scope.tableParams = new NgTableParams({ count: 20 }, {
        counts: [], getData: function () {
            return callServerGetApi(baseUrl + "/event/list", "", "", $http, $scope);
        }
    });

    $scope.getEventDetail = () => {
        callServerGetApi(baseUrl + "/event/get/", eventId, "", $http, $scope)
            .then(function (success) {
                $scope.eventDetail = success;
                calculateEventAmount($scope);
            });
    }

    /* ====================================Event Transaction=================================================== */

    $scope.prepareTransactionDetail = () => {
        return eventTranData = {
            "event_id": $scope.eventDetail.id,
            "total_food_charge_child": $scope.eventDetail.no_of_children * $scope.eventDetail.food_par_head,
            "total_food_charge_adult": $scope.eventDetail.no_of_adults * $scope.eventDetail.food_par_head,
            "total_entry_charge_child": $scope.eventDetail.no_of_children * $scope.eventDetail.entry_charge_child,
            "total_entry_charge_adult": $scope.eventDetail.no_of_adults * $scope.eventDetail.entry_charge_adults,
            "playcost": 0,
            "miscellaneous": $scope.miscellaneous,
            "catering": $scope.canteenCharge,
            "cafe": $scope.eventDetail.id,
            "deposit": $scope.eventDetail.deposit,
            "total_charge": $scope.grandTotal,
            "gst": 0,
            "sub_total": $scope.grandTotal + $scope.extraSocks + $scope.miscellaneous + $scope.canteenCharge,
            "pay_amount": (($scope.grandTotal + $scope.extraSocks + $scope.miscellaneous + $scope.canteenCharge) - $scope.eventDetail.deposit),
            "return_amount": ($scope.eventDetail.deposit - ($scope.grandTotal + $scope.extraSocks + $scope.miscellaneous + $scope.canteenCharge))
        }
    }

    $scope.saveAndSettle = () => {
        callServerPostApi(baseUrl + "/event/transaction/save", "", $scope.prepareTransactionDetail(), $http, $scope)
            .then((success) => {
                if(success)
                $scope.tableParams = new NgTableParams({ count: 20 }, {
                    counts: [], getData: function () {
                        return callServerGetApi(baseUrl + "/event/list", "", "", $http, $scope);
                    }
                });
            });
    }

});

calculateEventAmount = ($scope) => {
    var details = $scope.eventDetail;
    $scope.totalChargeChildren = ((details.no_of_children * details.entry_charge_child) + (details.no_of_children * details.food_par_head));
    $scope.totalChargeAdults = ((details.no_of_adults * details.entry_charge_adults) + (details.no_of_adults * details.food_par_head));
    $scope.grandTotal = $scope.totalChargeAdults + $scope.totalChargeChildren + details.ground_rent;
}

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




/* ================================================== J Query ================================================ */

$(document).ready(() => {
    $(".pop-up-div").on('click', function () {
        $(".floating-form-div2").show("scale", 300);
    });

    $(".close-floating-div2").on('click', function () {
        $(".floating-form-div2").hide("scale", 300);
    });
});