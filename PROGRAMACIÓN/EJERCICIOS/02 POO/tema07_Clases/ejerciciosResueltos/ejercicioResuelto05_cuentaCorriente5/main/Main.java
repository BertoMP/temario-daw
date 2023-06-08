package tema07_Clases.ejerciciosResueltos.ejercicioResuelto05_cuentaCorriente5.main;

import tema07_Clases.ejerciciosResueltos.ejercicioResuelto05_cuentaCorriente5.clases.Iniciador;

/***********************************************************************************************************************
 * Existen gestores que administran las cuentas bancarias y atienden a sus propietarios.                               *
 * Cada cuenta, en caso de tenerlo, cuenta con un único gestor. Diseñar la clase Gestor de la que interesa guardar     *
 * su nombre, teléfono y el importe máximo autorizado con el que pueden operar. Con respecto a los gestores,           *
 * existen las siguientes restricciones:                                                                               *
 *                                                                                                                     *
 *  - Un gestor tendrá siempre un nombre y un teléfono.                                                                *
 *  - Si no se asigna, el importe máximo autorizado por operación será de 10 000 euros.                                *
 *  - Un gestor, una vez asignado, no podrá cambiar su número de teléfono. Y todas las clases podrán consultarlo.      *
 *                                                                                                                     *
 *  El nombre será público y el importe máximo solo será visible por clases vecinas.                                   *
 *  Modificar la clase CuentaCorriente para que pueda disponer de un objeto Gestor. Escribir los métodos necesarios.   *
 ***********************************************************************************************************************/
public class Main {
    public static void main(String[] args) {
        Iniciador.inicio();
    }
}

