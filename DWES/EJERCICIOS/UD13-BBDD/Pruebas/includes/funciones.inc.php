<?php
function generaConexion() {
    $strHost = 'localhost';
    $strPuerto = '3306';
    $strDbname = 'juego';
    $strUser = 'root';
    $strPass = '';

    try {
        $conexion = new PDO(
            'mysql:host=' . $strHost . ';port=' . $strPuerto . ';dbname=' . $strDbname,
            $strUser,
            $strPass
        );
        $conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        return $conexion;
    } catch (PDOException $e) {
        echo 'Error en la conexión a la base de datos ' . $strDbname . '.';

        return null;
    }
}

function select() {
    $strTabla = 'HEROES';
    $strQuery = 'SELECT NOMBRE FROM ' . $strTabla . ' ORDER BY NOMBRE ASC';

    try {
        $conexion = generaConexion();
        if ($conexion) {
            $sentenciaSQL = $conexion->prepare($strQuery, array(PDO::ATTR_CURSOR => PDO::CURSOR_SCROLL));
            $sentenciaSQL->setFetchMode(PDO::FETCH_ASSOC);
            $sentenciaSQL->execute();

            $arrCamposTabla = array('NOMBRE');
            $intCont = 0;

            echo '<table>';
            echo '<thead>';
            echo '<tr>';

            foreach ($arrCamposTabla as $campo) {
                echo '<th>' . $campo . '</th>';
            }

            $heroe = $sentenciaSQL->fetch(PDO::FETCH_NUM, PDO::FETCH_ORI_LAST);

            do {
                echo '<tr>';
                foreach ($heroe as $atributo => $valor) {
                    echo '<td>';
                    echo $intCont . ' ' . $valor;
                    echo '</td>';
                }
                echo '</tr>';
                $intCont++;
            } while ($heroe = $sentenciaSQL->fetch(PDO::FETCH_NUM, PDO::FETCH_ORI_FIRST));

            echo '</tbody>';
            echo '</table>';
        }
    } catch (PDOException $e) {
        echo 'Error en el acceso a los datos en la tabla ' . $strTabla . '.';
    } finally {
        if (isset($conexion)) {
            $sentenciaSQL->closeCursor();
            unset($conexion);
        }
    }
}
