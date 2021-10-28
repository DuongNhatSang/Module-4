<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sf book
  Date: 10/25/21
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h2>Settings</h2>
<form:form modelAttribute="configuration" method="post" action="/update">
    <table>
        <tr>
            <td>
                <form:hidden path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <p>Language: </p>
            </td>
            <td>
                <form:select path="languages" items="${languageList}"/>
            </td>
        </tr>
        <tr>
            <td>
                <p>Page size: </p>
            </td>
            <td>
                <span>Show </span><form:select path="pageSize" items="${pageSizeList}"/><span> Email per page</span>
            </td>
        </tr>
        <tr>
            <td>
                <p>Spams filter: </p>
            </td>
            <td>
                <form:checkbox path="spamsFilter" value="${configuration.spamsFilter}"/>
            </td>
        </tr>
        <tr>
            <td>
                <p>Signature: </p>
            </td>
            <td>
                <form:textarea path="signature" title="${configurationList.signature}"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
            <td>
                <input type="button" value="Cancel">
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>