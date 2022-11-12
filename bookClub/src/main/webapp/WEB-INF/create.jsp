<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Add a Book to Your Shelf!</h1>
		<a href="/">back to the shelves</a>
		<hr />
	</div>
	<div class = "form">	
		<form:form action="/books" method="post" modelAttribute="book">
<!-- 		Makes errors show up at top of the page -->
			<form:errors path="*"/>
			
			<p>
				<form:label path="title">Title</form:label>
<%-- 				<form:errors path="title" /> --%>
				<form:input path="title" />
			</p>
			<p>
				<form:label path="author">Author</form:label>
<%-- 				<form:errors path="author" /> --%>
				<form:textarea path="author" />
			</p>
			<p>
				<form:label path="description">My thoughts</form:label>
<%-- 				<form:errors path="description" /> --%>
				<form:input path="description" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>

