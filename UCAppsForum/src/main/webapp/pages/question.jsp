<%-- <%@ page language="java"%> --%>
<!DOCTYPE html>
<html ng-app="myTest">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Practice Test</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/question.js"></script> --%>
</head>
<body ng-controller="questionController">
	<main id="question" class="container"> 
	<%@ include file="header.jsp" %>
		<nav class="navbar navbar-default" role="navigation">
			<!-- <div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#activity-navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Activities</a>
			</div> -->
			<section>
				<div id="landing" class="jumbotron">
					<h3></h3>
					<br><br>
					<div id="description">
						<input type="hidden" name="questid" value="${question.questionId}"/>
						<span><c:out value="${question.question}"/></span>
					</div>
				</div>
				<div>
					<form role="form" action="addanswer.htm" method="post">		
						<div class="form-group">
							<label for="question">My Answer</label>
							<textarea rows='6' cols='100'
								class="form-control" style="width: 50%" name="answer"
								placeholder="Please add your Answer..." required>
							</textarea>
						</div>
						<button type="submit" class="btn btn-primary">Submit Answer</button>
					</form>
				</div>
				<br>
				<br>
				<div id="feedback" style="display: none" class="col-lg-5">
					<form role="form" action="feedback.htm" method="post">
						<label for="feedback">Answer</label> <textarea type="text"
							class="form-control" name="feedback"
							placeholder="Enter your Feedback"/>
						<button type="submit" class="btn btn-primary">Feedback</button>
					</form>
				</div>
				<div id="countdown" style="display: none">
					<span id="time"></span>
					<div class="alert alert-warning" style="display:none">Warning !You have less than 1 min</div>
					<div class="alert alert-danger" style="display:none">Sorry. Time is up!!!</div>
				</div>
				<!-- <div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="60"
						aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
						<span class="sr-only">0% Complete</span>
					</div>
				</div> -->
			</section>
		</nav>
		<aside id="useractivity" class="panel panel-primary">
			<%@ include file="useractivity.jsp" %>
		</aside>
	</main>
</body>
</html>