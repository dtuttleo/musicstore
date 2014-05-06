 <!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
 <html>
	<%@ include file="includes/headTag.jsp" %>
	<body>
		<div class="container">		
			<%@ include file="includes/navbar.jsp" %>
			<h1 class="col-sm-offset-5 col-sm-7">Create New Album</h1>
				 		
			<form:form modelAttribute="album" method="post" class="form-horizontal" role="form">
				<div class="form-group">
		 			<label for="albumName" class="col-sm-6 control-label">Album's name</label>
		 			<div class="col-sm-6">
						<form:input path="name" placeholder="Album's name" id="albumName" required="true"/>
						<form:errors path="name" />	 			
		 			</div>
				
				</div>
				<div class="form-group">
		 			<label for="author" class="col-sm-6 control-label">Author</label>
		 			<div class="col-sm-6">
						<form:input path="author" placeholder="Author" id="author" required="true"/>
						<form:errors path="author"  />	 			
		 			</div>
				
				</div>				
				<div class="form-group">
		 			<label for="yearOfRelease" class="col-sm-6 control-label">Year of release</label>
		 			<div class="col-sm-6">
						<form:input path="yearOfRelease" placeholder="Year of release" id="yearOfRelease" type="number" required="true"/>
						<form:errors path="yearOfRelease"  />	 			
		 			</div>
				
				</div>	
				<div class="form-group">
				    <div class="col-sm-offset-6 col-sm-6">
				      <button type="submit" class="btn btn-default">Create</button>
	    			</div>
					
				</div>	
					
			 </form:form>
			 <div class="row">			 	 			 			
				<c:if test="${success eq true}">
					<div class="alert alert-success col-sm-offset-4 col-sm-4" data-testid="success">Album Succesfully Created</div>
				</c:if>
			 </div>
		 </div>
	 </body>
 </html>