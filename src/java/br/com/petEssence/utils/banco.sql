create table especie (
    id serial primary key,
    nome varchar(100) not null
);

create table raca (
    id serial primary key,
    nome varchar(100) not null
);

insert into raca (nome) values ('Corgi');
insert into especie (nome) values ('Cachorro');

select * from especie;

select * from raca;