<h1>${param.name}‚ÌŒŸõŒ‹‰Ê</h1>
${requestScope.non}
<c:forEach var="wikiPage" items="${list}">
	<c:url value="/refer" var="url">
		<c:param name="name" value="${wikiPage.name}"/>
	</c:url>
	<li><a href="${url}">${wikiPage.name}</a><br>
</c:forEach>
