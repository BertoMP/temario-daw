/*AQUI EL JS*/
// CLASES
/** 
 * Clase Producto
 *  
 * Representa un producto en un sistema de gestión de inventario 
 * con los atributos ID, nombre y precio.
 * 
 * Esta clase permite crear y gestionar productos, manteniendo 
 * información esencial sobre cada uno, como su ID, nombre 
 * y precio.
 * 
 * @class
 */
class Producto {
    #_id; // Identificador del producto
    #_nombre; // Nombre del producto
    #_precio; // Precio del producto

    /**
     * Constructor de la clase Producto.
     * @param {number} id - El ID del producto.
     * @param {string} nombre - El nombre del producto.
     * @param {number} precio - El precio del producto.
     */
    constructor(id, nombre, precio) {
        this.#_id = id;
        this.#_nombre = nombre;
        this.#_precio = precio;
    }

    /**
     * Obtiene el ID del producto.
     * @returns {number} El ID del producto.
     */
    getId = () => this.#_id;

    /**
     * Obtiene el nombre del producto.
     * @returns {string} El nombre del producto.
     */
    getNombre = () => this.#_nombre;

    /**
     * Obtiene el precio del producto.
     * @returns {number} El precio del producto.
     */
    getPrecio = () => this.#_precio;
}

/**
 * Clase Carrito
 * 
 * Representa un carrito de compras en un sistema de comercio electrónico.
 * El carrito almacena los elementos seleccionados por el usuario.
 *
 * @class
 */
class Carrito {
    #_contenidoCarrito; // Almacena el contenido del carrito como un Map

    /**
     * Crea una nueva instancia de la clase Carrito con un carrito vacío.
     */
    constructor() {
        this.#_contenidoCarrito = new Map();
    }

    /**
     * Obtiene el contenido del carrito.
     * @returns {Map} Un objeto Map que representa el contenido del carrito.
     */
    getContenidoCarrito = () => this.#_contenidoCarrito;
}

// FUNCIONES
/**
 * Crea un mensaje final que muestra el precio de la compra y,
 * si se aplicó un descuento, muestra el precio con descuento.
 * @function
 * @returns {void}
 */
function mensajeFinal() {
    // Crea un elemento div para mostrar el resultado.
    const productos = document.getElementById('productos');

    // Crea un párrafo para mostrar el precio de la compra.
    const parrafoPrecio = document.createElement('p');
    parrafoPrecio.innerHTML = `El precio de su compra es: ${precioTotal}€.`;
    productos.appendChild(parrafoPrecio);

    // Si se aplicó un descuento, muestra el precio con descuento.
    if (descuentoAplicado) {
        const parrafoDescuento = document.createElement('p');
        parrafoDescuento.innerHTML = `¡DESCUENTO APLICADO! El precio final de su compra es: ${precioTotal * 0.8}€.`;
        productos.appendChild(parrafoDescuento);
    }

    return;
}

/**
 * Finaliza la compra mostrando un mensaje con el precio de la compra y,
 * si se aplicó un descuento, muestra el precio con descuento.
 * @function
 * @returns {void}
 */
function finalizarCompra() {
    // Verifica si el carrito de la compra está vacío.
    if (carritoCompra.getContenidoCarrito().size === 0) {
        alert('Tu carrito de la compra está vacío.');
        return;
    }

    // Verifica si la compra ya se ha finalizado.
    if (!compraFinalizada) {
        compraFinalizada = true;
        mensajeFinal(); // Llama a la función para mostrar el mensaje final.
    }

    return;
}


/**
 * Aplica un descuento a la compra si se cumplen ciertas condiciones y
 * muestra información relevante.
 * @function
 * @returns {void}
 */
function aplicaDescuento() {
    // Verifica si el carrito de la compra está vacío.
    if (carritoCompra.getContenidoCarrito().size === 0) {
        alert('No puedes aplicar el descuento sin nada en el carrito.');
        return;
    }

    // Verifica si la compra ya se ha finalizado.
    if (compraFinalizada) {
        alert('Ya has finalizado la compra, no puedes aplicar el descuento.');
        return;
    }

    // Verifica si el descuento ya se ha aplicado anteriormente.
    if (descuentoAplicado) {
        alert('El descuento sólo se puede aplicar una vez.');
        return;
    }

    // Aplica el descuento y muestra información relevante.
    if (!descuentoAplicado) {
        descuentoAplicado = true;
        muestraInformacion(); // Llama a la función para mostrar información actualizada.
    }

    return;
}

/**
 * Elimina una unidad del producto del carrito, reduce el precio total y actualiza 
 * la información.
 * @function
 * @param {Producto} producto - El producto que se eliminará del carrito.
 * @returns {void}
 */
