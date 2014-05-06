<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<%@ include file="includes/headTag.jsp" %>
	<body>	
		
		<div class="container">	
			<%@ include file="includes/navbar.jsp" %>

			<h2>Number of albums: ${fn:length(albums.source)}</h2>			
			<div class ="row">
					<table class="table table-striped">
						<tr>
							<th>Name</th>
							<th>Author</th>
							<th>Year Of Release</th>
						</tr>
						<c:forEach items="${albums.pageList}" var="album">
							<tr>
								<td><c:out value="${album.name}"></c:out></td>
								<td><c:out value="${album.author}"></c:out></td>
								<td><c:out value="${album.yearOfRelease}"></c:out></td>
							</tr>
						</c:forEach>		
					</table>					
			</div>
			<div class="row">
				<label class="col-sm-offset-10 col-sm-2">Page ${albums.page +1 } of ${albums.pageCount} </label>
				<ul class="pager">
					<c:if test="${!albums.firstPage}">
						<li><a href="${pageContext.request.contextPath}?page=previous">Previous</a></li>
					</c:if>
					<c:if test="${!albums.lastPage}">
						<li><a href="${pageContext.request.contextPath}?page=next">Next</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</body>
</html>
