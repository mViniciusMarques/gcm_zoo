CREATE DATABASE  IF NOT EXISTS `zoo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `zoo`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: zoo
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `agenda_consulta`
--

DROP TABLE IF EXISTS `agenda_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda_consulta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ATENDIDO` varchar(4) NOT NULL,
  `data_agendamento` date NOT NULL,
  `horario_agendamento` varchar(45) NOT NULL,
  `STATUS` varchar(45) NOT NULL,
  `animal_codigo` int(11) NOT NULL,
  `veterinario_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_agenda_consulta_0` (`ID`),
  KEY `FK_agenda_consulta_animal_codigo` (`animal_codigo`),
  KEY `FK_agenda_consulta_veterinario_id` (`veterinario_id`),
  CONSTRAINT `FK_agenda_consulta_animal_codigo` FOREIGN KEY (`animal_codigo`) REFERENCES `animal` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_agenda_consulta_veterinario_id` FOREIGN KEY (`veterinario_id`) REFERENCES `veterinario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda_consulta`
--

LOCK TABLES `agenda_consulta` WRITE;
/*!40000 ALTER TABLE `agenda_consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `data_nascimento` date NOT NULL,
  `ESPECIE` varchar(255) NOT NULL,
  `NOME` varchar(255) NOT NULL,
  `PESO` double NOT NULL,
  `regiao_origem` varchar(255) NOT NULL,
  `boletim_saude_id` int(11) NOT NULL,
  `rotina_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE KEY `UNQ_ANIMAL_0` (`CODIGO`),
  KEY `FK_ANIMAL_boletim_saude_id` (`boletim_saude_id`),
  KEY `FK_ANIMAL_rotina_codigo` (`rotina_codigo`),
  CONSTRAINT `FK_ANIMAL_boletim_saude_id` FOREIGN KEY (`boletim_saude_id`) REFERENCES `boletim_saude` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ANIMAL_rotina_codigo` FOREIGN KEY (`rotina_codigo`) REFERENCES `rotina` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_tratador`
--

DROP TABLE IF EXISTS `animal_tratador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal_tratador` (
  `animal_codigo` int(11) NOT NULL,
  `tratador_id` int(11) NOT NULL,
  PRIMARY KEY (`animal_codigo`,`tratador_id`),
  KEY `FK_animal_tratador_tratador_id` (`tratador_id`),
  CONSTRAINT `FK_animal_tratador_animal_codigo` FOREIGN KEY (`animal_codigo`) REFERENCES `animal` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_animal_tratador_tratador_id` FOREIGN KEY (`tratador_id`) REFERENCES `tratador` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_tratador`
--

LOCK TABLES `animal_tratador` WRITE;
/*!40000 ALTER TABLE `animal_tratador` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal_tratador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletim`
--

DROP TABLE IF EXISTS `boletim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletim` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATA` date NOT NULL,
  `estado_animal` varchar(45) NOT NULL,
  `OBSERVACOES` longtext NOT NULL,
  `animal_codigo` int(11) NOT NULL,
  `tratador_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_BOLETIM_0` (`ID`),
  KEY `FK_BOLETIM_animal_codigo` (`animal_codigo`),
  KEY `FK_BOLETIM_tratador_id` (`tratador_id`),
  CONSTRAINT `FK_BOLETIM_animal_codigo` FOREIGN KEY (`animal_codigo`) REFERENCES `animal` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_BOLETIM_tratador_id` FOREIGN KEY (`tratador_id`) REFERENCES `tratador` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletim`
--

LOCK TABLES `boletim` WRITE;
/*!40000 ALTER TABLE `boletim` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletim_saude`
--

DROP TABLE IF EXISTS `boletim_saude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletim_saude` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_boletim_saude_0` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletim_saude`
--

LOCK TABLES `boletim_saude` WRITE;
/*!40000 ALTER TABLE `boletim_saude` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletim_saude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `data_atendimento` date DEFAULT NULL,
  `hora_atendimento` varchar(10) DEFAULT NULL,
  `agenda_consulta_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_CONSULTA_0` (`ID`),
  KEY `FK_CONSULTA_agenda_consulta_id` (`agenda_consulta_id`),
  CONSTRAINT `FK_CONSULTA_agenda_consulta_id` FOREIGN KEY (`agenda_consulta_id`) REFERENCES `agenda_consulta` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BAIRRO` varchar(45) NOT NULL,
  `CIDADE` varchar(45) NOT NULL,
  `ESTADO` varchar(45) NOT NULL,
  `NUMERO` int(11) NOT NULL,
  `RUA` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_ENDERECO_0` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Marumbi','JF','MG',107,'Carlos Luiz Reiter'),(2,'Bonfim','JF','MG',200,'Barão do Retiro');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_MEDICAMENTO_0` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES (1,'CONDROPLEX STICKS'),(2,'PREVICOX'),(3,'BRAVECTO'),(4,'PLAQUEOFF'),(5,'ANGELS EYES'),(6,'SIMPARIC');
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita`
--

DROP TABLE IF EXISTS `receita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receita` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `data_envio` date NOT NULL,
  `DOSE` varchar(45) NOT NULL,
  `frequencia_de_aplicacao` varchar(45) NOT NULL,
  `OBSERVACOES` longtext NOT NULL,
  `rotina_codigo` int(11) DEFAULT NULL,
  `veterinario_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_RECEITA_0` (`ID`),
  KEY `FK_RECEITA_rotina_codigo` (`rotina_codigo`),
  KEY `FK_RECEITA_veterinario_id` (`veterinario_id`),
  CONSTRAINT `FK_RECEITA_rotina_codigo` FOREIGN KEY (`rotina_codigo`) REFERENCES `rotina` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_RECEITA_veterinario_id` FOREIGN KEY (`veterinario_id`) REFERENCES `veterinario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita`
--

LOCK TABLES `receita` WRITE;
/*!40000 ALTER TABLE `receita` DISABLE KEYS */;
/*!40000 ALTER TABLE `receita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita_medicamento`
--

DROP TABLE IF EXISTS `receita_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receita_medicamento` (
  `medicamento_id` int(11) NOT NULL,
  `receita_id` int(11) NOT NULL,
  PRIMARY KEY (`medicamento_id`,`receita_id`),
  KEY `FK_receita_medicamento_receita_id` (`receita_id`),
  CONSTRAINT `FK_receita_medicamento_medicamento_id` FOREIGN KEY (`medicamento_id`) REFERENCES `medicamento` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_receita_medicamento_receita_id` FOREIGN KEY (`receita_id`) REFERENCES `receita` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita_medicamento`
--

LOCK TABLES `receita_medicamento` WRITE;
/*!40000 ALTER TABLE `receita_medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `receita_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_clinico`
--

DROP TABLE IF EXISTS `registro_clinico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_clinico` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DIAGNOSTICO` longtext NOT NULL,
  `observacao_geral` longtext NOT NULL,
  `tipo_atendimento` varchar(45) NOT NULL,
  `boletim_saude_id` int(11) NOT NULL,
  `veterinario_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_registro_clinico_0` (`ID`),
  KEY `FK_registro_clinico_boletim_saude_id` (`boletim_saude_id`),
  KEY `FK_registro_clinico_veterinario_id` (`veterinario_id`),
  CONSTRAINT `FK_registro_clinico_boletim_saude_id` FOREIGN KEY (`boletim_saude_id`) REFERENCES `boletim_saude` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_registro_clinico_veterinario_id` FOREIGN KEY (`veterinario_id`) REFERENCES `veterinario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_clinico`
--

LOCK TABLES `registro_clinico` WRITE;
/*!40000 ALTER TABLE `registro_clinico` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_clinico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotina`
--

DROP TABLE IF EXISTS `rotina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotina` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `data_validade` date NOT NULL,
  PRIMARY KEY (`CODIGO`),
  UNIQUE KEY `UNQ_ROTINA_0` (`CODIGO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotina`
--

LOCK TABLES `rotina` WRITE;
/*!40000 ALTER TABLE `rotina` DISABLE KEYS */;
/*!40000 ALTER TABLE `rotina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarefas`
--

DROP TABLE IF EXISTS `tarefas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` longtext NOT NULL,
  `rotina_codigo` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_TAREFAS_0` (`ID`),
  KEY `FK_TAREFAS_rotina_codigo` (`rotina_codigo`),
  CONSTRAINT `FK_TAREFAS_rotina_codigo` FOREIGN KEY (`rotina_codigo`) REFERENCES `rotina` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarefas`
--

LOCK TABLES `tarefas` WRITE;
/*!40000 ALTER TABLE `tarefas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarefas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratador`
--

DROP TABLE IF EXISTS `tratador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratador` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MATRICULA` varchar(45) NOT NULL,
  `NOME` varchar(255) NOT NULL,
  `SENHA` varchar(45) NOT NULL,
  `TELEFONE` varchar(45) NOT NULL,
  `endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_TRATADOR_0` (`ID`),
  UNIQUE KEY `UNQ_TRATADOR_1` (`MATRICULA`),
  KEY `FK_TRATADOR_endereco_id` (`endereco_id`),
  CONSTRAINT `FK_TRATADOR_endereco_id` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratador`
--

LOCK TABLES `tratador` WRITE;
/*!40000 ALTER TABLE `tratador` DISABLE KEYS */;
INSERT INTO `tratador` VALUES (1,'30274','tiago','123','3226-6416',1);
/*!40000 ALTER TABLE `tratador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratador_has_rotina`
--

DROP TABLE IF EXISTS `tratador_has_rotina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratador_has_rotina` (
  `rotina_codigo` int(11) NOT NULL,
  `tratador_id` int(11) NOT NULL,
  PRIMARY KEY (`rotina_codigo`,`tratador_id`),
  KEY `FK_tratador_has_rotina_tratador_id` (`tratador_id`),
  CONSTRAINT `FK_tratador_has_rotina_rotina_codigo` FOREIGN KEY (`rotina_codigo`) REFERENCES `rotina` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tratador_has_rotina_tratador_id` FOREIGN KEY (`tratador_id`) REFERENCES `tratador` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratador_has_rotina`
--

LOCK TABLES `tratador_has_rotina` WRITE;
/*!40000 ALTER TABLE `tratador_has_rotina` DISABLE KEYS */;
/*!40000 ALTER TABLE `tratador_has_rotina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacina`
--

DROP TABLE IF EXISTS `vacina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacina` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(45) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_VACINA_0` (`CODIGO`),
  UNIQUE KEY `UNQ_VACINA_1` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` VALUES (1,'120','anti-rábica'),(2,'130','antti-giardíase'),(3,'140','Óctupla'),(4,'150','Quíntupla');
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacina_registro_clinico`
--

DROP TABLE IF EXISTS `vacina_registro_clinico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacina_registro_clinico` (
  `vacina_id` int(11) NOT NULL,
  `registro_clinico_id` int(11) NOT NULL,
  PRIMARY KEY (`vacina_id`,`registro_clinico_id`),
  KEY `FK_vacina_registro_clinico_registro_clinico_id` (`registro_clinico_id`),
  CONSTRAINT `FK_vacina_registro_clinico_registro_clinico_id` FOREIGN KEY (`registro_clinico_id`) REFERENCES `registro_clinico` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_vacina_registro_clinico_vacina_id` FOREIGN KEY (`vacina_id`) REFERENCES `vacina` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina_registro_clinico`
--

LOCK TABLES `vacina_registro_clinico` WRITE;
/*!40000 ALTER TABLE `vacina_registro_clinico` DISABLE KEYS */;
/*!40000 ALTER TABLE `vacina_registro_clinico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinario`
--

DROP TABLE IF EXISTS `veterinario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veterinario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CRMV` varchar(45) NOT NULL,
  `data_registro` date NOT NULL,
  `MATRICULA` varchar(45) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `SENHA` varchar(45) NOT NULL,
  `TELEFONE` varchar(45) DEFAULT NULL,
  `endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_VETERINARIO_0` (`CRMV`),
  UNIQUE KEY `UNQ_VETERINARIO_1` (`ID`),
  KEY `FK_VETERINARIO_endereco_id` (`endereco_id`),
  CONSTRAINT `FK_VETERINARIO_endereco_id` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veterinario`
--

LOCK TABLES `veterinario` WRITE;
/*!40000 ALTER TABLE `veterinario` DISABLE KEYS */;
INSERT INTO `veterinario` VALUES (1,'4545451','2016-06-28','144','julia','123','3225-2873',2);
/*!40000 ALTER TABLE `veterinario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-30 17:51:39
