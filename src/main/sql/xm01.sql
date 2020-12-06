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

 Date: 06/12/2020 22:49:50
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stock_order
-- ----------------------------
DROP TABLE IF EXISTS `stock_order`;
CREATE TABLE `stock_order`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stockcheck` int(1) NULL DEFAULT NULL,
  `stockid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stockname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `currentprice` decimal(15, 2) NULL DEFAULT NULL,
  `totalprice` decimal(32, 2) NULL DEFAULT NULL,
  `number` int(64) NULL DEFAULT NULL,
  `ordertime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stock_order
-- ----------------------------
INSERT INTO `stock_order` VALUES (13, 'ddd', 1, 'sh60051', '茅台', 256.00, 0.00, 50, 'Fri Dec 04 10:32:05 CST 2020');
INSERT INTO `stock_order` VALUES (14, 'ddd', 1, 'sh60051', '茅台', 256.00, 0.00, 50, 'Fri Dec 04 10:32:32 CST 2020');

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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'ddd', '123456', '1097249217@qq.com', '男', 18, '上海', NULL);
INSERT INTO `user` VALUES (2, 'dxt', '123456', '1097249217@qq.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 'aaa', '111111', '111@qq.com', '男', 18, '深圳', 'nihao');
INSERT INTO `user` VALUES (4, 'GHGHGHG', '123456', '1112@qq.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, 'GGG', '123456', '43563@11.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, 'TTTT', '123456', '436564@56.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, 'dai', '123456', '1097249217@qq.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, 'zdy', '123456', '1196154768@qq.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (11, 'ylx1', '123456', '2754@qq.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (12, 'ylx2', '123456', '5784@qq.com', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_property
-- ----------------------------
DROP TABLE IF EXISTS `user_property`;
CREATE TABLE `user_property`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `property` decimal(32, 2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_property
-- ----------------------------
INSERT INTO `user_property` VALUES (1, 'ddd', 0.00);
INSERT INTO `user_property` VALUES (2, 'dxt', 0.00);
INSERT INTO `user_property` VALUES (3, 'aaa', 0.00);
INSERT INTO `user_property` VALUES (4, 'GHGHGHG', 1000.00);
INSERT INTO `user_property` VALUES (5, 'GGG', 10000.00);
INSERT INTO `user_property` VALUES (6, 'TTTT', 33547.00);
INSERT INTO `user_property` VALUES (9, 'dai', 0.00);
INSERT INTO `user_property` VALUES (10, 'zdy', 0.00);
INSERT INTO `user_property` VALUES (11, 'ylx2', 0.00);

-- ----------------------------
-- Table structure for user_stock
-- ----------------------------
DROP TABLE IF EXISTS `user_stock`;
CREATE TABLE `user_stock`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stockid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stockname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` int(16) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;