package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Projeto;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {

    public void adicionarProjeto(Projeto projeto) {
        String sql = "INSERT INTO projeto (titulo, dataInicial, dataFinal, professor_id, alunoBolsista_id, alunoVoluntario_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projeto.getTitulo());
            stmt.setDate(2, new java.sql.Date(projeto.getDataInicial().getTime()));
            stmt.setDate(3, new java.sql.Date(projeto.getDataFinal().getTime()));
            stmt.setInt(4, projeto.getProfessor().getId());
            stmt.setInt(5, projeto.getAlunoBolsista().getId());
            stmt.setInt(6, projeto.getAlunoVoluntario().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Projeto> getTodosProjetos() {
        String sql = "SELECT p.id, p.titulo, p.dataInicial, p.dataFinal, p.professor_id, pr.nome as nome_professor, " +
                     "p.alunoBolsista_id, ab.nome as nome_aluno_bolsista, p.alunoVoluntario_id, av.nome as nome_aluno_voluntario " +
                     "FROM projeto p " +
                     "JOIN professor pr ON p.professor_id = pr.id " +
                     "JOIN aluno ab ON p.alunoBolsista_id = ab.id " +
                     "JOIN aluno av ON p.alunoVoluntario_id = av.id";
        List<Projeto> projetos = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                java.util.Date dataInicial = rs.getDate("dataInicial");
                java.util.Date dataFinal = rs.getDate("dataFinal");
                int professorId = rs.getInt("professor_id");
                String nomeProfessor = rs.getString("nome_professor");
                int alunoBolsistaId = rs.getInt("alunoBolsista_id");
                String nomeAlunoBolsista = rs.getString("nome_aluno_bolsista");
                int alunoVoluntarioId = rs.getInt("alunoVoluntario_id");
                String nomeAlunoVoluntario = rs.getString("nome_aluno_voluntario");

                Professor professor = new Professor(professorId, nomeProfessor);
                Aluno alunoBolsista = new Aluno(alunoBolsistaId, nomeAlunoBolsista);
                Aluno alunoVoluntario = new Aluno(alunoVoluntarioId, nomeAlunoVoluntario);

                Projeto projeto = new Projeto(id, titulo, dataInicial, dataFinal, professor, alunoBolsista, alunoVoluntario);
                projetos.add(projeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }

    public void atualizarProjeto(Projeto projeto) {
        String sql = "UPDATE projeto SET titulo = ?, dataInicial = ?, dataFinal = ?, " +
                     "professor_id = ?, alunoBolsista_id = ?, alunoVoluntario_id = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, projeto.getTitulo());
            stmt.setDate(2, new java.sql.Date(projeto.getDataInicial().getTime()));
            stmt.setDate(3, new java.sql.Date(projeto.getDataFinal().getTime()));
            stmt.setInt(4, projeto.getProfessor().getId());
            stmt.setInt(5, projeto.getAlunoBolsista().getId());
            stmt.setInt(6, projeto.getAlunoVoluntario().getId());
            stmt.setInt(7, projeto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirProjeto(int id) {
        String sql = "DELETE FROM projeto WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Projeto getProjetoPorId(int id) {
        String sql = "SELECT p.id, p.titulo, p.dataInicial, p.dataFinal, p.professor_id, pr.nome as nome_professor, " +
                     "p.alunoBolsista_id, ab.nome as nome_aluno_bolsista, p.alunoVoluntario_id, av.nome as nome_aluno_voluntario " +
                     "FROM projeto p " +
                     "JOIN professor pr ON p.professor_id = pr.id " +
                     "JOIN aluno ab ON p.alunoBolsista_id = ab.id " +
                     "JOIN aluno av ON p.alunoVoluntario_id = av.id " +
                     "WHERE p.id = ?";
        Projeto projeto = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String titulo = rs.getString("titulo");
                    java.util.Date dataInicial = rs.getDate("dataInicial");
                    java.util.Date dataFinal = rs.getDate("dataFinal");
                    int professorId = rs.getInt("professor_id");
                    String nomeProfessor = rs.getString("nome_professor");
                    int alunoBolsistaId = rs.getInt("alunoBolsista_id");
                    String nomeAlunoBolsista = rs.getString("nome_aluno_bolsista");
                    int alunoVoluntarioId = rs.getInt("alunoVoluntario_id");
                    String nomeAlunoVoluntario = rs.getString("nome_aluno_voluntario");

                    Professor professor = new Professor(professorId, nomeProfessor);
                    Aluno alunoBolsista = new Aluno(alunoBolsistaId, nomeAlunoBolsista);
                    Aluno alunoVoluntario = new Aluno(alunoVoluntarioId, nomeAlunoVoluntario);

                    projeto = new Projeto(id, titulo, dataInicial, dataFinal, professor, alunoBolsista, alunoVoluntario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projeto;
    }
}

