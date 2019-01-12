/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : pmss

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 12/01/2019 11:27:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for platform_department
-- ----------------------------
DROP TABLE IF EXISTS `platform_department`;
CREATE TABLE `platform_department`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `parent_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `short_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for platform_menu
-- ----------------------------
DROP TABLE IF EXISTS `platform_menu`;
CREATE TABLE `platform_menu`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `icon_cls` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `parent_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sort_no` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `system_flag` int(11) NULL DEFAULT NULL,
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `modify_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platform_menu
-- ----------------------------
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000001', '2018-09-15 11:28:28', 'ios-home', '系统管理', NULL, 'a', 100, 1, 1, '#', NULL, NULL, NULL);
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000002', '2018-09-15 11:28:28', 'md-menu', '菜单管理', '00000003-0000-0000-0000-000000000001', 'a', 1, 1, 1, 'platform/menu/page', NULL, NULL, NULL);
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000003', '2018-09-15 11:28:28', 'md-heart', '角色管理', '00000003-0000-0000-0000-000000000001', 'a', 2, 1, 1, 'platform/role/page', NULL, NULL, NULL);
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000004', '2018-09-15 11:28:28', 'md-link', '资源管理', '00000003-0000-0000-0000-000000000001', 'b', 3, 1, 1, 'platform/resources/page', NULL, NULL, NULL);
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000005', '2018-09-15 11:28:28', 'md-person', '用户管理', '00000003-0000-0000-0000-000000000001', 'b', 4, 1, 1, 'platform/user/page', NULL, NULL, NULL);
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000006', '2018-09-15 11:28:28', 'md-paper', '数据字典', '00000003-0000-0000-0000-000000000001', 'b', 5, 1, 1, 'platform/dict/page', NULL, NULL, NULL);
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000007', '2018-09-15 11:28:28', 'md-pricetags', '部门管理', '00000003-0000-0000-0000-000000000001', 'b', 7, 1, 1, 'platform/department/page', NULL, NULL, NULL);
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000008', '2018-09-15 11:28:28', 'md-ribbon', '岗位管理', '00000003-0000-0000-0000-000000000001', 'a', 8, 1, 1, 'platform/position/page', NULL, NULL, NULL);
INSERT INTO `platform_menu` VALUES ('40539b7d661e365001661e3c02390000', '2018-09-28 11:32:21', 'ios-mail', '小工具', '', '小巩固', 200, 1, NULL, '#', '00000000-0000-0000-0000-000000000000', '2019-01-11 17:33:11', '00000000-0000-0000-0000-000000000000');
INSERT INTO `platform_menu` VALUES ('40539b7d661e864001661ef1929a0000', '2018-09-28 14:50:40', 'ios-mail', '抢票12306', '40539b7d661e365001661e3c02390000', '12306抢票程序', 1, 1, NULL, 'business/travel/page', '00000000-0000-0000-0000-000000000000', '2019-01-11 17:34:23', '00000000-0000-0000-0000-000000000000');
INSERT INTO `platform_menu` VALUES ('402880ef66e2f8b00166e3153a260000', '2018-11-05 16:55:11', 'ios-mail', 'ccc2', '40539b7d661e365001661e3c02390000', 'fe', 22, 1, NULL, '#', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683bdda001683bec1e380000', '2019-01-11 15:59:16', 'ios-mail', 'q1', '40539b7d661e365001661e3c02390000', 'q1', 3, 1, NULL, 'q1', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683bdda001683bec3ddb0001', '2019-01-11 15:59:25', 'ios-mail', 'q2', '40539b7d661e365001661e3c02390000', 'q2', 4, 1, NULL, 'q2', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683bdda001683bec55590002', '2019-01-11 15:59:31', 'ios-mail', 'q5', '40539b7d661e365001661e3c02390000', '55', 55, 1, NULL, '55', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683bdda001683bec68780003', '2019-01-11 15:59:36', 'ios-mail', '66', '40539b7d661e365001661e3c02390000', '66', 66, 1, NULL, '66', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683bdda001683bec7ebe0004', '2019-01-11 15:59:41', 'ios-mail', '77', '40539b7d661e365001661e3c02390000', '77', 77, 1, NULL, '77', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683bdda001683bef56910005', '2019-01-11 16:02:48', 'ios-mail', 'qq', '40539b7d661e365001661e3c02390000', 'qq', 111, 1, NULL, 'qq', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683c154701683c179c850000', '2019-01-11 16:46:47', 'ios-mail', 'www', '40539b7d661e365001661e3c02390000', 'ww', 22, 1, NULL, 'ww', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683c154701683c17b2900001', '2019-01-11 16:46:53', 'ios-mail', 'ee', '40539b7d661e365001661e3c02390000', 'ee', 334, 1, NULL, 'ee', '00000000-0000-0000-0000-000000000000', NULL, NULL);
INSERT INTO `platform_menu` VALUES ('4028809b683c154701683c17eb5c0002', '2019-01-11 16:47:07', 'ios-mail', 'sa', '40539b7d661e365001661e3c02390000', 'sa', 22, 1, NULL, 'sa', '00000000-0000-0000-0000-000000000000', NULL, NULL);

-- ----------------------------
-- Table structure for platform_position
-- ----------------------------
DROP TABLE IF EXISTS `platform_position`;
CREATE TABLE `platform_position`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `department_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `short_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for platform_resource
-- ----------------------------
DROP TABLE IF EXISTS `platform_resource`;
CREATE TABLE `platform_resource`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for platform_role
-- ----------------------------
DROP TABLE IF EXISTS `platform_role`;
CREATE TABLE `platform_role`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `code` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `modify_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platform_role
-- ----------------------------
INSERT INTO `platform_role` VALUES ('00000001-0000-0000-0000-000000000000', 'ADMIN', '2018-09-15 11:25:39', '管理员', 1, NULL, NULL, NULL);
INSERT INTO `platform_role` VALUES ('4028809b683bdda001683bfae4a60006', 'GUEST12111111', '2019-01-11 16:15:25', '来宾用户1211111', 1, '00000000-0000-0000-0000-000000000000', '2019-01-11 17:26:05', '00000000-0000-0000-0000-000000000000');

