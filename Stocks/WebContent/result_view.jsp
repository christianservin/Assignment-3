<%@page import="model.StocksModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stocks Investment Results</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/Stocks.css">
</head>
<body>
	<%StocksModel stocks = (StocksModel)request.getAttribute("stocks");%>
	
	<h1>Stocks Investment Results</h1>

	<div>
		<div id="heading">
			<h3>Total Investment:</h3><h4> $</h4><h4><%=stocks.getInvestmentTotal()%></h4>
		</div>
		<div id="heading">
			<h3>Investment Remainder:</h3><h4> $</h4><h4 id="investmentRemainder"><%=stocks.getInvestmentRemainder()%></h4>
		</div>
		<br>
	</div>

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
				<td id="stock1"><%=stocks.getStock1()%></td>
				<td><%=stocks.getStock1price()%></td>
				<td><%=stocks.getStock1shares()%></td>
				<td id="stock1investment"><%=stocks.getStock1investment()%></td>
			</tr>
			<tr>
				<td id="stock2"><%=stocks.getStock2()%></td>
				<td><%=stocks.getStock2price()%></td>
				<td><%=stocks.getStock2shares()%></td>
				<td id="stock2investment"><%=stocks.getStock2investment()%></td>
			</tr>
			<tr>
				<td id="stock3"><%=stocks.getStock3()%></td>
				<td><%=stocks.getStock3price()%></td>
				<td><%=stocks.getStock3shares()%></td>
				<td id="stock3investment"><%=stocks.getStock3investment()%></td>
			</tr>
		</tbody>
	</table>
	<button onclick="main()">Save</button>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div id="piechart" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
			</div>
			<div class="col-sm-6">
				<div id="barchart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
			</div>
		</div>
	</div>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script src="http://code.highcharts.com/modules/data.js"></script>
	<script src="js/mindmup-editabletable.js"></script>
	<script src="js/Stocks.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>