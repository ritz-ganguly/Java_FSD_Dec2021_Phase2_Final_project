<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Fly Away Admin Login Page</h2>
	<form action="adminLogin" method="post">
		<table border="1">
			<tr>
				<td>Enter the user id:</td>

				<td><input type="email" name="userId" required="required"
					maxlength="80" size="80"></td>
			</tr>

			<tr>
				<td>Enter the password:</td>

				<td><input type="password" name="password" required="required"
					maxlength="80" size="80"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>

		</table>

	</form>
</body>
</html>