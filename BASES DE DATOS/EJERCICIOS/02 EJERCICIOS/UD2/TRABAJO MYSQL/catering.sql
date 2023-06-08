-- MySQL dump 10.13  Distrib 8.0.31, for Linux (x86_64)
--
-- Host: localhost    Database: catering
-- ------------------------------------------------------
-- Server version	8.0.31-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CATERING`
--

DROP TABLE IF EXISTS `CATERING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CATERING` (
  `numero` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `precio` float(6,2) DEFAULT NULL,
  `metodo_pago` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  CONSTRAINT `C_METODO_POSIBLE` CHECK ((`metodo_pago` in (_utf8mb4'paypal',_utf8mb4'tarjeta'))),
  CONSTRAINT `C_PRECIO_MAYOR10` CHECK ((`precio` >= 10))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATERING`
--

LOCK TABLES `CATERING` WRITE;
/*!40000 ALTER TABLE `CATERING` DISABLE KEYS */;
INSERT INTO `CATERING` VALUES (1,'2020-12-11',1065.20,'paypal'),(2,'2020-12-21',520.75,'paypal'),(3,'2021-01-05',350.00,'paypal'),(4,'2021-01-06',2500.80,'tarjeta'),(5,'2021-01-07',830.75,'tarjeta');
/*!40000 ALTER TABLE `CATERING` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENTE` (
  `codigo` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `U_EMAIL_UNICO` (`email`),
  CONSTRAINT `C_TELEFONO_NOTNULL` CHECK ((`telefono` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
INSERT INTO `CLIENTE` VALUES (500,'Diego Sánchez',916723323,NULL),(501,'Elena García',611230045,'Elena123@hotmail.com'),(502,'Restaurante El Rincón',917894100,'info@elrincon.com'),(503,'Bodega Rio Tinto',670488811,'pedidos@riotinto.es');
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INCLUYE`
--

DROP TABLE IF EXISTS `INCLUYE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `INCLUYE` (
  `catering` int NOT NULL,
  `producto` int NOT NULL,
  `unidades` int DEFAULT NULL,
  PRIMARY KEY (`catering`,`producto`),
  KEY `FK_INCLUYE_PRODUCTO` (`producto`),
  CONSTRAINT `FK_INCLUYE_CATERING` FOREIGN KEY (`catering`) REFERENCES `CATERING` (`numero`),
  CONSTRAINT `FK_INCLUYE_PRODUCTO` FOREIGN KEY (`producto`) REFERENCES `PRODUCTO` (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INCLUYE`
--

LOCK TABLES `INCLUYE` WRITE;
/*!40000 ALTER TABLE `INCLUYE` DISABLE KEYS */;
INSERT INTO `INCLUYE` VALUES (1,34,125),(1,50,5),(1,103,75),(2,35,80),(2,52,10),(3,34,60),(3,50,2),(3,105,10),(4,34,300),(4,35,100),(4,50,15),(5,34,125),(5,50,5),(5,103,75);
/*!40000 ALTER TABLE `INCLUYE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCTO`
--

DROP TABLE IF EXISTS `PRODUCTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODUCTO` (
  `referencia` int NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `coste` float(6,2) DEFAULT NULL,
  PRIMARY KEY (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTO`
--

LOCK TABLES `PRODUCTO` WRITE;
/*!40000 ALTER TABLE `PRODUCTO` DISABLE KEYS */;
INSERT INTO `PRODUCTO` VALUES (33,'Hojaldre de salmón',2.05),(34,'Canapé surtido',0.85),(35,'Milhojas de berenjena',1.20),(50,'Salsa agria (100ml)',1.00),(52,'Salsa pesto (100ml)',0.90),(103,'Tosta de queso azul',2.35),(105,'Tosta de ibérico',2.57);
/*!40000 ALTER TABLE `PRODUCTO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-23 17:47:43
