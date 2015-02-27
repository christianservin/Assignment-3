<%@page import="model.StocksModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stocks Investments Results</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<%StocksModel stocks = (StocksModel)request.getAttribute("stocks");%>

	<h1>Total Investment: $<%=stocks.getInvestmentTotal()%></h1>
	<h2>Stock1: <%=stocks.getStock1()%> = $<%=stocks.getStock1price()%> Shares: <%=stocks.getStock1shares()%> Investment: $<%=stocks.getStock1investment()%></h2>
	<h2>Stock2: <%=stocks.getStock2()%> = $<%=stocks.getStock2price()%> Shares: <%=stocks.getStock2shares()%> Investment: $<%=stocks.getStock2investment()%></h2>
	<h2>Stock3: <%=stocks.getStock3()%> = $<%=stocks.getStock3price()%> Shares: <%=stocks.getStock3shares()%> Investment: $<%=stocks.getStock3investment()%></h2>
	<h1>Investment Remainder: $<%=stocks.getInvestmentRemainder()%></h1>
	
	<div id="piechart" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script src="js/Stocks.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			console.log("PieChart");
			piechart("<%=stocks.getStock1()%>","<%=stocks.getStock2()%>","<%=stocks.getStock3()%>",<%=stocks.getStock1investment()%>,<%=stocks.getStock2investment()%>,<%=stocks.getStock3investment()%>,<%=stocks.getInvestmentRemainder()%>);
		});
	</script>
</body>
</html>