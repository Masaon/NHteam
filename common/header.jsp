<%@ page pageEncoding="Windows-31J" language="java" contentType="text/html; charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Puchiwiki</title>
</head>
<body>
<div id="headd">
<%--���S--%>
<a href="index.jsp"><img src="img/logo.gif"></a>

<%--�w�b�_���j���[--%>
<a href="list">�ꗗ</a>
|
<a href="create.jsp">�V�K</a>
|
<form action="search">
	����<input type="text" name="name">
	<input type="submit" value="���M">
</form>
</div>
<%--���b�Z�[�W�\��--%>
<p>${message}

<hr>
