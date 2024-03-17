// SELECTORES

// 1. Seleccionar todos los elementos div que poseen la clase "module".
$('div.module');

// 2. Especificar tres selecciones que puedan seleccionar el tercer ítem de la lista desordenada #myList.
$('#myListItem');
$('#myList li:eq(2)');
$('#myList li:nth-child(3)');

// 3. Seleccionar el elemento label del elemento input utilizando un selector de atributo.
$('label[for="q"]');

// 4. Averiguar cuantos elementos en la página están ocultos.
$(':hidden').length;

// 5. Averiguar cuantas imágenes en la página poseen el atributo alt.
$('img[alt]').length;

// 6. Seleccionar todas las filas impares del cuerpo de la tabla.
$('tbody tr:odd');

// RECORRER EL DOM
// 1. Seleccionar todas las imágenes en la página; registrar en la consola el atributo alt de cada imagen.
const imagenes = $('img');

imagenes.each(function () {
	const altAtributo = $(this).attr('alt');
	console.log(altAtributo);
});

// 2. Seleccionar el elemento input, luego dirigirse hacia el formulario y añadirle una clase al mismo.
$('input.input_text')
	.closest('form')
	.addClass('nuevaClase');

/* 3. Seleccionar el ítem que posee la clase “current” dentro de la lista #myList y remover dicha clase en el
	  elemento; luego añadir la clase “current” al siguiente ítem de la lista. */
const itemActual = $('#myList .current').removeClass('current');
const siguienteItem = itemActual.next();
siguienteItem.addClass('current');


// 4. Seleccionar el elemento select dentro de #specials; luego dirigirse hacia el botón submit.
const select = $('#specials select');
const submit = select.closest('#specials').find(':submit');
submit.css('font-size', '2rem');

/* 5. Seleccionar el primer ítem de la lista en el elemento #slideshow; añadirle la clase “current” al mismo y luego
 	  añadir la clase “disabled” a los elementos hermanos. */
const primerItem = $('#slideshow li:first-child');
primerItem.addClass('current');
primerItem.siblings().addClass('disabled');

// MANIPULACIÓN
// 1. Añadir 5 nuevos ítems al final de la lista desordenada #myList.
const listado = $('#myList');

for (let i = 0; i < 5; i++) {
	$(`<li>Nuevo elemento ${i}</li>`).appendTo(listado);
}

// 2. Remover los ítems impares de la lista.
$('#myList li:odd').remove();
$('#myList li:nth-child(odd)').remove();

// 3. Añadir otro elemento h2 y otro párrafo al último div.module.
const ultimoDivModule = $('div.module:last');
ultimoDivModule.append('<h2>Encabezado nuevo</h2>');
ultimoDivModule.append('<p>Parrafo nuevo</p>');

// 4. Añadir otra opción al elemento select; darle a la opción añadida el valor “Wednesday”.
$('#specials select').append('<option value="Wednesday">Wednesday</option>');

/* 5. Añadir un nuevo div.module a la página después del último; luego añadir una copia de una de las imágenes
      existentes dentro del nuevo div. */
const imagen = $('img[alt="vegetables"]');
const nuevoDiv = $('<div class="module"/>');

nuevoDiv.append(imagen.clone()).insertAfter('div.module:last');