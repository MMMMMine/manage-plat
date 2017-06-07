# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.18)
# Database: xiuqi
# Generation Time: 2017-06-07 09:41:46 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table xq_admin
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xq_admin`;

CREATE TABLE `xq_admin` (
  `admin_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(20) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `xq_admin` WRITE;
/*!40000 ALTER TABLE `xq_admin` DISABLE KEYS */;

INSERT INTO `xq_admin` (`admin_id`, `account`, `password`, `role_id`, `create_time`, `update_time`)
VALUES
	(1,'admin','21232f297a57a5a743894a0e4a801fc3',1,'2017-05-22 11:55:59','2017-05-22 11:55:59');

/*!40000 ALTER TABLE `xq_admin` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table xq_app_query
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xq_app_query`;

CREATE TABLE `xq_app_query` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `query_name` varchar(50) DEFAULT NULL COMMENT '查询名称',
  `query_name_en` varchar(50) DEFAULT NULL COMMENT '查询名称(英文)',
  `query_desc` varchar(255) DEFAULT NULL COMMENT '查询描述',
  `query_sql` text COMMENT '查询sql',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `xq_app_query` WRITE;
/*!40000 ALTER TABLE `xq_app_query` DISABLE KEYS */;

INSERT INTO `xq_app_query` (`id`, `query_name`, `query_name_en`, `query_desc`, `query_sql`, `create_time`, `update_time`)
VALUES
	(14,'测试12','test14','测试','select * from xq_admin;','2017-06-07 16:30:08','2017-06-07 16:30:52'),
	(15,'测试12','test14','123','select * from xq_admin;','2017-06-07 17:30:09',NULL),
	(16,'测试12','test14','ceshi','select * from xq_admin;','2017-06-07 17:32:30',NULL);

/*!40000 ALTER TABLE `xq_app_query` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table xq_organization
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xq_organization`;

CREATE TABLE `xq_organization` (
  `org_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '机构id',
  `org_name` varchar(100) DEFAULT NULL COMMENT '机构名称',
  `org_des` varchar(100) DEFAULT NULL COMMENT '机构说明',
  `par_org` varchar(10) DEFAULT NULL COMMENT '直属父机构id',
  `par_org_list` varchar(255) DEFAULT NULL COMMENT '所有父机构id集合',
  `child_org_list` varchar(255) DEFAULT NULL COMMENT '所有子结构id集合',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `xq_organization` WRITE;
/*!40000 ALTER TABLE `xq_organization` DISABLE KEYS */;

INSERT INTO `xq_organization` (`org_id`, `org_name`, `org_des`, `par_org`, `par_org_list`, `child_org_list`, `create_time`, `update_time`)
VALUES
	(1,'秀起','最高机构','','','','2017-05-22 11:58:34','2017-05-22 11:58:34');

/*!40000 ALTER TABLE `xq_organization` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table xq_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `xq_role`;

CREATE TABLE `xq_role` (
  `role_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `org_id` int(11) DEFAULT NULL COMMENT '角色最高机构',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `xq_role` WRITE;
/*!40000 ALTER TABLE `xq_role` DISABLE KEYS */;

INSERT INTO `xq_role` (`role_id`, `role_name`, `org_id`, `create_time`, `update_time`)
VALUES
	(1,'超级管理员',1,'2017-05-22 12:00:59','2017-05-22 12:00:59');

/*!40000 ALTER TABLE `xq_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