-- ----------------------------
-- Table structure for platform_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `platform_role_menu`;
CREATE TABLE `platform_role_menu`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `menu_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platform_role_menu
-- ----------------------------
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b70e60000', NULL, '40539b7d661e864001661ef1929a0000', '4028809b683bdda001683bfae4a60006');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b70f00001', NULL, '4028809b683bdda001683bec1e380000', '4028809b683bdda001683bfae4a60006');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97be0002', NULL, '00000003-0000-0000-0000-000000000001', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97be0003', NULL, '00000003-0000-0000-0000-000000000002', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97be0004', NULL, '00000003-0000-0000-0000-000000000003', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97be0005', NULL, '00000003-0000-0000-0000-000000000004', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97bf0006', NULL, '00000003-0000-0000-0000-000000000005', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97bf0007', NULL, '00000003-0000-0000-0000-000000000006', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c00008', NULL, '00000003-0000-0000-0000-000000000007', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c00009', NULL, '00000003-0000-0000-0000-000000000008', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c1000a', NULL, '40539b7d661e365001661e3c02390000', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c1000b', NULL, '40539b7d661e864001661ef1929a0000', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c2000c', NULL, '4028809b683bdda001683bec1e380000', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c2000d', NULL, '4028809b683bdda001683bec3ddb0001', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c3000e', NULL, '402880ef66e2f8b00166e3153a260000', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c3000f', NULL, '4028809b683c154701683c179c850000', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c30010', NULL, '4028809b683c154701683c17eb5c0002', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c40011', NULL, '4028809b683bdda001683bec55590002', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c40012', NULL, '4028809b683bdda001683bec68780003', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c40013', NULL, '4028809b683bdda001683bec7ebe0004', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c40014', NULL, '4028809b683bdda001683bef56910005', '00000001-0000-0000-0000-000000000000');
INSERT INTO `platform_role_menu` VALUES ('4028809b683c2b0501683c2b97c40015', NULL, '4028809b683c154701683c17b2900001', '00000001-0000-0000-0000-000000000000');

-- ----------------------------
-- Table structure for platform_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `platform_role_resource`;
CREATE TABLE `platform_role_resource`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `resource_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for platform_user
-- ----------------------------
DROP TABLE IF EXISTS `platform_user`;
CREATE TABLE `platform_user`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `account_non_expired` bit(1) NULL DEFAULT NULL,
  `account_non_locked` bit(1) NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `contact_infomation` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `credentials_non_expired` bit(1) NULL DEFAULT NULL,
  `department_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `enabled` bit(1) NULL DEFAULT NULL,
  `gender` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `position_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `real_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platform_user
-- ----------------------------
INSERT INTO `platform_user` VALUES ('00000000-0000-0000-0000-000000000000', b'1', b'1', '2018-09-15', '虚拟用户', '2018-09-15 11:23:19', b'1', NULL, b'1', 'nan', '$2a$10$ItToNYw2u5luVBHDV9M8fuH5oNklUdOWq/C6sNcBp2gyEJ7DaTwSW', NULL, '管理员', 'admin');

-- ----------------------------
-- Table structure for platform_user_role
-- ----------------------------
DROP TABLE IF EXISTS `platform_user_role`;
CREATE TABLE `platform_user_role`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platform_user_role
-- ----------------------------
INSERT INTO `platform_user_role` VALUES ('00000002-0000-0000-0000-000000000000', '2018-09-15 11:26:11', '00000001-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000');

SET FOREIGN_KEY_CHECKS = 1;
