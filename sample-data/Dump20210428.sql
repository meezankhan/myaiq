-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: portal_setup
-- ------------------------------------------------------
-- Server version	8.0.23

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homepagemaster`
--

LOCK TABLES `homepagemaster` WRITE;
/*!40000 ALTER TABLE `homepagemaster` DISABLE KEYS */;
INSERT INTO `homepagemaster` VALUES 
(1,'Test CAL','Test CG','TestProject','Test Lead','Test DU','test innovation lead','Test Market Unit',29,1),
(4,'Test CAL1','Test CG1','Test Project1','Test Lead 1','Test DU1',NULL,'test MU 1',33,1),
(5,'Test CAL 1','Test CG2','Test Project1','Test Lead 2','Test DU2',NULL,'Test MU1',33,1);
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
  PRIMARY KEY (`id`),
  KEY `surveyidfk_ip_idx` (`surveyid`),
  CONSTRAINT `surveyidfk_ip` FOREIGN KEY (`surveyid`) REFERENCES `surveymaster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `innovationparammaster`
--

LOCK TABLES `innovationparammaster` WRITE;
/*!40000 ALTER TABLE `innovationparammaster` DISABLE KEYS */;
INSERT INTO `innovationparammaster` VALUES 
(1,'Understand Client Challenges and Objectives',1,1),
(2,'Innovation Capabilities within engagement',2,1),
(3,'Client Co Innovation Framework',3,1),
(4,'Degree of Innovation',4,1),
(5,'Client Value',5,1),
(6,'Client Testimonials (Audio & Video)',6,1),
(7,'Leverage Accenture Innovation Architecture',7,1),
(8,'Contribution to Accenture Innovation Architecture',8,1);/*!40000 ALTER TABLE `innovationparammaster` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `innovationparamscoremaster`
--

LOCK TABLES `innovationparamscoremaster` WRITE;
/*!40000 ALTER TABLE `innovationparamscoremaster` DISABLE KEYS */;
INSERT INTO `innovationparamscoremaster` VALUES 
(1,1,'NOVICE',3.75,0),
(2,1,'BEGINNER',7.5,3.75),
(3,1,'PRACTITIONER',11.25,7.5),
(4,1,'LEADER',99999,11.25),
(5,2,'NOVICE',3,0),
(6,2,'BEGINNER',6,3),
(7,2,'PRACTITIONER',9,6),
(8,2,'LEADER',99999,9),
(9,3,'NOVICE',3.75,0),
(10,3,'BEGINNER',7.5,3.75),
(11,3,'PRACTITIONER',11.25,7.5),
(12,3,'LEADER',99999,11.25),
(13,4,'LEADER',99999,6.75),
(14,5,'LEADER',99999,11.25),
(15,5,'PRACTITIONER',11.25,7.5),
(16,5,'BEGINNER',7.5,3.75),
(17,5,'NOVICE',3.75,0),
(18,4,'PRACTITIONER',6.75,4.5),
(19,4,'BEGINNER',4.5,2.25),
(20,4,'NOVICE',2.25,0),
(21,6,'NOVICE',3,0),
(22,6,'BEGINNER',6,3),
(23,6,'PRACTITIONER',9,6),
(24,6,'LEADER',99999,9),
(25,7,'NOVICE',3,0),
(26,7,'BEGINNER',6,3),
(27,7,'PRACTITIONER',9,6),
(28,7,'LEADER',99999,9),
(29,8,'NOVICE',2.25,0),
(30,8,'BEGINNER',4.5,2.25),
(31,8,'PRACTITIONER',6.75,4.25),
(32,8,'LEADER',99999,6.75);
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
INSERT INTO `optionsmaster` VALUES
(1,'Please Select',1,1,1,0),
(2,'No, I haven\'t discussed any innovation program with client at this point in time',0,2,1,0),
(3,'Yes, the discussion has come in few meetings where Accenture capabilities in driving innovation were mentioned but hasn?t progressed thereafter',0,3,1,1),
(4,'Yes, I have regular connects with clients talking on innovation program and objectives within the account',0,4,1,2),
(5,'Yes, I have strategic level connects with senior stakeholders where innovation is a key contributor to business bottomline and brand value where also Accenture is a key partner in driving growth of business',0,5,1,3),
(6,'Please Select',1,1,2,0),
(7,'Not particularly other than the line of business Accenture is contracted to work and deliver',0,2,2,0),
(8,'Yes we are aware, but we don?t necessarily talk about it as we are not driven by contractual obligations to delve into other sides of business',0,3,2,1),
(9,'Yes, we are aware about the client business challenges and they are being discussed at project deliverable connects with business stakeholders',0,4,2,2),
(10,'Yes, client business challenges are discussed at CXO levels with ATCI and do constitute a strategic lever for Accenture to develop/sustain business relationship in the future',0,5,2,3),
(11,'Please Select',1,1,3,0),
(12,'No, I am not privy to client business objectives',0,2,3,0),
(13,'Yes, I am aware of client business objectives ',0,3,3,1),
(14,'Yes, I am shared with client business objectives and interact with only those business units closer to our contractual deliverables to discuss their challenges and offer solutions',0,4,3,2),
(15,'Yes, I am shared client business objectives by business CXOs and am in a strategic partnership with the business units to help attaining results on the client objectives',0,5,3,3),
(16,'Please Select',1,1,4,0),
(17,'No, I am not aware of long-term and short-term strategic goals of my client',0,2,4,0),
(18,'Yes, I am aware of the long term and short term goals of our client but are aligned through contracted deliverables with our client',0,3,4,1),
(19,'Yes, I am aware of the strategic goals and we have discussions with business counterparts where we can source work to align deliverables with the goals',0,4,4,2),
(20,'Yes, I am aligned with the client\'s strategic goals and my pipeline of work is being shaped and defined by these strategic business goals',0,5,4,3),
(21,'Please Select',1,1,5,0),
(22,'No, as my resources are only aligned with current technologies and tech platforms mandated by the contractual deliverables',0,2,5,0),
(23,'No, as my resource strategy is primarily driven for delivering exisiting technology solutions contracted by client and would require new workforce onboarding for niche solutions thereby adding a possibility of sourcing delay',0,3,5,1),
(24,'Yes, I can deliver new solutions and technologies with my current workforce as I have strategically upgraded knowledge of key resources to start working on new technology solutions albeit a few',0,4,5,2),
(25,'Yes, I have strategically resourced my project to deliver new technologies and solutions to clients considering current work and future pipeline of assignments',0,5,5,3),
(26,'Please Select',1,1,6,0),
(27,'Employees across all levels are not aware of any innovation initiative within account',0,2,6,0),
(28,'Employees across all levels are aware of innovation program in the account',0,3,6,1),
(29,'Employees across all levels are aware and capable of new ideas and are driven to work on new ideas',0,4,6,2),
(30,'Employees across all levels are driven to work for innovation across the project deliverables where new pipeline of work is defined based on innovative ideas pertaining to client business challenges and strategic goals',0,5,6,3),
(31,'Please Select',1,1,7,0),
(32,'Not much participation across levels in innovation program / initiatives across either ATCI or account',0,2,7,0),
(33,'Offshore senior resources and delivery managers are aligned to business challenges and objectives',0,3,7,1),
(34,'Offshore senior resources and managers are aligned and have connect sessions to discuss objectives and goals with the wider team',0,4,7,2),
(35,'Regular connect sessions with clients to discuss business strategic goals and objectives wherein assignments are aligned to deliver solutions towards those objectives primarily driven by ATCI resources both at offshore and onshore',0,5,7,3),
(36,'Please Select',1,1,8,0),
(37,'Technology scope is only defined by contractual deliverables',0,2,8,0),
(38,'We have discussion forums on new technologies and innovations but we don?t actively pursue those as not defined in the contract',0,3,8,1),
(39,'We propose solutions based on the scope of current work and the scope of new technologies and innovations is define by that scope of work only',0,4,8,2),
(40,'Ideas and solutions are ideated, discussed and designed using the latest SMAC technologies wherein strategic partnerships have been defined with vendors to deliver world class solutions based on latest technologies',0,5,8,3),
(41,'Please Select',1,1,9,0),
(42,'Trainings are only deliverables perspective and technology in scope of contractual delivery',0,2,9,0),
(43,'The resources participate as and when the trainings are announced.',0,3,9,1),
(44,'We have a training tracker tracking resources attending various bootcamps and technology trainings',0,4,9,2),
(45,'We have a training framework in place where resources are not only sent to targeted technology trainings and bootcamps but also we arrange for trainings whenever necessary to train resources on latest technologies for project deliverables',0,5,9,3),
(46,'Please Select',1,1,10,0),
(47,'No, I don?t have any space designed like such.',0,2,10,0),
(48,'Yes, I make use of meeting rooms and office spaces for design discussions',0,3,10,1),
(49,'Yes, I have a design space built within the project space for design thinking discussions',0,4,10,2),
(50,'Yes, I have DT sessions planned on regular intervals making use of DT spaces within Accenture premises.',0,5,10,3),
(51,'Please Select',1,1,11,0),
(52,'No, I don?t have any co-innovation framework defined',0,2,11,0),
(53,'No, I don?t have but am working on it and have planned for the near future',0,3,11,1),
(54,'Yes, but I have an adhoc framework with limited sponsorship as of now',0,4,11,2),
(55,'Yes, I have a proven innovation framework in place wherein I have joint innovation councils with the client discussing on new innovations and ideas generated in the project',0,5,11,3),
(56,'Please Select',1,1,12,0),
(57,'No, I don?t have any co-innovation roadmap defined and not foreseen in near future',1,2,12,0),
(58,'No, I don?t have but am working on it to define in the near future',0,3,12,1),
(59,'Yes, but I have an adhoc roadmap with limited sponsorship as of now',0,4,12,2),
(60,'Yes, I have a proven innovation roadmap in place wherein the business areas to focus on innovation are clearly defined and have the right business sponsorship in place',0,5,12,3),
(61,'Please Select',1,1,13,0),
(62,'No, we don?t conduct any co-innovation workshops with or without client in my account',0,2,13,0),
(63,'No, I haven\'t conducted any workshops directly with client yet',0,3,1,13),
(64,'Yes, I have the co-innovation framework in place but is driven primarily by Accenture with low level participation from client',0,4,13,2),
(65,'Yes, I have a well proven co-innovation framework in place with frequent workshops with clients to discuss innovative ideas and business challenges',0,5,13,3),
(66,'Please Select',1,1,14,0),
(67,'No, account does not conduct any co-innovation workshops within project at onshore or offshore with ATCI resource participation',0,2,14,0),
(68,'No, we do not conduct any co-innovation workshops at offshore though there are few discussions that do happen at onshore with ATCI participation.',0,3,14,1),
(69,'Yes, we have internal teams participating in adhoc workshops conducted within project both at onshore and offshore locations with ATCI resource participation',0,4,14,2),
(70,'Yes, we have a well proven co-innovation framework wherein regular connects and discussions take place within projects both at onshore and offshore and across and the outcomes are discussed in innovation councils with business',0,5,14,3),
(71,'Please Select',1,1,15,0),
(72,'No, we are focused on contractual deliverables at this point in time and haven\'t thought on CI or incremental innovation as of yet',0,2,15,0),
(73,'Yes, we have continuous improvement driven outcomes within projects which are being shared and discussed with clients regularly',0,3,15,1),
(74,'Yes, we have small process level incremental innovation within projects based on the current understanding of the business objectives at large along with the CI driven outcomes',0,4,15,2),
(75,'Yes, we have not only CI driven outcomes but differential and unconventional approach to innovation resulting in significant gains to client',0,5,15,3),
(76,'Please Select',1,1,16,0),
(77,'No, not heard of breakthrough innovation at all',0,2,16,0),
(78,'No, we don?t have any breakthrough innovation to mention yet but only CI driven initiatives',0,3,16,1),
(79,'No, our innovations are designed to address current business problems which are more step innovation and CI driven initiatives',0,4,16,2),
(80,'Yes, we have demonstrated breakthrough innovation through unconventional / out-of-box thinking resulting in strategic outcomes for the benefit of the client',0,5,16,3),
(81,'Please Select',1,1,17,0),
(82,'No, not heard of transformational innovation at all',0,2,17,0),
(83,'No, we have not seen any transformational innovation yet',0,3,17,1),
(84,'No, our innovations are designed to address current business problems which are more step innovation or CI driven initiatives',0,4,17,2),
(85,'Yes, we have demonstrated transformational innovation through unconventional / out-of-box thinking resulting in strategic outcomes for the benefit of the client',0,5,17,3),
(86,'Please Select',1,1,18,0),
(87,'No, we don?t have any new technologies other than what is prescribed by contract',0,2,18,0),
(88,'No, innovation approach is defined by client needs and are mostly looking to improve BAU legacy technologies',0,3,18,1),
(89,'Yes, to a small level where technologies are defined by scope of new work being done on newer technologies',0,4,18,2),
(90,'Yes, strong partnership with vendors and Accenture Labs etc. to bring latest SMAC/ digital technologies in the scope of work',0,5,18,3),
(91,'Please Select',1,1,19,0),
(92,'No, we don?t co-innovate with our client yet',0,2,19,0),
(93,'No, we don?t have any co-innovation nomination',0,3,19,1),
(94,'Yes, we have demonstrated co-innovation ideas in IG level forums',0,4,19,2),
(95,'Yes, we have demonstrated co-innovation ideas across IG level forums in ATCI driven co-innovation competitions.',0,5,19,3),
(96,'Please Select',1,1,20,0),
(97,'No involvement of client yet',0,2,20,0),
(98,'Individual business leads',0,3,20,1),
(99,'LoB executive sponsors',0,4,20,2),
(100,'CXO level participation and sponsorship in innovation initiatives',0,5,20,3),
(101,'Please Select',1,1,21,0),
(102,'We have not discussed any high impact ideas with client yet',0,2,21,0),
(103,'No, we don?t have any high impact ideas suggested to client but are mostly CI driven outcomes',0,3,21,1),
(104,'Significant business benefits to client with value realized will be at least $5M-10M per year',0,4,21,2),
(105,'Very significant business benefits to client with value realized will be at least >$10M per year',0,5,21,3),
(106,'Please Select',1,1,22,0),
(107,'Business benefits realized will be less than $1M per year',0,2,22,0),
(108,'Business benefits realized less than $1M-$4.9M value per year',0,3,22,1),
(109,'Business benefits realized will be at least $5M-10M per year',0,4,22,2),
(110,'Business benefits realized will be at least >$10M per year',0,5,22,3),
(111,'Please Select',1,1,23,0),
(112,'No we don?t have a program to define any co-innovation stories',0,2,23,0),
(113,'No client testimonials on innovation driven outcomes',0,3,23,1),
(114,'Yes, but they are not developed to share on the innovation platform',0,4,23,2),
(115,'Yes, we have consistent few co-innovation stories which are used as references in Accenture discussions across IGs on innovation',0,5,23,3),
(116,'Please Select',1,1,24,0),
(117,'No client co-innovation program',0,2,24,0),
(118,'No involvement with client stakeholders yet',0,3,24,1),
(119,'Mid level Management',0,4,24,2),
(120,'LOB leads and CXO endorsements',0,5,24,3),
(121,'Please Select',1,1,25,0),
(122,'No client co-innovation program',0,2,25,0),
(123,'No client testimonials on innovation driven outcomes',0,3,25,1),
(124,'Yes, mid level management endorsements and testimonials',0,4,25,2),
(125,'Yes, CXO level management endorsements and testimonials',0,5,25,3),
(126,'Please Select',1,1,26,0),
(127,'No client co-innovation program',0,2,26,0),
(128,'No, we cant use any client reference',0,3,26,1),
(129,'Yes, but need client approvals',0,4,26,2),
(130,'Yes, client want to share success stories across platforms / Media savvy clients',0,5,26,3),
(131,'Please Select',1,1,27,0),
(132,'No, we don?t involve Accenture Innovation ecosystem yet',0,2,27,0),
(133,'Yes, Some form of collaboration exists with Accenture Labs/Studio, mostly for reference purposes, for developing rudimentary innovation tools.',0,3,27,1),
(134,'Yes, Enhanced level of involvement exists with Accenture Studio/Lab. However, there have been few Innovation outcomes driven collaboratively between Accenture Labs/Studios and projects .',0,4,27,2),
(135,'Yes, A very high level of involvement with Accenture Studio /Labs. There exists an extensive use of innovation tool, that has resulted in a strategic partnership with Accenture Labs/Studio. Delivery and innovation outcomes are jointly funded by client',0,5,27,3),
(136,'Please Select',1,1,28,0),
(137,'We don?t have opportunities to leverage industry assets yet',0,2,28,0),
(138,'Accenture Studio and Accenture Labs solutions have not been used to suggest possible solutions to the client problem statements.',0,3,28,1),
(139,'Accenture Studio and Accenture Labs solutions have been used to suggest possible solutions to the client problem statements, However, these suggestions include the use of rudimentary innovation tools only.',0,4,28,2),
(140,'Accenture Studio and Accenture Labs solutions have been used to suggest possible solutions to the client problem statements, There is an extensive use of innovation tools, provided by Accenture Studio/Labs, to suggest solutions to client problems.',0,5,28,3),
(141,'Please Select',1,1,29,0),
(142,'No, its not in agenda at all',0,2,29,0),
(143,'Yes, Innovation Hub visits are in agenda but not mandatory',0,3,29,1),
(144,'Yes, Innovation Hub / Studio visits are planned occasionally for client visits. However, not for all client visits.',0,4,29,2),
(145,'Yes, All client visits include a session at the Innovation Hub.',0,5,29,3),
(146,'Please Select',1,1,30,0),
(147,'No, we don?t discuss any such assets with client',0,2,30,0),
(148,'No, Accenture Studio / Lab assets are mentioned but not mandatory to showcase any such assets',0,3,30,1),
(149,'Yes, Accenture Studio / Lab assets are showcased to clients. However, not extensively ',0,4,30,2),
(150,'Yes, Accenture Studio / Lab assets are extensively showcased to clients.',0,5,30,3),
(151,'Please Select',1,1,31,0),
(152,'No, we don?t have that in agenda',0,2,31,0),
(153,'No, we have a plan to showcase but not working towards and don?t have a timeline',0,3,31,1),
(154,'Yes, Few stories, using basic level of Automation, planned in the near future and is in roadmap for this year',0,4,31,2),
(155,'Yes, High Impact Story boards have been showcased at the Accenture Innovation Hub. These stories have a high degree of re-usability across industries and have resulted in co-partnerships with client to increase sales and business development.',0,5,31,3),
(156,'Please Select',1,1,32,0),
(157,'No, we don?t have that in agenda',0,2,32,0),
(158,'Yes, Few stories have been created in collaboration with Accenture Innovation Hub/Accenture Studio using basic levels of Automation for client business benefit.',0,3,32,1),
(159,'Yes, High Impact Story board have been created with Accenture Innovation hub/Accenture Studio,  to realize business benefits ($5M-10M per year);',0,4,32,2),
(160,'Yes, Very High Impact Story board have been created with Accenture Innovation hub/Accenture Studio, to realize business benefits (>$10M per year);Re-usability across various industry sectors - Very High.Co-partnerships created with client for future sales and business development',0,5,32,3),
(161,'Please Select',1,1,33,0),
(162,'No, we don?t have that in agenda',0,2,33,0),
(163,'No, Client Assets have not been showcased to the Accenture Innovation Hub/ Accenture Studio yet',0,3,33,1),
(164,'Yes, Few client assets have been showcased (or planned to showcase in the near future) to the Accenture Innovation Hub / Accenture Studio. These assets do not have cross industry re-usability, however can be re-used in the same industry.',0,4,33,2),
(165,'Yes, Very High Impact client assets have been showcased to the Accenture Innovation Hub/ Accenture Studio. These assets have cross industry re-usability.',0,5,33,3);
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
INSERT INTO `questionairemaster` VALUES (1,1,1,'Do you have discussed innovation program in the account with your client?'),
(2,1,2,'Do you understand your client business challenges?'),
(3,1,3,'Have you been shared with business objectives of your client partners?'),
(4,1,4,'Are you aware of long term and short term strategic goals of your client?'),
(5,1,5,'Is your project aligned to deliver business value to the client?'),
(6,2,1,'What is the level of employee engagement in innovation within your project?'),
(7,2,2,'What has been the diversity of view, voice and experience of participation?'),
(8,2,3,'What is the scope of new technology used for ideation?'),
(9,2,4,'What is the level of participation in innovation bootcamps and new technology trainings?'),
(10,2,5,'Do you have infrastructure within engagement on innovative thinking?'),
(11,3,1,'Do you have co-innovation framework in place?'),
(12,3,2,'Do you have co-innovation roadmap defined?'),
(13,3,3,'Do you conduct co-innovation workshops with client?'),
(14,3,4,'Do you conduct co-innovation workshops within project?'),
(15,4,1,'What do you think you do- continuous improvement or incremental innovation?'),
(16,4,2,'Do you have any cases that you can quote as breakthrough innovation? '),
(17,4,3,'Do you have any transformational innovation?'),
(18,5,1,'Do you have any technology innovation using new technologies?'),
(19,5,2,'Do you have a co-innovation nomination?'),
(20,5,3,'What is the stakeholder involvement level in innovation program?'),
(21,5,4,'What are the high impact ideas to the client?'),
(22,5,5,'What are the business benefits enabled and realized in $ value w.r.t innovation?'),
(23,6,1,'Do you have any co-innovation stories ?'),
(24,6,2,'What is the stakeholder level for client testimonial ?'),
(25,6,3,'Do you have any video and/or audio testimonials?'),
(26,6,4,'Can we reference your client for innovation?'),
(27,7,1,'Do you involve Accenture Studio / Accenture Labs / Ecosystem partners to solve client problems?'),
(28,7,2,'How do you demonstrate leveraging industry assets?'),
(29,7,3,'Do you plan for Innovation Hub visits during client visits?'),
(30,7,4,'Do you remote showcase Accenture Studio / Lab assets to your clients?'),
(31,8,1,'Do you plan account showcases at Accenture Innovation Hub?'),
(32,8,2,'Do you collaborate with Accenture Innovation Hub / Accenture Studio for client innovation framework / architecture?'),
(33,8,3,'Do you showcase client assets to Accenture Innovation Hub/ Accenture Studio?');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `maxscore` float NOT NULL,
  `maxrating` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveymaster`
--

LOCK TABLES `surveymaster` WRITE;
/*!40000 ALTER TABLE `surveymaster` DISABLE KEYS */;
INSERT INTO `surveymaster` VALUES (1,9,100,'Innovation Questionaire',1.0);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveyresult`
--

