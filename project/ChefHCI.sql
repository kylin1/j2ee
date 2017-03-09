/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50505
 Source Host           : localhost
 Source Database       : Chef

 Target Server Type    : MySQL
 Target Server Version : 50505
 File Encoding         : utf-8

 Date: 03/05/2017 23:55:41 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bowl`
-- ----------------------------
DROP TABLE IF EXISTS `bowl`;
CREATE TABLE `bowl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `is_return` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `bowl_ibfk_1` (`user_id`),
  CONSTRAINT `bowl_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bowl`
-- ----------------------------
BEGIN;
INSERT INTO `bowl` VALUES ('1', '1', '1'), ('2', '2', '1'), ('3', '3', '1');
COMMIT;

-- ----------------------------
--  Table structure for `custom_menu`
-- ----------------------------
DROP TABLE IF EXISTS `custom_menu`;
CREATE TABLE `custom_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `time` datetime NOT NULL,
  `flavor` varchar(244) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `menu_ifbk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `custom_menu`
-- ----------------------------
BEGIN;
INSERT INTO `custom_menu` VALUES ('1', '2', 'test', '2016-12-13 16:15:27', 'test'), ('2', '2', 'customer menu2', '2016-12-12 19:47:29', 'a bitter one'), ('3', '3', 'customer menu3', '2016-12-12 19:48:09', 'a sweet one'), ('6', '2', 'test', '2016-12-13 15:55:26', 'test'), ('7', '2', 'test', '2016-12-13 15:55:45', 'test'), ('8', '2', 'test', '2016-12-13 16:15:27', 'test'), ('9', '1', 'new menu1', '2016-12-15 23:45:49', 'flavor1');
COMMIT;

-- ----------------------------
--  Table structure for `custom_menu_food`
-- ----------------------------
DROP TABLE IF EXISTS `custom_menu_food`;
CREATE TABLE `custom_menu_food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(3) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `price` decimal(10,5) NOT NULL,
  `picture` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `custom_menu_food`
-- ----------------------------
BEGIN;
INSERT INTO `custom_menu_food` VALUES ('1', '1', 'rice', '3.00000', 'http://106.14.238.63/images/someFood.jpg'), ('2', '1', 'bread', '3.00000', 'http://106.14.238.63/images/someFood.jpg'), ('3', '2', 'chiken', '15.00000', 'http://106.14.238.63/images/someFood.jpg'), ('4', '2', 'beef', '15.00000', 'http://106.14.238.63/images/someFood.jpg'), ('5', '3', 'tomato', '5.00000', 'http://106.14.238.63/images/someFood.jpg'), ('6', '3', 'patato', '5.00000', 'http://106.14.238.63/images/someFood.jpg'), ('7', '4', 'little dish1', '10.00000', 'http://106.14.238.63/images/someFood.jpg'), ('8', '4', 'little dish2', '10.00000', 'http://106.14.238.63/images/someFood.jpg'), ('9', '5', 'sauce1', '5.00000', 'http://106.14.238.63/images/someFood.jpg'), ('10', '5', 'sauce2', '5.00000', 'http://106.14.238.63/images/someFood.jpg'), ('11', '6', 'flavor1', '0.00000', 'http://106.14.238.63/images/someFood.jpg'), ('12', '6', 'flavor2', '0.00000', 'http://106.14.238.63/images/someFood.jpg'), ('13', '6', 'flavor3', '0.00000', 'http://106.14.238.63/images/someFood.jpg'), ('14', '5', 'test', '55.50000', 'http://106.14.238.63/images/someFood.jpg'), ('15', '5', 'test', '55.50000', 'http://106.14.238.63/images/someFood.jpg'), ('16', '5', 'test', '55.50000', 'http://106.14.238.63/images/someFood.jpg'), ('17', '5', 'test', '55.50000', 'http://106.14.238.63/images/someFood.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `custom_menu_list`
-- ----------------------------
DROP TABLE IF EXISTS `custom_menu_list`;
CREATE TABLE `custom_menu_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  `number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `menu_id` (`menu_id`),
  KEY `menu_id_2` (`menu_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `menu_list_ifbk1` FOREIGN KEY (`menu_id`) REFERENCES `custom_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `menu_list_ifbk2` FOREIGN KEY (`food_id`) REFERENCES `custom_menu_food` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `custom_menu_list`
-- ----------------------------
BEGIN;
INSERT INTO `custom_menu_list` VALUES ('4', '1', '1', '1'), ('5', '1', '2', '2'), ('6', '1', '3', '3'), ('7', '1', '4', '4'), ('8', '2', '1', '2'), ('9', '2', '2', '3'), ('10', '3', '1', '3'), ('11', '1', '1', '2'), ('12', '1', '1', '2'), ('13', '1', '1', '2'), ('20', '9', '1', '1'), ('21', '9', '3', '1'), ('22', '9', '5', '2'), ('23', '9', '9', '1'), ('24', '9', '7', '2'), ('25', '9', '11', '1');
COMMIT;

-- ----------------------------
--  Table structure for `custom_order`
-- ----------------------------
DROP TABLE IF EXISTS `custom_order`;
CREATE TABLE `custom_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `menu_id` int(11) NOT NULL,
  `is_finish` tinyint(2) NOT NULL DEFAULT '0',
  `ticket_info` tinyint(2) NOT NULL,
  `pay_type` tinyint(2) NOT NULL,
  `bowl_info` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `cus_order_ifbk1` FOREIGN KEY (`menu_id`) REFERENCES `custom_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `custom_order`
-- ----------------------------
BEGIN;
INSERT INTO `custom_order` VALUES ('1', '2016-12-17 16:02:36', '2', '0', '1', '1', '1'), ('2', '2016-12-17 16:17:33', '1', '0', '1', '1', '1'), ('3', '2016-12-17 16:17:46', '1', '1', '1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `easy_order`
-- ----------------------------
DROP TABLE IF EXISTS `easy_order`;
CREATE TABLE `easy_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `easy_order_ibfk_1` (`user_id`),
  KEY `easy_order_ibfk_2` (`order_id`),
  CONSTRAINT `easy_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `easy_order_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `easy_order`
