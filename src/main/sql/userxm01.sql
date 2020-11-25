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

 Date: 25/11/2020 21:30:02
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(10) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'ddd', '123456', '1097249217@qq.com', '男', 18, '上海', NULL);
INSERT INTO `user` VALUES (2, 'dxt', '123456', '1097249217@qq.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 'aaa', '111111', '111@qq.com', '男', 18, '深圳', 'nihao');
INSERT INTO `user` VALUES (4, 'GHGHGHG', '123456', '1112@qq.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, 'GGG', '123456', '43563@11.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, 'TTTT', '123456', '436564@56.com', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
