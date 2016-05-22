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
					scope.activePage = activeState.getActivePage();	
				};
				
				scope.getPage();
				
				scope.setPage = function(location) {
					scope.activePage = location;
				};
				
				
				/* Due to horrible support in Angular 1 for hashtag scrolling, jQuery which is already installed in wordpress is used. The angular way would be to use anchorScroll combided with location and use a url paramater. However this rerenders the entire view which is not what we want */
				
				/** Primary navigation anchor scrolling **/
				jQuery("#primary-nav-to-topp15").click(function() {
					jQuery('html, body').animate({
						scrollTop: jQuery("#topp15").offset().top
					}, 1000);
				});
				
				jQuery("#primary-nav-to-news").click(function() {
					jQuery('html, body').animate({
						scrollTop: jQuery("#nyheter").offset().top
					}, 1000);
				});
				
				jQuery("#primary-nav-to-barn").click(function() {
					jQuery('html, body').animate({
						scrollTop: jQuery("#barneboker").offset().top
					}, 1000);
				});		
				
			}
		};
	}]);