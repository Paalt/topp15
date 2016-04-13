angular.module('topp15')
	.factory('activeState', function activeStateFactory() {
		"use strict";
		var activePage = ''; 
		return {
			setActivePage: function(location) {
				activePage = location;
			},
			getActivePage: function() {
				return activePage;
			}
		};
	});
	