function delProducto(producto) {
    // Verifica si la compra ya se ha finalizado.
    if (compraFinalizada) {
        alert('No puedes eliminar un producto después de finalizar la compra.');
        return;
    }

    const contenidoCarrito = carritoCompra.getContenidoCarrito();

    if (contenidoCarrito.has(producto)) {
        contenidoCarrito.set(producto, contenidoCarrito.get(producto) - 1);
        precioTotal -= producto.getPrecio();

        // Si se ha eliminado la última unidad del producto, lo elimina completamente del carrito.
        if (contenidoCarrito.get(producto) === 0) {
            contenidoCarrito.delete(producto);
        }
    } else {
        alert('No tienes productos de este tipo en el carrito.');
        return;
    }

    muestraInformacion(); // Actualiza la información del carrito.
    return;
}

/**
 * Elimina una tabla previamente creada en el documento, si existe.
 * @function
 * @returns {void}
 */
function eliminaTablaPrevia() {
    // Obtiene la referencia al elemento div que contiene la tabla del carrito.
    const divTabla = document.getElementById('divTabla');

    // Verifica si el elemento div existe y, en ese caso, lo elimina del documento.
    if (divTabla) {
        const seccionTabla = document.getElementById('tuCesta');
        seccionTabla.removeChild(divTabla);
    }

    return;
}

/**
 * Calcula el precio total de los productos en el carrito multiplicando el precio de cada producto por su cantidad en el carrito.
 * @function
 * @returns {number} El precio total de la compra.
 */
function calcularTotal() {
    // Obtiene el contenido del carrito.
    const contenidoCarrito = carritoCompra.getContenidoCarrito();
    let total = 0;

    // Itera a través de los productos en el carrito y suma sus precios multiplicados por la cantidad.
    contenidoCarrito.forEach((cantidad, producto) => {
        total += producto.getPrecio() * cantidad;
    });

    return total;
}

/**
 * Agrega información de descuento y precio final a una tabla en el documento HTML.
 * @function
 * @param {HTMLElement} nodoPadre - El nodo HTML al que se agregarán los elementos de la tabla.
 * @returns {void}
 */
function agregarDescuento(nodoPadre) {
    // Calcula el descuento y el precio con descuento.
    const descuento = precioTotal * 0.2;
    const precioConDescuento = precioTotal * 0.8;

    // Crea una fila para el descuento y agrega celdas.
    const trDescuento = crearElemento('tr');
    nodoPadre.appendChild(trDescuento);
    agregarCelda(trDescuento, 'Descuento aplicado (20%):', 2, 'th');
    agregarCelda(trDescuento, descuento, 0, 'th');

    // Crea una fila para el precio final y agrega celdas.
    const trPrecioFinal = crearElemento('tr');
    nodoPadre.appendChild(trPrecioFinal);
    agregarCelda(trPrecioFinal, 'Precio final:', 2, 'th');
    agregarCelda(trPrecioFinal, precioConDescuento, 0, 'th');

    return;
}

/**
 * Crea el pie de una tabla en el documento HTML, mostrando el total y, si se aplicó un descuento, la información de descuento.
 * @function
 * @param {HTMLElement} nodoPadre - El nodo HTML al que se agregará el pie de la tabla.
 * @returns {void}
 */
function crearPieTabla(nodoPadre) {
    const tfoot = crearElemento('tfoot');
    nodoPadre.appendChild(tfoot);

    const tr = crearElemento('tr');
    tfoot.appendChild(tr);

    agregarCelda(tr, 'Total:', 2, 'th');
    agregarCelda(tr, precioTotal, 0, 'th');

    if (descuentoAplicado) {
        agregarDescuento(tfoot);
    }
    return;
}

/**
 * Crea el cuerpo de una tabla en el documento HTML, mostrando los productos en el carrito con su cantidad y precio total.
 * @function
 * @param {HTMLElement} nodoPadre - El nodo HTML al que se agregará el cuerpo de la tabla.
 * @param {Map<Producto, number>} contenidoCarrito - Un mapa que contiene los productos en el carrito y sus cantidades.
 * @returns {void}
 */
function crearCuerpoTabla(nodoPadre, contenidoCarrito) {
    const tbody = crearElemento('tbody');
    nodoPadre.appendChild(tbody);

    contenidoCarrito.forEach((cantidad, producto) => {
        const tr = crearElemento('tr');
        tbody.appendChild(tr);

        agregarCelda(tr, producto.getNombre(), 0, 'td');
        agregarCelda(tr, cantidad, 0, 'td');
        agregarCelda(tr, producto.getPrecio() * cantidad, 0, 'td');
    });
    return;
}

