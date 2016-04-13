angular.module('topp15')
	.directive('navPrimary', ['activeState', function(activeState) {
		"use strict";
		return {
			restrict: "E",
			templateUrl: themeUri.templates + "directives/nav-primary.php",
			link: function(scope){
				
				scope.activePage = "";
				
				//On refresh, set the active page to the current page by reading the current URL
				scope.getPage = function() {
					scope.activePage =  activeState.getActivePage();	
				};
				
				scope.getPage();
				
				scope.setPage = function(location) {
					scope.activePage = location;
				};
			}	
		};
	}]);