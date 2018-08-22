
/*
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
*/

create table if not exists category (
	id int not null auto_increment,
	name varchar(255),
	primary key (id)
);

create table if not exists product (
	id int not null auto_increment,
	catid int,
	name varchar(255) DEFAULT 'UNKNOWN PRODUCT',
	price decimal(10,2)  DEFAULT 0.0,
	primary key (id),
    foreign key (catid)
        references category(id)
);

create table if not exists orders (
	id int not null auto_increment,
	prdid int,
	quantity int DEFAULT 1,
	contact varchar(255)  DEFAULT '04xxxxxxxx',
	primary key (id),
    foreign key (prdid)
        references product(id)
);
