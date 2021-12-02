<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page import="com.EmployeeDataManagement.pojo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Play&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/custom.css" >
<script type="text/javascript" src="/js/custom.js"></script	>

</head>

<body class="background">
<nav style="background-color:#121eb9; justify-content:space-between ; display: flex; height:50px; width: 100%; z-index: 1">
	<div style="padding-top: 6px; ">
		<a href="landingPage" style=" padding-left:15px; color:white; text-decoration: none ;font-family: 'Play', sans-serif; font-size: 30px">Home</a>
	</div >
	<div style="padding-top: 6px;">
		<a href="profile" style="padding-top: 6px; padding-right:15px; color:white; text-decoration: none ;font-family: 'Play', sans-serif; font-size: 30px">Profile</a>
		<a href="logoutPage" style="padding-top: 6px; padding-right:15px; color:white; text-decoration: none ;font-family: 'Play', sans-serif; font-size: 30px" onClick="logout()">Logout</a>
	</div>
</nav>
<br>
<br>
<div class="adminDisplay" >
<div class="block" style="color:white; text-decoration: none ;font-family: 'Play', sans-serif;">
<p>Welcome EMPLOYEE</p>
</div>
</div>
<br>
<br>
<div class="centerBlock" style="color:black; font-size:30px;text-align:start ; text-decoration: none ;font-family: 'Play', sans-serif;">
		
		<table>
			<tr>
				<td colspan="2">Details</td>
			</tr>
			<tr>
				<td>Emp Id:</td><td>${empDetails.empId}</td>
			</tr>
			<tr>
				<td>Name:</td><td>${empDetails.name} ${empDetails.surname}</td>
			</tr>
			<tr>
				<td>Mobile no:</td><td>${empDetails.pNumber}</td>
			</tr>
			<tr>
				<td>Email Id:</td><td>${empDetails.email}</td>
			</tr>	
		</table>
</div>
<br>
<div class="centerBlock" style="display:block; c olor:black; font-size:30px; font-family: 'Play', sans-serif;">
	Update Details:
	<a style="text-decoration: none" href="update"><button class="textBox" >Update</button></a>
	<br>
	<!--  Reset password:
	<a style="text-decoration: none" href="password"><button class="textBox" >Password</button></a>
	<br>-->
	Delete Account:
	<a style="text-decoration: none" href="delete"><button class="textBox" >Delete</button></a>
</div>
</body>
</html>