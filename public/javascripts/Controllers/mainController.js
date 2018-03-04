myAppModule.controller("mainController", function($scope) {

    $scope.$on('getUser', function(event) {
        // TODO: Get the user from the dataservice
        // TODO: Send it via broadcast
        $scope.$broadcast('userInfo', $scope.user);
    })
});