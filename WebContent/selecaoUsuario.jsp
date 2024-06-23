<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String tipoUsuario = request.getParameter("tipoUsuario");
    if (tipoUsuario.equals("professor")) {
        response.sendRedirect("professor-form.jsp");
    } else if (tipoUsuario.equals("coordenador")) {
        response.sendRedirect("coordenador-form.jsp");
    } else if (tipoUsuario.equals("aluno")) {
        response.sendRedirect("aluno-form.jsp");
    } else {
        out.println("Seleção inválida.");
    }
%>
