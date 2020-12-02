CREATE TABLE operations (
    id SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    description VARCHAR  NOT NULL,
    amount REAL NOT NULL,
    type VARCHAR NOT NULL,
    dated VARCHAR NOT NULL,
    created_at TIMESTAMP DEFAULT current_timestamp,
    updated_at TIMESTAMP DEFAULT current_timestamp
);