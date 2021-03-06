SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of platform_menu
-- ----------------------------
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000001', '2018-09-15 11:28:28', NULL, '系统管理', NULL, NULL, 100, 1, 1, '#');
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000002', '2018-09-15 11:28:28', NULL, '菜单管理', '00000003-0000-0000-0000-000000000001', NULL, 1, 1, 1, 'platform/menu/page');
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000003', '2018-09-15 11:28:28', NULL, '角色管理', '00000003-0000-0000-0000-000000000001', NULL, 2, 1, 1, 'platform/role/page');
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000004', '2018-09-15 11:28:28', NULL, '资源管理', '00000003-0000-0000-0000-000000000001', NULL, 3, 1, 1, 'platform/resources/page');
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000005', '2018-09-15 11:28:28', NULL, '用户管理', '00000003-0000-0000-0000-000000000001', NULL, 4, 1, 1, 'platform/user/page');
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000006', '2018-09-15 11:28:28', NULL, '数据字典', '00000003-0000-0000-0000-000000000001', NULL, 5, 1, 1, 'platform/dict/page');
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000007', '2018-09-15 11:28:28', NULL, '部门管理', '00000003-0000-0000-0000-000000000001', NULL, 7, 1, 1, 'platform/department/page');
INSERT INTO `platform_menu` VALUES ('00000003-0000-0000-0000-000000000008', '2018-09-15 11:28:28', NULL, '岗位管理', '00000003-0000-0000-0000-000000000001', NULL, 8, 1, 1, 'platform/position/page');

-- ----------------------------
-- Records of platform_role
-- ----------------------------
INSERT INTO `platform_role` VALUES ('00000001-0000-0000-0000-000000000000', 'ADMIN', '2018-09-15 11:25:39', '管理员', 1);

-- ----------------------------
-- Records of platform_user
-- ----------------------------
INSERT INTO `platform_user` VALUES ('00000000-0000-0000-0000-000000000000', b'1', b'1', '2018-09-15', '虚拟用户', '2018-09-15 11:23:19', b'1', NULL, b'1', 'nan', '$2a$10$ItToNYw2u5luVBHDV9M8fuH5oNklUdOWq/C6sNcBp2gyEJ7DaTwSW', NULL, '管理员', 'admin');

-- ----------------------------
-- Records of platform_user_role
-- ----------------------------
INSERT INTO `platform_user_role` VALUES ('00000002-0000-0000-0000-000000000000', '2018-09-15 11:26:11', '00000001-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000');

-- ----------------------------
-- Records of platform_role_menu
-- ----------------------------
INSERT INTO `pmss`.`platform_role_menu`(`id`, `create_time`, `menu_id`, `role_id`) VALUES ('00000004-0000-0000-0000-000000000001', '2018-09-15 11:43:16', '00000003-0000-0000-0000-000000000001', '00000001-0000-0000-0000-000000000000');
INSERT INTO `pmss`.`platform_role_menu`(`id`, `create_time`, `menu_id`, `role_id`) VALUES ('00000004-0000-0000-0000-000000000002', '2018-09-15 11:44:07', '00000003-0000-0000-0000-000000000002', '00000001-0000-0000-0000-000000000000');
INSERT INTO `pmss`.`platform_role_menu`(`id`, `create_time`, `menu_id`, `role_id`) VALUES ('00000004-0000-0000-0000-000000000003', '2018-09-15 11:44:07', '00000003-0000-0000-0000-000000000003', '00000001-0000-0000-0000-000000000000');
INSERT INTO `pmss`.`platform_role_menu`(`id`, `create_time`, `menu_id`, `role_id`) VALUES ('00000004-0000-0000-0000-000000000004', '2018-09-15 11:44:07', '00000003-0000-0000-0000-000000000004', '00000001-0000-0000-0000-000000000000');
INSERT INTO `pmss`.`platform_role_menu`(`id`, `create_time`, `menu_id`, `role_id`) VALUES ('00000004-0000-0000-0000-000000000005', '2018-09-15 11:44:07', '00000003-0000-0000-0000-000000000005', '00000001-0000-0000-0000-000000000000');
INSERT INTO `pmss`.`platform_role_menu`(`id`, `create_time`, `menu_id`, `role_id`) VALUES ('00000004-0000-0000-0000-000000000006', '2018-09-15 11:44:07', '00000003-0000-0000-0000-000000000006', '00000001-0000-0000-0000-000000000000');
INSERT INTO `pmss`.`platform_role_menu`(`id`, `create_time`, `menu_id`, `role_id`) VALUES ('00000004-0000-0000-0000-000000000007', '2018-09-15 11:44:07', '00000003-0000-0000-0000-000000000007', '00000001-0000-0000-0000-000000000000');
INSERT INTO `pmss`.`platform_role_menu`(`id`, `create_time`, `menu_id`, `role_id`) VALUES ('00000004-0000-0000-0000-000000000008', '2018-09-15 11:44:07', '00000003-0000-0000-0000-000000000008', '00000001-0000-0000-0000-000000000000');


SET FOREIGN_KEY_CHECKS = 1;
