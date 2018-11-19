/*
 Navicat MySQL Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 19/11/2018 15:37:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Test
-- ----------------------------
DROP TABLE IF EXISTS `Test`;
CREATE TABLE `Test` (
  `id` int(19) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `age` int(3) unsigned NOT NULL COMMENT '年龄',
  `text` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '这是一个文本内容' COMMENT '文本',
  `tyint` tinyint(2) DEFAULT NULL COMMENT '测试tingint',
  `memo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '文本',
  `json_memo` json DEFAULT NULL COMMENT 'json文本',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `index_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='TEST';

SET FOREIGN_KEY_CHECKS = 1;
