-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: portal_setup
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `homepagemaster`
--

DROP TABLE IF EXISTS `homepagemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homepagemaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surveyid` int NOT NULL,
  `marketunit` varchar(150) DEFAULT NULL,
  `clientgroup` varchar(150) DEFAULT NULL,
  `deliveryunit` varchar(150) DEFAULT NULL,
  `clientname` varchar(150) DEFAULT NULL,
  `cal` varchar(150) DEFAULT NULL,
  `deliverymd` varchar(150) DEFAULT NULL,
  `innovationlead` varchar(150) DEFAULT NULL,
  `projectid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_surveymaster1` (`surveyid`),
  KEY `projectidfk_idx` (`projectid`),
  CONSTRAINT `projectidfk` FOREIGN KEY (`projectid`) REFERENCES `projectmaster` (`id`),
  CONSTRAINT `surveyidfk` FOREIGN KEY (`surveyid`) REFERENCES `surveymaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homepagemaster`
--

LOCK TABLES `homepagemaster` WRITE;
/*!40000 ALTER TABLE `homepagemaster` DISABLE KEYS */;
INSERT INTO `homepagemaster` VALUES (1,1,'Test Market Unit','Test CG','Test DU','TestProject','Test CAL','Test Lead','test innovation lead',29),(4,1,'test MU 1','Test CG1','Test DU1','Test Project1','Test CAL1','Test Lead 1',NULL,33),(5,1,'Test MU1','Test CG2','Test DU2','Test Project1','Test CAL 1','Test Lead 2',NULL,33),(6,1,'Interactive','PRD','PRD','H&M','cora.stone','rajendra.joshi',NULL,13);
/*!40000 ALTER TABLE `homepagemaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `innovationparammaster`
--

DROP TABLE IF EXISTS `innovationparammaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `innovationparammaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surveyid` int NOT NULL,
  `innovationparameter` varchar(500) NOT NULL,
  `orderId` int NOT NULL,
  `maxscore` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `surveyidfk_ip_idx` (`surveyid`),
  CONSTRAINT `surveyidfk_ip` FOREIGN KEY (`surveyid`) REFERENCES `surveymaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `innovationparammaster`
--

LOCK TABLES `innovationparammaster` WRITE;
/*!40000 ALTER TABLE `innovationparammaster` DISABLE KEYS */;
INSERT INTO `innovationparammaster` VALUES (1,1,'Understand Client Challenges and Objectives',1,15),(2,1,'Innovation Capabilities within engagement',2,15),(3,1,'Client Co Innovation Framework',3,12),(4,1,'Degree of Innovation',4,9),(5,1,'Client Value',5,15),(6,1,'Client Testimonials (Audio & Video)',6,12),(7,1,'Leverage Accenture Innovation Architecture',7,12),(8,1,'Contribution to Accenture Innovation Architecture',8,9);
/*!40000 ALTER TABLE `innovationparammaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `innovationparamscoremaster`
--

DROP TABLE IF EXISTS `innovationparamscoremaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `innovationparamscoremaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `innovationparamid` int NOT NULL,
  `minscore` double NOT NULL,
  `maxscore` double NOT NULL,
  `level` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `innoparamfk_scoremaster_idx` (`innovationparamid`),
  CONSTRAINT `innoparamfk_scoremaster` FOREIGN KEY (`innovationparamid`) REFERENCES `innovationparammaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `innovationparamscoremaster`
--

LOCK TABLES `innovationparamscoremaster` WRITE;
/*!40000 ALTER TABLE `innovationparamscoremaster` DISABLE KEYS */;
INSERT INTO `innovationparamscoremaster` VALUES (1,1,0,3.75,'NOVICE'),(2,1,3.75,7.5,'BEGINNER'),(3,1,7.5,11.25,'PRACTITIONER'),(4,1,11.25,99999,'LEADER'),(5,2,0,3,'NOVICE'),(6,2,3,6,'BEGINNER'),(7,2,6,9,'PRACTITIONER'),(8,2,9,99999,'LEADER'),(9,3,0,3.75,'NOVICE'),(10,3,3.75,7.5,'BEGINNER'),(11,3,7.5,11.25,'PRACTITIONER'),(12,3,11.25,99999,'LEADER'),(13,4,6.75,99999,'LEADER'),(14,5,11.25,99999,'LEADER'),(15,5,7.5,11.25,'PRACTITIONER'),(16,5,3.75,7.5,'BEGINNER'),(17,5,0,3.75,'NOVICE'),(18,4,4.5,6.75,'PRACTITIONER'),(19,4,2.25,4.5,'BEGINNER'),(20,4,0,2.25,'NOVICE'),(21,6,0,3,'NOVICE'),(22,6,3,6,'BEGINNER'),(23,6,6,9,'PRACTITIONER'),(24,6,9,99999,'LEADER'),(25,7,0,3,'NOVICE'),(26,7,3,6,'BEGINNER'),(27,7,6,9,'PRACTITIONER'),(28,7,9,99999,'LEADER'),(29,8,0,2.25,'NOVICE'),(30,8,2.25,4.5,'BEGINNER'),(31,8,4.25,6.75,'PRACTITIONER'),(32,8,6.75,99999,'LEADER');
/*!40000 ALTER TABLE `innovationparamscoremaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `optionsmaster`
--

DROP TABLE IF EXISTS `optionsmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `optionsmaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `questionid` int NOT NULL,
  `answer` varchar(500) NOT NULL,
  `score` int NOT NULL,
  `orderId` int NOT NULL,
  `isdefault` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `questionfk_idx` (`questionid`),
  CONSTRAINT `questionfk` FOREIGN KEY (`questionid`) REFERENCES `questionairemaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optionsmaster`
--

LOCK TABLES `optionsmaster` WRITE;
/*!40000 ALTER TABLE `optionsmaster` DISABLE KEYS */;
INSERT INTO `optionsmaster` VALUES (1,1,'Please Select',0,1,1),(2,1,'No, I haven\'t discussed any innovation program with client at this point in time',0,2,0),(3,1,'Yes, the discussion has come in few meetings where Accenture capabilities in driving innovation were mentioned but hasn?t progressed thereafter',1,3,0),(4,1,'Yes, I have regular connects with clients talking on innovation program and objectives within the account',2,4,0),(5,1,'Yes, I have strategic level connects with senior stakeholders where innovation is a key contributor to business bottomline and brand value where also Accenture is a key partner in driving growth of business',3,5,0),(6,2,'Please Select',0,1,1),(7,2,'Not particularly other than the line of business Accenture is contracted to work and deliver',0,2,0),(8,2,'Yes we are aware, but we don?t necessarily talk about it as we are not driven by contractual obligations to delve into other sides of business',1,3,0),(9,2,'Yes, we are aware about the client business challenges and they are being discussed at project deliverable connects with business stakeholders',2,4,0),(10,2,'Yes, client business challenges are discussed at CXO levels with ATCI and do constitute a strategic lever for Accenture to develop/sustain business relationship in the future',3,5,0),(11,3,'Please Select',0,1,1),(12,3,'No, I am not privy to client business objectives',0,2,0),(13,3,'Yes, I am aware of client business objectives ',1,3,0),(14,3,'Yes, I am shared with client business objectives and interact with only those business units closer to our contractual deliverables to discuss their challenges and offer solutions',2,4,0),(15,3,'Yes, I am shared client business objectives by business CXOs and am in a strategic partnership with the business units to help attaining results on the client objectives',3,5,0),(16,4,'Please Select',0,1,1),(17,4,'No, I am not aware of long-term and short-term strategic goals of my client',0,2,0),(18,4,'Yes, I am aware of the long term and short term goals of our client but are aligned through contracted deliverables with our client',1,3,0),(19,4,'Yes, I am aware of the strategic goals and we have discussions with business counterparts where we can source work to align deliverables with the goals',2,4,0),(20,4,'Yes, I am aligned with the client\'s strategic goals and my pipeline of work is being shaped and defined by these strategic business goals',3,5,0),(21,5,'Please Select',0,1,1),(22,5,'No, as my resources are only aligned with current technologies and tech platforms mandated by the contractual deliverables',0,2,0),(23,5,'No, as my resource strategy is primarily driven for delivering exisiting technology solutions contracted by client and would require new workforce onboarding for niche solutions thereby adding a possibility of sourcing delay',1,3,0),(24,5,'Yes, I can deliver new solutions and technologies with my current workforce as I have strategically upgraded knowledge of key resources to start working on new technology solutions albeit a few',2,4,0),(25,5,'Yes, I have strategically resourced my project to deliver new technologies and solutions to clients considering current work and future pipeline of assignments',3,5,0),(26,6,'Please Select',0,1,1),(27,6,'Employees across all levels are not aware of any innovation initiative within account',0,2,0),(28,6,'Employees across all levels are aware of innovation program in the account',1,3,0),(29,6,'Employees across all levels are aware and capable of new ideas and are driven to work on new ideas',2,4,0),(30,6,'Employees across all levels are driven to work for innovation across the project deliverables where new pipeline of work is defined based on innovative ideas pertaining to client business challenges and strategic goals',3,5,0),(31,7,'Please Select',0,1,1),(32,7,'Not much participation across levels in innovation program / initiatives across either ATCI or account',0,2,0),(33,7,'Offshore senior resources and delivery managers are aligned to business challenges and objectives',1,3,0),(34,7,'Offshore senior resources and managers are aligned and have connect sessions to discuss objectives and goals with the wider team',2,4,0),(35,7,'Regular connect sessions with clients to discuss business strategic goals and objectives wherein assignments are aligned to deliver solutions towards those objectives primarily driven by ATCI resources both at offshore and onshore',3,5,0),(36,8,'Please Select',0,1,1),(37,8,'Technology scope is only defined by contractual deliverables',0,2,0),(38,8,'We have discussion forums on new technologies and innovations but we don?t actively pursue those as not defined in the contract',1,3,0),(39,8,'We propose solutions based on the scope of current work and the scope of new technologies and innovations is define by that scope of work only',2,4,0),(40,8,'Ideas and solutions are ideated, discussed and designed using the latest SMAC technologies wherein strategic partnerships have been defined with vendors to deliver world class solutions based on latest technologies',3,5,0),(41,9,'Please Select',0,1,1),(42,9,'Trainings are only deliverables perspective and technology in scope of contractual delivery',0,2,0),(43,9,'The resources participate as and when the trainings are announced.',1,3,0),(44,9,'We have a training tracker tracking resources attending various bootcamps and technology trainings',2,4,0),(45,9,'We have a training framework in place where resources are not only sent to targeted technology trainings and bootcamps but also we arrange for trainings whenever necessary to train resources on latest technologies for project deliverables',3,5,0),(46,10,'Please Select',0,1,1),(47,10,'No, I don?t have any space designed like such.',0,2,0),(48,10,'Yes, I make use of meeting rooms and office spaces for design discussions',1,3,0),(49,10,'Yes, I have a design space built within the project space for design thinking discussions',2,4,0),(50,10,'Yes, I have DT sessions planned on regular intervals making use of DT spaces within Accenture premises.',3,5,0),(51,11,'Please Select',0,1,1),(52,11,'No, I don?t have any co-innovation framework defined',0,2,0),(53,11,'No, I don?t have but am working on it and have planned for the near future',1,3,0),(54,11,'Yes, but I have an adhoc framework with limited sponsorship as of now',2,4,0),(55,11,'Yes, I have a proven innovation framework in place wherein I have joint innovation councils with the client discussing on new innovations and ideas generated in the project',3,5,0),(56,12,'Please Select',0,1,1),(57,12,'No, I don?t have any co-innovation roadmap defined and not foreseen in near future',0,2,0),(58,12,'No, I don?t have but am working on it to define in the near future',1,3,0),(59,12,'Yes, but I have an adhoc roadmap with limited sponsorship as of now',2,4,0),(60,12,'Yes, I have a proven innovation roadmap in place wherein the business areas to focus on innovation are clearly defined and have the right business sponsorship in place',3,5,0),(61,13,'Please Select',0,1,1),(62,13,'No, we don?t conduct any co-innovation workshops with or without client in my account',0,2,0),(63,13,'No, I haven\'t conducted any workshops directly with client yet',1,3,0),(64,13,'Yes, I have the co-innovation framework in place but is driven primarily by Accenture with low level participation from client',2,4,0),(65,13,'Yes, I have a well proven co-innovation framework in place with frequent workshops with clients to discuss innovative ideas and business challenges',3,5,0),(66,14,'Please Select',0,1,1),(67,14,'No, account does not conduct any co-innovation workshops within project at onshore or offshore with ATCI resource participation',0,2,0),(68,14,'No, we do not conduct any co-innovation workshops at offshore though there are few discussions that do happen at onshore with ATCI participation.',1,3,0),(69,14,'Yes, we have internal teams participating in adhoc workshops conducted within project both at onshore and offshore locations with ATCI resource participation',2,4,0),(70,14,'Yes, we have a well proven co-innovation framework wherein regular connects and discussions take place within projects both at onshore and offshore and across and the outcomes are discussed in innovation councils with business',3,5,0),(71,15,'Please Select',0,1,1),(72,15,'No, we are focused on contractual deliverables at this point in time and haven\'t thought on CI or incremental innovation as of yet',0,2,0),(73,15,'Yes, we have continuous improvement driven outcomes within projects which are being shared and discussed with clients regularly',1,3,0),(74,15,'Yes, we have small process level incremental innovation within projects based on the current understanding of the business objectives at large along with the CI driven outcomes',2,4,0),(75,15,'Yes, we have not only CI driven outcomes but differential and unconventional approach to innovation resulting in significant gains to client',3,5,0),(76,16,'Please Select',0,1,1),(77,16,'No, not heard of breakthrough innovation at all',0,2,0),(78,16,'No, we don?t have any breakthrough innovation to mention yet but only CI driven initiatives',1,3,0),(79,16,'No, our innovations are designed to address current business problems which are more step innovation and CI driven initiatives',2,4,0),(80,16,'Yes, we have demonstrated breakthrough innovation through unconventional / out-of-box thinking resulting in strategic outcomes for the benefit of the client',3,5,0),(81,17,'Please Select',0,1,1),(82,17,'No, not heard of transformational innovation at all',0,2,0),(83,17,'No, we have not seen any transformational innovation yet',1,3,0),(84,17,'No, our innovations are designed to address current business problems which are more step innovation or CI driven initiatives',2,4,0),(85,17,'Yes, we have demonstrated transformational innovation through unconventional / out-of-box thinking resulting in strategic outcomes for the benefit of the client',3,5,0),(86,18,'Please Select',0,1,1),(87,18,'No, we don?t have any new technologies other than what is prescribed by contract',0,2,0),(88,18,'No, innovation approach is defined by client needs and are mostly looking to improve BAU legacy technologies',1,3,0),(89,18,'Yes, to a small level where technologies are defined by scope of new work being done on newer technologies',2,4,0),(90,18,'Yes, strong partnership with vendors and Accenture Labs etc. to bring latest SMAC/ digital technologies in the scope of work',3,5,0),(91,19,'Please Select',0,1,1),(92,19,'No, we don?t co-innovate with our client yet',0,2,0),(93,19,'No, we don?t have any co-innovation nomination',1,3,0),(94,19,'Yes, we have demonstrated co-innovation ideas in IG level forums',2,4,0),(95,19,'Yes, we have demonstrated co-innovation ideas across IG level forums in ATCI driven co-innovation competitions.',3,5,0),(96,20,'Please Select',0,1,1),(97,20,'No involvement of client yet',0,2,0),(98,20,'Individual business leads',1,3,0),(99,20,'LoB executive sponsors',2,4,0),(100,20,'CXO level participation and sponsorship in innovation initiatives',3,5,0),(101,21,'Please Select',0,1,1),(102,21,'We have not discussed any high impact ideas with client yet',0,2,0),(103,21,'No, we don?t have any high impact ideas suggested to client but are mostly CI driven outcomes',1,3,0),(104,21,'Significant business benefits to client with value realized will be at least $5M-10M per year',2,4,0),(105,21,'Very significant business benefits to client with value realized will be at least >$10M per year',3,5,0),(106,22,'Please Select',0,1,1),(107,22,'Business benefits realized will be less than $1M per year',0,2,0),(108,22,'Business benefits realized less than $1M-$4.9M value per year',1,3,0),(109,22,'Business benefits realized will be at least $5M-10M per year',2,4,0),(110,22,'Business benefits realized will be at least >$10M per year',3,5,0),(111,23,'Please Select',0,1,1),(112,23,'No we don?t have a program to define any co-innovation stories',0,2,0),(113,23,'No client testimonials on innovation driven outcomes',1,3,0),(114,23,'Yes, but they are not developed to share on the innovation platform',2,4,0),(115,23,'Yes, we have consistent few co-innovation stories which are used as references in Accenture discussions across IGs on innovation',3,5,0),(116,24,'Please Select',0,1,1),(117,24,'No client co-innovation program',0,2,0),(118,24,'No involvement with client stakeholders yet',1,3,0),(119,24,'Mid level Management',2,4,0),(120,24,'LOB leads and CXO endorsements',3,5,0),(121,25,'Please Select',0,1,1),(122,25,'No client co-innovation program',0,2,0),(123,25,'No client testimonials on innovation driven outcomes',1,3,0),(124,25,'Yes, mid level management endorsements and testimonials',2,4,0),(125,25,'Yes, CXO level management endorsements and testimonials',3,5,0),(126,26,'Please Select',0,1,1),(127,26,'No client co-innovation program',0,2,0),(128,26,'No, we cant use any client reference',1,3,0),(129,26,'Yes, but need client approvals',2,4,0),(130,26,'Yes, client want to share success stories across platforms / Media savvy clients',3,5,0),(131,27,'Please Select',0,1,1),(132,27,'No, we don?t involve Accenture Innovation ecosystem yet',0,2,0),(133,27,'Yes, Some form of collaboration exists with Accenture Labs/Studio, mostly for reference purposes, for developing rudimentary innovation tools.',1,3,0),(134,27,'Yes, Enhanced level of involvement exists with Accenture Studio/Lab. However, there have been few Innovation outcomes driven collaboratively between Accenture Labs/Studios and projects .',2,4,0),(135,27,'Yes, A very high level of involvement with Accenture Studio /Labs. There exists an extensive use of innovation tool, that has resulted in a strategic partnership with Accenture Labs/Studio. Delivery and innovation outcomes are jointly funded by client',3,5,0),(136,28,'Please Select',0,1,1),(137,28,'We don?t have opportunities to leverage industry assets yet',0,2,0),(138,28,'Accenture Studio and Accenture Labs solutions have not been used to suggest possible solutions to the client problem statements.',1,3,0),(139,28,'Accenture Studio and Accenture Labs solutions have been used to suggest possible solutions to the client problem statements, However, these suggestions include the use of rudimentary innovation tools only.',2,4,0),(140,28,'Accenture Studio and Accenture Labs solutions have been used to suggest possible solutions to the client problem statements, There is an extensive use of innovation tools, provided by Accenture Studio/Labs, to suggest solutions to client problems.',3,5,0),(141,29,'Please Select',0,1,1),(142,29,'No, its not in agenda at all',0,2,0),(143,29,'Yes, Innovation Hub visits are in agenda but not mandatory',1,3,0),(144,29,'Yes, Innovation Hub / Studio visits are planned occasionally for client visits. However, not for all client visits.',2,4,0),(145,29,'Yes, All client visits include a session at the Innovation Hub.',3,5,0),(146,30,'Please Select',0,1,1),(147,30,'No, we don?t discuss any such assets with client',0,2,0),(148,30,'No, Accenture Studio / Lab assets are mentioned but not mandatory to showcase any such assets',1,3,0),(149,30,'Yes, Accenture Studio / Lab assets are showcased to clients. However, not extensively ',2,4,0),(150,30,'Yes, Accenture Studio / Lab assets are extensively showcased to clients.',3,5,0),(151,31,'Please Select',0,1,1),(152,31,'No, we don?t have that in agenda',0,2,0),(153,31,'No, we have a plan to showcase but not working towards and don?t have a timeline',1,3,0),(154,31,'Yes, Few stories, using basic level of Automation, planned in the near future and is in roadmap for this year',2,4,0),(155,31,'Yes, High Impact Story boards have been showcased at the Accenture Innovation Hub. These stories have a high degree of re-usability across industries and have resulted in co-partnerships with client to increase sales and business development.',3,5,0),(156,32,'Please Select',0,1,1),(157,32,'No, we don?t have that in agenda',0,2,0),(158,32,'Yes, Few stories have been created in collaboration with Accenture Innovation Hub/Accenture Studio using basic levels of Automation for client business benefit.',1,3,0),(159,32,'Yes, High Impact Story board have been created with Accenture Innovation hub/Accenture Studio,  to realize business benefits ($5M-10M per year);',2,4,0),(160,32,'Yes, Very High Impact Story board have been created with Accenture Innovation hub/Accenture Studio, to realize business benefits (>$10M per year);Re-usability across various industry sectors - Very High.Co-partnerships created with client for future sales and business development',3,5,0),(161,33,'Please Select',0,1,1),(162,33,'No, we don?t have that in agenda',0,2,0),(163,33,'No, Client Assets have not been showcased to the Accenture Innovation Hub/ Accenture Studio yet',1,3,0),(164,33,'Yes, Few client assets have been showcased (or planned to showcase in the near future) to the Accenture Innovation Hub / Accenture Studio. These assets do not have cross industry re-usability, however can be re-used in the same industry.',2,4,0),(165,33,'Yes, Very High Impact client assets have been showcased to the Accenture Innovation Hub/ Accenture Studio. These assets have cross industry re-usability.',3,5,0);
/*!40000 ALTER TABLE `optionsmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectmaster`
--

DROP TABLE IF EXISTS `projectmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projectmaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectmaster`
--

LOCK TABLES `projectmaster` WRITE;
/*!40000 ALTER TABLE `projectmaster` DISABLE KEYS */;
INSERT INTO `projectmaster` VALUES (1,'Airbus'),(2,'AXA'),(3,'BANK OF IRELAND'),(4,'Barclays'),(5,'BMW'),(6,'BP'),(7,'BRITISH TELECOM'),(8,'CARLSBERG'),(9,'COOP'),(10,'DEUTSCHE BANK'),(11,'ENI SAIPEM'),(12,'FIAT'),(13,'H&M'),(14,'NATIONWIDE BUILDING SOCIETY'),(15,'NATWEST GROUP'),(16,'OP GROUP'),(17,'RABOBANK'),(18,'ROYAL MAIL GROUP LTD'),(19,'Shell'),(20,'SIEMENS'),(21,'SWISSCOM'),(22,'TELEFONICA O2 UK'),(23,'TOTAL SA'),(24,'UBS'),(25,'UK POLICE & JUSTICE'),(26,'UNILEVER'),(27,'VIRGIN MONEY'),(28,'VODAFONE GROUP'),(29,'TestProject'),(30,'Test Project 2'),(31,'Test Project 3'),(32,'Test Project 4'),(33,'Test Project1');
/*!40000 ALTER TABLE `projectmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionairemaster`
--

DROP TABLE IF EXISTS `questionairemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionairemaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `innovationparamid` int NOT NULL,
  `question` varchar(500) NOT NULL,
  `orderId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_innoParammaster` (`innovationparamid`),
  CONSTRAINT `innoparamfk-qmaster` FOREIGN KEY (`innovationparamid`) REFERENCES `innovationparammaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionairemaster`
--

LOCK TABLES `questionairemaster` WRITE;
/*!40000 ALTER TABLE `questionairemaster` DISABLE KEYS */;
INSERT INTO `questionairemaster` VALUES (1,1,'Do you have discussed innovation program in the account with your client?',1),(2,1,'Do you understand your client business challenges?',2),(3,1,'Have you been shared with business objectives of your client partners?',3),(4,1,'Are you aware of long term and short term strategic goals of your client?',4),(5,1,'Is your project aligned to deliver business value to the client?',5),(6,2,'What is the level of employee engagement in innovation within your project?',1),(7,2,'What has been the diversity of view, voice and experience of participation?',2),(8,2,'What is the scope of new technology used for ideation?',3),(9,2,'What is the level of participation in innovation bootcamps and new technology trainings?',4),(10,2,'Do you have infrastructure within engagement on innovative thinking?',5),(11,3,'Do you have co-innovation framework in place?',1),(12,3,'Do you have co-innovation roadmap defined?',2),(13,3,'Do you conduct co-innovation workshops with client?',3),(14,3,'Do you conduct co-innovation workshops within project?',4),(15,4,'What do you think you do- continuous improvement or incremental innovation?',1),(16,4,'Do you have any cases that you can quote as breakthrough innovation? ',2),(17,4,'Do you have any transformational innovation?',3),(18,5,'Do you have any technology innovation using new technologies?',1),(19,5,'Do you have a co-innovation nomination?',2),(20,5,'What is the stakeholder involvement level in innovation program?',3),(21,5,'What are the high impact ideas to the client?',4),(22,5,'What are the business benefits enabled and realized in $ value w.r.t innovation?',5),(23,6,'Do you have any co-innovation stories ?',1),(24,6,'What is the stakeholder level for client testimonial ?',2),(25,6,'Do you have any video and/or audio testimonials?',3),(26,6,'Can we reference your client for innovation?',4),(27,7,'Do you involve Accenture Studio / Accenture Labs / Ecosystem partners to solve client problems?',1),(28,7,'How do you demonstrate leveraging industry assets?',2),(29,7,'Do you plan for Innovation Hub visits during client visits?',3),(30,7,'Do you remote showcase Accenture Studio / Lab assets to your clients?',4),(31,8,'Do you plan account showcases at Accenture Innovation Hub?',1),(32,8,'Do you collaborate with Accenture Innovation Hub / Accenture Studio for client innovation framework / architecture?',2),(33,8,'Do you showcase client assets to Accenture Innovation Hub/ Accenture Studio?',3);
/*!40000 ALTER TABLE `questionairemaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendations`
--

DROP TABLE IF EXISTS `recommendations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `level` varchar(20) DEFAULT NULL,
  `recommendations` varchar(250) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendations`
--

LOCK TABLES `recommendations` WRITE;
/*!40000 ALTER TABLE `recommendations` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommendations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveymaster`
--

DROP TABLE IF EXISTS `surveymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveymaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surveytitle` varchar(450) NOT NULL,
  `version` float(2,1) DEFAULT NULL,
  `maxscore` int DEFAULT NULL,
  `maxrating` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveymaster`
--

LOCK TABLES `surveymaster` WRITE;
/*!40000 ALTER TABLE `surveymaster` DISABLE KEYS */;
INSERT INTO `surveymaster` VALUES (1,'Innovation Questionaire',1.0,99,8.9);
/*!40000 ALTER TABLE `surveymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveyresult`
--

DROP TABLE IF EXISTS `surveyresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveyresult` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `projectid` int DEFAULT NULL,
  `surveyid` int NOT NULL,
  `marketunit` varchar(150) DEFAULT NULL,
  `clientgroup` varchar(150) DEFAULT NULL,
  `deliveryunit` varchar(150) DEFAULT NULL,
  `clientname` varchar(150) DEFAULT NULL,
  `cal` varchar(150) DEFAULT NULL,
  `deliverymd` varchar(150) DEFAULT NULL,
  `innovationlead` varchar(150) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `score` double DEFAULT '0',
  `createdon` datetime DEFAULT NULL,
  `submittedon` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userfk_idx` (`userid`),
  KEY `projectfk_idx` (`projectid`),
  KEY `surveyfk_idx` (`surveyid`),
  CONSTRAINT `projectfk` FOREIGN KEY (`projectid`) REFERENCES `projectmaster` (`id`),
  CONSTRAINT `surveyfk` FOREIGN KEY (`surveyid`) REFERENCES `surveymaster` (`id`),
  CONSTRAINT `userfk` FOREIGN KEY (`userid`) REFERENCES `usermaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveyresult`
--

LOCK TABLES `surveyresult` WRITE;
/*!40000 ALTER TABLE `surveyresult` DISABLE KEYS */;
INSERT INTO `surveyresult` VALUES (14,5,13,1,'Interactive','PRD','PRD','H&M','cora.stone','rajendra.joshi','sajith.k.malayath@accenture.com','SUBMITTED',32,NULL,'2021-04-30 16:37:35'),(15,5,13,1,'Interactive','PRD','PRD','H&M','cora.stone','rajendra.joshi','sajith.k.malayath@accenture.com','SUBMITTED',32,'2021-04-30 16:45:41','2021-04-30 16:45:41');
/*!40000 ALTER TABLE `surveyresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveyresultinnoscore`
--

DROP TABLE IF EXISTS `surveyresultinnoscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveyresultinnoscore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surveyresultid` int NOT NULL,
  `score` int NOT NULL,
  `innoparamid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `surveyresult_fk_001_idx` (`surveyresultid`),
  KEY `innoparamid_fk_001_idx` (`innoparamid`),
  CONSTRAINT `innoparamid_fk_001` FOREIGN KEY (`innoparamid`) REFERENCES `innovationparammaster` (`id`),
  CONSTRAINT `surveyresult_fk_001` FOREIGN KEY (`surveyresultid`) REFERENCES `surveyresult` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveyresultinnoscore`
--

LOCK TABLES `surveyresultinnoscore` WRITE;
/*!40000 ALTER TABLE `surveyresultinnoscore` DISABLE KEYS */;
INSERT INTO `surveyresultinnoscore` VALUES (1,14,3,1),(2,14,7,2),(3,14,2,3),(4,14,5,4),(5,14,6,5),(6,14,1,6),(7,14,5,7),(8,14,3,8),(9,15,3,1),(10,15,7,2),(11,15,2,3),(12,15,5,4),(13,15,6,5),(14,15,1,6),(15,15,5,7),(16,15,3,8);
/*!40000 ALTER TABLE `surveyresultinnoscore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveyresultquestionscore`
--

DROP TABLE IF EXISTS `surveyresultquestionscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveyresultquestionscore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surveyresultid` int NOT NULL,
  `score` int DEFAULT '0',
  `comments` varchar(500) DEFAULT NULL,
  `answerid` int DEFAULT NULL,
  `questionid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `surveyresultfk_idx` (`surveyresultid`),
  CONSTRAINT `surveyresultfk` FOREIGN KEY (`surveyresultid`) REFERENCES `surveyresult` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveyresultquestionscore`
--

LOCK TABLES `surveyresultquestionscore` WRITE;
/*!40000 ALTER TABLE `surveyresultquestionscore` DISABLE KEYS */;
INSERT INTO `surveyresultquestionscore` VALUES (47,14,1,' comments 001',3,1),(48,14,0,' comments 001-1',7,2),(49,14,2,' comments 001-1-2',14,3),(50,14,0,' comments 001-1-2',16,4),(51,14,0,' comments 001-1-2',21,5),(52,14,1,' comments 001-1-2',28,6),(53,14,3,' comments 001-1-2',35,7),(54,14,0,' comments 001-1-2',37,8),(55,14,2,' comments 001-1-2',44,9),(56,14,1,' comments 001-1-2',48,10),(57,14,1,' comments 001-1-2',53,11),(58,14,0,' comments 001-1-2',57,12),(59,14,0,' comments 001-1-2',61,13),(60,14,1,' comments 001-1-2',68,14),(61,14,2,' comments 001-1-2',74,15),(62,14,2,' comments 001-1-2',79,16),(63,14,1,' comments 001-1-2',83,17),(64,14,1,' comments 001-1-2',88,18),(65,14,3,' comments 001-1-2',95,19),(66,14,1,' comments 001-1-2',98,20),(67,14,0,' comments 001-1-2',102,21),(68,14,1,' comments 001-1-2',108,22),(69,14,0,' comments 001-1-2',111,23),(70,14,0,' comments 001-1-2',117,24),(71,14,0,' comments 001-1-2',122,25),(72,14,1,' comments 001-1-2',128,26),(73,14,1,' comments 001-1-2',133,27),(74,14,0,' comments 001-1-2',137,28),(75,14,3,' comments 001-1-2',145,29),(76,14,1,' comments 001-1-2',148,30),(77,14,0,' comments 001-1-2',152,31),(78,14,3,' comments 001-1-2',160,32),(79,14,0,' comments 001-1-2',161,33),(80,15,1,' comments 001',3,1),(81,15,0,' comments 001-1',7,2),(82,15,2,' comments 001-1-2',14,3),(83,15,0,' comments 001-1-2',16,4),(84,15,0,' comments 001-1-2',21,5),(85,15,1,' comments 001-1-2',28,6),(86,15,3,' comments 001-1-2',35,7),(87,15,0,' comments 001-1-2',37,8),(88,15,2,' comments 001-1-2',44,9),(89,15,1,' comments 001-1-2',48,10),(90,15,1,' comments 001-1-2',53,11),(91,15,0,' comments 001-1-2',57,12),(92,15,0,' comments 001-1-2',61,13),(93,15,1,' comments 001-1-2',68,14),(94,15,2,' comments 001-1-2',74,15),(95,15,2,' comments 001-1-2',79,16),(96,15,1,' comments 001-1-2',83,17),(97,15,1,' comments 001-1-2',88,18),(98,15,3,' comments 001-1-2',95,19),(99,15,1,' comments 001-1-2',98,20),(100,15,0,' comments 001-1-2',102,21),(101,15,1,' comments 001-1-2',108,22),(102,15,0,' comments 001-1-2',111,23),(103,15,0,' comments 001-1-2',117,24),(104,15,0,' comments 001-1-2',122,25),(105,15,1,' comments 001-1-2',128,26),(106,15,1,' comments 001-1-2',133,27),(107,15,0,' comments 001-1-2',137,28),(108,15,3,' comments 001-1-2',145,29),(109,15,1,' comments 001-1-2',148,30),(110,15,0,' comments 001-1-2',152,31),(111,15,3,' comments 001-1-2',160,32),(112,15,0,' comments 001-1-2',161,33);
/*!40000 ALTER TABLE `surveyresultquestionscore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveyresultscore`
--

DROP TABLE IF EXISTS `surveyresultscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveyresultscore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `scoreparamid` int NOT NULL,
  `scoreparamtype` varchar(255) NOT NULL,
  `surveyresultid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveyresultscore`
--

LOCK TABLES `surveyresultscore` WRITE;
/*!40000 ALTER TABLE `surveyresultscore` DISABLE KEYS */;
/*!40000 ALTER TABLE `surveyresultscore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveyresultscoremaster`
--

DROP TABLE IF EXISTS `surveyresultscoremaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveyresultscoremaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surveyid` int NOT NULL,
  `minscore` double NOT NULL,
  `maxscore` double NOT NULL,
  `level` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `surveyfk_idx` (`surveyid`),
  CONSTRAINT `surveyfk_forscoremaster` FOREIGN KEY (`surveyid`) REFERENCES `surveymaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveyresultscoremaster`
--

LOCK TABLES `surveyresultscoremaster` WRITE;
/*!40000 ALTER TABLE `surveyresultscoremaster` DISABLE KEYS */;
INSERT INTO `surveyresultscoremaster` VALUES (2,1,0,2.99,'NOVICE'),(3,1,2.99,4.99,'BEGINNER'),(4,1,4.99,6.99,'PRACTITIONER'),(5,1,6.99,999,'LEADER');
/*!40000 ALTER TABLE `surveyresultscoremaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usermaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `useremail` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `marketunit` varchar(150) DEFAULT NULL,
  `active` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,'testUser1@test.com','User','',1),(2,'testUser2@test.com','MU Lead','Test Market Unit',1),(3,'testUser3@test.com','Super Admin','ALL',1),(4,'testUser4@test.com','User',NULL,1),(5,'naseem.malik@accenture.com','User',NULL,1);
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userprojectmapping`
--

DROP TABLE IF EXISTS `userprojectmapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userprojectmapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `projectid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userfk01_idx` (`userid`),
  KEY `projectfk01_idx` (`projectid`),
  CONSTRAINT `projectfk01` FOREIGN KEY (`projectid`) REFERENCES `projectmaster` (`id`),
  CONSTRAINT `userfk01` FOREIGN KEY (`userid`) REFERENCES `usermaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userprojectmapping`
--

LOCK TABLES `userprojectmapping` WRITE;
/*!40000 ALTER TABLE `userprojectmapping` DISABLE KEYS */;
INSERT INTO `userprojectmapping` VALUES (1,1,29),(2,1,30),(3,2,31),(4,4,33),(5,5,13);
/*!40000 ALTER TABLE `userprojectmapping` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-30 16:47:39
