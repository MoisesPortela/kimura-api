create table pessoas(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(100) not null unique,
    rg varchar(100)  not null unique,
    email varchar(100) not null unique,
    idade varchar(100),
    telefone varchar(100) not null unique,

    primary key (id)

);