#!/usr/bin/python

import pymysql
import warnings

warnings.filterwarnings('ignore')


def create_initial_records(cursor):

    """ Create initial demo records """

    sql = """INSERT INTO category (NAME)
           SELECT %s FROM DUAL
           WHERE NOT EXISTS (SELECT 1 FROM category WHERE NAME=%s)"""
    val = [
        ('Monitor', 'Monitor'),
        ('Keyboard', 'Keyboard'),
        ('Mouse', 'Mouse')
    ]

    cursor.executemany(sql, val)


    sql = """INSERT INTO product (CATID, NAME, PRICE)
           SELECT A.ID, %s, 2000.99 FROM category A
           WHERE A.NAME=%s AND NOT EXISTS
                 (SELECT 1 FROM category A, product B
                  WHERE A.ID=B.CATID AND A.NAME=%s AND B.NAME=%s)"""
    val = [
        ('Dell', 'Monitor', 'Monitor', 'Dell'),
        ('Apple', 'Monitor', 'Monitor', 'Apple'),
        ('Logitech', 'Keyboard', 'Keyboard', 'Logitech'),
        ('Logitech', 'Mouse', 'Mouse', 'Logitech'),
        ('HP', 'Mouse', 'Mouse', 'HP')
    ]

    cursor.executemany(sql, val)

    sql = """INSERT INTO orders (PRDID, QUANTITY, CONTACT)
           SELECT B.ID, 1, %s FROM category A, product B
           WHERE A.ID=B.CATID
                AND A.NAME=%s
                AND B.NAME=%s AND NOT EXISTS
                (SELECT 1 FROM category A, product B, orders C
                 WHERE A.ID=B.CATID AND B.ID=C.PRDID AND A.NAME=%s
                     AND B.NAME=%s AND C.CONTACT=%s)"""
    val = [
        ('0400100101', 'Monitor', 'Dell', 'Monitor', 'Dell', '0400100101'),
        ('0400100102', 'Monitor', 'Apple', 'Monitor', 'Apple', '0400100102'),
        ('0400100103', 'Keyboard', 'Logitech', 'Keyboard', 'Logitech', '0400100103'),
        ('0400100104', 'Mouse', 'Logitech', 'Mouse', 'Logitech', '0400100104'),
        ('0400100105', 'Mouse', 'HP', 'Mouse', 'HP', '0400100105'),
        ('0400100999', 'Mouse', 'HP', 'Mouse', 'HP', '0400100999')
    ]

    cursor.executemany(sql, val)


def create_tables(cursor):

    """ Create tables if not exists """

    create_sql = """create table if not exists category (
	id int not null auto_increment,
	name varchar(255),
	primary key (id)
    )"""
    cursor.execute(create_sql)

    create_sql = """create table if not exists product (
	id int not null auto_increment,
	catid int,
	name varchar(255) DEFAULT 'UNKNOWN PRODUCT',
	price decimal(10,2)  DEFAULT 0.0,
	primary key (id),
        foreign key (catid)
        references category(id)
    )"""
    cursor.execute(create_sql)

    create_sql = """create table if not exists orders (
	id int not null auto_increment,
	prdid int,
	quantity int DEFAULT 1,
	contact varchar(255)  DEFAULT '04xxxxxxxx',
	primary key (id),
        foreign key (prdid)
        references product(id)
    )"""
    cursor.execute(create_sql)


def drop_tables(cursor):

    """ Dorp all tables """

    drop_sql= "DROP TABLE IF EXISTS orders"
    cursor.execute(drop_sql)

    drop_sql= "DROP TABLE IF EXISTS product"
    cursor.execute(drop_sql)

    drop_sql= "DROP TABLE IF EXISTS category"
    cursor.execute(drop_sql)


def main():

    connection = pymysql.connect(
            host='mydbinstance.cacbnttmboqy.ap-southeast-2.rds.amazonaws.com',
            port=3306,
            user='admin',
            passwd='password1',
            db='orderdb'
         )

    try:

        cursor = connection.cursor()

#        drop_tables(cursor)
        create_tables(cursor)
        create_initial_records(cursor)

        connection.commit()

    except ValueError as e:
        print(e.args)

    connection.close()


if __name__ == "__main__":
    main()
