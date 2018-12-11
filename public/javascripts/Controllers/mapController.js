myAppModule.controller("mapController", function ($scope, dataService, $q, $compile) {
    var map;
    $scope.user;
    $scope.dataLoaded = false;
    
    $scope.$on('userInfo', function(event, user) {
        $scope.user = user;
        $scope.dataLoaded = true;
    })

    // loads google map
    $scope.load = function () {
        var  addressUserLocation;
        
        $scope.getAddressCoords($scope.user.address + ', ' + $scope.user.city).then(function(data) {
            addressUserLocation = data;

            map = new google.maps.Map(document.getElementById('map'), {
                zoom: 16,
                center: addressUserLocation
            });

            var homeMarkerIcon = {
                url: "http://www.pvhc.net/img228/okvgqsmegtgiyaauhqlf.png", // url
                scaledSize: new google.maps.Size(50, 50) // scaled size
            };

            var homeMarker = new google.maps.Marker({
                position: addressUserLocation,
                map: map,
                icon: homeMarkerIcon,
                title: "הבית שלי"
            });

            var infoHomeWindow = new google.maps.InfoWindow({
                content: "מיקום הבית שלך"
            });
            homeMarker.addListener('click', function() {
                infoHomeWindow.open(map, homeMarker);
            });
        })

        dataService.getMethod("/organizations/all").then(function(data) {
            var OrganizationIcon = {
                url: "https://www.borderless-travel.com/wp-content/uploads/2016/11/map-marker.ico", // url
                scaledSize: new google.maps.Size(50, 50) // scaled size
            };

            data.forEach(function(element) {
                $scope.getAddressCoords(element.address).then(function(data) {
                    var organizationMarker = new google.maps.Marker({
                        position: data,
                        map: map,
                        icon: OrganizationIcon
                    });

                    var infoOrgWindow = new google.maps.InfoWindow({
                        content: "<div class='container'><div class='header'><h1> " + element.name +
                                 " </h1></div><p class='lead'> " + element.desc + 
                                 " </p><p> " + element.address + 
                                 " </p></div>"
                    });
                    organizationMarker.addListener('click', function() {
                        infoOrgWindow.open(map, organizationMarker);
                    });
                });
            });
        })

        dataService.getMethod("/events/all").then(function(data) {
            var EventIcon = {
                url: "https://www.i-nexus.com/wp-content/themes/iNexus/images/Map_icon.svg.png", // url
                scaledSize: new google.maps.Size(40, 50) // scaled size
            };

            data.forEach(function(element) {
                $scope.getAddressCoords(element.address).then(function(data) {
                    var eventMarker = new google.maps.Marker({
                        position: data,
                        map: map,
                        icon: EventIcon
                    });

                    var htmlElement = "<div class='container'><div class='header'><h1> " + element.name +
                                       " </h1></div><p class='lead'> From " + new Date(element.start_date).toLocaleDateString("he-IL") + " To " + new Date(element.end_date).toLocaleDateString("he-IL") +
                                       " </p><p> " + element.address +
                                       " </p><button class='btn btn-warning' ng-click='myFunction()'>התנדב לאירוע זה!</button></div>";
                    var compiled = $compile(htmlElement)($scope)

                    var infoEventWindow = new google.maps.InfoWindow({
                        content: compiled[0]
                    });
                    eventMarker.addListener('click', function() {
                        infoEventWindow.open(map, eventMarker);
                    });
                });
            });
        }) 
    };

    $scope.getAddressCoords = function(address) {
        var deffered = $q.defer();

        var geocoder = new google.maps.Geocoder();
        var coords = null;

        geocoder.geocode( { 'address': address}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                var latitude = results[0].geometry.location.lat();
                var longitude = results[0].geometry.location.lng();
                
                deffered.resolve({lat: latitude, lng: longitude});
            } 
        }); 

        return deffered.promise;
    }

    $scope.myFunction = function(element) {
        alert("הוסף בהצלחה!");
    }

    $scope.$emit('getUser');
});
