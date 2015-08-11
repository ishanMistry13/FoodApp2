/**
 * Created by ishan_000 on 8/3/2015.
 */
(function() {

	angular.module('myApp').controller('searchReserveViewController',
			searchViewCtrlFn);

	searchViewCtrlFn.$inject = [ '$location', 'reservationListServ' ];
	function searchViewCtrlFn($location, reservationListServ) {
		var searchVm = this;

		searchVm.searchReservation = function() {

			var promise = reservationListServ.reservationCode(searchVm.searchReserveCode);
			
			$location.path('/viewReservationList');
		

			

		}

	}

})();