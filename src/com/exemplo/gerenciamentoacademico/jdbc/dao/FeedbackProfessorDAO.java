package com.exemplo.gerenciamentoacademico.jdbc.dao;



import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.FeedbackProfessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackProfessorDAO {

    public void adicionarFeedback(FeedbackProfessor feedback) {
        String sql = "INSERT INTO feedbackprofessor (titulo, feedback, professor_id, aluno_id) " +
                     "VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getTitulo());
            stmt.setString(2, feedback.getFeedback());
            stmt.setInt(3, feedback.getProfessorId());
            stmt.setInt(4, feedback.getAlunoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<FeedbackProfessor> getFeedbacksPorProfessor(int professorId) {
        String sql = "SELECT * FROM feedbackprofessor WHERE professor_id = ?";
        List<FeedbackProfessor> feedbacks = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FeedbackProfessor feedback = new FeedbackProfessor(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("feedback"),
                            rs.getInt("professor_id"),
                            rs.getInt("aluno_id")
                    );
                    feedbacks.add(feedback);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Número de feedbacks encontrados no DAO: " + feedbacks.size()); // Adicione este log
        return feedbacks;
    }

    public void atualizarFeedback(FeedbackProfessor feedback) {
        String sql = "UPDATE feedbackprofessor SET titulo = ?, feedback = ?, professor_id = ?, aluno_id = ? " +
                     "WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, feedback.getTitulo());
            stmt.setString(2, feedback.getFeedback());
            stmt.setInt(3, feedback.getProfessorId());
            stmt.setInt(4, feedback.getAlunoId());
            stmt.setInt(5, feedback.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirFeedback(int id) {
        String sql = "DELETE FROM feedbackprofessor WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FeedbackProfessor getFeedbackPorId(int id) {
        String sql = "SELECT * FROM feedbackprofessor WHERE id = ?";
        FeedbackProfessor feedback = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    feedback = new FeedbackProfessor(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("feedback"),
                            rs.getInt("professor_id"),
                            rs.getInt("aluno_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }
    
    
    public String getNomeAlunoPorFeedbackId(int feedbackId) {
        String nomeAluno = null;
        String query = "SELECT a.nome FROM aluno a JOIN feedbackprofessor f ON a.id = f.aluno_id WHERE f.id = ?";
        try (
            Connection conn = DatabaseUtil.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setInt(1, feedbackId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nomeAluno = rs.getString("nome");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomeAluno;
    }
}
