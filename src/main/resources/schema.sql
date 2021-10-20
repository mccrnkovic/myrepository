-- MySQL Script generated by MySQL Workbench
-- Wed Oct 20 16:02:51 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`BankAccount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BankAccount` ;

CREATE TABLE IF NOT EXISTS `mydb`.`BankAccount` (
  `idBankAccount` CHAR(21) NOT NULL,
  `balance` DECIMAL NOT NULL,
  PRIMARY KEY (`idBankAccount`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Bill` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Bill` (
  `idBill` VARCHAR(8) NOT NULL,
  `buyer` INT NOT NULL,
  `seller` INT NOT NULL,
  `price` DECIMAL NOT NULL,
  `paid` TINYINT NOT NULL,
  `whenPaid` DATE NULL,
  `issued` DATE NOT NULL,
  PRIMARY KEY (`idBill`),
  INDEX `fk_Bill_User_idx` (`buyer` ASC) VISIBLE,
  INDEX `fk_Bill_User1_idx` (`seller` ASC) VISIBLE,
  CONSTRAINT `fk_Bill_User`
    FOREIGN KEY (`buyer`)
    REFERENCES `mydb`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bill_User1`
    FOREIGN KEY (`seller`)
    REFERENCES `mydb`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Transaction` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Transaction` (
  `idTransaction` INT NOT NULL AUTO_INCREMENT,
  `payee` CHAR(21) NULL,
  `payer` CHAR(21) NULL,
  `amount` DECIMAL NULL,
  `date` DATE NULL,
  PRIMARY KEY (`idTransaction`),
  INDEX `fk_Transaction_BankAccount1_idx` (`payee` ASC) VISIBLE,
  INDEX `fk_Transaction_BankAccount2_idx` (`payer` ASC) VISIBLE,
  CONSTRAINT `fk_Transaction_BankAccount1`
    FOREIGN KEY (`payee`)
    REFERENCES `mydb`.`BankAccount` (`idBankAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_BankAccount2`
    FOREIGN KEY (`payer`)
    REFERENCES `mydb`.`BankAccount` (`idBankAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`User` ;

CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `hq` VARCHAR(64) NOT NULL,
  `founded` DATE NOT NULL,
  `bankAccount` CHAR(21) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `bankAccount_UNIQUE` (`bankAccount` ASC) VISIBLE,
  CONSTRAINT `fk_User_BankAccount1`
    FOREIGN KEY (`bankAccount`)
    REFERENCES `mydb`.`BankAccount` (`idBankAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
