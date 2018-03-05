myAppModule.controller("mapController", function ($scope, dataService) {

    var map;
    var allOrganiztions;
    var geocoder;

    // loads google map
    $scope.load = function () {
        geocoder = new google.maps.Geocoder();
        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 3,
            center: new google.maps.LatLng(2.8, -187.3)
        });

        // initializes map with organization's locations
        initAssociations();
    };

    var initAssociations = function () {

        // gets from server all organizations
        dataService.getMethod('/organizations').then(function (data) {
            allOrganiztions = data
            for (var i = 0; i < allOrganiztions.length; i++) {
                var coords = getLocFromAdress(allOrganiztions[i].address);

                if (coords != null) {
                    var marker = new google.maps.Marker({
                        position: new google.maps.LatLng(coords[0], coords[1]),
                        map: map
                    });
                }

            }
        });


    }

    var getLocFromAdress = function (address) {

        geocoder.geocode({
            'address': address
        }, function (result, status) {
            if (status == google.maps.GeocoderStatus.OK) {

                return ([result[0].geometry.location.lat(), result[0].geometry.location.lng()])
            } else {
                return null
            }
        })

    }
});
