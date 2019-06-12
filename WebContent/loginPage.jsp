<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<title>Enter WebProject</title>
</head>

<body style="color: #2e4161; background-color: #9bd742">

	<div class="w3-card-4">
		<div class="w3-container w3-green">
			<h2>WebProject Worker</h2>
		</div>

		<form action="LoginServlet" method="post"
			style="color: black; text-align: center;">
			<p style="font-family: verdana; color: black; font-size: 80%;">LOGIN:</p>
			<input type="text" name="username" value=""
				style="width: 20%; text-align: center;"> <br>
			<c:out value="${messages['username']}" />
			<br>
			<p style="font-family: verdana; color: black; font-size: 80%;">PASSWORD:</p>
			<input type="text" name="password" value=""
				style="width: 20%; text-align: center;"> <br>
			<c:out value="${messages['password']}" />
			<br> <br>
			<input class="w3-button w3-green w3-round-xxlarge" type="submit"
				value="Enter" name="sbmit"
				style="width: 10%; background-color: Green; color: white; font-family: verdana; font-size: 80%;">
			<br>
			<c:out value="${messages['login']}" />
		</form>
		<br>
		<br>
		<br>

	</div>

	<h2 id="creater"></h2>
</body>
</html>