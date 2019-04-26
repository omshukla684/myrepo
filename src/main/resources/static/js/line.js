 Highcharts.chart('container1', {

	    title: {
	        text: ' 2019-2019'
	    },

	    subtitle: {
	        text: 'Source:Mobiloitte.com'
	    },

	    yAxis: {
	        title: {
	            text: 'Number of Users'
	        }
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },

	    plotOptions: {
	        series: {
	            label: {
	                connectorAllowed: false
	            },
	            pointStart: 2019
	        }
	    },

	    series: [{
	        name: 'Admin',
	        data: [0,${admincount}]
	    }, {
	        name: 'User',
	        data: [${usercount}]
	    }],

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    }

	});