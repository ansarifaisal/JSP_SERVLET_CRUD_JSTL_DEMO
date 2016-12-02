CREATE TABLE student(
id IDENTITY,
roll_no int(5),
year int(4),
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
address varchar(50) NOT NULL
);

INSERT INTO student (roll_no, year, first_name, last_name, address) values
(101,2016,'Ansari','Faisal','Chembur');

INSERT INTO student (roll_no, year, first_name, last_name, address) values
(102,2016,'Khozema','Nullwala','Mumbra');
