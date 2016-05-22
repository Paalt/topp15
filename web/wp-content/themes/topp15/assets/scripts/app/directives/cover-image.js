angular.module('topp15')
	.directive('coverImage', ['getMedia', function(getMedia) {
		"use strict";
		return {
			restrict: "E",
			templateUrl: themeUri.templates + "directives/cover-image.php",
			scope: {
				coverImage: '@',
			},
			link: function(scope){
				
				//Get images of book covers
				getMedia.single(scope.coverImage)
					.success(function(data) {
						scope.media = data.guid.rendered;
						scope.alt = data.title.rendered;
						scope.error = data.error;
					})
						
					.error(function(data, status) {
						scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
						console.error(scope.error);
					});
					
			}	
		};
	}]);