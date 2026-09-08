<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08/09/2026
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Edit Product</title>
  </head>
  <body>
    <h1>Edit Product</h1>

    <form action="${pageContext.request.contextPath}/products" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${product.id}">
        <p>
            Name:
            <input type="text" name="name" value="${product.name}">
        </p>
        <p>
            Price:
            <input type="number" name="price" step="0.01" value="${product.price}">
        </p>
        <button type="submit"> Update </button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/products"> Cancel </a>
  </body>
</html>
