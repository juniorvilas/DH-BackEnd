create table IF NOT EXISTS endereco(
id int auto_increment primary key,
rua varchar(255),
numero varchar (255),
cidade varchar (255),
estado varchar (255));

create table IF NOT EXISTS paciente(
id int auto_increment primary key,
nome varchar(255),
sobrenome varchar (255),
cpf varchar (255),
datacadastro TIMESTAMP WITHOUT TIME ZONE,
endereco_id int);

create table IF NOT EXISTS dentista(
id int auto_increment primary key,
nome varchar(255),
sobrenome varchar (255),
matricula int);

create table IF NOT EXISTS usuario(
id int auto_increment primary key,
nome varchar(255),
email varchar (255),
senha varchar (255),
acesso int);


