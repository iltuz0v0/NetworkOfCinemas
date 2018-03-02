<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
</head>
<body>
<c:import url="head.jsp"/>
<h1>Films</h1>
<c:forEach var="film" items="${films}">
    <p>${film.id} ${film.title} ${film.ageLimit} ${film.description} ${film.premiere}</p>
</c:forEach>
<h1>Costs</h1>
<c:forEach var="cost" items="${costs}">
    <p>${cost.id} ${cost.filmKind} ${cost.cost} ${cost.displayDay}</p>
</c:forEach>
<h1>Halls</h1>
<c:forEach var="hall" items="${halls}">
    <p>${hall.id} ${hall.cinema.name} ${hall.hall.hallType} ${hall.hall.structure}</p>
</c:forEach>
<form:form action="/main/person/admin/addsession" modelAttribute="localSession" method="post">
    <form:label path="filmId">Film ID</form:label>
    <br/>
    <form:input path="filmId"/>
    <br/>
    <form:errors path="filmId" cssClass="wrong"/>
    <br/>
    <form:label path="costId">Cost ID</form:label>
    <br/>
    <form:input path="costId"/>
    <br/>
    <form:errors path="costId" cssClass="wrong"/>
    <br/>
    <form:label path="hallId">Hall ID</form:label>
    <br/>
    <form:input path="hallId"/>
    <br/>
    <form:errors path="hallId" cssClass="wrong"/>
    <br/>
    <label title="date">Date</label>
    <br/>
    <input name="date" type="date"/>
    <br/>
    ${fDate}
    <br/>
    <label title="startTime">Start time</label>
    <br/>
    <input name="startTime" type="time"/>
    <br/>
    ${f1Time}
    <br/>
    <label title="endTime">End time</label>
    <br/>
    <input name="endTime" type="time"/>
    <br/>
    ${f2Time}
    <br/>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>
