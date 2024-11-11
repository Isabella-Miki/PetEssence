create table especie (
    id serial primary key,
    nome varchar(100) not null
);

create table raca (
    id serial primary key,
    nome varchar(100) not null
);

create table pet (
    id serial primary key,
    nome varchar(100) not null,
    situacao varchar(1) not null,
    idespecie int not null,
    idraca int not null,
    CONSTRAINT fk_especie FOREIGN KEY (idespecie) REFERENCES especie (id),
    CONSTRAINT fk_raca FOREIGN KEY (idraca) REFERENCES raca (id)
);

create table atendimento (
    id serial primary key,
    descricao varchar(200),
    dataatendimento date not null,
    horario time not null,
    idpet int not null,
    valor numeric(5,2) not null,
    duracao time not null,
    nomeveterinario varchar(100) not null,
    constraint fk_pet foreign key (idpet) references pet(id)
);

insert into raca (nome) values ('Corgi');
insert into especie (nome) values ('Cachorro');
insert into pet (nome, situacao, idespecie, idraca) values ('Meg', 'A', 1, 1);

select * from especie;

select * from raca;

select * from pet;