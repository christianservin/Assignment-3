var theStock;

function piechart(stock1, stock2, stock3, stockShare1, stockShare2, stockShare3, stock1value, stock2value, stock3value, remainder) 
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

    //this function gets the selected stock and then sends it to the changedValue function where a window prompt is called
      function selectHandler() {
          var selectedItem = chart.getSelection()[0];
          if (selectedItem) {
            var stock = data.getValue(selectedItem.row, 0);
            var value = data.getValue(selectedItem.row, 1);
            if(stock == stock1)
            	changeValue(stock,value,stockShare1);
            else if(stock == stock2)
            	changeValue(stock,value,stockShare2);
            else
            	changeValue(stock, value, stockShare3);
          }
        }
      
      google.visualization.events.addListener(chart, 'select', selectHandler); 
      	
      chart.draw(data, options);
    }
}

function barchart(stock1, stock2, stock3, stockShare1, stockShare2, stockShare3, stock1value, stock2value, stock3value, remainder) 
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
      
      //this function gets the selected stock and then sends it to the changedValue function where a window prompt is called
      function selectHandler() {
          var selectedItem = chart.getSelection()[0];
          if (selectedItem) {
            var stock = data.getValue(selectedItem.row, 0);
            var value = data.getValue(selectedItem.row, 1);
            if(stock == stock1)
            	changeValue(stock,value,stockShare1);
            else if(stock == stock2)
            	changeValue(stock,value,stockShare2);
            else
            	changeValue(stock3, value, stockShare3);
          }
        }
      
      google.visualization.events.addListener(chart, 'select', selectHandler); 
      	
      chart.draw(data, options);
    }
}

//This window calls a window prompt showing stock, stock price and stock shares
function changeValue(stock,value,share)
{
	var newAmount = prompt('Please enter the new amount:  \n'+ 'Stock = '+stock + ', Value = ' + value + ', Shares =  '+ share,share);
	changeElement(newAmount,stock,value,share);
}


function changeElement(newAmount,stock,value,share)
{
    //new value of stock times new stock shares entered
	var newValue = (newAmount * (value/share));
	//alert("New Value = " + newValue);
/////////////////////////////////////	probably needs an ajax function/////////////////////////////////////////
	//document.getElementById("stock1shares").innerHTML = newAmount;
	//document.getElementById("stock1investment").innerHTML = newValue;
}