CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    email VARCHAR UNIQUE,
    senha VARCHAR,
    rules SMALLINT[],
    -- Supondo que "conteudo" tem uma coluna chamada "usuario_id" como chave estrangeira
    conteudo_id INT
);
CREATE TABLE conteudo (
    id SERIAL PRIMARY KEY,
    signo VARCHAR(30),
    conteudo VARCHAR(1500),
    referencia VARCHAR(30),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

ALTER TABLE usuario
ADD CONSTRAINT fk_conteudo
FOREIGN KEY (conteudo_id) REFERENCES conteudo(id);


INSERT INTO usuario (nome, email, senha, rules)
VALUES
  ('mario russo', 'mario.russo93@hotmail.com', '1234', ARRAY[0,1]),
  ('russo', 'russo@example.com', 'senha', ARRAY[1.0]),
  ('araujo', 'araujo@example.com', 'senha', ARRAY[1]),
  ('goncalves', 'goncalves@example.com', 'senha', ARRAY[0]),
  ('teste', 'teste@example.com', 'senha', ARRAY[1]);
