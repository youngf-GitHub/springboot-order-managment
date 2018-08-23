
import pymysql
import warnings

class Category:

    def __init__(self):
        self.id = 0
        self.name = ""

    def __repr__(self):
        return " ({},{}))".format(self.id,self.name)


class Product:

    def __init__(self):
        self.id = 0
        self.catid = 0
        self.name = ""
        self.price = 0.0

    def __repr__(self):
        return " ({},{},{},{}))".format(self.id,self.name,self.name,self.price)

class Order:

    def __init__(self):
        self.id = 0
        self.prdid = 0
        self.quantity = 1
        self.contact = ""

    def __repr__(self):
        return " ({},{},{},{}))".format(self.id,self.prdid,self.quantity,self.contact)


class Database:

    def __init__(self):
        self.host = "mydbinstance.cacbnttmboqy.ap-southeast-2.rds.amazonaws.com"
        self.port = 3306
        self.user = 'admin'
        self.password = 'password1'
        self.db = 'orderdb'
        self.connection = None

    def _connect(self):
        self.connection = pymysql.connect(
                host=self.host,
                port=self.port,
                user=self.user,
                passwd=self.password,
                db=self.db
             )
        return self.connection.cursor()

    def _disconnect(self):
        self.connection.close()


    def get_cat_by_id(id):
        cat = Category()
        sql = "select id, name from category where id = %d" % id
        cursor = _connect()
        cursor.execute(sql)
        row = cursor.fetchone()
        cat.id = row[0]
        cat.name = row[1]
        _disconnect()
        return cat

    def get_product_by_id(id):
        product = Product()
        sql = "select id, catid, name, price from product where id = %d" % id
        cursor = _connect()
        cursor.execute(sql)
        row = cursor.fetchone()
        product.id = row[0]
        product.catid = row[1]
        product.name = row[2]
        product.price = row[3]
        _disconnect()
        return product


    def get_order_by_id(id):
        order = Order()
        sql = "select id, prdid, quantity, contact from orders where id = %d" % id
        cursor = _connect()
        cursor.execute(sql)
        row = cursor.fetchone()
        order.id = row[0]
        order.prdid = row[1]
        order.quantity = row[2]
        order.contact = row[3]
        _disconnect()
        return order


    def get_all_cat():

        list = []
        sql = "select id, name from category"
        cursor = _connect()
        cursor.execute(sql)
        rows= cursor.fetchall()
        for row in rows:
            cat = Category()
            cat.id = row[0]
            cat.name = row[1]
            list.append(cat)

        _disconnect()

        return list
