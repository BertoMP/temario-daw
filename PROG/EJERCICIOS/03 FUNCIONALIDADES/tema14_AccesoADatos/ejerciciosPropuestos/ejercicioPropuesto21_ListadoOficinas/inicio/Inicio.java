package tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto21_ListadoOficinas.inicio;

import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto21_ListadoOficinas.clases.Oficina;
import tema14_AccesoADatos.ejerciciosPropuestos.ejercicioPropuesto21_ListadoOficinas.clases.OficinaDAO;

import java.util.List;

/***********************************************************************************************************************
 * Clase encargada del desarrollo principal del programa.                                                              *
 ***********************************************************************************************************************/

public class Inicio {
    public static void inicio() {
        List<Oficina> listadoOficinas; //Listado que guardará las oficinas.

        listadoOficinas = OficinaDAO.listadoOficinas();

        if (listadoOficinas != null) {
            System.out.println("LISTADO DE OFICINAS");
            for (Oficina oficinaValor : listadoOficinas) {
                System.out.println(oficinaValor);
            }
        }
    }
}
