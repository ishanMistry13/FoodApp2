/**
 * Created by ishan_000 on 8/2/2015.
 */

(function () {


    angular.module('myApp').controller('tabViewController', tabViewFn);

    tabViewFn.$inject=['$location','$http','$window'];

    function tabViewFn($location, $http, $window ) {
        var tabVm = this;

        //tabVm.maintemplate1 = 'mainResLoginTpl.html';



        tabVm.tab1 = true;
        tabVm.tab2 = false;
        console.log("inside tabview controller");

        tabVm.reserve = function (tabDisp) {
            console.log("inside function");
            if (tabDisp == "tab1") {
                tabVm.tab1 = true;
                tabVm.tab2 = false;

            } else {

                tabVm.tab1 = false;
                tabVm.tab2 = true;


            }


        }


        tabVm.ownerLogin = function(){
            //$http
            // console.log("Executing http in tabview controller");

        }
        
        
        tabVm.searchRes = function(){        	
        		$location.path('/searchReservation');        		
        }



            //Function for submiting new reservation data
            tabVm.submitReserve=function(){


                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/FoodProjApp/api/Reservation/addRes',
                    data: tabVm.newRes
                }).success(function(data){
                    console.log(data);
                    tabVm.newRes = null;
                    $window.alert("Reservation added successfully with id");

                }).error(function(error){
                    console.log(error);
                });


            }




    }


})();
