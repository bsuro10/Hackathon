var LoginModule = angular.module('LoginModule', []);

LoginModule.controller("LoginController", function($scope, dataService) {
    $scope.submit = function() {
        dataService.getMethod('users/' + $scope.username);
        window.location = "views/index.html";
    };
});
