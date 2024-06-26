-- MySQL dump 10.13  Distrib 8.4.0, for Win64 (x86_64)
--
-- Host: localhost    Database: meteorite
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `Loans`
--

DROP TABLE IF EXISTS `Loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Loans` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loaneeName` varchar(255) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` text,
  `loanStartDate` date DEFAULT NULL,
  `loanDueDate` date DEFAULT NULL,
  `monnigNumbersOfSamplesOnLoan` text,
  `notes` text,
  `archived` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Loans`
--

LOCK TABLES `Loans` WRITE;
/*!40000 ALTER TABLE `Loans` DISABLE KEYS */;
/*!40000 ALTER TABLE `Loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MeteoriteHistory`
--

DROP TABLE IF EXISTS `MeteoriteHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MeteoriteHistory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `meteoriteSampleId` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `category` enum('Acquired','Cut','Other') DEFAULT NULL,
  `details` text,
  PRIMARY KEY (`id`),
  KEY `meteoriteSampleId` (`meteoriteSampleId`),
  CONSTRAINT `meteoritehistory_ibfk_1` FOREIGN KEY (`meteoriteSampleId`) REFERENCES `MeteoriteSamples` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MeteoriteHistory`
--

LOCK TABLES `MeteoriteHistory` WRITE;
/*!40000 ALTER TABLE `MeteoriteHistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `MeteoriteHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MeteoriteSamples`
--

