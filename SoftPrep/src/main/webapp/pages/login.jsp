<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<main id="login" class="container"> 
	<div>
		<form role="form" action="spring_sec_auth.htm" method="post">
			<div class="form-group">
				<label for="name">UserName</label> <input type="text"
					class="form-control" name="username" />
			</div>
			<div class="form-group">
				<label for="pwd">Password</label> <input type="password"
					class="form-control" name="password" />
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		</form>
		<form role="form" action="linkedin" method="post">
			<div class="form-group">
				<button type="submit" class="btn btn-block">Login with
					LinkedIn</button>
			</div>
		</form>
		<form role="form" action="facebook" method="post">
			<div class="form-group">
				<button type="submit" class="btn btn-block">Login with
					FaceBook</button>
			</div>
		</form>
	</div>
	</main>
</body>
</html>