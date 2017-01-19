<%@ page pageEncoding="Windows-31J" language="java" contentType="text/html; charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Puchiwiki</title>
</head>
<body>
<div id="headd">
<%--ロゴ--%>
<a href="index.jsp"><img src="img/logo.gif"></a>

<%--ヘッダメニュー--%>
<a href="list">一覧</a>
|
<a href="create.jsp">新規</a>
|
<form action="search">
	検索<input type="text" name="name">
	<input type="submit" value="送信">
</form>
</div>
<%--メッセージ表示--%>
<p>${message}

<hr>
