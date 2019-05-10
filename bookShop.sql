drop database if exists book_ssm_db;
create database book_ssm_db;
use book_ssm_db;

-- 用户角色表
drop table if exists t_role;
create table t_role(
id int primary key auto_increment,
rolename varchar(20)
);

-- 用户表
drop table if exists t_user;
create table t_user (
id int primary key auto_increment,
username  varchar(20) unique,
password varchar(56) not null,
photoname varchar(150),
sex boolean,
age int,
roleid int not null,
phone VARCHAR(15),-- 电话
foreign key (roleId) references t_role(id)
);


-- 图书分类表
drop table if exists t_type;
CREATE TABLE t_type(
id int PRIMARY KEY auto_increment ,
NAME VARCHAR(50),
descr VARCHAR(50) -- 分类说明
);


-- 图书属性表
drop table if exists t_book;
CREATE TABLE t_book(
id int PRIMARY KEY auto_increment,
NAME VARCHAR(50),
price FLOAT,-- 原价
auth  VARCHAR(30), -- 作者
img VARCHAR(40), -- 图书的图片名称UUID
rebate NUMERIC(3,2), -- 0.xx保留两位
stock INT,
publisher VARCHAR(50), -- 出版社名称
publishdate DATE, -- 出版日期
pages INT, -- 页数
size VARCHAR(10), -- 开本
printtimes INT, -- 印次
versions INT, -- 版次
brief TEXT, -- 内容简介
content VARCHAR(4000), -- 目录,必须一显示格式良好的HTMl文本保存
onlinetime DATE  -- 上架时间
);

-- 图书分类和图书关系表
drop table if exists t_booktype;
CREATE TABLE t_booktype(
bookid int,
typeid int,
PRIMARY KEY(bookid,typeid),
FOREIGN KEY (bookid) REFERENCES t_book(id),
FOREIGN KEY (typeid) REFERENCES t_type(id)
-- constraint booktype-book foreign key (bookId) REFERENCES t_books(id),
-- CONSTRAINT booktype-type FOREIGN KEY (typeId) REFERENCES t_types(id)
);



insert into t_role(rolename) values('用户'),('商家');

insert into t_user(username,password,photoname,sex,age,roleid,phone) values('flower','flower',null,false,21,'2',15820872232);

insert into t_type(name) values('言情'),('武侠'),('军事'),('政治'),('教育'),('计算机'),('养生'),('科幻');



insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('那个背影',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('java并发编程实战',33,'大牛',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('平民公主的美颜手记',33,'王子墨',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('解忧杂货店',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('三生三世枕上书',33,'唐七',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('花千骨',33,'fresh果果',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('乖，摸摸头',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('嗨，低头族',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-2-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('穿山甲',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-4-11');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('窗台的花',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('名侦探柯南',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('安徒生童话',33,'大牛',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-2-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('十万个为什么',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-3-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('剑指offer',33,'大牛',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2017-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('知否，知否，应是绿肥红瘦',33,'大牛',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-2-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('Java编程思想',33,'小白',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-3-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('编程之美',33,'大牛',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2017-1-21');
insert into t_book(name,price,auth,img,rebate,stock,publisher,publishdate,pages,size,printtimes,versions,brief,content,onlinetime)
values('java程序员面试笔试宝典',33,'大牛',null,0.75,120,'青青文学出版社','2017-1-8',350,'16开',3,3,'鬼马精灵的萝莉girl与耿直学霸boy的校园爱情故事',null,'2018-2-21');

-- 管理员表
drop table if exists t_admin;
create table t_admin(
id VARCHAR(32) PRIMARY KEY,
NAME VARCHAR(20) unicode,
PASSWORD VARCHAR(50) not null, -- 密码需要进行加密
roleid int not null,
sex CHAR(2) default 1,
email VARCHAR(30),
descr VARCHAR(50), -- 管理员描述
foreign key (roleid) references t_role(id)
);

-- 商家店铺表
drop table if exists t_merchant;
CREATE TABLE t_merchant(
id int primary key auto_increment,
mname varchar(32) unique,-- 店铺昵称
rname varchar(32),-- 商家真实姓名
city varchar(60),-- 所在地区
phone varchar(20),
applynum varchar(32)-- 支付宝
);

-- 用户收货地址列表
drop table if exists t_address;
CREATE TABLE t_address(
uid int PRIMARY KEY auto_increment,
NAME VARCHAR(20),-- 收货人姓名
phone VARCHAR(20),
address varchar(70),-- 收货地址
addressdetail varchar(100), -- 收货地址明细
zip VARCHAR(10), -- 邮编
dft CHAR(1),-- 1,是, 0,否 是否为默认地址
descr VARCHAR(50),
mktime DATE ,-- 方便按时间倒序排列
FOREIGN KEY (uid) REFERENCES t_user(id)
);

use book_ssm_db;
-- 订单id、创建时间、修改时间、付款方式、金额、支付状态、订单编号
-- 用户订单表
drop table if exists t_order;
CREATE TABLE  t_order(
id VARCHAR(32) PRIMARY Key,-- 订单编号,应该是用随机数生成出来的
uid int,
consignee VARCHAR(300),-- 收货人的明细信息
paytype CHAR(1),-- 1,货到付款 2,网上支付
amt NUMERIC(10,2),-- 订单总金额
state INT, -- 订单状态,每个数字代表一种状态 0:待支付  1：已支付-待发货 2：已关闭-超时未支付或取消 3：已发货 4：已收货
orderdate timestamp null default current_timestamp,-- yyyy-MM--dd HH:mm:ss--订单生成时间
updatetime timestamp on update current_timestamp,-- 订单更新时间，创建时为0值，以后修改时自动更新为当前时间
sendgoods timestamp null,-- 发货时间
FOREIGN KEY (uid) REFERENCES t_user(id)
);

use book_ssm_db;
-- 订单项
drop table if exists t_orderItem;
CREATE TABLE  t_orderItem(
id VARCHAR(32) PRIMARY KEY,
orderid VARCHAR(32),-- 所属订单号
bookid int ,-- 图书ID
amt INT,-- 书的数量
price FLOAT, -- 价格
FOREIGN KEY (orderid) REFERENCES t_order(id),
FOREIGN KEY (bookid) REFERENCES t_book(id)
);

-- 最近浏览表
drop table if exists t_recentbrowse;
create table t_recentbrowse(
uid int primary key,
bookid int,
watchtimes int,
foreign key (uid) references  t_user(id),
foreign key (bookid) references t_book(id)
);




-- 购物车表
-- 每个用户都有一个购物车
-- drop table if exists t_shopcar;
-- create table t_shopcar(
-- id int primary key auto_increment,
-- uid int,
-- count int,-- 同种商品的件数，从前台的下拉框中获取
-- pcmoney float,-- 同种商品的总价
-- money float,-- 购物车中的商品总价
-- foreign key (uid) references t_user(id)
-- );

-- alter table t_shopcar add constraint car_user foreign key(uid) REFERENCES t_user(id) on update cascade on delete cascade;
-- 购物车和商品关系对应表
-- 多对多
/*drop table if exists t_carbook;
create table t_carbook(
bid int, -- 图书id
carid int, -- 购物车id
foreign key (bid) references  t_book(id),
foreign key (carid) references  t_shopcar(id)
);
*/


-- 购物车表
-- 每个用户都有一个购物车
drop table if exists t_shopcar;
create table t_shopcar(
uid int,
bid int,
num int,-- 同种商品的数量
`status` tinyint(4) default 1,-- 1:正常，0：禁用，-1：删除
create_time timestamp default current_timestamp,-- 记录创建时间，时间戳，在创建新纪录时吧这个字段值设置为当前时间，但以后修改时不再更新它
update_time timestamp on update current_timestamp,-- 记录更新时间，时间戳,在创建新纪录时吧这个字段值设为0，但以后修改的时候更新为当前的时间戳
-- foreign key(uid) references t_user(id),
foreign key (uid) references t_user(id)  on update cascade on delete cascade,
foreign key(bid) references t_book(id)
);

drop trigger if exists insert_usercar ;
/*
-- 当向t_uesr中插入一条数据时，购物车表中也插入一条数据
delimiter ||

drop trigger if exists insert_usercar ||

create trigger insert_usercar

after insert on t_user for each row

begin

insert into t_shopcar(uid) values(new.id);-- new表示t_user中刚添加的记录

end||

delimiter ||
*/

insert into t_shopcar(uid,bid,num,status) values(1,1,1,1);
insert into t_shopcar(uid,bid,num,status) values(1,2,1,1);



-- 书架
drop table if exists t_bookrack;
create table t_bookrack(
uid int primary key,
bookid int,
foreign key (uid) references t_user(id),
foreign key (bookid) references t_book(id)
);

alter table t_type add column parent_id INT(11) DEFAULT NULL COMMENT '参考主键id';

alter table t_type add constraint id_parent foreign key(parent_id) REFERENCES t_type(id) on delete cascade;

insert into t_type(NAME,descr,parent_id) values
('都市言情','都市里的爱情故事',1),('古装言情','古代的爱情故事',1),('校园言情','都市里的爱情故事',1);
insert into t_type(NAME,descr,parent_id) values
('数据库','mysql,Oracle,MongDB,Redis',6),('Java','java基础，web框架',6),('C++','面向对象程序设计',6),('数据结构算法','数据结构和算法相关',6);
insert into t_type(NAME,descr,parent_id) values
('修仙','仙侠小说',2),('经典','例如金庸，古龙',2);
insert into t_type(NAME,descr,parent_id) values
('穿越','从一个世纪穿越到另一个世纪',8),('探险','例如到太空旅行',8);

insert into t_booktype values (1,5),(10,5),(14,15),(16,15),(18,15),(2,15),
(6,2),(6,10),(3,7),(7,9),(8,9),(9,9),(13,5),(12,8),(15,10);
