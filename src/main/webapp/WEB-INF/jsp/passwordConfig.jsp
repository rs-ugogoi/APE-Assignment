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
			<%
				String message=(String)session.getAttribute("message");
				session.setAttribute("empId",session.getAttribute("empId"));%>
	
<body class="background">
	
<nav style="background-color:#121eb9; justify-content:space-between ; position: absolute; display: flex; height:50px; width: 100%; z-index: 1">
	<div style="padding-top: 6px; ">
		<a href="landingPage" style=" padding-left:15px; color:white; text-decoration: none ;font-family: 'Play', sans-serif; font-size: 30px">Home</a>
	</div >
	<div style="padding-top: 6px;">
		<a href="profile" style="padding-top: 6px; padding-right:15px; color:white; text-decoration: none ;font-family: 'Play', sans-serif; font-size: 30px">Profile</a>
	</div>
</nav>

<div class="pageDisplay" >
	<div class="block" style="color:white; text-decoration: none ;font-family: 'Play', sans-serif;">
		Set Password
	<form action="setPassword" method="post">
		<table style="font-size: 30px" >
		
			<tr>
				<td>Enter Password:</td>
				<td><input class="textBox" type="text" name="password"></td>
			</tr>
		
			<tr>
				<td>Re-Enter Password:</td>
				<td><input class="textBox" type="password" name="reEnterPassword"></td>
			</tr>
			
		</table>
		<p style="margin: 0px; color:red ; font-size: 20px"><%= message %></p>	
				<input class="textBox" style="font-size:30px" type="submit">
	</form>
	</div>
</div>
</body>
</html>