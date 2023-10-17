CREATE DATABASE Traveland;
Use Traveland;

CREATE TABLE Usuarios (
ID_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR (64),
cpf VARCHAR (11) UNIQUE,
email VARCHAR (128) UNIQUE,
senha VARCHAR (255),
createAT DATETIME DEFAULT CURRENT_TIMESTAMP,
updateAT DATETIME
);

CREATE TABLE Destinos (
ID_destino INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR (64),
pais VARCHAR (64),
estado VARCHAR (64),
cidade VARCHAR (64),
preco DECIMAL ,
createAT DATETIME DEFAULT CURRENT_TIMESTAMP,
updateAT DATETIME
);


CREATE TABLE Compras (
ID_compra INT PRIMARY KEY AUTO_INCREMENT,
ID_destino INT,
ID_usuario INT,
data_ida DATE,
data_volta DATE,
data_compra DATE,
desconto DECIMAL (10,2),
total DECIMAL (10,2),
createAT DATETIME DEFAULT CURRENT_TIMESTAMP,
updateAT DATETIME
);

select * from Usuarios;
select * from Destinos;
select * from Compras;


insert into Usuarios ( nome, cpf, email, senha)
values ('Jennifer', '12345678921', 'jenni@gmail.com', 'jenni857'),
('Lucas', '98765432100', 'lucas@gmail', 'lucas958');

insert into Destinos ( nome, pais, estado, cidade, preco) values
('Disney Paris, França', 'França', '', 'Paris', '500.00'),
('Disney Orlando, EUA', 'EUA', 'Flórida', 'Orlando', '500.00');


insert into Compras (ID_destino, ID_usuario, data_compra, data_ida, data_volta, desconto, total) values
( 1, 2, '2023-10-12', '2023-10-17', '2023-10-26', '0.00', '500.00'),
( 1, 1, '2023-10-12', '2023-10-17', '2023-10-26', '0.00', '500.00');

select * from Compras, Destinos, Usuarios where Compras.ID_destino = Destinos.ID_destino and Compras.ID_usuario = Usuarios.ID_usuario;

UPDATE Usuarios SET nome = 'Jennifer Ribeiro', cpf = '12345678921', email = 'jenni@gmail.com', senha = 'jenni857' WHERE ID_usuario = 1;
UPDATE Destinos SET nome ='Disney Paris, França', pais = 'França', estado = '', cidade = 'Paris', data_ida = '2023-10-11', data_volta = '2023-10-21', preco = '500.00' WHERE ID_destino = 1;


DELETE FROM Usuarios WHERE ID_usuario = 4;
DELETE FROM Destinos WHERE ID_destino = 3;
DELETE FROM Compras WHERE ID_compras = 2;