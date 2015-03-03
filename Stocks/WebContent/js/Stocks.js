$('#datatable').editableTableWidget();
$(document).ready(function() {
	main();
});

function main() {
	// piechart("<%=stocks.getStock1()%>","<%=stocks.getStock2()%>","<%=stocks.getStock3()%>",<%=stocks.getStock1investment()%>,<%=stocks.getStock2investment()%>,<%=stocks.getStock3investment()%>,<%=stocks.getInvestmentRemainder()%>);
	piechart(document.getElementById("stock1").innerHTML, 
			document.getElementById("stock2").innerHTML,
			document.getElementById("stock3").innerHTML,
			parseFloat(document.getElementById("stock1investment").innerHTML),
			parseFloat(document.getElementById("stock2investment").innerHTML),
			parseFloat(document.getElementById("stock3investment").innerHTML),
			parseFloat(document.getElementById("investmentRemainder").innerHTML));
	barchart();
}

function piechart(stock1, stock2, stock3, stock1value, stock2value, stock3value, remainder) 
{	
	$('#piechart').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Pie Chart'
        },
        tooltip: {
            //pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: '$',
            data: [
                [stock1,   		stock1value],
                [stock2,   		stock2value],
                [stock3,   		stock3value],
                ['Remainder',   remainder]
            ]
        }]
    });
}

function barchart() 
{
	$('#barchart').highcharts({
        data: {
            table: 'datatable'
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'Bar Chart'
        },
        yAxis: {
            allowDecimals: false,
            title: {
                text: ''
            }
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    this.point.y + ' ' + this.point.name.toLowerCase();
            }
        }
    });
}