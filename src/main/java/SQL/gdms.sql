/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : gdms

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-05-23 13:32:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adviser_score`
-- ----------------------------
DROP TABLE IF EXISTS `adviser_score`;
CREATE TABLE `adviser_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(255) DEFAULT NULL,
  `adviser_score` int(11) DEFAULT '0',
  `sid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adviser_score
-- ----------------------------
INSERT INTO `adviser_score` VALUES ('9', '20140304625', '70', 'B20140304623');
INSERT INTO `adviser_score` VALUES ('10', '20140304625', '60', 'B20140304624');
INSERT INTO `adviser_score` VALUES ('11', '20140304625', '40', 'B20140304625');
INSERT INTO `adviser_score` VALUES ('12', '20140304625', '0', 'B20140304626');
INSERT INTO `adviser_score` VALUES ('13', '20140304625', '0', 'B20140304627');
INSERT INTO `adviser_score` VALUES ('14', '20140304625', '0', 'B20140304628');
INSERT INTO `adviser_score` VALUES ('15', '20140304625', '0', 'B20140304703');
INSERT INTO `adviser_score` VALUES ('16', '20140304625', '0', 'B20140304704');

-- ----------------------------
-- Table structure for `advise_apply`
-- ----------------------------
DROP TABLE IF EXISTS `advise_apply`;
CREATE TABLE `advise_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(20) DEFAULT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `pass` int(11) DEFAULT '0' COMMENT ' 0- 还在审核中， 1- 通过，2-未通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of advise_apply
-- ----------------------------
INSERT INTO `advise_apply` VALUES ('2', '20140304625', 'B20140304623', '1');
INSERT INTO `advise_apply` VALUES ('3', '20140304625', 'B20140304624', '1');
INSERT INTO `advise_apply` VALUES ('4', '20140304625', 'B20140304625', '1');
INSERT INTO `advise_apply` VALUES ('10', '20140304625', 'B20140304626', '1');
INSERT INTO `advise_apply` VALUES ('13', '20140304625', 'B20140304627', '1');
INSERT INTO `advise_apply` VALUES ('14', '20140304625', 'B20140304628', '2');
INSERT INTO `advise_apply` VALUES ('16', '20140304625', 'B20140304629', '0');

-- ----------------------------
-- Table structure for `advise_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `advise_teacher`;
CREATE TABLE `advise_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(20) DEFAULT NULL,
  `have_number` int(11) DEFAULT '0',
  `limit_number` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of advise_teacher
-- ----------------------------
INSERT INTO `advise_teacher` VALUES ('1', '20140304625', '9', '20');
INSERT INTO `advise_teacher` VALUES ('2', '20140304663', '0', '1');
INSERT INTO `advise_teacher` VALUES ('3', '20140304789', '2', '2');

-- ----------------------------
-- Table structure for `advise_teacherandstudent`
-- ----------------------------
DROP TABLE IF EXISTS `advise_teacherandstudent`;
CREATE TABLE `advise_teacherandstudent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(20) DEFAULT NULL,
  `sid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of advise_teacherandstudent
-- ----------------------------
INSERT INTO `advise_teacherandstudent` VALUES ('1', '20140304625', 'B20140304623');
INSERT INTO `advise_teacherandstudent` VALUES ('3', '20140304625', 'B20140304624');
INSERT INTO `advise_teacherandstudent` VALUES ('8', '20140304625', 'B20140304625');
INSERT INTO `advise_teacherandstudent` VALUES ('9', '20140304625', 'B20140304626');
INSERT INTO `advise_teacherandstudent` VALUES ('10', '20140304625', 'B20140304627');
INSERT INTO `advise_teacherandstudent` VALUES ('11', '20140304625', 'B20140304628');
INSERT INTO `advise_teacherandstudent` VALUES ('12', '20140304625', 'B20140304703');
INSERT INTO `advise_teacherandstudent` VALUES ('13', '20140304625', 'B20140304704');
INSERT INTO `advise_teacherandstudent` VALUES ('14', '20140304789', 'B2010304701');
INSERT INTO `advise_teacherandstudent` VALUES ('15', '20140304789', 'B20140304896');
INSERT INTO `advise_teacherandstudent` VALUES ('16', '20140304625', 'B20140304629');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '计算机工程与应用数学学院');
INSERT INTO `department` VALUES ('2', '经济与管理学院');
INSERT INTO `department` VALUES ('3', '土木工程学院');
INSERT INTO `department` VALUES ('4', '影视艺术与文化传播学院');
INSERT INTO `department` VALUES ('5', '艺术设计学院');
INSERT INTO `department` VALUES ('6', '生物与环境工程学院');
INSERT INTO `department` VALUES ('7', '电子信息与电气工程学院');
INSERT INTO `department` VALUES ('8', '外国语学院');
INSERT INTO `department` VALUES ('9', '机电工程学院');
INSERT INTO `department` VALUES ('10', '法学院');
INSERT INTO `department` VALUES ('11', '音乐学院');
INSERT INTO `department` VALUES ('12', '马克思主义学院');

