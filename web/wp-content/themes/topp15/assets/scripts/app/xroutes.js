angular.module('topp15')
	
	.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
		"use strict";
		$locationProvider.html5Mode(true);
		
		$routeProvider
		
		.when('/', {
			templateUrl: themeUri.pages + 'topp15.html',
			controller: 'Topp15'
		})
			
		.when('/book/:ID', {
			templateUrl: themeUri.pages + 'book.html',
			controller: 'Book'
		})
		
		.when('/anmeldelser', {
			templateUrl: themeUri.pages + 'anmeldelser.html',
			controller: 'Anmeldelser'
		})	
		
		.when('/favoritter', {
			templateUrl: themeUri.pages + 'favoritter.html',
			controller: 'Favoritter'
		})
		
		.otherwise({
			redirectTo: '/'
		  });
	
	}])
	
	.controller('Topp15', ['$scope', '$http', '$location', 'activeState', function($scope, $http, $location, activeState) {
		"use strict";
		$http.get('wp-json/wp/v2/posts').success(function(res){
			$scope.posts = res;
		});
		
		//Set the active page by url
		$scope.thisPage = $location.path();
		activeState.setActivePage($scope.thisPage);
		
	}])
	
	.controller('Book', ['$scope', '$http', '$routeParams', '$location', 'activeState', function($scope, $http, $routeParams, $location, activeState) {
		"use strict";
		$http.get('wp-json/wp/v2/posts/' + $routeParams.ID).success(function(res){
			$scope.post = res;
		});
		
		//Set the active page by url
		$scope.thisPage = $location.path();
		activeState.setActivePage($scope.thisPage);
	}])
	
	.controller('Anmeldelser', ['$scope', '$http', '$location', 'activeState', function($scope, $http, $location, activeState) {
		"use strict";
		
		$http.get('wp-json/wp/v2/posts/').success(function(res){
			$scope.post = res;
		});
		
		//Set the active page by url
		$scope.thisPage = $location.path();
		activeState.setActivePage($scope.thisPage);
	}])
	
	.controller('Favoritter', ['$scope', '$http', '$location', 'activeState', function($scope, $http, $location, activeState) {
		"use strict";
		$http.get('wp-json/wp/v2/posts/').success(function(res){
			$scope.post = res;
		});
		
		//Set the active page by url
		$scope.thisPage = $location.path();
		activeState.setActivePage($scope.thisPage);
	}]);