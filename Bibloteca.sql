--Creo la base de datos
create database Biblioteca
go

--Uso la base de datos
use Biblioteca
go

--Creo las tablas
Create table Categoria(
Codigo int primary key,
Nombre varchar(30))
go

Create table Libro(
Codigo varchar(30) primary key,
Titulo varchar(30),
Autor varchar(30),
Fecha_Ingreso date,
Numero_Ejemplares int,
Codigo_Categoria int,
Estado varchar(10)
)
go

Create table Usuario(
Carnet bigint primary key,
Nombre varchar(30),
Apellido varchar(30),
Correo_Electronico varchar(30),
Direccion varchar(30),
Telefono bigint,
Estado varchar(10)
)
go

Create table Prestamo(
Codigo_Libro varchar(30),
Carnet_Usuario bigint ,
Fecha_Prestamo date,
Fecha_Devolucion_Estandar date,
Fecha_Devolucion_Usuario date,
Estado varchar(10),
Dinero money
primary key(Codigo_Libro, Carnet_Usuario)
)
go

--Relacion
alter table Libro add foreign key (Codigo_Categoria) references Categoria(Codigo)
go

Alter table Prestamo add foreign key(Codigo_Libro) references Libro(Codigo)
go

Alter table Prestamo add foreign key(Carnet_Usuario) references Usuario(Carnet)
go

--Inserto datos
insert into Categoria values (1,'Terror')
Insert into Categoria values (2, 'Suspenso')
Insert into Categoria values (3, 'Fantasia')
go

insert into Libro values ('1A','Narnia','No idea','2000/08/24',3,3,'Libre')
insert into Libro values ('1A-2','Narnia','No idea','2000/08/24',3,3,'Libre')
insert into Libro values ('1A-3','Narnia','No idea','2000/08/24',3,3,'Libre')
Insert into Libro values ('2A','It','Stephen King','2000/03/20',2,3,'Libre')
Insert into Libro values ('2A-2','It','Stephen King','2000/03/20',2,3,'Libre')
Insert into Libro values ('3A','Psicoanalista','No se','2010/04/24',1,3,'Libre')
go

insert into Usuario values (1234,'Daniel','Guzman','Dani.Guz@gmail.com','Cra 107 C 45 A 70 int 128',3152364458,'Moroso')
Insert into Usuario values (2555, 'David','Gomez','d.gomez@yahoo.com','Cra 100 C 40 A 80 int 138',3152364447,'Libre')
Insert into Usuario values (3666, 'Sebastian','Trujillo','Sebas.Truj@hotmail.com','Cra 102 C 35 A 60 int 8',3162364447,'Libre')
go

insert into Prestamo values ('1A',1234,'2019/06/01','2019/06/06','','Prestado',1000)
go

--Creo las vistas
CREATE VIEW Consulta_Libro AS SELECT * FROM Libro
go

CREATE VIEW Consulta_Usuario AS SELECT * FROM Usuario 
go

CREATE VIEW Consulta_Categoria AS SELECT * FROM Categoria
go

CREATE VIEW Consulta_Prestamo AS SELECT * FROM Prestamo
go

update Categoria set nombre='Fantasia' where Codigo=1

--drop database Biblioteca

--Select * From Usuario
--Select * From Prestamo
--Select * From Categoria
--Select * From Libro

--Select L.Codigo,L.Titulo,L.Autor,L.Fecha_Ingreso,L.Numero_Ejemplares,L.Estado,L.Estado,C.Nombre from Libro L inner join Categoria C on L.Codigo_Categoria=C.Codigo where L.Codigo='1A'