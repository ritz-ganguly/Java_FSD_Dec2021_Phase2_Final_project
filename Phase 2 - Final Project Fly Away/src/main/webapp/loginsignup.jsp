<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table border="1">
		<form action="userRegistration" method="post">

			<h2>Registration Form</h2>
			<tr>
				<td>Enter Email id:</td>

				<td><input type="email" name="emailId" required="required"
					maxlength="80" size="80"></td>
			</tr>


			<tr>
				<td>Enter Password:</td>

				<td><input type="password" name="password" required="required"
					maxlength="80" size="80"></td>
			</tr>


			<tr>
				<td>Enter Name:</td>

				<td><input type="text" name="userName" required="required"
					maxlength="80" size="80"></td>
			</tr>

			<tr>
				<td>Enter Mobile Number:</td>

				<td><input type="text" name="mobile" required="required"
					maxlength="15" size="15"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</form>
		<br> Already a member?
		<a href="userloginpage.jsp">Login</a>
	</table>
</body>
</html>