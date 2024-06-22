package com.exemplo.gerenciamentoacademico.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises;

public class RelatorioAnalisesDAO {

    private Connection conn;

    public RelatorioAnalisesDAO(Connection conn) {
        this.conn = conn;
    }

    public RelatorioAnalises gerarRelatorio() throws SQLException {
        RelatorioAnalises relatorio = new RelatorioAnalises();

        relatorio.setTotalUsuarios(contarUsuarios());
        relatorio.setTotalProfessores(contarProfessores());
        relatorio.setTotalCoordenadores(contarCoordenadores());
        relatorio.setTotalAlunos(contarAlunos());
        relatorio.setTotalProjetos(contarProjetos());
        relatorio.setTotalVoluntarios(contarVoluntarios());
        relatorio.setTotalBolsistas(contarBolsistas());
        relatorio.setTotalAtividades(contarAtividades());
        relatorio.setTotalEntregas(contarEntregas());

        return relatorio;
    }

    private int contarUsuarios() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM (SELECT id FROM professor UNION ALL SELECT id FROM coordenador UNION ALL SELECT id FROM aluno) AS total_usuarios";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }

    private int contarProfessores() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM professor";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }

    private int contarCoordenadores() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM coordenador";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }

    private int contarAlunos() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM aluno";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }

    private int contarProjetos() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM projeto";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }

    private int contarVoluntarios() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM aluno WHERE alunoBolsista_id IS NULL AND alunoVoluntario_id IS NOT NULL";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }

    private int contarBolsistas() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM aluno WHERE alunoBolsista_id IS NOT NULL";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }

    private int contarAtividades() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM atividade";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }

    private int contarEntregas() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) AS total FROM entrega";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                total = rs.getInt("total");
            }
        }
        return total;
    }
}


