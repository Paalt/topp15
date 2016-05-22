<?php 
/*Plugin Name: Topp15 - Sjangre
Description: This plugin add custom categories to the 'Topp15', 'Nyheter' and 'Barnebøker' post types so that they can hace indpendent categories, for use in navigation etc.
Version: 1.0
License: GPLv2
*/
function topp15_register_taxonomy() {
	// set up labels
	$labels = array(
		'name'              => 'Topp15 sjanger',
		'singular_name'     => 'Topp15 sjanger',
		'search_items'      => 'Søk i sjangre for Topp15',
		'all_items'         => 'Alle sjangre for Topp15',
		'edit_item'         => 'Rediger sjanger for Topp15',
		'update_item'       => 'Oppdater sjanger for Topp15',
		'add_new_item'      => 'Legg til ny sjanger for Topp15',
		'new_item_name'     => 'Ny sjanger for Topp15',
		'menu_name'         => 'Sjangere for Topp15'
	);
	// register taxonomy
	register_taxonomy( 'topp15_sjanger', 'topp15', array(
		'hierarchical' => true,
		'labels' => $labels,
		'show_ui'           => true,
		'rewrite'           => array( 'slug' => 'Sjanger for topp15' ),
		'query_var' => true,
		'show_in_rest'       => true,
  		'rest_base'          => 'Topp15-sjanger',
  		'rest_controller_class' => 'WP_REST_Terms_Controller',
		'show_admin_column' => true
	) );

}

function nyheter_register_taxonomy() {
	// set up labels
	$labels = array(
		'name'              => 'Nyhet sjanger',
		'singular_name'     => 'Nyhet sjanger',
		'search_items'      => 'Søk i sjangre for nyheter',
		'all_items'         => 'Alle sjangre for nyheter',
		'edit_item'         => 'Rediger sjanger for nyheter',
		'update_item'       => 'Oppdater sjanger for nyheter',
		'add_new_item'      => 'Legg til ny sjanger for nyheter',
		'new_item_name'     => 'Ny sjanger for nyheter',
		'menu_name'         => 'Sjangere for nyheter'
	);
	// register taxonomy
	register_taxonomy( 'nyheter_sjanger', 'nyheter', array(
		'hierarchical' => true,
		'labels' => $labels,
		'show_ui'           => true,
		'rewrite'           => array( 'slug' => 'Sjanger for nyheter' ),
		'query_var' => true,
		'show_in_rest'       => true,
  		'rest_base'          => 'Nyheter-sjanger',
  		'rest_controller_class' => 'WP_REST_Terms_Controller',
		'show_admin_column' => true
	) );

}


function barneboker_register_taxonomy() {
	// set up labels
	$labels = array(
		'name'              => 'Barnebok sjanger',
		'singular_name'     => 'Barnebok sjanger',
		'search_items'      => 'Søk i sjangre for barnebøker',
		'all_items'         => 'Alle sjangre for barnebøker',
		'edit_item'         => 'Rediger sjanger for barnebøker',
		'update_item'       => 'Oppdater sjanger for barnebøker',
		'add_new_item'      => 'Legg til ny sjanger for barnebøker',
		'new_item_name'     => 'Ny sjanger for barnebøker',
		'menu_name'         => 'Sjangere for barnebøker'
	);
	// register taxonomy
	register_taxonomy( 'barnebok_sjanger', 'barneboker', array(
		'hierarchical' => true,
		'labels' => $labels,
		'show_ui'           => true,
		'rewrite'           => array( 'slug' => 'Sjanger for barnebøker' ),
		'query_var' => true,
		'show_in_rest'       => true,
  		'rest_base'          => 'Barnebok-sjanger',
  		'rest_controller_class' => 'WP_REST_Terms_Controller',
		'show_admin_column' => true
	) );

}
add_action( 'init', 'topp15_register_taxonomy' );
add_action( 'init', 'nyheter_register_taxonomy' );
add_action( 'init', 'barneboker_register_taxonomy' );

?>
