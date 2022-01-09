create table user(
    id bigint auto_increment  primary key not null,
    name varchar(45),
    loginId varchar(45),
    password varchar(256),
    email varchar(256)
 );