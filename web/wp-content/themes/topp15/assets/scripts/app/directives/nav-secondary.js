angular.module('topp15')
	.directive('navSecondary', ['activeState', 'getCategories', function(activeState, getCategories) {
		"use strict";
		return {
			restrict: "E",
			scope: {
				catTopp15Id: '=',
				catNewsId: '=',
				section: '@'
			},
			templateUrl: themeUri.templates + "directives/nav-secondary.php",
			link: function(scope){
				
				//Initially view all categories
				scope.activeTopp15Category = "";
				scope.activeNewsCategory = "";
				
				//Call to API for categories, check for what section
				if(scope.section === 'topp15') {
					getCategories.getAllTopp15()
						.success(function(data) {
							scope.menuItems = data;
							scope.error = data.error;
						})
						
						.error(function(data, status) {
							scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
							console.error(scope.error);
						});
						
				} else if(scope.section === 'news') {
					getCategories.getAllNews()
						.success(function(data) {
							scope.menuItems = data;
							scope.error = data.error;
						})
						
						.error(function(data, status) {
							scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
							console.error(scope.error);
						});
				}
				
				//Setters and getters for category navigation and filtering
				scope.showAllTopp15 = function() {
					scope.catTopp15Id = "";
					scope.activeTopp15Category = "";
				};	
				
				scope.showAllNews = function() {
					scope.catNewsId = "";
					scope.activeNewsCategory = "";
				};	
				
				scope.setTopp15Category = function(catName, catID) {
					scope.activeTopp15Category = catName;
					scope.catTopp15Id = catID;
				};
				
				scope.setNewsCategory = function(catName, catID) {
					scope.activeNewsCategory = catName;
					scope.catNewsId = catID;
				};
			}	
		};
	}]);