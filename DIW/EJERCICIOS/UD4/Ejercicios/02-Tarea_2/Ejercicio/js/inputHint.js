// Constante para almacenar el elemento input.input_text.
const input = $('.input_text');

// Constante para almacenar el elemento label.
const label = $('label');

// Constante para almacenar el texto del elemento label.
const textLabel = label.text();

$(document).ready(function() {
	// Establece el valor del elemento input igual al valor del elemento label.
	input.val(textLabel);

	// Añade la clase 'hint' al elemento input.
	input.addClass('hint');

	// Remover el elemento label.
	label.remove();

	// Vincular un evento focus.
	input.focus (function() {
		input.val('')
			.removeClass('hint');
	});

	// Vincular un evento blur.
	input.blur(function() {
		if (input.val() === '') {
			input.val(textLabel)
				.addClass('hint');
		}
	});
});