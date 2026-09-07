<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17/08/2026
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <h2>Xin chào, ${sessionScope.user}</h2>
    <br>
    <a href= "${pageContext.request.contextPath}/secure/secret.jsp"> Trang bảo mật </a>
    <br>
    <a href= "${pageContext.request.contextPath}/logout"> Đăng xuất </a>

  </body>
</html>
