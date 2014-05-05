<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<title>Home</title>
		<spring:url value="/webjars/bootstrap/3.1.0/css/bootstrap.min.css" var="bootstrapCss"/>
 		<link rel="stylesheet" href="${bootstrapCss}">
	</head>
	<body>	
		
		<div class="container">	
			<%@ include file="includes/navbar.jsp" %>
		
			<c:if test="${success eq true}">
				<label data-testid='success'>Album Succesfully Created</label>
			</c:if>
			<h2>Number of albums: ${fn:length(albums)}</h2>			
			<div class ="row">
					<table class="table table-striped">
						<tr>
							<th>Name</th>
							<th>Author</th>
							<th>Year Of Release</th>
						</tr>
						<c:forEach items="${albums}" var="album">
							<tr>
								<td><c:out value="${album.name}"></c:out></td>
								<td><c:out value="${album.author}"></c:out></td>
								<td><c:out value="${album.yearOfRelease}"></c:out></td>
							</tr>
						</c:forEach>		
					</table>					
			</div>
		</div>
	</body>
</html>
