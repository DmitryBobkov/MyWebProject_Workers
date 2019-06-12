<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WebPrpject worker</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body style="color: #2e4161; background-color: #9bd742">

	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
		style="display: none; background-color: #9bd742" id="mySidebar">
		<button class="w3-bar-item w3-red w3-button w3-large"
			onclick="w3_close()">Close&times;</button>

		<form action="/webProjectWorker/?action=update"
			class="w3-bar-item w3-button" method="post">
			<p>
				<font size="5" color="Blue" face="Arial">Enter the data to be
					update</font>
			</p>
			Id:<br> <input type="text" name="id" pattern="^[ 0-9]+$"
				required> <br> Type:<br> <select name="type"
				style="width: 205px; height: 30px">
				<option value="Worker">Worker</option>
				<option value="Workman">Workman</option>
				<option value="Scientist">Scientist</option>
				<option value="Manager">Manager</option>
			</select><br> Name:<br> <input type="text" name="name"
				pattern="^[a-zA-Z]+$" required> <br> City:<br> <input
				type="text" name="city" pattern="^[a-zA-Z]+$" required> <br>
			Country:<br> <input type="text" name="country"
				pattern="^[a-zA-Z]+$" required> <br> Position:<br>
			<input type="text" name="position" pattern="^[ 0-9]+$"> <br>
			Gathering:<br> <input type="text" name="gathering"
				pattern="^[ 0-9]+$"> <br> Publications:<br> <input
				type="text" name="publications" pattern="^[ 0-9]+$"> <br>
			<br> <input class="w3-hover-green" type="submit" value="Update">
		</form>

		<form action="/webProjectWorker/?action=create"
			class="w3-bar-item w3-button" method="post">
			<p>
				<font size="5" color="Blue" face="Arial">Enter the data to be
					create</font>
			</p>
			Type:<br> <select name="type"
				style="width: 205px; height: 30px;">
				<option value="Worker">Worker</option>
				<option value="Workman">Workman</option>
				<option value="Scientist">Scientist</option>
				<option value="Manager">Manager</option>
			</select><br> Name:<br> <input type="text" name="name"
				pattern="^[a-zA-Z]+$" required> <br> City:<br> <input
				type="text" name="city" pattern="^[a-zA-Z]+$" required> <br>
			Country:<br> <input type="text" name="country"
				pattern="^[a-zA-Z]+$" required> <br> Position:<br>
			<input type="text" name="position" pattern="^[ 0-9]+$"> <br>
			Gathering:<br> <input type="text" name="gathering"
				pattern="^[ 0-9]+$"> <br> Publications:<br> <input
				type="text" name="publications" pattern="^[ 0-9]+$"> <br>
			<br> <input class="w3-hover-green" type="submit" value="Create">
		</form>

		<form action="/webProjectWorker/?action=delete"
			class="w3-bar-item w3-button" method="post">
			<p>
				<font size="5" color="Blue" face="Arial">Enter the data to be
					delete</font>
			</p>
			Id:<br> <input type="text" name="id" pattern="^[ 0-9]+$"
				required> <br>
			<br> <input class="w3-hover-green" type="submit" value="Delete"><br>
		</form>

		<form action="/webProjectWorker/?action=read"
			class="w3-bar-item w3-button" method="post">
			<p>
				<font size="5" color="Blue" face="Arial">Enter the data to be
					read</font>
			</p>
			Id:<br> <input type="text" name="id" pattern="^[ 0-9]+$"
				required> <br>
			<br> <input class="w3-hover-green" type="submit" value="Read"><br>
		</form>
	</div>

	<div id="main">
		<div class="w3-teal">
			<button id="openNav" class="w3-button w3-teal w3-xlarge"
				onclick="w3_open()">&#9776;</button>
			<div class="w3-container">
				<h1>WebProject Worker</h1>
			</div>
		</div>

		<div class="w3-container">
			<p>Belarus, Minsk, 2019</p>
		</div>
	</div>

	<script>
		function w3_open() {
			document.getElementById("main").style.marginLeft = "25%";
			document.getElementById("mySidebar").style.width = "25%";
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("openNav").style.display = 'none';
		}
		function w3_close() {
			document.getElementById("main").style.marginLeft = "0%";
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("openNav").style.display = "inline-block";
		}
	</script>

	<div class="w3-container">
		<div class="w3-container w3-center w3-animate-top">
			<h2>Staff list</h2>
			<p>Site for viewing employees, as well as for performing</p>
			<p>actions on the list of employees of the company</p>
		</div>

		<div class="w3-container w3-center w3-animate-zoom">
			<table class="w3-table-all w3-hoverable ">
				<thead>
					<tr class="w3-light-grey w3-hover-green">

						<c:forEach items="${workerList}" var="worker">
							<c:if test="${worker.type != null}">
								<th>Id</th>
								<th>Name</th>
								<th>Type</th>
								<th>City</th>
								<th>Country</th>


								<c:if test="${worker.type == 'Manager'}">
									<th>Position</th>
									<th>Gathering</th>
								</c:if>



								<c:if test="${worker.type == 'Scientist'}">
									<th>Publications</th>
								</c:if>
							</c:if>
						</c:forEach>

					</tr>
				</thead>

				<tbody>

					<c:forEach items="${workerList}" var="worker">
						<tr class="w3-hover-green">

							<c:if test="${worker.type != null}">
								<p>
									<font size="4" color="Blue" face="Arial">Detailed
										information about the employee is provided below</font>
								</p>

								<td>${worker.id}</td>
								<td>${worker.name}</td>
								<td>${worker.type}</td>
								<td>${worker.address.city}</td>
								<td>${worker.address.country}</td>


								<c:if test="${worker.type == 'Manager'}">
									<td>${worker.position}</td>
									<td>${worker.gathering}</td>
								</c:if>

								<c:if test="${worker.type == 'Scientist'}">
									<td>${worker.publications}</td>
								</c:if>
							</c:if>


							<c:if test="${worker.type == null}">
								<p>
									<font size="4" color="Red" face="Arial">There's no
										employee with that ID</font>
								</p>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="w3-container w3-center w3-animate-bottom"></div>

	<div class="w3-container w3-center w3-animate-opacity">
		<p>
			<i class="w3-jumbo w3-spin fa fa-home"></i>
		</p>
		<a href="/webProjectWorker/?action=showAll"
			class="w3-bar-item w3-button">Home</a>
	</div>

</body>
</html>