<?php  
	if(!defined(ABSPATH)){
		$pagePath = explode('/wp-content/', dirname(__FILE__));
		include_once(str_replace('wp-content/' , '', $pagePath[0] . '/wp-load.php'));
	}
?>
<div class="page-header__background">
	<div class="page-header__background--transparent">
    	<div class="page-header__logo">
        	<img class="page-header__logo-image" ng-src="{{media.guid.rendered}}" alt="logo">
        </div>
    </div>
</div>