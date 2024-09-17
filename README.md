
# 🎓 Smart Broker API - Correção de Atividades Personalizada no Programa Coda Mundo

A **Smart Broker API** é uma peça fundamental do programa **Coda Mundo** da ZUP, que oferece letramento digital e em programação para alunos de escolas públicas no Brasil. Esta API foi projetada para apoiar professores e alunos no processo de correção de atividades dentro das oficinas de letramento digital, fornecendo feedback personalizado e adaptado ao perfil de cada estudante.

Utilizando inteligência artificial, a API avalia as respostas dos alunos com base em suas características pessoais e nas atividades que eles submetem. O objetivo é oferecer um feedback detalhado e didático, alinhado às competências do programa, como o letramento digital, o pensamento computacional e a lógica de programação. A correção vai além do simples "certo" ou "errado", gerando um retorno que auxilia o aluno a aprimorar suas habilidades, sempre de maneira crítica e adaptada às suas necessidades educacionais.

### Correção de Atividades
O endpoint de correção de atividades é o coração da API, onde todo o poder da IA é aplicado para avaliar as respostas dos alunos. As informações pessoais dos alunos, juntamente com as características didáticas das atividades, são usadas para gerar um feedback construtivo e detalhado.

## 📑 Recursos e Métodos Disponíveis

| Recurso        | Método                        | Descrição                                  |
|----------------|-------------------------------|--------------------------------------------|
| **Aluno**      | `GET /alunos/{id}`             | Retorna os dados de um aluno específico    |
|                | `POST /alunos`                | Cria um novo aluno                        |
|                | `PATCH /alunos/{id}`          | Atualiza os dados de um aluno              |
|                | `DELETE /alunos/{id}`         | Deleta os dados de um aluno                |
| **Professor**  | `GET /professores/{id}`        | Retorna os dados de um professor específico|
|                | `POST /professores`           | Cria um novo professor                     |
|                | `PATCH /professores/{id}`     | Atualiza os dados de um professor          |
|                | `DELETE /professores/{id}`    | Deleta os dados de um professor            |
| **Atividade**  | `GET /atividades/{id}`         | Retorna os dados de uma atividade específica|
|                | `POST /atividades`            | Cria uma nova atividade                    |
|                | `PATCH /atividades/{id}`      | Atualiza os dados de uma atividade         |
|                | `DELETE /atividades/{id}`     | Deleta os dados de uma atividade           |
| **Contexto**   | `GET /contextos/{id}`          | Retorna os dados de um contexto específico |
|                | `POST /contextos`             | Cria um novo contexto                      |
|                | `PATCH /contextos/{id}`       | Atualiza os dados de um contexto           |
|                | `DELETE /contextos/{id}`      | Deleta os dados de um contexto             |

## Estrutura do Projeto

A estrutura do projeto segue uma arquitetura limpa, dividida em várias camadas para separar as responsabilidades e facilitar a manutenção e evolução do código.

```
smart_broker_api_g10
│
├── adapters                  // Adaptadores que conectam a aplicação com o mundo externo (controladores e gateways)
│   ├── controllers            // Controladores REST que recebem requisições HTTP e delegam para os casos de uso
│   └── output                 // Implementações de saída, como gateways para comunicação com APIs e repositórios
│       ├── gateways           // Gateways de saída que fazem a comunicação com fontes externas, como banco de dados e APIs externas
│       └── repositories       // Repositórios JPA para interação com o banco de dados
│
├── application               // Camada da lógica de aplicação
│   ├── ports                 // Portas que conectam o núcleo da aplicação aos adaptadores
│   │   ├── input             // Interfaces de entrada (usadas pelos controladores para os casos de uso)
│   │   └── output            // Interfaces de saída (usadas pelos gateways para comunicação com APIs externas e banco de dados)
│   └── usecases              // Casos de uso que contêm a lógica de negócio da aplicação
│
├── domain                    // Camada do domínio (contém as entidades e regras de negócio)
│   ├── models                // Modelos de domínio (representações das entidades do mundo real, sem dependências externas)
│   ├── services              // Serviços de domínio que encapsulam a lógica de negócio
│   └── entities              // Entidades que são mapeadas para o banco de dados
│
├── shared                    // Classes e componentes compartilhados em toda a aplicação
│   ├── dto                   // Objetos de Transferência de Dados (Data Transfer Objects)
│   └── exceptions            // Classes relacionadas ao tratamento de exceções globais
```

## Funcionalidades

### Gerenciamento de Aluno
- **Buscar Aluno por ID**
- **Salvar Aluno**
- **Atualizar Aluno**

### Gerenciamento de Atividade
- **Buscar Atividade por ID**
- **Salvar Atividade**
- **Atualizar Atividade**

### Gerenciamento de Professor
- **Buscar Professor por ID**
- **Salvar Professor**
- **Atualizar Professor**

### Gerenciamento de Contexto
- **Buscar Contexto por ID**
- **Salvar Contexto**
- **Atualizar Contexto**

### Integração com API do ChatGPT
- **Enriquecer Correção**: Envia uma solicitação para a API do ChatGPT e retorna a resposta enriquecida.

## Tecnologias Utilizadas

- **Kotlin**
- **Java**
- **Spring Boot**
- **Maven**
- **WebClient** (para comunicação com APIs externas)
- **Jackson** (para serialização e desserialização de JSON)

## Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/cassiorobertogs/smart_broker_api_g10.git
   cd smart_broker_api_g10
   ```

2. **Compile e execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acesse a API:**
   A API estará disponível em `http://localhost:8080`.

