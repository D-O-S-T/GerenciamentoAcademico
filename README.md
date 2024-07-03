

# SGA-IC

![Banner](https://i.imgur.com/xgt1z6m.png)

## Descrição
Este projeto é um Sistema de Gestão Acadêmica voltado para projetos de Iniciação Científica, utilizando Servlets, JSP e Java para funcionalidades baseadas na web. 

O sistema facilita tarefas comuns de gerenciamento em ambientes acadêmicos, como registro de alunos, gestão de cursos e solicitações de bolsas.

## Funcionalidades
O sistema é dividido em três perfis de acesso diferentes, o nível de acesso é definido no login, que pode ser de professor, coordenador ou aluno :

![Captura de tela 2024-07-02 213527](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/40a06fb5-035a-449d-be49-098c388184e4)



## Perfil do professor :

![Captura de tela 2024-07-02 213703](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/9b05dfe0-9a11-4185-9317-70e09565de55)


**Inserir Feedback para alunos**: O Professor pode inserir um feedback sobre o aluno incluido em seu o projeto, o qual o aluno referido terá acesso.

![Captura de tela 2024-07-02 221550](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/43a7bd6a-910b-4528-8735-337b2fec8e96)


**Gestão de Atividades**: O Professor pode inserir uma atividade referente ao projeto e ver uma lista dos alunos que já entregaram a atividade.

**Relatório** : O Professor pode enviar um relatório, o qual a Coordenação terá acesso.

## Perfil do Coordenador:

![Captura de tela 2024-07-02 215948](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/4f75c282-97c7-4dbd-b67d-60168b7d7c4f)

**Análises e Extratos**: dashboard que permite ver e gerar um pdf contendo o número total de usuários, professores, alunos, coordenadores, atividades, projetos e entregas.

![Captura de tela 2024-07-02 220949](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/e1d6f0de-6ec0-46b8-8090-d04926cf943b)


**Gestão de Alunos**: listagem de alunos que permite adicionar novos estudantes, editar dados de estudantes já existentes, excluir e gerar um pdf.

![Captura de tela 2024-07-02 215542](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/bee56267-6294-4794-bf43-abe022d4b489)


**Gestão de Projetos**: listagem de projetos que permite adicionar novos projetos, editar dados de projetos já existentes, visualizar quais são os professores e alunos bolsistas e voluntários, excluir projeto e gerar um pdf.

![Captura de tela 2024-07-02 220444](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/c76ea755-d9cc-474a-8a1a-b6d522cbb1dd)


**Gestão de Professores**: listagem de professores que permite adicionar novos professores, editar dados de professor, excluir e gerar um pdf.

![Captura de tela 2024-07-02 220513](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/7ff627ae-6e3c-4c3f-bb53-f323a26cf5cb)


**Gestão de Coordenadores**: listagem de coordenadores, permite adicionar novos coordenadores, editar dados de coordenadores, excluir e gerar um pdf.

![Captura de tela 2024-07-02 220536](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/cd1ec7a3-6870-4c09-b430-e4eadc8e0f3a)


**Relatórios**: permite ao coordenador adicionar, editar ou excluir um relatório sobre um projeto, o qual será listado para todos os coordenadores terem acesso.

![Captura de tela 2024-07-02 220600](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/4b01ac9b-1435-4525-8dc4-8db57b1ed099)


## Perfil do Aluno:
**Entregar a atividade**: permite ao aluno entregar a atividade que foi cadastrada pelo professor de seu projeto. A entrega é então automaticamente listada para o Professor.

**Inserir feedback**: permite ao aluno inserir um feedback sobre o professor.

**Feedbacks Recebidos**: permite ao aluno ler os feedbacks que o professor enviou a ele.



![Captura de tela 2024-07-02 215235](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/7459463d-b81a-47ab-8bf4-b3bef6d32709)

![Captura de tela 2024-07-02 221649](https://github.com/D-O-S-T/GerenciamentoAcademico/assets/165727441/303fc4f5-7f24-4a19-b433-cd7dfa21912c)








## Como Utilizar
### 1. Clonar o Repositório
Clone este repositório para sua máquina local usando Git.

### 2. Configurar o Ambiente de Desenvolvimento
- Certifique-se de ter o Java [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) instalado em sua máquina.
- Utilize um IDE como [Eclipse](https://www.eclipse.org/downloads/packages/) ou [IntelliJ IDEA](https://www.jetbrains.com/idea/download) para o desenvolvimento (OBS: precisa estar configurado para criação de projetos web dinâmicos).
- Configure o [Apache Tomcat 9](https://tomcat.apache.org/download-90.cgi) em seu IDE para o desenvolvimento de Servlets e JSP.
- Instale o [MySQL Server 8.0.0+](https://mysql.com/downloads).
- Recomendamos usar o [MySQL Workbench 8](https://dev.mysql.com/downloads/workbench/) para visualizar as tabelas.

### 3. Executar a aplicação

1. **Criar uma Base de Dados**
   - Inicie o MySQL Server no computador, utilizando a senha `1234@sim`.
   - Crie um esquema (schema) no MySQL Workbench utilizando esse [script](./sql.txt).

2. **Iniciar o Servidor Tomcat**
   - Inicie o servidor Tomcat dentro do IDE (através do arquivo `index.jsp`).
   - Acesse a aplicação através do navegador utilizando a URL do servidor Tomcat: `http://localhost:8080/`.

## Funcionalidades

<details>

<summary style="text-weight: bold">Gerenciamento de Alunos</summary>

- Registrador de novos alunos.
- Visualizar e editar detalhes dos alunos.

</details>

<details>
<summary>Gestão de Cursos</summary>

- Adicionar novos cursos.
- Gerenciar detalhes dos cursos.
</details>

<details>
<summary>Solicitações de Bolsas</summary>

- Alunos podem solicitar bolsas de estudo através da interface web.
</details>

<details>
<summary>Interface Interativa</summary>

- Utilize JSP para criar páginas web dinâmicas.
- Servlets para lidar com requisições e respostas.
</details>

<details>
<summary>Persistência de Dados</summary>

- Os dados são salvos em uma base de dados MySQL.
- Permite adicionar, editar, excluir e atualizar registros conforme as permissões do usuário.
</details>


