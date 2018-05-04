<%-- <%@ page language="java"%> --%>
<!DOCTYPE html>
<html ng-app="myTest">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Question-${question.question}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/question.js"></script> --%>
</head>
<body ng-controller="questionController">
	<main id="question" class="container"> 
	<%@ include file="header.jsp" %>
		<nav class="navbar navbar-default" role="navigation">
			<section>
				<div id="landing" class="jumbotron">
					<div id="description">
						<span><c:out value="${question.question}"/></span>
					</div>
					<div>
						<form role="form" action="addAnswer.htm" method="post">		
							<div class="form-group">
								<!-- <label for="question">My Answer</label> -->
								<input type="hidden" name="questionId" value="${question.questionId}"/>
								<textarea rows='6' cols='100'
									class="form-control" style="width: 50%" name="answer"
									placeholder="Please add your Answer..." required>
								</textarea>
							</div>
							<button type="submit" class="btn btn-primary">Submit Answer</button>
						</form>
					</div>
				</div>	
				<br>
				<br>
				<!-- list of answers -->
				<div class="table-responsive">
					<table class="table" id="atable">
						<caption>Answers by other users</caption>
						<thead>
							<tr>
								<th style='text-align:center'>
								<div class="checkbox">
										<label><input type="checkbox" value="">Select
											All</label>
									</div></th>
								<th style='text-align:center'>User</th>
								<th style='text-align:center'>Answer</th>
								<th style='text-align:center'>Upvotes</th>
								<th style='text-align:center'>Comments</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${answers}" var="answer" varStatus="loop">
	  							<tr>
	  							   <td style='text-align:center'>
										<div class="checkbox">
											<label><input type="checkbox" value="">${loop.index}</label>
										</div>
									</td>
								   <td style='text-align:center'><c:out value="${answer.userName}" /></td>
								   <td style='text-align:center'><c:out value="${answer.answer}" /></td>
								   <td style='text-align:center'><c:out value="${answer.upvotes}" /></td>
								   <td style='text-align:center'><c:out value="${answer.comments}" /></td>
	  							</tr>
 							</c:forEach>
						</tbody>
					</table>
				</div>
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
			</section>
		</nav>
		<aside id="useractivity" class="panel panel-primary">
			<%@ include file="useractivity.jsp" %>
		</aside>
	</main>
</body>
</html>