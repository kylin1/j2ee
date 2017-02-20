/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50505
 Source Host           : localhost
 Source Database       : j2eeProject

 Target Server Type    : MySQL
 Target Server Version : 50505
 File Encoding         : utf-8

 Date: 02/18/2017 13:40:17 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `approval`
-- ----------------------------
DROP TABLE IF EXISTS `approval`;
CREATE TABLE `approval` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelid` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `mainContent` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_approval` (`hotelid`),
  CONSTRAINT `fk_approval` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `expenditure`
-- ----------------------------
DROP TABLE IF EXISTS `expenditure`;
CREATE TABLE `expenditure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelid` int(11) NOT NULL,
  `date` date NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_expenditure` (`hotelid`),
  CONSTRAINT `fk_expenditure` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `hotel`
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hotel`
-- ----------------------------
BEGIN;
INSERT INTO `hotel` VALUES ('2', 'test', 'test', 'test', 'test', '1');
COMMIT;

-- ----------------------------
--  Table structure for `hotel_room`
-- ----------------------------
DROP TABLE IF EXISTS `hotel_room`;
CREATE TABLE `hotel_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room` varchar(255) NOT NULL,
  `hotelid` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `date` date NOT NULL,
  `status` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hotel_room` (`hotelid`),
  CONSTRAINT `fk_hotel_room` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `bankCard` varchar(255) DEFAULT NULL,
  `activatedTime` date DEFAULT NULL,
  `expireTime` date DEFAULT NULL,
  `consume` int(11) NOT NULL DEFAULT '0',
  `balance` int(11) NOT NULL DEFAULT '0',
  `level` int(11) NOT NULL DEFAULT '0',
  `score` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `hotelid` int(11) NOT NULL,
  `orderTime` date NOT NULL,
  `checkIn` date NOT NULL,
  `checkOut` date NOT NULL,
  `roomType` int(11) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `contactName` varchar(255) NOT NULL,
  `contactPhone` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `isMember` int(11) DEFAULT NULL,
  `isCash` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order` (`userid`),
  KEY `fk_order_1` (`hotelid`),
  CONSTRAINT `fk_order` FOREIGN KEY (`userid`) REFERENCES `member` (`id`),
  CONSTRAINT `fk_order_1` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `payment`
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `time` date NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment` (`hotelid`),
  KEY `fk_payment_1` (`userid`),
  CONSTRAINT `fk_payment` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`),
  CONSTRAINT `fk_payment_1` FOREIGN KEY (`userid`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `room_guest`
-- ----------------------------
DROP TABLE IF EXISTS `room_guest`;
CREATE TABLE `room_guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `date` date NOT NULL,
  `roomid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `idNum` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_room_guest` (`orderid`),
  KEY `fk_room_guest_1` (`roomid`),
  CONSTRAINT `fk_room_guest` FOREIGN KEY (`orderid`) REFERENCES `order` (`id`),
  CONSTRAINT `fk_room_guest_1` FOREIGN KEY (`roomid`) REFERENCES `hotel_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
