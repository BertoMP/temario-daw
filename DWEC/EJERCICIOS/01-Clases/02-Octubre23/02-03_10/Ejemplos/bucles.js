// BUCLE WHILE
console.log('WHILE');

let contador = 0;

while (contador < 10) {
    console.log(`El contador está en ${contador}`);
    contador++;
}

// BUCLE DO ... WHILE
console.log('DO ... WHILE');

let contador2 = 0;

do {
    console.log(`El contador está en ${contador2}`);
    contador2++;
} while (contador2 < 10);

// BUCLE FOR
console.log('FOR');

for (let intCont = 0; intCont < 10; intCont++) {
    console.log(`El contador está en ${intCont}`);
}

// BUCLE FOR ... OF
console.log('FOR ... OF');
let arrayNumeros = [2, 5, 8, 23, 56];

for (let numero of arrayNumeros) {
    console.log(numero);
}

// BUCLE FOR ... IN
console.log('FOR ... IN');
let persona = {
    nombre: 'Juan',
    edad: '23'
}

for (let atributo in persona) {
    console.log(`${atributo} -> ${persona[atributo]}`);
}

let arrayNum = [2, , 7, 8];

for (let numero of arrayNum) {
    console.log(numero);
}

for (let numero in arrayNum) {
    console.log(arrayNum[numero]);
}