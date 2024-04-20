#criar o database chamado exercicio
create database if not exists exercicio;

#entrar no database exercicio
use exercicio;

#remove a tabela para recriá-la
drop table if exists fornecedor;

#cria a tabela de fornecedor
CREATE TABLE fornecedor (
	fornecedorID    INTEGER NOT NULL AUTO_INCREMENT,    	 
	nomeFantasia    VARCHAR(50) NOT NULL,     
	razaoSocial     VARCHAR(50) NOT NULL,     
	CNPJ    	VARCHAR(20),	
	cidade       	VARCHAR(25),
	regiao       	VARCHAR(20),
	PRIMARY KEY(fornecedorID)    
);

#lista a tabela criada
show tables;
