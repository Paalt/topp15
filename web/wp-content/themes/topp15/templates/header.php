<header class="banner">
	<div class="container">
    	<!-- Logo  -->
        <div class="site-branding">
            <!-- If a logo is uploaded we show the logo-->
            <?php if ( get_theme_mod( 'topp15_logo' ) ) : ?>
                <div class='site-logo'>
                    <a class="brand" href='<?php echo esc_url( home_url( '/' ) ); ?>' title='<?php echo esc_attr( get_bloginfo( 'name', 'display' ) ); ?>' rel='home'><img id="logo" src='<?php echo esc_url( get_theme_mod( 'topp15_logo' ) ); ?>' alt='<?php echo esc_attr( get_bloginfo( 'name', 'display' ) ); ?>'></a>
                </div>
            <!-- Else we show the title -->
            <?php else : ?>
                <hgroup>
                    <h1 class='site-title'><a href='<?php echo esc_url( home_url( '/' ) ); ?>' title='<?php echo esc_attr( get_bloginfo( 'name', 'display' ) ); ?>' rel='home'><?php bloginfo( 'name' ); ?></a></h1>
                    <h2 class='site-description'><?php bloginfo( 'description' ); ?></h2>
                </hgroup>
            <?php endif; ?>
        </div>
		<!-- Primary Navigation-->
        <nav class="nav-primary" ng-controller="activeLocationCtrl">
			<?php
            if (has_nav_menu('primary_navigation')) :
            wp_nav_menu(['theme_location' => 'primary_navigation', 'menu_class' => 'nav']);
            endif;
            ?>
        </nav>
        <md-button class="md-raised md-primary">Click me</md-button>
        <md-button class="md-raised md-accent">or maybe me</md-button>
        <md-button class="md-raised md-warn">Careful</md-button>
        
	</div>
</header>
