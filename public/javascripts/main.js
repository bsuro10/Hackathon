var myAppModule = angular.module('myApp', []);

myAppModule.controller("mainController", function($scope) {
    $scope.test = "ran"; 
});