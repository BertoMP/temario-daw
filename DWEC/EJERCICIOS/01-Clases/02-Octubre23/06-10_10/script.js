const miBoton = document.getElementById('boton1');

miBoton.addEventListener('click', function(evento){
    // Todos los eventos generan un evento en sí.
    console.log(evento);
    /* En el atributo target vemos el elemento en el que 
       se ha ejecutado el evento. */
    console.log(evento.target);
    /* Delegación de eventos: Hace que un evento se herede
       a los hijos del el elemento. */
});