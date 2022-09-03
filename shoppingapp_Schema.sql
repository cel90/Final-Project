use shoppingapp ;

DROP TABLE IF EXISTS order_product;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS products;


CREATE TABLE customer (
  customer_id int unsigned NOT NULL AUTO_INCREMENT primary key ,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  phone varchar(20)
);

CREATE TABLE orders (
order_id int unsigned NOT NULL AUTO_INCREMENT primary key ,
customer_id int unsigned NOT NULL,
 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
) ;

CREATE TABLE order_product (  
id int unsigned NOT NULL AUTO_INCREMENT primary key ,
quantity int unsigned NOT NULL ,
order_id int unsigned NOT NULL,
product_id int unsigned NOT NULL,
 FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE,
 FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE CASCADE

) ;

CREATE TABLE products (
product_id int unsigned NOT NULL AUTO_INCREMENT primary key,
product_name varchar(45) NOT NULL,
product_price double  
) ;
