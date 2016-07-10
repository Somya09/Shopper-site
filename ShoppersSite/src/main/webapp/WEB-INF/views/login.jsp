<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Decor</title>
</head>
<body>
${message}<br/><br/>
<form:form action= "isValidUser" method ="post">
         Enter Username:<input type ="text" name="name"><br/>
         Enter Password :<input type = "password" name="password"><br/>
         <input type="radio" value="isUser" checked> User<br>
         <input type="radio" value="isAdmin"> Admin<br>
         <input type = "Submit">
         </form:form>
</body>
</html>