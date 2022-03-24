<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
</body>
</html>