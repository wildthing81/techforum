<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1 pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/homepage.css" />
<script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/homepage.js"></script>
<title>Your Forum Dashboard</title>
</head>
<body>
  <main id="homepage" class="container"> 
	<header class="page-header">
			<ul>
				<li class="span4">
					<div class="thumbnail">
						<!-- <img data-src="holder.js/300x200" alt=""> -->
						<p>Logged in as: <b><c:out value='${user}'/></b>
						   &nbsp;&nbsp;&nbsp;
						   Questions Asked: <b><c:out value='0' /></b>
						   &nbsp;&nbsp;&nbsp;
						   Questions Answered: <b><c:out value='0' /></b>
						   &nbsp;&nbsp;&nbsp;
						   Rank: <b><c:out value='100' /></b>
						   &nbsp;&nbsp;&nbsp;
						   <%-- Badges: <b><c:out value='0' /></b> --%>
						</p>
					</div>
				</li>
			</ul>
	</header>
	<nav class="navbar navbar-default" role="navigation">
		<div class="collapse navbar-collapse" id="activity-navbar-collapse">
			<ul class="nav nav-pills">
				<li><a id="questionbankref" href="#">Upload QuestionBank</a></li>
				<li><a id="topicref" href="#">Create Topic</a></li>
				<li><a id="questionref" href="#"> Add Your Question
<!-- 						<b class="caret"></b> -->
				</a></li>
				<!-- <li><a id="taketestref" href="#">Take Test</a></li> -->
			</ul>
		</div>
		<section>
			<div id="landing" class="jumbotron">
				<h3>Welcome to UC Server APPs Forum</h3>
				<p>Here you can ask & answer questions related to UC Server Apps...</p>
			</div>
			<div id="qbankform" style="display: none">
				<form role="form" action="qbankupload.htm" method="post">
					<div class="form-group">
						<label for="qBankName">Name</label> <input type="text"
							class="form-control" style="width: 50%" name="qBankName"
							placeholder="Enter Name of Question bank">
					</div>
					<div class="form-group">
						<label for="qbankFile">File input</label> <input type="file"
							name="qbankFile">
						<p class="help-block">Upload the file(.xls,.xlsx)</p>
					</div>
					<button type="submit" class="btn btn-primary">Upload</button>
				</form>
			</div>
			<div id="topicform" style="display: none">
				<form role="form">
					<div class="form-group">
						<label for="stream">Name</label> <input type="text"
							class="form-control" style="width: 50%" name="topic"
							placeholder="Enter Name of Topic">
					</div>
					
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<div id="questionform" style="display: none">
				<form role="form" action="addQuestion.htm" method="post">
					<div class="form-group">
						<label for="question">Question</label> 
						<textarea rows='6' cols='100'
							class="form-control" style="width: 50%" name="question"
							placeholder="Please add your Question..." required>
						</textarea>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<!-- list of questions -->
			<div class="table-responsive">
						<table class="table" id="qtable">
							<caption>Select Questions to add to Topic or Answer</caption>
							<thead>
								<tr>
									<th style='text-align:center'>
									<div class="checkbox">
											<label><input type="checkbox" value="">Select
												All</label>
										</div></th>
									<th style='text-align:center'>Questions</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%-- <c:forEach var="question" items="${questionList}"
									varStatus="qLoopCount"> --%>
								<%-- </c:forEach> --%>
							</tbody>
						</table>
			</div>
			<!-- statuses -->
			<c:if test="${uploadstatus=='upload success'}">
				<div class="alert alert-success">Success! Well done its
					submitted.</div>
			</c:if>
			<c:if test="${uploadstatus=='upload error'}">
				<div class="alert alert-danger">Error ! Correct the invalid
					Questions!!</div>
			</c:if>
			<div class="alert alert-info" style="visibility: hidden">Info!
				take this info.</div>
			<c:if test="${uploadstatus=='fileaccess error'}">
				<div class="alert alert-warning">Warning !Unable to access
					Upload File.</div>
			</c:if>
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