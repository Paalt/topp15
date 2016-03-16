<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'mbtopp15');

/** MySQL database username */
define('DB_USER', 'root');

/** MySQL database password */
define('DB_PASSWORD', 'root');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8mb4');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'Diy+$I(K*0Me 0z!(,fR--(D<VC+Mb_- UE~STLoItlGOK<(<St1~ebj>Odu #E1');
define('SECURE_AUTH_KEY',  'fy<J-2}^4 3ZpTtL5o)_wC8_:+~E~&zD+c%[g?BD}q?yyKVi0V|)7/fg5d-m|>M`');
define('LOGGED_IN_KEY',    '%E$#;^fSGZfgQm.A28<`CbZ4?tj=+uDP/ni[<6F;y)78]M]Ta}]2DMM)2SYP>gTG');
define('NONCE_KEY',        '@[3&;f$t/CrstwNzt#UFhVGPTF|7[a|J( 3bckQi-d4-`j_o9,tHB<*r7-}diS6K');
define('AUTH_SALT',        'p7I>gW+6TwsQ&ze8GI.(~0[V<PxuRl +G*/Wz?DgAAe-cZTS`Nh$LzC*4s++6]TU');
define('SECURE_AUTH_SALT', '[R%]_dm?-3&.0$=z+Do &]ww$rFGlu)&9%9}54I,?Ek:)2aSyn[j;Ee: e(AB%_p');
define('LOGGED_IN_SALT',   '.Mb%(`-.b=aG7rj*S|.0{-/75buF$|N$].T]82W+R$EnxHoyh)+ I;0>cvIa|+|d');
define('NONCE_SALT',       'Xc5qRtj*2Gj-(0BFwMC3V{Bk*q`!hK2 O:Arp8|Llcny9Q-0ii>Y6%#L|YwtX=+X');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'mb_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the Codex.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define('WP_DEBUG', true);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
