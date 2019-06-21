/*
SQLyog Trial v12.2.3 (32 bit)
MySQL - 8.0.13 : Database - javastu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javastu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `javastu`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `coursenumber` varchar(10) NOT NULL,
  `coursename` varchar(20) NOT NULL,
  `period` varchar(4) NOT NULL,
  `credit` varchar(4) NOT NULL,
  PRIMARY KEY (`coursenumber`,`coursename`,`period`,`credit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`coursenumber`,`coursename`,`period`,`credit`) values 
('12','23','3','43'),
('201906','高级程序设计','48','3.0');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `department` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`number`,`name`,`sex`,`birthday`,`address`,`department`,`phone`) values 
('12234678','7757','男','56','78','969','9678'),
('1614','22','男','332','3','32','32'),
('16140','安克强','女','2017.2.2','11','11','11'),
('161401121','徐翰林','男','1997.09.16','江苏泰州','信息系统','18751883833'),
('232390','23','女','234','234','235','45'),
('23490','324','男','234','324','789','435'),
('432','53','男','453','453','453','453'),
('454','李钢','男','54645','456','456','546');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
