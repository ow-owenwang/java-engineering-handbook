create
database db;

use
db;

create table user
(
    id       int primary key auto_increment,
    username varchar(20)  not null,
    password varchar(256) not null,
    gender   varchar(5),
    age      int,
    address  varchar(32),
    qq       varchar(20),
    email    varchar(50)
);

insert into `user`(`id`, `username`, `password`, `gender`, `age`, `address`, `qq`, `email`)
values (1, '张三', '000', '男', 13, '陕西', '12345', 'zhangsan@itcast.cn');
insert into `user`(`id`, `username`, `password`, `gender`, `age`, `address`, `qq`, `email`)
values (2, '李四', '123', '女', 15, '北京', '88888', 'ls@itcast.cn');

select *
from user;