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
<body class="background">
<div class="block" style="color:white; text-decoration: none ;font-family: 'Play', sans-serif;">
Sign Up
	<form action="employeeSignUp" method="post">
		<table style="font-size: 30px" >
		
			<tr>
				<td>Name:</td>
				<td><input class="textBox" type="text" name="name"></td>
			</tr>
			<tr>
				<td>Surname:</td>
				<td><input class="textBox" type="text" name="surname"></td>
			</tr>
			<tr>
				<td>Employee Id:</td>
				<td><input class="textBox" type="text" name="empId"></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><input class="textBox" type="number" name="pNumber"></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input class="textBox" type="email" name="email"></td>
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
		<input class="textBox" style="font-size:30px" type="submit" onclick="test()">
	</form>
</div>
</body>
</html>