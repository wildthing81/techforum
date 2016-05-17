/*
*All fucntions for dashboard.jsp
*
*/

$(function(){

	$('#questionbankref').on("click",function(){
		$('section').find('.active').hide();
		$('#activity-navbar-collapse').find('.active').removeClass("active");
		$(this).addClass("active");
		$('#landing').hide();
		$('#qbankform').show().addClass("active");
	});
	
	$('#streamref').on("click",function(){
		$('section').find('.active').hide();
		$('#activity-navbar-collapse').find('.active').removeClass("active");
		$(this).addClass("active");
		$('#landing').hide();
		$('#streamform').show().addClass("active");
	});
	
	$('#binaryref').on("click",function(){
		$('section').find('.active').hide();
		$('#activity-navbar-collapse').find('.active').removeClass("active");
		$(this).addClass("active");
		$('#landing').hide();
		$('#binaryform').show().addClass("active");
	});
	
	$('#multichoiceref').on("click",function(){
		$('section').find('.active').hide();
		$('#activity-navbar-collapse').find('.active').removeClass("active");
		$(this).addClass("active");
		$('#landing').hide();
		$('#multichoiceform').show().addClass("active");
	});
	
	$('#fillblankref').on("click",function(){
		$('section').find('.active').hide();
		$('#activity-navbar-collapse').find('.active').removeClass("active");
		$(this).addClass("active");
		$('#landing').hide();
			
		$('#fillblankform').show().addClass("active");
	});
	
	$('#taketestref').on("click",function(){
		$('section').find('.active').hide();
		$('#activity-navbar-collapse').find('.active').removeClass("active");
		$(this).addClass("active");
		$('#landing').hide();
		 //Streams
		$.getJSON("lookup/getstreams.htm", function( data )
		{
			$.each(data,function(key,val){
				var streamcheckbox="<div class='checkbox'><label>" +
				"<input type='checkbox' value='"+key">"+val+"</label></div>";
				
				$("#taketestform streams").append(streamcheckbox);
			});
		});
		//questions count
		$.getJSON("lookup/questioncount.htm", function( data ){
			$.each(data,function(val){
				var radiocount="<div class='radio'><label>" +
				"<input type='radio' value='"+val">"+val+"</label></div>";
				
				$("#taketestform questioncount").append(radiocount);
			});
		});
		
		 //exam length
		$.getJSON("lookup/examduration.htm", function( data ){
			$.each(data,function(val){
				var radioduration="<div class='radio'><label>" +
				"<input type='radio' value='"+val">"+val+"</label></div>";
				
				$("#taketestform examduration").append(radioduration);
			});
			
		});
	
		$('#taketestform').show().addClass("active");
	});
	
	$('#addchoice').on("click",function(event){
		var choice="<input type='text' class='form-control' style='width:50%'" +
				"name='choices' placeholder='Enter Answer Choice'/><br>";
							
		$('#multichoiceform').find(".form-group:nth-child(2) br").last().after(choice);
	});
});