LOCK TABLES `surveyresult` WRITE;
/*!40000 ALTER TABLE `surveyresult` DISABLE KEYS */;
INSERT INTO surveyresult VALUES(1,'Test CAL','Test CG','TestProject','2021-04-22 00:00:00','Test Lead','Test DU','test innovation lead','Test Market Unit',29,37,'SUBMITTED','2021-04-22 00:00:00',1,1),
(2,'Test CAL','Test CG','TestProject','2021-04-22 00:00:00','Test Lead','Test DU','test innovation lead','Test Market Unit',29,0,'IN PROGRESS',NULL,1,1),
(3,'Test CAL 2','Test CG 2','Test Project 2','2021-04-22 00:00:00','lead','Test DU','IR','Test Market Unit',30,0,'IN PROGRESS',NULL,1,1),                        
(5,'dummy CAL','Test CG 2','Test Project 3','2021-04-23 00:00:00','lead','Test DU','lead','Test Market Unit',31,45,'SUBMITTED','2021-04-23 00:00:00',1,2),
(6,'cal','test','cn','2021-04-23 00:00:00','dmd','test','il','Test_MU_2',32,0,'IN PROGRESS',NULL,1,2),
(9,'CAL 001','CG 001','Test Project 3','2021-04-28 13:15:14','DMD 001','DU 001','IL 001','MU 001',31,0,'IN PROGRESS','2021-04-28 13:18:58',1,1);

