
# Documentação Técnica: Configuração e Execução do Contêiner PostgreSQL

Este documento descreve como configurar, subir e verificar um contêiner PostgreSQL usando Docker, além de realizar conexões e manipular tabelas no banco de dados.

---

## 1. Preparação Inicial

Antes de começar, certifique-se de que o **Docker** está instalado e em execução na sua máquina. Você pode verificar se o Docker está pronto rodando o seguinte comando no terminal:

```bash
docker --version
```

### Verificando Docker em Execução:

1. Verifique se o Docker Desktop está rodando (para usuários do Windows/macOS).
2. Execute o comando abaixo para garantir que o daemon do Docker está em execução:

```bash
docker info
```

Se esse comando listar as informações sobre seu ambiente Docker, você está pronto para seguir com os próximos passos.

---

## 2. Subindo o Contêiner PostgreSQL com Docker Compose

### Passo 1: Clonar o Repositório (caso o projeto esteja hospedado em um repositório Git)

Primeiro, obtenha os arquivos do projeto (incluindo o `docker-compose.yml` e qualquer outro arquivo relevante) clonando o repositório com o seguinte comando:

```bash
git clone https://github.com/seu-usuario/seu-projeto.git
cd seu-projeto
```

### Passo 2: Verificar o Arquivo `docker-compose.yml`

No arquivo `docker-compose.yml`, você deve encontrar a seguinte configuração para o PostgreSQL:

```yaml
version: '3.8'
services:
  db:
    image: postgres:15
    environment:
      POSTGRES_DB: meu_banco
      POSTGRES_USER: usuario
      POSTGRES_PASSWORD: 1234
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

volumes:
  pgdata:
```

### Passo 3: Subir o Contêiner

Com o arquivo `docker-compose.yml` configurado corretamente, execute o seguinte comando para subir o contêiner do PostgreSQL:

```bash
docker-compose up -d
```

Esse comando iniciará o contêiner em modo **detached** (em segundo plano). O Docker irá baixar a imagem do PostgreSQL (caso ainda não esteja no seu sistema) e iniciar o serviço.

---

## 3. Verificando se o Contêiner Está Rodando

Para verificar se o contêiner do PostgreSQL está em execução, você pode rodar o comando:

```bash
docker ps
```

Esse comando listará todos os contêineres ativos. Você deve ver uma saída similar a esta:

```bash
CONTAINER ID   IMAGE         COMMAND                  CREATED         STATUS         PORTS                    NAMES
8e315d45ea21   postgres:15   "docker-entrypoint.s…"   6 minutes ago   Up 6 minutes   0.0.0.0:5432->5432/tcp   smart-broker-api-g10-db-1
```

Isso confirma que o contêiner está rodando e o PostgreSQL está disponível na porta `5432`.

---

## 4. Conectando-se ao Banco de Dados PostgreSQL

Você pode se conectar ao banco de dados diretamente de dentro do contêiner usando o cliente `psql`.

### Passo 1: Acessar o Contêiner PostgreSQL

Use o seguinte comando para abrir um terminal dentro do contêiner PostgreSQL:

```bash
docker exec -it smart-broker-api-g10-db-1 psql -U usuario -d meu_banco
```

- **`smart-broker-api-g10-db-1`**: Nome do contêiner (obtido no comando `docker ps`).
- **`-U usuario`**: Nome de usuário definido no `docker-compose.yml`.
- **`-d meu_banco`**: Nome do banco de dados definido no `docker-compose.yml`.

### Passo 2: Verificando as Tabelas Existentes

Se o contêiner PostgreSQL estiver usando volumes persistentes (como configurado no `docker-compose.yml`), as tabelas que você criou anteriormente ainda estarão disponíveis. Para verificar as tabelas existentes, use o comando:

```sql
\dt
```

Isso listará todas as tabelas do banco de dados.

---

## 5. Criando as Tabelas no Banco de Dados

Caso as tabelas ainda não estejam criadas, você pode executar o seguinte script SQL manualmente no terminal `psql`:

```sql
-- Criação das tabelas
CREATE TABLE oficina (
    id_oficina SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    escola VARCHAR(255)
);

CREATE TABLE professor (
    id_professor SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especialidade VARCHAR(255)
);

CREATE TABLE turma (
    id_turma SERIAL PRIMARY KEY,
    id_oficina INT NOT NULL,
    id_professor INT NOT NULL,
    quantidade_alunos INT,
    CONSTRAINT fk_oficina FOREIGN KEY (id_oficina) REFERENCES oficina(id_oficina),
    CONSTRAINT fk_professor FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
);

CREATE TABLE contexto (
    id_contexto SERIAL PRIMARY KEY,
    prompt TEXT,
    coeficiente_didatico DOUBLE PRECISION
);

CREATE TABLE aluno (
    id_aluno SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    pessoa_com_deficiencia BOOLEAN,
    estilo_aprendizagem VARCHAR(255),
    interesses_hobbies VARCHAR(255),
    passa_tempo_preferido VARCHAR(255),
    filme_serie_preferido VARCHAR(255),
    artista VARCHAR(255),
    tipo_de_deficiencia VARCHAR(255),
    id_turma INT NOT NULL,
    CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma)
);

CREATE TABLE atividade (
    id_atividade SERIAL PRIMARY KEY,
    enunciado TEXT,
    resposta_esperada TEXT,
    area_conhecimento VARCHAR(255),
    nivel_dificuldade VARCHAR(255),
    objetivos_aprendizagem TEXT,
    id_oficina INT NOT NULL,
    CONSTRAINT fk_oficina FOREIGN KEY (id_oficina) REFERENCES oficina(id_oficina)
);

CREATE TABLE resposta (
    id_resposta SERIAL PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_atividade INT NOT NULL,
    resposta_aluno TEXT,
    resposta_correcao TEXT,
    coeficiente_acertividade DOUBLE PRECISION,
    data_hora_resposta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_aluno FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
    CONSTRAINT fk_atividade FOREIGN KEY (id_atividade) REFERENCES atividade(id_atividade)
);
```

---

## 6. Persistência dos Dados

O volume `pgdata` definido no `docker-compose.yml` garante que os dados do banco de dados sejam persistidos, mesmo que o contêiner seja parado ou removido. Se você já criou as tabelas anteriormente e o contêiner foi reiniciado, os dados continuarão disponíveis.

---

## 7. Finalizando a Conexão com o Banco de Dados

Para sair do terminal `psql`, basta digitar:

```bash
\q
```

Isso encerra a sessão e retorna ao terminal padrão.

---

## Conclusão

Seguindo este guia, você poderá subir o contêiner PostgreSQL com Docker, verificar se ele está rodando corretamente, se conectar ao banco de dados, e gerenciar tabelas e dados. O uso de volumes persistentes garante que as tabelas e dados sejam mantidos mesmo após reiniciar o contêiner.
