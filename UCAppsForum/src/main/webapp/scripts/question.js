/**
 * 
 */
/*var myTest=angular.module('myTest',[]);

myTest.controller('testController',[$scope,function($scope)
{
	
	
}]);*/


$(function (){
	
	
	$('#atable > tbody').on("click","button",function () {
        var id=$(this).attr('id');
        window.location.href='/UCAppsForum/answer.htm?answerId='+id;
	});
	
});