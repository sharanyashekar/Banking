
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
out.print("Welcome "+name+" to Bank");


%>

<br>
<a href="CheckBalance">Click here to check balance</a>
<br><br>
<a href="applyLoan.jsp">Click here to apply for the loan</a>
<br><br>
<a href="changepwd.jsp">Click here to change password</a>
<br><br>
<a href="transferamt.jsp">Click here for Amount transfer</a>
<br><br>
<a href="GetStatement">Click here for Transaction statement</a>
<br><br>
<a href="logout.jsp">Logout</a>
<br><br>
</body>
</html>

