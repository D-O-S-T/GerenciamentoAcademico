package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {

    public void adicionarProjeto(Projeto projeto) {
        String sql = "INSERT INTO projeto (titulo, conteudo, dataInicial, dataFinal, professor_id, alunoBolsista_id, alunoVoluntario_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projeto.getTitulo());
            stmt.setString(2, projeto.getConteudo());
            stmt.setDate(3, projeto.getDataInicial());
            stmt.setDate(4, projeto.getDataFinal());
            stmt.setInt(5, projeto.getProfessorId());
            stmt.setInt(6, projeto.getAlunoBolsistaId());
            stmt.setInt(7, projeto.getAlunoVoluntarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Projeto> getProjetosPorProfessor(int professorId) {
        String sql = "SELECT * FROM projeto WHERE professor_id = ?";
        List<Projeto> projetos = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Projeto projeto = new Projeto(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getDate("dataInicial").toLocalDate(),
                            rs.getDate("dataFinal").toLocalDate(),
                            rs.getInt("professor_id")
                    );
                    projetos.add(projeto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }
    
    public int getProfessorIdPorProjeto(int projetoId) throws SQLException {
        String sql = "SELECT professor_id FROM projeto WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, projetoId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("professor_id");
                } else {
                    throw new SQLException("Projeto não encontrado para o projetoId associado à atividade.");
                }
            }
        }
    }
    
    public Projeto getProjetoPorProfessorId(int professorId) {
        String sql = "SELECT * FROM projeto WHERE professor_id = ?";
        Projeto projeto = null;

        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professorId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    projeto = new Projeto(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("conteudo"),
                            rs.getDate("dataInicial").toLocalDate(),
                            rs.getDate("dataFinal").toLocalDate(),
                            rs.getInt("professor_id"),
                            rs.getInt("alunoBolsista_id"),
                            rs.getInt("alunoVoluntario_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projeto;
    }

    
    public List<Projeto> getTodosProjetos() {
        String sql = "SELECT a.*, p.nome AS professorNome, ab.nome AS alunoBolsistaNome, av.nome AS alunoVoluntarioNome " +
                     "FROM projeto a " +
                     "JOIN professor p ON a.professor_id = p.id " +
                     "JOIN aluno ab ON a.alunoBolsista_id = ab.id " +
                     "JOIN aluno av ON a.alunoVoluntario_id = av.id";
        List<Projeto> projetos = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Projeto projeto = new Projeto(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("conteudo"),
                        rs.getDate("dataInicial"),
                        rs.getDate("dataFinal"),
                        rs.getInt("professor_id"),
                        rs.getInt("alunoBolsista_id"),
                        rs.getInt("alunoVoluntario_id"),
                        rs.getString("professorNome"),         // Nome do professor
                        rs.getString("alunoBolsistaNome"),     // Nome do aluno bolsista
                        rs.getString("alunoVoluntarioNome")    // Nome do aluno voluntário
                );
                projetos.add(projeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }

    public void atualizarProjeto(Projeto projeto) {
        String sql = "UPDATE projeto SET titulo = ?, conteudo = ?, dataInicial = ?, dataFinal = ?, professor_id = ?, alunoBolsista_id = ?, alunoVoluntario_id = ? " +
                     "WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, projeto.getTitulo());
            stmt.setString(2, projeto.getConteudo());
            stmt.setDate(3, projeto.getDataInicial());
            stmt.setDate(4, projeto.getDataFinal());
            stmt.setInt(5, projeto.getProfessorId());
            stmt.setInt(6, projeto.getAlunoBolsistaId());
            stmt.setInt(7, projeto.getAlunoVoluntarioId());
            stmt.setInt(8, projeto.getId());

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
        String sql = "SELECT * FROM projeto WHERE id = ?";
        Projeto projeto = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    projeto = new Projeto(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("conteudo"),
                            rs.getDate("dataInicial"),
                            rs.getDate("dataFinal"),
                            rs.getInt("professor_id"),
                            rs.getInt("alunoBolsista_id"),
                            rs.getInt("alunoVoluntario_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projeto;
    }
    
    public List<Projeto> getTodosProjetosSemId() {
        String sql = "SELECT titulo, conteudo, dataInicial, dataFinal, professor_id, alunoBolsista_id, alunoVoluntario_id FROM projeto";
        List<Projeto> projetos = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Projeto projeto = new Projeto(
                        rs.getString("titulo"),
                        rs.getString("conteudo"),
                        rs.getDate("dataInicial"),
                        rs.getDate("dataFinal"),
                        rs.getInt("professor_id"),
                        rs.getInt("alunoBolsista_id"),
                        rs.getInt("alunoVoluntario_id")
                );
                projetos.add(projeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }
    
    
    public List<Integer> getAlunosIdsPorProfessorId(int professorId) {
        String sql = "SELECT alunoBolsista_id, alunoVoluntario_id " +
                     "FROM projeto " +
                     "WHERE professor_id = ?";
        List<Integer> alunoIds = new ArrayList<>();
        
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int bolsistaId = rs.getInt("alunoBolsista_id");
                    int voluntarioId = rs.getInt("alunoVoluntario_id");
                    alunoIds.add(bolsistaId);
                    alunoIds.add(voluntarioId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return alunoIds;
    }
}

