create table foto (
    id bigint not null auto_increment,
    pessoa_id BIGINT NOT NULL,
    nome varchar(100) not null,
    legenda varchar(200),
    data date not null,
    imagem LONGBLOB,
    tamanho varchar(10),
    tipo varchar(10),
    primary key (id),
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id) ON DELETE CASCADE
);