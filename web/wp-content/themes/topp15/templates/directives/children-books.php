<article layout="row" layout-wrap>
    <div flex="25" ng-repeat="book in childrenBooksList | orderBy: 'Rank'">
        <div class="ranking-list-children__title">
            <h3 class="epsilon">{{book.Tittel}}</h3>
        </div>
        
        <cover-image cover-image="{{book.featured_media}}" class="ranking-list-children__image-container"></cover-image>
        
        
        <div class="ranking-list-news__description-container" ng-controller="newsDescriptionController as modal">
	
            <p class="ranking-list-news__description-item" ng-bind-html="book.content.rendered"></p>
            
            <div class="ranking-list-news--fade-to-grey"></div>
            
            <div layout="row" layout-align="space-around center">
                <md-button class="md-raised md-primary" ng-click="modal.openDialog($event, book.content.rendered)">Les mer</md-button>
                <span></span>
                <p class="ranking-list-news__price delta">{{book.Pris}},- kr</p>
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
    </div>
</article>
