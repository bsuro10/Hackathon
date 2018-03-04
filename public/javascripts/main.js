var myAppModule = angular.module('myApp', ["ngRoute"]);
var LoginModule = angular.module('Login', []);

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
     when('/Organizations', {
        templateUrl: 'Routes/organizations.html',
        controller: 'OrgController'
      }).
      otherwise({
        redirectTo: '/Profile'
      });
  }]);


