<?php

namespace Roots\Sage\Extras;

use Roots\Sage\Setup;

/**
 * Add a logo uploader to the Theme Customizer. 
 */
function topp15_logo_customizer( $wp_customize ) {
	$wp_customize->add_section( 'topp15_logo_section' , array(
		'title'       => __( 'Logo', 'topp15' ),
		'priority'    => 30,
		'description' => 'Upload a logo to replace the default site name and description in the header',
	) );
	$wp_customize->add_setting( 'topp15_logo' );
	$wp_customize->add_control( new \WP_Customize_Image_Control( $wp_customize, 'topp15_logo', array(
    'label'    => __( 'Logo', 'topp15' ),
    'section'  => 'topp15_logo_section',
    'settings' => 'topp15_logo',
) ) );
}
add_action('customize_register', __NAMESPACE__ . '\\topp15_logo_customizer');

/**
 * Add <body> classes
 */
function body_class($classes) {
  // Add page slug if it doesn't exist
  if (is_single() || is_page() && !is_front_page()) {
    if (!in_array(basename(get_permalink()), $classes)) {
      $classes[] = basename(get_permalink());
    }
  }

  // Add class if sidebar is active
  if (Setup\display_sidebar()) {
    $classes[] = 'sidebar-primary';
  }

  return $classes;
}
add_filter('body_class', __NAMESPACE__ . '\\body_class');

/**
 * Clean up the_excerpt()
 */
function excerpt_more() {
  return ' &hellip; <a href="' . get_permalink() . '">' . __('Continued', 'sage') . '</a>';
}
add_filter('excerpt_more', __NAMESPACE__ . '\\excerpt_more');
