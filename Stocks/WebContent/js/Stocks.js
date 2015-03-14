function piechart(stock1, stock2, stock3, stock1value, stock2value, stock3value, remainder) 
{	
	google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Stock', 		'Price'],
        [stock1,     	stock1value],
        [stock2,      	stock2value],
        [stock3,  		stock3value],
        ['Remainder',  	remainder]
      ]);

      var options = {
        title: ''
      };
      
      var chart = new google.visualization.PieChart(document.getElementById('piechart'));

      function selectHandler() {
          var selectedItem = chart.getSelection()[0];
          if (selectedItem) {
            var stock = data.getValue(selectedItem.row, 0);
            var value = data.getValue(selectedItem.row, 1);
            if(stock == stock1)
            	changeValue(stock,1);
            else if(stock == stock2)
            	changeValue(stock,2);
            else if(stock == stock3)
            	changeValue(stock,3);
          }
        }
      
      google.visualization.events.addListener(chart, 'select', selectHandler); 
      	
      chart.draw(data, options);
    }
}

function barchart(stock1, stock2, stock3, stock1value, stock2value, stock3value, remainder) 
{
	google.load("visualization", "1.1", {packages:["bar"]});
    google.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Stock', 		'Price'],
        [stock1,     	stock1value],
        [stock2,      	stock2value],
        [stock3,  		stock3value],
        ['Remainder',  	remainder]
      ]);

      var options = {
        chart: {
          title: ''
        },
        bars: 'vertical' // Required for Material Bar Charts.
      };

      var chart = new google.charts.Bar(document.getElementById('barchart'));

      function selectHandler() {
          var selectedItem = chart.getSelection()[0];
          if (selectedItem) {
            var stock = data.getValue(selectedItem.row, 0);
            var value = data.getValue(selectedItem.row, 1);
            if(stock == stock1)
            	changeValue(stock,1);
            else if(stock == stock2)
            	changeValue(stock,2);
            else if(stock == stock3)
            	changeValue(stock,3);
          }
        }
      
      google.visualization.events.addListener(chart, 'select', selectHandler); 
      	
      chart.draw(data, options);
    }
}


function changeValue(stock, chosenStock)
{
	
	var pricePerStock1 = document.getElementById('stock1price').value;
	var pricePerStock2 = document.getElementById('stock2price').value;
	var pricePerStock3 = document.getElementById('stock3price').value;
	var stock1 = document.getElementById('stock1shares').value;
	var stock2 = document.getElementById('stock2shares').value;
	var stock3 = document.getElementById('stock3shares').value;
	var stockvalue1 = document.getElementById('stock1investment').value;
	var stockvalue2 = document.getElementById('stock2investment').value;
	var stockvalue3 = document.getElementById('stock3investment').value;
	var rem = document.getElementById('investmentRemainder').value;
	var investmentTot = document.getElementById('investmentTotal').value;
	
	if(chosenStock == 1)
	{
		
		//alert("Price of  " +  stock + " = " + pricePerStock1 + " and you own " + stock1 + " shares" + " and your their total worth is " + stockvalue1);
		var newAmount = prompt('Please enter the new amount:  \n'+ 'Stock = '+ stock + ', Value = ' + stockvalue1 + ', Shares =  ' + stock1,stock1);
		if(newAmount)
			{
				var newTotal = pricePerStock1 * newAmount;
		
				document.getElementById("stock1shares").value=newAmount; 
				document.getElementById("stock1investment").value=newTotal;
	
				//alert(stock+", "+stock2 + ", "+stock3+", "+newTotal+", "+stockvalue2+", "+stockvalue3 +", " +rem);
						
				//piechart(stock,stock2,stock3,newTotal,stockvalue2,stockvalue3,rem);
				//barchart(stock,stock2,stock3,newTotal,stockvalue2,stockvalue3,rem);
			}
		//alert("this is a test");
	}
	else if(chosenStock == 2)
	{
		var newAmount = prompt('Please enter the new amount:  \n'+ 'Stock = '+ stock + ', Value = ' + stockvalue2 + ', Shares =  ' + stock2,stock2);
		if(newAmount)
		{
			var newTotal = pricePerStock2 * newAmount;
			document.getElementById("stock2shares").value=newAmount; 
			document.getElementById("stock2investment").value=newTotal;
		
			//piechart(stock1, stock, stock3, stockvalue1, newTotal, stockvalue3, rem);
			//barchart(stock1, stock, stock3, stockvalue1, newTotal, stockvalue3, rem);
		}
	}
	else if(chosenStock == 3)
	{
		var newAmount = prompt('Please enter the new amount:  \n'+ 'Stock = '+ stock + ', Value = ' + stockvalue3 + ', Shares =  ' + stock3,stock3);
		if(newAmount)
		{
			var newTotal = pricePerStock3 * newAmount;
			document.getElementById("stock3shares").value=newAmount; 
			document.getElementById("stock3investment").value=newTotal;
			
			//piechart(stock1, stock2, stock, stockvalue1, stockvalue2, newTotal, rem);
			//barchart(stock1, stock2, stock, stockvalue1, stockvalue2, newTotal, rem);
		}
	}
	
	
}
