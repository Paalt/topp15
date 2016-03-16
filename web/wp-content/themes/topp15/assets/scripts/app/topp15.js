angular.module('topp15', ['ngMaterial', 'ngAnimate', 'ngAria', 'ngMessages'])
	/*.config(function($mdThemingProvider) {
		'use strict';
		$mdThemingProvider.theme('default')
			.primaryPalette('pink')
			.accentPalette('orange');
	});*/
	.config(['$mdThemingProvider', function($mdThemingProvider) {
		"use strict";
		$mdThemingProvider.theme('default')
			.primaryPalette('indigo')
			.accentPalette('pink')
			.warnPalette('red');
		}]);