/**
 * Agrega una celda a un nodo padre con opciones para definir el contenido, colspan y tipo de celda.
 * @function
 * @param {HTMLElement} nodoPadre - El nodo HTML al que se agregará la celda.
 * @param {string} innerHTML - El contenido HTML que se mostrará en la celda.
 * @param {number} colspan - El número de columnas que ocupará la celda (opcional).
 * @param {string} tipoCelda - El tipo de celda (ej. 'th' para encabezado o 'td' para celda de datos).
 * @returns {void}
 */
function agregarCelda(nodoPadre, innerHTML, colspan, tipoCelda) {
    const celda = crearElemento(tipoCelda);
    celda.innerHTML = innerHTML;

    if (colspan) {
        celda.setAttribute('colspan', colspan);
    }

    nodoPadre.appendChild(celda);
    return;
}

/**
 * Crea las cabeceras de una tabla en el documento HTML.
 * @function
 * @param {HTMLElement} nodoPadre - El nodo HTML al que se agregarán las cabeceras de la tabla.
 * @param {string[]} cabeceras - Un arreglo de cadenas que representan las cabeceras de la tabla.
 * @returns {void}
 */
function crearCabeceras(nodoPadre, cabeceras) {
    const tr = crearElemento('tr');
    nodoPadre.appendChild(tr);

    for (let cabecera of cabeceras) {
        agregarCelda(tr, cabecera, 0, 'th');
    }
    return;
}

/**
 * Crea la cabecera de una tabla en el documento HTML con las etiquetas 'PRODUCTO', 'CANTIDAD' y 'PRECIO'.
 * @function
 * @param {HTMLElement} nodoPadre - El nodo HTML al que se agregará la cabecera de la tabla.
 * @returns {void}
 */
function crearCabeceraTabla(nodoPadre) {
    const thead = crearElemento('thead');
    nodoPadre.appendChild(thead);

    const cabeceras = ['PRODUCTO', 'CANTIDAD', 'PRECIO'];
    crearCabeceras(thead, cabeceras);
    return;
}

/**
 * Crea una tabla completa en el documento HTML que muestra el contenido del carrito, incluyendo cabecera, cuerpo y pie.
 * @function
 * @param {HTMLElement} nodoPadre - El nodo HTML al que se agregará la tabla.
 * @param {Map<Producto, number>} contenidoCarrito - Un mapa que contiene los productos en el carrito y sus cantidades.
 * @returns {void}
 */
function crearTabla(nodoPadre, contenidoCarrito) {
    const table = crearElemento('table', 'tablaCesta');
    nodoPadre.appendChild(table);

    crearCabeceraTabla(table);
    crearCuerpoTabla(table, contenidoCarrito);
    crearPieTabla(table);
    return;
}

/**
 * Crea un elemento HTML con opciones para definir la etiqueta, el ID y el contenido interno.
 * @function
 * @param {string} etiqueta - La etiqueta HTML del elemento a crear.
 * @param {string} id - El ID que se asignará al elemento (opcional).
 * @param {string} innerHTML - El contenido interno del elemento (opcional).
 * @returns {HTMLElement} El elemento HTML creado.
 */
function crearElemento(etiqueta, id, innerHTML) {
    const elemento = document.createElement(etiqueta);

    if (id) {
        elemento.setAttribute('id', id);
    }

    if (innerHTML) {
        elemento.innerHTML = innerHTML;
    }

    return elemento;
}

/**
 * Muestra información relacionada con el carrito de compras en un documento HTML.
 * Elimina la tabla anterior (si existe) y crea una nueva tabla con el contenido del carrito.
 * @function
 * @returns {void}
 */
function muestraInformacion() {
    eliminaTablaPrevia();
    const seccionTabla = document.getElementById('tuCesta');
    const contenidoCarrito = carritoCompra.getContenidoCarrito();

    if (contenidoCarrito.size !== 0) {
        const contenedorTabla = crearElemento('div', 'divTabla');
        seccionTabla.appendChild(contenedorTabla);

        const h2 = crearElemento('h2', '', 'TU CESTA');
        contenedorTabla.appendChild(h2);
        crearTabla(contenedorTabla, contenidoCarrito);
    }
    return;
}

/**
 * Calcula la cantidad total de unidades en un carrito de compras.
 *
 * @function
 * @param {Map} contenidoCarrito - El contenido del carrito de compras como un objeto Map.
 * @returns {number} La cantidad total de unidades en el carrito.
 */
function cantidadTotal(contenidoCarrito) {
    let totalUnidades = 0;

    // Itera a través de los productos en el carrito y suma sus cantidades.
    contenidoCarrito.forEach((cantidad) => {
        totalUnidades += cantidad;
    });

    return totalUnidades;
}

/**
 * Agrega un producto al carrito de compra, incrementando la cantidad y 
 * actualizando el precio total.
 * @function
 * @param {Producto} producto - El producto que se agregará al carrito.
 */
