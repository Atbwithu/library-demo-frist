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

 Date: 25/09/2024 11:10:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书名',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '上架日期\r\n上架时间',
  `isbn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `num` int NULL DEFAULT NULL COMMENT '书本数量',
  `info` json NULL,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片封面',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '三味书屋', '未知', '2024-09-18 14:06:32', '111', 50, '[{\"id\": 1, \"num\": \"100\", \"info\": null, \"isbn\": \"124\", \"name\": \"豪门赘婿\", \"author\": \"未知\", \"createTime\": \"2024-09-12 14:07:24\"}]', 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (2, '豪门赘婿', '未知', '2024-09-12 14:07:24', '124', 100, '{\"id\": 2, \"num\": \"100\", \"info\": null, \"isbn\": \"124\", \"name\": \"豪门赘婿\", \"author\": \"未知\", \"createTime\": \"2024-09-12 14:07:24\"}', 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (3, 'test', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (4, 'test01', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (5, '1', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (6, '2', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (7, '3', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (8, '4', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (9, '5', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (10, '6', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (11, '7', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (12, '8', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (13, '9', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (14, '10', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (15, '11', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (16, '12', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (17, '13', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (18, '14', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');
INSERT INTO `book` VALUES (19, '15', NULL, NULL, NULL, NULL, NULL, 'https://th.bing.com/th/id/OIP.XQwonRIZtmY7lDK8s_2W1AHaLH?w=122&h=183&c=7&r=0&o=5&pid=1.7');

SET FOREIGN_KEY_CHECKS = 1;
