--drop database books;
--create database books;

create table author(author_id serial PRIMARY KEY,
name_author varchar(50) not null UNIQUE);

insert into author (name_author) values ('Булгаков М.А.'),
 ('Достоевский Ф.М.'), ('Есенин С.А.'),
 ('Пастернак Б.Л.'), ('Лермонтов М.Ю.');
 
create table genre(genre_id serial PRIMARY KEY,
name_genre varchar(50) not null UNIQUE);

insert into genre (name_genre) values
('Роман'),  ('Поэзия'), ('Приключения');

create table book (book_id serial PRIMARY KEY,	title varchar(50),
	author_id int not null,	genre_id int not null,	price decimal(8,2) not null,	amount int not null,
	UNIQUE (title, author_id, genre_id, price));
	
alter table book add constraint author_fk
foreign key (author_id) references author(author_id);
alter table book add constraint genre_fk
foreign key (genre_id) references genre(genre_id);

insert into book (title, author_id,	genre_id,	price,	amount)
values
('Мастер и Маргарита',	1,	1,	670.99,	3),
('Белая гвардия',	1,	1,	540.50,	5),
('Идиот',	2,	1,	460.00,	10),
('Братья Карамазовы',	2,	1,	799.01,	3),
('Игрок',	2,	1,	480.50,	10),
('Стихотворения и поэмы',	3,	2,	650.00,	15),
('Черный человек',	3,	2,	570.20,	6),
('Лирика',	4,	2,	518.99,	2);

