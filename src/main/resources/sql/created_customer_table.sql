create table customer(
id bigint auto_increment not null,
uid varchar(100) unique not null ,
first_name varchar (30) not null,
last_name varchar (30) not null,
email varchar (100) not null,
phone bigint (10) not null,
primary key(id)
);
