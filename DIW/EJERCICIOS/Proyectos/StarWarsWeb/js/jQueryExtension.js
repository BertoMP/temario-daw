/**
 * Extensión de jQuery para gestionar la selección/deselección de elementos con ids que comienzan con "episode-".
 *
 * @param {jQuery} $ - Instancia de jQuery.
 *
 * @function
 * @returns {jQuery} - Cadena de objetos jQuery seleccionados.
 */
(function ($) {
	/**
	 * Método para alternar la clase 'selectedFilm' en los elementos y deseleccionar los demás.
	 *
	 * @method
	 * @returns {jQuery} - Cadena de objetos jQuery seleccionados.
	 */
	$.fn.toggleSelectedFilm = function () {
		this.click(function () {
			// Alterna la clase 'selectedFilm' en el elemento clicado y deselecciona los demás.
			$(this).toggleClass('selectedFilm');
			$('[id^="episode-"]').not(this).removeClass('selectedFilm');
		});
		return this;
	};

	// Aplica la extensión a los elementos con ids que comienzan con "episode-".
	$('[id^="episode-"]').toggleSelectedFilm();
})(jQuery);
