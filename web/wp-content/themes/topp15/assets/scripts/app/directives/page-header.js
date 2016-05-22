angular.module('topp15')
	.directive('pageHeader', ['getMedia', function(getMedia) {
		"use strict";
		return {
			restrict: "E",
			templateUrl: themeUri.templates + "directives/page-header.php",
			link: function(scope){
				
				//Get media files
				getMedia.single(15).success(function(res){
					scope.media = res;
				});
			}	
		};
	}]);