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

	<h3>Total Investment: $<%=stocks.getInvestmentTotal()%></h3>
	<table id="datatable" class="table table-bordered">
		<thead>
			<tr>
				<th>Ticker</th>
				<th>Price</th>
				<th>Shares</th>
				<th>Investment</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=stocks.getStock1()%></td>
				<td><%=stocks.getStock1price()%></td>
				<td><%=stocks.getStock1shares()%></td>
				<td><%=stocks.getStock1investment()%></td>
			</tr>
			<tr>
				<td><%=stocks.getStock2()%></td>
				<td><%=stocks.getStock2price()%></td>
				<td><%=stocks.getStock2shares()%></td>
				<td><%=stocks.getStock2investment()%></td>
			</tr>
			<tr>
				<td><%=stocks.getStock3()%></td>
				<td><%=stocks.getStock3price()%></td>
				<td><%=stocks.getStock3shares()%></td>
				<td><%=stocks.getStock3investment()%></td>
			</tr>
		</tbody>
	</table>
	<h3>Investment Remainder: $<%=stocks.getInvestmentRemainder()%></h3>

	<div id="piechart" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
	<div id="barchart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script src="http://code.highcharts.com/modules/data.js"></script>
	<script src="js/Stocks.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			piechart("<%=stocks.getStock1()%>","<%=stocks.getStock2()%>","<%=stocks.getStock3()%>",<%=stocks.getStock1investment()%>,<%=stocks.getStock2investment()%>,<%=stocks.getStock3investment()%>,<%=stocks.getInvestmentRemainder()%>);
			barchart();
		});
	</script>
</body>
</html>