angular.module('topp15')
	.factory('getMedia', ['$http', function PostFactory($http) {
		"use strict";
		return {
			single: function(id) {
				return $http({method: 'GET', url: 'wp-json/wp/v2/media/' + id});
			}
		};
	}]);
	