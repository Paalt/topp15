angular.module('topp15')
	.controller('newsletterController', ['$scope', '$mdDialog', function($scope, $mdDialog){	
		"use strict";
		
		var self = this;
		
		self.hidden = false;
		self.isOpen = false;
		self.hover = false;
			
		self.openDialog = function($event, item) {
			// Show the dialog
			$mdDialog.show({
				clickOutsideToClose: true,
				controller: ['$mdDialog', function($mdDialog) {
					// Save the clicked item
					this.item = item;
					// Setup some handlers
					this.close = function() {
						$mdDialog.cancel();
					};
					this.submit = function() {
						$mdDialog.hide();
					};
				  }],
				  controllerAs: 'newsletterForm',
				  templateUrl: themeUri.pages + 'newsletter-form.html',
				  targetEvent: $event
			});
		};
      
	}]);
	