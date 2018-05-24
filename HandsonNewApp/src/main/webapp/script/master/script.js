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
	
	$(".add-child-form").on('click',function(){
		$(".floating-form-div").show("scale",300);
	})
	
	$(".close-floating-div").on('click',function(){
		$(".floating-form-div").hide("scale",300);
	})
	
	
});