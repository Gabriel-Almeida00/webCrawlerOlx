-- Criação da tabela de Produtos
CREATE TABLE Produtos (
    ID SERIAL PRIMARY KEY,
    Titulo VARCHAR(255),
    Preco NUMERIC(10, 2),
    Endereco VARCHAR(255),
    URL VARCHAR(255),
    DataAnuncio DATE,
    DescricaoVendedor TEXT,
    ParcelasPossiveis INTEGER,
    ValorEntrega NUMERIC(10, 2),
    DiasUteisEntrega INTEGER
);

-- Criação da tabela de Localização
CREATE TABLE Localizacao (
    ID SERIAL PRIMARY KEY,
    ProdutoID INTEGER REFERENCES Produtos(ID),
    CEP VARCHAR(8),
    Municipio VARCHAR(100),
    Bairro VARCHAR(100)
);

-- Criação da tabela de Detalhes do Produto
CREATE TABLE DetalhesProduto (
    ID SERIAL PRIMARY KEY,
    ProdutoID INTEGER REFERENCES Produtos(ID),
    Cor VARCHAR(50),
    Modelo VARCHAR(50)
);

-- Criação da tabela de E-mails
CREATE TABLE Emails (
    ID SERIAL PRIMARY KEY,
    Endereco VARCHAR(255)
);
