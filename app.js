/**
 * Created by ishan_000 on 8/1/2015.
 */
(function () {


    angular
        .module('myApp', ['ngRoute'])
        .config(moduleConfig);

    moduleConfig.$inject=['$routeProvider'];

    function moduleConfig($routeProvider){

        $routeProvider
            .when('/Home',{
                templateUrl:'HomeLoginView/mainResLoginTpl.html',
                controller:'tabViewController',
                controllerAs: 'tabVm'

            })
            .when('/searchReservation',{
                templateUrl:'Reservations/searchResTpl.html',
                controller:'searchReserveViewController',
                controllerAs: 'searchVm'

            })
            .when('/viewReservationList',{
                templateUrl:'Reservations/reservationListViewTpl.html',
                controller:'ReservationListViewController',
                controllerAs: 'reserveVm',
                

            })
            
            .otherwise({

                redirectTo:'/Home'

            });





    }





})();