myAppModule.service('dataService', function($http, $q) {
    this.getMethod = function(url) {
        var deffered = $q.defer();

        $http.get(url)
        .success(function(data) {
            deffered.resolve(data);
        }).error(function() {
            alert("Something went wrong while getting " + url);
        });

        return deffered.promise;
    }
});