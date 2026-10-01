CREATE TABLE users (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(255) NOT NULL UNIQUE,
    password_hash   VARCHAR(255) NOT NULL,
    full_name       VARCHAR(150) NOT NULL,
    phone           VARCHAR(20),
    role            VARCHAR(20)  NOT NULL DEFAULT 'USER',
    is_active       BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at      DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    updated_at      DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);
CREATE TABLE categories (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(100) NOT NULL UNIQUE,
    slug            VARCHAR(120) NOT NULL UNIQUE,
    description     VARCHAR(500),
    created_at      DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3)
);
CREATE TABLE foods (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    sku             VARCHAR(50)  NOT NULL UNIQUE,
    category_id     BIGINT       NULL,
    name            VARCHAR(200) NOT NULL,
    slug            VARCHAR(220) NOT NULL UNIQUE,
    description     TEXT,
    price           DECIMAL(14, 2) NOT NULL,
    stock_quantity  INT          NOT NULL DEFAULT 0,   -- Số lượng tồn kho
    is_published    BOOLEAN      NOT NULL DEFAULT TRUE, -- đã xuất
    is_deleted      BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at      DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    updated_at      DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    CONSTRAINT fk_food_category FOREIGN KEY (category_id) REFERENCES categories(id)
);
CREATE TABLE food_images (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    foods_id      BIGINT       NOT NULL,
    url             VARCHAR(500) NOT NULL,
    is_cover        BOOLEAN      NOT NULL DEFAULT FALSE,
    sort_order      INT          NOT NULL DEFAULT 0,
    created_at      DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    CONSTRAINT fk_foods_images_foods FOREIGN KEY (foods_id) REFERENCES foods(id) ON DELETE CASCADE
);
CREATE TABLE cart_items (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id         BIGINT       NOT NULL,
    foods_id      BIGINT       NOT NULL,
    quantity        INT          NOT NULL DEFAULT 1,
    created_at      DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    updated_at      DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    CONSTRAINT fk_cart_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_cart_foods FOREIGN KEY (foods_id) REFERENCES foods(id),
    CONSTRAINT uq_cart_user_foods UNIQUE (user_id, foods_id)
);

CREATE TABLE restaurant_tables (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    table_name   VARCHAR(200) NOT NULL,
    capacity     INT          NOT NULL,
    status       BOOLEAN      NOT NULL DEFAULT TRUE
); 

CREATE TABLE orders (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_code       VARCHAR(30)  NOT NULL UNIQUE,
    user_id          BIGINT       NOT NULL,  -- Người tạo đơn (có thể là khách tự đặt hoặc thu ngân)
    table_id         BIGINT       NULL,      -- Bàn số mấy (Sẽ NULL nếu là đơn giao hàng)
    order_type       VARCHAR(20)  NOT NULL DEFAULT 'DINE_IN', -- DINE_IN hoặc DELIVERY
    status           VARCHAR(30)  NOT NULL DEFAULT 'PENDING',
    subtotal         DECIMAL(14, 2) NOT NULL,
    shipping_fee     DECIMAL(14, 2) NOT NULL DEFAULT 0,
    total_amount     DECIMAL(14, 2) NOT NULL,
    receiver_name    VARCHAR(150) NULL,      -- Cho phép NULL nếu ăn tại bàn
    receiver_phone   VARCHAR(20)  NULL,      -- Cho phép NULL nếu ăn tại bàn
    shipping_address VARCHAR(500) NULL,      -- Cho phép NULL nếu ăn tại bàn
    note             VARCHAR(500),
    cancelled_at     DATETIME(3)  NULL,
    confirmed_by     BIGINT       NULL,      -- Nhân viên nào xác nhận đơn
    created_at       DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    updated_at       DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_orders_admin FOREIGN KEY (confirmed_by) REFERENCES users(id),
    CONSTRAINT fk_orders_table FOREIGN KEY (table_id) REFERENCES restaurant_tables(id)
);

CREATE TABLE order_items (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id      BIGINT       NOT NULL,
    foods_id    BIGINT       NOT NULL,
    foods_name  VARCHAR(200) NOT NULL,
    unit_price    DECIMAL(14, 2) NOT NULL,
    quantity      INT          NOT NULL,
    line_total    DECIMAL(14, 2) NOT NULL,
    CONSTRAINT fk_oi_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    CONSTRAINT fk_oi_foods FOREIGN KEY (foods_id) REFERENCES foods(id)
);


CREATE TABLE bill (
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id       BIGINT NOT NULL UNIQUE,
    total_amount   DECIMAL(14, 2) NOT NULL,
    discount       DECIMAL(14, 2) NOT NULL DEFAULT 0,
    tax            DECIMAL(14, 2) NOT NULL DEFAULT 0,
    payment_method VARCHAR(50)    NOT NULL,
    paid_at        DATETIME(3)    NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    CONSTRAINT fk_bill_order FOREIGN KEY (order_id) REFERENCES orders(id)
);


CREATE INDEX idx_foods_category ON foods(category_id);
CREATE INDEX idx_foods_price ON foods(price);
CREATE INDEX idx_foods_published ON foods(is_published, is_deleted);
CREATE INDEX idx_cart_user ON cart_items(user_id);
CREATE INDEX idx_orders_user ON orders(user_id);
CREATE INDEX idx_orders_status ON orders(status);
