function loadCSS () {
    var navigation_css = document.createElement('link');
    navigation_css.type = 'text/css';
    navigation_css.rel = 'stylesheet';
    navigation_css.href = '/css/navigation.css';
    document.head.appendChild(navigation_css);

	var styles_css  = document.createElement('link');
	styles_css.type = 'text/css';
	styles_css.rel  = 'stylesheet';
	styles_css.href = '/css/styles.css';
	document.head.appendChild(styles_css);

	var full_glitch_effect_text_css  = document.createElement('link');
	full_glitch_effect_text_css.type = 'text/css';
	full_glitch_effect_text_css.rel  = 'stylesheet';
	full_glitch_effect_text_css.href = '/css/full-glitch-effect-text.css';
	document.head.appendChild(full_glitch_effect_text_css);

	var horizontal_glitch_effect_text_css  = document.createElement('link');
	horizontal_glitch_effect_text_css.type = 'text/css';
	horizontal_glitch_effect_text_css.rel  = 'stylesheet';
	horizontal_glitch_effect_text_css.href = '/css/horizontal-glitch-effect-text.css';
	document.head.appendChild(horizontal_glitch_effect_text_css);

	var header_css  = document.createElement('link');
	header_css.type = 'text/css';
	header_css.rel  = 'stylesheet';
	header_css.href = '/css/header.css';
	document.head.appendChild(header_css);

	var cyberpunk_like_glitch_button_css  = document.createElement('link');
	cyberpunk_like_glitch_button_css.type = 'text/css';
	cyberpunk_like_glitch_button_css.rel  = 'stylesheet';
	cyberpunk_like_glitch_button_css.href = '/css/cyberpunk-like-glitch-button.css';
	document.head.appendChild(cyberpunk_like_glitch_button_css);
};

loadCSS();