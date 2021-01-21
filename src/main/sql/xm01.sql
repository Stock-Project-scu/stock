/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50151
Source Host           : localhost:3366
Source Database       : xm01

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2021-01-21 18:04:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stock_order
-- ----------------------------
DROP TABLE IF EXISTS `stock_order`;
CREATE TABLE `stock_order` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `stockcheck` int(1) DEFAULT NULL,
  `stockid` varchar(32) DEFAULT NULL,
  `stockname` varchar(255) DEFAULT NULL,
  `currentprice` decimal(15,2) DEFAULT NULL,
  `totalprice` decimal(32,2) DEFAULT NULL,
  `number` int(64) DEFAULT NULL,
  `ordertime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of stock_order
-- ----------------------------
INSERT INTO `stock_order` VALUES ('15', 'ddd', '1', '600493', '凤竹纺织', '5.51', '551.00', '100', '1607432371660');
INSERT INTO `stock_order` VALUES ('16', 'ddd', '1', '600493', '凤竹纺织', '5.51', '551.00', '100', '1607432382543');
INSERT INTO `stock_order` VALUES ('17', 'ddd', '1', '600493', '凤竹纺织', '5.51', '551.00', '100', '1607432395337');
INSERT INTO `stock_order` VALUES ('18', 'ddd', '1', '600495', '晋西车轴', '4.07', '407.00', '100', '1607432423013');
INSERT INTO `stock_order` VALUES ('19', 'ddd', '1', '600495', '晋西车轴', '4.07', '407.00', '100', '1607432436510');
INSERT INTO `stock_order` VALUES ('20', 'ddd', '1', '600567', '山鹰国际', '3.11', '311.00', '100', '1608020498175');
INSERT INTO `stock_order` VALUES ('21', 'kkk', '1', '000001', '平安银行', '20.38', '20380.00', '1000', '1610355743830');
INSERT INTO `stock_order` VALUES ('22', 'kkk', '1', '000002', '万 科Ａ', '29.90', '299000.00', '10000', '1610542797969');
INSERT INTO `stock_order` VALUES ('23', 'kkk', '1', '000004', '国华网安', '17.95', '1795000.00', '100000', '1610542832125');
INSERT INTO `stock_order` VALUES ('24', 'kkk', '1', '000002', '万 科Ａ', '29.95', '2995.00', '100', '1610866798539');
INSERT INTO `stock_order` VALUES ('25', 'kkk', '1', '000002', '万 科Ａ', '29.95', '2995.00', '100', '1610866882323');
INSERT INTO `stock_order` VALUES ('26', 'kkk', '1', '000002', '万 科Ａ', '29.95', '2995000000.00', '100000000', '1610866906523');
INSERT INTO `stock_order` VALUES ('27', 'kkk', '1', '000002', '万 科Ａ', '29.95', '29950000.00', '1000000', '1610866919872');
INSERT INTO `stock_order` VALUES ('28', 'kkk', '0', '000002', '万 科Ａ', '29.95', '299500000.00', '10000000', '1610867077296');
INSERT INTO `stock_order` VALUES ('29', '1233217456', '1', '600123', '兰花科创', '5.21', '1563.00', '300', '1610969147089');
INSERT INTO `stock_order` VALUES ('30', 'ceshizu', '1', '000001', '平安银行', '22.23', '2223.00', '100', '1611221359026');
INSERT INTO `stock_order` VALUES ('31', 'ceshizu', '1', '000001', '平安银行', '22.23', '2223.00', '100', '1611221530728');
INSERT INTO `stock_order` VALUES ('32', 'ceshizu', '1', '000001', '平安银行', '22.23', '2223.00', '100', '1611221539108');
INSERT INTO `stock_order` VALUES ('33', 'ceshizu', '1', '000001', '平安银行', '22.23', '2223.00', '100', '1611221662497');
INSERT INTO `stock_order` VALUES ('34', 'ceshizu', '1', '000002', '万 科Ａ', '30.10', '3010.00', '100', '1611221793508');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ddd', '123456', '1097249217@qq.com', '男', '18', '上海', null);
INSERT INTO `user` VALUES ('2', 'dxt', '123456', '1097249217@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('3', 'aaa', '111111', '111@qq.com', '男', '18', '成都', 'nihao');
INSERT INTO `user` VALUES ('4', 'GHGHGHG', '123456', '1112@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('5', 'GGG', '123456', '43563@11.com', null, null, null, null);
INSERT INTO `user` VALUES ('6', 'TTTT', '123456', '436564@56.com', null, null, null, null);
INSERT INTO `user` VALUES ('9', 'dai', '123456', '1097249217@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('10', 'zdy', '123456', '1196154768@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('11', 'ylx1', '123456', '2754@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('12', 'ylx2', '123456', '5784@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('13', '1', '123456', '999@l.com', null, null, null, null);
INSERT INTO `user` VALUES ('14', 'Freeman', '123456', '970759901@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('15', 'vincent', '123456', 'vincentorick@163.com', null, null, null, null);
INSERT INTO `user` VALUES ('16', 'vin', '123456', 'vincentorick@163.com', null, null, null, null);
INSERT INTO `user` VALUES ('17', '11', '123456', '2908952256@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('18', 'GZY', '123456', '2908952256@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('19', '!!@', '123456', '1@qq.com', '女', '-1', '', 'sys.exit()');
INSERT INTO `user` VALUES ('20', '1111', '123123', '12.3@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('21', '111', '123123', '12.3@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('22', '1234', '123123', '12@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('23', 'test2', '123123', '13883910723@163.com', null, null, null, null);
INSERT INTO `user` VALUES ('24', 'test1', '123123', '13883910723@163.com', null, null, null, null);
INSERT INTO `user` VALUES ('25', 'test', '123123', '13883910723@163.com', null, null, null, null);
INSERT INTO `user` VALUES ('26', 'xm06', '123123', '13883910723@163.com', '女', '20', '成都', 'testuuuu');
INSERT INTO `user` VALUES ('27', '999', '123456', '1181787389@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('28', '123456', '123456', '1181787389@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('29', 'kkk', '123456', '1377443741@qq.com', '男', '100', '成都', '爱情不可哭');
INSERT INTO `user` VALUES ('30', 'xinwei', '12345678', 'xinwei@scu.edu.cn', null, null, null, null);
INSERT INTO `user` VALUES ('31', '123', '123456', '1233333@qq.ocm', null, null, null, null);
INSERT INTO `user` VALUES ('32', '124356', '123456', '1233333@qq.ocm', null, null, null, null);
INSERT INTO `user` VALUES ('33', 'zdk', '123456as', '369025818@qq.com', '男', '18', '成都', 'wu');
INSERT INTO `user` VALUES ('34', 'qwe', '123123', '123@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('35', '1234561', '111111', '3097037188@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('36', '666', '123456789012', '601645349@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('37', '1233217456', '123456', '1@2.com', null, null, null, null);
INSERT INTO `user` VALUES ('38', 'test1.19', '123456', '123@test.com', null, null, null, null);
INSERT INTO `user` VALUES ('39', 'ceshizu', '123456', 'woshilaiceshide@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('40', 'ceshizu111', '123456', 'woshilaiceshide@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('41', 'testfive', '123456', 'woshilaigaoshide@qq.com', null, null, null, null);
INSERT INTO `user` VALUES ('42', 'test0', '123456', '123@123.com', null, null, null, null);
INSERT INTO `user` VALUES ('43', 'admin', '123456', '1@12.com', null, null, null, null);

-- ----------------------------
-- Table structure for user_property
-- ----------------------------
DROP TABLE IF EXISTS `user_property`;
CREATE TABLE `user_property` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `property` decimal(32,2) unsigned NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_property
-- ----------------------------
INSERT INTO `user_property` VALUES ('1', 'ddd', '7874.00');
INSERT INTO `user_property` VALUES ('2', 'dxt', '0.00');
INSERT INTO `user_property` VALUES ('3', 'aaa', '6146.00');
INSERT INTO `user_property` VALUES ('4', 'GHGHGHG', '1000.00');
INSERT INTO `user_property` VALUES ('5', 'GGG', '10000.00');
INSERT INTO `user_property` VALUES ('6', 'TTTT', '33547.00');
INSERT INTO `user_property` VALUES ('9', 'dai', '0.00');
INSERT INTO `user_property` VALUES ('10', 'zdy', '0.00');
INSERT INTO `user_property` VALUES ('11', 'ylx1', '0.00');
INSERT INTO `user_property` VALUES ('12', 'ylx2', '0.00');
INSERT INTO `user_property` VALUES ('13', '1', '0.00');
INSERT INTO `user_property` VALUES ('14', 'Freeman', '0.00');
INSERT INTO `user_property` VALUES ('15', 'vincent', '0.00');
INSERT INTO `user_property` VALUES ('16', 'vin', '0.00');
INSERT INTO `user_property` VALUES ('17', '11', '0.00');
INSERT INTO `user_property` VALUES ('18', 'GZY', '0.00');
INSERT INTO `user_property` VALUES ('19', '!!@', '0.00');
INSERT INTO `user_property` VALUES ('20', '1111', '0.00');
INSERT INTO `user_property` VALUES ('21', '111', '0.00');
INSERT INTO `user_property` VALUES ('22', '1234', '0.00');
INSERT INTO `user_property` VALUES ('23', 'test2', '0.00');
INSERT INTO `user_property` VALUES ('24', 'test1', '0.00');
INSERT INTO `user_property` VALUES ('25', 'test', '0.00');
INSERT INTO `user_property` VALUES ('26', 'xm06', '0.00');
INSERT INTO `user_property` VALUES ('27', '999', '0.00');
INSERT INTO `user_property` VALUES ('28', '123456', '0.00');
INSERT INTO `user_property` VALUES ('29', 'kkk', '6161127630.00');
INSERT INTO `user_property` VALUES ('30', 'xinwei', '0.00');
INSERT INTO `user_property` VALUES ('31', '123', '0.00');
INSERT INTO `user_property` VALUES ('32', '124356', '0.00');
INSERT INTO `user_property` VALUES ('33', 'zdk', '900.00');
INSERT INTO `user_property` VALUES ('34', 'qwe', '0.00');
INSERT INTO `user_property` VALUES ('35', '1234561', '100000.00');
INSERT INTO `user_property` VALUES ('36', '666', '0.00');
INSERT INTO `user_property` VALUES ('37', '1233217456', '37.00');
INSERT INTO `user_property` VALUES ('38', 'test1.19', '0.00');
INSERT INTO `user_property` VALUES ('39', 'ceshizu', '7998.76');
INSERT INTO `user_property` VALUES ('40', 'ceshizu111', '0.00');
INSERT INTO `user_property` VALUES ('41', 'testfive', '0.00');
INSERT INTO `user_property` VALUES ('42', 'test0', '0.00');
INSERT INTO `user_property` VALUES ('43', 'admin', '0.00');

-- ----------------------------
-- Table structure for user_stock
-- ----------------------------
DROP TABLE IF EXISTS `user_stock`;
CREATE TABLE `user_stock` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `stockid` varchar(32) DEFAULT NULL,
  `stockname` varchar(32) DEFAULT NULL,
  `number` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_stock
-- ----------------------------
INSERT INTO `user_stock` VALUES ('6', 'ddd', '600433', '冠豪高新', '300');
INSERT INTO `user_stock` VALUES ('7', 'ddd', '600428', '中远海特', '100');
INSERT INTO `user_stock` VALUES ('8', 'aaa', '002230', '科大讯飞', '100');
INSERT INTO `user_stock` VALUES ('9', 'ddd', '600567', '山鹰国际', '100');
INSERT INTO `user_stock` VALUES ('10', 'kkk', '000001', '平安银行', '1000');
INSERT INTO `user_stock` VALUES ('11', 'kkk', '000002', '万 科Ａ', '91010200');
INSERT INTO `user_stock` VALUES ('12', 'kkk', '000004', '国华网安', '100000');
INSERT INTO `user_stock` VALUES ('13', '1233217456', '600123', '兰花科创', '300');
INSERT INTO `user_stock` VALUES ('14', 'ceshizu', '000001', '平安银行', '400');
INSERT INTO `user_stock` VALUES ('15', 'ceshizu', '000002', '万 科Ａ', '100');


-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (3, '今日大盘正式上线', '一进入系统就想看到大盘是涨是跌？ 今日大盘模块帮你实现！获取五大市场板块最新数据，是涨是跌一目了然 点击标题还能查看大盘分时 您的方便是我们努力的方向', '2021-01-20 15:06:50');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleid` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------

