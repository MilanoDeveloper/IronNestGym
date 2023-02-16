SELECT * FROM t_persons;

ALTER TABLE t_persons
ADD person_email VARCHAR(50) NOT NULL, 
ADD person_password VARCHAR(20) NOT NULL ;

CREATE TABLE `gym`.`t_users_login` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
ALTER TABLE t_users_login
DROP COLUMN user_name;

SELECT * FROM t_users_login
