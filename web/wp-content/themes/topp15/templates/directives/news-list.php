<img class="ranking-list-news__image" ng-src="{{media}}" alt="{{alt}}">
<img class="ranking-list-news__image ranking-list-news__image--rotation-left" ng-src="{{media}}" alt="{{alt}}">
<img class="ranking-list-news__image ranking-list-news__image--rotation-right" ng-src="{{media}}" alt="{{alt}}">
<img class="ranking-list-news__image ranking-list-news__image--cutout" ng-src="{{media}}" alt="{{alt}}">

<div>
	<h3 class="gamma ranking-list-news__title">{{author}}</h3>
</div>

<div class="ranking-list-news__description-container" ng-controller="newsDescriptionController as modal">
	
    <p class="ranking-list-news__description-item" ng-bind-html="description"></p>
	<div class="ranking-list-news--fade-to-grey"></div>
    <div layout="row" layout-align="space-around center">
    	<md-button class="md-raised md-primary" ng-click="modal.openDialog($event, description)">Les mer</md-button>
        <span></span>
    	<p class="ranking-list-news__price delta">{{price}},- kr</p>
    </div>
    
</div>

<div class="ranking-list-news__rating-container" layout="row">
	<div flex="33" class="ranking-list-news__likes">
    	<a href="" ng-click="likeToggle = !likeToggle; likeBook()">
        	<md-icon ng-if="likeToggle" md-svg-icon="heart-outline" class="icon--size-24 md-primary ranking-list-news__icon-heart"></md-icon>
            <md-icon  ng-if="!likeToggle" md-svg-icon="heart" class="icon--size-24 md-primary ranking-list-news__icon-heart"></md-icon>
        </a>
    	<p class="ranking-list-news__icon-text">Liker</p>
    </div>
    <div class="ranking-list-news__views"></div>
    <div flex="66" class="ranking-list-news__rating" layout="row">
    	<star-rating></star-rating>
    </div>
</div>

<div class="ranking-list-news__tags" layout="row">
	<p ng-repeat="tag in tagList">{{tag}}</p>
</div>