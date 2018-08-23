
from flask import Flask, render_template, url_for, redirect
from db import Category, Database

app = Flask(__name__)

@app.route("/", methods=['GET'])
def list():

    db = Database()
    cat_list = db.get_all_cat()

    return render_template('list.html', cat_list=cat_list)



@app.route("/addcat")
def addcat():
    pass


@app.route("/delcat")
def delcat():
    pass


@app.route("/savecat")
def savecat():
    pass




@app.route("/addprd")
def addprd():
    pass


@app.route("/delprd")
def delprd():
    pass


@app.route("/saveprd")
def saveprd():
    pass




@app.route("/addorder")
def addorder():
    pass


@app.route("/delorder")
def delorder():
    pass


@app.route("/saveorder")
def saveorder():
    pass



if __name__ == "__main__":
    db = Database()
    db._connect()
    print("connected")
    db._disconnect()
    print("disconnected")
    app.run(debug=True)
