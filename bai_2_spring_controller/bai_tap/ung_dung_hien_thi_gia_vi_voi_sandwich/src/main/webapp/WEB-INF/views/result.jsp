<%--
  Created by IntelliJ IDEA.
  User: sf book
  Date: 10/26/21
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Selected List</title>
</head>
<body>
<h2>Selected List</h2>
<c:forEach items="${strings}" var="string">
    <p>${string}</p>
</c:forEach>
</body>
</html>
