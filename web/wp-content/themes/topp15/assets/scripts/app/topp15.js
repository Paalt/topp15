angular.module('topp15', ['ngRoute', 'ngMaterial', 'ngAnimate', 'ngAria', 'ngMessages', 'ngSanitize'])
	
	.config(['$mdThemingProvider', '$mdIconProvider', function($mdThemingProvider, $mdIconProvider) {
		"use strict";
		
		 $mdIconProvider
    		.defaultIconSet('wp-content/themes/topp15/dist/images/mdi.svg');
		
		$mdThemingProvider.definePalette('mbOrange', {
			'50': 'ffebee',
			'100': 'ffcdd2',
			'200': 'F7931E',
			'300': 'e57373',
			'400': 'FEFEFE',
			'500': 'f44336',
			'600': 'e53935',
			'700': 'd32f2f',
			'800': 'c62828',
			'900': 'b71c1c',
			'A100': 'E09810', //Hue 1
			'A200': 'F7931E', // Default
			'A400': 'FBC212', // Hue 2
			'A700': 'E06210', // Hue 3
			'contrastDefaultColor': 'light',    // whether, by default, text (contrast)
												// on this palette should be dark or light
			'contrastDarkColors': ['50', '100', //hues which contrast should be 'dark' by default
			 '200', '300', '400', 'A100'],
			'contrastLightColors': undefined    // could also specify this if default was 'dark'
		});
		
		$mdThemingProvider.definePalette('mbBlack', {
			'50': 'ffebee',
			'100': 'ffcdd2',
			'200': 'F7931E',
			'300': 'e57373',
			'400': 'FEFEFE',
			'500': 'f44336',
			'600': 'e53935',
			'700': 'd32f2f',
			'800': 'c62828',
			'900': 'b71c1c',
			'A100': 'E09810', //Hue 1
			'A200': '0F0F0F', // Default
			'A400': 'FBC212', // Hue 2
			'A700': 'E06210', // Hue 3
			'contrastDefaultColor': 'light',    // whether, by default, text (contrast)
												// on this palette should be dark or light
			'contrastDarkColors': ['50', '100', //hues which contrast should be 'dark' by default
			 '200', '300', '400', 'A100'],
			'contrastLightColors': undefined    // could also specify this if default was 'dark'
		});
		
		$mdThemingProvider.theme('default')
			.primaryPalette('mbOrange', {
			  'default': 'A200', // by default use shade 400 from the pink palette for primary intentions
			  'hue-1': 'A100', // use shade 100 for the <code>md-hue-1</code> class
			  'hue-2': 'A400', // use shade 600 for the <code>md-hue-2</code> class
			  'hue-3': 'A700' // use shade A100 for the <code>md-hue-3</code> class
			})
		
			.accentPalette('mbBlack', {
			  'default': 'A200', // by default use shade 400 from the pink palette for primary intentions
			  'hue-1': 'A100', // use shade 100 for the <code>md-hue-1</code> class
			  'hue-2': 'A400', // use shade 600 for the <code>md-hue-2</code> class
			  'hue-3': 'A700' // use shade A100 for the <code>md-hue-3</code> class
			})
		
			.warnPalette('red');
		}]);
	
 