<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidebar" id="sidebar">
      <ul class="sidebar-list">
          <li onclick="window.location.href='RelatorioAnalisesServlet?action=listar'" onclick="window.location.href='relatorios-analises-form.jsp'">Relatórios e Análises</li>
          <li onclick="window.location.href='ProjetoServlet?action=listar'" onclick="window.location.href='listar-projetos.jsp'">Acompanhamento de Projetos</li>
          <li onclick="window.location.href='AlunoServlet?action=listar'" onclick="window.location.href='listar-alunos.jsp'">Gestão de Alunos</li>
          <li onclick="window.location.href='ProjetoServlet?action=listar'" onclick="window.location.href='listar-projetos.jsp'">Gestão de Projetos</li>
          <li onclick="window.location.href='ProfessorServlet?action=listar'" onclick="window.location.href='index-professor.jsp'">Gestão de Professores</li>
          <li onclick="window.location.href='CoordenadorServlet?action=listar'" onclick="window.location.href='listar-coordenadores.jsp'">Gestão de Coordenadores</li>
          <li onclick="window.location.href='RelatorioCoordenadorServlet?action=listar'" onclick="window.location.href='listar-relatoriocoordenador.jsp'">Inserir Relatório</li>
          <li>Suporte</li>
          <li onclick="window.location.href='index.jsp'">Sair</li>
      </ul>
  </div>
  <div class="main-content" id="main-content">
      <button id="toggleButton">☰</button>
      <!-- Other content goes here -->
</div>
<script src="scripts/sidebar.js"></script>