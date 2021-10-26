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
    <title>Sandwich Condiments</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form method="post" action="/home">
    <table>
        <tr>
            <td>
                <input type="checkbox" name="lettuce" value="Lettuce"><span>Lettuce</span>
            </td>
            <td>
                <input type="checkbox" name="tomato" value="Tomato"><span>Tomato</span>
            </td>
            <td>
                <input type="checkbox" name="mustard" value="Mustard"><span>Mustard</span>
            </td>
            <td>
                <input type="checkbox" name="sprouts" value="Sprouts"><span>Sprouts</span>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit">
            </td>
        </tr>
  </table>

</form>
</body>
</html>