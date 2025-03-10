CREATE TABLE experiencia(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pessoa_id BIGINT NOT NULL,
    nome VARCHAR(100),
    cargo VARCHAR(100),
    data_inicio DATE,
    data_fim DATE,
    atividades TEXT,
    CONSTRAINT fk_experiencia_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE CASCADE
);