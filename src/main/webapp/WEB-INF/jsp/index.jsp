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

<P>  The time on the server is ${serverTime}. </P>
<a href="album" data-testid="createAlbumLink" >Create Album</a>
</body>
</html>
