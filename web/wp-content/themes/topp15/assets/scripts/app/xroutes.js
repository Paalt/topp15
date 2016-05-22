angular.module('topp15')
	.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
		"use strict";
		$locationProvider.html5Mode(true);
		
		$routeProvider
		
		.when('/', {
			templateUrl: themeUri.pages + 'topp15.html',
			controller: 'Topp15'
		})
			
		.when('/book/:ID', {
			templateUrl: themeUri.pages + 'book.html',
			controller: 'Book'
		})
		
		.when('/anmeldelser', {
			templateUrl: themeUri.pages + 'anmeldelser.html',
			controller: 'Anmeldelser'
		})	
		
		.when('/favoritter', {
			templateUrl: themeUri.pages + 'favoritter.html',
			controller: 'Favoritter'
		})
		
		.otherwise({
			redirectTo: '/'
		  });
	
	}])
	
	.controller('Topp15', ['$scope', '$http', '$location', 'activeState', 'getTopp15', 'getNews', '$mdMedia', '$mdDialog', function($scope, $http, $location, activeState, getTopp15, getNews, $mdMedia, $mdDialog) {
		"use strict";
		
		//Api calls to retrieve book data
		getTopp15.getAll()
			.success(function(data) {
				$scope.topp15List = data;
				$scope.error = data.error;
				
				//Convert Rank from string to float, so that Orderby works properly
				angular.forEach($scope.topp15List, function (detail) {
					detail.Rank = parseFloat(detail.Rank);
				});
				
			})
			
			.error(function(data, status) {
				$scope.error = 'En teknisk feil har oppstått. Feilkode' + status + 'Vennligst kontakt Kundeservice';
			});
			
		getNews.getAll()
			.success(function(data) {
				$scope.newsList = data;
				$scope.error = data.error;
				
				//Convert Rank from string to float, so that Orderby works properly
				angular.forEach($scope.newsList, function (detail) {
					detail.Rank = parseFloat(detail.Rank);
				});
				
			})
			
			.error(function(data, status) {
				$scope.error = 'En teknisk feil har oppstått. Feilkode' + status + 'Vennligst kontakt Kundeservice';
			});
		
		
		//Set the active page by url
		$scope.thisPage = $location.path();
		activeState.setActivePage($scope.thisPage);
		
		
		//Popup when clicking on a book
		$scope.status = '  ';
		$scope.customFullscreen = $mdMedia('xs') || $mdMedia('sm');
		
		$scope.showDetails = function(ev, rank, type) {	
		
			$scope.parentScopeData = rank;
		
			var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
		
			$mdDialog.show({
				locals:{bookID: $scope.parentScopeData},
				controller: ['$scope', '$mdDialog', 'getTopp15', 'bookID', 'getMedia', '$sce', function($scope, $mdDialog, getTopp15, bookID, getMedia, $sce) {
					
					//Popup options and controls
					$scope.mdDialogData = bookID;
					
					$scope.hide = function() {
						$mdDialog.hide();
					};
					$scope.cancel = function() {
						$mdDialog.cancel();
					};
					$scope.answer = function(answer) {
						$mdDialog.hide(answer);
					};
					
					//API calls to retrive book data inside popup
					if (type === 'topp15') {
						
						getTopp15.getSingle(bookID)
							.success(function(data) {
								$scope.book = data;
								$scope.error = data.error;
								
								getMedia.single($scope.book.featured_media)
									.success(function(data) {
										$scope.media = data.guid.rendered;
										$scope.alt = data.title.rendered;
										$scope.error = data.error;
									})
										
									.error(function(data, status) {
										$scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
										console.error($scope.error);
									});
								
							})
							
							.error(function(data, status) {
								$scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
								console.error($scope.error);
							});
							
					} else if (type === 'news') {
					
						getNews.getSingle(bookID)
							.success(function(data) {
								$scope.book = data;
								$scope.error = data.error;
								
								getMedia.single($scope.book.featured_media)
									.success(function(data) {
										$scope.media = data.guid.rendered;
										$scope.alt = data.title.rendered;
										$scope.error = data.error;
									})
										
									.error(function(data, status) {
										$scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
										console.error($scope.error);
									});
								
							})
							
							.error(function(data, status) {
								$scope.error = 'En teknisk feil har oppstått. Feilkode' + status;
								console.error($scope.error);
							});
					}
					
				}],
				templateUrl: themeUri.pages + 'book.html',
				parent: angular.element(document.body),
				targetEvent: ev,
				clickOutsideToClose:true,
				fullscreen: useFullScreen
			})
			.then(function(answer) {
				$scope.status = 'You said the information was "' + answer + '".';
			}, function() {
				$scope.status = 'You cancelled the dialog.';
			});
			
			$scope.$watch(function() {
				return $mdMedia('xs') || $mdMedia('sm');
			}, function(wantsFullScreen) {
				$scope.customFullscreen = (wantsFullScreen === true);
			});
		};
	
	}])
	
	.controller('Book', ['$scope', '$http', '$routeParams', '$location', 'activeState', function($scope, $http, $routeParams, $location, activeState) {
		"use strict";
		$http.get('wp-json/wp/v2/posts/' + $routeParams.ID).success(function(res){
			$scope.post = res;
		});
		
		//Set the active page by url
		$scope.thisPage = $location.path();
		activeState.setActivePage($scope.thisPage);
	}])
	
	.controller('Anmeldelser', ['$scope', '$http', '$location', 'activeState', function($scope, $http, $location, activeState) {
		"use strict";
		
		$http.get('wp-json/wp/v2/posts/').success(function(res){
			$scope.post = res;
		});
		
		//Set the active page by url
		$scope.thisPage = $location.path();
		activeState.setActivePage($scope.thisPage);
	}])
	
	.controller('Favoritter', ['$scope', '$http', '$location', 'activeState', function($scope, $http, $location, activeState) {
		"use strict";
		$http.get('wp-json/wp/v2/posts/').success(function(res){
			$scope.post = res;
		});
		
		//Set the active page by url
		$scope.thisPage = $location.path();
		activeState.setActivePage($scope.thisPage);
	}]);