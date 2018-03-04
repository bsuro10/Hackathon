var myAppModule = angular.module('myApp', ["ngRoute"]);

myAppModule.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/Profile', {
        templateUrl: 'Routes/Profile.html',
        controller: 'profileController'
      }).
      when('/Map', {
        templateUrl: 'Routes/Map.html',
        controller: 'mapController'
      }).
      otherwise({
        redirectTo: '/Profile'
      });
  }]);


