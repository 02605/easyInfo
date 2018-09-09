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

/*Data for the table `basedict` */

insert  into `basedict`(`dict_id`,`dict_type_code`,`dict_type_name`,`dict_item_name`,`dict_item_code`,`dict_sort`,`dict_enable`,`dict_memo`) values 
('1','001','性别','男',NULL,1,'1',NULL),
('10','003','职称','副教授',NULL,3,'1',NULL),
('11','003','职称','教授',NULL,4,'1',NULL),
('12','004','学位','学士',NULL,1,'1',NULL),
('13','004','学位','硕士',NULL,2,'1',NULL),
('14','004','学位','博士',NULL,3,'1',NULL),
('15','005','学历','博士生毕业',NULL,4,'1',NULL),
('16','005','学历','博士生结业',NULL,5,'1',NULL),
('17','005','学历','博士生肄业',NULL,6,'1',NULL),
('18','005','学历','硕士生毕业',NULL,7,'1',NULL),
('19','005','学历','硕士生结业',NULL,8,'1',NULL),
('2','001','性别','女',NULL,2,'1',NULL),
('20','005','学历','硕士生肄业',NULL,9,'1',NULL),
('21','005','学历','本科生毕业',NULL,10,'1',NULL),
('22','005','学历','本科生结业',NULL,11,'1',NULL),
('23','005','学历','本科生肄业',NULL,12,'1',NULL),
('24','005','学历','专科生毕业',NULL,13,'1',NULL),
('25','005','学历','专科生结业',NULL,14,'1',NULL),
('26','005','学历','专科生肄业',NULL,15,'1',NULL),
('27','005','学历','研修班毕业',NULL,16,'1',NULL),
('28','005','学历','双学位毕业',NULL,17,'1',NULL),
('29','006','民族','汉族',NULL,NULL,'1',NULL),
('3','002','所属院系','机电工程学院',NULL,1,'1',NULL),
('30','006','民族','少数民族',NULL,NULL,'1',NULL),
('31','007','政治面貌','中共党员',NULL,NULL,'1',NULL),
('32','007','政治面貌','中共预备党员',NULL,NULL,'1',NULL),
('33','007','政治面貌','共青团员',NULL,NULL,'1',NULL),
('34','007','政治面貌','民革党员',NULL,NULL,'1',NULL),
('35','007','政治面貌','民盟盟员',NULL,NULL,'1',NULL),
('36','007','政治面貌','民建会员',NULL,NULL,'1',NULL),
('37','007','政治面貌','民进会员',NULL,NULL,'1',NULL),
('38','007','政治面貌','农工党党员',NULL,NULL,'1',NULL),
('39','007','政治面貌','致公党党员',NULL,NULL,'1',NULL),
('4','002','所属院系','电子与控制学院',NULL,2,'1',NULL),
('40','007','政治面貌','九三学社社员',NULL,NULL,'1',NULL),
('41','007','政治面貌','台盟盟员',NULL,NULL,'1',NULL),
('42','007','政治面貌','无党派人士',NULL,NULL,'1',NULL),
('43','007','政治面貌','群众',NULL,NULL,'1',NULL),
('44','008','论文层次','省级',NULL,NULL,'1',NULL),
('45','008','论文层次','国家级',NULL,NULL,'1',NULL),
('46','008','论文层次','国际会议',NULL,NULL,'1',NULL),
('47','008','论文层次','中文核心',NULL,NULL,'1',NULL),
('48','008','论文层次','EI检索',NULL,NULL,'1',NULL),
('49','008','论文层次','SCI检索',NULL,NULL,'1',NULL),
('5','002','所属院系','计算机与遥感信息技术学院',NULL,3,'1',NULL),
('50','009','专利类型','发明',NULL,NULL,'1',NULL),
('51','009','专利类型','外观设计',NULL,NULL,'1',NULL),
('52','009','专利类型','实用新型',NULL,NULL,'1',NULL),
('53','009','专利类型','软件著作权',NULL,NULL,'1',NULL),
('54','010','立项级别|学生&老师获奖级别','校级',NULL,NULL,'1',NULL),
('55','010','立项级别|学生&老师获奖级别','市厅级',NULL,NULL,'1',NULL),
('56','010','立项级别|学生&老师获奖级别','省部级',NULL,NULL,'1',NULL),
('57','010','立项级别|学生&老师获奖级别','国家级',NULL,NULL,'1',NULL),
('58','011','教学评估成绩','优秀',NULL,NULL,'1',NULL),
('59','011','教学评估成绩','良好',NULL,NULL,'1',NULL),
('6','002','所属院系','材料工程学院',NULL,4,'1',NULL),
('60','011','教学评估成绩','中等',NULL,NULL,'1',NULL),
('61','012','培训成果','获得证书',NULL,NULL,'1',NULL),
('62','012','培训成果','结业',NULL,NULL,'1',NULL),
('63','012','培训成果','完成',NULL,NULL,'1',NULL),
('64','012','培训成果','未完成',NULL,NULL,'1',NULL),
('65','013','年终考核结果','优秀',NULL,NULL,'1',NULL),
('66','013','年终考核结果','合格',NULL,NULL,'1',NULL),
('67','013','年终考核结果','不合格',NULL,NULL,'1',NULL),
('68','014','奖励类别','教学',NULL,NULL,'1',NULL),
('69','014','奖励类别','科研',NULL,NULL,'1',NULL),
('7','002','所属院系','经济管理系',NULL,5,'1',NULL),
('70','014','奖励类别','教研',NULL,NULL,'1',NULL),
('71','014','奖励类别','学生工作',NULL,NULL,'1',NULL),
('72','014','奖励类别','党务',NULL,NULL,'1',NULL),
('73','014','奖励类别','政务',NULL,NULL,'1',NULL),
('74','014','奖励类别','工会',NULL,NULL,'1',NULL),
('75','015','奖励所属','集体',NULL,NULL,NULL,NULL),
('76','015','奖励所属','个人',NULL,NULL,NULL,NULL),
('77','016','纵向研究性质','科研',NULL,NULL,NULL,NULL),
('78','016','纵向研究性质','教研',NULL,NULL,NULL,NULL),
('79','017','用户状态','使用',NULL,NULL,NULL,NULL),
('8','003','职称','助教',NULL,1,'1',NULL),
('80','017','用户状态','冻结',NULL,NULL,NULL,NULL),
('81','018','角色','普通用户',NULL,NULL,NULL,NULL),
('82','018','角色','管理员',NULL,NULL,NULL,NULL),
('83','018','角色','超级管理员',NULL,NULL,NULL,NULL),
('9','003','职称','讲师',NULL,2,'1',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
