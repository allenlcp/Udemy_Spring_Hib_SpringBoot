<%--
  Created by IntelliJ IDEA.
  User: mopom
  Date: 2019-02-23
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration Form</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name (*): <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>
    Free passes (*): <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>
    <br><br>
    Courses (*): <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>
    <br><br>
    <input type="submit" value="submit">
</form:form>
</body>
</html>

