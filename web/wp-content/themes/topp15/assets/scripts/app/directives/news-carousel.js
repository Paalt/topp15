angular.module('topp15')
	.directive('newsCarousel', ['getTags', 'getNews', function(getTags, getNews) {
		"use strict";
		return {
			restrict: "E",
			scope: {
				catNewsId: '=',
				},
			templateUrl: themeUri.templates + "directives/news-carousel.php",
			link: function(scope){
				
				//API call for book data
				getNews.getAll()
					.success(function(data) {
						scope.newsList = data;
						scope.error = data.error;
						
						//Convert Rank from string to float, so that Orderby works properly
						angular.forEach(scope.newsList, function (detail) {
							detail.Rank = parseFloat(detail.Rank);
						});
						
					})
			
					.error(function(data, status) {
						scope.error = 'En teknisk feil har oppstått. Feilkode' + status + 'Vennligst kontakt Kundeservice';
					});
				
				/* ** Carousel controls** */
				
				scope.imgIndex = 0;
		
				scope.setImgIndex = function(index) {
					scope.imgIndex = index;
				};
				
				scope.hasPlayed = function(index) {
					return scope.getProgress(index);
				};
				
				scope.isCurrentImgIndex = function(index) {
					return scope.imgIndex === index;
				};	
				
				scope.nextImg = function() {
					scope.imgIndex = (scope.imgIndex < scope.newsList.length - 1) ? ++scope.imgIndex : 0;
				};
				
				scope.prevImg = function() {
					scope.imgIndex = (scope.imgIndex > 0) ? --scope.imgIndex : scope.newsList.length - 1;
				};
			}	
		};
	}]);