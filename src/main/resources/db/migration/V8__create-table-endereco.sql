create table endereco (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    entidade_tipo VARCHAR(10) NOT NULL CHECK (entidade_tipo IN ('Pessoa', 'Empresa')),
    entidade_id BIGINT NOT NULL,
    tipo_endereco VARCHAR(15) NOT NULL CHECK (tipo_endereco IN ('Nascimento', 'Trabalho', 'Comercial', 'Residencial', 'Outros')),
    cep varchar(50),
    logradouro varchar(100),
    complemento varchar(100),
    bairro varchar(100),
    localidade varchar(100),
    uf varchar(2)
);