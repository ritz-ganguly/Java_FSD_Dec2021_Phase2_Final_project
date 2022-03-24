<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Card details page</h2>

	<form action="cardDetails" method="post">

		Enter 16 digit card number : <input type="number" name="cardNo"
			required="required" maxlength="16" size="16"> <br>
		<br> Enter 3 digit cvv: <input type="number" name="cvv"
			required="required" maxlength="3" size="3"> <br>
		<br> <input type="submit" value="Proceed">
	</form>
</body>
</html>