INSERT INTO `user_role` VALUES ('1', 'ddd', '1');
INSERT INTO `user_role` VALUES ('2', 'dxt', '1');
INSERT INTO `user_role` VALUES ('3', 'aaa', '1');
INSERT INTO `user_role` VALUES ('4', 'GHGHGHG', '1');
INSERT INTO `user_role` VALUES ('5', 'GGG', '1');
INSERT INTO `user_role` VALUES ('6', 'TTTT', '1');
INSERT INTO `user_role` VALUES ('9', 'dai', '1');
INSERT INTO `user_role` VALUES ('10', 'zdy', '1');
INSERT INTO `user_role` VALUES ('11', 'ylx1', '1');
INSERT INTO `user_role` VALUES ('12', 'ylx2', '1');
INSERT INTO `user_role` VALUES ('13', '1', '1');
INSERT INTO `user_role` VALUES ('14', 'Freeman', '1');
INSERT INTO `user_role` VALUES ('15', 'vincent', '1');
INSERT INTO `user_role` VALUES ('16', 'vin', '1');
INSERT INTO `user_role` VALUES ('17', '11', '1');
INSERT INTO `user_role` VALUES ('18', 'GZY', '1');
INSERT INTO `user_role` VALUES ('19', '!!@', '1');
INSERT INTO `user_role` VALUES ('20', '1111', '1');
INSERT INTO `user_role` VALUES ('21', '111', '1');
INSERT INTO `user_role` VALUES ('22', '1234', '1');
INSERT INTO `user_role` VALUES ('23', 'test2', '1');
INSERT INTO `user_role` VALUES ('24', 'test1', '1');
INSERT INTO `user_role` VALUES ('25', 'test', '1');
INSERT INTO `user_role` VALUES ('26', 'xm06', '1');
INSERT INTO `user_role` VALUES ('27', '999', '1');
INSERT INTO `user_role` VALUES ('28', '123456', '1');
INSERT INTO `user_role` VALUES ('29', 'kkk', '1');
INSERT INTO `user_role` VALUES ('30', 'xinwei', '1');
INSERT INTO `user_role` VALUES ('31', '123', '1');
INSERT INTO `user_role` VALUES ('32', '124356', '1');
INSERT INTO `user_role` VALUES ('33', 'zdk', '1');
INSERT INTO `user_role` VALUES ('34', 'qwe', '1');
INSERT INTO `user_role` VALUES ('35', '1234561', '1');
INSERT INTO `user_role` VALUES ('36', '666', '1');
INSERT INTO `user_role` VALUES ('37', '1233217456', '1');
INSERT INTO `user_role` VALUES ('38', 'test1.19', '1');
INSERT INTO `user_role` VALUES ('39', 'ceshizu', '1');
INSERT INTO `user_role` VALUES ('40', 'ceshizu111', '1');
INSERT INTO `user_role` VALUES ('41', 'testfive', '1');
INSERT INTO `user_role` VALUES ('42', 'test0', '1');
INSERT INTO `user_role` VALUES ('43', 'admin', '0');
