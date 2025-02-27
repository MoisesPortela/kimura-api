create table docs (
    id bigint not null auto_increment,
    pessoa_id BIGINT NOT NULL,
    nome varchar(100) not null,
    arquivo LONGBLOB,
    tipo varchar(10),
    primary key (id),
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id) ON DELETE CASCADE
);