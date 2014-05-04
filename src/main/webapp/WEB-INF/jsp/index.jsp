<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>
			Hello world!  
		</h1>
	
		<c:if test="${success eq true}">
			<label data-testid='success'>Album Succesfully Created</label>
		</c:if>
	
		<table>
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
		
		<P>  The time on the server is ${serverTime}. </P>
		<a href="album" data-testid="createAlbumLink" >Create Album</a>
	</body>
</html>
