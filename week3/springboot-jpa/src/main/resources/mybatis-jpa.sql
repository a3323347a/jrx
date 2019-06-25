/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.44 : Database - jpa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jpa` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `jpa`;

/*Table structure for table `cst_customer` */

DROP TABLE IF EXISTS `cst_customer`;

CREATE TABLE `cst_customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cust_industry` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cust_level` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cust_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cust_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cust_source` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `cst_customer` */

insert  into `cst_customer`(`cust_id`,`cust_address`,`cust_industry`,`cust_level`,`cust_name`,`cust_phone`,`cust_source`) values (1,'日本',NULL,NULL,'c#程序员',NULL,NULL),(2,'广东广州','it教育','高级会员','程序员',NULL,NULL),(6,'广东汕头','it培训','会员','中级教师',NULL,NULL),(7,NULL,NULL,NULL,'百度1',NULL,NULL),(8,'中国香港','数学教育','会员','高级教师',NULL,NULL);

/*Table structure for table `cst_linkman` */

DROP TABLE IF EXISTS `cst_linkman`;

CREATE TABLE `cst_linkman` (
  `lkm_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lkm_email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lkm_gender` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lkm_memo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lkm_mobile` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lkm_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lkm_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lkm_position` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lkm_cust_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`lkm_id`),
  KEY `FKh9yp1nql5227xxcopuxqx2e7q` (`lkm_cust_id`),
  CONSTRAINT `FKh9yp1nql5227xxcopuxqx2e7q` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `cst_linkman` */

insert  into `cst_linkman`(`lkm_id`,`lkm_email`,`lkm_gender`,`lkm_memo`,`lkm_mobile`,`lkm_name`,`lkm_phone`,`lkm_position`,`lkm_cust_id`) values (3,'123@qq.com','女',NULL,NULL,'张三',NULL,NULL,2),(4,NULL,NULL,NULL,NULL,'小李1',NULL,NULL,7);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`) values (1,'java程序员'),(2,'c#程序员'),(3,'php程序员'),(4,'数据库管理员');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`age`,`user_name`) values (1,15,'小李'),(2,15,'小王'),(3,23,'老张'),(4,44,'王五');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `sys_user_id` bigint(20) NOT NULL,
  `sys_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sys_user_id`,`sys_role_id`),
  KEY `FK1ef5794xnbirtsnudta6p32on` (`sys_role_id`),
  CONSTRAINT `FK1ef5794xnbirtsnudta6p32on` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FKsbjvgfdwwy5rfbiag1bwh9x2b` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`sys_user_id`,`sys_role_id`) values (1,1),(2,1),(3,1),(1,2),(1,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
