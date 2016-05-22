angular.module('topp15')
	.factory('getCategories', ['$http', function PostFactory($http) {
		"use strict";
		return {
			getSingleTopp15: function(id) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/Topp15-sjanger/' + id});
			},
			getAllTopp15: function() {
				return $http({method: 'GET', url: 'wp-json/wp/v2/Topp15-sjanger?filter[posts_per_page]=999'});
			},
			getSingleNews: function(id) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/Nyheter-sjanger/' + id});
			},
			getAllNews: function() {
				return $http({method: 'GET', url: 'wp-json/wp/v2/Nyheter-sjanger?filter[posts_per_page]=999'});
			},
			getSingleChildbook: function(id) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/Barnebok-sjanger/' + id});
			},
			getAllChildbooks: function() {
				return $http({method: 'GET', url: 'wp-json/wp/v2/Barnebok-sjanger?filter[posts_per_page]=999'});
			}
		};
	}]);
	