angular.module('topp15')
	.directive('newsList', ['getMedia', 'getTags', function(getMedia, getTags) {
		"use strict";
		return {
			restrict: "E",
			templateUrl: themeUri.templates + "directives/news-list.php",
			scope: {
				coverImage: '@',
				author: '@',
				description: '@',
				tags: '=',
				price: '@'
			},
			link: function(scope){
				
				scope.likeToggle = true;
				
				//Get tags for each book
				
				scope.tagList = [];
				angular.forEach(scope.tags, function(tag, i) {
					getTags.getSingle(tag)
						.success(function(data) {
							scope.tagList.push(data.name);
							scope.error = data.error;
						})
							
						.error(function(data, status) {
							scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
							console.error(scope.error);
						});
				});
				
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
					
				scope.likeBook = function() {
					//TODO: Persist the like in a DB
				};
			}	
		};
	}]);