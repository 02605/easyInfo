/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : easyinfo

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2018-08-31 08:44:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adminlogin`
-- ----------------------------
DROP TABLE IF EXISTS `adminlogin`;
CREATE TABLE `adminlogin` (
  `tea_id` varchar(100) NOT NULL DEFAULT '' COMMENT '职工号 ',
  `admin_password` varchar(50) NOT NULL COMMENT '密码',
  `admin_state` char(1) NOT NULL COMMENT '状态1/0',
  PRIMARY KEY (`tea_id`),
  CONSTRAINT `adminlogin_ibfk_1` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminlogin
-- ----------------------------

-- ----------------------------
-- Table structure for `annualreview`
-- ----------------------------
DROP TABLE IF EXISTS `annualreview`;
CREATE TABLE `annualreview` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号 ',
  `ann_rev_year` date NOT NULL COMMENT '年份',
  `ann_rev_grade` varchar(32) NOT NULL COMMENT '考核结果',
  PRIMARY KEY (`tea_id`,`ann_rev_year`),
  KEY `ann_rev_grade` (`ann_rev_grade`),
  KEY `ann_id` (`tea_id`),
  CONSTRAINT `annualreview_ibfk_1` FOREIGN KEY (`ann_rev_grade`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `annualreview_ibfk_2` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of annualreview
-- ----------------------------

-- ----------------------------
-- Table structure for `basedict`
-- ----------------------------
DROP TABLE IF EXISTS `basedict`;
CREATE TABLE `basedict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  KEY `dict_item_name` (`dict_item_name`),
  KEY `dict_id` (`dict_id`),
  KEY `dict_type_name` (`dict_type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basedict
-- ----------------------------
INSERT INTO `basedict` VALUES ('1', '001', '性别', '男', null, '1', '1', null);
INSERT INTO `basedict` VALUES ('10', '003', '职称', '副教授', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('11', '003', '职称', '教授', '', '4', '1', '');
INSERT INTO `basedict` VALUES ('12', '004', '学位', '学士', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('13', '004', '学位', '硕士', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('14', '004', '学位', '博士', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('15', '005', '学历', '博士生毕业', '', '4', '1', '');
INSERT INTO `basedict` VALUES ('16', '005', '学历', '博士生结业', '', '5', '1', '');
INSERT INTO `basedict` VALUES ('17', '005', '学历', '博士生肄业', '', '6', '1', '');
INSERT INTO `basedict` VALUES ('18', '005', '学历', '硕士生毕业', '', '7', '1', '');
INSERT INTO `basedict` VALUES ('19', '005', '学历', '硕士生结业', '', '8', '1', '');
INSERT INTO `basedict` VALUES ('2', '001', '性别', '女', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('20', '005', '学历', '硕士生肄业', '', '9', '1', '');
INSERT INTO `basedict` VALUES ('21', '005', '学历', '本科生毕业', '', '10', '1', '');
INSERT INTO `basedict` VALUES ('22', '005', '学历', '本科生结业', '', '11', '1', '');
INSERT INTO `basedict` VALUES ('23', '005', '学历', '本科生肄业', '', '12', '1', '');
INSERT INTO `basedict` VALUES ('24', '005', '学历', '专科生毕业', '', '13', '1', '');
INSERT INTO `basedict` VALUES ('25', '005', '学历', '专科生结业', '', '14', '1', '');
INSERT INTO `basedict` VALUES ('26', '005', '学历', '专科生肄业', '', '15', '1', '');
INSERT INTO `basedict` VALUES ('27', '005', '学历', '研修班毕业', '', '16', '1', '');
INSERT INTO `basedict` VALUES ('28', '005', '学历', '双学位毕业', '', '17', '1', '');
INSERT INTO `basedict` VALUES ('29', '006', '民族', '汉族', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('3', '002', '所属院系', '机电工程学院', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('30', '006', '民族', '少数民族', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('31', '007', '政治面貌', '中共党员', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('32', '007', '政治面貌', '中共预备党员', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('33', '007', '政治面貌', '共青团员', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('34', '007', '政治面貌', '民革党员', '', '4', '1', '');
INSERT INTO `basedict` VALUES ('35', '007', '政治面貌', '民盟盟员', '', '5', '1', '');
INSERT INTO `basedict` VALUES ('36', '007', '政治面貌', '民建会员', '', '6', '1', '');
INSERT INTO `basedict` VALUES ('37', '007', '政治面貌', '民进会员', '', '7', '1', '');
INSERT INTO `basedict` VALUES ('38', '007', '政治面貌', '农工党党员', '', '8', '1', '');
INSERT INTO `basedict` VALUES ('39', '007', '政治面貌', '致公党党员', '', '9', '1', '');
INSERT INTO `basedict` VALUES ('4', '002', '所属院系', '电子与控制学院', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('40', '007', '政治面貌', '九三学社社员', '', '10', '1', '');
INSERT INTO `basedict` VALUES ('41', '007', '政治面貌', '台盟盟员', '', '11', '1', '');
INSERT INTO `basedict` VALUES ('42', '007', '政治面貌', '无党派人士', '', '12', '1', '');
INSERT INTO `basedict` VALUES ('43', '007', '政治面貌', '群众', '', '13', '1', '');
INSERT INTO `basedict` VALUES ('44', '008', '论文层次', '省级', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('45', '008', '论文层次', '国家级', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('46', '008', '论文层次', '国际会议', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('47', '008', '论文层次', '中文核心', '', '4', '1', '');
INSERT INTO `basedict` VALUES ('48', '008', '论文层次', 'EI检索', '', '5', '1', '');
INSERT INTO `basedict` VALUES ('49', '008', '论文层次', 'SCI检索', '', '6', '1', '');
INSERT INTO `basedict` VALUES ('5', '002', '所属院系', '计算机与遥感信息技术学院', null, '3', '1', null);
INSERT INTO `basedict` VALUES ('50', '009', '专利类型', '发明', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('51', '009', '专利类型', '外观设计', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('52', '009', '专利类型', '实用新型', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('53', '009', '专利类型', '软件著作权', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('54', '010', '立项级别|学生&老师获奖级别', '校级', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('55', '010', '立项级别|学生&老师获奖级别', '市厅级', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('56', '010', '立项级别|学生&老师获奖级别', '省部级', '', '4', '1', '');
INSERT INTO `basedict` VALUES ('57', '010', '立项级别|学生&老师获奖级别', '国家级', '', '5', '1', '');
INSERT INTO `basedict` VALUES ('58', '011', '教学评估成绩', '优秀', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('59', '011', '教学评估成绩', '良好', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('6', '002', '所属院系', '材料工程学院', '', '4', '1', '');
INSERT INTO `basedict` VALUES ('60', '011', '教学评估成绩', '中等', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('61', '012', '培训成果', '获得证书', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('62', '012', '培训成果', '结业', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('63', '012', '培训成果', '完成', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('64', '012', '培训成果', '未完成', '', '4', '1', '');
INSERT INTO `basedict` VALUES ('65', '013', '年终考核结果', '优秀', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('66', '013', '年终考核结果', '合格', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('67', '013', '年终考核结果', '不合格', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('68', '014', '奖励类别', '教学', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('69', '014', '奖励类别', '科研', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('7', '002', '所属院系', '经济管理系', '', '5', '1', '');
INSERT INTO `basedict` VALUES ('70', '014', '奖励类别', '教研', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('71', '014', '奖励类别', '学生工作', '', '4', '1', '');
INSERT INTO `basedict` VALUES ('72', '014', '奖励类别', '党务', '', '5', '1', '');
INSERT INTO `basedict` VALUES ('73', '014', '奖励类别', '政务', '', '6', '1', '');
INSERT INTO `basedict` VALUES ('74', '014', '奖励类别', '工会', '', '7', '1', '');
INSERT INTO `basedict` VALUES ('75', '015', '奖励所属', '集体', '', '8', '1', '');
INSERT INTO `basedict` VALUES ('76', '015', '奖励所属', '个人', '', '9', '1', '');
INSERT INTO `basedict` VALUES ('77', '016', '纵向研究性质', '科研', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('78', '016', '纵向研究性质', '教研', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('79', '017', '用户状态', '使用', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('8', '003', '职称', '助教', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('80', '017', '用户状态', '冻结', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('81', '018', '角色', '超级管理员', '', '1', '1', '');
INSERT INTO `basedict` VALUES ('82', '018', '角色', '管理员', '', '2', '1', '');
INSERT INTO `basedict` VALUES ('83', '018', '角色', '普通用户', '', '3', '1', '');
INSERT INTO `basedict` VALUES ('9', '003', '职称', '讲师', '', '2', '1', '');

-- ----------------------------
-- Table structure for `compilemateria`
-- ----------------------------
DROP TABLE IF EXISTS `compilemateria`;
CREATE TABLE `compilemateria` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `cm_id` varchar(100) NOT NULL COMMENT '教师著作id',
  `cm_rank` varchar(20) NOT NULL COMMENT '排名',
  `cm_chiefEditor` varchar(100) NOT NULL COMMENT '主编',
  `cm_subeditor` varchar(100) NOT NULL COMMENT '副主编',
  `cm_name` varchar(100) NOT NULL COMMENT '著作名称',
  `cm_edition` varchar(20) NOT NULL COMMENT '版次',
  `cm_location` varchar(100) NOT NULL COMMENT '出版地',
  `cm_publisher` varchar(100) NOT NULL COMMENT '出版者',
  `cm_pubTime` date NOT NULL COMMENT '出版时间',
  `cm_pageNum` int(11) DEFAULT NULL COMMENT '页码',
  `cm_bearNum` int(11) DEFAULT NULL COMMENT '承担字数',
  `cm_scan` varchar(100) NOT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`cm_id`),
  KEY `cm_location` (`cm_location`),
  KEY `cm_id` (`tea_id`),
  CONSTRAINT `compilemateria_ibfk_1` FOREIGN KEY (`cm_location`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `compilemateria_ibfk_2` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of compilemateria
-- ----------------------------

-- ----------------------------
-- Table structure for `horizontalresearch`
-- ----------------------------
DROP TABLE IF EXISTS `horizontalresearch`;
CREATE TABLE `horizontalresearch` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `hor_id` varchar(100) NOT NULL COMMENT '横向科研id',
  `hor_no` varchar(100) NOT NULL COMMENT '课题编号',
  `hor_rank` varchar(20) NOT NULL COMMENT '排名',
  `hor _nature` varchar(20) NOT NULL COMMENT '性质',
  `hor _manager` varchar(100) NOT NULL COMMENT '项目负责人',
  `hor _personnel` varchar(100) NOT NULL COMMENT '参加人员',
  `hor _courseName` varchar(100) NOT NULL COMMENT '课题名称',
  `hor_introduction` varchar(100) NOT NULL COMMENT '简单介绍',
  `hor _projectTime` date NOT NULL COMMENT '立项时间',
  `hor _endTime` date DEFAULT NULL COMMENT '结题时间',
  `hor_cilentName` varchar(20) NOT NULL COMMENT '客户名称',
  `hor_subjcerCost` int(11) NOT NULL COMMENT '课题总经费',
  `hor_inplactCost` int(11) NOT NULL COMMENT '到位经费',
  `hor _scan` varchar(100) NOT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`hor_id`),
  KEY `hor _nature` (`hor _nature`),
  KEY `hor_id` (`tea_id`) USING BTREE,
  CONSTRAINT `horizontalresearch_ibfk_1` FOREIGN KEY (`hor _nature`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `horizontalresearch_ibfk_2` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of horizontalresearch
-- ----------------------------

-- ----------------------------
-- Table structure for `instructedstudents`
-- ----------------------------
DROP TABLE IF EXISTS `instructedstudents`;
CREATE TABLE `instructedstudents` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `ins_stu_id` varchar(100) NOT NULL COMMENT '索引id',
  `stu_rank` varchar(20) NOT NULL COMMENT '排名',
  `stu _teancherOne` varchar(20) NOT NULL COMMENT '指导教师一',
  `stu_oneUnit` varchar(100) NOT NULL COMMENT '指导教师一单位',
  `stu _teancherTwo` varchar(20) DEFAULT NULL COMMENT '指导教师二',
  `stu_twoUnit` varchar(100) DEFAULT NULL COMMENT '指导教师二单位',
  `stu _teancherThree` varchar(20) DEFAULT NULL COMMENT '指导教师三',
  `stu_threeUnit` varchar(100) DEFAULT NULL COMMENT '指导教师三单位',
  `stu_num` varchar(100) NOT NULL COMMENT '学号',
  `stu_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `stu_comName` varchar(100) DEFAULT NULL COMMENT '竞赛名称',
  `stu_proName` varchar(20) NOT NULL DEFAULT '' COMMENT '项目名称',
  `stu_startTime` date DEFAULT NULL COMMENT '开始时间',
  `stu_endTime` date DEFAULT NULL COMMENT '结束时间',
  `stu_type` char(20) DEFAULT NULL,
  `stu_others` varchar(100) DEFAULT NULL COMMENT '团队其他成员',
  `stu_organizer` varchar(100) DEFAULT NULL COMMENT '主办单位',
  `stu_reward` char(100) DEFAULT NULL COMMENT '是否获奖',
  `stu_rewardTime` date DEFAULT NULL COMMENT '获奖时间',
  `stu_rewardLevel` varchar(255) DEFAULT NULL COMMENT '获奖级别',
  `stu_rewardDetail` varchar(20) NOT NULL COMMENT '获奖等级或奖项名称',
  `stu_scan` varchar(100) NOT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`ins_stu_id`),
  KEY `ins_stu_id` (`tea_id`) USING BTREE,
  KEY `stu_type` (`stu_type`),
  KEY `stu_rewardLevel` (`stu_rewardLevel`),
  CONSTRAINT `instructedstudents_ibfk_1` FOREIGN KEY (`stu_type`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `instructedstudents_ibfk_2` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`),
  CONSTRAINT `instructedstudents_ibfk_3` FOREIGN KEY (`stu_rewardLevel`) REFERENCES `basedict` (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of instructedstudents
-- ----------------------------

-- ----------------------------
-- Table structure for `instructor`
-- ----------------------------
DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `ins_id` varchar(100) NOT NULL,
  `ins_startTime` date NOT NULL COMMENT '起始时间',
  `ins_endTime` date DEFAULT NULL COMMENT '结束时间',
  `ins_classes` varchar(100) NOT NULL COMMENT '班级',
  PRIMARY KEY (`tea_id`,`ins_id`),
  KEY `ins_id` (`tea_id`),
  CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of instructor
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `Mes_id` varchar(50) NOT NULL COMMENT '通知id',
  `Mes_dep` varchar(20) NOT NULL COMMENT '发布通知人/部门',
  `Mes_content` varchar(224) NOT NULL COMMENT '通知内容',
  `Mes_time` date NOT NULL COMMENT '发布时间',
  `Mes_tel` varchar(20) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`Mes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `patent`
-- ----------------------------
DROP TABLE IF EXISTS `patent`;
CREATE TABLE `patent` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `pat_id` varchar(100) NOT NULL COMMENT '专利id',
  `pat_rank` varchar(20) NOT NULL COMMENT '排名',
  `pat_type` varchar(20) NOT NULL COMMENT '专利类型',
  `pat_author` varchar(100) NOT NULL COMMENT '作者',
  `pat_name` varchar(100) NOT NULL COMMENT '题名',
  `pat_country` varchar(100) NOT NULL COMMENT '国别',
  `pat_registerNum` varchar(100) NOT NULL COMMENT '登记号',
  `pat_pubTime` date NOT NULL COMMENT '发布日期',
  `pat_scan` varchar(100) NOT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`pat_id`),
  KEY `pat_id` (`tea_id`) USING BTREE,
  KEY `pat_type` (`pat_type`),
  KEY `pat_country` (`pat_country`),
  CONSTRAINT `patent_ibfk_1` FOREIGN KEY (`pat_type`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `patent_ibfk_2` FOREIGN KEY (`pat_country`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `patent_ibfk_3` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patent
-- ----------------------------

-- ----------------------------
-- Table structure for `practice`
-- ----------------------------
DROP TABLE IF EXISTS `practice`;
CREATE TABLE `practice` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `pra_id` varchar(100) NOT NULL COMMENT '索引id',
  `pra_company` varchar(100) NOT NULL COMMENT '实践单位',
  `pra_startTime` date NOT NULL COMMENT '起始时间',
  `pra_endTime` date DEFAULT NULL COMMENT '结束时间',
  `pra_post` varchar(100) NOT NULL DEFAULT '' COMMENT '实践职务',
  `pra_project` varchar(100) NOT NULL COMMENT '依托项目',
  `pra_content` varchar(100) NOT NULL COMMENT '实践内容',
  `pra_scan` varchar(100) NOT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`pra_id`),
  KEY `pra_id` (`tea_id`) USING BTREE,
  CONSTRAINT `practice_ibfk_1` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practice
-- ----------------------------

-- ----------------------------
-- Table structure for `privatetemplate`
-- ----------------------------
DROP TABLE IF EXISTS `privatetemplate`;
CREATE TABLE `privatetemplate` (
  `Pri_tem_id` varchar(50) NOT NULL COMMENT '模板名称',
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `Pri_tem_name` varchar(50) NOT NULL COMMENT '模板id',
  `Pri_tem_url` varchar(100) NOT NULL COMMENT '模板地址',
  `Pri_tem_describe` varchar(224) DEFAULT NULL COMMENT '模板描述',
  PRIMARY KEY (`Pri_tem_id`,`tea_id`),
  KEY `Pri_tem_id` (`tea_id`),
  CONSTRAINT `privatetemplate_ibfk_1` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privatetemplate
-- ----------------------------

-- ----------------------------
-- Table structure for `publictemplate`
-- ----------------------------
DROP TABLE IF EXISTS `publictemplate`;
CREATE TABLE `publictemplate` (
  `Pub_tem_id` varchar(50) NOT NULL COMMENT '模板名称',
  `Pub_tem_name` varchar(50) NOT NULL COMMENT '模板id',
  `Pub_tem_url` varchar(100) NOT NULL COMMENT '模板地址',
  `Pub_tem_describe` varchar(224) DEFAULT NULL COMMENT '模板描述',
  PRIMARY KEY (`Pub_tem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publictemplate
-- ----------------------------

-- ----------------------------
-- Table structure for `reward`
-- ----------------------------
DROP TABLE IF EXISTS `reward`;
CREATE TABLE `reward` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `rew_id` varchar(100) NOT NULL COMMENT '索引id',
  `rew_name` varchar(100) NOT NULL COMMENT '奖励名称',
  `rew_department` varchar(100) NOT NULL COMMENT '奖励部门',
  `rew_time` date NOT NULL COMMENT '奖励时间',
  `rew_level` varchar(100) NOT NULL COMMENT '奖励级别',
  `rew_levelDetail` varchar(100) NOT NULL COMMENT '获奖等级或奖项名称',
  `rew_family` varchar(100) NOT NULL COMMENT '奖励类别',
  `rew_ascription` varchar(100) NOT NULL COMMENT '集体或个人',
  `rew_scan` varchar(100) NOT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`rew_id`),
  KEY `rew_id` (`tea_id`) USING BTREE,
  KEY `rew_level` (`rew_level`),
  KEY `rew_levelDetail` (`rew_levelDetail`),
  KEY `rew_ascription` (`rew_ascription`),
  KEY `rew_family` (`rew_family`),
  CONSTRAINT `reward_ibfk_1` FOREIGN KEY (`rew_levelDetail`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `reward_ibfk_2` FOREIGN KEY (`rew_family`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `reward_ibfk_3` FOREIGN KEY (`rew_ascription`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `reward_ibfk_4` FOREIGN KEY (`rew_level`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `reward_ibfk_5` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reward
-- ----------------------------

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号 ',
  `tea_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `tea_gender` varchar(1) DEFAULT NULL COMMENT '性别',
  `tea_birthday` date DEFAULT NULL COMMENT '出生日期',
  `tea_identityId` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `tea_nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `tea_political` varchar(20) DEFAULT NULL COMMENT '政治面貌',
  `tea_workDate` date DEFAULT NULL COMMENT '参加工作时间',
  `tea_jobTitel` varchar(20) DEFAULT NULL COMMENT '职称',
  `tea_eduBG` varchar(20) DEFAULT NULL COMMENT '学历',
  `tea_degree` varchar(20) DEFAULT NULL COMMENT '学位',
  `tea_home` varchar(20) DEFAULT NULL COMMENT '家庭住址',
  `tea_phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `tea_qq` varchar(20) DEFAULT NULL COMMENT 'QQ',
  `tea_weChat` varchar(20) DEFAULT NULL COMMENT '微信',
  `tea_dep` varchar(20) DEFAULT NULL COMMENT '系别',
  `tea_enable` varchar(2) NOT NULL COMMENT '状态',
  `tea_email` varchar(255) DEFAULT NULL,
  `tea_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tea_id`),
  KEY `tea_gender` (`tea_gender`),
  KEY `tea_nation` (`tea_nation`),
  KEY `tea_political` (`tea_political`),
  KEY `tea_jobTitel` (`tea_jobTitel`),
  KEY `tea_eduBG` (`tea_eduBG`),
  KEY `tea_degree` (`tea_degree`),
  KEY `tea_dep` (`tea_dep`),
  KEY `tea_enable` (`tea_enable`),
  KEY `FKAA31CBE2C5A9509` (`tea_role`),
  KEY `FKAA31CBE24E76E750` (`tea_eduBG`),
  KEY `FKAA31CBE25FD1EC1A` (`tea_nation`),
  KEY `FKAA31CBE292593752` (`tea_political`),
  CONSTRAINT `FK3viuxr3si6tn99067xdqaq5v7` FOREIGN KEY (`tea_enable`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK2jblarkquje10owieugaveyop` FOREIGN KEY (`tea_jobTitel`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK5fm9f4x84tr7nmkk6dlfvdsc7` FOREIGN KEY (`tea_dep`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK80sjmwbpcel2wwrbo6dkg9btx` FOREIGN KEY (`tea_eduBG`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK9ns4t74b94jeiop3v36futtr0` FOREIGN KEY (`tea_role`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKAA31CBE25FD1EC1A` FOREIGN KEY (`tea_nation`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKAA31CBE292593752` FOREIGN KEY (`tea_political`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKe9qekkq7usydud5plqwy07rj3` FOREIGN KEY (`tea_nation`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKhm5b6pqjjl042mcygi9frsh3` FOREIGN KEY (`tea_gender`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKkb1x2hb2r6ipl69kee9mn83vv` FOREIGN KEY (`tea_degree`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FKnum25vb6ortk7umcnpyrtm1xy` FOREIGN KEY (`tea_political`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`tea_jobTitel`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`tea_eduBG`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_3` FOREIGN KEY (`tea_role`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_4` FOREIGN KEY (`tea_degree`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_5` FOREIGN KEY (`tea_dep`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_6` FOREIGN KEY (`tea_eduBG`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_7` FOREIGN KEY (`tea_enable`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_8` FOREIGN KEY (`tea_gender`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teacher_ibfk_9` FOREIGN KEY (`tea_id`) REFERENCES `user` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2001', '张三', '1', '2018-08-31', null, '29', '11', '2018-08-15', '11', '11', '19', null, null, null, null, '3', '79', null, '82');

-- ----------------------------
-- Table structure for `teachingevaluation`
-- ----------------------------
DROP TABLE IF EXISTS `teachingevaluation`;
CREATE TABLE `teachingevaluation` (
  `tea_id` varchar(100) NOT NULL DEFAULT '' COMMENT '职工号 ',
  `tea_eva_year` date NOT NULL DEFAULT '0000-00-00' COMMENT '学年',
  `tea_eva_grade` varchar(32) NOT NULL COMMENT '评估成绩',
  `tea_eva_id` int(11) NOT NULL,
  PRIMARY KEY (`tea_id`,`tea_eva_year`),
  KEY `tea_eva_grade` (`tea_eva_grade`),
  KEY `tea_eva_id` (`tea_id`),
  KEY `FK1C9ACA49B2E888FD` (`tea_eva_grade`),
  CONSTRAINT `FK2c7p4ia6xs92998dvehp8dn1e` FOREIGN KEY (`tea_eva_grade`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK7meyemtlklr8rhkjc3hdixm` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`),
  CONSTRAINT `teachingevaluation_ibfk_1` FOREIGN KEY (`tea_eva_grade`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teachingevaluation_ibfk_2` FOREIGN KEY (`tea_eva_grade`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `teachingevaluation_ibfk_3` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachingevaluation
-- ----------------------------

-- ----------------------------
-- Table structure for `thesis`
-- ----------------------------
DROP TABLE IF EXISTS `thesis`;
CREATE TABLE `thesis` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `the_id` varchar(100) NOT NULL COMMENT '索引id',
  `the_rank` varchar(20) NOT NULL COMMENT '排名',
  `the_firstAuthor` varchar(20) NOT NULL COMMENT '第一作者',
  `the_otherAuthor` varchar(100) NOT NULL COMMENT '其他作者',
  `the_title` varchar(100) NOT NULL COMMENT '论文题目',
  `the_periodical` varchar(100) NOT NULL COMMENT '刊物名称',
  `the_pubTime` date NOT NULL COMMENT '出版时间',
  `the_reelNum` varchar(20) DEFAULT NULL COMMENT '卷号',
  `the_issue` varchar(20) DEFAULT NULL COMMENT '期号',
  `the_startNum` int(11) DEFAULT NULL COMMENT '起始页码',
  `the_endNum` int(11) DEFAULT NULL COMMENT '终止页码',
  `the_wordNum` int(11) DEFAULT NULL COMMENT '字数',
  `the_level` varchar(20) NOT NULL COMMENT '论文层次',
  `the_scan` varchar(100) NOT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`the_id`),
  KEY `the_id` (`tea_id`),
  KEY `the_level` (`the_level`),
  CONSTRAINT `thesis_ibfk_1` FOREIGN KEY (`the_level`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `thesis_ibfk_2` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of thesis
-- ----------------------------

-- ----------------------------
-- Table structure for `train`
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `tra_id` varchar(100) NOT NULL COMMENT '索引id',
  `tra_startTime` date NOT NULL COMMENT '起始时间',
  `tra_endTime` date DEFAULT NULL COMMENT '结束时间',
  `tra_address` varchar(100) NOT NULL COMMENT '地点',
  `tra_theme` varchar(100) NOT NULL COMMENT '主题',
  `tra_content` varchar(100) NOT NULL COMMENT '培训内容',
  `tra_result` varchar(100) NOT NULL COMMENT '培训成果',
  `tra_scan` varchar(100) NOT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`tra_id`),
  KEY `tra_index` (`tea_id`) USING BTREE,
  KEY `tra_result` (`tra_result`),
  CONSTRAINT `train_ibfk_1` FOREIGN KEY (`tra_result`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `train_ibfk_2` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `tea_id` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `state` varchar(10) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`tea_id`),
  KEY `role` (`role`),
  KEY `state` (`state`),
  CONSTRAINT `FKeqkrbx6e09vc257arvvrysb9p` FOREIGN KEY (`state`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `FK8e80qs6bx8v8ceho2fm4r8s6r` FOREIGN KEY (`role`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`role`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `user_ibfk_3` FOREIGN KEY (`state`) REFERENCES `basedict` (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2001', 'admin', '79', '82');
INSERT INTO `user` VALUES ('2002', 'admin', '79', '82');

-- ----------------------------
-- Table structure for `userlogin`
-- ----------------------------
DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin` (
  `tea_id` varchar(100) NOT NULL DEFAULT '' COMMENT '职工号 ',
  `user_password` varchar(50) NOT NULL COMMENT '密码',
  `user_state` char(1) NOT NULL COMMENT '状态1/0',
  PRIMARY KEY (`tea_id`),
  CONSTRAINT `userlogin_ibfk_1` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlogin
-- ----------------------------

-- ----------------------------
-- Table structure for `userprivilege`
-- ----------------------------
DROP TABLE IF EXISTS `userprivilege`;
CREATE TABLE `userprivilege` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号',
  `user_pri_type` varchar(50) NOT NULL COMMENT '用户权限类型',
  PRIMARY KEY (`tea_id`),
  KEY `user_pri_type` (`user_pri_type`),
  CONSTRAINT `userprivilege_ibfk_1` FOREIGN KEY (`user_pri_type`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `userprivilege_ibfk_2` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userprivilege
-- ----------------------------

-- ----------------------------
-- Table structure for `verticalresearch`
-- ----------------------------
DROP TABLE IF EXISTS `verticalresearch`;
CREATE TABLE `verticalresearch` (
  `tea_id` varchar(100) NOT NULL COMMENT '职工号 ',
  `ver_id` varchar(100) NOT NULL COMMENT '索引id',
  `ver_rank` varchar(20) NOT NULL COMMENT '排名',
  `ver_nature` varchar(20) NOT NULL COMMENT '性质',
  `ver_manager` varchar(100) NOT NULL COMMENT '项目负责人',
  `ver_personnel` varchar(100) DEFAULT NULL COMMENT '参加人员',
  `ver_courseName` varchar(100) NOT NULL COMMENT '课题名称',
  `ver_introduction` varchar(100) NOT NULL COMMENT '简单介绍',
  `ver_projectTime` date NOT NULL COMMENT '立项时间',
  `ver_endTime` date DEFAULT NULL COMMENT '结题时间',
  `ver_projectUnit` varchar(20) NOT NULL COMMENT '立项单位',
  `ver_ projectLevel` varchar(10) NOT NULL COMMENT '立项级别',
  `ver_identTime` date DEFAULT NULL COMMENT '鉴定时间',
  `ver_identLevel` varchar(20) DEFAULT NULL COMMENT '鉴定级别',
  `ver_identCon` varchar(100) DEFAULT NULL COMMENT '鉴定结论',
  `ver_scan` varchar(100) DEFAULT NULL COMMENT '扫描件',
  PRIMARY KEY (`tea_id`,`ver_id`),
  KEY `ver_id` (`tea_id`),
  KEY `ver_ projectLevel` (`ver_ projectLevel`),
  KEY `ver_identLevel` (`ver_identLevel`),
  KEY `ver_nature` (`ver_nature`),
  CONSTRAINT `verticalresearch_ibfk_1` FOREIGN KEY (`ver_identLevel`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `verticalresearch_ibfk_2` FOREIGN KEY (`ver_nature`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `verticalresearch_ibfk_3` FOREIGN KEY (`ver_ projectLevel`) REFERENCES `basedict` (`dict_id`),
  CONSTRAINT `verticalresearch_ibfk_4` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verticalresearch
-- ----------------------------
