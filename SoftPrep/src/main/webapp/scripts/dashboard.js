/*
*All fucntions for dashboard.jsp
*
*/

$(function(){

	$('#questionbankref').on("click",function(){
		$(this).addClass("active");
		$('#landing').hide();
		$('section').find('.active').hide();
		$('#qbankform').show().addClass("active");
	});
	
	$('#streamref').on("click",function(){
		$(this).addClass("active");
		$('#landing').hide();
		$('section').find('.active').hide();
		$('#streamform').show().addClass("active");
	});
	
	$('#binaryref').on("click",function(){
		$('#landing').hide();
		$('section').find('.active').hide();
		$('#binaryform').show().addClass("active");
	});
	
	$('#multichoiceref').on("click",function(){
		$('#landing').hide();
		$('section').find('.active').hide();
		$('#multichoiceform').show().addClass("active");
	});
	
	$('#fillblankref').on("click",function(){
		$('#landing').hide();
		$('section').find('.active').hide();
		$('#fillblankform').show().addClass("active");
	});
	
	
});
