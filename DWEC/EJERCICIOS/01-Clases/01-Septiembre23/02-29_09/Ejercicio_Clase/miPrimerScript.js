/**
 * Utilizando la documentación oficial de Mozilla busca un método de la clase
 * String que permita que la frase "Odiio a los perros porque tienen mala leche",
 * cambie a "Odio a los gatos porque tienen mala leche."
 */

let miFraseFamosa = "Odio a los perros porque tienen mala leche.";
let nuevaFrase = miFraseFamosa.replace('perros', 'gatos');

console.log(nuevaFrase);