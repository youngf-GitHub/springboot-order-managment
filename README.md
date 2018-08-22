## order-managment-demo

This is a demo program for the Product Order management.


### Tables:
  Category: (ID<PK>, NAME)
  Product: (ID<PK>, CATID<FK>, PRICE)
  Orders: (ID<PK>, PRDID<FK>, CNT, PHONE)


### Web UI:

  The web page shows the lists of Category, Product and Orders, and provide the links to add/update/delete the corresponding records.


### Database creation and initialization

  The database structure and initial data are created when the server starts up.


### Limitations:

1) Input data validation (type, length) is omitted.
2) Data integrity validation is omitted.