-- ----------------------------
BEGIN;
INSERT INTO `easy_order` VALUES ('3', '2', '2'), ('16', '3', '3'), ('17', '4', '1');
COMMIT;

-- ----------------------------
--  Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT '',
  `price` decimal(10,5) NOT NULL,
  `like` int(11) NOT NULL DEFAULT '0',
  `dislike` int(11) NOT NULL DEFAULT '0',
  `type_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `food_ibfk_1` (`type_id`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `food_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `food`
-- ----------------------------
BEGIN;
INSERT INTO `food` VALUES ('1', 'my 1', 'http://106.14.238.63/images/salad.jpg', '10.00000', '36', '3', '1', 'des'), ('2', 'salad2', 'http://106.14.238.63/images/salad.jpg', '12.00000', '30', '4', '1', 'salad'), ('3', 'noddle', 'http://106.14.238.63/images/noddle.jpg', '8.00000', '34', '3', '2', 'delicious noddle'), ('4', 'noddle', 'http://106.14.238.63/images/noddle.jpg', '8.00000', '34', '3', '2', 'delicious noddle'), ('5', 'noddle', 'http://106.14.238.63/images/noddle.jpg', '8.00000', '34', '3', '2', 'delicious noddle'), ('6', 'noddle', 'http://106.14.238.63/images/noddle.jpg', '8.00000', '34', '3', '2', 'delicious noddle'), ('7', 'chicken', 'http://106.14.238.63/images/chicken.jpg', '8.00000', '34', '3', '3', 'delicious chicken'), ('8', 'chicken', 'http://106.14.238.63/images/chicken.jpg', '8.00000', '34', '3', '3', 'delicious chicken'), ('9', 'chicken', 'http://106.14.238.63/images/chicken.jpg', '8.00000', '34', '3', '3', 'delicious chicken'), ('10', 'chicken', 'http://106.14.238.63/images/chicken.jpg', '8.00000', '34', '3', '3', 'delicious chicken'), ('11', 'pizza', 'http://106.14.238.63/images/pizza.jpg', '8.00000', '34', '3', '4', 'delicious pizza'), ('12', 'pizza', 'http://106.14.238.63/images/pizza.jpg', '8.00000', '34', '3', '4', 'delicious pizza'), ('13', 'pizza', 'http://106.14.238.63/images/pizza.jpg', '8.00000', '34', '3', '4', 'delicious pizza'), ('14', 'egg', 'http://106.14.238.63/images/egg.jpg', '1.00000', '0', '0', '5', 'extra'), ('15', 'egg2', 'http://106.14.238.63/images/egg.jpg', '2.00000', '0', '0', '5', 'extra2');
COMMIT;

