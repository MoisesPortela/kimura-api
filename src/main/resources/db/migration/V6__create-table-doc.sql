CREATE TABLE doc (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pessoa_id BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    caminho VARCHAR(200) NOT NULL,
    tipo VARCHAR(10),
    CONSTRAINT fk_docs_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE CASCADE
);
