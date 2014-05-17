<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<%@ include file="includes/headTag.jsp" %>
	<body>	
	<%@ include file="includes/navbar.jsp" %>
	
		<section id="albumList">
			<header>
				<h3>Album List</h3>
			</header>	
			<article>
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
			</article>
			<footer>
				<nav>
					<c:if test="${!albums.firstPage}">
						<div class="nav_button">
							<a href="${pageContext.request.contextPath}?page=previous" >Previous</a>
						</div>
					</c:if>
					
					<c:if test="${!albums.lastPage}">
						<div class="nav_button">
							<a href="${pageContext.request.contextPath}?page=next" >Next</a>
						</div>
					</c:if>
					<label id="numberPages">Page ${albums.page +1 } of ${albums.pageCount} </label>
				</nav>
			</footer>
		</section>

		<section id="topList">
			<header>
				<h3>Album Ranking</h3>
			</header>
			<article>
	
				<ol>
					<li>albuuuum</li>
					<li>albuuuum</li>
					<li>albuuuum</li>
					<li>albuuuum</li>
					<li>albuuuum</li>
				</ol>
	
			</article>
		</section>
	
		<%@ include file="includes/footer.jsp" %>

	</body>

</html>