-- ----------------------------
--  Table structure for `food_extra`
-- ----------------------------
DROP TABLE IF EXISTS `food_extra`;
CREATE TABLE `food_extra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `food_id` int(11) NOT NULL,
  `extra_food_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `food_extra_ibfk_1` (`food_id`),
  KEY `food_extra_ibfk_2` (`extra_food_id`),
  CONSTRAINT `food_extra_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `food_extra_ibfk_2` FOREIGN KEY (`extra_food_id`) REFERENCES `food` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `food_extra`
-- ----------------------------
BEGIN;
INSERT INTO `food_extra` VALUES ('7', '2', '14'), ('8', '2', '15'), ('9', '3', '14'), ('10', '4', '15'), ('11', '2', '3'), ('12', '1', '2'), ('13', '1', '3'), ('14', '1', '4');
COMMIT;

-- ----------------------------
--  Table structure for `food_list`
-- ----------------------------
DROP TABLE IF EXISTS `food_list`;
CREATE TABLE `food_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  `food_num` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `food_list_ibfk_1` (`food_id`),
  KEY `food_list_ibfk_2` (`order_id`),
  CONSTRAINT `food_list_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `food_list_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `food_list`
-- ----------------------------
BEGIN;
INSERT INTO `food_list` VALUES ('1', '1', '1', '2'), ('2', '1', '2', '2'), ('3', '2', '3', '3'), ('4', '2', '4', '2'), ('5', '3', '1', '1'), ('6', '3', '5', '1'), ('8', '1', '1', '3'), ('10', '13', '1', '1'), ('11', '14', '1', '1'), ('12', '14', '2', '2');
COMMIT;

