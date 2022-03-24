<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Admin Password Change Page</h2>
	<form action="adminProfilePasswordChange" method="post">
		<table border="1">
			<tr>
				<td>Enter Old Password</td>
				<td><input type="password" required="required"
					name="oldPassword" maxlength="80" size="80"></td>
			</tr>
			<tr>
				<td>Enter New Password</td>
				<td><input type="password" required="required"
					name="newPassword1" maxlength="80" size="80"></td>
			</tr>

			<tr>
				<td>Re-Enter New Password</td>
				<td><input type="password" required="required"
					name="newPassword2" maxlength="80" size="80"></td>
			</tr>

			<tr>

				<td><input type="submit" required="required"
					value="Change Password"></td>
			</tr>

		</table>

	</form>
</body>
</html>