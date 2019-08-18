<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="changepass" method = "POST">

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
String name = (String) session.getAttribute("user");
out.print("Hello, " + name);
%>
			<p>Please enter your old password</p> 		
			<input type="text" name="uname"value="<% out.print(session.getAttribute("user")); %>"/><br>		
		
			<p>Please enter your new password</p>
			<input type="password" name="newpw"/>
			
			<input type="submit" value="submit">			
		</form>
</body>
</body>
</html>