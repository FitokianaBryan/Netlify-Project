create sequence sqvehicule;
create sequence sqtokenadmin;

create table Admin(
idAdmin varchar(10) primary key not null,
users varchar(10),
mdp varchar(10)
);

insert into Admin(idadmin,users,mdp) values ('admin1','hardi','hardi');
insert into Admin(idadmin,users,mdp) values ('admin2','anjary','anjary');
insert into Admin(idadmin,users,mdp) values ('admin3','bryan','bryan');


create table Vehicule( 
idvehicule varchar(10) primary key not null default 'auto'||nextval('sqvehicule'),
nomvehicule varchar(10),
numero varchar(10)
);

insert into Vehicule(nomvehicule,numero) values ('porshe','AT344') ,  ('Tibag','AV56') , ('V8','T34B8') , ('Fortuner','C3T6');

create table Mouvement(
idvehicule varchar(10) references Vehicule(idvehicule),
dateMouvement date,
departkm int,
arriveekm int
);

insert into Mouvement(idvehicule,datemouvement,departkm,arriveekm) values ('auto1','2022-10-08',100,400) , ('auto2','2022-10-09',100,300); 

create table tokenAdmin(
idtokenadmin varchar(10) primary key not null default 'tokena'||nextval('sqtokenadmin'),
idadmin varchar(10) references Admin(idadmin),
token varchar(100),
datecreation date,
dateexpiration date,
role varchar(10)
);
