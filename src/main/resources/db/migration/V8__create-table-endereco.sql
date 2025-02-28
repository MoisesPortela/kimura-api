create table endereco (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipo_endereco VARCHAR(15) NOT NULL CHECK (tipo_endereco IN ('Nascimento', 'Trabalho', 'Comercial', 'Residencial', 'Outros')),
    cep varchar(50),
    logradouro varchar(100),
    complemento varchar(100),
    bairro varchar(100),
    localidade varchar(100),
    uf varchar(2)
);