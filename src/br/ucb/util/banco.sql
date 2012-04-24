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
  `endereco_cliente` VARCHAR(100) NULL DEFAULT NULL ,
  `cpf_cliente` CHAR(11) NULL DEFAULT NULL ,
  `cidade_cliente` VARCHAR(50) NULL DEFAULT NULL ,
  `estado_cliente` CHAR(2) NULL DEFAULT NULL ,
  `email_cliente` VARCHAR(45) NULL DEFAULT NULL ,
  `cep_cliente` CHAR(8) NULL DEFAULT NULL ,
  `usuario_id_usuario` INT(11) NOT NULL ,
  PRIMARY KEY (`id_cliente`, `usuario_id_usuario`) ,
  INDEX `fk_Clientes_Usuarios1` (`usuario_id_usuario` ASC) ,
  CONSTRAINT `fk_Clientes_Usuarios1`
    FOREIGN KEY (`usuario_id_usuario` )
    REFERENCES `supermercado`.`usuario` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `supermercado`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome_usuario` VARCHAR(45) NULL DEFAULT NULL ,
  `senha_usuario` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_usuario`) )
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

CREATE  TABLE IF NOT EXISTS `supermercado`.`vendas_has_produtos` (
  `produto_id_produto` INT(11) NOT NULL ,
  `venda_id_venda` INT(11) NOT NULL ,
  `quantidade` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`produto_id_produto`, `venda_id_venda`) ,
  INDEX `fk_Produtos_has_Vendas_Vendas1` (`venda_id_venda` ASC) ,
  INDEX `fk_Produtos_has_Vendas_Produtos1` (`produto_id_produto` ASC) ,
  CONSTRAINT `fk_Produtos_has_Vendas_Produtos1`
    FOREIGN KEY (`produto_id_produto` )
    REFERENCES `supermercado`.`produto` (`id_produto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_has_Vendas_Vendas1`
    FOREIGN KEY (`venda_id_venda` )
    REFERENCES `supermercado`.`venda` (`id_venda` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
