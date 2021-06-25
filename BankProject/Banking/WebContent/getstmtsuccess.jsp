<%@page import="java.util.ArrayList"%>
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
ArrayList al=(ArrayList)session.getAttribute("statement");
out.print("Hello "+name+" Your Bank statement "+al);


%>

</body>
</html>