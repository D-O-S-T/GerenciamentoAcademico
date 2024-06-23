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

	    RelatorioAnalisesDAO dao = new RelatorioAnalisesDAO();
	    RelatorioAnalises relatorio = dao.obterRelatorioAnalises();

	    request.setAttribute("relatorio", relatorio);

	    // Verificação de log
	    System.out.println("Relatorio totalUsuarios: " + relatorio.getTotalUsuarios());
	    System.out.println("Relatorio totalProfessores: " + relatorio.getTotalProfessores());
	    System.out.println("Relatorio totalAlunos: " + relatorio.getTotalAlunos());
	    System.out.println("Relatorio totalCoordenadores: " + relatorio.getTotalCoordenadores());
	    System.out.println("Relatorio totalAtividades: " + relatorio.getTotalAtividades());
	    System.out.println("Relatorio totalProjetos: " + relatorio.getTotalProjetos());
	    System.out.println("Relatorio totalEntregas: " + relatorio.getTotalEntregas());

	    request.getRequestDispatcher("/relatorios-analises-form.jsp").forward(request, response);
	}

}



