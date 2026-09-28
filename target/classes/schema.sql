CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(100)
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(64) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    role VARCHAR(10) NOT NULL
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stockQuantity INT,
    category_id INT NOT NULL,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    orderDate TIMESTAMP NOT NULL,
    total_amount DECIMAL(12, 2) NOT NULL,
    users_id INT NOT NULL,
    CONSTRAINT fk_orders_user FOREIGN KEY (users_id) REFERENCES users(id)
);

CREATE TABLE order_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    orders_id INT NOT NULL,
    product_id INT NOT NULL,
    CONSTRAINT fk_details_order FOREIGN KEY (orders_id) REFERENCES orders(id),
    CONSTRAINT fk_details_product FOREIGN KEY (product_id) REFERENCES product(id)
);