-- ----------------------------
--  Table structure for `food_type`
-- ----------------------------
DROP TABLE IF EXISTS `food_type`;
CREATE TABLE `food_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `food_type`
-- ----------------------------
BEGIN;
INSERT INTO `food_type` VALUES ('1', 'salad', 'http://106.14.238.63/images/salad.jpg'), ('2', 'noddle', 'http://106.14.238.63/images/noddle.jpg'), ('3', 'fried chiken', 'http://106.14.238.63/images/chiken.jpg'), ('4', 'pizza', 'http://106.14.238.63/images/pizza.jpg'), ('5', 'extra', 'http://106.14.238.63/images/pizza.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `price` decimal(10,5) NOT NULL,
  `is_finish` tinyint(2) NOT NULL DEFAULT '0',
  `ticket_info` tinyint(2) NOT NULL,
  `pay_type` tinyint(2) NOT NULL,
  `bowl_info` tinyint(2) NOT NULL,
  `iscust` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `order_ibfk_1` (`user_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `order`
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES ('1', '2016-12-06 10:33:27', '1', '33.00000', '0', '1', '1', '1', '0'), ('2', '2016-12-06 10:33:39', '2', '38.00000', '0', '0', '0', '0', '0'), ('3', '2016-12-14 10:33:48', '3', '5.80000', '1', '1', '0', '0', '0'), ('4', '2016-12-09 10:58:26', '4', '3123.00000', '0', '1', '1', '1', '0'), ('5', '2016-12-07 11:58:48', '1', '33.80000', '1', '1', '1', '1', '0'), ('6', '2016-12-07 14:08:06', '1', '33.80000', '1', '1', '1', '1', '0'), ('7', '2016-12-08 10:54:41', '1', '33.80000', '1', '1', '1', '1', '0'), ('8', '2016-12-08 10:55:10', '1', '33.80000', '1', '1', '1', '1', '0'), ('9', '2015-12-02 12:12:12', '1', '22.00000', '0', '1', '1', '1', '0'), ('10', '2016-12-09 16:29:03', '1', '33.80000', '1', '1', '1', '1', '0'), ('11', '2016-12-09 16:29:27', '1', '33.80000', '1', '1', '1', '1', '0'), ('12', '2016-12-09 16:29:42', '1', '33.80000', '1', '1', '1', '1', '0'), ('13', '2015-12-02 12:12:12', '1', '22.00000', '0', '1', '1', '1', '0'), ('14', '2015-12-02 12:12:12', '1', '22.00000', '0', '1', '1', '1', '0'), ('15', '2016-12-09 16:32:45', '1', '33.80000', '1', '1', '1', '1', '0'), ('16', '2016-12-19 20:43:23', '1', '33.80000', '1', '1', '1', '1', '0'), ('17', '2016-12-19 20:43:31', '1', '33.80000', '1', '1', '1', '1', '1'), ('18', '2016-12-19 22:12:35', '1', '33.80000', '1', '1', '1', '1', '1'), ('19', '2016-12-19 22:38:04', '1', '33.80000', '1', '1', '1', '1', '1'), ('20', '2016-12-19 23:52:50', '1', '33.80000', '1', '1', '1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `expire_day` int(11) DEFAULT NULL,
  `daily_upper` decimal(10,5) NOT NULL,
  `price` decimal(10,4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ticket`
-- ----------------------------
BEGIN;
INSERT INTO `ticket` VALUES ('1', 'monthly ticket', 'ticket info', '31', '20.00000', '500.0000');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `avatar` varchar(255) NOT NULL DEFAULT '/data/wwwroot/default/images/default-avatar.jpg',
  `address` varchar(255) NOT NULL DEFAULT '',
  `phone` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '123666', '123123', '18795853969@163.com', 'http://106.14.238.63/images/default-avatar.jpg', 'http addr', 'http phone'), ('2', 'kylin2', '123123', '187958539692@163.com', 'http://106.14.238.63/images/default-avatar.jpg', 'NJU gulou campus', '18795853969'), ('3', 'alan', '123123', '187958539693@163.com', 'http://106.14.238.63/images/default-avatar.jpg', 'NJU gulou campus', '18795853969'), ('4', 'kuixi', '123123', '187958539694@163.com', 'http://106.14.238.63/images/default-avatar.jpg', 'NJU gulou campus', '18795853969'), ('5', 'test', '123123', 'test@test.com', 'http://106.14.238.63/images/default-avatar.jpg', 'NJU gulou campus', '4'), ('14', 'name', '123', '123', 'http://106.14.238.63/images/default-avatar.jpg', 'NJU gulou campus', '4'), ('15', 'kylin888', '123123', '888@163.com', 'http://106.14.238.63/images/default-avatar.jpg', 'NJU gulou campus', '5'), ('16', 'name', '123', '123123', 'http://106.14.238.63/images/default-avatar.jpg', '', ''), ('17', 'kylin888', '123123', '8882@163.com', 'http://106.14.238.63/images/default-avatar.jpg', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `user_ticket`
-- ----------------------------
DROP TABLE IF EXISTS `user_ticket`;
CREATE TABLE `user_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  `expire_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_ticket_ibfk_1` (`user_id`),
  KEY `user_ticket_ibfk_2` (`ticket_id`),
  CONSTRAINT `user_ticket_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_ticket_ibfk_2` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_ticket`
-- ----------------------------
BEGIN;
INSERT INTO `user_ticket` VALUES ('1', '1', '1', '2016-12-31 10:48:36'), ('2', '2', '1', '2016-12-07 11:20:16'), ('6', '2', '1', '2016-12-08 14:53:22'), ('7', '2', '1', '2016-12-08 16:39:56'), ('8', '2', '1', '2016-12-09 16:32:45'), ('9', '2', '1', '2016-12-09 16:35:34'), ('10', '2', '1', '2016-12-09 17:03:54'), ('11', '2', '1', '2016-12-10 11:13:16'), ('12', '2', '1', '2016-12-10 13:58:22'), ('13', '2', '1', '2016-12-10 19:10:54'), ('14', '2', '1', '2016-12-10 19:40:16');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
