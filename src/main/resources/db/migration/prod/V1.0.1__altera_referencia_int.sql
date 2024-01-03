-- V2__alterar_referencia_para_int.sql
-- Remover a chave estrangeira temporariamente
ALTER TABLE
    conteudo DROP CONSTRAINT IF EXISTS fk_usuario;

-- Criar uma nova coluna temporária com o tipo INT
ALTER TABLE
    conteudo
ADD
    COLUMN nova_referencia INT;

-- Atualizar os valores da nova coluna com base nos valores antigos convertidos
UPDATE
    conteudo
SET
    nova_referencia = CAST(referencia AS INT);

-- Remover a antiga coluna de referência
ALTER TABLE
    conteudo DROP COLUMN referencia;

-- Renomear a nova coluna para o nome desejado
ALTER TABLE
    conteudo RENAME COLUMN nova_referencia TO referencia;

-- Adicionar a chave estrangeira de volta
ALTER TABLE
    conteudo
ADD
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id);