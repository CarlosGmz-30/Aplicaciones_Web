create database employees;

use employees;

create table employee(
	id int primary key auto_increment not null,
    empName varchar(45) not null,
    ap1 varchar(45) not null,
    ap2 varchar(45) not null,
    salary decimal not null,
    posType varchar(50) not null
);

create table usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    pass VARCHAR(256),
    rol VARCHAR(50)
);


insert into employee(empName, ap1, ap2, salary, posType)
values ("Carlos", "Martinez", "Gomez", 20000, "Asignatura");

insert into employee(empName, ap1, ap2, salary, posType)
values ("Leonardo Daniel", "Dorantes", "Castanieda", 20000, "Asignatura");

insert into employee(empName, ap1, ap2, salary, posType)
values ("Diego Jesus", "Hernandez", "Palma", 20000, "Asignatura");

insert into employee(empName, ap1, ap2, salary, posType)
values ("Jayr Gil", "Galicia", "Jimenez", 20000, "Asignatura");

insert into employee(empName, ap1, ap2, salary, posType)
values ("Alexis Leonardo", "Noriega", "Rangel", 20000, "Asignatura");

insert into employee(empName, ap1, ap2, salary, posType)
values ("Jaqueline Nieobe", "Hernandez", "Bernal", 20000, "Asignatura");