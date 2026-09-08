<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08/09/2026
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Product Detail</title>
    </head>
    <body>
        <h1>Product Detail</h1>
        <p>
            <strong>ID:</strong>
            ${product.id}
        </p>
        <p>
            <strong>Name:</strong>
            ${product.name}
        </p>
        <p>
            <strong>Price:</strong>
            ${product.price}
        </p>
        <br>
        <a href="${pageContext.request.contextPath}/products">
            Back to Product List
        </a>
    </body>
</html>
