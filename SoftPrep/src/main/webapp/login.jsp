<?xml version="1.0" encoding="ISO-8859-1" ?>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div>
		<form role="form" action="linkedin" method="post">
			<div class="form-group">
      			<label for="name">UserName</label>
      			<input type="text" class="form-control" id="name" name="username"/>
   			</div>
   			<div class="form-group">
      			<label for="pwd">Password</label>
      			<input type="password" class="form-control" id="pwd" name="password"/>
      			 <button type="submit" class="btn btn-default">Login with LinkedIn details</button>
   			</div>
		</form>
	
	</div>
</body>
</html>