## Contribuição

1. **Fork o projeto**
2. **Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)**
3. **Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)**
4. **Push para a branch (`git push origin feature/nova-feature`)**
5. **Abra um Pull Request**

## Banco de Dados

### Diagrama Entidade-Relacionamento (ER)

O diagrama representa um modelo de banco de dados, com várias entidades conectadas por relações entre elas. Cada entidade contém atributos que definem suas características. Abaixo estão as entidades e seus respectivos atributos, seguidos pelos relacionamentos entre elas:

Entidades e seus atributos:
ALUNO:

id (Long): Identificador único do aluno.
nome (String): Nome do aluno.
idade (Integer): Idade do aluno.
oficinaCadastrada (String): Oficina na qual o aluno está inscrito.
turma (String): Turma do aluno.
pessoaComDeficiencia (Boolean): Indica se o aluno possui alguma deficiência.
estiloAprendizagem (String): Estilo de aprendizagem do aluno.
interessesHobbies (String): Interesses e hobbies do aluno.
passaTempoPreferido (String): Atividades preferidas no tempo livre.
filmeSeriePreferido (String): Filme ou série favorita.
artista (String): Artista favorito.
ATIVIDADE:

id (Long): Identificador único da atividade.
enunciado (String): Enunciado da atividade.
respostaEsperada (String): Resposta esperada para a atividade.
areaConhecimento (String): Área do conhecimento a que a atividade pertence.
nivelDificuldade (String): Nível de dificuldade da atividade.
objetivosAprendizagem (String): Objetivos de aprendizagem da atividade.
PROFESSOR:

id (Long): Identificador único do professor.
nome (String): Nome do professor.
especialidade (String): Especialidade do professor.
CONTEXTO:

id (Long): Identificador único do contexto.
prompt (String): Prompt que guia a atividade.
coeficienteDidatico (Double): Coeficiente didático usado para gerar feedback personalizado.
OFICINA:

id (Long): Identificador único da oficina.
escola (String): Nome da escola onde a oficina é realizada.
TURMA:

id (Long): Identificador único da turma.
quantidadeAlunos (Integer): Quantidade de alunos na turma.
RESPOSTA:

id (Long): Identificador único da resposta do aluno.
respostaAluno (String): Resposta dada pelo aluno.
coeficienteAcertividade (Double): Avaliação da precisão da resposta.
dataHoraResposta (LocalDateTime): Data e hora da resposta.
Relacionamentos:
ALUNO está associado a uma TURMA.
TURMA pode realizar várias ATIVIDADES.
Um PROFESSOR cria uma ATIVIDADE.
Cada ATIVIDADE está associada a um CONTEXTO.
ATIVIDADE está ligada a uma ou mais RESPOSTAS dos alunos.
Uma TURMA pertence a uma OFICINA.

```mermaid
graph LR;

%% Declaração das entidades (tabelas do banco de dados)
Aluno[ALUNO]:::entity;
Atividade[ATIVIDADE]:::entity;
Professor[PROFESSOR]:::entity;
Contexto[CONTEXTO]:::entity;
Oficina[OFICINA]:::entity;
Turma[TURMA]:::entity;
Resposta[RESPOSTA]:::entity;

%% Atributos de cada entidade

%% Entidade Aluno: armazena informações sobre os alunos
Aluno --> |id: Long, nome: String, idade: Integer, oficinaCadastrada: String, turma: String, pessoaComDeficiencia: Boolean, estiloAprendizagem: String, interessesHobbies: String, passaTempoPreferido: String, filmeSeriePreferido: String, artista: String| Aluno;

%% Entidade Atividade: armazena dados das atividades propostas aos alunos
Atividade --> |id: Long, enunciado: String, respostaEsperada: String, areaConhecimento: String, nivelDificuldade: String, objetivosAprendizagem: String| Atividade;

%% Entidade Professor: armazena informações sobre os professores
Professor --> |id: Long, nome: String, especialidade: String| Professor;

%% Entidade Contexto: guarda os prompts e coeficientes didáticos para gerar feedback personalizado
Contexto --> |id: Long, prompt: String, coeficienteDidatico: Double| Contexto;

%% Entidade Oficina: informações da oficina na qual o aluno está inscrito
Oficina --> |id: Long, escola: String| Oficina;

%% Entidade Turma: contém dados sobre as turmas de alunos
Turma --> |id: Long, quantidadeAlunos: Integer| Turma;

%% Entidade Resposta: armazena as respostas dos alunos para as atividades
Resposta --> |id: Long, respostaAluno: String, coeficienteAcertividade: Double, dataHoraResposta: LocalDateTime| Resposta;

%% Relacionamentos entre as entidades

%% Relacionamento entre Aluno e Turma (um aluno está em uma turma)
Aluno --> Turma;

%% Relacionamento entre Turma e Atividade (uma turma faz várias atividades)
Turma --> Atividade;

%% Relacionamento entre Professor e Atividade (um professor cria uma atividade)
Professor --> Atividade;

%% Relacionamento entre Atividade e Contexto (cada atividade está associada a um contexto)
Atividade --> Contexto;

%% Relacionamento entre Atividade e Resposta (cada atividade tem uma ou mais respostas dos alunos)
Atividade --> Resposta;

%% Relacionamento entre Turma e Oficina (uma turma pertence a uma oficina)
Turma --> Oficina;

%% Estilo para entidades
classDef entity fill:#f9f,stroke:#333,stroke-width:2px;
```

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
