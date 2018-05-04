/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : gdms

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-05-03 23:59:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '计算机工程与应用数学学院');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identity
-- ----------------------------
INSERT INTO `identity` VALUES ('1', '1', '超级管理员', '1');
INSERT INTO `identity` VALUES ('2', '2', '学生', '2');
INSERT INTO `identity` VALUES ('3', '3', '指导老师', '3');
INSERT INTO `identity` VALUES ('4', '4', '答辩老师', '4');
INSERT INTO `identity` VALUES ('5', '5', '管理员', '5');

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
INSERT INTO `kit_admin` VALUES ('1', 'admin', 'admin', 'admin', 'uplodefiles/touxian.jpg', '1');
INSERT INTO `kit_admin` VALUES ('2', '123456', '123456', '李白', 'uplodefiles/touxian.jpg', '5');

-- ----------------------------
-- Table structure for `kit_g_group`
-- ----------------------------
DROP TABLE IF EXISTS `kit_g_group`;
CREATE TABLE `kit_g_group` (
  `group_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '分组id',
  `group_name` varchar(50) DEFAULT NULL COMMENT '分组名字',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kit_g_group
-- ----------------------------
INSERT INTO `kit_g_group` VALUES ('1', '超级管理员');
INSERT INTO `kit_g_group` VALUES ('2', '学生');
INSERT INTO `kit_g_group` VALUES ('3', '指导老师');
INSERT INTO `kit_g_group` VALUES ('4', '答辩老师');
INSERT INTO `kit_g_group` VALUES ('5', '管理员');

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
INSERT INTO `kit_g_group_limit` VALUES ('008a6c8ea4ea41219c3fc39d90940be0', '1', '3', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('017ca7737e3c4be5affcaa1af03eb697', '3', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('0ac3a0b9d95a4919ad88b2ec2e2981b7', '2', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('0b48ad7bd435482eb75005c5bf32426e', '5', '30', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('0c464b45aefb4915bfea236b2954485a', '4', '44', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('0ebea47145dd4da5852d1cbd90b77f18', '1', '2', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('116161', '1', '31', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1243bade27f04411bc8619d1700ab54a', '2', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('12b2d09ff5d2416dba5eaff4268c5de4', '5', '34', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('137db35999264813bb0a6c05164ff821', '4', '47', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('14615941', '1', '36', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('146161646', '1', '40', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('154161616', '1', '49', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('16161', '1', '32', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('16161132216', '1', '33', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('16516165', '1', '34', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('181654949841', '1', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('19416161', '1', '44', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1986165464', '1', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1d9qa1sda1sd61ad1', '1', '28', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1dff970a7b2248f9a5eb6e86b147fbcd', '1', '24', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1e073f47a9a0442798464918a258661d', '2', '38', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1e94ce110e434620b0d0ce7610effec9', '4', '46', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('1ee01456c61a4ec7a4d91491e8d9caa9', '1', '22', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('20e95fcca7a34073bbbd419cc8fb6f7d', '1', '23', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('21d73a1fd9e84ae58658ebdb281e4016', '4', '57', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('21e182e806f64310b3498707245f9077', '5', '38', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('22598d95bd7a45678468037d7f5b6001', '3', '31', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('227ba9c785b64853910d263efe04c699', '3', '52', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('23b7fb3633534760a42de24ed8e6fa2d', '5', '42', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('24856165165', '1', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('24cf7d2ebcdd4b788e442d413154b156', '4', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('272fb1eb935946548a51fe0c48184048', '5', '50', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('2a10bc9434cf440f81936537184eb7d1', '2', '56', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('2a56713e3ae341df8c2343caac33d6b6', '2', '52', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('2c45be9fe08a4a6396d1827a37b3028d', '2', '53', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('35f5a400c42343ebb6bd756d9dd9d275', '3', '40', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('369efdb347754f829d936d97a2584f0a', '1', '1', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('3a23d8438cef4ed1a25e743bc023e177', '3', '46', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('3b7da8c354214f7e913d8c4172cb524f', '3', '47', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('3c26653ccf3244688ad885bf36131ccd', '1', '4', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('3fde392fe128400f9f4fad12ddb260ef', '5', '48', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('4142078c018047ed8b3d347de9554034', '5', '40', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('45c64a1812e4471f926797e0e513f5b5', '4', '40', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('466161613', '1', '46', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('4916541646546', '1', '39', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('4961616166', '1', '42', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('49849516519', '1', '38', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('506826be7bcd471e85e4f29020c4b804', '4', '38', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('519dc9092d69447381d491ca8dfda48c', '4', '50', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('5393e57359874645b62a8a3a09defca2', '4', '39', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('567d21b0fea546d396119cc51a80427c', '2', '46', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('5ba7ebaca72147daa52b32c2c404b40e', '3', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('5dec6da26944491fb0e1349ba3617199', '2', '55', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('62084c7646a14c6182d876117492ae38', '3', '44', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('637ec5ed87e840ebafdd47e6269df1a0', '3', '51', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('6506e2be404a4811a59a3465c31237c9', '5', '31', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('651655131', '1', '47', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('6592fa60b1854116815668b122ce8b26', '2', '50', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('684b8b6e0c564c719420ddd6a781c210', '2', '31', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('6a1ada14b4e5479cba48978a00146e1e', '1', '21', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('6ce695a3e9b3407fa9aba75e870357c3', '5', '39', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('6e51c8177d2749948e28a273823c6d27', '5', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('6f6bce78c89e4839b30f74b09582b38b', '3', '53', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('72fa86934868452099da15576bb505e4', '5', '46', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('782c4a7fc128479d9295cfbc13f07f88', '5', '43', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('783be4fec0d84df5aa8661e4316bd8f7', '5', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('7b5c32312b66449d87103970cac8f6b8', '5', '44', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('7da2ccd0c01f408893085a2047bb4145', '1', '19', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('8465165416', '1', '48', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('86417b10c0624884809064b94ee05343', '5', '29', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('8c656190288746f5956424b832bb7719', '5', '52', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('90ec337a31f84591a725b79bffcd2369', '4', '41', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('941ba01f755343f388218ca1e5e64230', '2', '39', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('9942425e93704f0f8dfca66f88d829a0', '3', '56', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('9feb144474ae4da9afdcb429890fac45', '5', '32', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('a7209e27cb6b46338c275c91eb6bcb4a', '2', '57', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('a8830bfb34624aab88fa398059890d9a', '4', '56', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('a90390d627b84d01a0b41a50dd4eecf8', '3', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('a9fcc967c28342838da322bd95603a88', '5', '51', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('aa07b88b26a9476fa9177fd7809ea654', '2', '33', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('aaa75a70033840999d2ecb1874615897', '4', '55', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('aca8950c976d480698df8059ec6c24ec', '1', '5', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('af10aa0336854f59b508f925e6029f2a', '2', '47', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ansudbnaksjdn', '1', '55', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b48f5076ccc94c73b86bddf5d3cbd9ef', '5', '33', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b55a90f9c72a4f1986905d66f2190c4f', '2', '36', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b742fcbc64554c97a2019cf414401462', '2', '35', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b9002a2f37d242c28fe5a7f3cd1628dd', '2', '34', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('b9b77594faba46d19d78e430566a1446', '5', '49', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ba29d09a7b9945eb8bda6c399d9ef020', '1', '16', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('baffcfc6199545328ef362c1c9cfa20c', '2', '44', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('bd41ed9aa197402eb7765bf10d9e5951', '3', '38', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('bf4566ee8ce045e68c0894843e96df42', '3', '55', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('bf6cc75d26a342278b90136a463c2336', '5', '53', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('bfec5f6a23ec475e837aaea6f7200a3f', '2', '40', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('c73ecf0076c547439997ef44cfd3ca58', '5', '57', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('cd11aedf033a4d06b3fce690bad64a7c', '1', '25', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('d396f9ee124d4256b4d2b4f85457c191', '3', '57', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('d5b2b658d87341dfa06b58c667650c87', '3', '50', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('d846aed054ef4d139722a03c51e37efc', '5', '36', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('d9f9e03ce5de48df958445beed4b0acd', '3', '36', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('dabdsuabdjabd', '1', '56', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('dadbajkdb', '1', '50', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('daniudbaiwbdiqb', '1', '52', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('daniusdnqidnbijqnd', '1', '53', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('daudbjsabdkjabdkj', '1', '58', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('dausdbqjbdjbaj', '1', '51', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('dbf03e890d9241b18048faf8cb58ae7c', '3', '34', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('dbf674e16d4f406bafd3621d5b20834a', '3', '33', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('dnausbdiasd1ad61asd651a65', '1', '30', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('dniasndiansd1as6d1a6s1d', '1', '29', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e222519078364dc18c5f624caa86fb15', '3', '39', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e5b62e769a93416eb6c4d0e2ab082aaf', '4', '51', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e5e88d8efc904a4d937c979c515d820c', '1', '20', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e624f188d8fb427cb3925f47ddfc2014', '2', '51', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e81e871aee32463e916766b7d676d80a', '4', '53', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('e84534143b0546faa0a294d2ec77d5cf', '4', '52', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ee1915b036bb44408e7323f7fe1cfde5', '5', '56', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('eea266c03fc34bcb8f0697d461b8b06a', '5', '28', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('ehauydabsdub', '1', '57', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('f3db0ab6887849fbb9b03e43bc8c3df2', '5', '55', '1', '1', '1', '1');
INSERT INTO `kit_g_group_limit` VALUES ('f4c7e6088aee4c738e24d213f951e7dc', '5', '47', '1', '1', '1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='功能表';

-- ----------------------------
-- Records of kit_g_limit
-- ----------------------------
INSERT INTO `kit_g_limit` VALUES ('1', '50', '&#xe614;', '系统工具', '/', '0', '2');
INSERT INTO `kit_g_limit` VALUES ('3', '2', '&#xe62a;', '菜单管理', '/gLimit/getGroup', '1', '2');
INSERT INTO `kit_g_limit` VALUES ('5', '4', '&#xe612;', '管理员管理', '/admin/getAll', '1', '2');
INSERT INTO `kit_g_limit` VALUES ('28', '1', '&#xe612;', '用户管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('29', '1', '&#xe613;', '老师管理', '/user/teacher', '28', '1');
INSERT INTO `kit_g_limit` VALUES ('30', '2', '&#xe613;', '学生管理', '/user/student', '28', '1');
INSERT INTO `kit_g_limit` VALUES ('31', '3', '&#xe613;', '指导老师互选管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('32', '3', '&#xe620;', '老师身份管理', '/user/setTeacherIdentity', '28', '1');
INSERT INTO `kit_g_limit` VALUES ('33', '1', '&#xe615;', '查看指导老师', '/selectAdviserTeacher', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('34', '2', '&#xe620;', '分配指导老师', '/adviser/allotTeacher', '31', '1');
INSERT INTO `kit_g_limit` VALUES ('35', '4', '&#xe63c;', '选题管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('36', '1', '&#xe615;', '查看学生选题', '/topic/selectStudentTopic', '35', '1');
INSERT INTO `kit_g_limit` VALUES ('38', '5', '&#xe7a0;', '开题答辩', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('39', '6', '&#xe7a0;', '中期答辩', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('40', '7', '&#xe7a0;', '毕业答辩', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('41', '8', '&#xe613;', '答辩组管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('42', '2', '&#xe60a;', '公告管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('43', '9', '&#xe705;', '成绩管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('44', '10', '&#xe611;', '交流管理', '/', '0', '1');
INSERT INTO `kit_g_limit` VALUES ('46', '1', '&#xe638;', '长大毕设论坛', '/BBS', '44', '1');
INSERT INTO `kit_g_limit` VALUES ('47', '1', '&#xe621;', '学生毕设成绩', '/score/selectStudentScore', '43', '1');
INSERT INTO `kit_g_limit` VALUES ('48', '1', '&#xe61f;', '发布公告', '/notice/insertNotice', '42', '1');
INSERT INTO `kit_g_limit` VALUES ('49', '2', '&#xe63c;', '公告', '/notice/lookAllNotice', '42', '1');
INSERT INTO `kit_g_limit` VALUES ('50', '1', '&#xe620;', '答辩组设置', '/', '41', '1');
INSERT INTO `kit_g_limit` VALUES ('51', '1', '&#xe61f;', '发布开题答辩资料', '/', '38', '1');
INSERT INTO `kit_g_limit` VALUES ('52', '2', '&#xe620;', '开题答辩资料', '/', '38', '1');
INSERT INTO `kit_g_limit` VALUES ('53', '1', '&#xe61f;', '发布中期答辩资料', '/', '39', '1');
INSERT INTO `kit_g_limit` VALUES ('55', '1', '&#xe61f;', '发布毕业答辩资料', '/', '40', '1');
INSERT INTO `kit_g_limit` VALUES ('56', '2', '&#xe62d;', '毕业答辩资料', '/', '40', '1');
INSERT INTO `kit_g_limit` VALUES ('57', '2', '&#xe62d;', '中期答辩资料', '/', '39', '1');
INSERT INTO `kit_g_limit` VALUES ('58', '3', '&#xe613;', '角色权限分配', '/gGroup/getAll', '1', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '软件工程', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'B20140304623', '杨鹏', '123456', '1', '1', '1', '14级', '软件1班', '15673331257', '1791133899@qq.com', 'uplodefiles/touxian.jpg', '1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '20140304625', '大刀', '123456', '1', '5年', '硕士', 'Javaweb开发', '高级程序员', 'uplodefiles/touxian.jpg', '1', '1', '3');
