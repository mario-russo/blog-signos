CREATE TABLE IF NOT EXISTS conteudo (
    id SERIAL PRIMARY KEY,
    signo VARCHAR,
    conteudo TEXT,
    referencia VARCHAR,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR,
    email VARCHAR UNIQUE,
    senha VARCHAR,
    rules SMALLINT[],
    -- Supondo que "conteudo" tem uma coluna chamada "usuario_id" como chave estrangeira
    conteudo_id INT,
    FOREIGN KEY (conteudo_id) REFERENCES conteudo(id)
);