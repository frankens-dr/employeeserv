CREATE schema test;

CREATE TABLE `test`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `test`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NOT NULL,
  `line1` VARCHAR(150) NOT NULL,
  `line2` VARCHAR(150) NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `zip_code` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`id`));
