<?php use Roots\Sage\Titles; ?>

<header class="page-header" role="banner">
	<page-header></page-header>
    
    <div class="page-header__newsletter">
    	<form>
        	<h3 class="epsilon">Meld deg på vårt nyhetsbrev</h3>
            <label class="newsletter__label">
            	<input type="text" placeholder="Din e-post...">
            	<button class="newsletter__button" type="submit"><i class="material-icons md-light md-18">mail_outline</i></button>
            </label>     
        </form>
    </div>
    
    <nav class="page-header__navigation">
        <h1><?= Titles\title(); ?></h1>
        <ul>
        	<li>Item 1</li>
        </ul>
    </nav>
</header>

