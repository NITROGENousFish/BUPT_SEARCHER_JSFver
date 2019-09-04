-- MySQL Script generated by MySQL Workbench
-- Wed Sep  4 10:49:27 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema program
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema program
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `program` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `program` ;

-- -----------------------------------------------------
-- Table `program`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `program`.`User` (
  `user_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `passwd` VARCHAR(45) NOT NULL,
  `sex` INT NOT NULL,
  `user_post_date` DATETIME NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `program`.`searchlog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `program`.`searchlog` (
  `log_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `searchword` VARCHAR(45) NOT NULL,
  `time` DATETIME NOT NULL,
  `ip` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`log_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `searchlog_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `program`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `program`.`currentsearch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `program`.`currentsearch` (
  `log_id` INT NOT NULL,
  `order_search` INT NOT NULL,
  `description` LONGTEXT NOT NULL,
  PRIMARY KEY (`log_id`, `order_search`),
  CONSTRAINT `log_id`
    FOREIGN KEY (`log_id`)
    REFERENCES `program`.`searchlog` (`log_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `program`.`prefersettings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `program`.`prefersettings` (
  `user_id` INT NOT NULL,
  `background_id` INT NOT NULL,
  `is_use_js` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `prefersettings_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `program`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;