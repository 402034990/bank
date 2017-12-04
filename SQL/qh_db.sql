/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : qh_db

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2014-08-22 15:45:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `business`
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(5) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT '1',
  `limitCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_name` (`name`),
  UNIQUE KEY `uq_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('24', '1', 'vip业务', '1', '11');
INSERT INTO `business` VALUES ('25', '2', '普通业务', '1', '6');

-- ----------------------------
-- Table structure for `caller`
-- ----------------------------
DROP TABLE IF EXISTS `caller`;
CREATE TABLE `caller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_caller_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of caller
-- ----------------------------
INSERT INTO `caller` VALUES ('3', 'yy', 'asd', '1', '1');
INSERT INTO `caller` VALUES ('5', 'qq', 'qq1', '1', '1');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_manager_account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'root', 'root', 'root', '1');

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `business_id` int(11) DEFAULT NULL,
  `takeDate` datetime DEFAULT NULL,
  `waitCount` int(11) DEFAULT NULL,
  `takeIP` varchar(20) DEFAULT NULL,
  `callerId` int(11) DEFAULT NULL,
  `isCalled` tinyint(1) DEFAULT '0',
  `isSuccess` tinyint(1) DEFAULT NULL,
  `caller_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_business` (`business_id`),
  KEY `fk_ticket_caller` (`callerId`),
  KEY `fk_ticket_window` (`num`),
  CONSTRAINT `fk_ticket_business` FOREIGN KEY (`business_id`) REFERENCES `business` (`id`),
  CONSTRAINT `fk_ticket_caller` FOREIGN KEY (`callerId`) REFERENCES `caller` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('1', '1', '24', '2014-08-22 14:02:46', '1', '-1', '3', '1', '1', 'asd');
INSERT INTO `ticket` VALUES ('2', '1', '24', '2014-08-22 14:02:47', '1', '-1', '3', '1', '0', 'asd');
INSERT INTO `ticket` VALUES ('3', '-1', '24', '2014-08-22 14:02:49', '1', '-1', null, '0', null, null);
INSERT INTO `ticket` VALUES ('4', '2', '25', '2014-08-22 14:05:14', '1', '-1', '5', '1', '1', 'qq1');
INSERT INTO `ticket` VALUES ('5', '-1', '25', '2014-08-22 14:05:21', '1', '-1', null, '0', null, null);
INSERT INTO `ticket` VALUES ('6', '-1', '25', '2014-08-22 14:06:20', '1', '-1', null, '0', null, null);
INSERT INTO `ticket` VALUES ('7', '-1', '25', '2014-08-22 14:11:54', '1', '-1', null, '0', null, null);

-- ----------------------------
-- Table structure for `window`
-- ----------------------------
DROP TABLE IF EXISTS `window`;
CREATE TABLE `window` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `business_id` int(11) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nq_num` (`num`) USING BTREE,
  KEY `fk_window_bussiness` (`business_id`),
  CONSTRAINT `fk_window_bussiness` FOREIGN KEY (`business_id`) REFERENCES `business` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of window
-- ----------------------------
INSERT INTO `window` VALUES ('3', '1', '24', '1');
INSERT INTO `window` VALUES ('4', '2', '25', '1');
