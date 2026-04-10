-- V1: Criar tabela de ingredientes

CREATE TABLE food_item(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    quantidade INTEGER NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    validade DATE NOT NULL
)