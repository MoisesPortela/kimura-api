CREATE TABLE foto (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    legenda VARCHAR(200),
    data DATE NOT NULL,
    caminho VARCHAR(200) NOT NULL,
    tamanho VARCHAR(10),
    tipo VARCHAR(10),
    pessoa_id BIGINT UNIQUE,
    CONSTRAINT fk_foto_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE CASCADE
);
