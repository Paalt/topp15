angular.module('topp15')
	.factory('getNews', ['$http', function PostFactory($http) {
		"use strict";
		return {
			getSingle: function(id) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/nyheter/' + id});
			},
			getAll: function() {
				return $http({method: 'GET', url: 'wp-json/wp/v2/nyheter?filter[posts_per_page]=999'});
			},
			getByCategory: function(catId) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/posts?filter[posts_per_page]=999&filter[categories]=' + catId});
			},
		};
	}]);
	