<article layout="row" layout-wrap layut-align="center center"x>
	
    <div flex="5" class="carousel__arrow-prev">
    	<a href="" ng-click="prevImg()">
        	<md-icon md-svg-icon="triangle-outline" class="icon--size-48 md-primary carousel__left-controller"></md-icon>
        </a>
    </div>
	
    <div flex="90" 
    	 class="ranking-list-news__table-row"
    	 layout="row" 
         layout-align="center-top"
         layout-wrap
         ng-init="setImgIndex(0)">
        
        <news-list 
        	flex="33"  
        	ng-repeat="book in newsList | orderBy: 'Rank' | filter: {'Nyheter-sjanger': catNewsId}"
            cover-image="{{book.featured_media}}"
            author="{{book.Forfatter}}"
            description="{{book.content.rendered}}"
            tags="book.tags"
            price="{{book.Pris}}"
            class="ranking-list-news"
            ng-hide="!isCurrentImgIndex($index) && !isCurrentImgIndex($index + -2) && !isCurrentImgIndex($index - 1)">
        </news-list>
    
    </div>
	
    <div flex="5" class="carousel__arrow-next">
        <a href="" ng-click="nextImg()">
            <md-icon md-svg-icon="triangle-outline" class="icon--size-48 md-primary carousel__right-controller"></md-icon>
        </a>
    </div>

</article>