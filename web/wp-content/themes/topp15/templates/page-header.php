<header class="page-header" role="banner">
	<page-header></page-header>
    
    <nav class="sticky-navigation" ng-controller="newsletterController as modal">
    
        <md-fab-speed-dial 
        	md-open="dial.isOpen" 
        	md-direction="up" 
            class="md-scale"
            ng-mouseenter="dial.isOpen=true" 
            ng-mouseleave="dial.isOpen=false">
            
            <md-fab-trigger>
            
                <md-button aria-label="social-menu" class="md-fab md-primary">
                	<md-icon md-svg-icon="menu" class="icon--size-36"></md-icon>
                </md-button>
            
            </md-fab-trigger>
            
            <md-fab-actions>
            
                <md-button aria-label="Nyhetsbrev" class="md-fab md-raised md-mini" ng-click="modal.openDialog($event, item)">
                	<md-icon md-svg-icon="email" class="icon--size-18"></md-icon>
                </md-button>
                
                <md-button aria-label="Facebook" class="md-fab md-raised md-mini">
                	<md-icon md-svg-icon="facebook" class="icon--size-18"></md-icon>
                </md-button>

            </md-fab-actions>
        </md-fab-speed-dial>	
    </nav>  
</header>