/*!40000 ALTER TABLE `surveyresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveyresultscore`
--

DROP TABLE IF EXISTS `surveyresultscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveyresultscore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surveyresultid` int NOT NULL,
  `scoreparamid` int NOT NULL,
  `scoreparamtype` varchar(100) NOT NULL,
  `score` int DEFAULT '0',
  `comments` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `surveyresultfk_idx` (`surveyresultid`),
  CONSTRAINT `surveyresultfk` FOREIGN KEY (`surveyresultid`) REFERENCES `surveyresult` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveyresultscore`
--

LOCK TABLES `surveyresultscore` WRITE;
/*!40000 ALTER TABLE `surveyresultscore` DISABLE KEYS */;
INSERT INTO `surveyresultscore` VALUES (9,' comments 001',0,2,'O',9),
(10,' comments 001-1',3,3,'O',9),
(11,NULL,0,1,'I',9),
(12,NULL,4,2,'I',9),
(13,' comments 001-1-2',1,4,'O',9);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveyresultscoremaster`
--

LOCK TABLES `surveyresultscoremaster` WRITE;
/*!40000 ALTER TABLE `surveyresultscoremaster` DISABLE KEYS */;
INSERT INTO `surveyresultscoremaster` VALUES (2,'NOVICE',2.99,0,1),
(3,'BEGINNER',4.99,2.99,1),(4,'PRACTITIONER',6.99,4.99,1),(5,'LEADER',9.99,6.99,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,1,'','User','testUser1@test.com'),(2,1,'Test Market Unit','MU Lead','testUser2@test.com'),(3,1,'ALL','Super Admin','testUser3@test.com'),(4,1,NULL,'User','testUser4@test.com');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userprojectmapping`
--

LOCK TABLES `userprojectmapping` WRITE;
/*!40000 ALTER TABLE `userprojectmapping` DISABLE KEYS */;
INSERT INTO `userprojectmapping` VALUES (1,29,1),(2,30,1),(3,31,2),(4,33,4);
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

-- Dump completed on 2021-04-23 17:52:12
