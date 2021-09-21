<%-- 
    Document   : createNewAccount
    Created on : Jul 2, 2021, 10:07:31 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>
            Create Account
        </h1>
        <form action="DispatchController" method="POST">
            <c:set var="errors" value="${requestScope.INSERT_ERROR}"/>
            Username* <input type="text" name="txtUsername" value="" /> (6 - 12 chars)<br/>
            <c:if test="${not empty errors.usernameLengthErr}">
                <font color="red">
                ${errors.usernameLengthErr}
                </font><br/>
            </c:if>
                <c:if test="${not empty errors.usernameIsExisted}">
                <font color="red">
                ${errors.usernameIsExisted}
                </font><br/>
            </c:if>
            Password* <input type="password" name="txtPassword" value="" />(8 - 20 chars)<br/>
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color="red">
                ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm*  <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.cofirmNotMatched}">
                <font color="red">
                ${errors.cofirmNotMatched}
                </font><br/>
            </c:if>
            Last name*<input type="text" name="txtLastname" value="" /> (2 - 40 chars)<br/>
            <c:if test="${not empty errors.fullnameLengthErr}">
                <font color="red">
                ${errors.fullnameLengthErr}
                </font><br/>
            </c:if>
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
