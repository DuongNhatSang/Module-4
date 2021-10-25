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
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<form method="post" action="/home">
    <table>
        <tr>
            <td>
                <p>Nhập tỉ giá</p>
            </td>
            <td>
                <input type="number" name="tigia" value="${tigia}">
            </td>
        </tr>
        <tr>
            <td>
                <p>Nhập lượng USD chuyển đổi</p>
            </td>
            <td>
                <input type="number" name="luongusd" value="${luongusd}">
            </td>
         </tr>
        <tr>
            <td>
                <input type="submit">
            </td>
        </tr>
  </table>

</form>
<h3>Kết quả: ${ketqua}</h3>
</body>
</html>