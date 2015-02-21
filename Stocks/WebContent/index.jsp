<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>Stocks Investment</h1>
	<form action="main" method="post">
		<table>
			<tr>
				<td>Amount to Invest:</td>
				<td><input type="number" name="investment" value="10000"/></td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<td>Stock1:</td>
				<td><input type="text" name="stock1" value="GOOG" /></td>
			</tr>
			<tr>
				<td>Stock2:</td>
				<td><input type="text" name="stock2" value="APPL"/></td>
			</tr>
			<tr>
				<td>Stock3:</td>
				<td><input type="text" name="stock3" value="MSFT"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
<!-- jQuery and Bootstrap JavaScript/css -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</html>