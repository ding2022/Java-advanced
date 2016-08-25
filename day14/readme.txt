1、新建库和表、导包
create database day14 character set utf8 collate utf8_general_ci;

use day14;

create table users(
	id int primary key,
	name varchar(40),
	password varchar(40),
	email varchar(60),
	birthday date
);

insert into users(id,name,password,email,birthday) values(1,'zs','123456','zs@sina.com','1980-12-04');
insert into users(id,name,password,email,birthday) values(2,'lisi','123456','lisi@sina.com','1981-12-04');
insert into users(id,name,password,email,birthday) values(3,'wangwu','123456','wangwu@sina.com','1979-12-04');


1.加载驱动
2、创建与数据库的链接
3、得到用于向数据库发送sql语句的 statement
4、向数据库发sql，并得到代表结果集的resultset
5、从resultset获取数据
6、关闭链接、释放资源
