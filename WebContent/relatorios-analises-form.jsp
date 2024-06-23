<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="relatorioAnalises" scope="request" class="com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises" />

<html>
<head>
    <title>Relatório de Análises</title>
</head>
<body>
    <h1>Relatório de Análises</h1>
    <p>Total de Usuários: ${relatorioAnalises.totalUsuarios}</p>
    <p>Total de Professores: ${relatorioAnalises.totalProfessores}</p>
    <p>Total de Alunos: ${relatorioAnalises.totalAlunos}</p>
    <p>Total de Coordenadores: ${relatorioAnalises.totalCoordenadores}</p>
    <p>Total de Atividades: ${relatorioAnalises.totalAtividades}</p>
    <p>Total de Projetos: ${relatorioAnalises.totalProjetos}</p>
    <p>Total de Entregas: ${relatorioAnalises.totalEntregas}</p>
</body>
</html>
