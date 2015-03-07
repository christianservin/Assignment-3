function piechart(stock1, stock2, stock3, stock1value, stock2value, stock3value, remainder) 
{	
	google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Stock', 		'Price'],
        [stock1,     	stock1value],
        [stock2,      	stock2value],
        [stock1,  		stock3value],
        ['Remainder',  	remainder]
      ]);

      var options = {
        title: ''
      };

      var chart = new google.visualization.PieChart(document.getElementById('piechart'));

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
        [stock1,  		stock3value],
        ['Remainder',  	remainder]
      ]);

      var options = {
        chart: {
          title: ''
        },
        bars: 'vertical' // Required for Material Bar Charts.
      };

      var chart = new google.charts.Bar(document.getElementById('barchart'));

      chart.draw(data, options);
    }
}