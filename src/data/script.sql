CREATE DATABASE bdConsultaMedica;

use bdConsultaMedica;

CREATE TABLE usuario (
    id int not null auto_increment primary key,
    nome varchar(50) not null,
    usuario varchar(20) not null,
    senha varchar(20) not null,
    tipo int not null
);

CREATE TABLE medico (
    codMedico int not null auto_increment primary key,
    nomeMedico varchar(50) not null,
    crm varchar(10) not null,
    email varchar(50) not null
);

CREATE TABLE especialidade (
    id int not null auto_increment primary key,
    descricao varchar(50) not null,
    codMedico int not null,
    Constraint fk_especialidade_medico foreign key(codMedico) references medico(codMedico)
);

CREATE TABLE paciente (
    codPaciente int not null auto_increment primary key,
    cpf varchar(14) not null,
    nomePaciente varchar(50) not null,
    telefone varchar(13) not null
);

CREATE TABLE endereco (
    id int not null auto_increment primary key,
    rua varchar(50) not null,
    bairro varchar(50) not null,
    numero int not null,
    cidade varchar(50) not null,
    estado varchar(50) not null,
    codPaciente int not null,
    Constraint fk_endereco_paciente foreign key(codPaciente) references paciente(codPaciente)
);

CREATE TABLE consulta (
    idConsulta int auto_increment not null,
    codPaciente int not null,
    codMedico int not null,
    dataConsulta varchar(10) not null,
    horaConsulta varchar(8) not null,
    Constraint pk_consulta primary key(idConsulta),
    Constraint fk_consulta_paciente foreign key(codPaciente) references paciente(codPaciente),
    Constraint fk_consulta_medico foreign key(codMedico) references medico(codMedico),
    UNIQUE `consulta` (`dataConsulta`, `horaConsulta`, `codPaciente`, `codMedico`)
);