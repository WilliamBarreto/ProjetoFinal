SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `supermercado` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

USE `supermercado`;

CREATE  TABLE IF NOT EXISTS `supermercado`.`produto` (
  `id_produto` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome_produto` VARCHAR(100) NULL DEFAULT NULL ,
  `marca_produto` VARCHAR(50) NULL DEFAULT NULL ,
  `preco_produto` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`id_produto`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `supermercado`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome_cliente` VARCHAR(100) NULL DEFAULT NULL ,
  `cpf_cliente` VARCHAR(11) NULL DEFAULT NULL ,
  `email_cliente` VARCHAR(45) NULL DEFAULT NULL ,
  `logradouro_cliente` VARCHAR(100) NULL DEFAULT NULL ,
  `bairro_cliente` VARCHAR(50) NULL DEFAULT NULL ,
  `cidade_cliente` VARCHAR(50) NULL DEFAULT NULL ,
  `cep_cliente` VARCHAR(8) NULL DEFAULT NULL ,
  `uf_cliente` VARCHAR(2) NULL DEFAULT NULL ,
  `usuarioc_id_usuario_cliente` INT(11) NOT NULL ,
  PRIMARY KEY (`id_cliente`) ,
  INDEX `fk_cliente_usuarioc1` (`usuarioc_id_usuario_cliente` ASC) ,
  CONSTRAINT `fk_cliente_usuarioc1`
    FOREIGN KEY (`usuarioc_id_usuario_cliente` )
    REFERENCES `supermercado`.`usuarioc` (`id_usuario_cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `supermercado`.`usuarios` (
  `id_usuario_sistema` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome_usuario_sistema` VARCHAR(15) NULL DEFAULT NULL ,
  `senha_usuario_sistema` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_usuario_sistema`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `supermercado`.`venda` (
  `id_venda` INT(11) NOT NULL AUTO_INCREMENT ,
  `cliente_id_cliente` INT(11) NOT NULL ,
  `data_venda` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`id_venda`) ,
  INDEX `fk_Vendas_Clientes` (`cliente_id_cliente` ASC) ,
  CONSTRAINT `fk_Vendas_Clientes`
    FOREIGN KEY (`cliente_id_cliente` )
    REFERENCES `supermercado`.`cliente` (`id_cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `supermercado`.`usuarioc` (
  `id_usuario_cliente` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome_usuario_cliente` VARCHAR(45) NULL DEFAULT NULL ,
  `senha_usurio_cliente` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_usuario_cliente`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `supermercado`.`venda_has_produto` (
  `venda_id_venda` INT(11) NOT NULL ,
  `produto_id_produto` INT(11) NOT NULL ,
  `quantidade` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`venda_id_venda`, `produto_id_produto`) ,
  INDEX `fk_venda_has_produto_produto1` (`produto_id_produto` ASC) ,
  INDEX `fk_venda_has_produto_venda1` (`venda_id_venda` ASC) ,
  CONSTRAINT `fk_venda_has_produto_venda1`
    FOREIGN KEY (`venda_id_venda` )
    REFERENCES `supermercado`.`venda` (`id_venda` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_has_produto_produto1`
    FOREIGN KEY (`produto_id_produto` )
    REFERENCES `supermercado`.`produto` (`id_produto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE autorizacao (
  usuario int(11) NOT NULL,
  papel varchar(15) NOT NULL,
  PRIMARY KEY (usuario, papel),
  CONSTRAINT fk_autorizacao FOREIGN KEY (usuario) REFERENCES usuarios (id_usuario_sistema)
);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
