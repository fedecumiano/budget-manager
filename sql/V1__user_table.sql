CREATE TABLE users (
    username VARCHAR PRIMARY KEY,
    password VARCHAR  NOT NULL,
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);