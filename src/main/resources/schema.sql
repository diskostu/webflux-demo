DROP TABLE IF EXISTS users;

create table users
(
    id       serial primary key,
    name     varchar(255),
    surname  varchar(255),
    username varchar(255),
    email    varchar(255),
    passport varchar(255)
);


insert into users (name, surname, username, email, passport)
values ('Meier', 'Markus', 'demo1', 'demo1@lala.com', '12345');

insert into users (name, surname, username, email, passport)
values ('Schulze', 'Peter', 'demo2', 'demo2@lala.com', '23456');

insert into users (name, surname, username, email, passport)
values ('Koenig', 'Sabine', 'demo3', 'demo3@lala.com', '34567');

insert into users (name, surname, username, email, passport)
values ('Salbei', 'Ursula', 'demo4', 'demo4@lala.com', '45678');

insert into users (name, surname, username, email, passport)
values ('Trotz', 'Tina', 'demo5', 'demo5@lala.com', '567890');

insert into users (name, surname, username, email, passport)
values ('Unsinn', 'Tim', 'demo6', 'demo6@lala.com', '678901');
