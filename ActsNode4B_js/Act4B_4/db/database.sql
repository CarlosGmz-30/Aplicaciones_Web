create database university;
use university;

-- Creamos tabla de carreras
create table carreras (
	id_carrera varchar (20) not null primary key,
    carrera varchar (45) not null
);

-- Creamos tabla de cursos
create table cursos (
	codigo varchar (45) primary key not null,
    curso varchar (45) not null
);

-- Creamos tabla de alumnos
create table alumnos (
	matricula int primary key,
    nombre varchar (45) not null,
    direccion varchar (45) not null,
    telefono varchar (45) not null,
    id_carrera varchar(20) not null,
    foreign key (id_carrera) references carreras(id_carrera)
);

-- Creamos tabla de alumno_curso
create table alumno_curso (
	matricula int not null,
    codigo varchar (45) not null,
    foreign key (matricula) references alumnos (matricula),
    foreign key (codigo) references cursos (codigo)
);

-- Insertar datos en la tabla carreras
insert into carreras (id_carrera, carrera) values ('C2100','Ingeniería en desarrollo de software');
insert into carreras (id_carrera, carrera) values ('C2020','Ingeniería en sistemas computacionales');

-- Insertar datos en la tabla cursos
insert into cursos (codigo, curso) values ('BD1', 'Base de Datos');
insert into cursos (codigo, curso) values ('AW1', 'Aplicaciones Web');
insert into cursos (codigo, curso) values ('ED1', 'Estructura de Datos');
insert into cursos (codigo, curso) values ('EM1', 'Estándares y Métricas');
insert into cursos (codigo, curso) values ('DA1', 'Diseño de Apps');

-- Insertar datos en la tabla estudiante
insert into alumnos (matricula, nombre, direccion, telefono, id_carrera) values 
(100, 'Carlos', '20223tn066@utez.edu.mx', '7777894512', 'C2100');
insert into alumnos (matricula, nombre, direccion, telefono, id_carrera) values 
(200, 'Keyla', '20223tn099@utez.edu.mx', '7771234578', 'C2020');

-- Insertar datos en la tabla alumno_curso
INSERT INTO alumno_curso (matricula, codigo) VALUES (100, 'AW1');
INSERT INTO alumno_curso (matricula, codigo) VALUES (100, 'BD1');
INSERT INTO alumno_curso (matricula, codigo) VALUES (100, 'DA1');
INSERT INTO alumno_curso (matricula, codigo) VALUES (200, 'DA1');
INSERT INTO alumno_curso (matricula, codigo) VALUES (200, 'ED1');
INSERT INTO alumno_curso (matricula, codigo) VALUES (200, 'EM1');




