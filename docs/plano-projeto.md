# Plano de Projeto — Sistema de Gerenciamento de Restaurante Universitário (RU)

## Grupo
- Gabriela Augustin
- Luize Riedi

## Repositórios e Ferramentas

GitHub: https://github.com/gabrielaaugustinsantos/UniFood

Trello: https://trello.com/b/zafXvcb7/unifood

---

# 1. Objetivo do Projeto

O projeto tem como objetivo desenvolver um sistema de gerenciamento para Restaurante Universitário (RU), permitindo o controle de usuários, refeições, créditos e consumo de refeições.

O sistema busca facilitar a administração do restaurante e melhorar a experiência dos estudantes no acesso às refeições.

---

# 2. Escopo do Sistema

## UC1 — Gestão de Usuários
- Cadastro de alunos
- Cadastro de administradores
- Login

## UC2 — Gestão do Cardápio
- Cadastro de refeições
- Cardápio semanal
- Informações nutricionais

## UC3 — Controle de Créditos e Refeições
- Saldo de créditos do aluno
- Registro de consumo
- Histórico de refeições

## UC4 — Relatórios
- Refeições mais consumidas
- Quantidade de usuários por dia
- Gastos mensais
- Controle de estoque simples

---

# 3. Casos de Uso

## UC01 — Cadastro de Usuário

### Atores
- Aluno
- Administrador

### Fluxo Principal

1. O usuário acessa a tela de cadastro.
2. O sistema solicita:
   - Nome
   - Matrícula
   - E-mail
   - Senha
3. O usuário preenche os dados.
4. O sistema valida as informações.
5. O sistema verifica duplicidade de matrícula e e-mail.
6. O sistema salva os dados.
7. O sistema confirma o cadastro.

### Regras de Negócio
- Matrícula deve ser única.
- E-mail deve ser único.
- Campos obrigatórios não podem ficar vazios.

---

## UC02 — Login no Sistema

### Atores
- Aluno
- Administrador

### Fluxo Principal

1. O usuário acessa a tela de login.
2. O sistema solicita matrícula/e-mail e senha.
3. O usuário informa os dados.
4. O sistema valida as credenciais.
5. O sistema autentica o usuário.
6. O sistema libera acesso.

### Regras de Negócio
- Senha deve corresponder ao usuário.
- Usuários bloqueados não podem acessar.

---

## UC03 — Visualizar Cardápio

### Atores
- Aluno
- Administrador

### Fluxo Principal

1. O usuário acessa o cardápio.
2. O sistema consulta refeições cadastradas.
3. O sistema exibe:
   - Nome
   - Descrição
   - Valor
   - Quantidade disponível
   - Data
4. O usuário visualiza o cardápio.

### Regras de Negócio
- Apenas refeições disponíveis serão exibidas.

---

## UC04 — Registrar Consumo de Refeição

### Atores
- Aluno
- Administrador

### Fluxo Principal

1. O usuário seleciona uma refeição.
2. O sistema verifica saldo.
3. O sistema verifica disponibilidade.
4. O sistema registra consumo.
5. O saldo é atualizado.
6. A quantidade da refeição é reduzida.
7. O sistema confirma o consumo.

### Regras de Negócio
- Usuário não pode consumir sem saldo.
- Refeições esgotadas não podem ser selecionadas.

---

# 4. Planejamento das Sprints

| Sprint | Casos de Uso | Objetivos |
|---------|---------|---------|
| Sprint 1 | UC01 e UC02 | Estrutura do projeto, arquitetura MVC, banco e autenticação |
| Sprint 2 | UC03 | Implementação do cardápio |
| Sprint 3 | UC04 | Controle de consumo e saldo |
| Sprint 4 | Testes e finalização | Correções, documentação e apresentação |

---

# 5. Priorização dos Casos de Uso

| Prioridade | Caso de Uso | Justificativa |
|-----------|------------|---------------|
| Alta | UC01 — Cadastro de Usuário | Base do sistema |
| Alta | UC02 — Login | Necessário para acesso |
| Média | UC03 — Visualizar Cardápio | Consulta principal |
| Alta | UC04 — Registrar Consumo | Operação principal |

---

# 6. Cronograma do Projeto

| Semana | Atividade |
|---------|-----------|
| Semana 1 | Planejamento, GitHub, Trello e estrutura |
| Semana 2 | Cadastro e login |
| Semana 3 | Cardápio |
| Semana 4 | Consumo |
| Semana 5 | Testes e documentação |

---

# 7. Riscos do Projeto

| Risco | Impacto | Mitigação |
|--------|---------|-----------|
| Atraso no desenvolvimento | Médio | Divisão equilibrada |
| Conflitos no GitHub | Médio | Uso de branches e PR |
| Problemas de integração | Alto | Integrações frequentes |
| Falhas no banco | Alto | Testes e backups |

---

# 8. Critérios de Aceite

O projeto será considerado aceito quando:

- Cadastro e login funcionarem corretamente;
- Cardápio estiver integrado ao banco;
- Consumo atualizar saldo e disponibilidade;
- Persistência em banco estiver implementada;
- Repositório GitHub estiver organizado;
- Documentação estiver atualizada;
- Testes básicos forem executados.

---

# 9. Estimativas Baseadas em Casos de Uso (UC Points)

| Caso de Uso | Complexidade | UC Points | Horas | Responsável | Sprint |
|-------------|-------------|-----------|-------|-------------|--------|
| UC01 — Cadastro | Média | 5 | 10h | Gabriela | Sprint 1 |
| UC02 — Login | Média | 5 | 8h | Luize | Sprint 1 |
| UC03 — Cardápio | Baixa | 3 | 6h | Luize | Sprint 2 |
| UC04 — Consumo | Alta | 8 | 14h | Gabriela | Sprint 3 |
| Testes finais | Média | 5 | 10h | Equipe | Sprint 4 |
| Documentação | Baixa | 3 | 6h | Equipe | Sprint 4 |

### Total do Projeto
- UC Points: 29
- Horas estimadas: 54h

---

# 10. Cerimônias Scrum

## Sprint Planning — Sprint 1

Foi definido como objetivo estruturar o sistema UniFood, configurar ambiente, arquitetura MVC e banco de dados.

Casos selecionados:
- UC01 — Cadastro
- UC02 — Login

As tarefas foram distribuídas entre Gabriela e Luize.

---

## Registro das Dailies

As reuniões acompanharam:

- Configuração do GitHub
- Banco de dados
- Estrutura MVC
- Cadastro
- Login
- Integrações

---

## Sprint Review

Foram apresentados:

- Estrutura inicial
- Banco configurado
- Cadastro
- Login
- Organização do GitHub e Trello

Feedback:
- Boa organização
- Melhorar interface
- Adicionar validações

---

## Retrospectiva

Pontos positivos:
- Boa divisão das tarefas
- Comunicação eficiente

Melhorias para Sprint 2:
- Mais commits
- Melhor planejamento técnico
- Integrações frequentes