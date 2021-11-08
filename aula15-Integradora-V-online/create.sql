DROP TABLE IF EXISTS endereco, paciente;
CREATE TABLE IF NOT EXISTS endereco (
    id int auto_increment primary key,
    rua varchar(64),
    numero varchar(8),
    bairro varchar(64),
    cidade varchar(64));

CREATE TABLE IF NOT EXISTS paciente (
    id int auto_increment primary key,
    nome varchar(64),
    sobrenome varchar(8),
    rg varchar(16),
    data_cadastro TIMESTAMP WITHOUT TIME ZONE,
    endereco_id int);
