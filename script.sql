CREATE SCHEMA `exam_2020` ;

create table STUDENTS
(
	id int auto_increment,
	name varchar(30) not null,
	email varchar(45) not null,
	supervisor_id int not null,
	constraint STUDENTS_pk
		primary key (id)
);

create table SUPERVISORS
(
	id int auto_increment,
	name varchar(40) not null,
	constraint SUPERVISORS_pk
		primary key (id)
);

insert into supervisors (id, name) VALUES (default, 'Melting Snowman');
insert into supervisors (id, name) VALUES (default, 'Santa' 's' ' Assistant');
insert into supervisors (id, name) VALUES (default, 'Elf #94');

insert into students (id, name, email, supervisor_id) VALUES (default, 'Caspe Sliktern B Lichtenberg', 'slikternb@stud.kea.dk', 3);
insert into students (id, name, email, supervisor_id) VALUES (default, 'Shoto Todoroki', 'shotoooo@stud.kea.dk', 1);
insert into students (id, name, email, supervisor_id) VALUES (default, 'Katsuki Bakugo', 'angers@stud.kea.dk', 1);
insert into students (id, name, email, supervisor_id) VALUES (default, 'Kazuma desu', 'konosuba@stud.kea.dk', 2);
insert into students (id, name, email, supervisor_id) VALUES (default, 'Dmitri Krushnic', 'gishwes@stud.kea.dk', 2);
insert into students (id, name, email, supervisor_id) VALUES (default, 'Sparky', 'casperbff@stud.kea.dk', 3);

