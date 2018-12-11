myAppModule.controller("OrgController", function($scope, $http) {
    
    $scope.orgReq = $http.get("user/org").then(function(data) {
        $scope.organizations = data;
    });
    
    
    $scope.details = function(org) {
        
    };
});
