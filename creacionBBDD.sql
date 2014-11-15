SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `bancoAlcala` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `bancoAlcala` ;

-- -----------------------------------------------------
-- Table `bancoAlcala`.`cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bancoAlcala`.`cuenta` ;

CREATE  TABLE IF NOT EXISTS `bancoAlcala`.`cuenta` (
  `numero` INT(4) ZEROFILL NOT NULL AUTO_INCREMENT ,
  `pin` INT(4) ZEROFILL NOT NULL ,
  `saldo` DOUBLE NOT NULL ,
  PRIMARY KEY (`numero`) ,
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoAlcala`.`tipoMovimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bancoAlcala`.`tipoMovimiento` ;

CREATE  TABLE IF NOT EXISTS `bancoAlcala`.`tipoMovimiento` (
  `id` VARCHAR(2) NOT NULL ,
  `descripcion` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoAlcala`.`movimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bancoAlcala`.`movimiento` ;

CREATE  TABLE IF NOT EXISTS `bancoAlcala`.`movimiento` (
  `idMovimiento` INT NOT NULL AUTO_INCREMENT ,
  `numCuenta` INT(4) ZEROFILL NOT NULL ,
  `fecha` DATETIME NOT NULL ,
  `tipo` VARCHAR(2) NOT NULL ,
  `monto` DOUBLE NOT NULL ,
  `longitud` DOUBLE NOT NULL ,
  `latitud` DOUBLE NOT NULL ,
  PRIMARY KEY (`idMovimiento`),
  INDEX `FK_tipoMovimiento_idx` (`tipo` ASC) ,
  INDEX `FK_numCuenta_idx` (`numCuenta` ASC) ,
  CONSTRAINT `FK_tipoMovimiento`
   FOREIGN KEY (`tipo` )
    REFERENCES `bancoAlcala`.`tipoMovimiento` (`id` )
    ON DELETE NO ACTION
   ON UPDATE NO ACTION,
  CONSTRAINT `FK_numCuenta`
    FOREIGN KEY (`numCuenta` )
   REFERENCES `bancoAlcala`.`cuenta` (`numero` )
   ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bancoAlcala`.`cuenta`
-- -----------------------------------------------------
START TRANSACTION;
USE `bancoAlcala`;
INSERT INTO `bancoAlcala`.`cuenta` (`numero`, `pin`, `saldo`) VALUES (0000, 0000, 15000);

COMMIT;

-- -----------------------------------------------------
-- Data for table `bancoAlcala`.`tipoMovimiento`
-- -----------------------------------------------------
START TRANSACTION;
USE `bancoAlcala`;
INSERT INTO `bancoAlcala`.`tipoMovimiento` (`id`, `descripcion`) VALUES ('IE', 'Ingreso Efectivo');
INSERT INTO `bancoAlcala`.`tipoMovimiento` (`id`, `descripcion`) VALUES ('RE', 'Retirada Efectivo');
INSERT INTO `bancoAlcala`.`tipoMovimiento` (`id`, `descripcion`) VALUES ('TR', 'Transferencia');
INSERT INTO `bancoAlcala`.`tipoMovimiento` (`id`, `descripcion`) VALUES ('RT', 'Recarga Telefonica');

COMMIT;
