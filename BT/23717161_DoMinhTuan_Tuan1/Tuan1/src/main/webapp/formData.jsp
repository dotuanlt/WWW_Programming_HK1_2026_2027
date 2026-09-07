<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/17/2026
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Data</title>
</head>
<body>
<h3> <%= "HTML Form Example with File Upload"%></h3>
<br>
<form action="${pageContext.request.contextPath}/formServlet"
      method="post"
      enctype="multipart/form-data">
    <div>
        <label>Name: </label>
        <input type="text" name="txtName">
    </div>
    <br>
    <div>
        <label>Password: </label>
        <input type="password" name="txtPassword">
    </div>
    <br>
    <div>
        <label>Gender: </label>
        <input type="radio" name="rdGender" value="male">
        <label> Male </label>
        <input type="radio" name="rdGender" value="female">
        <label> Female </label>
    </div>
    <br>
    <div>
        <label>Hobbies: </label>
        <input type="checkbox" name="ckHobby" value="reading">
        <label>Reading</label>
        <input type="checkbox" name="ckHobby" value="sports">
        <label>Sports</label>
        <input type="checkbox" name="ckHobby" value="music">
        <label>Music</label>
    </div>
    <br>
    <div>
        <label>Country: </label>
        <select name="cbmCountry">
            <option value="VietNam">Vietnam</option>
            <option value="American">American</option>
            <option value="Singapo">Singapo</option>
        </select>
    </div>
    <br>
    <div>
        <label>Birth Date: </label>
        <input type="date" name="birthDate">
    </div>
    <br>
    <div>
        <label>Profile Picture: </label>
        <input type="file" name="fileProfile" value="Chọn tệp">
<%--        <span>Không có tệp nào được chọn</span>--%>
    </div>
    <br>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
