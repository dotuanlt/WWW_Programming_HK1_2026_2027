<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17/08/2026
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Upload multi-files</title>
  </head>
  <body>
    <h2> <%= "Upload multi-files"%></h2>
    <br>
    <form action="${pageContext.request.contextPath}/uploadMulti" method="post" enctype="multipart/form-data">
        <div>
            <label>File #1: </label>
            <input type="file" name="file">
        </div>
        <br>
        <div>
            <label>File #2: </label>
            <input type="file" name="file">
        </div>
        <br>
        <div>
            <label>File #3: </label>
            <input type="file" name="file">
        </div>
        <br>
        <div>
            <label>File #4: </label>
            <input type="file" name="file">
        </div>
        <br>
        <div>
            <label>File #5: </label>
            <input type="file" name="file">
        </div>
        <br>
        <div>
            <input type="submit" value="Upload">
            <input type="reset" value="Reset">
        </div>
    </form>
  </body>
</html>
