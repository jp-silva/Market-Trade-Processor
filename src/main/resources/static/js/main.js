$(document).ready(function(){

	// dataPoints
	var dps = [];
	var dps2 = [];
	
	var chart = new CanvasJS.Chart("chartContainer",{
		title :{
			text: "Live amount bought - amount sold for EUR/GBP AND USD/GBP"
		},
		data: [{
			type: "line",
			dataPoints: dps
		},{
			type: "line",
			dataPoints: dps2
		}]
	});

	var updateInterval = 100;
	var dataLength = 500; // number of dataPoints visible at any point

	var updateCurrencyVolumeArrays = function () {
		$.getJSON( "/api/trade-messages", function( response ) {
			var data = response.data;
			var now = new Date();

			dps.push({
					x: now,
					y: data["EUR/GBP"]
				});
			dps2.push({
				x: now,
				y: data["USD/GBP"]
			});

			if (dps.length > dataLength) {
				dps.shift();
			}
			if (dps2.length > dataLength) {
				dps2.shift();
			}
		});
	};

	//get latest currency volume values
	updateCurrencyVolumeArrays();

	// update chart after specified time. 
	setInterval(function(){
		updateCurrencyVolumeArrays();
		chart.render();
	}, updateInterval); 
});