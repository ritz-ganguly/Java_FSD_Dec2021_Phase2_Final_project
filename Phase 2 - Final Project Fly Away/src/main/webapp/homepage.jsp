<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="mypack.entity.Flights"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Fly Away</h2>
	<form action="booking" method="post">
		<table border="1">
			<tr>
				<td><label for="travelday">Select Travel Date:</label></td>
				<td><input type="date" id="travelday" name="travelday"
					required="required"></td>
			</tr>

			<tr>
				<td>Select the source:</td>
				<td><select name="source">
						<%
						List<Flights> distinctSources = (ArrayList<Flights>) request.getAttribute("distinctSources");
						//System.out.println(distinctSources);
						%>
						<c:forEach items="${distinctSources}" var="category">
							<option value="${category.getSource()}">${category.getSource()}</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td>Select the Destination:</td>
				<td><select name="destination">
						<%
						List<Flights> distinctDestinations = (ArrayList<Flights>) request.getAttribute("distinctDestinations");
						//System.out.println(distinctDestinations);
						%>
						<c:forEach items="${distinctDestinations}" var="category">
							<option value="${category.getDestination()}">${category.getDestination()}</option>
						</c:forEach>

				</select></td>
			</tr>

			<tr>
				<td>Number of Persons</td>
				<td><select name="persons">
						<c:forEach begin="1" end="${maxSeats}" varStatus="loop">
							<option value="${loop.index}">${loop.index}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td><input type="submit"></td>
			</tr>

		</table>
	</form>


</body>
</html>