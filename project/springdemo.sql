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

 Date: 02/18/2017 13:40:02 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

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

SET FOREIGN_KEY_CHECKS = 1;
