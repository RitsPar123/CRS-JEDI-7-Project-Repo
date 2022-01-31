-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CRSDatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CRSDatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CRSDatabase` DEFAULT CHARACTER SET utf8 ;
USE `CRSDatabase` ;

-- -----------------------------------------------------
-- Table `CRSDatabase`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CRSDatabase`.`User` (
  `Id` VARCHAR(45) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Role` INT NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CRSDatabase`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CRSDatabase`.`Student` (
  `SId` VARCHAR(45) NOT NULL,
  `Branch` VARCHAR(45) NULL,
  `IsApproved` TINYINT NOT NULL DEFAULT 0,
  `IsRegistered` TINYINT NOT NULL DEFAULT 0,
  `IsReportApproved` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`SId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CRSDatabase`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CRSDatabase`.`Professor` (
  `PId` VARCHAR(45) NOT NULL,
  `Department` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CRSDatabase`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CRSDatabase`.`Course` (
  `CourseId` VARCHAR(45) NOT NULL,
  `PId` VARCHAR(45) NOT NULL,
  `CourseName` VARCHAR(45) NOT NULL,
  `SeatCount` INT NOT NULL DEFAULT 10,
  PRIMARY KEY (`CourseId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CRSDatabase`.`Notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CRSDatabase`.`Notification` (
  `NotificationId` VARCHAR(45) NULL,
  `SId` VARCHAR(45) NOT NULL,
  `Message` VARCHAR(45) NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CRSDatabase`.`Payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CRSDatabase`.`Payment` (
  `SId` VARCHAR(45) NOT NULL,
  `PaymentId` VARCHAR(45) NOT NULL,
  `PaymentMethod` VARCHAR(45) NULL,
  `Amount` DOUBLE NULL,
  `TransactionDate` DATE NULL,
  `FeeStatus` TINYINT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CRSDatabase`.`RegisteredCourse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CRSDatabase`.`RegisteredCourse` (
  `CourseId` VARCHAR(45) NOT NULL,
  `SId` VARCHAR(45) NOT NULL,
  `IsRegistered` INT NOT NULL DEFAULT 0,
  `Grade` INT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CRSDatabase`.`Grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CRSDatabase`.`Grade` (
  `SId` VARCHAR(45) NOT NULL,
  `CourseId` VARCHAR(45) NOT NULL,
  `Marks` INT NOT NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
