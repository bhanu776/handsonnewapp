$(document).ready(function(){
  /*  $( "#search-box" ).autocomplete({
    	autoFocus:true,
        source: function(request, response) {
        	console.log(request.term);
              $.ajax({
                  url: "/admin/search_child",
                  dataType: "json",
                  data: 'keyword='+request.term,
                  success: function( data, textStatus, jqXHR) {
                      var items={};	  
                      console.log(data);
                      $.each(data,function(key,value){
                      	items[value.id]=[value.firstname+" "+value.lastname];
                      	console.log(data);
                      });
                      response($.map(items, function (value, key) {
                          return {
                              label: value[0],
                              value: function(event,ui){
                              	//$("input[name=child_id]").val(key);
                              		return value[0];
                              	}
                          }
                      }));
                  },
                  error: function(jqXHR, textStatus, errorThrown){
                       console.log( textStatus);
                  }
              });
          }
    });
*/
	  $("#search-box").on('keyup',function(event){
		  $.ajax({
              url: "/admin/search_child",
              dataType: "json",
              data: 'keyword='+$("#search-box").val(),
              success: function( data, textStatus, jqXHR) {
                  console.log(data);
              }
		  });
	  });
                 
        
});