myAppModule.controller("OrgController", function($scope, $http) {
    
    $scope.orgReq = $http.get("/events/current").then(function(data) {
        $scope.events = data.data;
    });
    
    
    $scope.details = function(org) {
        
    };
});
