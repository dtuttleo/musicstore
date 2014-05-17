 <!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
 <html>
	<%@ include file="includes/headTag.jsp" %>
	<body>
		<%@ include file="includes/navbar.jsp" %>
		<section id="albumForm">
			<header> 
				<h1>Create New Album</h1>
			</header>
			<form:form modelAttribute="album" method="post" class="form-horizontal" role="form">
				<fieldset>
					<legend>Album information</legend>
					<div>
						<label for="albumName" >Album's name:</label>
						<form:input path="name" placeholder="Album's name" id="albumName" required="true" autofocus="true"/>
						<form:errors path="name" />			
					</div>
					<div>
						<label for="author" >Author:</label>
						<form:input path="author" placeholder="Author" id="author" required="true"/>
						<form:errors path="author"  />	
					</div>
					<div>
						<label for="yearOfRelease" class="col-sm-6 control-label">Year of release:</label>
						<form:input path="yearOfRelease" placeholder="Year of release" id="yearOfRelease" type="number" required="true"/>
						<form:errors path="yearOfRelease"  />
					</div>
					
					<button type="submit" >Create</button>
					
				</fieldset>
				<c:if test="${success eq true}">
					<div class="alert-success" data-testid="success">Album Succesfully Created</div>
				</c:if>
			</form:form>

		</section>
		
		<%@ include file="includes/footer.jsp" %>
		
	</body>
 </html>