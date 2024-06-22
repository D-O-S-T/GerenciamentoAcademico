package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.RelatorioAnalisesDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises;

@WebServlet("/RelatorioAnalisesServlet")
public class RelatorioAnalisesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Estabelece conexão com o banco de dados usando o DatabaseUtil
        Connection conn = DatabaseUtil.getConexao();

        // Cria o DAO para obter os dados do relatório
        RelatorioAnalisesDAO relatorioDAO = new RelatorioAnalisesDAO(conn);

        try {
            // Gera o relatório
            RelatorioAnalises relatorio = relatorioDAO.gerarRelatorio();

            // Define atributos para enviar para a página JSP
            request.setAttribute("relatorio", relatorio);

            // Encaminha para a página JSP de relatório
            request.getRequestDispatcher("/relatorios-analises-form.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

