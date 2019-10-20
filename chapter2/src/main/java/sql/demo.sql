CREATE DATABASE demo;
USE demo;

CREATE TABLE customer (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键(自增长)',  
	`name` VARCHAR(255) NOT NULL	COMMENT '客户名称', 
	contact VARCHAR(255) NOT NULL	COMMENT '联系人', 
	telphone VARCHAR(255)	COMMENT '电话号码', 
	email VARCHAR(255)	COMMENT '邮箱地址',
	remark TEXT 	COMMENT '备注'

)ENGINE=MYISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO customer VALUES('1', 'customer1', 'Jack', '136212345678', 'jack@gmail.com', NULL);
INSERT INTO customer VALUES('2', 'customer1', 'Rose', '138712345678', 'rose@gmail.com', NULL);



