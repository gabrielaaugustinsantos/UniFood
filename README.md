# UniFood 🍽️

Sistema de Gerenciamento de Restaurante Universitário (RU) desenvolvido para a disciplina de Implementação de Software.

## Integrantes

* Gabriela Augustin
* Luize Riedi

## Objetivo

O UniFood tem como objetivo auxiliar o gerenciamento de um Restaurante Universitário, permitindo:

* Cadastro de usuários;
* Login de usuários;
* Consulta do cardápio;
* Registro de consumo de refeições;
* Controle de saldo dos usuários;
* Histórico de consumo;
* Emissão de relatórios simples.

## Tecnologias Utilizadas

* Java 17
* Maven
* Banco de Dados H2
* Arquitetura MVC
* Service Layer
* Git e GitHub

## Estrutura do Projeto

```text
src/main/java
│
├── config
│   └── DatabaseConfig.java
│
├── model
│   ├── Usuario.java
│   ├── Refeicao.java
│   └── HistoricoConsumo.java
│
├── repository
│   ├── UsuarioRepository.java
│   ├── RefeicaoRepository.java
│   └── HistoricoRepository.java
│
├── service
│   ├── UsuarioService.java
│   ├── LoginService.java
│   ├── ConsumoService.java
│   └── RelatorioService.java
│
├── handler
│   ├── UsuarioHandler.java
│   ├── CardapioHandler.java
│   └── RelatorioHandler.java
│
└── Main.java
```

## Funcionalidades Implementadas

### UC01 – Cadastro de Usuário

Permite cadastrar usuários contendo:

* ID
* Nome
* Matrícula
* E-mail
* Senha
* Saldo

Validações:

* Campos obrigatórios
* Matrícula única
* E-mail único
* ID único

### UC02 – Login

Permite autenticar usuários através de:

* E-mail
* Senha

### UC03 – Cardápio

Exibe as refeições disponíveis no Restaurante Universitário:

* Almoço Tradicional
* Almoço Vegetariano
* Janta Tradicional
* Janta Vegana

Cada refeição possui:

* Nome
* Descrição
* Valor
* Quantidade disponível

### UC04 – Consumo de Refeições

Permite:

* Selecionar uma refeição do cardápio
* Validar saldo do usuário
* Atualizar saldo após consumo
* Atualizar quantidade disponível da refeição
* Registrar histórico de consumo

### Relatórios

Permite visualizar:

* Quantidade total de refeições consumidas
* Histórico de consumo dos usuários

## Banco de Dados

O projeto utiliza o banco H2.

A conexão é configurada através da classe:

```java
DatabaseConfig.java
```

A tabela de usuários é criada automaticamente na inicialização do sistema.

## Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/gabrielaaugustinsantos/UniFood.git
```

### 2. Entrar na pasta do projeto

```bash
cd UniFood
```

### 3. Instalar dependências

```bash
mvn clean install
```

### 4. Executar o projeto

Pelo VS Code:

* Abrir o arquivo Main.java
* Clicar em Run Java

Ou pelo Maven:

```bash
mvn exec:java
```

## Fluxo de Demonstração

1. Cadastrar usuário.
2. Realizar login.
3. Visualizar cardápio.
4. Selecionar refeição.
5. Consumir refeição.
6. Verificar atualização do saldo.
7. Visualizar relatório de consumo.

## Controle de Versão

O projeto foi desenvolvido utilizando Git e GitHub, com acompanhamento das atividades pelo Trello.

## Status do Projeto

✅ Sprint 1 – Planejamento e Estruturação

✅ Sprint 2 – Cadastro, Login e Cardápio

✅ Sprint 3 – Consumo de Refeições e Relatórios

🚧 Sprint Final – Documentação, Testes e Apresentação
