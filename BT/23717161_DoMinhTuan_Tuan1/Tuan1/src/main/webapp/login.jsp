<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17/08/2026
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <h3> <%= "Đăng nhập"%></h3>
    <br>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div>
            <label>Tên đăng nhập: </label>
            <input type="text" name="txtName">
        </div>
        <br>
        <div>
            <label>Mật khẩu: </label>
            <input type="password" name="txtPassword">
        </div>
        <br>
        <div>
            <input type="submit" value="Đăng nhập">
        </div>
    </form>
  </body>
</html>
