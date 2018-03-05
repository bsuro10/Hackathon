LoginModule.controller("LoginController", function($scope, dataService) {
    $scope.submit = function() {
        dataService.getMethod('users/' + $scope.username).then(function() {
            window.location = "views/index.html";
        });
    };
});
