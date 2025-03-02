CREATE TABLE usuario (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    tipo_perfil VARCHAR(100),
    ativo TINYINT,
    pessoa_id BIGINT UNIQUE,
    empresa_id BIGINT UNIQUE,
    adm_id BIGINT UNIQUE,
    CONSTRAINT fk_usuario_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE CASCADE,
    CONSTRAINT fk_usuario_empresa FOREIGN KEY (empresa_id) REFERENCES empresa(id) ON DELETE CASCADE,
    CONSTRAINT fk_usuario_adm FOREIGN KEY (adm_id) REFERENCES adm(id) ON DELETE CASCADE
);
