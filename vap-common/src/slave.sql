CREATE DATABASE /*!32312 IF NOT EXISTS*/`slave` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `slave`;
DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `username` varchar(50) NOT NULL,
                            `password` varchar(60) NOT NULL,
                            `nickname` varchar(255) DEFAULT NULL,
                            `head_img_url` varchar(1024) DEFAULT NULL,
                            `mobile` varchar(11) DEFAULT NULL,
                            `sex` tinyint(1) DEFAULT NULL,
                            `enabled` tinyint(1) NOT NULL DEFAULT '1',
                            `type` varchar(16) NOT NULL,
                            `create_time` datetime DEFAULT NULL,
                            `update_time` datetime DEFAULT NULL,
                            `company` varchar(255) DEFAULT NULL,
                            `open_id` varchar(32) DEFAULT NULL,
                            `is_del` tinyint(1) NOT NULL DEFAULT '0',
                            PRIMARY KEY (`id`),
                            KEY `idx_username` (`username`),
                            KEY `idx_mobile` (`mobile`),
                            KEY `idx_open_id` (`open_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

insert  into `sys_user`(`id`,`username`,`password`,`nickname`,`head_img_url`,`mobile`,`sex`,`enabled`,`type`,`create_time`,`update_time`,`company`,`open_id`,`is_del`) values (1,'slave','slave','slave','slave','13652356958',0,1,'APP','2017-11-17 16:56:59','2019-01-08 17:05:47','ENGJ','123',0);
