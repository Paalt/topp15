<?php

namespace Roots\Sage\Setup;

use Roots\Sage\Assets;

/**
 * Theme setup
 */
function setup() {
  // Enable features from Soil when plugin is activated
  // https://roots.io/plugins/soil/
  add_theme_support('soil-clean-up');
  add_theme_support('soil-nav-walker');
  add_theme_support('soil-nice-search');
  add_theme_support('soil-jquery-cdn');
  add_theme_support('soil-relative-urls');

  // Make theme available for translation
  // Community translations can be found at https://github.com/roots/sage-translations
  load_theme_textdomain('sage', get_template_directory() . '/lang');

  // Enable plugins to manage the document title
  // http://codex.wordpress.org/Function_Reference/add_theme_support#Title_Tag
  add_theme_support('title-tag');

  // Register wp_nav_menu() menus
  // http://codex.wordpress.org/Function_Reference/register_nav_menus
  register_nav_menus([
    'primary_navigation' => __('Primary Navigation', 'sage')
  ]);

  // Enable post thumbnails
  // http://codex.wordpress.org/Post_Thumbnails
  // http://codex.wordpress.org/Function_Reference/set_post_thumbnail_size
  // http://codex.wordpress.org/Function_Reference/add_image_size
  add_theme_support('post-thumbnails');

  // Enable post formats
  // http://codex.wordpress.org/Post_Formats
  add_theme_support('post-formats', ['aside', 'gallery', 'link', 'image', 'quote', 'video', 'audio']);

  // Enable HTML5 markup support
  // http://codex.wordpress.org/Function_Reference/add_theme_support#HTML5
  add_theme_support('html5', ['caption', 'comment-form', 'comment-list', 'gallery', 'search-form']);

  // Use main stylesheet for visual editor
  // To add custom styles edit /assets/styles/layouts/_tinymce.scss
  add_editor_style(Assets\asset_path('styles/main.css'));
}
add_action('after_setup_theme', __NAMESPACE__ . '\\setup');

/**
 * Register sidebars
 */
function widgets_init() {
  register_sidebar([
    'name'          => __('Primary', 'sage'),
    'id'            => 'sidebar-primary',
    'before_widget' => '<section class="widget %1$s %2$s">',
    'after_widget'  => '</section>',
    'before_title'  => '<h3>',
    'after_title'   => '</h3>'
  ]);

  register_sidebar([
    'name'          => __('Footer', 'sage'),
    'id'            => 'sidebar-footer',
    'before_widget' => '<section class="widget %1$s %2$s">',
    'after_widget'  => '</section>',
    'before_title'  => '<h3>',
    'after_title'   => '</h3>'
  ]);
}
add_action('widgets_init', __NAMESPACE__ . '\\widgets_init');

/**
 * Determine which pages should NOT display the sidebar
 */
function display_sidebar() {
  static $display;

  isset($display) || $display = !in_array(true, [
    // The sidebar will NOT be displayed if ANY of the following return true.
    // @link https://codex.wordpress.org/Conditional_Tags
    is_404(),
    is_front_page(),
    is_page_template('template-custom.php'),
  ]);

  return apply_filters('sage/display_sidebar', $display);
}

/**
 * Theme assets
 */
function assets() {
  wp_enqueue_style('sage/css', Assets\asset_path('styles/main.css'), false, null);

  if (is_single() && comments_open() && get_option('thread_comments')) {
    wp_enqueue_script('comment-reply');
  }

  wp_enqueue_script('sage/js', Assets\asset_path('scripts/main.js'), ['jquery'], null, true);
  
  wp_localize_script(
		'sage/js',
		'themeUri',
		array(
			'pages' => trailingslashit( get_template_directory_uri() ) . 'pages/',
			'templates' => trailingslashit( get_template_directory_uri() ) . 'templates/'
			)
	);
}
add_action('wp_enqueue_scripts', __NAMESPACE__ . '\\assets', 100);

/**
 * Add custom post types
 */ 
 
