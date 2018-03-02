<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
</head>
<body>
<c:import url="head.jsp"/>
<form action="${pageContext.request.contextPath}/main/choice" method="post">
    <select size="2" name="choice">
        <option disabled>Choose city</option>
        <option value="Moscow">Moscow</option>
        <option value="Volgograd">Volgograd</option>
    </select>
    <br/>
    <button type="submit" class="accept">Accept</button>
    <br/>
</form>
</body>
</html>
