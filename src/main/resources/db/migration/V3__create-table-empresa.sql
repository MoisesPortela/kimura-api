CREATE TABLE empresa (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nome_fantasia VARCHAR(100),
    cnpj VARCHAR(100) NOT NULL UNIQUE,
    setor_economico VARCHAR(100),
    telefone VARCHAR(100),
    ativo TINYINT
);
