create database ticket1_db;
use ticket1_db;

create table tickets(
id int not null auto_increment,
title varchar(50),
description1 varchar(100),
createdOn varchar(20),
primary key(id)
);

insert into tickets values (1, 'ABCD','sample ticket','8 Apr');
insert into tickets values (2, 'Wayanad Trip','Tour Packages','20091225');
insert into tickets values (3, 'ABCDNSM','sample ticket24','20091226');

select * from tickets;

SELECT * FROM tickets t WHERE t.title like '%mani%' or t.description1 LIKE '%mani%';



delete from tickets where id = 3;

alter table tickets modify id int auto_increment;
alter table tickets modify createdOn varchar(20);

update tickets set createdOn = '20091224' where id = 1;
update tickets set createdOn = '20231225' where id = 2;
update tickets set createdOn = '20231226' where id = 3;
