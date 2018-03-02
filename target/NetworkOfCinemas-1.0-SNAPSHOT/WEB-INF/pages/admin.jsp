<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
</head>
<body>
<c:import url="head.jsp "/>
<a href="${pageContext.request.contextPath}/main/person/admin/addfilm">Add Film</a>
<br/>
<a href="${pageContext.request.contextPath}/main/person/admin/deletefilm">Delete Film</a>
<br/>
<a href="${pageContext.request.contextPath}/main/person/admin/addsession">Add Session</a>
<br/>
<a href="${pageContext.request.contextPath}/main/person/admin/deletesession">Delete Session</a>
<br/>
</body>
</html>
