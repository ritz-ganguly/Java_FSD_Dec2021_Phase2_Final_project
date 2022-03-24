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
	<h2>Passengers' details Page</h2>
	<%
	int numberOfPersons = (int) session.getAttribute("numberOfPersons");
	%>

	<form action="passengerDetails" method="post">
		<table border="1">
			<c:forEach begin="1" end="${totPersons}" varStatus="loop">
				<tr>
					<td>Enter name of Passenger ${loop.index}</td>

					<td><input type="text" required="required"
						name="passengerName${loop.index}"></td>




					<td>Enter age of Passenger ${loop.index}</td>

					<td><input type="number" min="1" max="999" required="required"
						name="passengerAge${loop.index}"></td>
				</tr>
			</c:forEach>

			<tr>
				<td><input type="submit" value="Proceed"></td>
			</tr>
		</table>
	</form>
</body>
</html>