
CREATE DATABASE IF NOT EXISTS hopefind;
USE hopefind;


CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS complaints (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    category VARCHAR(100),
    description TEXT,
    location VARCHAR(255),
    report_date DATETIME,
    status VARCHAR(50) DEFAULT 'Pending',
    photo_path VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

alter table complaints add column title varchar(255);

