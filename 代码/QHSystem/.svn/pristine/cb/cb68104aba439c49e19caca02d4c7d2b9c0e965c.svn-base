/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : qh_db

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2014-10-03 09:04:30
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
  `disabled` tinyint(1) DEFAULT NULL,
  `limitCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_name` (`name`),
  UNIQUE KEY `uq_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `caller`
-- ----------------------------
DROP TABLE IF EXISTS `caller`;
CREATE TABLE `caller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_caller_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;



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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;



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
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `window`
-- ----------------------------
DROP TABLE IF EXISTS `window`;
CREATE TABLE `window` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `business_id` int(11) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nq_num` (`num`) USING BTREE,
  KEY `fk_window_bussiness` (`business_id`),
  CONSTRAINT `fk_window_bussiness` FOREIGN KEY (`business_id`) REFERENCES `business` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


