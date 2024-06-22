package com.exemplo.gerenciamentoacademico.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises;

public class RelatorioAnalisesDAO {

    // Método para obter o relatório de análises
    public RelatorioAnalises obterRelatorioAnalises() {
        RelatorioAnalises relatorio = new RelatorioAnalises();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseUtil.getConexao();

            // Contar total de usuários (professores, alunos e coordenadores)
            String queryTotalUsuarios = "SELECT COUNT(*) AS total FROM "
                    + "(SELECT id FROM professor UNION ALL SELECT id FROM aluno UNION ALL SELECT id FROM coordenador) AS totalUsuarios";
            stmt = conn.prepareStatement(queryTotalUsuarios);
            rs = stmt.executeQuery();
            if (rs.next()) {
                relatorio.setTotalUsuarios(rs.getInt("total"));
            }

            // Contar total de professores
            String queryTotalProfessores = "SELECT COUNT(*) AS total FROM professor";
            stmt = conn.prepareStatement(queryTotalProfessores);
            rs = stmt.executeQuery();
            if (rs.next()) {
                relatorio.setTotalProfessores(rs.getInt("total"));
            }

            // Contar total de alunos
            String queryTotalAlunos = "SELECT COUNT(*) AS total FROM aluno";
            stmt = conn.prepareStatement(queryTotalAlunos);
            rs = stmt.executeQuery();
            if (rs.next()) {
                relatorio.setTotalAlunos(rs.getInt("total"));
            }

            // Contar total de coordenadores
            String queryTotalCoordenadores = "SELECT COUNT(*) AS total FROM coordenador";
            stmt = conn.prepareStatement(queryTotalCoordenadores);
            rs = stmt.executeQuery();
            if (rs.next()) {
                relatorio.setTotalCoordenadores(rs.getInt("total"));
            }

            // Contar total de atividades
            String queryTotalAtividades = "SELECT COUNT(*) AS total FROM atividade";
            stmt = conn.prepareStatement(queryTotalAtividades);
            rs = stmt.executeQuery();
            if (rs.next()) {
                relatorio.setTotalAtividades(rs.getInt("total"));
            }

            // Contar total de projetos
            String queryTotalProjetos = "SELECT COUNT(*) AS total FROM projeto";
            stmt = conn.prepareStatement(queryTotalProjetos);
            rs = stmt.executeQuery();
            if (rs.next()) {
                relatorio.setTotalProjetos(rs.getInt("total"));
            }

            // Contar total de entregas
            String queryTotalEntregas = "SELECT COUNT(*) AS total FROM entrega";
            stmt = conn.prepareStatement(queryTotalEntregas);
            rs = stmt.executeQuery();
            if (rs.next()) {
                relatorio.setTotalEntregas(rs.getInt("total"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar SQL: " + e.getMessage());
        }

        return relatorio;
    }
}



