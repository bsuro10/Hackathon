myAppModule.controller("profileController", function($scope) {
    $scope.user;

    $scope.$on('userInfo', function(event, user) {
        $scope.user = user;
    })

    $scope.$emit('getUser');
});