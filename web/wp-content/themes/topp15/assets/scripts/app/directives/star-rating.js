angular.module('topp15')
	.directive('starRating', ['getMedia', function(getMedia) {
		"use strict";
		return {
			restrict: "E",
			templateUrl: themeUri.templates + "directives/star-rating.php",
			scope: {
			},
			link: function(scope){
				
				scope.star1 = true;
				scope.star2 = true;
				scope.star3 = true;
				scope.star4 = true;
				scope.star5 = true;
					
				scope.rateBook = function(stars) {
					if (stars === 1) {
						scope.star1 = false;
					} else if (stars === 2) {
						scope.star1 = false;
						scope.star2 = false;
					} else if (stars === 3) {
						scope.star1 = false;
						scope.star2 = false;
						scope.star3 = false;
					} else if (stars === 4) {
						scope.star1 = false;
						scope.star2 = false;
						scope.star3 = false;
						scope.star4 = false;
					} else if (stars === 5) {
						scope.star1 = false;
						scope.star2 = false;
						scope.star3 = false;
						scope.star4 = false;
						scope.star5 = false;
					}
					
					//TODO: Persist the rating in DB
				};
			}	
		};
	}]);