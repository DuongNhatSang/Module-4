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
    <title>Từ điển Anh-Việt</title>
</head>
<body>
<form method="post" action="/home">
    <table>
        <tr>
            <td>
                <p>Nhập</p>
            </td>
            <td>
                <input type="text" name="string" value="${string}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Dịch">
            </td>
        </tr>
  </table>

</form>
<h3>Kết quả: ${result}</h3>
</body>
</html>