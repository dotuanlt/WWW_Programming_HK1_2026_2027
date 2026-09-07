<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/08/2026
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Form get data</title>
  </head>
  <body>
    <form action="thongTin" method="GET">
        <div>
            <lable>Họ tên: </lable>
            <input id="name" type="text" placeholder="Nguyễn Văn A...">
        </div>

        <div>
            <lable>Tuổi: </lable>
            <input id="age" type="text" placeholder="20...">
        </div>

        <div>
            <lable>Lớp: </lable>
            <input id="className" type="text" placeholder="DHKTPM19BTT...">
        </div>
    </form>

  </body>
</html>
