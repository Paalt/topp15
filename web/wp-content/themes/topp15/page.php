<?php while (have_posts()) : the_post(); ?>
  <?php get_template_part('templates/page', 'header'); ?>
  <div class="main-content" ng-view></div>
  <?php get_template_part('templates/content', 'page'); ?>
<?php endwhile; ?>
