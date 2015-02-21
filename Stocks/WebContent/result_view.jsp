<%@page import="model.StocksModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Investments</title>
</head>
<body>
	<%StocksModel stocks = (StocksModel) request.getAttribute("stocks");%>
	
	<h1>Investment: <%=stocks.getInvestment()%>!</h1>
	<h2>Stock1: <%=stocks.getStock1()%></h2>
	<h2>Stock2: <%=stocks.getStock2()%></h2>
	<h2>Stock3: <%=stocks.getStock3()%></h2>
</body>

<!-- jQuery and Bootstrap JavaScript -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</html>