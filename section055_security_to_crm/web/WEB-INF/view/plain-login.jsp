<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Custom Login Page</title>

    <style>
        .failed {
            color: red;
        }
    </style>

</head>

<body>

<h3>My Custom Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
           method="POST"> <!-- post method required for "/authenticateTheUser" controller -->

    <!-- Check for login error -->

    <c:if test="${param.error != null}">

        <i class="failed">Sorry! You entered invalid username/password.</i>

    </c:if>

    <p>
        User name: <input type="text" name="username"/> <!-- name needs to be "username" used by "/authenticateTheUser" controller-->
    </p>

    <p>
        Password: <input type="password" name="password"/>  <!-- name needs to be "password" used by "/authenticateTheUser" controller-->
    </p>

    <input type="submit" value="Login"/>

</form:form>

</body>

</html>












