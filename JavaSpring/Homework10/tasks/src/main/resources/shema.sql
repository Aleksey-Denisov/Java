CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    short_description VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(15) NOT NULL,
    creation_date TIMESTAMP NOT NULL
);