CREATE TABLE pessoa (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL UNIQUE,
    rg VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(100) NOT NULL UNIQUE,
    idade VARCHAR(100),
    ativo TINYINT,
    org_exped VARCHAR(100),
    data_nascimento DATE,
    formacao_academica VARCHAR(100),
    idiomas VARCHAR(30),
    cargo_atual VARCHAR(50),
    incluir_disclaimer_lgpd TINYINT(1),
    indicacao VARCHAR(20),
    nvl_cargo VARCHAR(20),
    especialidades VARCHAR(30),
    anotacoes VARCHAR(236)
);
