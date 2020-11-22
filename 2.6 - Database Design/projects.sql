drop table employee_project;
drop table employee;
drop table project;
drop table department;

BEGIN TRANSACTION;

CREATE TABLE department
(
        department_id serial,
        name varchar(50) not null,
        
        constraint pk_department primary key (department_id),
        constraint ck_name check (name IN ('Department of Baking', 'Icing, etc.', 'Ministry of Sprinkles', 'Slinging Donuts a.k.a. Sales', 'Management & Other Horrors'))
);

CREATE TABLE project
(
        project_id serial,
        name varchar(50) not null,
        start_date date not null,
        
        constraint pk_project primary key (project_id)
);

CREATE TABLE employee
(
        employee_id serial,
        job_title varchar(50) not null,
        department_id int not null,
        date_of_hire date not null,
        first_name varchar(25) not null,
        last_name varchar(25) not null,
        gender varchar(25),
        date_of_birth date not null,
        
        constraint pk_employee primary key (employee_id),
        constraint fk_employee_department foreign key (department_id) references department (department_id),
        constraint ck_gender check (gender IN ('female', 'male', 'non-binary', 'other'))
);

CREATE TABLE employee_project
(
        employee_project_id serial,
        employee_id int not null,
        project_id int not null,
        
        constraint fk_employee_project_employee foreign key (employee_id) references employee (employee_id),
        constraint fk_employee_project_project foreign key (project_id) references project (project_id)
);

COMMIT TRANSACTION;

INSERT INTO department (name) VALUES ('Department of Baking');
INSERT INTO department (name) VALUES ('Icing, etc.');
INSERT INTO department (name) VALUES ('Ministry of Sprinkles');
INSERT INTO department (name) VALUES ('Slinging Donuts a.k.a. Sales');

INSERT INTO project (name, start_date) VALUES ('Search for the Next Great Cruller', '2019-11-01');
INSERT INTO project (name, start_date) VALUES ('The Self-Refilling Jelly Donut', '2010-01-13');
INSERT INTO project (name, start_date) VALUES ('Keto Donuts Because Apparently That Is a Thing Now', '2020-01-01');
INSERT INTO project (name, start_date) VALUES ('Glazed and Confused: Donut-Induced Delirium', '2000-07-18');
INSERT INTO project (name, start_date) VALUES ('Donut, Doughnut, or Deauxnuhtte?', '2005-04-23');

INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Dough Mixer', 1, '1983-11-01', 'Bob', 'Buttermilk', 'male', '1963-01-02');
INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Fry Master', 1, '1999-04-30', 'Cindy', 'Cinnamonroll', 'female', '1980-05-20');
INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Hole Puncher', 1, '1997-06-06', 'Cranston', 'Crullerman', 'male', '1976-08-08');
INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Glaze Master', 2, '2004-03-24', 'Eda', 'Dozen', 'non-binary', '1986-03-09');
INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Frosting Drizzler', 2, '2001-08-15', 'Glazea', 'Lottavum', 'other', '1969-04-22');
INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Sprinkle Bedazzler', 3, '1965-07-07', 'Spencer', 'Sprinkleton', 'male', '1936-01-27');
INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Sprinkle Bedazzler', 3, '2002-02-28', 'Kay', 'Kdonut', 'female', '1988-07-12');
INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Cashier', 4, '1992-01-17', 'May', 'Pultwist', 'non-binary', '1971-09-19');       
INSERT INTO employee (job_title, department_id, date_of_hire, first_name, last_name, gender, date_of_birth)
        VALUES ('Order Taker & Boxer', 4, '2007-12-01', 'Sherry', 'Danish', 'female', '1991-02-03');

INSERT INTO employee_project (employee_id, project_id) VALUES (1, 5);
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (2, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (3, 5);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (6, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (7, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (8, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (9, 2);

    