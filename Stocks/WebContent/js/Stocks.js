function piechart(stock1, stock2, stock3, stock1value, stock2value, stock3value, remainder) 
{	
	console.log("piechart")
	console.log("stock1value: " + stock1value);
	console.log("stock2value: " + stock2value);
	console.log("stock3value: " + stock3value);
	console.log("remainder: " + remainder);
	
	
	google.load("visualization", "1", {packages:["corechart"]});

    function drawPieChart() {
      var Piechartdata = null;
      Piechartdata = new google.visualization.arrayToDataTable([
        ['Stock', 		'Price'],
        [stock1,     	parseFloat(stock1value)],
        [stock2,      	parseFloat(stock2value)],
        [stock3,  		parseFloat(stock3value)],
        ['Remainder',  	parseFloat(remainder)]
      ]);

      var Piechartoptions = {
        title: ''
      };
      
      var Piechart = null;
      Piechart = new google.visualization.PieChart(document.getElementById('piechart'));

      function PiechartselectHandler() {
          var selectedItem = Piechart.getSelection()[0];
          if (selectedItem) {
            var stock = Piechartdata.getValue(selectedItem.row, 0);
            var value = Piechartdata.getValue(selectedItem.row, 1);
            if(stock == stock1)
            	changeValue(stock,1);
            else if(stock == stock2)
            	changeValue(stock,2);
            else if(stock == stock3)
            	changeValue(stock,3);
          }
        }
      
      google.visualization.events.addListener(Piechart, 'select', PiechartselectHandler); 
      Piechart.draw(Piechartdata, Piechartoptions);
    }
    drawPieChart();
}

function barchart(stock1, stock2, stock3, stock1value, stock2value, stock3value, remainder) 
{
	console.log("barchart")
	console.log("stock1value: " + stock1value);
	console.log("stock2value: " + stock2value);
	console.log("stock3value: " + stock3value);
	console.log("remainder: " + remainder);
	
	google.load("visualization", "1.1", {packages:["bar"]});

    function drawBarChart() 
    {
      var Barchartdata = null;
      Barchartdata = new google.visualization.arrayToDataTable([
        ['Stock', 		'Price'],
        [stock1, parseFloat(stock1value)],
        [stock2, parseFloat(stock2value)],
        [stock3, parseFloat(stock3value)],
        ['Remainder',  	parseFloat(remainder)]
      ]);

      var Barchartoptions = {
        chart: {
          title: ''
        },
        bars: 'vertical' // Required for Material Bar Charts.
      };

      var Barchart = null;
      Barchart = new google.charts.Bar(document.getElementById('barchart'));

      function BarchartselectHandler() {
          var selectedItem = Barchart.getSelection()[0];
          if (selectedItem) {
            var stock = Barchartdata.getValue(selectedItem.row, 0);
            var value = Barchartdata.getValue(selectedItem.row, 1);
            if(stock == stock1)
            	changeValue(stock,1);
            else if(stock == stock2)
            	changeValue(stock,2);
            else if(stock == stock3)
            	changeValue(stock,3);
          }
        }
      
      google.visualization.events.addListener(Barchart, 'select', BarchartselectHandler); 
      	
      Barchart.draw(Barchartdata, Barchartoptions);
    }
    
    drawBarChart();
}


function changeValue(stock, chosenStock)
{
	
	var stock1 = document.getElementById('stock1').value;
	var stock2 = document.getElementById('stock2').value;
	var stock3 = document.getElementById('stock3').value;
	var stock1price = document.getElementById('stock1price').value;
	var stock2price = document.getElementById('stock2price').value;
	var stock3price = document.getElementById('stock3price').value;
	var stock1shares = document.getElementById('stock1shares').value;
	var stock2shares = document.getElementById('stock2shares').value;
	var stock3shares = document.getElementById('stock3shares').value;
	var stock1investment = document.getElementById('stock1investment').value;
	var stock2investment = document.getElementById('stock2investment').value;
	var stock3investment = document.getElementById('stock3investment').value;
	var investmentRemainder = document.getElementById('investmentRemainder').value;
	var investmentTotal = document.getElementById('investmentTotal').value;
	
	if(chosenStock == 1)
	{
		
		//alert("Price of  " +  stock + " = " + pricePerStock1 + " and you own " + stock1 + " shares" + " and your their total worth is " + stockvalue1);
		var newAmount = prompt('Please enter the new amount:  \n'+ 'Stock = '+ stock + ', Value = ' + stock1investment + ', Shares =  ' + stock1shares,stock1shares);
		if(newAmount)
			{
				var newTotal = parseFloat(Math.round((stock1price * newAmount)*100.00)/100.00).toFixed(2);
				
				document.getElementById("stock1shares").value=newAmount; 
				document.getElementById("stock1investment").value=newTotal;
				
				//alert(stock1+", "+stock2 + ", "+stock3+", "+newTotal+", "+stockvalue2+", "+stockvalue3 +", " +rem);
						
				updateCharts();
			}
		
	}
	else if(chosenStock == 2)
	{
		var newAmount = prompt('Please enter the new amount:  \n'+ 'Stock = '+ stock + ', Value = ' + stock2investment + ', Shares =  ' + stock2shares,stock2shares);
		if(newAmount)
		{
			var newTotal = parseFloat(Math.round((stock2price * newAmount)*100.00)/100.00).toFixed(2);
			document.getElementById("stock2shares").value=newAmount; 
			document.getElementById("stock2investment").value=newTotal;
		
			updateCharts();
		}
	}
	else if(chosenStock == 3)
	{
		var newAmount = prompt('Please enter the new amount:  \n'+ 'Stock = '+ stock + ', Value = ' + stock3investment + ', Shares =  ' + stock3shares,stock3shares);
		if(newAmount)
		{
			var newTotal = parseFloat(Math.round((stock3price * newAmount)*100.00)/100.00).toFixed(2);
			document.getElementById("stock3shares").value=newAmount; 
			document.getElementById("stock3investment").value=newTotal;
			
			updateCharts();
		}
	}
		
}

function updateCharts() 
{
	var stock1 = document.getElementById('stock1').value;
	var stock2 = document.getElementById('stock2').value;
	var stock3 = document.getElementById('stock3').value;
	var stock1price = document.getElementById('stock1price').value;
	var stock2price = document.getElementById('stock2price').value;
	var stock3price = document.getElementById('stock3price').value;
	var stock1shares = document.getElementById('stock1shares').value;
	var stock2shares = document.getElementById('stock2shares').value;
	var stock3shares = document.getElementById('stock3shares').value;
	var stock1investment = document.getElementById('stock1investment').value;
	var stock2investment = document.getElementById('stock2investment').value;
	var stock3investment = document.getElementById('stock3investment').value;
	var investmentRemainder = document.getElementById('investmentRemainder').value;
	var investmentTotal = document.getElementById('investmentTotal').value;
	
	console.log("stock1investment: " + stock1investment);
	console.log("stock2investment: " + stock2investment);
	console.log("stock3investment: " + stock3investment);
	console.log("investmentRemainder: " + investmentRemainder);
	
	piechart(stock1, stock2, stock3, stock1investment, stock2investment, stock3investment, investmentRemainder);
	barchart(stock1, stock2, stock3, stock1investment, stock2investment, stock3investment, investmentRemainder);
}


