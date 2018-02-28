<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<script type="text/javascript">
/* var source = new EventSource("/UCAppsForum/rest/userActivity");
source.onmessage = function(event) {
    document.getElementById("result").innerHTML += event.data + "<br>";
}; */
$(function(){
	//server sent event for user activity
	var source = new EventSource("/UCAppsForum/rest/userActivity");
	source.addEventListener("open", function (event) {
        $('#header').append('Latest 5 values');
    }, false);
	source.addEventListener("error", function (event) {
        if (event.eventPhase == EventSource.CLOSED) { :
             $('#footer').append('Connection Closed!'); }
    }, false);
	source.addEventListener("message", function (event) {
		data.push(event.data);
		var strData = '';
        for (var i = 0; i < data.length; i++) {
            strData += data[i] + '<br/>';
        }
        $('#activity').hide();
        $('#activity').empty();
        $('#activity').html(strData);
        $('#activity').slideDown(1000);
	},false);	
});
</script>
<div class="panel-heading">
	<h3 class="panel-title">User Activity</h3>
</div>
<div class="panel-body">
	<div>
		<div id="header"></div>
		<div id="activity"></div>
		<div id="footer"></div>
	</div>
</div>

