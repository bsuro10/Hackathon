myAppModule.controller("mainController", function($scope, dataService) {
    $scope.user;
    $scope.dataLoaded = false;

    dataService.getMethod('/users/current').then(function(data) {
        $scope.user = data;
        $scope.dataLoaded = true;
    });
    
    $scope.$on('getUser', function(event) {
        // TODO: Get the user from the dataservice
        // TODO: Send it via broadcast
        $scope.$broadcast('userInfo', $scope.user);
    })
});