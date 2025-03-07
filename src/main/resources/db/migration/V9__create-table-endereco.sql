CREATE TABLE endereco (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pessoa_id BIGINT NOT NULL,
    tipo_endereco VARCHAR(50),
    cep VARCHAR(20),
    logradouro VARCHAR(100),
    complemento VARCHAR(100),
    bairro VARCHAR(50),
    localidade VARCHAR(50),
    uf VARCHAR(2),
    CONSTRAINT fk_endereco_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE CASCADE
);