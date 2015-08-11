/**
 * Created by ishan_000 on 8/1/2015.
 */
(function() {
	angular.module('myApp').controller('ReservationListViewController',
			reserveFn);
	reserveFn.$inject = [ '$location', 'reservationListServ' ];

	function reserveFn($location, reservationListServ) {
		var reserveVm = this;
		reserveVm.tab1 = true;
		reserveVm.tab2 = false;
		
		reserveVm.reserveList = [];

		reserveVm.tabViewReserve = function(tabDisp) {
			console.log("inside reserve controller function");
			if (tabDisp == "tab1") {
				reserveVm.tab1 = true;
				reserveVm.tab2 = false;

			} else {
				reserveVm.tab1 = false;
				reserveVm.tab2 = true;
			}
		}

		
		reserveVm.dispReservationList=function() {
			var searchCode = reservationListServ.getReservationCode();
			var promise = reservationListServ
					.getSelectedReservation();

			promise.then(function(data) {
				console.log(data);
				
				reserveVm.reservationData = data.payload;
				console.log(reserveVm.reservationData);
				
			}, function(error) {
				console.log(data.message);

			});

		}
		


	}

})();
