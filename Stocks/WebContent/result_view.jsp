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

	<form action="database" method="post">
		<div>
			<div id="heading">
				<h3>Total Investment:</h3>
				<h4>$</h4>
				<h4><input type="number" name="investmentTotal" id="investmentTotal" value="<%=stocks.getInvestmentTotal()%>"/></h4>
			</div>
			<div id="heading">
				<h3>Investment Remainder:</h3>
				<h4>$</h4>
				<h4><input type="number" name="investmentRemainder" id="investmentRemainder" value="<%=stocks.getInvestmentRemainder()%>"/></h4>
			</div>
			<br>
		</div>
		<table id="datatable"><!--  class="table table-bordered" -->
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
					<td><input type="text" name="stock1" id="stock1" value="<%=stocks.getStock1()%>"/></td>
					<td><input type="number" name="stock1price" id="stock1price" value="<%=stocks.getStock1price()%>"/></td>
					<td><input type="number" name="stock1shares" id="stock1shares" value="<%=stocks.getStock1shares()%>"/></td>
					<td><input type="number" name="stock1investment" id="stock1investment" value="<%=stocks.getStock1investment()%>"/></td>
				</tr>
				<tr>
					<td><input type="text" name="stock2" id="stock2" value="<%=stocks.getStock2()%>"/></td>
					<td><input type="number" name="stock2price" id="stock2price" value="<%=stocks.getStock2price()%>"/></td>
					<td><input type="number" name="stock2shares" id="stock2shares" value="<%=stocks.getStock2shares()%>"/></td>
					<td><input type="number" name="stock2investment" id="stock2investment" value="<%=stocks.getStock2investment()%>"/></td>
				</tr>
				<tr>
					<td><input type="text" name="stock3" id="stock3" value="<%=stocks.getStock3()%>"/></td>
					<td><input type="number" name="stock3price" id="stock3price" value="<%=stocks.getStock3price()%>"/></td>
					<td><input type="number" name="stock3shares" id="stock3shares" value="<%=stocks.getStock3shares()%>"/></td>
					<td><input type="number" name="stock3investment" id="stock3investment" value="<%=stocks.getStock3investment()%>"/></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Submit" onclick="main()" />
	</form>
	<!-- 	<button onclick="main()">Save</button> -->
	<br>

	<div class="chartsContainer">
		<div class="row">
			<div class="col-sm-6">
				<div id="piechart" style="width: 600px; height: 300px;"></div>
			</div>
			<div class="col-sm-6">
				<div id="barchart" style="width: 300px; height: 300px;"></div>
			</div>
		</div>
	</div>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['corechart']}]}"></script>
	<script type="text/javascript" src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1.1','packages':['bar']}]}"></script>
	<!-- <script src="http://code.highcharts.com/highcharts.js"></script> -->
	<!-- <script src="http://code.highcharts.com/modules/data.js"></script> -->
	<!-- <script src="js/mindmup-editabletable.js"></script> -->
	<script src="js/Stocks.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			piechart("<%=stocks.getStock1()%>","<%=stocks.getStock2()%>","<%=stocks.getStock3()%>",<%=stocks.getStock1investment()%>,<%=stocks.getStock2investment()%>,<%=stocks.getStock3investment()%>,<%=stocks.getInvestmentRemainder()%>);
			barchart("<%=stocks.getStock1()%>","<%=stocks.getStock2()%>","<%=stocks.getStock3()%>",<%=stocks.getStock1investment()%>,<%=stocks.getStock2investment()%>,<%=stocks.getStock3investment()%>,<%=stocks.getInvestmentRemainder()%>);
		});
	</script>


</body>
</html>