package com.exemplo.gerenciamentoacademico.jdbc;

import com.exemplo.gerenciamentoacademico.jdbc.dao.RelatorioAnalisesDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RelatorioAnalisesServlet")
public class RelatorioAnalisesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private RelatorioAnalisesDAO relatorioAnalisesDAO;

    public void init() {
        relatorioAnalisesDAO = new RelatorioAnalisesDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "visualizar";
        }

        switch (action) {
            case "visualizar":
                visualizarRelatorio(request, response);
                break;
            default:
                visualizarRelatorio(request, response);
        }
    }

    private void visualizarRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RelatorioAnalises relatorioAnalises = relatorioAnalisesDAO.getRelatorioAnalises();
            request.setAttribute("relatorioAnalises", relatorioAnalises);
            request.getRequestDispatcher("relatorios-analises-form.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro ao obter o relatório de análises", e);
        }
    }
}




