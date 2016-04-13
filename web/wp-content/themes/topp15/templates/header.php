<header class="top-bar">
	<div class="container" layout="row" layout-align="start center">
    	<!-- Logo  -->
        <div class="site-branding" flex="25">
            <!-- If a logo is uploaded we show the logo-->
            <?php if ( get_theme_mod( 'topp15_logo' ) ) : ?>
                <div class="header__site-logo">
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
        <nav-primary flex="75"></nav-primary>
	</div>
</header>
