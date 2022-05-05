-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vkurse
-- ------------------------------------------------------
-- Server version	5.7.37

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
-- Table structure for table `lesson_time`
--

DROP TABLE IF EXISTS `lesson_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lesson_time` (
  `id` int(11) NOT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `weekday` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson_time`
--

LOCK TABLES `lesson_time` WRITE;
/*!40000 ALTER TABLE `lesson_time` DISABLE KEYS */;
INSERT INTO `lesson_time` VALUES (55,'10:05','8:30',0),(56,'11:55','10:15',0),(57,'13:45','12:10',0),(58,'15:35','14:00',0),(59,'17:30','15:55',0),(60,'19:20','17:45',0),(61,'10:05','8:30',1),(62,'11:55','10:15',1),(63,'13:45','12:10',1),(64,'15:35','14:00',1),(65,'17:30','15:55',1),(66,'19:20','17:45',1),(67,'10:05','8:30',2),(68,'11:55','10:15',2),(69,'13:45','12:10',2),(70,'15:35','14:00',2),(71,'17:30','15:55',2),(72,'19:20','17:45',2),(73,'10:05','8:30',3),(74,'11:55','10:15',3),(75,'13:45','12:10',3),(76,'15:35','14:00',3),(77,'17:30','15:55',3),(78,'19:20','17:45',3),(79,'10:05','8:30',4),(80,'11:55','10:15',4),(81,'13:45','12:10',4),(82,'15:35','14:00',4),(83,'17:30','15:55',4),(84,'19:20','17:45',4),(85,'10:05','8:30',5),(86,'11:55','10:15',5),(87,'13:45','12:10',5),(88,'15:35','14:00',5),(89,'17:30','15:55',5),(90,'19:20','17:45',5),(91,'10:05','8:30',6),(92,'11:55','10:15',6),(93,'13:45','12:10',6),(94,'15:35','14:00',6),(95,'17:30','15:55',6),(96,'19:20','17:45',6);
/*!40000 ALTER TABLE `lesson_time` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-05 17:46:35
