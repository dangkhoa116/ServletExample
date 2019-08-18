<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>

</head>
<body>
<h1>Login Success</h1>
Keep the page idle for 10 seconds
	<br> And try reloading the page
	<br> you will be redirected to home page automatically
	<br>
    <%
    	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
				out.print("Hello, " + name + "  Welcome to your Profile");
			} else {
				response.sendRedirect("LoginPage.jsp");
			}
		}
	%>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
	<form action="ChangePass.jsp" method="post">
		<input type="submit" value="Change Password">
	</form>
	
</body>
</html>