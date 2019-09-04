-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema buptsearcher
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `buptsearcher` ;

-- -----------------------------------------------------
-- Schema buptsearcher
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `buptsearcher` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `buptsearcher` ;

-- -----------------------------------------------------
-- Table `buptsearcher`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buptsearcher`.`user` ;

CREATE TABLE IF NOT EXISTS `buptsearcher`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `passwd` VARCHAR(45) NOT NULL,
  `sex` INT(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `user_post_date` DATETIME NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `buptsearcher`.`searchlog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buptsearcher`.`searchlog` ;

CREATE TABLE IF NOT EXISTS `buptsearcher`.`searchlog` (
  `log_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `searchword` VARCHAR(45) NOT NULL,
  `time` DATETIME NOT NULL,
  `ip` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`log_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `searchlog_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `buptsearcher`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `buptsearcher`.`currentsearch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buptsearcher`.`currentsearch` ;

CREATE TABLE IF NOT EXISTS `buptsearcher`.`currentsearch` (
  `page_id` INT(11) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `url` LONGTEXT NOT NULL,
  `content` LONGTEXT NOT NULL,
  PRIMARY KEY (`page_id`),
  CONSTRAINT `log_id`
    FOREIGN KEY (`page_id`)
    REFERENCES `buptsearcher`.`searchlog` (`log_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `buptsearcher`.`prefersettings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buptsearcher`.`prefersettings` ;

CREATE TABLE IF NOT EXISTS `buptsearcher`.`prefersettings` (
  `user_id` INT(11) NOT NULL,
  `background_id` INT(11) NOT NULL,
  `is_use_js` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `prefersettings_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `buptsearcher`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `buptsearcher`.`websites_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buptsearcher`.`websites_info` ;

CREATE TABLE IF NOT EXISTS `buptsearcher`.`websites_info` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NULL,
  `content` LONGTEXT NULL,
  `published_time` DATETIME NULL,
  `click_times` INT NULL,
  `crawled` TINYINT NULL DEFAULT 0,
  `being_crawled` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
