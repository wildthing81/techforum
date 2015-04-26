<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Practice Test</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/realtest.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/timer.js"></script>
</head>
<body>
	<main id="realtest" class="container"> <header
		class="page-header">
		<span class="glyphicon glyphicon-user"></span>
		<ul class="thumbnails">
			<li class="span4">
				<div class="thumbnail">
					<img data-src="holder.js/300x200" alt="">
					<p>Admin User</p>
				</div>
			</li>
		</ul>
	</header>
	<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#activity-navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Activities</a>
		</div>
		<section>
			<div id="landing" class="jumbotron">
				<h3>Welcome to your Real Test</h3>
				<p>Click on Start to begin!!</p>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">START</button>
			</div>
			<div id="question" style="display: none">
				<form role="form" action="verifyans.htm" method="post">
					<div id="question"></div>
					<div class="col-lg-5">
						<label for="answer">Answer</label> <input type="text"
							class="form-control" name="answer" placeholder="Enter the Answer">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<div id="countdown" style="display: none">
				<span id="time"></span>
				<div class="alert alert-warning" style="display:none">Warning !You have less than 1 min</div>
				<div class="alert alert-danger" style="display:none">Sorry. Time is up!!!</div>
			</div>
			<div class="progress">
				<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60"
					aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
					<span class="sr-only">0% Complete</span>
				</div>
			</div>
		</section>
	</nav>
	<aside id="useractivity" class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">User Activity</h3>
		</div>
		<div class="panel-body">Panel content</div>
	</aside>
	</main>
</body>
</html>