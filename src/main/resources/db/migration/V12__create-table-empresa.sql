create table empresas (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    nome_fantasia varchar(100),
    cnpj varchar(100) not null,
    setor_economico varchar(100),
    telefone varchar(100),
    primary key (id)
)