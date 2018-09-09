var baseUrl = "/admin";
/* ==========================Add Child popup div========================================= */

$(document).ready(function () {
	$(".menu").mouseleave(function () {
		$(".menu").animate({ "margin-left": "-14%" }, 300);
		$(".menu-slide-button").animate({ "margin-left": "1%" }, 300);
	});

	$(".menu-slide-button, .menu").on('click', function () {
		$(".menu").animate({ "margin-left": "0" }, 300);
		$(".menu-slide-button").animate({ "margin-left": "15%" }, 300);
	});

	$(".menu").mouseenter(function (e) {
		/*console.log(e.pageX);
		if(e.pageX<5){*/
		$(".menu").animate({ "margin-left": "0" }, 300);
		$(".menu-slide-button").animate({ "margin-left": "15%" }, 300);
		/*}*/
	});

	$(".add-child-form, .update-child").on('click', function () {
		$(".floating-form-div").show("scale", 300);
	})

	$(".close-floating-div").on('click', function () {
		$(".floating-form-div").hide("scale", 300);
	})

	/* =======================================Advance Amount Page Checkbox Actions================================ */

	$("#playzone").click(function () {
		if (this.checked) {
			$("#library").prop("checked", false);
			$("#special").prop("checked", false);
			$("#visitor").prop("checked", false);
		}
	});

	$("#library").click(function () {
		console.log("click")
		if (this.checked) {
			$("#playzone").prop("checked", false);
			$("#special").prop("checked", false);
			$("#visitor").prop("checked", false);
		}
	});

	$("#special").click(function () {
		if (this.checked) {
			$("#library").prop("checked", false);
			$("#playzone").prop("checked", false);
			$("#visitor").prop("checked", false);
		}
	});

	$("#visitor").click(function () {
		if (this.checked) {
			$("#library").prop("checked", false);
			$("#playzone").prop("checked", false);
			$("#special").prop("checked", false);
		}
	});

	/* =================================== Sub menu ===================================================== */

	$("#report-menu").click(() => {
		$(".report-list").toggle();
	});

	

});

/*========================================Settings==================================================*/

var settingApp = angular.module("settingApp", ['ui.rCalendar']);

settingApp.controller("settingController", function ($scope, $http) {
	$scope.eventSource = [];

	$http({
		method: "GET",
		url: baseUrl+"/getsettings"
	}).then(function mySuccess(response) {
		console.log(response);
		return response.data;
	}, function myError(response) {
		$scope.error = response.statusText;
	});

	$http({
		method: "GET",
		url: baseUrl+"/get_calendar_holiday"
	}).then(function mySuccess(response) {
		$scope.eventSource = [];
		response.data.forEach(date => {
			var startDate = new Date(Date.UTC(date.yyyy, date.mm, date.dd));
			var endDate = new Date(Date.UTC(date.yyyy, date.mm, date.dd + 1));
			$scope.eventSource.push({ title: "event", startTime: startDate, endTime: endDate, allDay: true });
		});
	}, function myError(response) {
		$scope.error = response.statusText;
	});

	$scope.onTimeSelected = function (selectedTime, event) {
		console.log(selectedTime);
		$http({
			method: "GET",
			url: baseUrl+"/set_calendar_holiday/" + selectedTime
		}).then(function mySuccess(response) {
			$scope.eventSource = [];
			response.data.forEach(date => {
				var startDate = new Date(Date.UTC(date.yyyy, date.mm, date.dd));
				var endDate = new Date(Date.UTC(date.yyyy, date.mm, date.dd + 1));
				$scope.eventSource.push({ title: "event", startTime: startDate, endTime: endDate, allDay: true });
			});
		}, function myError(response) {
			$scope.error = response.statusText;
		});
	}

	$scope.$broadcast('eventSourceChanged', $scope.eventSource);

});








