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
	
	<div class="adminDisplay" style="height:200px">
		<div class="block" style="color:white; text-decoration: none ;font-family: 'Play', sans-serif;">
			<p>List Of Employees</p>
		</div>
	</div>
<br>
	
	<div class="table">
		<table>
			<thead>
			
			</thead>
		<tbody>
			<c:forEach items="${employee}" var="list">
				<tr>
						<td>${list.empId}</td><td>${list.name}</td>
						<td>${list.surname}</td><td>${list.pNumber}</td>
						<td>${list.email}</td><td>${list.role}</td>
					<!-- 	<td><a href="update"><button>Update</button></a></td>
						<td><input type="button" value="D" name="option"></td> -->
				</tr>
			</c:forEach>		
		</tbody>
		</table>
	</div>

</body>
</html>