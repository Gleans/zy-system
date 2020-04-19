/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : zy-system

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 19/04/2020 21:38:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 1001, '用户管理', 'user', 1000, 'page');
INSERT INTO `menu` VALUES (2, 1002, '用户组管理', 'group', 1000, 'page');
INSERT INTO `menu` VALUES (3, 2000, '科研信息', '', 0, 'main');
INSERT INTO `menu` VALUES (4, 2005, '科研信息管理', 'keyanxinxi', 2000, 'main');
INSERT INTO `menu` VALUES (5, 1000, '基础资料', NULL, 0, 'main');
INSERT INTO `menu` VALUES (6, 4000, '管理员模块', NULL, 0, 'main');
INSERT INTO `menu` VALUES (7, 4001, '管理员账户管理', 'admin', 4000, 'page');
INSERT INTO `menu` VALUES (8, 4002, '教师信息管理', 'teacher', 4000, 'page');
INSERT INTO `menu` VALUES (9, 4003, '系主任信息管理', 'dean', 4000, 'page');
INSERT INTO `menu` VALUES (10, 4004, '常用下载', 'download', 4000, 'page');
INSERT INTO `menu` VALUES (11, 2001, '科研动态', 'keyandongtai', 2000, 'page');
INSERT INTO `menu` VALUES (12, 2002, '我的项目', 'myproject', 2000, 'page');
INSERT INTO `menu` VALUES (13, 2003, '我的成果', 'myjob', 2000, 'page');
INSERT INTO `menu` VALUES (14, 2004, '信息采集', 'info', 2000, 'page');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称key',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` bigint(13) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` bigint(13) NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '删除状态 Y/N',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '系统管理员', NULL, NULL, NULL, NULL, 'N');
INSERT INTO `role` VALUES (2, 'dean', '系主任', NULL, NULL, NULL, NULL, 'N');
INSERT INTO `role` VALUES (3, 'teacher', '教师', NULL, NULL, NULL, NULL, 'N');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` bigint(12) NULL DEFAULT NULL COMMENT '手机号',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` bigint(13) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` bigint(13) NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '删除状态 Y/N',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `uq_username`(`username`) USING BTREE COMMENT '用户名唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin@qq.com', '男', 18888888888, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (2, 'message', 'message', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (3, 'lastError', 'lastError', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (4, '1111111', '1111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (6, 'admin1', '1111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (7, 'test111', 'test111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (8, 'admin1111', 'admin111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (9, 'admin1112', 'admin111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (10, 'admin1113', 'admin111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (11, 'admin1114', 'admin111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (12, 'admi555', 'admin111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (13, '张三', 'admin111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (14, '李四', 'admin111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (15, '卢本伟', 'admin111111111', '', '男', 17888888888, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (21, '1112112', '1212121', '', '男', NULL, NULL, NULL, NULL, NULL, 'N');
INSERT INTO `user` VALUES (22, 'admin11212', 'admin', '', '男', 11122223333, NULL, NULL, NULL, NULL, 'N');

-- ----------------------------
-- Table structure for user_menu
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_menu
-- ----------------------------
INSERT INTO `user_menu` VALUES (1, 1, 1);
INSERT INTO `user_menu` VALUES (2, 1, 2);
INSERT INTO `user_menu` VALUES (3, 1, 3);
INSERT INTO `user_menu` VALUES (4, 1, 4);
INSERT INTO `user_menu` VALUES (5, 1, 5);
INSERT INTO `user_menu` VALUES (6, 1, 6);
INSERT INTO `user_menu` VALUES (7, 1, 7);
INSERT INTO `user_menu` VALUES (8, 1, 8);
INSERT INTO `user_menu` VALUES (9, 1, 9);
INSERT INTO `user_menu` VALUES (10, 1, 10);
INSERT INTO `user_menu` VALUES (11, 1, 11);
INSERT INTO `user_menu` VALUES (12, 1, 12);
INSERT INTO `user_menu` VALUES (13, 1, 13);
INSERT INTO `user_menu` VALUES (14, 1, 14);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `is_delete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, NULL);
INSERT INTO `user_role` VALUES (11, 1, 19, NULL);
INSERT INTO `user_role` VALUES (12, 1, 20, NULL);
INSERT INTO `user_role` VALUES (13, 1, 15, NULL);
INSERT INTO `user_role` VALUES (14, 2, 15, NULL);
INSERT INTO `user_role` VALUES (15, 1, 21, NULL);
INSERT INTO `user_role` VALUES (16, 1, 22, NULL);
INSERT INTO `user_role` VALUES (17, 2, 22, NULL);
INSERT INTO `user_role` VALUES (18, 3, 22, NULL);
INSERT INTO `user_role` VALUES (19, 1, 15, NULL);
INSERT INTO `user_role` VALUES (20, 2, 15, NULL);
INSERT INTO `user_role` VALUES (21, 3, 15, NULL);
INSERT INTO `user_role` VALUES (22, 1, 22, NULL);
INSERT INTO `user_role` VALUES (23, 2, 22, NULL);
INSERT INTO `user_role` VALUES (24, 3, 22, NULL);

SET FOREIGN_KEY_CHECKS = 1;
