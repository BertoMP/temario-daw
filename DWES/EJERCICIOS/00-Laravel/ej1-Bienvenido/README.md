# EJERCICIO 1 - BIENVENIDO A LARAVEL
## Descripción

Crea un sitio web con Laravel que contenga el título "Bienvenidos a Laravel",
un texto de bienvenida (puede ser un poco de Lorem Ipsum) y a continuación un
menú de navegación con sus correspondientes alias y los siguientes enlaces:

* **Inicio**: Enlace a la página principal donde se visualizará el texto de Lorem Ipsum
además de los elementos estáticos (Título y menú de navegación).  
* **Nosotros**: Enlace que vaya a la página "nosotros" y muestre, además de los elementos estáticos de todo el sitio,
  un h2 que diga: *"Estás en la sección Nosotros"*
* **Proyecto**: Enlace que cargue una vista con el siguiente texto *"Estás en el proyecto número: X"* donde X es un 
  número entero que podamos introducirlo en la propia ruta. Si no se mete ningún número en la ruta, por defecto 
  tiene que ser 1; por ejemplo http://localhost:8000/proyecto/123456  

Recuerda que el título y el menú de navegación han de aparecer en todas las vistas que cargues.
