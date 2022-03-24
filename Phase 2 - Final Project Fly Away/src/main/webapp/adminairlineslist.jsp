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
	if (session.getAttribute("userid") == null)
		response.sendRedirect("adminlogin.jsp");
	%>

	<table border="1">
		<tr>
			<form action="changeAdminPassword" method="post">
				<td><input type="submit" value="Change Password"></td>
			</form>

			<form action="sourceAndDestination" method="post">
				<td><input type="submit" value="View Source and Destination">
				</td>
			</form>

			<form action="airlines" method="post">
				<td><input type="submit" value="View Airlines"></td>
			</form>

			<form action="listOfFlights" method="post">
				<td><input type="submit" value="View Flight Details"></td>
			</form>

			<form action="adminLogout" method="post">
				<td><input type="submit" value="Logout"></td>
			</form>
		</tr>
	</table>
	<h2>Airlines List</h2>
	<%
	List<Flights> airlinesList = (ArrayList<Flights>) request.getAttribute("airlinesList");
	if (airlinesList.size() == 0)
		out.println("No airlines found");
	else {
	%>
	<table border="1">

		<c:forEach items="${airlinesList}" var="airlines">
			<tr>
				<td><input type="text" readonly
					value="${airlines.getAirline()}"></td>
			</tr>
		</c:forEach>
	</table>
	<%
	}
	%>

</body>
</html>