-- ----------------------------
-- Table structure for `identity`
-- ----------------------------
DROP TABLE IF EXISTS `identity`;
CREATE TABLE `identity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity_id` int(11) DEFAULT NULL COMMENT '身份id',
  `identityname` varchar(25) DEFAULT NULL COMMENT '身份姓名',
  `group_id` int(11) DEFAULT NULL COMMENT '权限分组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identity
-- ----------------------------
INSERT INTO `identity` VALUES ('1', '1', '超级管理员', '1');
INSERT INTO `identity` VALUES ('2', '2', '学生', '2');
INSERT INTO `identity` VALUES ('3', '3', '指导老师', '3');
INSERT INTO `identity` VALUES ('4', '4', '答辩老师', '4');
INSERT INTO `identity` VALUES ('5', '5', '管理员', '5');
INSERT INTO `identity` VALUES ('6', '6', '答辩组组长', '6');

-- ----------------------------
-- Table structure for `kit_admin`
-- ----------------------------
DROP TABLE IF EXISTS `kit_admin`;
CREATE TABLE `kit_admin` (
  `kit_admin_id` varchar(111) NOT NULL COMMENT '用户id',
  `kit_admin_username` varchar(30) NOT NULL COMMENT '管理员账号',
  `kit_admin_password` varchar(32) NOT NULL COMMENT '密码',
  `kit_admin_name` varchar(20) NOT NULL COMMENT '名字',
  `kit_admin_img_url` varchar(100) DEFAULT 'uplodefiles/touxian.jpg' COMMENT '头像地址',
  `group_id` int(2) NOT NULL COMMENT '用户所属分组',
  PRIMARY KEY (`kit_admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of kit_admin
-- ----------------------------
INSERT INTO `kit_admin` VALUES ('1', 'admin', '123456', '超级管理员', 'uplodefiles/image/e51789b8416b4d9697c8bc15e5af95ba.jpeg', '1');
INSERT INTO `kit_admin` VALUES ('188750', 'guns', '123456', '枪王', 'uplodefiles/image/92a9fead350e42ed9ef2e83418e9a0cb.jpeg', '5');
INSERT INTO `kit_admin` VALUES ('2', 'Sword', '123456', '剑仙', 'uplodefiles/touxian.jpg', '5');
INSERT INTO `kit_admin` VALUES ('5', 'Sword_god', '123456', '剑帝', 'uplodefiles/image/5c2b2359cb9c4daca6106cfa7ad38458.jpeg', '5');

-- ----------------------------
-- Table structure for `kit_g_group`
-- ----------------------------
DROP TABLE IF EXISTS `kit_g_group`;
CREATE TABLE `kit_g_group` (
  `group_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '分组id',
  `group_name` varchar(50) DEFAULT NULL COMMENT '分组名字',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kit_g_group
-- ----------------------------
INSERT INTO `kit_g_group` VALUES ('1', '超级管理员');
INSERT INTO `kit_g_group` VALUES ('2', '学生');
INSERT INTO `kit_g_group` VALUES ('3', '指导老师');
INSERT INTO `kit_g_group` VALUES ('4', '答辩老师');
INSERT INTO `kit_g_group` VALUES ('5', '管理员');
INSERT INTO `kit_g_group` VALUES ('6', '答辩组组长');

-- ----------------------------
-- Table structure for `kit_g_group_limit`
-- ----------------------------
DROP TABLE IF EXISTS `kit_g_group_limit`;
CREATE TABLE `kit_g_group_limit` (
  `gl_id` varchar(111) NOT NULL COMMENT '列表ID',
  `group_id` int(4) DEFAULT NULL COMMENT '分组ID',
  `limit_id` int(5) DEFAULT NULL COMMENT '功能id',
  `group_c` int(1) NOT NULL DEFAULT '1' COMMENT '是否有增加按钮，1 为 有，2 为没有',
  `group_r` int(1) NOT NULL DEFAULT '1' COMMENT '是否有删除按钮，1 为 有，2 为没有',
  `group_u` int(1) NOT NULL DEFAULT '1' COMMENT '是否有修改按钮，1 为 有，2 为没有',
  `group_d` int(1) NOT NULL DEFAULT '1' COMMENT '是否有查询按钮，1 为 有，2 为没有',
  PRIMARY KEY (`gl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分组和权限关联表';

-- ----------------------------
-- Records of kit_g_group_limit
-- ----------------------------
INSERT INTO `kit_g_group_limit` VALUES ('096f806081b3449ebd2cc5a673545e71', '6', '90', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('0db0c66a6be143349f0b9ca3ea1f9568', '1', '58', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('0f0da51b2333434db3ace63606212d10', '4', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('100ee463c18b4a83824ea9b574027695', '6', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('105c0ed2cdc34837a0587ddb1b4c2911', '1', '84', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('12d671a8caed4471ad4cd49776fef50e', '5', '31', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1381bcbf60f04d77a41d3610a3f81551', '3', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1459c83550a44b0e849601c1155f9584', '2', '65', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('215001e2db2c4672a1072debf341f015', '1', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('269a5514401145dd93cae96176e4091e', '5', '48', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('2c676d844f1d4a75b6ce8818c3f048e6', '4', '76', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('2f9c78a64d2048669097fb45c54010f3', '6', '81', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('318be6ff1609475cb7fb9dc0ad9811f3', '1', '50', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('34b56f02341449fdb9fc63cf164632c7', '5', '87', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('38234bb13190410b9087245fc3748dc7', '5', '89', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('3bbb783c12364895893d2c97679c095a', '4', '90', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('3e831d7d791144b6abd56b8b30a13b3a', '1', '87', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('4312606650344174a87fe6798af32180', '5', '77', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('439af732b9e845f0b45e0aa932b1a28f', '3', '79', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('45310481e31648069eacbcde9dc27924', '5', '30', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('49015a9ee46f4eeea9d835f920d373e7', '1', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('4a263ea894324db48223ff248bfbd3e6', '4', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('557a0017de424fbe895d1adde8c7e5c8', '3', '77', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('566aff8c872747538dab34ccddba7ed9', '2', '69', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('61ec8ef8be8e4ff9b6b0f3a15e27c440', '1', '30', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('6590981594a243a0b6dcbc3ac1a1b146', '2', '60', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('681117e0d96d4443bd8535fb4326487f', '5', '50', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('684e3c511754414a9ee1268b6ea5f160', '2', '73', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('69901d95755942989c640d28373e36e4', '6', '82', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('6d02be502f6c4acdb280652cacaf7e5e', '1', '77', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('71fcb0af6b8e4b57b7807fb10d988c27', '3', '31', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('78f18fc24c41429595b3585892d6ec9f', '1', '5', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('7e82809b1dd3405a8bf8cbe3cdd0ed64', '3', '66', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('8220a7ed0ea8477eb3a5f55122166a24', '2', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('82a539469d3b410da8f83c604568a503', '2', '31', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('85a8f772c3c54ab180b9df52f344e1c7', '5', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('85b9a4d2e5fa4ac19c1327c74a0bab31', '3', '78', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('87e1a39354f84c5b928559b252084a0a', '1', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('893946c2e4364529bdc544ea483ec100', '4', '75', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('8d842d8acc74458b8f5d808dc60e2ac4', '5', '28', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('91f2cf5c6e374c9c903a695689776499', '6', '75', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('959ab6ed3dca42cb96b483c92a029897', '5', '49', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('999cbcb19f714f2f931efcf57123dba5', '2', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('9b9d618dc1ad416199c5700b8eb99550', '5', '33', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('a14634ba864f40c1b0811eac33be54b0', '3', '68', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('a2a08d0714db482b93a07c5f9cf1f018', '1', '31', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('a404c3ce064f4fe29513a873683e81f9', '1', '1', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('a7144a1b2d2045e69cc0cdbf7ec88c06', '3', '36', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ab9425215fd84ad096c7c5e55147e01d', '2', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('adc1ba3df0d34125be3dab05777a4598', '1', '33', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ae3d44d01d6e4a09a2e603dfc9085093', '1', '42', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ae53fafe09de4ea7bd1329eb93346398', '1', '29', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('af01c2b101e747ab8abf3db523a5ffe3', '3', '88', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('af8f7c4f44f3473ba55f395fb53d431b', '3', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b02037cf698647e581d1f7fc1c624316', '6', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b39bc073b41447f89d45a0fd00bfc25d', '4', '82', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b43d523c029940659c7dae952746ecda', '1', '3', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b56221ed2436489a96fd63261826367f', '3', '63', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b5f625290ecb4ff0bd0220e7f902475c', '5', '42', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b71fd605e90f4d49b80788123cf79c94', '5', '29', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b9556a0186c34e6eacc7e1e515032eda', '5', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ba43577d718d418789952857d3d35e3e', '5', '83', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('be418b398c734e79bcbf3a5e15198f2e', '3', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('c3578ddb11be4c0e81562174a6987c35', '1', '89', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('c40c47865d404231befbec87ad353988', '6', '76', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('c4c822aeee594e25b8086bed8041a8ed', '2', '47', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('c5bcad3862f544b58d1940c3ebccf7e8', '1', '83', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('c8036e4951ff4d58b01a5dd3c508a687', '5', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('c807eb1074b6486cb01fe1ef2ad9ba60', '2', '71', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ccbea616e83f4cb58340fd878aa0e751', '6', '85', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('d40cbb026c3345ada3a64aa221e38948', '1', '48', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('de296841af074f048a9cbb388b233d62', '6', '92', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e104f71752ae4afbac8c8e1bdcdc26d3', '1', '49', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e3e8eaaf5f714ec0bfac9e202d5c125c', '2', '64', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e5558a0642434699bce025a06950d5f9', '2', '61', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ea723ac6f89d4734ba24d67e8b0d2350', '3', '62', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('f0b7743f3d6d4998b06fb1d376800038', '6', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('f1983d5617e04d64841692ce7dbc1876', '1', '28', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('f1c57edaf7e24fb5874346cfab09c8e8', '1', '34', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('f2e34c3dcff04c749d38f96e29ecc341', '3', '91', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('fb854024c7764f2bb964a8d4e777eec2', '5', '34', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('fb90e0c41ae34ef187461ad697c1e608', '6', '70', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('fca3325b36a9497b8e0f1f1718c9a120', '5', '84', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `kit_g_limit`
-- ----------------------------
DROP TABLE IF EXISTS `kit_g_limit`;
CREATE TABLE `kit_g_limit` (
  `limit_id` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '功能id',
  `limit_sequence` int(4) NOT NULL DEFAULT '50' COMMENT '排序',
  `limit_ico` varchar(50) NOT NULL COMMENT '图标',
  `limit_title` varchar(50) NOT NULL COMMENT '标题',
  `limit_action` varchar(100) NOT NULL COMMENT '路径',
  `limit_leaderid` int(5) NOT NULL DEFAULT '0' COMMENT '上级ID',
  `limit_system` int(2) NOT NULL DEFAULT '1' COMMENT '是否允许编辑，1：允许修改，2：不允许修改',
  PRIMARY KEY (`limit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COMMENT='功能表';

-- ----------------------------
-- Records of kit_g_limit
-- ----------------------------
INSERT INTO `kit_g_limit` VALUES ('1', '50', '&#xe614;', '系统工具', '/', '0', '2');
INSERT INTO `kit_g_limit` VALUES ('3', '2', '&#xe62a;', '菜单管理', '/gLimit/getGroup', '1', '2');
INSERT INTO `kit_g_limit` VALUES ('5', '4', '&#xe612;', '管理员管理', '/admin/getAll', '1', '2');
INSERT INTO `kit_g_limit` VALUES ('28', '1', '&#xe612;', '用户管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('29', '1', '&#xe613;', '老师管理', '/user/goTeacher', '28', '1');
INSERT INTO `kit_g_limit` VALUES ('30', '2', '&#xe613;', '学生管理', '/user/goStudent', '28', '1');
INSERT INTO `kit_g_limit` VALUES ('31', '3', '&#xe613;', '指导老师互选管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('33', '1', '&#xe615;', '查看指导老师', '/advise/golookAdvise', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('34', '2', '&#xe620;', '分配指导老师', '/advise/golookDistributionAdvise', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('35', '4', '&#xe63c;', '选题管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('36', '1', '&#xe615;', '查看学生选题', '/topic/goLookStudentTopic', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('41', '8', '&#xe613;', '答辩组管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('42', '2', '&#xe60a;', '公告管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('43', '9', '&#xe705;', '成绩管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('47', '1', '&#xe615;', '学生毕设成绩', '/score/goLookOneselfScore', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('48', '1', '&#xe61f;', '发布公告', '/notice/goReleaseNotice', '42', '1');
INSERT INTO `kit_g_limit` VALUES ('49', '2', '&#xe63c;', '公告', '/notice/goNotice', '42', '1');
INSERT INTO `kit_g_limit` VALUES ('50', '1', '&#xe620;', '答辩组设置', '/reply/goReplySet', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('58', '3', '&#xe613;', '角色权限分配', '/gGroup/getAll', '1', '2');
INSERT INTO `kit_g_limit` VALUES ('60', '3', '&#xe613;', '选择指导老师', '/advise/goAdvise', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('61', '4', '&#xe615;', '查看选择结果', '/advise/golookChoiceResult', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('62', '5', '&#xe613;', '查看申请学生', '/advise/golookApplyStudent', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('63', '6', '&#xe613;', '查看所带学生', '/advise/golookCrayyStudent', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('64', '2', '&#xe621;', '申请课题（自选）', '/topic/goApplyByOneself', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('65', '3', '&#xe60a;', '申请选题（选择导师给出的课题）', '/topic/goApplyByOther', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('66', '4', '&#xe609;', '上传选题', '/topic/goUploadTopic', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('68', '7', '&#xe620;', '导师上传课题管理', '/topic/goUploadTopicManagement', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('69', '6', '&#xe615;', '查看课题通过情况', '/topic/goLookApplyResult', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('70', '8', '&#xe620;', '学生申请课题管理', '/topic/goTopicManagement', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('71', '2', '&#xe615;', '查看所在答辩组', '/reply/goLookStayReplyGroup', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('73', '4', '&#xe60a;', '查看各阶段答辩结果', '/reply/goLookPhaseReplyResult', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('75', '6', '&#xe613;', '查看答辩组', '/reply/goLookReplyGroupInfo', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('76', '7', '&#xe6b2;', '答辩评审', '/reply/goReplyReview', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('77', '8', '&#xe615;', '查看全部答辩组', '/reply/goLookAllReplyGroup', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('78', '2', '&#xe615;', '查看所带学生毕设成绩', '/score/goLookStudentScore', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('79', '3', '&#xe61f;', '成绩录入（导师）', '/score/goEntryScoreByATeacher', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('81', '4', '&#xe61f;', '成绩录入（论文）', '/score/goEntryPaperScore', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('82', '5', '&#xe615;', '查看所在答辩组学生成绩', '/score/goLookReplyGroupStudentScore', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('83', '6', '&#xe615;', '查看所有学生的成绩', '/score/goLookAllStudentScore', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('84', '7', '&#xe618;', '最终成绩确认', '/score/goConfirmScore', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('85', '8', '&#xe61f;', '成绩录入（答辩成绩）', '/score/goEntryScoreByRTeacher', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('87', '9', '&#xe615;', '查看所有学生选题', '/topic/goLookAllStudentTopic', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('88', '7', '&#xe620;', '设置申请人数限制', '/advise/goSetLimitNumber', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('90', '9', '&#xe615;', '查看学生答辩成绩', '/reply/goLookStudentReplyScore', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('91', '10', '&#xe60a;', '查看所带学生的各阶段答辩成绩', 'reply/goLookOnselfStudentReplyScore', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('92', '11', '&#xe620;', '评审管理', '/reply/goReviewManagement', '41', '1');

-- ----------------------------
-- Table structure for `kit_web_setting`
-- ----------------------------
DROP TABLE IF EXISTS `kit_web_setting`;
CREATE TABLE `kit_web_setting` (
  `kit_web_id` int(11) NOT NULL AUTO_INCREMENT,
  `kit_web_name` varchar(50) NOT NULL COMMENT '网站名称',
  `kit_web_message` int(1) DEFAULT NULL COMMENT '短信设置（1：阿里大鱼，2：云之讯）',
  `kit_web_push` int(1) DEFAULT NULL COMMENT '推送设置（1：极光，2：云之讯）',
  `kit_web_file` int(1) DEFAULT NULL COMMENT '文件存储（1：本地，2：七牛云）',
  `kit_sige_size` int(1) DEFAULT NULL COMMENT '验证码位数',
  `kit_web_hellow_adv_size` int(2) DEFAULT NULL COMMENT '首次登录欢迎界面的显示个数（0-10之间）',
  `kit_sign_active_time` int(2) DEFAULT NULL COMMENT '验证码有效时间（单位分钟）',
  PRIMARY KEY (`kit_web_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='项目配置表，有且仅有一条数据，不要删除';

-- ----------------------------
-- Records of kit_web_setting
-- ----------------------------
INSERT INTO `kit_web_setting` VALUES ('1', '长大本科毕业设计', '1', '1', '2', '6', '3', '5');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `major_name` varchar(20) NOT NULL COMMENT '专业',
  `did` int(11) NOT NULL COMMENT '院部id',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '软件工程', '1');
INSERT INTO `major` VALUES ('2', '计算机科学与技术', '1');
INSERT INTO `major` VALUES ('3', '应用数学', '1');
INSERT INTO `major` VALUES ('4', '酒店管理', '2');
INSERT INTO `major` VALUES ('5', '工程管理', '2');
INSERT INTO `major` VALUES ('6', '市场营销', '2');
INSERT INTO `major` VALUES ('7', '财务管理', '2');
INSERT INTO `major` VALUES ('8', '市场营销', '2');
INSERT INTO `major` VALUES ('9', '财务管理', '2');
INSERT INTO `major` VALUES ('10', '物业管理', '2');
INSERT INTO `major` VALUES ('11', '公共事业管理', '2');
INSERT INTO `major` VALUES ('12', '物流管理', '2');
INSERT INTO `major` VALUES ('13', '旅游管理', '2');
INSERT INTO `major` VALUES ('14', '土木工程', '3');
INSERT INTO `major` VALUES ('15', '广播电视编导', '4');
INSERT INTO `major` VALUES ('16', '播音与主持艺术', '4');
INSERT INTO `major` VALUES ('17', '视觉传达设计', '4');
INSERT INTO `major` VALUES ('18', '动画', '4');
INSERT INTO `major` VALUES ('19', ' 服装与服饰设计', '4');
INSERT INTO `major` VALUES ('20', '美术', '5');
INSERT INTO `major` VALUES ('21', '生物工程', '6');
INSERT INTO `major` VALUES ('22', '环境工程', '6');
INSERT INTO `major` VALUES ('23', '生物制药', '6');
INSERT INTO `major` VALUES ('24', '电气工程及其自动化', '7');
INSERT INTO `major` VALUES ('25', '电子信息工程', '7');
INSERT INTO `major` VALUES ('26', '通信工程', '7');
INSERT INTO `major` VALUES ('27', '光电信息科学与工程', '7');
INSERT INTO `major` VALUES ('28', '英语', '8');
INSERT INTO `major` VALUES ('29', '日语', '8');
INSERT INTO `major` VALUES ('30', '翻译', '8');
INSERT INTO `major` VALUES ('31', '汉语言文学', '4');
INSERT INTO `major` VALUES ('32', '新闻学', '4');
INSERT INTO `major` VALUES ('33', '功能材料', '9');
INSERT INTO `major` VALUES ('34', '机械设计制造及其自动化', '9');
INSERT INTO `major` VALUES ('35', '材料成型及控制工程', '9');
INSERT INTO `major` VALUES ('36', '汽车服务工程', '9');
INSERT INTO `major` VALUES ('37', '法学', '10');
INSERT INTO `major` VALUES ('38', '音乐学', '10');
INSERT INTO `major` VALUES ('39', '马克思主义', '11');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '关于组织2018届毕业生毕业设计（论文、创作）“查重”检查的通知', '2018-04-13', 'http://jwc.ccsu.cn/info/1039/2348.htm');
INSERT INTO `notice` VALUES ('4', '数计系2017届优秀毕业生评选结果公示', '2017-01-09', 'http://jsxy.ccsu.cn/info/1121/1325.htm');
INSERT INTO `notice` VALUES ('5', '长沙学院2018届优秀毕业生评选公示', '2018-04-13', 'http://zsjy.ccsu.cn/info/1086/1921.htm');

-- ----------------------------
-- Table structure for `paper_score`
-- ----------------------------
DROP TABLE IF EXISTS `paper_score`;
CREATE TABLE `paper_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(255) DEFAULT NULL,
  `paper_score` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper_score
-- ----------------------------
INSERT INTO `paper_score` VALUES ('1', 'B20140304623', '80');
INSERT INTO `paper_score` VALUES ('2', 'B20140304624', '40');
INSERT INTO `paper_score` VALUES ('3', 'B20140304703', '59');
INSERT INTO `paper_score` VALUES ('4', 'B20140304704', '0');
INSERT INTO `paper_score` VALUES ('5', 'B20140304625', '90');

-- ----------------------------
-- Table structure for `pass_situation`
-- ----------------------------
DROP TABLE IF EXISTS `pass_situation`;
CREATE TABLE `pass_situation` (
  `id` int(11) NOT NULL,
  `passId` int(11) DEFAULT NULL,
  `pass_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pass_situation
-- ----------------------------
INSERT INTO `pass_situation` VALUES ('1', '0', '未审核');
INSERT INTO `pass_situation` VALUES ('2', '1', '通过');
INSERT INTO `pass_situation` VALUES ('3', '2', '未通过');

-- ----------------------------
-- Table structure for `reply_group`
-- ----------------------------
DROP TABLE IF EXISTS `reply_group`;
CREATE TABLE `reply_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(20) DEFAULT NULL,
  `group_leader_tid` varchar(255) DEFAULT NULL,
  `group_teacher_number` int(11) DEFAULT '0',
  `group_student_number` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_group
-- ----------------------------
INSERT INTO `reply_group` VALUES ('1', '1组', '20140304626', '2', '5');
INSERT INTO `reply_group` VALUES ('2', '2组', '20140304613', '1', '1');

-- ----------------------------
-- Table structure for `reply_group_student`
-- ----------------------------
DROP TABLE IF EXISTS `reply_group_student`;
CREATE TABLE `reply_group_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(255) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_group_student
-- ----------------------------
INSERT INTO `reply_group_student` VALUES ('1', 'B20140304623', '1');
INSERT INTO `reply_group_student` VALUES ('2', 'B20140304624', '1');
INSERT INTO `reply_group_student` VALUES ('3', 'B20140304703', '1');
INSERT INTO `reply_group_student` VALUES ('4', 'B20140304704', '1');
INSERT INTO `reply_group_student` VALUES ('5', 'B20140304625', '1');
INSERT INTO `reply_group_student` VALUES ('6', 'B2010304701', '2');

-- ----------------------------
-- Table structure for `reply_group_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `reply_group_teacher`;
CREATE TABLE `reply_group_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(255) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_group_teacher
-- ----------------------------
INSERT INTO `reply_group_teacher` VALUES ('1', '20140304624', '1');
INSERT INTO `reply_group_teacher` VALUES ('2', '20140304626', '1');
INSERT INTO `reply_group_teacher` VALUES ('3', '20140304613', '2');

-- ----------------------------
-- Table structure for `reply_review`
-- ----------------------------
DROP TABLE IF EXISTS `reply_review`;
CREATE TABLE `reply_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(255) DEFAULT NULL,
  `open_topic_score` int(11) DEFAULT NULL,
  `mid_score` int(11) DEFAULT NULL,
  `graduate_score` int(11) DEFAULT NULL,
  `tid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_review
-- ----------------------------

-- ----------------------------
-- Table structure for `reply_score`
-- ----------------------------
DROP TABLE IF EXISTS `reply_score`;
CREATE TABLE `reply_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(255) DEFAULT NULL,
  `open_topic_score` int(11) DEFAULT NULL,
  `mid_score` int(11) DEFAULT NULL,
  `graduate_score` int(11) DEFAULT NULL,
  `reply_score` int(11) DEFAULT NULL,
  `entry_status` int(11) DEFAULT '0' COMMENT '0-未录入，1-录入，2-不录入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_score
-- ----------------------------
INSERT INTO `reply_score` VALUES ('1', 'B20140304623', '70', '70', '70', '70', '1');
INSERT INTO `reply_score` VALUES ('2', 'B20140304625', '70', '80', '90', '80', '1');

-- ----------------------------
-- Table structure for `review_status`
-- ----------------------------
DROP TABLE IF EXISTS `review_status`;
CREATE TABLE `review_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(255) DEFAULT NULL,
  `open_topic_status` int(11) DEFAULT NULL,
  `mid_status` int(11) DEFAULT NULL,
  `graduate_status` int(11) DEFAULT NULL,
  `tid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review_status
-- ----------------------------

-- ----------------------------
-- Table structure for `sex`
-- ----------------------------
DROP TABLE IF EXISTS `sex`;
CREATE TABLE `sex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sex
-- ----------------------------
INSERT INTO `sex` VALUES ('1', '男');
INSERT INTO `sex` VALUES ('2', '女');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sid` varchar(255) NOT NULL COMMENT '学号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `password` varchar(20) DEFAULT '123456' COMMENT '密码',
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `did` int(11) DEFAULT NULL COMMENT '院部',
  `mid` int(11) DEFAULT NULL COMMENT '专业',
  `grade` varchar(20) DEFAULT NULL COMMENT '年级',
  `sclass` varchar(20) DEFAULT NULL COMMENT '班级',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `icon` varchar(255) DEFAULT 'uplodefiles/touxian.jpg' COMMENT '头像地址',
  `adviserid` int(11) DEFAULT NULL COMMENT '指导老师id',
  `replygroupid` int(11) DEFAULT NULL COMMENT '答辩组的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'B20140304623', '杨鹏', '123456', '1', '1', '1', '14级', '软件1班', '15673331257', '1791133899@qq.com', 'uplodefiles/image/e5d90ddb813a489393411298a1bf504f.jpeg', '3', '1');
INSERT INTO `student` VALUES ('2', 'B20140304624', '周树人', '123456', '1', '1', '1', '14级', '软件1班', '15673331257', '1791133899@sina.cn', 'uplodefiles/touxian.jpg', '3', null);
INSERT INTO `student` VALUES ('3', 'B20140304625', '香蕉', '123456', '1', '1', '1', '14级', '软件2班', '12315236123', '5162376152@sina.com', 'uplodefiles/touxian.jpg', '3', null);
INSERT INTO `student` VALUES ('4', 'B20140304626', '董金鑫', '123456', '1', '1', '1', '14级', '软件2班', '15673331246', '1791133866@123.com', 'uplodefiles/touxian.jpg', '3', null);
INSERT INTO `student` VALUES ('5', 'B20140304627', '谭禹谦', '123456', '1', '1', '1', '14级', '软件1班', '15673331738', '1791133866@163.com', 'uplodefiles/touxian.jpg', '3', null);
INSERT INTO `student` VALUES ('6', 'B20140304628', '任悦强', '123456', '1', '1', '1', '14级', '软件2班', '15673331894', '1791133864@qq.com', 'uplodefiles/touxian.jpg', '3', null);
INSERT INTO `student` VALUES ('7', 'B20140304629', '小白', '123456', '1', '1', '1', '14级', '数管1班', '15673331237', '17911346516@sina.com', 'uplodefiles/touxian.jpg', '3', null);
INSERT INTO `student` VALUES ('9', 'B2010304701', '小黑', '123456', '1', '2', '5', '14级', '2班', '15678945678', '1984615@sina.com', 'uplodefiles/touxian.jpg', '7', null);
INSERT INTO `student` VALUES ('10', 'B20140304703', '向维星', '123456', '1', '1', '1', '14', '软件2班', '15673331257', '1791133899@qq.com', 'uplodefiles/touxian.jpg', '3', null);
INSERT INTO `student` VALUES ('12', 'B20140304896', '小白', '123456', '2', '2', '5', '14', '2', '15673331257', '17911@qq.com', 'uplodefiles/touxian.jpg', '7', null);
INSERT INTO `student` VALUES ('13', 'B20140304678', '蓝宝', '123456', '2', '8', '29', '14', '3', '15673331257', '17911@qq.com', 'uplodefiles/touxian.jpg', null, null);
INSERT INTO `student` VALUES ('14', 'B20140304576', 'dadda', '123456', '2', '2', '7', '14', '6', '15673331257', '1811616@qq.com', 'uplodefiles/touxian.jpg', null, null);

-- ----------------------------
-- Table structure for `student_reply_score`
-- ----------------------------
DROP TABLE IF EXISTS `student_reply_score`;
CREATE TABLE `student_reply_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(255) DEFAULT NULL,
  `open_topic_score` int(11) DEFAULT NULL,
  `mid_score` int(11) DEFAULT NULL,
  `graduate_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_reply_score
-- ----------------------------
INSERT INTO `student_reply_score` VALUES ('2', 'B20140304623', '82', '85', '85');
INSERT INTO `student_reply_score` VALUES ('6', 'B20140304625', '70', '80', '90');

-- ----------------------------
-- Table structure for `student_score`
-- ----------------------------
DROP TABLE IF EXISTS `student_score`;
CREATE TABLE `student_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(255) DEFAULT NULL,
  `adviser_score` int(11) DEFAULT NULL,
  `reply_score` int(11) DEFAULT NULL,
  `paper_score` int(11) DEFAULT NULL,
  `total_score` int(11) DEFAULT NULL,
  `pass_status` int(11) DEFAULT NULL COMMENT '1-通过，2-未通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_score
-- ----------------------------
INSERT INTO `student_score` VALUES ('1', 'B20140304623', '70', '70', '80', '73', '1');
INSERT INTO `student_score` VALUES ('3', 'B20140304625', '40', '80', '90', '62', '1');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tid` varchar(255) NOT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT '123456',
  `sex` int(2) DEFAULT NULL,
  `work_time` varchar(20) DEFAULT NULL,
  `hdegree` varchar(20) DEFAULT NULL,
  `teaching_direction` varchar(20) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `icon` varchar(255) DEFAULT 'uplodefiles/touxian.jpg',
  `did` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `identity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('3', '20140304625', '白展堂', '123456', '1', '1年', '博士', 'javaweb开发', '高级程序员', 'uplodefiles/touxian.jpg', '1', '1', '3');
INSERT INTO `teacher` VALUES ('4', '20140304624', '王晓燕', '123456', '2', '3年', '硕士', 'C语言', '高级架构师', 'uplodefiles/touxian.jpg', '1', '1', '4');
INSERT INTO `teacher` VALUES ('5', '20140304626', '独孤求败', '123456', '1', '5年', '硕士', '计算机网络', '教授', 'uplodefiles/touxian.jpg', '1', '1', '6');
INSERT INTO `teacher` VALUES ('7', '20140304789', '董笑笑', '123456', '1', '2年', '本科', '金融', '副教授', 'uplodefiles/touxian.jpg', '2', '6', '3');
INSERT INTO `teacher` VALUES ('11', '20140304663', '周笑笑', '123456', '1', '4年', '本科', '建筑', '副教授', 'uplodefiles/touxian.jpg', '3', '14', '3');
INSERT INTO `teacher` VALUES ('16', '20140304613', '绝无神', '123456', '1', '5年 ', '硕士', 'C语言', '教授', 'uplodefiles/touxian.jpg', '2', '8', '6');

-- ----------------------------
-- Table structure for `teacher_contact`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_contact`;
CREATE TABLE `teacher_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_contact
-- ----------------------------
INSERT INTO `teacher_contact` VALUES ('1', '20140304625', '15673331389', '1564874519@qq.com');
INSERT INTO `teacher_contact` VALUES ('2', '20140304624', '15673331257', '194616@qq.com');
INSERT INTO `teacher_contact` VALUES ('3', '20140304626', '1567331257', '19416165@qq.com');
INSERT INTO `teacher_contact` VALUES ('4', '20140304789', '15673331257', '179115@qq.com');
INSERT INTO `teacher_contact` VALUES ('8', '20140304663', '15673331257', '1791651@qq.com');
INSERT INTO `teacher_contact` VALUES ('13', '20140304613', '15673331257', 'adnuandanu@qq.com');

-- ----------------------------
-- Table structure for `teacher_topic`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_topic`;
CREATE TABLE `teacher_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(255) DEFAULT NULL,
  `tid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_topic
-- ----------------------------
INSERT INTO `teacher_topic` VALUES ('1', '蛋糕店', '20140304625');
INSERT INTO `teacher_topic` VALUES ('3', '文件管理系统', '20140304625');
INSERT INTO `teacher_topic` VALUES ('4', '小游戏对战平台', '20140304625');

-- ----------------------------
-- Table structure for `topic_apply`
-- ----------------------------
DROP TABLE IF EXISTS `topic_apply`;
CREATE TABLE `topic_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '0-自选,1-他选',
  `pass_situation` int(11) DEFAULT '0' COMMENT '0-未审核，1-通过，2-未通过',
  `attachment_name` varchar(255) DEFAULT NULL,
  `attachment_url` varchar(255) DEFAULT NULL,
  `sid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_apply
-- ----------------------------
INSERT INTO `topic_apply` VALUES ('3', '超市管理系统', '1', '1', '毕业设计课题申报表样版-杨鹏.xls', 'f29ffa059e464c60bac9594a28c83af8.xls', 'B20140304624');
INSERT INTO `topic_apply` VALUES ('4', '小黑', '0', '1', '毕业设计课题申报表样版-杨鹏.xls', '19a5e1a97aa04fb4ab6d596acdafc071.xls', 'B20140304623');
INSERT INTO `topic_apply` VALUES ('8', '文件管理系统', '1', '1', '毕业设计课题申报表样版-杨鹏.xls', '035a9151a78e4f4f99b43ba5667d0f62.xls', 'B20140304625');

-- ----------------------------
-- Table structure for `types`
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `id` int(11) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `type_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '0', '他选');
INSERT INTO `types` VALUES ('2', '1', '他选');
