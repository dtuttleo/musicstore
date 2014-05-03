 <!DOCTYPE html>
 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
 <html>
 	<h1>Create New Album</h1>
 
	 <form:form modelAttribute="album" method="post">
	 	<label>Album's name</label>
		<form:input path="name" />
		<label>Author</label>
		<form:input path="author" />
		<label>Year of Release</label>
		<form:input path="yearOfRelease" />	
		<input type="submit" value="Send"> 
	 </form:form>
 
 </html>