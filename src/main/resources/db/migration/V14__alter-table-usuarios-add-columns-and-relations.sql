alter table usuarios
ADD COLUMN entidade_tipo VARCHAR(10) NOT NULL CHECK (entidade_tipo IN ('Pessoa', 'Empresa', 'Adm')),
ADD COLUMN entidade_id BIGINT NOT NULL,
ADD CONSTRAINT fk_usuario_pessoa FOREIGN KEY (entidade_id) REFERENCES pessoas(id) ON DELETE CASCADE,
ADD CONSTRAINT fk_usuario_empresa FOREIGN KEY (entidade_id) REFERENCES empresas(id) ON DELETE CASCADE,
ADD CONSTRAINT fk_usuario_adm FOREIGN KEY (entidade_id) REFERENCES adms(id) ON DELETE CASCADE;