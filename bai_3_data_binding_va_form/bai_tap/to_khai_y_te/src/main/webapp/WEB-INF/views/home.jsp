<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form modelAttribute="toKhaiYTe" method="post" action="/home">
    <table>
        <tr>
            <th colspan="3">
                <h2>TỜ KHAI Y TẾ</h2>
                <h3>DAYAD LÀ TÀI LIỆU QUAN TRỌNG, THỒNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
                <p style="color: red">Khuyến cáo: khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
            </th>
        </tr>
        <tr>
            <td colspan="3">
                <p>Họ tên (ghi chữ IN HOA)<span style="color:red;">(*)</span></p>
                <form:input path="hoTen"/>
            </td>
        </tr>
        <tr>
            <td>
                <p>Năm sinh<span style="color:red;">(*)</span></p>
                <form:input path="namsinh"/>
            </td>
            <td>
                <p>Giới tính<span style="color:red;">(*)</span></p>
                <form:input path="gioiTinh"/>
            </td>
            <td>
                <p>Quốc tịch<span style="color:red;">(*)</span></p>
                <form:input path="quocTich"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <p>Thông tin đi lại<span style="color:red;">(*)</span></p>
                <form:radiobutton path="thongTinDiLai" value="taubay"/>Tàu bay
                <form:radiobutton path="thongTinDiLai" value="tauthuyen"/>Tàu Thuyền
                <form:radiobutton path="thongTinDiLai" value="oto"/>Ô tô
                <form:radiobutton path="thongTinDiLai" value="khac"/>Khác (ghi rõ)
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td>
                <p>Số hiệu phương tiện</p>
                <form:input path="soHieuPhuongTien"/>
            </td>
            <td>
                <p>Số ghế</p>
                <form:input path="soGhe"/>
            </td>
        </tr>
        <tr>
            <td>
                <p>Ngày khởi hành</p>
                <form:input path="ngayKhoiHanh"/>
            </td>
            <td>
                <p>Ngày kết thúc</p>
                <form:input path="ngayKetThuc"/>
            </td>
        </tr>
    </table>
<%--    <form:form modelAttribute="diaChiLienLac" method="post" action="/home">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td colspan="3">--%>
<%--                <p>Địa chỉ liên lạc</p>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <p>Tỉnh/Thành<span style="color:red;">(*)</span></p>--%>
<%--                <form:input path="tinhThanh"/>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <p>Quận/Huyện<span style="color:red;">(*)</span></p>--%>
<%--                <form:input path="quanHuyen"/>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <p>Phường/Xã<span style="color:red;">(*)</span></p>--%>
<%--                <form:input path="phuongXa"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    </form:form>--%>
    <table>
        <tr>
            <td colspan="2">
                <p>Địa chỉ nơi ở <span style="color:red;">(*)</span></p>
                <form:input path="diaChiNoiO"/>
            </td>
        </tr>
        <tr>
            <td>
                <p>Điện thoại <span style="color:red;">(*)</span></p>
                <form:input path="soDienThoai"/>
            </td>
            <td>
                <p>Email <span style="color:red;">(*)</span></p>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <p>Trong vòng 14 ngày qua, Anh/chị có thấy xuất hiện triệu chứng nào sau đây không <span style="color:red;">(*)</span></p>
            </td>
        </tr>
        <tr>
            <td>
                <p>Triệu chứng</p>
            </td>
            <td>
                <p>Có</p>
            </td>
            <td>
                <p>Không</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>Sốt <span style="color:red;">(*)</span></p>
            </td>
            <td>
                <form:radiobutton path="trieuChung" value="Sot"/>
            </td>
            <td>
                <form:radiobutton path="trieuChung" value=""/>
            </td>
        </tr>
    </table>
    <input type="submit" value="submit">
</form:form>
</body>
</html>