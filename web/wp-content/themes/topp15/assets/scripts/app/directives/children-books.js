angular.module('topp15')
	.directive('childrenBooks', ['getTags', 'getChildren', function(getTags, getChildren) {
		"use strict";
		return {
			restrict: "E",
			scope: {
				},
			templateUrl: themeUri.templates + "directives/children-books.php",
			link: function(scope){
				
				//API call for book data
				getChildren.getAll()
					.success(function(data) {
						scope.childrenBooksList = data;
						scope.error = data.error;
						
						//Convert Rank from string to float, so that Orderby works properly
						angular.forEach(scope.newsList, function (detail) {
							detail.Rank = parseFloat(detail.Rank);
						});
						
					})
			
					.error(function(data, status) {
						scope.error = 'En teknisk feil har oppstått. Feilkode' + status + 'Vennligst kontakt Kundeservice';
					});
				
				//API call for tags		
				getTags.getAll()
					.success(function(data) {
						scope.tags = data;
						scope.error = data.error;
					})
					
					.error(function(data, status) {
						scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
						console.error(scope.error);
					});
			}	
		};
	}]);