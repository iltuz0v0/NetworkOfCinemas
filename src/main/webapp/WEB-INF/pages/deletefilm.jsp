<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
</head>
<body>
<c:import url="head.jsp"/>
<c:forEach var="film" items="${films}">
    <p>${film.id}</p>
    <p>${film.title}</p>
    <p>${film.ageLimit}</p>
    <p>${film.poster}</p>
    <p>${film.description}</p>
    <p>${film.premiere}</p>
    <a href="/main/person/admin/deletefilm/${film.id}">delete</a>
</c:forEach>
</body>
</html>
