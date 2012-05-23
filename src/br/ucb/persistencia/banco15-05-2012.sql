
CREATE DATABASE IF NOT EXISTS supermercadoBD;

USE supermercadoBD;

CREATE  TABLE IF NOT EXISTS usuario (
  login VARCHAR(15) NOT NULL ,
  senha VARCHAR(15),
  PRIMARY KEY (login) 
);

CREATE  TABLE IF NOT EXISTS cliente (
  id_cliente INT(11) NOT NULL AUTO_INCREMENT ,
  nome VARCHAR(100),
  cpf VARCHAR(11),
  email VARCHAR(45),
  logradouro VARCHAR(100),
  bairro VARCHAR(50),
  cidade VARCHAR(50),
  cep VARCHAR(8),
  uf VARCHAR(2),
  dataNasc DATE,
  login VARCHAR(15) NOT NULL ,
  telefone VARCHAR(10),
  PRIMARY KEY (id_cliente) ,
  INDEX fk_cliente_usuario (login) ,
  CONSTRAINT fk_cliente_usuario FOREIGN KEY (login) REFERENCES usuario (login)
);


CREATE  TABLE IF NOT EXISTS produto (
  id_produto INT(11) NOT NULL AUTO_INCREMENT ,
  nome VARCHAR(100),
  marca VARCHAR(50),
  preco DOUBLE,
  tipo VARCHAR(50),
  url VARCHAR(100),
  PRIMARY KEY (id_produto) 
);

CREATE  TABLE IF NOT EXISTS autorizacao (
  papel VARCHAR(15),
  login VARCHAR(15),
  PRIMARY KEY (papel, login),
  INDEX fk_autorizacao_usuario (login) ,
  CONSTRAINT fk_autorizacao_usuario FOREIGN KEY (login ) REFERENCES usuario (login)
);

CREATE  TABLE IF NOT EXISTS venda (
  id_venda INT(11) NOT NULL AUTO_INCREMENT ,
  dataVenda DATE ,
  id_cliente INT(11) NOT NULL ,
  PRIMARY KEY (id_venda,id_cliente) ,
  INDEX fk_venda_cliente1 (id_cliente) ,
  CONSTRAINT fk_venda_cliente1 FOREIGN KEY (id_cliente ) REFERENCES cliente (id_cliente)
);

CREATE  TABLE IF NOT EXISTS venda_produto(
  id_venda INT(11)NOT NULL,
  id_produto INT(11) NOT NULL ,
  quantidade INT(11),
  preco DOUBLE,
  PRIMARY KEY (id_venda, id_produto) ,
  INDEX fk_venda_has_produto_produto1 (id_produto) ,
  CONSTRAINT fk_venda_has_produto_venda1 FOREIGN KEY (id_venda)REFERENCES venda (id_venda),
  CONSTRAINT fk_venda_has_produto_produto1 FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);