 <!DOCTYPE html>
 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
 <html>
 	<head>
 	<spring:url value="/webjars/bootstrap/3.1.0/css/bootstrap.min.css" var="bootstrapCss"/>
 	<link rel="stylesheet" href="${bootstrapCss}">
 	</head>
	<body>
		<h1 class="col-sm-offset-5 col-sm-7">Create New Album</h1>
	 
	 		
		<form:form modelAttribute="album" method="post" class="form-horizontal" role="form">
			<div class="form-group">
	 			<label for="albumName" class="col-sm-6 control-label">Album's name</label>
	 			<div class="col-sm-6">
					<form:input path="name" placeholder="Album's name" id="albumName" required="true"/>
					<form:errors path="name" class="help-inline" />	 			
	 			</div>
			
			</div>
			<div class="form-group">
	 			<label for="author" class="col-sm-6 control-label">Author</label>
	 			<div class="col-sm-6">
					<form:input path="author" placeholder="Author" id="author" required="true"/>
					<form:errors path="author" class="help-inline" />	 			
	 			</div>
			
			</div>				
			<div class="form-group">
	 			<label for="yearOfRelease" class="col-sm-6 control-label">Year of release</label>
	 			<div class="col-sm-6">
					<form:input path="yearOfRelease" placeholder="Year of release" id="yearOfRelease" type="number" required="true"/>
					<form:errors path="yearOfRelease" class="help-inline" />	 			
	 			</div>
			
			</div>	
			<div class="form-group">
			    <div class="col-sm-offset-6 col-sm-6">
			      <button type="submit" class="btn btn-default">Create</button>
    			</div>
				
			</div>	
				
		 </form:form>
	 </body>
 </html>