DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS
(
    userId   varchar(12) NOT NULL,
    password varchar(12) NOT NULL,
    name     varchar(20) NOT NULL,
    email    varchar(50),

    PRIMARY KEY (userId)
);

insert into users values('id','pwd','name','email');
insert into users values('asdf','pd','nm','em');