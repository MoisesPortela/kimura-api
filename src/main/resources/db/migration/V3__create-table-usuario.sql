create table usuarios (
    id bigint not null auto_increment,
    login varchar(100) not null unique,
    senha varchar(255) not null,
    email varchar(100) not null unique,
    telefone varchar(100) not null unique,

    primary key (id)
)