$(document).ready(function(){
	$(".menu").mouseleave(function(){
		$(".menu").animate({"margin-left":"-14%"}, 300);
		$(".menu-slide-button").animate({"margin-left":"1%"},300);
	});
	
	$(".menu-slide-button, .menu").on('click',function(){
		$(".menu").animate({"margin-left":"0"}, 300);
		$(".menu-slide-button").animate({"margin-left":"15%"},300);
	});
	
	$(".menu").mouseenter(function(e){
		/*console.log(e.pageX);
		if(e.pageX<5){*/
			$(".menu").animate({"margin-left":"0"}, 300);
			$(".menu-slide-button").animate({"margin-left":"15%"},300);
		/*}*/
	});
	
	$(".add-child-form, .update-child").on('click',function(){
		$(".floating-form-div").show("scale",300);
	})
	
	$(".close-floating-div").on('click',function(){
		$(".floating-form-div").hide("scale",300);
	})
	
	
});


/*========================================Settings==================================================*/

var settingApp = angular.module("settingApp",[]);
settingApp.controller("settingController",function($scope,$http){
	$http({
        method : "GET",
        url : "/admin/getsettings"
	    }).then(function mySuccess(response) {
	    	console.log(response);
	        return response.data;
	    }, function myError(response) {
	        $scope.error = response.statusText;
	    });
});



$(document).ready(function(){
	$("#playzone").click(function(){
		 if(this.checked) {
			$("#library").prop("checked", false);
			$("#special").prop("checked", false);
			$("#visitor").prop("checked", false);
		 }
	});

	$("#library").click(function(){
		console.log("click")
		 if(this.checked) {
		$("#playzone").prop("checked", false);
		$("#special").prop("checked", false);
		$("#visitor").prop("checked", false);
		}
	});

	$("#special").click(function(){
	 if(this.checked) {
		$("#library").prop("checked", false);
		$("#playzone").prop("checked", false);
		$("#visitor").prop("checked", false);
		}
	});
	
	$("#visitor").click(function(){
	 if(this.checked) {
		$("#library").prop("checked", false);
		$("#playzone").prop("checked", false);
		$("#special").prop("checked", false);
		}
	});
});







