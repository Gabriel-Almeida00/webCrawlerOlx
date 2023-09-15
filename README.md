# Web Crawler OLX

Este projeto consiste em desenvolver um Web Crawler para coletar dados do site OLX. O objetivo principal é automatizar o processo de coleta de informações sobre produtos na OLX, realizar cálculos estatísticos e gerar um arquivo CSV com os resultados.

## Funcionalidades

### 1. Coleta de Dados

O Web Crawler realiza as seguintes tarefas:

- Acessa o site da OLX.
- Pesquisa produtos com base nos seguintes critérios:
  - Nome do produto: iPhone 11.
  - Região: Goiás.
  - DDD: 62 - Grande Goiânia e Anápolis.
- Coleta dados das três primeiras páginas de resultados, ordenados por menor preço.
- Extrai as seguintes informações de cada anúncio:
  - Título.
  - Valor.
  - Endereço.
  - URL do anúncio.

### 2. Análise de Dados

- Calcula o valor médio dos iPhones com base nos dados coletados no passo anterior.
- Remove todos os produtos cujos valores estejam acima da média calculada.

### 3. Exportação de Dados

- Gera um arquivo CSV com os produtos que não foram removidos no passo anterior.
- O arquivo CSV contém as seguintes colunas:
  - Título do anúncio.
  - Valor.
  - Endereço.
  - URL do anúncio.

### 4. Produto de Menor e Maior Valor

- Indica para o usuário qual é o produto de menor e maior valor entre os que foram mantidos após a análise.

## Configurações e Requisitos

- O projeto utiliza a biblioteca HTTPBuilder para realizar as solicitações HTTP.
- É possível personalizar parâmetros, como o tipo de produto, o número de páginas a serem consultadas e a região, para adaptar o Web Crawler a diferentes necessidades.

## Envio e CRUD de Email

- O projeto tem a funcionalidade de enviar um e-mail contendo o arquivo ou informações coletadas para pessoas ou entidades interessadas.
- funcionalidade  para gerenciar uma lista de e-mails de pessoas interessadas, permitindo adicionar, remover, atualizar e listar contatos.

  
## Ferramentas e Bibliotecas Utilizadas

- Linguagem: Groovy
- Ferramenta de Build: Gradle
- Bibliotecas:
  - HTTPBuilder NG (https://http-builder-ng.github.io/http-builder-ng/)
  - Jsoup (https://jsoup.org/)

## Como Executar

1. Clone este repositório para a sua máquina.
2. Importe o projeto em sua IDE preferida.
3. Execute o método `executarProcessoCompleto()` na classe `CrawlerOlx` para iniciar a coleta e análise de dados.


## Contribuição

Se você quiser contribuir para o projeto, fique à vontade para abrir um pull request. Qualquer ajuda é bem-vinda!
