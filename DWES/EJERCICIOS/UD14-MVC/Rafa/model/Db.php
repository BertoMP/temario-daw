<?php 

require_once 'config/config.php';

abstract class Db {

  public function __construct(){
    
  }

	public static function abrirConexion(){
		try {
          return new PDO('mysql:host='.constant('DB_HOST').':3308; dbname='.constant('DB'), constant('DB_USER'), constant('DB_PASS'));
        } catch (PDOException $e) {
            echo "error en la base de datos " . $e->getMessage();
            exit();
        }
	}
}

?>