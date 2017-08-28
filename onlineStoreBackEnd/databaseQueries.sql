CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(20),
	is_active BOOLEAN,
	
	CONSTRAINT pk_catergory_id PRIMARY KEY(id)
);

INSERT INTO category (name, description, image_url, is_active) values ('Laptop', 'This is some description for laptop', 'laptop1.png', true);
INSERT INTO category (name, description, image_url, is_active) values ('Mobile', 'This is some description for Mobile', 'Mobile1.png', true);
INSERT INTO category (name, description, image_url, is_active) values ('Television', 'This is some description for television', 'television1.png', true);

CREATE TABLE user_detail(
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(50),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_catergory_id PRIMARY KEY(id)
);

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
values ('John', 'Wu', 'ADMIN', true, 'admin', 'abc@hotmail.com', '123-890-456');

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
values ('Annie', 'Wong', 'SUPPLIER', true, 'supplier1', 'dec@hotmail.com', '345-678-234');

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
values ('Michael', 'Smith', 'SUPPLIER', true, 'supplier2', '345abc@hotmail.com', '345-345-567');

CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10, 2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY(category_id) REFERENCES category(id),
	CONSTRAINT fk_supplier_id FOREIGN KEY(supplier_id) REFERENCES user_detail(id)	
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'iphone 6', 'Apple', '90% new iphone 6', 700, 2, true, 2, 2);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDAS456GHJD', 'iphone 7', 'Apple', 'Open Box', 780, 1, true, 2, 2);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPLM567ERTG', 'LG 60 inches TV', 'LG', 'Open Box', 900, 1, true, 3, 3);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC543UYIO', 'Samsung S8', 'Samsung', 'Open Box', 700, 1, true, 2, 2);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC890YTGH', 'Macbook Pro', 'Apple', 'Brand New', 1200, 2, true, 1, 3);
