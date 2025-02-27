create table exp_prof(
id bigint not null auto_increment,
nome varchar(100) not null,
cargo varchar(100) not null,
data_inicio date not null,
data_fim date,
atividade varchar(500) not null,
pessoa_id bigint not null,
primary key (id),
FOREIGN KEY (pessoa_id) REFERENCES pessoas(id) ON DELETE CASCADE
);