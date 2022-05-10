-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
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
-- Table structure for table `schedule_item`
--

DROP TABLE IF EXISTS `schedule_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule_item` (
  `id` int(11) NOT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `lesson_time_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKswlhofx9i6puoiuw8mwfkll4t` (`lesson_id`),
  KEY `FK70hjrptwpf5uwy3m41x6qedey` (`lesson_time_id`),
  KEY `FKjg012k4lb1iohmtpgiqo6492x` (`room_id`),
  KEY `FK9umqpmwqflvbk2iu0xl4vl14i` (`teacher_id`),
  CONSTRAINT `FK70hjrptwpf5uwy3m41x6qedey` FOREIGN KEY (`lesson_time_id`) REFERENCES `lesson_time` (`id`),
  CONSTRAINT `FK9umqpmwqflvbk2iu0xl4vl14i` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FKjg012k4lb1iohmtpgiqo6492x` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `FKswlhofx9i6puoiuw8mwfkll4t` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_item`
--

LOCK TABLES `schedule_item` WRITE;
/*!40000 ALTER TABLE `schedule_item` DISABLE KEYS */;
INSERT INTO `schedule_item` VALUES (119,103,55,102,2),(120,104,56,101,3),(121,105,57,102,4),(122,106,58,102,5),(123,107,61,98,5),(124,108,62,100,2),(125,109,63,99,6),(126,110,70,99,2),(127,107,71,98,4),(128,106,72,97,3),(129,104,76,103,6),(130,103,77,100,5),(131,106,82,98,4),(132,103,94,99,3),(133,105,95,100,2),(134,107,61,98,5),(135,108,62,100,2),(136,103,76,100,2),(137,104,77,102,4),(138,109,82,103,4);
/*!40000 ALTER TABLE `schedule_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-10 18:20:18
