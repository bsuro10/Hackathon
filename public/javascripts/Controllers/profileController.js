myAppModule.controller("profileController", function($scope) {
    $scope.user;
    $scope.hoursPercent;

    $scope.$on('userInfo', function(event, user) {
        $scope.user = user;
        $scope.hoursPercent = user.curr_hours / user.req_hours * 100;
    })

    $scope.$emit('getUser');
});