DROP TABLE IF EXISTS `MeteoriteSamples`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MeteoriteSamples` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `monnigNumber` varchar(255) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `groupType` varchar(100) DEFAULT NULL,
  `clan` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `foundOrFall` enum('Found','Fall') DEFAULT NULL,
  `sampleType` varchar(100) DEFAULT NULL,
  `totalKnownWeight` decimal(10,2) DEFAULT NULL,
  `sampleWeight` decimal(10,2) DEFAULT NULL,
  `yearFound` int DEFAULT NULL,
  `educationalSpecimen` tinyint(1) DEFAULT NULL,
  `repositorySpecimen` tinyint(1) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `monnigNumber` (`monnigNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MeteoriteSamples`
--

LOCK TABLES `MeteoriteSamples` WRITE;
/*!40000 ALTER TABLE `MeteoriteSamples` DISABLE KEYS */;
INSERT INTO `MeteoriteSamples` VALUES (1,'Acfer 358','M2142.1','Ordinary Chondrite','H',NULL,'Algeria',NULL,NULL,NULL,NULL,5.90,2002,NULL,NULL,1),(2,'Acfer 359','M2143.1','Ordinary Chondrite','H',NULL,'Algeria',NULL,NULL,NULL,NULL,4.20,2002,NULL,NULL,1),(3,'Acfer 361','M2145.1','Ordinary Chondrite','H',NULL,'Algeria',NULL,NULL,NULL,NULL,5.30,2002,NULL,NULL,1),(4,'Acfer 361','M2145.2','Ordinary Chondrite','H',NULL,'Algeria',NULL,NULL,NULL,NULL,3.10,2002,NULL,NULL,1),(5,'Acfer 361','M2145.3','Ordinary Chondrite','H',NULL,'Algeria',NULL,NULL,NULL,NULL,0.60,2002,NULL,NULL,1),(6,'Achilles','M808.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,108.20,1924,NULL,NULL,1),(7,'Ackerly','M1725.2','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,7.00,1995,NULL,NULL,1),(8,'Ackerly','M1725.3b','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,0.30,1995,NULL,NULL,1),(9,'Ackerly','M1725.3a','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,0.50,1995,NULL,NULL,1),(10,'Ackerly','M1725.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,282.40,1995,NULL,NULL,1),(11,'Ackerly','M1725.4','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,0.80,1995,NULL,NULL,1),(12,'Ackerly','M1725.3','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,3.20,1995,NULL,NULL,1),(13,'Acme','M229.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,42.60,1947,NULL,NULL,1),(14,'Acomita','M1244.1','Pallasite, PMG','D',NULL,'USA',NULL,NULL,NULL,NULL,87.60,1962,NULL,NULL,1),(15,'Acuna','M1126.1','Iron, IIIAB','',NULL,'Mexico',NULL,NULL,NULL,NULL,77.60,1981,NULL,NULL,1),(16,'Adams County','M89.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,71.70,1928,NULL,NULL,1),(17,'Ad-Dahbubah','M423.1','Ordinary Chondrite','H',NULL,'Saudi Arabia',NULL,NULL,NULL,NULL,20.50,1961,NULL,NULL,1),(18,'Admire','M45.4','Differentiated Achondrite, Pallasite, PMG','',NULL,'USA',NULL,NULL,NULL,NULL,640.80,1881,NULL,NULL,1),(19,'Admire','M45.1','Differentiated Achondrite, Pallasite, PMG','',NULL,'USA',NULL,NULL,NULL,NULL,124.40,1881,NULL,NULL,1),(20,'Admire','M45.5','Differentiated Achondrite, Pallasite, PMG','',NULL,'USA',NULL,NULL,NULL,NULL,313.60,1881,NULL,NULL,1),(21,'Adrar Chiriet','M1368.2','Ordinary Chondrite','L',NULL,'Niger',NULL,NULL,NULL,NULL,39.50,2003,NULL,NULL,1),(22,'Adrar Chiriet','M1368.1','Ordinary Chondrite','L',NULL,'Niger',NULL,NULL,NULL,NULL,NULL,2003,NULL,NULL,1),(23,'Adrian','M453.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,76.00,1936,NULL,NULL,1),(24,'Agen','M606.2','Ordinary Chondrite','H',NULL,'France',NULL,NULL,NULL,NULL,410.40,1814,NULL,NULL,1),(25,'Agoudal','M1749.1','Iron, IIAB','',NULL,'Morocco',NULL,NULL,NULL,NULL,1040.00,2000,NULL,NULL,1),(26,'Agoult','M1060.1','Differentiated Achondrite, Eucrite','',NULL,'Morocco',NULL,NULL,NULL,NULL,2.30,2000,NULL,NULL,1),(27,'Agoult','M1060.2','Differentiated Achondrite, Eucrite','',NULL,'Morocco',NULL,NULL,NULL,NULL,51.70,2000,NULL,NULL,1),(28,'Ahumada','M752.1','Differentiated Achondrite, Pallasite, PMG','',NULL,'Mexico',NULL,NULL,NULL,NULL,181.50,1909,NULL,NULL,1),(29,'Ainsworth','M345.1','Iron, IIAB','',NULL,'USA',NULL,NULL,NULL,NULL,45.60,1907,NULL,NULL,1),(30,'Air','M1127.1','Ordinary Chondrite','L',NULL,'Niger',NULL,NULL,NULL,NULL,64.50,1925,NULL,NULL,1),(31,'Akron (1940)','M1412.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,77.40,1940,NULL,NULL,1),(32,'Akwanga','M540.1','Ordinary Chondrite','H',NULL,'Nigeria',NULL,NULL,NULL,NULL,62.40,NULL,NULL,NULL,1),(33,'Alamogordo','M294.3','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,62.40,1938,NULL,NULL,1),(34,'Alamogordo','M294.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,19.50,1938,NULL,NULL,1),(35,'Alamosa','M809.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,170.60,1937,NULL,NULL,1),(36,'Albin (pallasite)','M441.1','Differentiated Achondrite, Pallasite, PMG','',NULL,'USA',NULL,NULL,NULL,NULL,275.10,1915,NULL,NULL,1),(37,'Albion','M1257.1','Iron, IVA','',NULL,'USA',NULL,NULL,NULL,NULL,298.10,1966,NULL,NULL,1),(38,'Aldama (a)','M847.1','Iron, IIIAB','',NULL,'Mexico',NULL,NULL,NULL,NULL,278.60,1985,NULL,NULL,1),(39,'Aldama (b)','M1283.1','Ordinary Chondrite','H',NULL,'Mexico',NULL,NULL,NULL,NULL,68.30,1996,NULL,NULL,1),(40,'Aldsworth','M283.1','Ordinary Chondrite','LL',NULL,'England',NULL,NULL,NULL,NULL,9.20,1835,NULL,NULL,1),(41,'Alfianello','M62.1','Ordinary Chondrite','L',NULL,'Italy',NULL,NULL,NULL,NULL,74.20,1883,NULL,NULL,1),(42,'Alfianello','M62.5','Ordinary Chondrite','L',NULL,'Italy',NULL,NULL,NULL,NULL,178.20,1883,NULL,NULL,1),(43,'Aliskerovo','M649.1','Iron, IIIE','',NULL,'Russia',NULL,NULL,NULL,NULL,94.50,1977,NULL,NULL,1),(44,'Allan Hills A76009','M1317.1','Ordinary Chondrite','L',NULL,'Antarctica',NULL,NULL,NULL,NULL,19.90,1976,NULL,NULL,1),(45,'Allegan','M65.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,997.80,1899,NULL,NULL,1),(46,'Allen','M30.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,447.00,1923,NULL,NULL,1),(47,'Allende','M137.6','Carbonaceous Chondrite','CV',NULL,'Mexico',NULL,NULL,NULL,NULL,101.90,1969,NULL,NULL,1),(48,'Allende','M137.11','Carbonaceous Chondrite','CV',NULL,'Mexico',NULL,NULL,NULL,NULL,92.10,1969,NULL,NULL,1),(49,'Allende','M137.36','Carbonaceous Chondrite','CV',NULL,'Mexico',NULL,NULL,NULL,NULL,118.10,1969,NULL,NULL,1),(50,'Allende','M137.45','Carbonaceous Chondrite','CV',NULL,'Mexico',NULL,NULL,NULL,NULL,1272.20,1969,NULL,NULL,1),(51,'Acfer 346','M2141.1','Ordinary Chondrite','LL',NULL,'Algeria',NULL,NULL,NULL,NULL,6.20,2002,NULL,NULL,1),(52,'Acfer 358','M2142.2','Ordinary Chondrite','H',NULL,'Algeria',NULL,NULL,NULL,NULL,5.90,2002,NULL,NULL,1),(53,'Acfer 359','M2143.3','Ordinary Chondrite','H',NULL,'Algeria',NULL,NULL,NULL,NULL,4.20,2002,NULL,NULL,1),(54,'Acfer 361','M2145.6','Ordinary Chondrite','H',NULL,'Algeria',NULL,NULL,NULL,NULL,5.30,2002,NULL,NULL,1),(55,'Allende','M137.3','Carbonaceous Chondrite','CV',NULL,'Mexico',NULL,NULL,NULL,NULL,89.40,1969,NULL,NULL,1),(56,'Allende','M137.46','Carbonaceous Chondrite','CV',NULL,'Mexico',NULL,NULL,NULL,NULL,118.40,1969,NULL,NULL,1),(57,'Allende','M137.46a','Carbonaceous Chondrite','CV',NULL,'Mexico',NULL,NULL,NULL,NULL,0.90,1969,NULL,NULL,1),(58,'Allende','M137.46b','Carbonaceous Chondrite','CV',NULL,'Mexico',NULL,NULL,NULL,NULL,NULL,1969,NULL,NULL,1),(59,'Almahata Sitta','M1623.3','Primitive Achondrite','Ureilite',NULL,'Sudan',NULL,NULL,NULL,NULL,3.50,2008,NULL,NULL,1),(60,'Almahata Sitta','M1623.1','Primitive Achondrite','Ureilite',NULL,'Sudan',NULL,NULL,NULL,NULL,1.20,2008,NULL,NULL,1),(61,'Almahata Sitta','M1623.2','Primitive Achondrite','Ureilite',NULL,'Sudan',NULL,NULL,NULL,NULL,5.20,2008,NULL,NULL,1),(62,'Alt Bela','M648.1','Iron','IID',NULL,'Czech Republic',NULL,NULL,NULL,NULL,48.60,1898,NULL,NULL,1),(63,'Altonah','M663.1','Iron','IVA',NULL,'USA',NULL,NULL,NULL,NULL,96.20,1932,NULL,NULL,1),(64,'Alvord','M419.1','Iron','IVA',NULL,'USA',NULL,NULL,NULL,NULL,91.60,1976,NULL,NULL,1),(65,'Ambapur Nagla','M578.1','Ordinary Chondrite','H',NULL,'India',NULL,NULL,NULL,NULL,0.80,1895,NULL,NULL,1),(66,'Amber','M169.2','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,227.70,1934,NULL,NULL,1),(67,'Amherst','M810.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,284.60,1947,NULL,NULL,1),(68,'Andover','M1371.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,46.00,1898,NULL,NULL,1),(69,'Ankober','M636.1','Ordinary Chondrite','H',NULL,'Ethiopia',NULL,NULL,NULL,NULL,42.00,1942,NULL,NULL,1),(70,'Anson','M1004.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,111.00,1972,NULL,NULL,1),(71,'Anthony','M532.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,31.60,1919,NULL,NULL,1),(72,'Anton','M308.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,141.90,1965,NULL,NULL,1),(73,'Apache Junction','M1720.1','Iron','IIIAB',NULL,'USA',NULL,NULL,NULL,NULL,90.50,2005,NULL,NULL,1),(74,'Apoala','M225.1','Iron','IIIAB',NULL,'Mexico',NULL,NULL,NULL,NULL,29.90,1889,NULL,NULL,1),(75,'Appley Bridge','M766.1','Ordinary Chondrite','LL',NULL,'United Kingdom',NULL,NULL,NULL,NULL,41.80,1914,NULL,NULL,1),(76,'Apt','M1128.1','Ordinary Chondrite','L',NULL,'France',NULL,NULL,NULL,NULL,24.80,1803,NULL,NULL,1),(77,'Arapahoe','M336.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,46.50,1940,NULL,NULL,1),(78,'Arbol Solo','M844.2','Ordinary Chondrite','H',NULL,'Argentina',NULL,NULL,NULL,NULL,43.30,1954,NULL,NULL,1),(79,'Arbol Solo','M844.1','Ordinary Chondrite','H',NULL,'Argentina',NULL,NULL,NULL,NULL,3.00,1954,NULL,NULL,1),(80,'Arcadia','M450.1','Ordinary Chondrite','LL',NULL,'USA',NULL,NULL,NULL,NULL,140.40,1937,NULL,NULL,1),(81,'Arispe','M96.3','Iron','IC',NULL,'Mexico',NULL,NULL,NULL,NULL,752.30,1896,NULL,NULL,1),(82,'Arispe','M96.1','Iron','IC',NULL,'Mexivo',NULL,NULL,NULL,NULL,1128.50,1896,NULL,NULL,1),(83,'Arispe','M96.2','Iron','IC',NULL,'Mexico',NULL,NULL,NULL,NULL,61689.60,1896,NULL,NULL,1),(84,'Arispe','M96.4','Iron','IC',NULL,'Mexico',NULL,NULL,NULL,NULL,506.60,1896,NULL,NULL,1),(85,'Arispe','M96.11','Iron','IC',NULL,'Mexico',NULL,NULL,NULL,NULL,34.00,1896,NULL,NULL,1),(86,'Armel','M811.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,78.20,1967,NULL,NULL,1),(87,'Arriba','M289.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,199.60,1936,NULL,NULL,1),(88,'Arroyo Aguiar','M1159.1','Ordinary Chondrite','H',NULL,'Argentina',NULL,NULL,NULL,NULL,63.90,1950,NULL,NULL,1),(89,'asdad','123456','Achondrite','Acapulcoite',NULL,'(Northeast Africa)',NULL,NULL,NULL,NULL,10.00,1200,NULL,NULL,1),(90,'Ash Creek','M1455.7','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,125.70,2009,NULL,NULL,1),(91,'Ash Creek','M1455.10','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,12.30,2009,NULL,NULL,1),(92,'Ash Creek','M1455.9','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,79.10,2009,NULL,NULL,1),(93,'Ash Creek','M1455.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,23.10,2009,NULL,NULL,1),(94,'Ash Creek','M1455.2','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,23.30,2009,NULL,NULL,1),(95,'Ash Creek','M1455.3','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,104.90,2009,NULL,NULL,1),(96,'Ash Creek','M1455.4','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,29.40,2009,NULL,NULL,1),(97,'Ash Creek','M1455.5','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,7.20,2009,NULL,NULL,1),(98,'Ash Creek','M1455.6','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,1.20,2009,NULL,NULL,1),(99,'Ash Creek','M1455.8','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,46.00,2009,NULL,NULL,1),(100,'Ashmore','M189.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,327.30,1969,NULL,NULL,1),(101,'Atlanta','M863.1','Enstatite Chondrite','EL',NULL,'USA',NULL,NULL,NULL,NULL,27.30,1938,NULL,NULL,1),(102,'Atoka','M40.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,36.70,1945,NULL,NULL,1),(103,'Atoka','M40.2','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,518.20,1945,NULL,NULL,1),(104,'Attica','M849.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,100.90,1996,NULL,NULL,1),(105,'Atwood','M1015.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,16.20,1963,NULL,NULL,1),(106,'Augusta County','M867.1','Iron','IIIAB',NULL,'USA',NULL,NULL,NULL,NULL,245.90,1858,NULL,NULL,1),(107,'Augustinovka','M587.1','Iron','IIIAB',NULL,'Ukraine',NULL,NULL,NULL,NULL,3.30,1890,NULL,NULL,1),(108,'Aumale','M287.3','Ordinary Chondrite','L',NULL,'Algeria',NULL,NULL,NULL,NULL,40.10,1865,NULL,NULL,1),(109,'Aumieres','M754.2','Ordinary Chondrite','L',NULL,'France',NULL,NULL,NULL,NULL,32.70,1842,NULL,NULL,1),(110,'Ausson','M261.6','Ordinary Chondrite','L',NULL,'France',NULL,NULL,NULL,NULL,26.10,1858,NULL,NULL,1),(111,'Ausson','M261.5','Ordinary Chondrite','L',NULL,'France',NULL,NULL,NULL,NULL,18.70,1858,NULL,NULL,1),(112,'Avanhandava','M1098.1','Ordinary Chondrite','H',NULL,'Brazil',NULL,NULL,NULL,NULL,11.90,1952,NULL,NULL,1),(113,'Avoca','M873.1','Iron','IIIAB',NULL,'Australia',NULL,NULL,NULL,NULL,175.90,1966,NULL,NULL,1),(114,'Axtell','M412.1','Carbonaceous Chondrite','CV',NULL,'USA',NULL,NULL,NULL,NULL,264.30,1943,NULL,NULL,1),(115,'Aztec','M855.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,28.70,1938,NULL,NULL,1),(116,'BabbΓÇÖs Mill (TroostΓÇÖs Iron)','M662.1','Iron','Ungrouped',NULL,'USA',NULL,NULL,NULL,NULL,170.90,1842,NULL,NULL,1),(117,'Bachmut','M971.1','Ordinary Chondrite','L',NULL,'Ukraine',NULL,NULL,NULL,NULL,19.10,1814,NULL,NULL,1),(118,'Bacubirito','M601.2','Iron','Ungrouped',NULL,'Mexico',NULL,NULL,NULL,NULL,229.10,1863,NULL,NULL,1),(119,'Balcarce','M1035.1','Ordinary Chondrite','H',NULL,'Argentina',NULL,NULL,NULL,NULL,42.30,2000,NULL,NULL,1),(120,'Ballinoo','M623.2','Iron','IIC',NULL,'Australia',NULL,NULL,NULL,NULL,576.90,1892,NULL,NULL,1),(121,'Bandong','M545.1','Ordinary Chondrite','LL',NULL,'Indonesia',NULL,NULL,NULL,NULL,25.60,1871,NULL,NULL,1),(122,'Barbotan','M348.2','Ordinary Chondrite','H',NULL,'France',NULL,NULL,NULL,NULL,61.20,1790,NULL,NULL,1),(123,'Barranca Blanca','M719.1','Iron','IIE',NULL,'Chile',NULL,NULL,NULL,NULL,44.70,1855,NULL,NULL,1),(124,'Barratta','M247.2','Ordinary Chondrite','L',NULL,'Australia',NULL,NULL,NULL,NULL,134.70,1845,NULL,NULL,1),(125,'Barrilla','M695.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,262.10,1994,NULL,NULL,1),(126,'Bartlett','M552.1','Iron','IIIAB',NULL,'USA',NULL,NULL,NULL,NULL,54.70,1938,NULL,NULL,1),(127,'Barwell','M255.2','Ordinary Chondrite','L',NULL,'United Kingdom',NULL,NULL,NULL,NULL,22.90,1965,NULL,NULL,1),(128,'Barwise','M95.2','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,1.30,1950,NULL,NULL,1),(129,'Barwise','M95.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,262.90,1950,NULL,NULL,1),(130,'Bassikounou','M1362.4','Ordinary Chondrite','H',NULL,'Mauritania',NULL,NULL,NULL,NULL,23.70,2016,NULL,NULL,1),(131,'Bassikounou','M1362.3','Ordinary Chondrite','H',NULL,'Mauritania',NULL,NULL,NULL,NULL,76.00,2006,NULL,NULL,1),(132,'Bassikounou','M1362.2','Ordinary Chondrite','H',NULL,'Mauritania',NULL,NULL,NULL,NULL,156.40,2006,NULL,NULL,1),(133,'Bassikounou','M1362.1','Ordinary Chondrite','H',NULL,'Mauritania',NULL,NULL,NULL,NULL,373.90,2006,NULL,NULL,1),(134,'Baszkowka','M865.1','Ordinary Chondrite','L',NULL,'Poland',NULL,NULL,NULL,NULL,10.70,1994,NULL,NULL,1),(135,'Batesland','M744.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,120.30,1961,NULL,NULL,1),(136,'Bath','M579.3','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,105.30,1892,NULL,NULL,1),(137,'Bath Furnace','M541.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,27.00,1902,NULL,NULL,1),(138,'Baygorria','M1096.1','Primitive Achondrite','IAB',NULL,'Uruguay',NULL,NULL,NULL,NULL,307.10,1994,NULL,NULL,1),(139,'Bear Creek','M326.2','Iron','IIIAB',NULL,'USA',NULL,NULL,NULL,NULL,645.50,1866,NULL,NULL,1),(140,'Beardsley','M86.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,108.20,1929,NULL,NULL,1),(141,'Beaver','M365.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,829.40,1940,NULL,NULL,1),(142,'Beaver Creek','M581.2','Ordinary Chondrite','H',NULL,'Canada',NULL,NULL,NULL,NULL,119.10,1893,NULL,NULL,1),(143,'Bechar (001)','M806.1','Ordinary Chondrite','L',NULL,'Algeria',NULL,NULL,NULL,NULL,25.60,1998,NULL,NULL,1),(144,'Beeler','M515.1','Ordinary Chondrite','LL',NULL,'USA',NULL,NULL,NULL,NULL,55.00,1924,NULL,NULL,1),(145,'Beenham','M266.2','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,116.60,1937,NULL,NULL,1),(146,'Beenham','M266.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,197.80,1937,NULL,NULL,1),(147,'Bella Roca','M721.1','Iron','IIIAB',NULL,'Mexico',NULL,NULL,NULL,NULL,183.00,1888,NULL,NULL,1),(148,'Belle Plaine','M146.4','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,987.90,1950,NULL,NULL,1),(149,'Belle Plaine','M146.1','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,NULL,1950,NULL,NULL,1),(150,'Belle Plaine','M146.2','Ordinary Chondrite','L',NULL,'USA',NULL,NULL,NULL,NULL,NULL,1950,NULL,NULL,1),(151,'Bells','M193.1','Carbonaceous Chondrite','Ungrouped',NULL,'USA',NULL,NULL,NULL,NULL,19.30,1961,NULL,NULL,1),(152,'Bells','M193.3','Carbonaceous Chondrite','Ungrouped',NULL,'USA',NULL,NULL,NULL,NULL,65.50,1961,NULL,NULL,1),(153,'Belly River','M1219.1','Ordinary Chondrite','H',NULL,'Canada',NULL,NULL,NULL,NULL,17.20,1943,NULL,NULL,1),(154,'Belmont','M1758.1','Ordinary Chondrite','H',NULL,'USA',NULL,NULL,NULL,NULL,242.60,1958,NULL,NULL,1),(155,'Bencubbin','M888.1','Carbonaceous Chondrite','CB',NULL,'Australia',NULL,NULL,NULL,NULL,58.00,1930,NULL,NULL,1);
/*!40000 ALTER TABLE `MeteoriteSamples` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SamplesOnLoan`
--

