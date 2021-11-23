<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Play&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/custom.css" >
</head>

<%
				String message=(String)session.getAttribute("message");
				if(message==null)
				{
					message="";
				}

%>

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
Sign Up
	<form action="employeeSignUp" method="post">
		<table style="font-size: 30px" >
		
			<tr>
				<td>Name:</td>
				<td><input class="textBox" type="text" name="name" required></td>
			</tr>
			<tr>
				<td>Surname:</td>
				<td><input class="textBox" type="text" name="surname" required></td>
			</tr>
			<tr>
				<td>Employee Id:</td>
				<td><input class="textBox" type="number" name="empId" required></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><input class="textBox" type="number" name="pNumber" required></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input class="textBox" type="email" name="email" required></td>
			</tr>
			<!-- <tr>
				<td style="text-aligh:center">Gender:</td>
			<tr>
				<td>Male</td>
				<td style="text-align: left;">
					<input type="radio">
				</td>
			</tr>
			<tr>
				<td>Female</td>
				<td style="text-align: left;">
				<input type="radio">
				</td>
			</tr>
				<tr>
				<td>Others</td>
				<td style="text-align: left;"><input type="radio"></td>
				</tr>
			</tr> -->
		</table>
		
				<p style="margin: 0px; color:red ; font-size: 20px"><%= message %></p>	
		
		<input class="textBox" style="font-size:30px" type="submit" onclick="test()">
	</form>
	<%
		if(request.getParameter("empId")==null)
		{
			int empId=0;
		}	
	%>
</div>
</div>
</body>
</html>