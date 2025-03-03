ALTER TABLE pessoa
    ADD COLUMN tipo_endereco VARCHAR(20),
    ADD COLUMN cep VARCHAR(20),
    ADD COLUMN logradouro VARCHAR(100),
    ADD COLUMN complemento VARCHAR(100),
    ADD COLUMN bairro VARCHAR(50),
    ADD COLUMN localidade VARCHAR(50),
    ADD COLUMN uf VARCHAR(2);