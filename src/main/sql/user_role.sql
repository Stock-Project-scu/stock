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

 Date: 18/01/2021 10:02:20
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleid` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 'ddd', 1);
INSERT INTO `user_role` VALUES (2, 'dxt', 1);
INSERT INTO `user_role` VALUES (3, 'aaa', 1);
INSERT INTO `user_role` VALUES (4, 'GHGHGHG', 1);
INSERT INTO `user_role` VALUES (5, 'GGG', 1);
INSERT INTO `user_role` VALUES (6, 'TTTT', 1);
INSERT INTO `user_role` VALUES (9, 'dai', 1);
INSERT INTO `user_role` VALUES (10, 'zdy', 1);
INSERT INTO `user_role` VALUES (11, 'ylx1', 1);
INSERT INTO `user_role` VALUES (12, 'ylx2', 1);

SET FOREIGN_KEY_CHECKS = 1;
