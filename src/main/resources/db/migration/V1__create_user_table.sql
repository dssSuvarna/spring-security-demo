CREATE SCHEMA IF NOT EXISTS core;

CREATE TABLE IF NOT EXISTS core."users" (
    id BIGSERIAL PRIMARY KEY,   -- Auto-incrementing primary key
    username VARCHAR(255) UNIQUE NOT NULL, -- Ensuring username is unique and not null
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);