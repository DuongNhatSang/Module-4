<%--
  Created by IntelliJ IDEA.
  User: sf book
  Date: 10/25/21
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h2>Caculator</h2>
<form method="post" action="/home">
    <table>
        <tr>
            <td colspan="2">
                <input type="number" name="numberone" value="${numberone}" required>
            </td>
            <td colspan="2">
                <input type="number" name="numbertwo" value="${numbertwo}" required>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="operator" value="Addition(+)">
            </td>
            <td>
                <input type="submit" name="operator" value="Subtraction(-)">
            </td>
            <td>
                <input type="submit" name="operator" value="Multiplication(X)">
            </td>
            <td>
                <input type="submit" name="operator" value="Division(/)">
            </td>
        </tr>
    </table>
    <h3>${result}</h3>

</form>
</body>
</html>