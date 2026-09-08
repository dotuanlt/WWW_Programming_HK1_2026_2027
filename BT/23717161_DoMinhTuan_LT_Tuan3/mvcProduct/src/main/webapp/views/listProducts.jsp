<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08/09/2026
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Product List</title>
    </head>
    <body>
        <h1>Product List</h1>

        <table border="1">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Function</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${products}" var="pro">
                <tr>
                    <td>${pro.id}</td>
                    <td>${pro.name}</td>
                    <td>${pro.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/products?action=detail&id=${pro.id}"> Detail </a>
                        |
                        <a href="${pageContext.request.contextPath}/products?action=edit&id=${pro.id}"> Edit </a>
                        |
                        <a href="${pageContext.request.contextPath}/products?action=delete&id=${pro.id}"
                            onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?')"> Delete </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>