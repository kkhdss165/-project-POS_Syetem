CREATE DATABASE  IF NOT EXISTS `posdb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `posdb`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: posdb
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `recode`
--

DROP TABLE IF EXISTS `recode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recode` (
  `recode_ID` int NOT NULL AUTO_INCREMENT,
  `product_ID` varchar(20) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  `product_manufacturer` varchar(20) NOT NULL,
  `product_price` mediumtext NOT NULL,
  `sell_amount` mediumtext NOT NULL,
  `recode_datetime` datetime NOT NULL,
  `recode_type` varchar(20) NOT NULL,
  PRIMARY KEY (`recode_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recode`
--

LOCK TABLES `recode` WRITE;
/*!40000 ALTER TABLE `recode` DISABLE KEYS */;
INSERT INTO `recode` VALUES (1,'A0002','포테토칩','농심','1500','4','2021-03-01 10:10:26','normal'),(2,'A0001','새우깡','농심','1100','1','2022-03-01 10:10:26','normal'),(3,'A0004','초코송이','크라운','1000','2','2022-05-05 10:24:59','refund'),(4,'A0001','새우깡','농심','1100','2','2022-05-20 11:39:02','normal'),(5,'A0001','새우깡','농심','1100','2','2022-06-02 11:39:14','normal'),(6,'A0004','초코송이','크라운','1000','2','2022-06-11 11:39:26','normal'),(7,'A0001','새우깡','농심','1100','7','2022-06-11 11:39:37','normal'),(8,'A0004','초코송이','크라운','1000','3','2022-06-11 13:01:32','normal'),(9,'A0002','포테토칩','농심','1500','1','2022-06-11 18:03:37','normal'),(10,'A0001','새우깡','농심','1100','1','2022-06-11 18:03:37','refund'),(11,'A0001','새우깡','농심','1100','1','2022-06-11 18:04:23','normal'),(12,'A0003','불닭볶음면','삼양','1150','5','2022-06-11 18:51:00','refund'),(13,'A0004','초코송이','크라운','1000','2','2022-06-11 18:51:00','normal');
/*!40000 ALTER TABLE `recode` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-12  5:59:51
