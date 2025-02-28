alter table endereco
    ADD COLUMN pessoa_id BIGINT NULL,
    ADD COLUMN empresa_id BIGINT NULL,
    ADD CONSTRAINT fk_endereco_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoas(id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_endereco_empresa FOREIGN KEY (empresa_id) REFERENCES empresas(id) ON DELETE CASCADE