/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80039
 Source Host           : localhost:3306
 Source Schema         : db_test

 Target Server Type    : MySQL
 Target Server Version : 80039
 File Encoding         : 65001

 Date: 25/09/2024 11:11:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT b'0',
  `role_id` int NULL DEFAULT 1,
  `create_time` datetime NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account`(`account` ASC) USING BTREE COMMENT '账号唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 1002 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', 'root', '123', b'0', 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, '张四', 'wwo', '', b'0', 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, '李四', 'admin', '', b'0', 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, '委中承', 'wzc', NULL, b'0', 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1000, '魏中林', 'wzl', '', b'0', 0, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1001, '37a48d62-458e-4c66-b600-2c87f2f8e58f', 'donk', '$2a$10$ambMIUnSsrF3x2A70oOpYu1wsoJIzzQgivfd3uhfjZeFUyHfLtBLa', b'0', 0, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
