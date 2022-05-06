-- MySQL dump 10.13  Distrib 5.7.29, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitalbd
-- ------------------------------------------------------
-- Server version	5.7.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounts` (
  `userName` varchar(15) NOT NULL,
  `passwd` varchar(20) NOT NULL,
  `typeUser` varchar(15) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('Admin','abcd*1234','Administrador'),('CE001','abcd*1234','Doctor'),('CE002','abcd*1234','Doctor'),('CE003','abcd*1234','Doctor'),('CE004','abcd*1234','Enfermero'),('CE005','abcd*1234','Enfermero'),('CE006','abcd*1234','Enfermero');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `codContract` varchar(5) NOT NULL,
  `contractType` varchar(25) NOT NULL,
  PRIMARY KEY (`codContract`),
  KEY `contractType` (`contractType`),
  CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`contractType`) REFERENCES `contract_type` (`contractType`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES ('CC002','Fijo'),('CC005','Fijo'),('CC001','Interino'),('CC004','Interino'),('CC003','Temporal'),('CC006','Temporal');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_employee`
--

DROP TABLE IF EXISTS `contract_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_employee` (
  `codEmployee` varchar(5) NOT NULL,
  `codContract` varchar(5) NOT NULL,
  `dateStart` date NOT NULL,
  `dateFinal` date NOT NULL,
  PRIMARY KEY (`codEmployee`,`codContract`),
  KEY `codContract` (`codContract`),
  CONSTRAINT `contract_employee_ibfk_1` FOREIGN KEY (`codEmployee`) REFERENCES `employee` (`codEmployee`) ON DELETE CASCADE,
  CONSTRAINT `contract_employee_ibfk_2` FOREIGN KEY (`codContract`) REFERENCES `contract` (`codContract`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_employee`
--

LOCK TABLES `contract_employee` WRITE;
/*!40000 ALTER TABLE `contract_employee` DISABLE KEYS */;
INSERT INTO `contract_employee` VALUES ('CE001','CC001','1918-04-07','1919-12-06'),('CE002','CC002','2000-07-04','9999-09-09'),('CE003','CC003','1998-03-09','1998-06-09'),('CE004','CC004','1918-04-07','1919-12-06'),('CE005','CC005','2010-11-06','9999-09-09'),('CE006','CC006','2006-05-05','2006-05-05');
/*!40000 ALTER TABLE `contract_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_type`
--

DROP TABLE IF EXISTS `contract_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_type` (
  `contractType` varchar(25) NOT NULL DEFAULT '',
  `description` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`contractType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_type`
--

LOCK TABLES `contract_type` WRITE;
/*!40000 ALTER TABLE `contract_type` DISABLE KEYS */;
INSERT INTO `contract_type` VALUES ('Fijo','El contrato esta pensado para durar indefinidamente'),('Interino','El contrato no tiene un limite de tiempo definido, pero pude llegar a extenderse si se siguen requiriendo sus servicios'),('Temporal','El contrato solo esta pensado para un limite de tiempo concreto');
/*!40000 ALTER TABLE `contract_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depart`
--

DROP TABLE IF EXISTS `depart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `depart` (
  `codDepart` varchar(5) NOT NULL,
  `nameDepart` varchar(50) NOT NULL,
  `activDepart` tinyint(1) NOT NULL,
  `specialty1` varchar(50) NOT NULL,
  `specialty2` varchar(50) DEFAULT NULL,
  `specialty3` varchar(50) DEFAULT NULL,
  `specialty4` varchar(50) DEFAULT NULL,
  `specialty5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codDepart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depart`
--

LOCK TABLES `depart` WRITE;
/*!40000 ALTER TABLE `depart` DISABLE KEYS */;
INSERT INTO `depart` VALUES ('CD001','Cirugía',1,'Cardiología','Neurología','General','Torácica','Robótica'),('CD002','Pediatría',1,'Nutrición','Oftalmología pediátrica','Oncología',NULL,NULL),('CD003','Ginecología y Obstetricia',0,'Endocrinología','Oncología','Cirugía laparoscópica',NULL,NULL);
/*!40000 ALTER TABLE `depart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `codEmployee` varchar(5) NOT NULL,
  `specialty_doc` varchar(50) NOT NULL,
  PRIMARY KEY (`codEmployee`),
  CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`codEmployee`) REFERENCES `employee` (`codEmployee`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('CE001','Oncología'),('CE002','Neurología'),('CE003','Oftalmología pediátrica');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `codEmployee` varchar(5) NOT NULL,
  `codDepart` varchar(5) NOT NULL,
  `dniEmployee` varchar(9) NOT NULL,
  `nameEmployee` varchar(15) NOT NULL,
  `lastNameEmployee1` varchar(25) NOT NULL,
  `lastNameEmployee2` varchar(25) DEFAULT NULL,
  `activEmployee` tinyint(1) NOT NULL,
  PRIMARY KEY (`codEmployee`,`codDepart`),
  KEY `codDepart` (`codDepart`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`codDepart`) REFERENCES `depart` (`codDepart`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('CE001','CD003','34567233L','Luis','Dominguez','Nuñez',0),('CE002','CD001','32284596H','Miguel','Ramirez',NULL,1),('CE003','CD002','16988430K','Sandra','Perez','Vergara',1),('CE004','CD003','93443789G','Sofia','Lorenzo',NULL,0),('CE005','CD001','11257764F','Dario','Placar','Barros',0),('CE006','CD002','45688321D','Maria','Carrera','Castillo',1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nurse` (
  `codEmployee` varchar(5) NOT NULL,
  `schedule` varchar(15) NOT NULL,
  PRIMARY KEY (`codEmployee`),
  CONSTRAINT `nurse_ibfk_1` FOREIGN KEY (`codEmployee`) REFERENCES `employee` (`codEmployee`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurse`
--

LOCK TABLES `nurse` WRITE;
/*!40000 ALTER TABLE `nurse` DISABLE KEYS */;
INSERT INTO `nurse` VALUES ('CE004','Nocturno'),('CE005','Diurno'),('CE006','Diurno');
/*!40000 ALTER TABLE `nurse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `cic` varchar(5) NOT NULL,
  `codEmployeeDoctor` varchar(5) NOT NULL,
  `codEmployeeNurse` varchar(5) NOT NULL,
  `dniPatient` varchar(9) NOT NULL,
  `namePatient` varchar(15) NOT NULL,
  `lastNamePatient1` varchar(25) NOT NULL,
  `lastNamePatient2` varchar(25) DEFAULT NULL,
  `tlf` int(9) DEFAULT NULL,
  `disease` varchar(50) NOT NULL,
  `recoverPatient` tinyint(1) NOT NULL,
  PRIMARY KEY (`cic`),
  KEY `codEmployeeDoctor` (`codEmployeeDoctor`),
  KEY `codEmployeeNurse` (`codEmployeeNurse`),
  CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`codEmployeeDoctor`) REFERENCES `doctor` (`codEmployee`) ON DELETE CASCADE,
  CONSTRAINT `patient_ibfk_2` FOREIGN KEY (`codEmployeeNurse`) REFERENCES `nurse` (`codEmployee`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('CP001','CE002','CE006','40234432J','Crish','Tina','Lopez',834652890,'Epilepsia incurable',1),('CP002','CE002','CE006','02344178F','Marco','Rossi','null',539267849,'Sobrecarga cerebral',1),('CP003','CE003','CE006','90122123B','Franchesca','Cifueyes','null',211478965,'Embarazo adolescente',0);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-08 13:03:56
