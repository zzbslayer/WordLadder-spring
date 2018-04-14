create database wordladder;
use wordladder

create table users
	(username		varchar(20),
	 pw		varchar(20),
	 email		varchar(50) NOT NULL UNIQUE,
     phone      varchar(20),
	 primary key (username)
	);

create table roles
    (username       varchar(20),
     rolename       varchar(10),
     primary key (username),
     foreign key (username) references users (username)
            on delete cascade
    );