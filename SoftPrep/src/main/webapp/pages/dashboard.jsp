<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/dashboard.css" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/dashboard.js"></script>
<title>DashBoard</title>
</head>
<body>
	<main id="dashboard" class="container"> <header
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
		<div class="collapse navbar-collapse" id="activity-navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a id="questionbankref" href="#">Creation QuestionBank</a></li>
				<li><a id="streamref" href="#">Creation Stream</a></li>
				<li class="active dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Create Question <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a id="binaryref" href="#">True/False</a></li>
						<li><a id="multichoiceref" href="#">Multiple-Choice</a></li>
						<li><a id="fillblankref" href="#">Fill in the Blank</a></li>
					</ul></li>
			</ul>
		</div>
		<section>
			<div id="landing" class="jumbotron">
				<h3>Welcome to your Dashboard</h3>
				<p>Here you can access all features!!</p>
			</div>
			<div id="qbankform" style="display: none">
				<form role="form" action="qbankupload.htm" method="post">
					<div class="col-lg-5">
						<label for="qbank">Name</label> <input type="text"
							class="form-control" name="qbank"
							placeholder="Enter Name of Question bank">
					</div>
					<div class="form-group">
						<label for="qbankfile">File input</label> <input type="file"
							name="qbankfile">
						<p class="help-block">Upload the Question bank(.xls,.xlsx)</p>
					</div>
					<!-- <div class="checkbox">
						<label> <input type="checkbox"> Check me out </label>
					</div> -->
					<button type="submit" class="btn btn-primary">Upload</button>
				</form>
			</div>
			<div id="streamform" style="display: none">
				<form role="form">
					<div class="col-lg-5">
						<label for="stream">Name</label> <input type="text"
							class="form-control" id="stream"
							placeholder="Enter Name of Stream">
					</div>
					<div class="table-responsive">
						<table class="table" id="qbankstable">
							<caption>Select Question banks to add to new Stream</caption>
							<thead>
								<tr>
									<th>No</th>
									<th>Question Bank</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="qbank" items="${qbankList}" varStatus="qbankLoopCount">
									<tr>
									    <td><div class="checkbox"><input type="checkbox" value=""></div></td>
										<td>${qbankLoopCount.count}</td>
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
			<div id="binaryform" style="display: none"></div>
			<div id="multichoiceform" style="display: none"></div>
			<div id="fillblankform" style="display: none"></div>
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