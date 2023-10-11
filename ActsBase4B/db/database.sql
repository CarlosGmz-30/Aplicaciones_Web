create database employees;

use employees;

create table employees(
    id int not null auto_increment primary key not null,
    empName varchar(45) not null,
    ap1 varchar(45) not null,
    ap2 varchar(45) not null,
    salary decimal not null,
    postType varchar(50) not null,
);

INSERT INTO
    employee (empName, ap1, ap2, salary, postType)
VALUES
    ("Carlos", "Martinez", "Gómez", 60000, "Director");