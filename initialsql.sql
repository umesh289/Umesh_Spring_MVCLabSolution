use studentdb;
drop table student;

create table student
(
id int primary key auto_increment,
name varchar(50),
department varchar(50),
country varchar(50)
);

select * from student;

insert into student values
(1, "Suresh", "BTech", "India"),
(2, "Muri", "BE", "Canada"),
(3, "Daniel", "BArch", "New Zealand"),
(4, "Tanya", "BComm", "USA")

