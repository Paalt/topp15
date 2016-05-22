angular.module('topp15')
	.factory('getTags', ['$http', function PostFactory($http) {
		"use strict";
		return {
			getSingle: function(id) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/tags/' + id});
			},
			getAll: function() {
				return $http({method: 'GET', url: 'wp-json/wp/v2/tags?filter[per_page]=999'});
			}
		};
	}]);
	