DROP TABLE IF EXISTS `SamplesOnLoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SamplesOnLoan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loanId` int DEFAULT NULL,
  `meteoriteSampleId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `loanId` (`loanId`),
  KEY `meteoriteSampleId` (`meteoriteSampleId`),
  CONSTRAINT `samplesonloan_ibfk_1` FOREIGN KEY (`loanId`) REFERENCES `Loans` (`id`),
  CONSTRAINT `samplesonloan_ibfk_2` FOREIGN KEY (`meteoriteSampleId`) REFERENCES `MeteoriteSamples` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SamplesOnLoan`
--

LOCK TABLES `SamplesOnLoan` WRITE;
/*!40000 ALTER TABLE `SamplesOnLoan` DISABLE KEYS */;
/*!40000 ALTER TABLE `SamplesOnLoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subsamples`
--

DROP TABLE IF EXISTS `Subsamples`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subsamples` (
  `id` int NOT NULL AUTO_INCREMENT,
  `meteoriteSampleId` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `weight` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `meteoriteSampleId` (`meteoriteSampleId`),
  CONSTRAINT `subsamples_ibfk_1` FOREIGN KEY (`meteoriteSampleId`) REFERENCES `MeteoriteSamples` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subsamples`
--

LOCK TABLES `Subsamples` WRITE;
/*!40000 ALTER TABLE `Subsamples` DISABLE KEYS */;
/*!40000 ALTER TABLE `Subsamples` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-04 16:11:04
