package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.RelatorioAnalisesDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises;

@WebServlet("/relatorio")
public class RelatorioAnalisesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Instanciar o DAO para obter o relatório de análises
        RelatorioAnalisesDAO dao = new RelatorioAnalisesDAO();
        RelatorioAnalises relatorio = dao.obterRelatorioAnalises();

        // Setar o objeto relatório como atributo na requisição
        request.setAttribute("relatorio", relatorio);

        // Encaminhar para a página JSP que irá exibir o relatório
        request.getRequestDispatcher("/relatorio.jsp").forward(request, response);
    }
}


