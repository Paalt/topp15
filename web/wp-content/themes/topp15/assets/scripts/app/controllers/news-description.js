angular.module('topp15')
	.controller('newsDescriptionController', ['$scope', '$mdDialog', function($scope, $mdDialog){	
		"use strict";
		
		var self = this;
		
		self.hidden = false;
		self.isOpen = false;
		self.hover = false;
			
		self.openDialog = function($event, description) {
			// Show the dialog
			$mdDialog.show({
				clickOutsideToClose: true,
				controller: ['$mdDialog', function($mdDialog) {
					// Save the clicked item
					this.description = description;
					// Setup some handlers
					this.close = function() {
						$mdDialog.cancel();
					};
					this.submit = function() {
						$mdDialog.hide();
					};
				  }],
				  controllerAs: 'newsDescription',
				  templateUrl: themeUri.pages + 'news-description.html',
				  targetEvent: $event
			});
		};
      
	}]);
	