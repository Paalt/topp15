<?php  
	if(!defined(ABSPATH)){
		$pagePath = explode('/wp-content/', dirname(__FILE__));
		include_once(str_replace('wp-content/' , '', $pagePath[0] . '/wp-load.php'));
	}
?>

<nav class="nav-secondary" role="navigation">
    <ul class="menu-secondary" role="menu">
        
        <li 
        	ng-if="section == 'topp15'" 
            ng-click="showAllTopp15()" 
            ng-class="{'active-category': !activeTopp15Category}" 
            class="menu__item-secondary zeta" 
            role="menuitem">
        	<a href="#">Alle</a>
        </li>
        
        <li 
        	ng-if="section == 'topp15' && item.count > 0"
            ng-repeat="item in menuItems" 
            ng-class="{'active-category': activeTopp15Category == item.name}" 
            ng-click="setTopp15Category(item.name, item.id)" 
            class="menu__item-secondary zeta" 
            role="menuitem">
        	<a href="#">{{item.name}}</a>
        </li>
        
        <li 
        	ng-if="section == 'news'" 
            ng-click="showAllNews()" 
            ng-class="{'active-category': !activeNewsCategory}" 
            class="menu__item-secondary zeta" 
            role="menuitem">
        	<a href="#">Alle</a>
        </li>
        
        <li 
        	ng-if="section == 'news' && item.count > 0" 
            ng-repeat="item in menuItems" 
            ng-class="{'active-category': activeNewsCategory == item.name}" 
            ng-click="setNewsCategory(item.name, item.id)" 
            class="menu__item-secondary zeta" 
            role="menuitem">
        	<a href="#">{{item.name}}</a>
        </li>
        
    </ul>
</nav>