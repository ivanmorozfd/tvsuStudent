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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,_binary '','$2a$12$x/HjadvQ2uyu5u2hk2p9bOvSFDvJGDV/FgBR9VxmwfBQmoqNg5h7i','admin','admin'),(1,_binary '','$2a$10$KwkPoQEzScA4g5PktZqMGOm3Z3qydj1C4yg3d3jET6Sr4sZyTsVq2','student','asgordeev'),(2,_binary '','$2a$10$NkHipm6AW9m3h3n5MRmdy.LW0voVToDJFWDzDNCN3ta45Pw4od2Z6','teacher','teach'),(111,_binary '','$2a$10$dkcnbkMTrTFuFdcP56XFbelLotekPFXsTOiVn.JOC79Sh4Kai2rmS','teacher','kozheko'),(112,_binary '','$2a$10$ttlGsySxwdsQpS792FCbQutZ4gPozdO63S8Tcr0nNQW0UhtMsBj8C','teacher','shapovalova'),(113,_binary '','$2a$10$S.rrluGrdw8lbNWZgvHNBeasLG1YqU2dWX.T4C.GkOGr9/29oipK.','teacher','semykina'),(114,_binary '','$2a$10$uxhiPkmvyYA9ryCkx6sJ1uXHt49bAY5Da.DdNQimSBizlBwnDdgvG','teacher','rybakov'),(115,_binary '','$2a$10$mSNdNSzlnd1rGWbghr7v..y7.EMvozfmCize7oBstLkv5gGkFVD.y','teacher','zyskin'),(116,_binary '','$2a$10$EDcvJD51RB401HrTkySFhOKKY6I8ugsN/gwzIs3uGjsjjy2DqeKZu','teacher','denisov'),(117,_binary '','$2a$10$.s9myUcoKJAZgEO.fm84DO/o9REQhxJAuYSca2gcclrDDb5n2n6lq','teacher','baranova'),(118,_binary '','$2a$10$q7FrM6H/pdfQZCLYi.PsquUVNE.w0N0CV4hBPf1yhcNtc9VT8lMGy','teacher','sushkin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-05 17:46:33
