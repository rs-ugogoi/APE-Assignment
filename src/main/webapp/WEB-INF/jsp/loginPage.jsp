<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Play&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/custom.css" >
<script type="text/javascript" src="/js/custom.js"></script	>
</head>
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
<b>Login Page</b>

<form action="loginPage" method="post" style="font-size:40px">
		<table>
			<tr>
				<td>Email Id:</td>
				<td><input class="textBox" name="username" type="email" ></td>
			</tr>
			<tr>
			<td></td><td></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input class="textBox" name="password" type="password"></td>
			</tr>
		</table>
		<!-- onclick="test()" -->
<input class="textBox" style="font-size:30px" type="submit"  value="login">
</form>
</div>
</div>
</body>
</html>

				