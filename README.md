# SGA-IC

![Banner](https://i.imgur.com/xgt1z6m.png)

## Descrição
Este projeto é um Sistema de Gestão Acadêmica voltado para projetos de Iniciação Científica, utilizando Servlets, JSP e Java para funcionalidades baseadas na web. 

O sistema facilita tarefas comuns de gerenciamento em ambientes acadêmicos, como registro de alunos, gestão de cursos e solicitações de bolsas.

## Funcionalidades
1. **Registro de Alunos**: Permite aos coordenadores cadastrar alunos com informações básicas como nome, CPF, endereço e detalhes de contato.
2. **Gestão de Cursos**: Permite aos coordenadores e professores criar e gerenciar cursos, incluindo detalhes como nome e duração.
3. **Solicitações de Bolsas**: Os alunos podem solicitar bolsas de estudo por meio do sistema.

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

## Licença
Este projeto é de código aberto e está disponível sob a Licença MIT. Consulte o arquivo [LICENSE](https://github.com/D-O-S-T/GerenciamentoAcademico/blob/fase3/LICENSE.txt) para mais detalhes.
