/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.5.21 : Database - easyinfo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easyinfo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easyinfo`;

/*Table structure for table `adminlogin` */

DROP TABLE IF EXISTS `adminlogin`;

CREATE TABLE `adminlogin` (
  `tea_id` varchar(255) NOT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `annualreview` */

DROP TABLE IF EXISTS `annualreview`;

CREATE TABLE `annualreview` (
  `ann_rev_id` int(11) NOT NULL AUTO_INCREMENT,
  `ann_rev_year` int(11) NOT NULL,
  `tea_id` varchar(255) NOT NULL,
  `ann_rev_grade` varchar(255) NOT NULL,
  PRIMARY KEY (`ann_rev_id`),
  KEY `FKe1j5wieyfln6lefbjkwcs90i` (`tea_id`),
  KEY `FKqojd9w3p9007ooiet6v659b8u` (`ann_rev_grade`),
  CONSTRAINT `FKqojd9w3p9007ooiet6v659b8u` FOREIGN KEY (`ann_rev_grade`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKe1j5wieyfln6lefbjkwcs90i` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `basedict` */

DROP TABLE IF EXISTS `basedict`;

CREATE TABLE `basedict` (
  `dict_id` varchar(255) NOT NULL,
  `dict_type_code` varchar(255) DEFAULT NULL,
  `dict_type_name` varchar(255) DEFAULT NULL,
  `dict_item_name` varchar(255) DEFAULT NULL,
  `dict_item_code` varchar(255) DEFAULT NULL,
  `dict_sort` int(11) DEFAULT NULL,
  `dict_enable` char(1) DEFAULT NULL,
  `dict_memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `compilemateria` */

DROP TABLE IF EXISTS `compilemateria`;

CREATE TABLE `compilemateria` (
  `cm_id` int(11) NOT NULL AUTO_INCREMENT,
  `cm_rank` varchar(255) DEFAULT NULL,
  `cm_chiefEditor` varchar(255) NOT NULL,
  `cm_subeditor` varchar(255) DEFAULT NULL,
  `cm_name` varchar(255) NOT NULL,
  `cm_edition` varchar(255) DEFAULT NULL,
  `cm_location` varchar(255) NOT NULL,
  `cm_publisher` varchar(255) NOT NULL,
  `cm_scan` varchar(255) DEFAULT NULL,
  `cm_pubTime` date NOT NULL,
  `cm_pageNum` int(11) DEFAULT NULL,
  `cm_bearNum` int(11) DEFAULT NULL,
  `tea_id` varchar(255) NOT NULL,
  PRIMARY KEY (`cm_id`),
  KEY `FKb8re0d81edwc102aq8g7rftts` (`tea_id`),
  CONSTRAINT `FKb8re0d81edwc102aq8g7rftts` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `horizontalresearch` */

DROP TABLE IF EXISTS `horizontalresearch`;

CREATE TABLE `horizontalresearch` (
  `hor_id` int(11) NOT NULL AUTO_INCREMENT,
  `hor_no` varchar(255) NOT NULL,
  `hor_rank` varchar(255) DEFAULT NULL,
  `hor_manager` varchar(255) NOT NULL,
  `hor_personnel` varchar(255) DEFAULT NULL,
  `hor_courseName` varchar(255) NOT NULL,
  `hor_introduction` varchar(255) DEFAULT NULL,
  `hor_cilentName` varchar(255) DEFAULT NULL,
  `hor_scan` varchar(255) DEFAULT NULL,
  `hor_projectTime` date NOT NULL,
  `hor_endTime` date DEFAULT NULL,
  `hor_subjcerCost` double DEFAULT NULL,
  `hor_inplactCost` double DEFAULT NULL,
  `tea_id` varchar(255) NOT NULL,
  PRIMARY KEY (`hor_id`),
  KEY `FKqlq49uog7tcwygn0psqyep3nn` (`tea_id`),
  CONSTRAINT `FKqlq49uog7tcwygn0psqyep3nn` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `instructedstudents` */

DROP TABLE IF EXISTS `instructedstudents`;

CREATE TABLE `instructedstudents` (
  `ins_stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `ins_stu_rank` varchar(255) DEFAULT NULL,
  `ins_stu_teancherOne` varchar(255) NOT NULL,
  `ins_stu_oneUnit` varchar(255) NOT NULL,
  `ins_stu_teacherTwo` varchar(255) DEFAULT NULL,
  `ins_stu_twoUnit` varchar(255) DEFAULT NULL,
  `ins_stu_teacherThree` varchar(255) DEFAULT NULL,
  `ins_stu_threeUnit` varchar(255) DEFAULT NULL,
  `ins_stu_num` varchar(255) NOT NULL,
  `ins_stu_name` varchar(255) NOT NULL,
  `ins_stu_comName` varchar(255) NOT NULL,
  `ins_stu_proName` varchar(255) NOT NULL,
  `ins_stu_others` varchar(255) DEFAULT NULL,
  `ins_stu_organizer` varchar(255) DEFAULT NULL,
  `ins_stu_rewardDetail` varchar(255) DEFAULT NULL,
  `ins_stu_scan` varchar(255) DEFAULT NULL,
  `ins_stu_startTime` date NOT NULL,
  `ins_stu_endTime` date DEFAULT NULL,
  `ins_stu_rewardTime` date DEFAULT NULL,
  `tea_id` varchar(255) NOT NULL,
  `ins_stu_type` varchar(255) NOT NULL,
  `ins_stu_reward` varchar(255) DEFAULT NULL,
  `ins_stu_rewardLevel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ins_stu_id`),
  KEY `FKcv6vpwfr4i1c63nu52vlpy92o` (`tea_id`),
  KEY `FK3s2094lubxm2b3yb62jcfvxvu` (`ins_stu_type`),
  KEY `FKdhvp4fiybedjbmy9rwolypqo2` (`ins_stu_reward`),
  KEY `FK269bpileqbetc24xc0k0baj6d` (`ins_stu_rewardLevel`),
  CONSTRAINT `FK269bpileqbetc24xc0k0baj6d` FOREIGN KEY (`ins_stu_rewardLevel`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK3s2094lubxm2b3yb62jcfvxvu` FOREIGN KEY (`ins_stu_type`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKcv6vpwfr4i1c63nu52vlpy92o` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`),
  CONSTRAINT `FKdhvp4fiybedjbmy9rwolypqo2` FOREIGN KEY (`ins_stu_reward`) REFERENCES `basedict` (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `instructor` */

DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `ins_id` int(11) NOT NULL AUTO_INCREMENT,
  `ins_classes` varchar(255) NOT NULL,
  `ins_startTime` date NOT NULL,
  `ins_endTime` date NOT NULL,
  `tea_id` varchar(255) NOT NULL,
  PRIMARY KEY (`ins_id`),
  KEY `FKtjosesj18545xw2im7br51vrb` (`tea_id`),
  CONSTRAINT `FKtjosesj18545xw2im7br51vrb` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `patent` */

DROP TABLE IF EXISTS `patent`;

CREATE TABLE `patent` (
  `pat_id` int(11) NOT NULL AUTO_INCREMENT,
  `pat_rank` varchar(255) DEFAULT NULL,
  `pat_author` varchar(255) NOT NULL,
  `pat_name` varchar(255) NOT NULL,
  `pat_country` varchar(255) NOT NULL,
  `pat_registerNum` varchar(255) NOT NULL,
  `pat_scan` varchar(255) DEFAULT NULL,
  `pat_pubTime` date NOT NULL,
  `tea_id` varchar(255) NOT NULL,
  `pat_type` varchar(255) NOT NULL,
  PRIMARY KEY (`pat_id`),
  KEY `FK1j1w8erqf43ucf1y7kjhjxapo` (`tea_id`),
  KEY `FKkf8g1fakte0n80yx8khn7sa2p` (`pat_type`),
  CONSTRAINT `FK1j1w8erqf43ucf1y7kjhjxapo` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`),
  CONSTRAINT `FKkf8g1fakte0n80yx8khn7sa2p` FOREIGN KEY (`pat_type`) REFERENCES `basedict` (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `practice` */

DROP TABLE IF EXISTS `practice`;

CREATE TABLE `practice` (
  `pra_id` int(11) NOT NULL AUTO_INCREMENT,
  `pra_post` varchar(255) NOT NULL,
  `pra_project` varchar(255) DEFAULT NULL,
  `pra_content` varchar(255) DEFAULT NULL,
  `pra_scan` varchar(255) DEFAULT NULL,
  `pra_startTime` date NOT NULL,
  `pra_endTime` date DEFAULT NULL,
  `tea_id` varchar(255) NOT NULL,
  PRIMARY KEY (`pra_id`),
  KEY `FKmktups5lxv4iocp5pbyd5dvo5` (`tea_id`),
  CONSTRAINT `FKmktups5lxv4iocp5pbyd5dvo5` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `reward` */

DROP TABLE IF EXISTS `reward`;

CREATE TABLE `reward` (
  `rew_id` int(11) NOT NULL AUTO_INCREMENT,
  `rew_name` varchar(255) NOT NULL,
  `rew_department` varchar(255) NOT NULL,
  `rew_levelDetail` varchar(255) DEFAULT NULL,
  `rew_scan` varchar(255) DEFAULT NULL,
  `rew_time` date NOT NULL,
  `tea_id` varchar(255) NOT NULL,
  `rew_level` varchar(255) NOT NULL,
  `rew_family` varchar(255) NOT NULL,
  `rew_ascription` varchar(255) NOT NULL,
  PRIMARY KEY (`rew_id`),
  KEY `FKpqcjgquq8bh70r4h91mj9593t` (`tea_id`),
  KEY `FK27q9sbxurvtk28qwwcthrf92i` (`rew_level`),
  KEY `FKoi5yi2npggsowlcjxagtosakh` (`rew_family`),
  KEY `FKam2k0gquqef4uqc3qmbb4xchc` (`rew_ascription`),
  CONSTRAINT `FKam2k0gquqef4uqc3qmbb4xchc` FOREIGN KEY (`rew_ascription`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK27q9sbxurvtk28qwwcthrf92i` FOREIGN KEY (`rew_level`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKoi5yi2npggsowlcjxagtosakh` FOREIGN KEY (`rew_family`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKpqcjgquq8bh70r4h91mj9593t` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tea_id` varchar(255) NOT NULL,
  `tea_name` varchar(255) DEFAULT NULL,
  `tea_identityId` varchar(255) DEFAULT NULL,
  `tea_home` varchar(255) DEFAULT NULL,
  `tea_phone` varchar(255) DEFAULT NULL,
  `tea_qq` varchar(255) DEFAULT NULL,
  `tea_weChat` varchar(255) DEFAULT NULL,
  `tea_email` varchar(255) DEFAULT NULL,
  `tea_birthday` date DEFAULT NULL,
  `tea_workDate` date DEFAULT NULL,
  `tea_gender` varchar(255) DEFAULT NULL,
  `tea_nation` varchar(255) DEFAULT NULL,
  `tea_political` varchar(255) DEFAULT NULL,
  `tea_jobTitel` varchar(255) DEFAULT NULL,
  `tea_eduBG` varchar(255) DEFAULT NULL,
  `tea_degree` varchar(255) DEFAULT NULL,
  `tea_role` varchar(255) NOT NULL,
  `tea_dep` varchar(255) DEFAULT NULL,
  `tea_enable` varchar(255) NOT NULL,
  `tea_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tea_id`),
  KEY `FKhm5b6pqjjl042mcygi9frsh3` (`tea_gender`),
  KEY `FKe9qekkq7usydud5plqwy07rj3` (`tea_nation`),
  KEY `FKnum25vb6ortk7umcnpyrtm1xy` (`tea_political`),
  KEY `FK2jblarkquje10owieugaveyop` (`tea_jobTitel`),
  KEY `FK80sjmwbpcel2wwrbo6dkg9btx` (`tea_eduBG`),
  KEY `FKkb1x2hb2r6ipl69kee9mn83vv` (`tea_degree`),
  KEY `FK9ns4t74b94jeiop3v36futtr0` (`tea_role`),
  KEY `FK5fm9f4x84tr7nmkk6dlfvdsc7` (`tea_dep`),
  KEY `FK3viuxr3si6tn99067xdqaq5v7` (`tea_enable`),
  CONSTRAINT `FK2jblarkquje10owieugaveyop` FOREIGN KEY (`tea_jobTitel`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK3viuxr3si6tn99067xdqaq5v7` FOREIGN KEY (`tea_enable`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK5fm9f4x84tr7nmkk6dlfvdsc7` FOREIGN KEY (`tea_dep`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK80sjmwbpcel2wwrbo6dkg9btx` FOREIGN KEY (`tea_eduBG`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK9ns4t74b94jeiop3v36futtr0` FOREIGN KEY (`tea_role`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKe9qekkq7usydud5plqwy07rj3` FOREIGN KEY (`tea_nation`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKhm5b6pqjjl042mcygi9frsh3` FOREIGN KEY (`tea_gender`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKkb1x2hb2r6ipl69kee9mn83vv` FOREIGN KEY (`tea_degree`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKnum25vb6ortk7umcnpyrtm1xy` FOREIGN KEY (`tea_political`) REFERENCES `basedict` (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `teachingevaluation` */

DROP TABLE IF EXISTS `teachingevaluation`;

CREATE TABLE `teachingevaluation` (
  `tea_eva_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_eva_year` date NOT NULL,
  `tea_id` varchar(255) NOT NULL,
  `tea_eva_grade` varchar(255) NOT NULL,
  PRIMARY KEY (`tea_eva_id`),
  KEY `FK7meyemtlklr8rhkjc3hdixm` (`tea_id`),
  KEY `FK2c7p4ia6xs92998dvehp8dn1e` (`tea_eva_grade`),
  CONSTRAINT `FK2c7p4ia6xs92998dvehp8dn1e` FOREIGN KEY (`tea_eva_grade`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK7meyemtlklr8rhkjc3hdixm` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `thesis` */

DROP TABLE IF EXISTS `thesis`;

CREATE TABLE `thesis` (
  `the_id` int(11) NOT NULL AUTO_INCREMENT,
  `the_startNum` int(11) DEFAULT NULL,
  `the_endNum` int(11) DEFAULT NULL,
  `the_wordNum` double DEFAULT NULL,
  `the_rank` varchar(255) DEFAULT NULL,
  `the_firstAuthor` varchar(255) NOT NULL,
  `the_otherAuthor` varchar(255) DEFAULT NULL,
  `the_title` varchar(255) NOT NULL,
  `the_periodical` varchar(255) DEFAULT NULL,
  `the_reelNum` varchar(255) DEFAULT NULL,
  `the_issue` varchar(255) DEFAULT NULL,
  `the_scan` varchar(255) DEFAULT NULL,
  `the_pubTime` date DEFAULT NULL,
  `tea_id` varchar(255) NOT NULL,
  `the_level` varchar(255) NOT NULL,
  PRIMARY KEY (`the_id`),
  KEY `FKsvn8j1maxbpsknus9y9pxmapi` (`tea_id`),
  KEY `FK3r57y0qwqi7p3r83sx9hnef89` (`the_level`),
  CONSTRAINT `FK3r57y0qwqi7p3r83sx9hnef89` FOREIGN KEY (`the_level`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKsvn8j1maxbpsknus9y9pxmapi` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `train` */

DROP TABLE IF EXISTS `train`;

CREATE TABLE `train` (
  `tra_id` int(11) NOT NULL AUTO_INCREMENT,
  `tra_address` varchar(255) DEFAULT NULL,
  `tra_theme` varchar(255) DEFAULT NULL,
  `tra_content` varchar(255) DEFAULT NULL,
  `tra_scan` varchar(255) DEFAULT NULL,
  `tra_startTime` date NOT NULL,
  `tra_endTime` date DEFAULT NULL,
  `tea_id` varchar(255) NOT NULL,
  `tra_result` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tra_id`),
  KEY `FK6e4dmekc1kh73xnhf8uaavuw0` (`tea_id`),
  KEY `FK154xscdr5qufhhtfahrtuirdq` (`tra_result`),
  CONSTRAINT `FK154xscdr5qufhhtfahrtuirdq` FOREIGN KEY (`tra_result`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK6e4dmekc1kh73xnhf8uaavuw0` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `tea_id` varchar(255) NOT NULL,
  `password` varchar(4) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tea_id`),
  KEY `FKeqkrbx6e09vc257arvvrysb9p` (`state`),
  KEY `FK8e80qs6bx8v8ceho2fm4r8s6r` (`role`),
  CONSTRAINT `FK8e80qs6bx8v8ceho2fm4r8s6r` FOREIGN KEY (`role`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKeqkrbx6e09vc257arvvrysb9p` FOREIGN KEY (`state`) REFERENCES `basedict` (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `userlogin` */

DROP TABLE IF EXISTS `userlogin`;

CREATE TABLE `userlogin` (
  `tea_id` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_state` varchar(255) NOT NULL,
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `verticalresearch` */

DROP TABLE IF EXISTS `verticalresearch`;

CREATE TABLE `verticalresearch` (
  `ver_id` int(11) NOT NULL AUTO_INCREMENT,
  `ver_no` varchar(255) NOT NULL,
  `ver_rank` varchar(255) DEFAULT NULL,
  `ver_manager` varchar(255) NOT NULL,
  `ver_personnel` varchar(255) DEFAULT NULL,
  `ver_courseName` varchar(255) NOT NULL,
  `ver_introduction` varchar(255) DEFAULT NULL,
  `ver_projectUnit` varchar(255) NOT NULL,
  `ver_identCon` varchar(255) DEFAULT NULL,
  `ver_scan` varchar(255) DEFAULT NULL,
  `ver_projectTime` date NOT NULL,
  `ver_endTime` date DEFAULT NULL,
  `ver_identTime` date DEFAULT NULL,
  `tea_id` varchar(255) NOT NULL,
  `ver_nature` varchar(255) NOT NULL,
  `ver_projectLevel` varchar(255) NOT NULL,
  `ver_identLevel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ver_id`),
  KEY `FKjt3919vowox4y9rkhjx20vsq3` (`tea_id`),
  KEY `FKco0s8s5m673hxu8pb996aurlp` (`ver_nature`),
  KEY `FKtbp5va9xou8xhskavr5fbjfrt` (`ver_projectLevel`),
  KEY `FKkardgnlj8ogmevuksvcrmdatg` (`ver_identLevel`),
  CONSTRAINT `FKkardgnlj8ogmevuksvcrmdatg` FOREIGN KEY (`ver_identLevel`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKco0s8s5m673hxu8pb996aurlp` FOREIGN KEY (`ver_nature`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKjt3919vowox4y9rkhjx20vsq3` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`),
  CONSTRAINT `FKtbp5va9xou8xhskavr5fbjfrt` FOREIGN KEY (`ver_projectLevel`) REFERENCES `basedict` (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
