<%@ page pageEncoding="Windows-31J" language="java" contentType="text/html; charset=Windows-31J" %>

<H1>ページの一覧</H1>

<c:forEach var="wikiPage" items="${list}">
	<c:url value="/refer" var="url">
		<c:param name="name" value="${wikiPage.name}"/>
	</c:url>
	<LI><A HREF="${url}">${wikiPage.name}</A></BR>
</c:forEach>
