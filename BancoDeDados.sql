create database cadastro
go

use cadastro

create table funcionario(
	Codigo int primary key identity(1,1),
	Nome varchar(255) not null,
	Cpf varchar(255) not null,
	DataNascimento datetime not null,
	Genero varchar(255) not null,
	NomeMae varchar(255) not null,
	Efetivo BIT not null,
)