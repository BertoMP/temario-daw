// Código con métodos y propiedades JQuery para acceder el DOM 
// Sintaxis básica
// $(<selector>).metodos()

$(document).ready(function() { // ¿Estará deprecado?
    // Selector mediante id
    $('#mx').hide(3000);
    // Selector mediante clase css
    $('.escritores').css('color','violet');
    // Selector mediante clase css y posición
    $('.escritores:eq(2)').css('font-size','24px');
    // Selector mediante combinación
    $('#directores li').addClass('cine');
})
