<%--
  Created by IntelliJ IDEA.
  User: mopom
  Date: 2019-02-22
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
    <title>Hello World</title>
</head>
<body>
    <p class="red-input">Hello World of Spring!</p>
    <br><br>
    Student name: ${param.studentName}
    <br><br>
    Message: ${message}
    <br><br>
    <img src="${pageContext.request.contextPath}/resources/images/img_001.png">
    <button onclick="myFunction()">Click Me</button>
</body>
</html>
