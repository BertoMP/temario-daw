let miFuncion = function() {
    let var1 = 5;
    let var2 = 2;
    return var1 + var2;
}

let forma = "redonda";
let tamanyo = 9;
let miCoche = {
    marca: "Saab",
    modelo: "93",
    color: "gris",
    arrancar() {
        alert("Mi coche ha arrancado.")
    }
};

console.log("El tipo de miFuncion es " + typeof miFuncion);
console.log("El tipo de forma es " + typeof forma);
console.log("El tipo de tamanyo es " + typeof tamanyo);
console.log("El tipo de miCoche es " + typeof miCoche);

console.log(typeof forma === "string" ? "Es un string." : "No es un string.");
console.log(typeof tamanyo === "object" ? "Es un objeto." : "No es un objeto.");