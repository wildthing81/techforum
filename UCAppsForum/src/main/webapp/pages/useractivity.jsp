<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<script type="text/javascript">
var source = new EventSource("/UCAppsForum/rest/userActivity");
source.onmessage = function(event) {
    document.getElementById("result").innerHTML += event.data + "<br>";
};
</script>
<div class="panel-heading">
	<h3 class="panel-title">User Activity</h3>
</div>
<div class="panel-body">
	<div id="result">
		
	</div>
</div>

