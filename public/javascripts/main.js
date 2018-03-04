var myAppModule = angular.module('myApp', ["ngRoute"]);

myAppModule.controller("mainController", function($scope) {
    $scope.test = "ran";
});

myAppModule.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/Profile', {
        templateUrl: '../views/Routes/Profile.html'
        //controller: 'AddOrderController'
      }).
      when('/Map', {
        templateUrl: '../views/Routes/Map.html',
        controller: 'mapController'
      }).
      otherwise({
        redirectTo: '/Profile'
      });
  }]);


