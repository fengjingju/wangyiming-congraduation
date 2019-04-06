/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : wangyiming-congraduation

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2019-04-06 20:54:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `uid` char(32) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('A6043E4CB32A40698F64449655D2EFB2', 'wangyiming', '1');

-- ----------------------------
-- Table structure for tbl_weibo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_weibo`;
CREATE TABLE `tbl_weibo` (
  `wid` char(32) DEFAULT NULL,
  `weiboNumber` int(11) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_weibo
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_weibo_comment
-- ----------------------------
DROP TABLE IF EXISTS `tbl_weibo_comment`;
CREATE TABLE `tbl_weibo_comment` (
  `wCid` char(32) NOT NULL,
  `commentNumber` int(11) DEFAULT NULL,
  `commentUser` int(255) DEFAULT NULL,
  `commentWeiBoNumber` int(11) DEFAULT NULL,
  `commentContent` varchar(2000) DEFAULT NULL,
  `emotionTendency` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_weibo_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_weibo_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_weibo_user`;
CREATE TABLE `tbl_weibo_user` (
  `wUid` char(32) NOT NULL,
  `userNumber` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `userCertificate` varchar(255) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `zone` varchar(50) DEFAULT NULL,
  `birth` varchar(50) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_weibo_user
-- ----------------------------
