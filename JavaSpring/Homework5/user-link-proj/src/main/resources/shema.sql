CREATE TABLE IF NOT EXISTS Users (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    role VARCHAR(25) NOT NULL
);
CREATE TABLE IF NOT EXISTS Projects (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    created_date TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS User_projects (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    related_entity_id LONG NOT NULL,
    project_id LONG NOT NULL,
    user_id LONG NOT NULL
);