function register_custom_post_types() {
	register_post_type( 'Nyheter', array(
  		'labels'	=>	array(
		'all_items'           => 'Nyhet',
		'menu_name'	      		=>	'Nyheter',
		'singular_name'       =>	'Nyhet',
		'edit_item'           =>	'Rediger nyhet',
		'new_item'            =>	'Ny nyhet',
		'view_item'           =>	'Vis nyheter',
		'items_archive'       =>	'Nyheter arkiv',
		'search_items'        =>	'Søk i nyheter',
		'not_found'	      		=>	'Ingen nyheter funnet',
		'not_found_in_trash'  =>	'Ingen nyheter funnet i søppelkurven'
	),
	'supports'			=>	array( 'title', 'editor', 'author', 'revisions' ),
	'menu_position'	=>	5,
	'public'				=>	true,
	'hierarchical' => true,
	'taxonomies' => array( 'post_tag', 'category' )
));

register_post_type( 'Nyheter', array(
  		'labels'	=>	array(
		'all_items'           => 'Nyhet',
		'menu_name'	      		=>	'Nyheter',
		'singular_name'       =>	'Nyhet',
		'edit_item'           =>	'Rediger nyhet',
		'new_item'            =>	'Ny nyhet',
		'view_item'           =>	'Vis nyheter',
		'items_archive'       =>	'Nyheter arkiv',
		'search_items'        =>	'Søk i nyheter',
		'not_found'	      		=>	'Ingen nyheter funnet',
		'not_found_in_trash'  =>	'Ingen nyheter funnet i søppelkurven'
	),
	'supports'			=>	array( 'title', 'editor', 'author', 'revisions' ),
	'menu_position'	=>	5,
	'public'				=>	true,
	'hierarchical' => true,
	'taxonomies' => array( 'post_tag', 'category' )
));

register_post_type( 'Barneboker', array(
  		'labels'	=>	array(
		'all_items'           => 'Barnebok',
		'menu_name'	      		=>	'Barnebøker',
		'singular_name'       =>	'Barnebok',
		'edit_item'           =>	'Rediger barnebok',
		'new_item'            =>	'Ny barnebok',
		'view_item'           =>	'Vis barnebøker',
		'items_archive'       =>	'Barnebøker arkiv',
		'search_items'        =>	'Søk i nyheter',
		'not_found'	      		=>	'Ingen barnebøker funnet',
		'not_found_in_trash'  =>	'Ingen barnebøker funnet i søppelkurven'
	),
	'supports'			=>	array( 'title', 'editor', 'author', 'revisions' ),
	'menu_position'	=>	5,
	'public'				=>	true,
	'hierarchical' => true,
	'taxonomies' => array( 'post_tag', 'category' )
));

register_post_type( 'Topp15', array(
  		'labels'	=>	array(
		'all_items'           => 'Topplistebok ',
		'menu_name'	      	  =>	'Topp 15',
		'singular_name'       =>	'Topplistebok',
		'edit_item'           =>	'Rediger topplistebok',
		'new_item'            =>	'Ny topplistebok',
		'view_item'           =>	'Vis topplistebøker',
		'items_archive'       =>	'Topplistebøker arkiv',
		'search_items'        =>	'Søk i topplistebøker',
		'not_found'	      		=>	'Ingen topplistebøker funnet',
		'not_found_in_trash'  =>	'Ingen topplistebøker funnet i søppelkurven'
	),
	'supports'			=>	array( 'title', 'editor', 'author', 'revisions', 'thumbnail', 'custom-fields' ),
	'menu_position'	=>	5,
	'public'				=>	true,
	'publicly_queryable' => true,
	'show_ui'            => true,
	'show_in_menu'       => true,
	'show_in_rest'       => true,
	'query_var'          => true,
	'capability_type'    => 'post',
	'hierarchical' => true,
	'taxonomies' => array( 'post_tag', 'category' )
));
}

add_action( 'init', __NAMESPACE__ . '\\register_custom_post_types' );

add_post_meta( 1, 'starship', 47 );

/**
 * Add the field "spaceship" to REST API responses for posts read and write
 */
add_action( 'rest_api_init', __NAMESPACE__ . '\\slug_register_spaceship' );
function slug_register_spaceship() {
    register_rest_field( 'post',
        'starship',
        array(
            'get_callback'    => 'slug_get_spaceship',
            'update_callback' => 'slug_update_spaceship',
            'schema'          => null,
        )
    );
}
/**
 * Handler for getting custom field data.
 *
 * @since 0.1.0
 *
 * @param array $object The object from the response
 * @param string $field_name Name of field
 * @param WP_REST_Request $request Current request
 *
 * @return mixed
 */
function slug_get_spaceship( $object, $field_name, $request ) {
    return get_post_meta( $object[ 'id' ], $field_name );
}

/**
 * Handler for updating custom field data.
 *
 * @since 0.1.0
 *
 * @param mixed $value The value of the field
 * @param object $object The object from the response
 * @param string $field_name Name of field
 *
 * @return bool|int
 */
function slug_update_spaceship( $value, $object, $field_name ) {
    if ( ! $value || ! is_string( $value ) ) {
        return;
    }

    return update_post_meta( $object->ID, $field_name, strip_tags( $value ) );

}