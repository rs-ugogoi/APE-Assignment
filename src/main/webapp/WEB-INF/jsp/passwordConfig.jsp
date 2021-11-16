<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Password</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Play&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/custom.css" >
</head>
<body class="background">
	<div class="block" style="color:white; text-decoration: none ;font-family: 'Play', sans-serif;">
		Set Password
	<form action="setPassword" method="get">
		<table style="font-size: 30px" >
		
			<tr>
				<td>Enter Password:</td>
				<td><input class="textBox" type="text" name="password"></td>
			</tr>
			<%
				String message=(String)session.getAttribute("message");
				session.setAttribute("empId",session.getAttribute("empId"));%>
			<%= message  %>
			<tr>
				<td>Re-Enter Password:</td>
				<td><input class="textBox" type="password" name="reEnterPassword"></td>
			</tr>
			
		</table>
				<input class="textBox" style="font-size:30px" type="submit">
	</form>
	</div>
</body>
</html>