<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="mypack.entity.Flights"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	int persons = (int) request.getAttribute("numberOfPersons");
	//request.setAttribute("numberOfPersons", persons);
    session.setAttribute("numberOfPersons", persons);
	List<Flights> flightsList = (ArrayList<Flights>) request.getAttribute("flightsList");
	//request.setAttribute("flightsList", flightsList);
	session.setAttribute("flightsList", flightsList);

	if (flightsList.size() == 0)
		out.println("No flights found");
	else {
	%>

	<table border="1">
		<tr>
			<td>Flight Number</td>
			<td>Airline</td>
			<td>Time</td>
			<td>Cost/Person</td>
			<td>Total Duration</td>
		</tr>

		<c:forEach items="${flightsList}" var="flights">
			<form action="selectedFlight" method="post">

				<tr>
					<td><input type="text" name="flightNo" readonly
						value="${flights.getFlightNo()}"></td>
					<td><input type="text" name="airline" readonly
						value="${flights.getAirline()}"></td>
					<td><input type="text" name="time" readonly
						value="${flights.getTime()}"></td>
					<td><input type="text" name="cost" readonly
						value="${flights.getCostPerPerson()}"></td>
					<td><input type="text" name="duration" readonly
						value="${flights.getFlightDuration()}"></td>
					<td><input type="submit" value="book"></td>
				</tr>



			</form>
		</c:forEach>
	</table>
	<%
	

	}
	%>


</body>
</html>