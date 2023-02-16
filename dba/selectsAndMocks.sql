INSERT INTO t_persons VALUES ('4', 'Georgia', '42', 'St Frozen Throne', 'W', 'geogina76@gmail.com', 'Pass123');

DELETE FROM t_persons WHERE id_persons = 1;
SELECT * FROM t_persons;


INSERT INTO department (department_id, department_address, department_code, department_name)
VALUES (2, '123 Main St', 'DPT-001', 'Accounting');

INSERT INTO department (department_id, department_address, department_code, department_name)
VALUES (3, '456 Park Ave', 'DPT-002', 'IT');

INSERT INTO department (department_id, department_address, department_code, department_name)
VALUES (4, '789 Elm St', 'DPT-003', 'Marketing');


INSERT INTO t_users_login (id,login, password)
VALUES ('1','Jhon Wick', 'aabbcc112233');
SELECT * FROM t_users_login;
SELECT * FROM department;