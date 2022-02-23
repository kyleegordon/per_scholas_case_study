CREATE SCHEMA `casestudy` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `casestudy`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(12) NOT NULL,
  `website` VARCHAR(100) NOT NULL,
  `number_employees` INT NOT NULL,
  `industry` VARCHAR(100) NOT NULL,
  `security_professionals` BIT NULL,
  `personal_data` BIT NULL,
  `healthcare_data` BIT NULL,
  `credit_data` BIT NULL,
  `other_data` BIT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `casestudy`.`users`
ADD COLUMN `password` VARCHAR(100) NOT NULL AFTER `email`,
ADD COLUMN `confirm_password` VARCHAR(100) NOT NULL AFTER `password`;

CREATE TABLE `casestudy`.`user_roles` (
  `user_roles_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `user_role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_roles_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `casestudy`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `casestudy`.`results` (
  `survey_id` INT NOT NULL,
  `question_id` INT NOT NULL,
  `answer` INT NOT NULL,
  INDEX `survey_id_idx` (`survey_id` ASC) VISIBLE,
  CONSTRAINT `survey_id`
    FOREIGN KEY (`survey_id`)
    REFERENCES `casestudy`.`survey` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `casestudy`.`results`
ADD COLUMN `result_id` INT NOT NULL AFTER `answer`,
ADD PRIMARY KEY (`result_id`);
;

ALTER TABLE `casestudy`.`results`
CHANGE COLUMN `result_id` `result_id` INT(11) NOT NULL AUTO_INCREMENT ;

CREATE TABLE `casestudy`.`questions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `casestudy`.`results`
ADD INDEX `question_id_idx` (`question_id` ASC) VISIBLE;
;
ALTER TABLE `casestudy`.`results`
ADD CONSTRAINT `question_id`
  FOREIGN KEY (`question_id`)
  REFERENCES `casestudy`.`questions` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
;


ALTER TABLE `casestudy`.`recommend_services`
DROP COLUMN `id`,
DROP PRIMARY KEY;
, RENAME TO  `casestudy`.`results_services` ;

ALTER TABLE `casestudy`.`questions`
ADD COLUMN `service_description` VARCHAR(1000) NOT NULL AFTER `question`;

ALTER TABLE `casestudy`.`results`

DROP COLUMN `result_id`,
ADD COLUMN `date` DATETIME NULL DEFAULT current_timestamp AFTER `answer`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`survey_id`);
;

ALTER TABLE `casestudy`.`results`
ADD COLUMN `result_id` VARCHAR(45) NOT NULL AFTER `date`,
DROP PRIMARY KEY;
;

ALTER TABLE `casestudy`.`user_roles`
CHANGE COLUMN `user_roles_id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `casestudy`.`results`
CHANGE COLUMN `result_id` `id` INT NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY (`id`);
;

ALTER TABLE `casestudy`.`questions`
RENAME TO  `casestudy`.`survey` ;

ALTER TABLE `casestudy`.`results`
DROP COLUMN `survey_id`,
DROP INDEX `survey_id_idx` ;
;

ALTER TABLE `casestudy`.`survey`
ADD COLUMN `service_id` INT NOT NULL AFTER `service_description`;

ALTER TABLE `casestudy`.`survey`
DROP COLUMN `service_description`;

CREATE TABLE `casestudy`.`services` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `service_description` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `casestudy`.`survey`
ADD INDEX `survey_service_fk_idx` (`service_id` ASC) VISIBLE;
;
ALTER TABLE `casestudy`.`survey`
ADD CONSTRAINT `survey_service_fk`
  FOREIGN KEY (`service_id`)
  REFERENCES `casestudy`.`services` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `casestudy`.`results`
ADD COLUMN `user_id` INT NOT NULL AFTER `date`,
ADD INDEX `user_results_fk_idx` (`user_id` ASC) VISIBLE;
;
ALTER TABLE `casestudy`.`results`
ADD CONSTRAINT `user_results_fk`
  FOREIGN KEY (`user_id`)
  REFERENCES `casestudy`.`users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `casestudy`.`services`
ADD COLUMN `service_name` VARCHAR(100) NOT NULL AFTER `id`;

ALTER TABLE `casestudy`.`users`
DROP COLUMN `other_data`;

ALTER TABLE `casestudy`.`users`
DROP COLUMN `security_professionals`;

ALTER TABLE `casestudy`.`services`
ADD COLUMN `variable` VARCHAR(45) NOT NULL AFTER `service_description`;
