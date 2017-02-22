/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50505
 Source Host           : localhost
 Source Database       : springdemo

 Target Server Type    : MySQL
 Target Server Version : 50505
 File Encoding         : utf-8

 Date: 02/22/2017 17:17:33 PM
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
  CONSTRAINT `FKbsfyubv0tf6kk49eo71ob5nll` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`),
  CONSTRAINT `fk_approval` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `approval`
-- ----------------------------
BEGIN;
INSERT INTO `approval` VALUES ('1', '1', '1', '1', '1', '1'), ('2', '1', '1', '2', '2', '2');
COMMIT;

-- ----------------------------
--  Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `pub_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `FKpxk2jtysqn41oop7lvxcp6dqq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `blog`
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES ('3', 'KYLIN', 'KYLIN', '3', '2016-10-10'), ('4', 'test2', 'tese2', '1', '2013-12-12');
COMMIT;

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
  CONSTRAINT `FKtc8iwknkvc0ybnpbko14442c0` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`),
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
INSERT INTO `hotel` VALUES ('1', '111', '111', 'hotel1', '111', '1'), ('2', 'test', 'test', 'test', 'test', '1');
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
  CONSTRAINT `FKng8xd6tn98w44vuv15tb65mi3` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`),
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
  CONSTRAINT `FKjq1wh48161k0tdpm104amxkoa` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FKt0v31t3pvx0iab8wcdtif6p9d` FOREIGN KEY (`userid`) REFERENCES `member` (`id`),
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
  CONSTRAINT `FK724b9cgmafartimnk15r002dj` FOREIGN KEY (`roomid`) REFERENCES `hotel_room` (`id`),
  CONSTRAINT `FK8ed6ctdqyp4j9he8jbpuwrs4e` FOREIGN KEY (`orderid`) REFERENCES `user_order` (`id`),
  CONSTRAINT `fk_room_guest` FOREIGN KEY (`orderid`) REFERENCES `user_order` (`id`),
  CONSTRAINT `fk_room_guest_1` FOREIGN KEY (`roomid`) REFERENCES `hotel_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'Steve', 'gaussic2', 'Steve', 'NoJob'), ('2', 'Bill', '111111', 'Bill', 'Gates'), ('3', 'Mark', '22222', 'Mark', 'Zuckerberg'), ('4', 'gauss', '11111111', 'Gaussic', 'D'), ('5', 'test', '123', '123', '123');
COMMIT;

-- ----------------------------
--  Table structure for `user_order`
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
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
  CONSTRAINT `FK8u7r2rx9eubqptxywrfp7du4e` FOREIGN KEY (`userid`) REFERENCES `member` (`id`),
  CONSTRAINT `FKiel9iow4qanugo7uiujodqo17` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`),
  CONSTRAINT `fk_order` FOREIGN KEY (`userid`) REFERENCES `member` (`id`),
  CONSTRAINT `fk_order_1` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
