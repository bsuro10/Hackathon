myAppModule.controller("profileController", function($scope, dataService) {
    $scope.user;
    $scope.hoursPercent;
    $scope.students = [];
    $scope.unapproveEvents = [];
    $scope.isTeacher = false;
    $scope.isManager = false;
    $scope.dataLoaded = false;

    $scope.$on('userInfo', function(event, user) {
        $scope.user = user;
        $scope.dataLoaded = true;
        $scope.hoursPercent = user.curr_hours / user.req_hours * 100;

        if ($scope.hoursPercent > 100) {
            $scope.hoursPercent = 100;
        }

        if ($scope.user.role.name == "teacher") {
            dataService.getMethod("/users/school/class").then(function(data) {
                $scope.students = data;
                $scope.isTeacher = true;
            })
        } else if ($scope.user.role.name == "manager") {
            dataService.getMethod("/organizations/events/unapprove").then(function(data) {
                $scope.unapproveEvents = data;
                $scope.isManager = true;
            })
        }
    })

    $scope.$emit('getUser');
});