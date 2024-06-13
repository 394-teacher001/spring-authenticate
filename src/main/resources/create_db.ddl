\c postgres
DROP DATABASE IF EXISTS auth_db;
DROP ROLE IF EXISTS auth_user;
CREATE ROLE auth_user WITH PASSWORD 'himitu' LOGIN;
CREATE DATABASE auth_db OWNER auth_user ENCODING 'utf8';
