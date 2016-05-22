angular.module('topp15')
	.directive('topp15List', ['getMedia', function(getMedia) {
		"use strict";
		return {
			restrict: "E",
			templateUrl: themeUri.templates + "directives/topp15-list.php",
			scope: {
				coverImage: '@',
				rank: '@'
			},
			link: function(scope){
				scope.show = false;
				
				getMedia.single(scope.coverImage)
					.success(function(data) {
						scope.media = data.guid.rendered;
						scope.alt = data.title.rendered;
						scope.error = data.error;
						scope.show = true;
					})
						
					.error(function(data, status) {
						scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
						console.error(scope.error);
					});
			}	
		};
	}]);