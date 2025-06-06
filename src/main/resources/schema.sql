CREATE TABLE IF NOT EXISTS users (
   id SERIAL PRIMARY KEY,
   email VARCHAR(255) NOT NULL UNIQUE,
   password VARCHAR(255) NOT NULL,
   name VARCHAR(100) NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS carts (
   id SERIAL PRIMARY KEY,
   user_id INT NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS cart_items (
    id SERIAL PRIMARY KEY,
    cart_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES carts(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    order_status VARCHAR(50) DEFAULT 'PENDING',
    total_price DECIMAL(10, 2) NOT NULL,
    ordered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS order_items (
     id SERIAL PRIMARY KEY,
     order_id INT NOT NULL,
     product_id INT NOT NULL,
     quantity INT NOT NULL,
     price DECIMAL(10, 2) NOT NULL,
     FOREIGN KEY (order_id) REFERENCES orders(id),
     FOREIGN KEY (product_id) REFERENCES products(id)
);
