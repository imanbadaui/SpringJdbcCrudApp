create table Employee(
id varchar(255) not null,
fname varchar(255) not null,
lname varchar(255) not null,
age integer not null,
salary integer not null,
constraint employee_id_PK primary key (id),
constraint employee_salary_ck check (salary <= 500000)
);