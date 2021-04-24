
CREATE DATABASE /*!32312 IF NOT EXISTS*/`usercenter` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `usercenter`;
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


insert  into `sys_user`(`id`,`username`,`password`,`nickname`,`head_img_url`,`mobile`,`sex`,`enabled`,`type`,`create_time`,`update_time`,`company`,`open_id`,`is_del`) values (1,'admin','$2a$10$TJkwVdlpbHKnV45.nBxbgeFHmQRmyWlshg94lFu2rKxVtT2OMniDO','master1111','http://pkqtmn0p1.bkt.clouddn.com/头像.png','18888888888',0,1,'APP','2017-11-17 16:56:59','2019-01-08 17:05:47','ENGJ','123',0),(2,'user','$2a$10$HdvgvgLUi4xH481NV./rgOny4TeoyAY3jENtjBJUrHif0Qyg0tZoG','体验用户','http://payo7kq4i.bkt.clouddn.com/QQ%E5%9B%BE%E7%89%8720180819191900.jpg','18888888887',1,1,'APP','2017-11-17 16:56:59','2021-03-19 16:57:59','ENGJ',NULL,0),(3,'test','$2a$10$RD18sHNphJMmcuLuUX/Np.IV/7Ngbjd3Jtj3maFLpwaA6KaHVqPtq','测试账户','http://payo7kq4i.bkt.clouddn.com/QQ%E5%9B%BE%E7%89%8720180819191900.jpg','13851539156',0,0,'APP','2017-11-17 16:56:59','2018-09-07 03:27:40','ENGJ',NULL,0),(4,'1','$2a$10$dF4t14.6m.lQ39QjPCLcauxw2wlaNhlt2r7J9EP6z8sYFJrJUXKA.','11',NULL,'13530151800',1,1,'APP','2018-09-07 14:20:51','2021-03-19 17:09:52','YCC',NULL,0),(5,'12','$2a$10$cgRGZ0uuIAoKuwBoTWmz7eJzP4RUEr688VlnpZ4BTCz2RZEt0jrIe','12',NULL,'17587132062',0,1,'APP','2018-09-08 04:52:25','2018-09-16 01:48:00','YCC',NULL,0),(6,'abc1','$2a$10$pzvn4TfBh2oFZJbtagovFe56ZTUlTaawPnx0Yz2PeqGex0xbddAGu','abc',NULL,'12345678901',0,1,'APP','2018-09-11 08:02:25','2018-09-14 06:49:54','YCC',NULL,0),(7,'234','$2a$10$FxFvGGSi2RCe4lm5V.G0Feq6szh5ArMz.8Mzm08zQlkA.VgE9GFbm','ddd',NULL,'13245678906',0,1,'APP','2018-09-19 01:33:54','2018-09-19 01:33:54','JFSC',NULL,1),(8,'tester','$2a$10$VUfknatgKIoZJYDLIesrrO5Vg8Djw5ON2oDWeXyC24TZ6Ca/TWiye','tester',NULL,'12345678901',0,1,'APP','2018-09-19 04:52:01','2018-11-16 22:12:04','JFSC',NULL,1),(9,'11111111111111111111','$2a$10$DNaUDpCHKZI0V9w.R3wBaeD/gGOQDYjgC5fhju7bQLfIkqsZV61pi','cute','http://payo7kq4i.bkt.clouddn.com/C:\\Users\\GAOY91\\Pictures\\79f0f736afc37931a921fd59e3c4b74543a91170.jpg','15599999991',1,1,'APP','2018-09-19 04:57:39',NULL,'JFSC',NULL,1),(10,'test001','123456','test001',NULL,'11111111',0,1,'BACKEND','2018-09-12 13:50:57','2019-01-07 13:04:18',NULL,NULL,1),(11,'test002','123456','test002',NULL,'22222222',0,1,'BACKEND','2018-09-11 08:02:25','2018-09-14 06:49:54',NULL,NULL,1),(12,'123','$2a$10$PgngbC9pQWDT.ZG37fvV6e8Zi0C3mQOVMJJE35.XQULnppSEWhyPK','12',NULL,'1',0,1,'BACKEND','2019-01-19 13:44:02','2019-01-19 13:44:02',NULL,NULL,1),(13,'demo','123456','demo管理员',NULL,NULL,NULL,1,'APP',NULL,NULL,NULL,NULL,0),(15,'liu001','liu001','liu001',NULL,'18627868759',1,1,'1','2021-03-31 23:05:10','2021-03-31 23:05:10','wuhan',NULL,0),(16,'liu001','liu001','liu001',NULL,'18627868759',1,1,'APP','2021-03-31 23:08:39','2021-03-31 23:08:39','wuhan',NULL,0),(17,'liu001','liu001','liu001',NULL,'18627868759',1,1,'APP','2021-03-31 23:12:54','2021-03-31 23:12:54','wuhan',NULL,0),(18,'liu001','liu001','liu001',NULL,'18627868759',1,1,'APP','2021-03-31 23:14:40','2021-03-31 23:14:40','wuhan',NULL,0);