function addProducto(producto) {
    // Verifica si la compra ya se ha finalizado.
    if (compraFinalizada) {
        alert('No puedes incluir un producto después de haber finalizado la compra.');
        return;
    }

    const contenidoCarrito = carritoCompra.getContenidoCarrito();

    if (cantidadTotal(contenidoCarrito) === articulosMaximosCarro) {
        alert(`Tu carro está lleno, tienes ${articulosMaximosCarro} unidades en el carro.`);
        return;
    }

    if (contenidoCarrito.has(producto)) {
        // Verifica si el producto ha alcanzado su cantidad máxima permitida en el carrito.
        if (contenidoCarrito.get(producto) < articulosMaximosTipo) {
            contenidoCarrito.set(producto, contenidoCarrito.get(producto) + 1);
            precioTotal += producto.getPrecio();
        } else {
            alert(`No puedes añadir más de ${articulosMaximosTipo} unidades de este producto.`);
            return;
        }
    } else {
        contenidoCarrito.set(producto, 1);
        precioTotal += producto.getPrecio();
    }

    muestraInformacion(); // Muestra información actualizada del carrito.
    return;
}


/**
 * Elimina el tercer producto del carrito de compra.
 * @function
 */
function eliminarProducto3() {
    delProducto(tercerProducto); // Llama a la función delProducto para eliminar el tercer producto.
    return;
}

/**
 * Elimina el segundo producto del carrito de compra.
 * @function
 */
function eliminarProducto2() {
    delProducto(segundoProducto); // Llama a la función delProducto para eliminar el segundo producto.
    return;
}

/**
 * Elimina el primer producto del carrito de compra.
 * @function
 */
function eliminarProducto1() {
    delProducto(primerProducto); // Llama a la función delProducto para eliminar el primer producto.
    return;
}

/**
 * Añade el primer producto al carrito de compra.
 * @function
 */
function anadirProducto1() {
    addProducto(primerProducto); // Llama a la función addProducto para agregar el primer producto.
    return;
}

/**
 * Añade el segundo producto al carrito de compra.
 * @function
 */
function anadirProducto2() {
    addProducto(segundoProducto); // Llama a la función addProducto para agregar el segundo producto.
    return;
}

/**
 * Añade el tercer producto al carrito de compra.
 * @function
 */
function anadirProducto3() {
    addProducto(tercerProducto); // Llama a la función addProducto para agregar el tercer producto.
    return;
}

/**
 * Inicia una nueva compra reiniciando la página actual.
 * @function
 */
function nuevaCompra() {
    location.reload(); // Recarga la página para iniciar una nueva compra.
    return;
}

// EVENTOS DE ESCUCHA
const botonAddProducto1 = document.getElementById('aniadir1');
botonAddProducto1.addEventListener('click', anadirProducto1);

const botonAddProducto2 = document.getElementById('aniadir2');
botonAddProducto2.addEventListener('click', anadirProducto2);

const botonAddProducto3 = document.getElementById('aniadir3');
botonAddProducto3.addEventListener('click', anadirProducto3);

const botonDelProducto1 = document.getElementById('eliminar1');
botonDelProducto1.addEventListener('click', eliminarProducto1);

const botonDelProducto2 = document.getElementById('eliminar2');
botonDelProducto2.addEventListener('click', eliminarProducto2);

const botonDelProducto3 = document.getElementById('eliminar3');
botonDelProducto3.addEventListener('click', eliminarProducto3);

const botonTarjeta = document.getElementById('aplicarDescuento');
botonTarjeta.addEventListener('click', aplicaDescuento);

const botonFinalizarCompra = document.getElementById('finalizarCompra');
botonFinalizarCompra.addEventListener('click', finalizarCompra);

const botonNuevaCompra = document.getElementById('nuevaCompra');
botonNuevaCompra.addEventListener('click', nuevaCompra);

// VARIABLES
const articulosMaximosTipo = 5; // Número máximo de unidades de un tipo de producto permitidas en el carrito.
const articulosMaximosCarro = 10; // Número máximo de unidades en el carro.
let precioTotal = 0; // Precio total acumulado de los productos en el carrito.
let descuentoAplicado = false; // Indica si se ha aplicado un descuento a la compra.
let compraFinalizada = false; // Indica si la compra ha sido finalizada.

// OBJETOS
// Crea instancias de productos.
const primerProducto = new Producto(1, 'Placa base', 100);
const segundoProducto = new Producto(2, 'Fuente de Alimentación', 50);
const tercerProducto = new Producto(3, 'Memoria RAM', 75);

// Crea una instancia de un carrito de compra.
const carritoCompra = new Carrito();