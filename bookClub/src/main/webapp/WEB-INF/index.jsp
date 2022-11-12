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
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Welcome, [Name]</h1>
		<h3>Books from everyone's shelves</h3>
		<a href="/create">+ Add a book to my shelf!</a>
		
<!-- 	Flash message rendering -->
		<p>${success }</p>
		<hr />
<%-- 		${ alldabooks } --%>
		<table>
			<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Author Name</td>
					<td>Posted By</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ alldabooks }" var="b">
				<tr>
					<td>${ b.id }</td>
					<td>
						<a href="/books/${ b.id }">
							${ b.title }
						</a>
					</td>
					<td>${ b.author }</td>
					<td>poster name</td>
					<td>
						<button><a href="/edit/${b.id}">Edit</a></button>
						<form action="/books/${b.id}" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

