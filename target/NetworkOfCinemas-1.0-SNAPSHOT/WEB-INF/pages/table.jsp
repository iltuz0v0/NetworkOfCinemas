<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
</head>
<body>
<c:import url="head.jsp"/>
    <div>
        <c:forEach var="sessionsArray" items="${sessions}" varStatus="status">
            <p>${cinemas.get(status.index).name}</p>
            <br/>
            <c:forEach var="session" items="${sessionsArray}">
                <p>${session.session.startTime}
                    ${session.session.endTime}
                    ${session.session.product.cost.filmKind}
                    ${session.session.product.cost.cost}
                </p>
                <br/>
                </c:forEach>
            </c:forEach>
    </div>
</body>
</html>
