angular.module('topp15')
	.factory('getChildren', ['$http', function PostFactory($http) {
		"use strict";
		return {
			getSingle: function(id) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/barneboker/' + id});
			},
			getAll: function() {
				return $http({method: 'GET', url: 'wp-json/wp/v2/barneboker?filter[posts_per_page]=999'});
			},
			getByCategory: function(catId) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/posts?filter[posts_per_page]=999&filter[categories]=' + catId});
			},
		};
	}]);
	