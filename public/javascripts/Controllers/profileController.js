myAppModule.controller("profileController", function($scope, dataService) {
    $scope.user;
    $scope.hoursPercent;
    $scope.students = [];

    $scope.$on('userInfo', function(event, user) {
        $scope.user = user;
        $scope.hoursPercent = user.curr_hours / user.req_hours * 100;

        if ($scope.hoursPercent > 100) {
            $scope.hoursPercent = 100;
        }

        if ($scope.user.role.name == "teacher") {
            dataService.getMethod("/users/school/class").then(function(data) {
                $scope.students = data;
            })
        }
    })

    $scope.$emit('getUser');
});