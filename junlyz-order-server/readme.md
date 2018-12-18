1、创建数据库：
CREATE DATABASE  IF NOT EXISTS orderdb DEFAULT CHARSET utf8;
2、创建数据库表:
CREATE TABLE tb_order(
	id INT AUTO_INCREMENT PRIMARY KEY,
	order_number VARCHAR(64) NOT NULL COMMENT '订单号',
	salesman VARCHAR(32) COMMENT '销售员姓名',
	salesman_number VARCHAR(32) COMMENT '工号',
	customer_id VARCHAR(32) COMMENT '客户编号',
	product_id INT COMMENT '产品id',
	order_status INT COMMENT '订单状态',
	is_valid INT COMMENT '是否有效',
	create_name VARCHAR(32) COMMENT '订单创建人',
	update_name VARCHAR(32) COMMENT '订单更新人',
	create_date DATE COMMENT '订单日期',
	update_date DATE COMMENT '更新日期'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE tb_customer(
	id INT AUTO_INCREMENT PRIMARY KEY,
	customer_number VARCHAR(64) NOT NULL COMMENT '客户编号',
	customer_name VARCHAR(32) COMMENT '客户姓名',
	age INT COMMENT '年龄',
	address VARCHAR(255) COMMENT '客户地址',
	phone VARCHAR(32) COMMENT '联系电话',
	gender ENUM('男','女'),
	is_valid INT COMMENT '是否有效',
	create_name VARCHAR(32) COMMENT '订单创建人',
	update_name VARCHAR(32) COMMENT '订单更新人',
	create_date DATE COMMENT '订单日期',
	update_date DATE COMMENT '更新日期'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO tb_customer VALUES(0, 'only-miss-20181216001', '妲己', 18, '朝歌', '13566668888', 2, 1, '唯念', '', SYSDATE(), SYSDATE());
INSERT INTO tb_customer VALUES(0, 'only-miss-20181216002', '杨贵妃', 16, '长安', '13566668822', 2, 1, '唯念', '', SYSDATE(), SYSDATE());
INSERT INTO tb_customer VALUES(0, 'only-miss-20181216003', '纣王', 28, '朝歌', '13566668899', 1, 1, '唯念', '', SYSDATE(), SYSDATE());

INSERT INTO tb_order VALUES(0, 'wn-20181216001', '唯念', 'Z001', 'only-miss-20181216001', 1, 1, 1, '唯念', '', SYSDATE(), SYSDATE());
INSERT INTO tb_order VALUES(0, 'wn-20181216002', '唯念', 'Z001', 'only-miss-20181216001', 3, 1, 1, '唯念', '', SYSDATE(), SYSDATE());
INSERT INTO tb_order VALUES(0, 'wn-20181216003', '唯念', 'Z001', 'only-miss-20181216003', 6, 1, 1, '唯念', '', SYSDATE(), SYSDATE());

