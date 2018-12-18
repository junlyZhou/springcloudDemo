1、创建数据库：
CREATE DATABASE  IF NOT EXISTS productdb DEFAULT CHARSET utf8;
2、创建数据库表:
CREATE TABLE product(
   product_id INT PRIMARY KEY NOT NULL,
   product_name VARCHAR(255) COMMENT '产品名称',
   price DOUBLE COMMENT '价格',
   product_desc VARCHAR(512) COMMENT '产品描述',
   create_date DATE,
   create_name VARCHAR(32),
   update_date DATE,
   update_name VARCHAR(32)
) ENGINE = INNODB DEFAULT CHARSET=utf8;
3、插入测试数据:
INSERT INTO product(product_id , product_name, price, product_desc, create_date, create_name, update_date, update_name) 
VALUES(1, '雾眉', 1888, '无边框眉毛，接近真实眉毛', SYSDATE(), 'miss', SYSDATE(), 'miss'); 
INSERT INTO product(product_id , product_name, price, product_desc, create_date, create_name, update_date, update_name) 
VALUES(2, '花眉', 1666, '雾里看花眉毛', SYSDATE(), 'miss', SYSDATE(), 'miss'); 
INSERT INTO product(product_id , product_name, price, product_desc, create_date, create_name, update_date, update_name) 
VALUES(3, '一字眉', 888, '无边框直眉毛', SYSDATE(), 'miss', SYSDATE(), 'miss'); 
INSERT INTO product(product_id , product_name, price, product_desc, create_date, create_name, update_date, update_name) 
VALUES(4, '刀眉', 1688, '霸气男士眉毛', SYSDATE(), 'miss', SYSDATE(), 'miss'); 
INSERT INTO product(product_id , product_name, price, product_desc, create_date, create_name, update_date, update_name) 
VALUES(5, '水雾眉', 2888, '无痛秀美眉毛', SYSDATE(), 'miss', SYSDATE(), 'miss'); 
INSERT INTO product(product_id , product_name, price, product_desc, create_date, create_name, update_date, update_name) 
VALUES(6, 'baby唇', 1200, '拥有boby一样的唇', SYSDATE(), 'miss', SYSDATE(), 'miss'); 
INSERT INTO product(product_id , product_name, price, product_desc, create_date, create_name, update_date, update_name) 
VALUES(7, '大红唇', 1686, '大红唇，性感的嘴唇', SYSDATE(), 'miss', SYSDATE(), 'miss'); 
INSERT INTO product(product_id , product_name, price, product_desc, create_date, create_name, update_date, update_name) 
VALUES(8, '法式甲', 299, '美丽靓丽的指甲，值得你拥有', SYSDATE(), 'miss', SYSDATE(), 'miss'); 
COMMIT;
4、添加一列状态:
ALTER TABLE product ADD COLUMN ( product_status INT);
5、更新值：
UPDATE product SET product_status = 1 ;
