<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1 pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <meta http-equiv="content-type" content="text/html; charset=utf-8" /> -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/homepage.css" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/homepage.js"></script>
<title>DashBoard</title>
</head>
<body>
	<main id="homepage" class="container"> <header
		class="page-header">
		<!-- <span class="glyphicon glyphicon-user"></span> -->
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
		<div class="collapse navbar-collapse" id="activity-navbar-collapse">
			<ul class="nav nav-pills">
				<li><a id="questionbankref" href="#">Creation QuestionBank</a></li>
				<li><a id="streamref" href="#">Creation Stream</a></li>
				<li class="dropdown"><a id="questionref" href="#"
					class="dropdown-toggle" data-toggle="dropdown"> Create Question
						<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a id="binaryref" href="#">True/False</a></li>
						<li><a id="multichoiceref" href="#">Multiple-Choice</a></li>
						<li><a id="fillblankref" href="#">Fill in the Blank</a></li>
					</ul></li>
				<li><a id="taketestref" href="#">Take Test</a></li>
			</ul>
		</div>
		<section>
			<div id="landing" class="jumbotron">
				<h3>Welcome to UC APPs Forum</h3>
				<p>Here you can ask & answer questions related to UC Apps!!</p>
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
						<p class="help-block">Upload the Question bank(.xls,.xlsx)</p>
					</div>
					<button type="submit" class="btn btn-primary">Upload</button>
				</form>
			</div>
			<div id="topicform" style="display: none">
				<form role="form">
					<div class="form-group">
						<label for="stream">Name</label> <input type="text"
							class="form-control" style="width: 50%" name="stream"
							placeholder="Enter Name of Topic">
					</div>
					<div class="table-responsive">
						<table class="table" id="qbankstable">
							<caption>Select Question banks to add to new Stream</caption>
							<thead>
								<tr>
									<th><div class="checkbox">
											<label><input type="checkbox" value="">Select
												All</label>
										</div></th>
									<th>Question Bank</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="qbank" items="${qbankList}"
									varStatus="qbankLoopCount">
									<tr>
										<td><div class="checkbox">
												<input type="checkbox" value="">
											</div></td>
										<td><div class="checkbox">
												<input type="checkbox" value="">
											</div></td>
										<td>${qbank}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<button type="submit" class="btn btn-primary">Create
						Stream</button>
				</form>
			</div>
			<div id="binaryform" style="display: none">
				<form role="form" action="binary.htm" method="post">
					<div class="form-group">
						<label for="qbank">Question</label> <input type="text"
							class="form-control" style="width: 50%" name="qbank"
							placeholder="Enter Question Description">
					</div>
					<div class="form-group">
						<label for="qbankfile">File input</label> <input type="file"
							name="qbankfile">
					</div>
					<button type="submit" class="btn btn-primary">Create</button>
				</form>
			</div>

			<div id="multichoiceform" style="display: none">
				<form role="form" action="multichoice.htm" method="post">
					<div class="form-group">
						<label for="question">Question</label> <input type="text"
							class="form-control" style="width: 50%" name="question"
							placeholder="Enter Question Description" />
					</div>
					<div class="form-group">
						<label for="choices">Answer Choices</label> <input type="text"
							class="form-control" style="width: 50%" name="choices"
							placeholder="Enter Answer Choice" /> <br>
						<button id="addchoice" type="button"
							class="btn btn-primary btn-md">Add Choice</button>
					</div>
					<button type="submit" class="btn btn-primary">Create
						Question</button>
				</form>
			</div>
			<div id="fillblankform" style="display: none">
				<form role="form" action="fillblank.htm" method="post">
					<div class="form-group">
						<label for="question">Question</label> <input type="text"
							class="form-control" style="width: 50%" name="question"
							placeholder="Enter Question Description" />
					</div>
					<div class="form-group">
						<label for="answer">Answer</label> <input type="text"
							class="form-control" style="width: 50%" name="answer"
							placeholder="Enter Answer Description" />
					</div>
					<button type="submit" class="btn btn-primary">Create
						Question</button>
				</form>
			</div>
			<div id="examform" style="display: none">
                                
				<form role="form" action="practicetest.htm" method="post">
                                    <p><b/>Select Streams</p>
					<div class="form-group" id="streams">
						
						<!-- <label for="streamid">Stream</label> <input type="text"
							class="form-control" style="width: 50%" name="streamid"
							placeholder="Streams To Include" /> -->
					</div>
                                        <p>Number of Questions</p>
					<div class="form-group" id="questioncount">
						
						<!-- <label for="questioncount">Number of Questions in Exam</label> <input type="text"
							class="form-control" style="width: 50%" name="questioncount"
							/> -->
					</div>
                                        <p>Exam Duration(minutes)</p>
					<div class="form-group" id="examduration">
						
						<!-- <label for="examduration">Time Duration of Exam</label> <input type="text"
							class="form-control" style="width: 50%" name="examlength"
							/> -->
					</div>
					<button type="submit" class="btn btn-primary">Take Exam</button>
				</form>
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