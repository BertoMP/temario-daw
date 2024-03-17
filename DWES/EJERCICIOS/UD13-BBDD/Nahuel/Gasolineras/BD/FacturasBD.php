<?php
function connect():PDO{
    $server = 'mysql:host=localhost;dbname=2daw';
    $user = 'nahuel';
    $password = 'nahuel';

    return new PDO($server, $user, $password);
}

function insercionTicket(Ticket $objTicket):void{
    $sql = 'insert into facturasytickets (fecha_hora, importe) values (:fecha, :importe)';
    $strfecha = $objTicket->getFecha();
    $fltImporte = $objTicket->getdblImporte();

    try {
        $conexion = connect();
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        try{
            $sentencia = $conexion->prepare($sql);

            $sentencia -> bindParam(':fecha', $strfecha);
            $sentencia -> bindParam(':importe', $fltImporte);
            $sentencia -> execute();
            $sentencia->closeCursor();

        }catch (PDOException $e){
            echo 'ERROR INSERCION TICKET: ' . $e->getMessage();
        }
    }catch (PDOException $e){
        echo 'FALLO CONEXION: ' . $e -> getMessage();
    }
}

function insercionFactura(Factura $objFactura):void{
    $sql = 'insert into facturasytickets (fecha_hora, importe, DNI, matricula) values (:fecha, :importe, :dni, :matricula)';
    $strfecha = $objFactura->getFecha();
    $fltImporte = $objFactura->getdblImporte();
    $strDni = $objFactura->getStrDNI();
    $strMatricula = $objFactura->getStrMatricula();


    try {
        $conexion = connect();
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        try{
            $sentencia = $conexion->prepare($sql);

            $sentencia -> bindParam(':fecha', $strfecha);
            $sentencia -> bindParam(':importe', $fltImporte);
            $sentencia -> bindParam(':dni', $strDni);
            $sentencia -> bindParam(':matricula', $strMatricula);
            $sentencia -> execute();
            $sentencia->closeCursor();

        }catch (PDOException $e){
            echo 'ERROR INSERCION TICKET: ' . $e->getMessage();
        }
    }catch (PDOException $e){
        echo 'FALLO CONEXION: ' . $e -> getMessage();
    }
}

function listarRepostajes():void{
    $sql = 'SELECT * FROM facturasytickets';
    $arrColumnas = ['fecha_hora', 'importe', 'DNI', 'matricula'];

    try {
        $conexion = connect();
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        try{
            $sentencia = $conexion->prepare($sql);
            $sentencia->setFetchMode(PDO::FETCH_ASSOC);
            $sentencia -> execute();
            crearTable($arrColumnas,$sentencia);
            $sentencia->closeCursor();
        }catch (PDOException $e){
            echo 'ERROR INSERCION TICKET: ' . $e->getMessage();
        }
    }catch (PDOException $e){
        echo 'FALLO CONEXION: ' . $e -> getMessage();
    }
}

function importeTotal():void{
    $sql = 'SELECT sum(importe) FROM facturasytickets';

    try {
        $conexion = connect();
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        try{
            $sentencia = $conexion->prepare($sql);
            $sentencia -> execute();
            $importe = $sentencia->fetch();
            echo 'Importe Total: ' .  $importe['sum(importe)'] . '$';
            $sentencia->closeCursor();
        }catch (PDOException $e){}
    }catch (PDOException $e){
        echo 'FALLO CONEXION: ' . $e -> getMessage();
    }
}

function insercionDeposito(array $arrDeposito):void{
    $sql = 'insert into depositos (id, litros, tipo_combustible, importe) values (:id, :litros, :tipo_combustible, :importe)';
    $id = getIdDeposito()+1;

    try {
        $conexion = connect();
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        try{
            $sentencia = $conexion->prepare($sql);

            $sentencia -> bindParam(':id', $id);
            $sentencia -> bindParam(':litros', $arrDeposito['litros']);
            $sentencia -> bindParam(':tipo_combustible', $arrDeposito['tipo_combustible']);
            $sentencia -> bindParam(':importe', $arrDeposito['importeTotal']);

            $sentencia -> execute();

            $sentencia->closeCursor();

        }catch (PDOException $e){
            echo 'ERROR INSERCION TICKET: ' . $e->getMessage();
        }
    }catch (PDOException $e){
        echo 'FALLO CONEXION: ' . $e -> getMessage();
    }
}

function getIdDeposito():int{
    $sql = 'SELECT count(*) FROM depositos';
    $idReturn = 0;

    try {
        $conexion = connect();
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        try{
            $sentencia = $conexion->prepare($sql);
            $sentencia -> execute();
            $idReturn = $sentencia -> fetch();
            $sentencia->closeCursor();

        }catch (PDOException $e){
            echo 'ERROR INSERCION TICKET: ' . $e->getMessage();
        }
    }catch (PDOException $e){
        echo 'FALLO CONEXION: ' . $e -> getMessage();
    }

    return $idReturn['count(*)'];
}

function listarDepositos():void{
    $sql = 'SELECT * FROM depositos';
    $arrColumnas = ['id', 'litros', 'tipo_combustible', 'importe'];

    try {
        $conexion = connect();
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        try{
            $sentencia = $conexion->prepare($sql);
            $sentencia->setFetchMode(PDO::FETCH_ASSOC);
            $sentencia -> execute();
            crearTable($arrColumnas,$sentencia);
            $sentencia->closeCursor();
        }catch (PDOException $e){
            echo 'ERROR INSERCION TICKET: ' . $e->getMessage();
        }
    }catch (PDOException $e){
        echo 'FALLO CONEXION: ' . $e -> getMessage();
    }
}
function borradoUltimoId():void{
    $sql = 'delete FROM depositos where id=:id';
    $id = getIdDeposito();

    try {
        $conexion = connect();
        $conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        try{
            $sentencia = $conexion->prepare($sql);
            $sentencia -> bindParam(':id', $id);
            $sentencia -> execute();
            $sentencia->closeCursor();
        }catch (PDOException $e){
            echo 'ERROR INSERCION TICKET: ' . $e->getMessage();
        }
    }catch (PDOException $e){
        echo 'FALLO CONEXION: ' . $e -> getMessage();
    }
}

function crearTable(array $arrColumnas, PDOStatement $sentencia):void{
    echo '<table>';
        thead($arrColumnas);
        tbody($sentencia, $arrColumnas);
    echo '</table>';
}
function thead(array $arrColumnas):void{
    echo '<thead>';
        echo '<tr>';
            foreach ($arrColumnas as $element){
                echo '<th>' . $element . '</th>';
            }
        echo '<tr>';
    echo '</thead>';
}

function tbody(PDOStatement $sentencia, array $arrColumnas):void{
    echo '<tbody>';
    while($elemento = $sentencia->fetch()){
        echo '<tr>';
            echo '<td>' . $elemento[$arrColumnas[0]] . '</td>';
            echo '<td>' . $elemento[$arrColumnas[1]] . '</td>';
            echo '<td>' . $elemento[$arrColumnas[2]] . '</td>';
            echo '<td>' . $elemento[$arrColumnas[3]] . '</td>';
        echo '</tr>';
    }
    echo '</tbody>';
}