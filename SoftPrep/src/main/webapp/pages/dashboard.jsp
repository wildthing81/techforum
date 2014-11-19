<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dashboard.css" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/scripts/dashboard.js"></script>
<title>DashBoard</title>
</head>
<body>
	<main id="dashboard" >
		<header class="page-header">
			 <span class="glyphicon glyphicon-user"></span>
		</header>
		<nav  class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" 
		         data-target="#activity-navbar-collapse">
			         <span class="sr-only">Toggle navigation</span>
			         <span class="icon-bar"></span>
			         <span class="icon-bar"></span>
			         <span class="icon-bar"></span>
		        </button>
      			<a class="navbar-brand" href="#">Activities</a>
  			</div>
  			<div class="collapse navbar-collapse" id="activity-navbar-collapse">
  				 <ul class="nav navbar-nav">
  				 	<li><a href="#">Creation QuestionBank</a></li>
        			<li><a href="#">Creation Stream</a></li>
         			<li class="active dropdown">
         				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
         					Create Question
         					 <b class="caret"></b>
         				</a>
         				<ul class="dropdown-menu">
			               <li><a href="#">True/False</a></li>
			               <li><a href="#">Multiple-Choice</a></li>
			               <li><a href="#">Fill in the Blank</a></li>
			            </ul>
         			</li>			
        		</ul>
        	</div>
		</nav>
		<section>
			
			<div class="alert alert-success">Success! Well done its submitted.</div>
			<div class="alert alert-danger">Error ! Change few things.</div>
			<div class="alert alert-info">Info! take this info.</div>
			<div class="alert alert-warning">Warning ! Dont submit this.</div>
		</section>
		<aside></aside>
	</main>
</body>
</html>