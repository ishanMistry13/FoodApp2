angular.module('myApp')
		.service('reservationListServ', getAllReservationService);

getAllReservationService.$inject = [ '$http', '$q' ];

function getAllReservationService($http, $q) {

	var searchTerm;
	var dataList;

	var reservationCode = function(code) {

		console.log("Search Code:" + code);
		searchTerm = code;

	};
	
	function getDataList(){
		
		return dataList;
		
	}

	var getReservationCode = function() {

		return searchTerm;

	};

	var getSelectedReservation = function() {
		
		var deferred = $q.defer();

		$http(
				{
					method : 'GET',
					url : 'http://localhost:8080/FoodProjApp/api/Reservation/codeReserve/'+searchTerm,
					contentType : "application/json"

				}).success(function(data, status, headers, config) {
			deferred.resolve(data);
			console.log("Data recieved in service");

		}).error(function(data, status, headers, config) {

			deferred.reject("An unknown error occurred.");

		}

		);

		return deferred.promise;

	}

	var getReservations = function() {

		var deferred = $q.defer();

		$http(
				{
					method : 'GET',
					url : 'http://localhost:8080/FoodProjApp/api/Reservation/allReservations',
					contentType : "application/json"

				}).success(function(data, status, headers, config) {
			deferred.resolve(data);
			console.log("Data recieved in service");

		}).error(function(data, status, headers, config) {

			deferred.reject("An unknown error occurred.");

		}

		);

		return deferred.promise;
	}

	return {
		getReservations : getReservations,
		reservationCode : reservationCode,
		getReservationCode : getReservationCode,
		getSelectedReservation : getSelectedReservation

	};

}
