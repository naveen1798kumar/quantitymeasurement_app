DROP TABLE IF EXISTS quantity_measurements;

CREATE TABLE quantity_measurements (

       id BIGINT AUTO_INCREMENT PRIMARY KEY,

       first_value DOUBLE NOT NULL,

       first_unit VARCHAR(50) NOT NULL,

       first_measurement_type VARCHAR(30) NOT NULL,

       second_value DOUBLE,

       second_unit VARCHAR(50),

       second_measurement_type VARCHAR(30),

       operation VARCHAR(30) NOT NULL,

       result VARCHAR(100),

       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);