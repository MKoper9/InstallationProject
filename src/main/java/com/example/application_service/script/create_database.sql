-- create database
create database calculator_service_db
    character set utf8 collate utf8_polish_ci;

set @@global.time_zone = '+2:00';

-- create new user
-- create, drop, alter, insert, update, select, delete
create user 'calculator_user'@'localhost' identified by 'Qwerty123';
grant
    create, drop, alter, insert, update, select, delete, references
    on
    calculator_service_db.*
    to
    'calculator_user'@'localhost';
