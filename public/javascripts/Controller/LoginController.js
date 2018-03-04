var LoginModule = angular.module('LoginModule', []);

LoginModule.controller("LoginController", function($scope) {
    $scope.submit = function() {
        window.location = "views/index.html";
    };
});
