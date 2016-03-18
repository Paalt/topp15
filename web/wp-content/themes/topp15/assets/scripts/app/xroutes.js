angular.module('topp15')
	
	.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
		"use strict";
		$locationProvider.html5Mode(true);
		
		$routeProvider
		
		.when('/', {
			templateUrl: themeUri.pages + 'topp15.html',
			controller: 'Topp15'
		})
		
		.when('/:ID', {
			templateUrl: themeUri.pages + 'book.html',
			controller: 'Book'
		});
	
	}])
	
	.controller('Topp15', ['$scope', '$http', function($scope, $http) {
		"use strict";
		$http.get('wp-json/wp/v2/posts').success(function(res){
			$scope.posts = res;
		});
	}])
	
	.controller('Book', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {
		"use strict";
		$http.get('wp-json/wp/v2/posts/' + $routeParams.ID).success(function(res){
			$scope.post = res;
		});
	}]);