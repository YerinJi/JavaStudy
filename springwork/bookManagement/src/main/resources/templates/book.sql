CREATE TABLE book (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(200) NOT NULL,
                      author VARCHAR(100) NOT NULL,
                      publisher VARCHAR(100),
                      price INT,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);