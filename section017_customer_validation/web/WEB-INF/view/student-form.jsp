<%--
  Created by IntelliJ IDEA.
  User: mopom
  Date: 2019-02-23
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:
    <form:select path="country">
        <form:options items="${theCountryOptions}" />
    </form:select>
    <br><br>
    Favorite Language:
    <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
    <br><br>
    Operating Systems:
    <form:checkboxes path="operatingSystems" items="${student.operatingSystemsOptions}"  />
    <br><br>
    <input type="submit" value="submit">
</form:form>
</body>
</html>
