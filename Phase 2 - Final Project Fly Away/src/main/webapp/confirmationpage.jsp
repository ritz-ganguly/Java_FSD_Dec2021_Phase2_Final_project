<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="mypack.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Confirmation Page</h2>

	<h3>Your details are as follows</h3>
	<%
	Flights f = (Flights) session.getAttribute("selectedFlight");
	request.setAttribute("f", f);
	%>

	<table border="1">
		<tr>
			<td>Flight Number</td>
			<td>Source</td>
			<td>Destination</td>
			<td>Airline</td>
			<td>Departure Date</td>
			<td>Time</td>
			<td>Cost/Person</td>
			<td>Total Duration</td>
		</tr>
		<tr>
			<td><input type="text" readonly value="${f.getFlightNo()}"></td>

			<td><input type="text" readonly value="${f.getSource()}"></td>
			<td><input type="text" readonly value="${f.getDestination()}"></td>
			<td><input type="text" readonly value="${f.getAirline()}"></td>
			<td><input type="text" readonly value="${f.getDepartureDate()}"></td>
			<td><input type="text" readonly value="${f.getTime()}"></td>
			<td><input type="text" readonly value="${f.getCostPerPerson()}"></td>

			<td><input type="text" readonly value="${f.getFlightDuration()}"></td>


		</tr>
	</table>

	<h3>Passenger details</h3>

	<%
	List<Passengers> p = (ArrayList<Passengers>) session.getAttribute("passengers");
	request.setAttribute("passengers", p);
	%>

	<table border="1">
		<tr>
			<td>Passenger Name</td>
			<td>Passenger Age</td>

		</tr>
		<c:forEach items="${passengers}" var="pass">
			<tr>
				<td><input type="text" readonly
					value="${pass.getPassengerName()}"></td>
				<td><input type="text" readonly
					value="${pass.getPassengerAge()}"></td>

			</tr>
		</c:forEach>
	</table>

	<br>
	<br>
	<form action="finalDetailsConfirmation" method="post">
		<input type="submit" value="Confirm">

	</form>
</body>
</html>