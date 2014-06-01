<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header id="pageHeader">
	<div id="logo">Music Store</div>
	<nav id="topMenu">
		<ul>
			<li>
				<a href='<spring:url value="/"></spring:url>' data-testid="homeLink">Home</a>
			</li><li>
				<a href="album" data-testid="createAlbumLink">Create Album</a>
			</li><li>
				<a href="#">Link2</a>
			</li>
		</ul>
	</nav>
</header>