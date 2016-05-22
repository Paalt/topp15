<?php  
	if(!defined(ABSPATH)){
		$pagePath = explode('/wp-content/', dirname(__FILE__));
		include_once(str_replace('wp-content/' , '', $pagePath[0] . '/wp-load.php'));
	}
?>

<nav class="nav-primary" role="navigation">
    <ul class="menu" role="menu">
        
        <li ng-class="{active: activePage == '/'}" ng-click="setPage('/')" id="primary-nav-to-topp15" class="menu__item zeta" role="menuitem">
        	<a class="" href="<?php echo esc_url( home_url( '/' ) ); ?>">Topp 15</a>
        </li>
        
        <li ng-class="{active: activePage == '/nyheter'}" ng-click="setPage('/nyheter')" id="primary-nav-to-news" class="menu__item zeta" role="menuitem">
        	<a href="" >Nyheter</a>
        </li>
            
        <li ng-class="{active: activePage == '/barneboker'}" ng-click="setPage('/barneboker')" id="primary-nav-to-barn" class="menu__item zeta" role="menuitem">
        	<a href="">Barn</a>
        </li>
        
        <li ng-class="{active: activePage == '/favoritter'}" ng-click="setPage('/favoritter')" class="menu__item zeta" role="menuitem">
        	<a href="favoritter">Favoritter</a>
        </li>
        
        <li ng-class="{active: activePage == '/anmeldelser'}" ng-click="setPage('/anmeldelser')" class="menu__item zeta" role="menuitem">
        	<a href="anmeldelser">Anmeldelser</a>
        </li>
        
        <li ng-class="{active: isActive}" ng-click="setPage('/finnibutikk')" class="menu__item zeta" role="menuitem">
        	<a href="finnibutikk">Finn i butikk</a>
        </li>
        
    </ul>
</nav>