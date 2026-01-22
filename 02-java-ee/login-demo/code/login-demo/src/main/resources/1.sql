create
database login_db;

use
login_db;

create table user
(
    id       int primary key auto_increment,
    username     varchar(10)  not null,
    password varchar(128) not null,
    gender   enum('男','女','保密') default '保密'
);

insert into user values(null, 'Doe', '123', '男');