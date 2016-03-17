angular.module('topp15')
	.config(['$locationProvider', function($locationProvider) {
		"use strict";
	  $locationProvider.html5Mode(true).hashPrefix('!');
	}])
	
	.controller('activeLocationCtrl', ['$scope', '$location', function ($scope, $location) {
		"use strict";
		
		$scope.path = $location.path();
		
		console.log($scope.path + 'fire');
		
		
	 	//do something
	}]);