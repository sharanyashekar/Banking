<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%
session=request.getSession();
String name=(String)session.getAttribute("name");
int balance=(int)session.getAttribute("balance");


out.print(name+" Your balance is: "+ balance);
%>
</body>
</html>