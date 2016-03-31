/*
Navicat MySQL Data Transfer

Source Server         : 趣选h5
Source Server Version : 50616
Source Host           : rdscyjxorp8m4w6d5e029.mysql.rds.aliyuncs.com:3306
Source Database       : fx_qselect

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2016-03-30 17:26:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `h5_match`
-- ----------------------------
DROP TABLE IF EXISTS `h5_match`;
CREATE TABLE `h5_match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) NOT NULL COMMENT '题目组id',
  `shareId` varchar(64) NOT NULL DEFAULT '0' COMMENT '分享id,分享时调用后后台接口生成',
  `openid` varchar(64) NOT NULL DEFAULT '' COMMENT '分享者id',
  `openidName` varchar(32) NOT NULL DEFAULT '' COMMENT '分享者昵称',
  `openidPic` varchar(1024) NOT NULL COMMENT '分享者头像',
  `fopenid` varchar(64) NOT NULL DEFAULT '' COMMENT '好友id',
  `fopenidName` varchar(32) NOT NULL DEFAULT '' COMMENT '好友昵称',
  `fopenidPic` varchar(1024) NOT NULL COMMENT '好友头像',
  `matchResult` float NOT NULL DEFAULT '0' COMMENT '匹配结果',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '匹配更新时间',
  `matchDescription` varchar(128) DEFAULT NULL COMMENT '匹配度描述，备用',
  `createTime` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '匹配生成时间',
  `matchTpye` tinyint(4) NOT NULL DEFAULT '0' COMMENT '匹配度结果类型,0：真实好友 1：虚拟/预设好友',
  PRIMARY KEY (`id`),
  UNIQUE KEY `guf_idx` (`gid`,`openid`,`fopenid`) USING BTREE,
  KEY `gid_fopenid` (`gid`,`fopenid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='结果记录表';

-- ----------------------------
-- Records of h5_match
-- ----------------------------
INSERT INTO `h5_match` VALUES ('4', '1', '1000000111222233322', 'c002', 'c002', 'http://q.qlogo.cn/c002', 'f001', 'f001', 'http://q.qlogo.cn/f001', '0.55', '2016-03-28 13:15:28', null, '2000-01-01 00:00:00', '0');
INSERT INTO `h5_match` VALUES ('5', '1', '1000000111222233322', 'c001', 'c001', 'http://q.qlogo.cn/c001', 'f001', 'f001', 'http://q.qlogo.cn/f001', '0.69', '2016-03-28 13:15:29', null, '2000-01-01 00:00:00', '0');
INSERT INTO `h5_match` VALUES ('6', '1', '1000000111222233322', 'f002', 'f001', 'http://q.qlogo.cn/f002', 'c001', 'c001', 'http://q.qlogo.cn/c001', '0.23', '2016-03-28 13:15:27', null, '2000-01-01 00:00:00', '0');
INSERT INTO `h5_match` VALUES ('7', '1', '1000000111222233322', 'f001', 'f001', 'http://q.qlogo.cn/f001', 'c001', 'c001', 'http://q.qlogo.cn/c001', '0.89', '2016-03-28 13:15:19', null, '2016-03-25 15:46:00', '0');
INSERT INTO `h5_match` VALUES ('8', '1', '1000000111222233322', 'f001', 'f001', 'http://q.qlogo.cn/f001', 'c002', 'c002', 'http://q.qlogo.cn/c002', '0.82', '2016-03-28 13:15:21', null, '2016-03-25 15:46:09', '0');
INSERT INTO `h5_match` VALUES ('9', '1', '1000000111222233322', 'f001', 'f001', 'http://q.qlogo.cn/f001', 'c003', 'c003', 'http://q.qlogo.cn/c003', '0.79', '2016-03-28 13:15:22', null, '2016-03-25 15:46:15', '0');
INSERT INTO `h5_match` VALUES ('10', '1', '1000000111222233322', '002', 'f001', 'http://q.qlogo.cn/f001', '001', 'c004', 'http://q.qlogo.cn/c004', '0.29', '2016-03-28 14:29:44', null, '2016-03-25 15:46:18', '0');
INSERT INTO `h5_match` VALUES ('11', '1', '1000000111222233322', '002', 'f001', 'http://q.qlogo.cn/f001', '005', 'c005', 'http://q.qlogo.cn/c005', '0.99', '2016-03-28 14:29:30', null, '2016-03-25 15:46:23', '0');
INSERT INTO `h5_match` VALUES ('12', '1', '1000000111222233322', 'f001', 'f001', 'http://q.qlogo.cn/f001', 'c006', 'c006', 'http://q.qlogo.cn/c006', '0.39', '2016-03-28 13:36:15', null, '2016-03-25 15:48:00', '0');
INSERT INTO `h5_match` VALUES ('15', '1', '0', '001', '分享者1', 'http://q.qlogo.cn/qqapp/1104974870/25EA09D65E48973EEB6B74723A861E36/100', '005', '查看者5', 'http://q.qlogo.cn/qqapp/1104974870/A5699A8DFB5D408CA091A8230D729F24/100', '0.89', '2016-03-28 14:50:29', null, '2016-03-28 14:50:20', '0');
INSERT INTO `h5_match` VALUES ('17', '1', '0', '001', '分享者1', 'http://q.qlogo.cn/qqapp/1104974870/25EA09D65E48973EEB6B74723A861E36/100', '008', '查看者5', 'http://q.qlogo.cn/qqapp/1104974870/A5699A8DFB5D408CA091A8230D729F24/100', '0.89', '2016-03-28 14:50:53', null, '2016-03-28 14:50:43', '0');
INSERT INTO `h5_match` VALUES ('18', '1', '0', '001', '分享者1', 'http://q.qlogo.cn/qqapp/1104974870/25EA09D65E48973EEB6B74723A861E36/100', '009', '查看者5', 'http://q.qlogo.cn/qqapp/1104974870/A5699A8DFB5D408CA091A8230D729F24/100', '0.89', '2016-03-28 14:51:03', null, '2016-03-28 14:50:53', '0');
INSERT INTO `h5_match` VALUES ('20', '1', '0', '001', '分享者1', 'http://q.qlogo.cn/qqapp/1104974870/25EA09D65E48973EEB6B74723A861E36/100', '010', '查看者5', 'http://q.qlogo.cn/qqapp/1104974870/A5699A8DFB5D408CA091A8230D729F24/100', '0.89', '2016-03-28 17:27:43', null, '2016-03-28 17:27:33', '0');
INSERT INTO `h5_match` VALUES ('21', '1', '0', '0', '0', '0', '0', '0', '0', '0', '2016-03-29 20:45:44', null, '2016-03-29 20:45:44', '0');

-- ----------------------------
-- Table structure for `h5_qgroup`
-- ----------------------------
DROP TABLE IF EXISTS `h5_qgroup`;
CREATE TABLE `h5_qgroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questions` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '包含的问题id，逗号分隔；如：1,2,3',
  `title` varchar(128) NOT NULL COMMENT '题目组名字',
  `description` varchar(256) NOT NULL COMMENT '题目组描述',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of h5_qgroup
-- ----------------------------
INSERT INTO `h5_qgroup` VALUES ('1', '1,4,5', '啊啊啊啊', '第三点', '2016-03-25 19:30:54', '2000-01-01 00:00:00');

-- ----------------------------
-- Table structure for `h5_question`
-- ----------------------------
DROP TABLE IF EXISTS `h5_question`;
CREATE TABLE `h5_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qa` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '问题A选项',
  `qb` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '问题B选项',
  `description` varchar(512) NOT NULL COMMENT '问题描述',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of h5_question
-- ----------------------------
INSERT INTO `h5_question` VALUES ('1', 'http://test.funchoice.cn/img/1.png', 'http://test.funchoice.cn/img/2.png', '你准备选择哪个呢', '2016-03-29 20:35:56', '2016-03-25 00:00:00');
INSERT INTO `h5_question` VALUES ('2', 'http://test.funchoice.cn/img/3.png', 'http://test.funchoice.cn/img/4.png', '案说法是发顺丰', '2016-03-29 20:37:12', '2000-01-01 00:00:00');
INSERT INTO `h5_question` VALUES ('3', 'http://test.funchoice.cn/img/5.png', 'http://test.funchoice.cn/img/6.png', 'hhhhhhh', '2016-03-29 20:37:16', '2000-01-01 00:00:00');
INSERT INTO `h5_question` VALUES ('4', 'http://test.funchoice.cn/img/3.png', 'http://test.funchoice.cn/img/4.png', 'bbbbbb', '2016-03-29 20:39:27', '2000-01-01 00:00:00');
INSERT INTO `h5_question` VALUES ('5', 'http://test.funchoice.cn/img/5.png', 'http://test.funchoice.cn/img/6.png', '3333', '2016-03-29 20:39:31', '2000-01-01 00:00:00');

-- ----------------------------
-- Table structure for `h5_user`
-- ----------------------------
DROP TABLE IF EXISTS `h5_user`;
CREATE TABLE `h5_user` (
  `openid` varchar(64) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '用户唯一标识',
  `pic` varchar(1024) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '用户头像',
  `nickName` varchar(64) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '用户昵称',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  PRIMARY KEY (`openid`),
  UNIQUE KEY `uid_idx` (`openid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of h5_user
-- ----------------------------
INSERT INTO `h5_user` VALUES ('MjA1ODMxMDQwMQ', 'http://mp.weixin.qq.com/mp/qrcode?scene=10000001&size=102&__biz=MjA1ODMxMDQwMQ==', '丁香医生', '2016-03-25 09:44:33');
INSERT INTO `h5_user` VALUES ('myopenid', 'mypic', 'ffshi', '2016-03-25 09:45:00');

-- ----------------------------
-- Table structure for `weixin_user`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_user`;
CREATE TABLE `weixin_user` (
  `id` varchar(64) NOT NULL,
  `openid` varchar(64) NOT NULL COMMENT '用户的唯一标识 ',
  `nickname` varchar(64) DEFAULT '' COMMENT '用户昵称',
  `sex` varchar(2) DEFAULT '0' COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `province` varchar(20) DEFAULT '' COMMENT '用户个人资料填写的省份',
  `city` varchar(20) DEFAULT '' COMMENT '普通用户个人资料填写的城市',
  `country` varchar(20) DEFAULT '' COMMENT '国家，如中国为CN ',
  `headimgurl` varchar(1000) DEFAULT '' COMMENT '用户头像,最后一个数值代表正方形头像大小',
  `privilege` varchar(1000) DEFAULT '' COMMENT '用户特权信息',
  `unionid` varchar(100) DEFAULT '' COMMENT '获取用户个人信息（UnionID机制）',
  `access_token` varchar(300) DEFAULT '' COMMENT '网页授权接口调用凭证,与基础支持的access_token不同 ',
  `refresh_token` varchar(300) DEFAULT '' COMMENT '用户刷新access_token ',
  `lang` varchar(10) DEFAULT '' COMMENT '返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语',
  `expires_in` int(11) DEFAULT NULL COMMENT 'access_token接口调用凭证超时时间，单位（秒）',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记0正常1删除',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `weixin_user_openid` (`openid`) USING BTREE,
  KEY `weixin_user_update_date` (`update_date`),
  KEY `weixin_user_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微信用户表';

-- ----------------------------
-- Records of weixin_user
-- ----------------------------
INSERT INTO `weixin_user` VALUES ('06b6d6c5b716455d966e73495fcfdb7a', 'orjG9wqakUzMr4VBF7or9u0fJ9bE', 'A残雪♋️', '1', '北京', '海淀', '中国', 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLDClYKUPWyAsgKEbESASoGLwdM0vNHg6TGia1mFPSBicH8qL1c6iaUEE2rsia4ShDEQXJxhw86ZHW1sNg/0', null, 'oIqP7szWlhfMuungXqYsSIaq-P8A', 'OezXcEiiBSKSxW0eoylIeCepHrTkGca9czkXQRNOnCvDqk-8wUHkSVy5U6MdAY2JfZ_IGXBX6JWgzyr3wQ5hsdeA9KEhqxfAO4xhCwsByMw5p3pS06ha3LQOW_hOTMOdhtSsYlPGE-44tYQ_okMnVQ', 'OezXcEiiBSKSxW0eoylIeCepHrTkGca9czkXQRNOnCvDqk-8wUHkSVy5U6MdAY2Jx_OYqu1WVkuFsakCCgClD18uINRI1qTmUwsQi_qRfbL9ssCLnLblQs767iN0YHNUgmYhe4dmKr-S6JPlCSpiSg', 'zh_CN', '7200', '0', '2016-03-28 14:41:09', '2016-03-30 14:11:17', null);
INSERT INTO `weixin_user` VALUES ('b7fca3c5bb894c25ac65752bc684f181', 'orjG9wj0nV0qJS5ge58eEdZW1-v4', '娜些光荫', '2', '北京', '', '中国', 'http://wx.qlogo.cn/mmopen/CzVkYkOYnibGEbiaIdzohpwjr7dOl4kibEIHch51hPMK538hp3mcUg0KCh17FmdMia7XzrnPiaLOJhIqNqiaznnicCxoKtFoZlnLQsC/0', null, 'oIqP7s_OoBH24QLxpVtMTdzQFL74', 'OezXcEiiBSKSxW0eoylIeCepHrTkGca9czkXQRNOnCuMDmSQljDQJYT6o963SdFSzWTxmzC0e-pLSlsU1lWh1xvqgYLZ3W6E937tDjdmKyZa2YNZ9nbt4zThGdnw6JKBESJwoOPzCSXw0b968bfI7A', 'OezXcEiiBSKSxW0eoylIeCepHrTkGca9czkXQRNOnCuMDmSQljDQJYT6o963SdFSQQOwDQJpkSkivYhRVBS4ZLQhEwFRyvcRtEMhf4awgI8XuTmUWujtmMyGsEONCvo4kENhyePN3DpzZC845ep6cg', 'zh_CN', '7200', '0', '2016-03-30 14:33:36', '2016-03-30 16:38:29', null);
