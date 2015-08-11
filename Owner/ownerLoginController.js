/**
 * Created by ishan_000 on 8/1/2015.
 */


(function () {

    angular.module('myApp').controller('ownerLoginViewController', ownerLoginFn);

    ownerLoginFn.$inject=['$location'];

    function ownerLoginFn($location) {
        var ownerVm = this;


        ownerVm.ownerLogin = function(){

            //$http

            console.log("executing http in ownerLoginController");


            $location.path('');




        }

    }


})();