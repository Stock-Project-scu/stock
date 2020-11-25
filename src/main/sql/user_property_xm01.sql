/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50151
 Source Host           : localhost:3306
 Source Schema         : xm01

 Target Server Type    : MySQL
 Target Server Version : 50151
 File Encoding         : 65001

 Date: 25/11/2020 21:30:27
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_property
-- ----------------------------
DROP TABLE IF EXISTS `user_property`;
CREATE TABLE `user_property`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `property` double(32, 0) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_property
-- ----------------------------
INSERT INTO `user_property` VALUES (1, 'ddd', 0);
INSERT INTO `user_property` VALUES (2, 'dxt', 0);
INSERT INTO `user_property` VALUES (3, 'aaa', 0);
INSERT INTO `user_property` VALUES (4, 'GHGHGHG', 1000);
INSERT INTO `user_property` VALUES (5, 'GGG', 10000);
INSERT INTO `user_property` VALUES (6, 'TTTT', 33547);

SET FOREIGN_KEY_CHECKS = 1;
