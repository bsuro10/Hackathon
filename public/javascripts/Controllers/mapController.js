myAppModule.controller("mapController", function ($scope) {

    var map;
    
    $scope.getAllAssociations = function()
    
    $scope.load = function () {
        map = new google.maps.Map(document.getElementById('map'), {zoom : 1, center: new google.maps.LatLng(2.8,-187.3)});
        $scope.initAssociations();
    };

    $scope.initAssociations = function () {
        for (var i = 0; i < allAssociations.length; i++) {
            var coords = allAssociations[i];
            var marker = new google.maps.Marker({
                position:  new google.maps.LatLng(coords.x, coords.y),
                map: map
            });
        }
    }
});
