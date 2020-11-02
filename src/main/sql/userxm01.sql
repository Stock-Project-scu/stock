/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50151
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50151
 File Encoding         : 65001

 Date: 02/11/2020 17:50:38
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userxm01
-- ----------------------------
DROP TABLE IF EXISTS `userxm01`;
CREATE TABLE `userxm01`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userxm01
-- ----------------------------
INSERT INTO `userxm01` VALUES (1, 'ddd', '1097249217@qq.com', '123456');
INSERT INTO `userxm01` VALUES (2, 'dxt', '1097249217@qq.com', '123456');

SET FOREIGN_KEY_CHECKS = 1;
