package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.FeedbackAluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackAlunoDAO {

	public void adicionarFeedback(FeedbackAluno feedback) {
        String sql = "INSERT INTO feedbackaluno (titulo, feedback, aluno_id, professor_id) " +
                     "VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getTitulo());
            stmt.setString(2, feedback.getFeedback());
            stmt.setInt(3, feedback.getAlunoId());
            stmt.setInt(4, feedback.getProfessorId());
            System.out.println("AlunoId na DAO antes de adicionar: " + feedback.getAlunoId()); // Log adicional
            stmt.executeUpdate();
            System.out.println("Feedback adicionado com alunoId: " + feedback.getAlunoId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<FeedbackAluno> getFeedbacksPorAluno(int alunoId) {
        String sql = "SELECT * FROM feedbackaluno WHERE aluno_id = ?";
        List<FeedbackAluno> feedbacks = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FeedbackAluno feedback = new FeedbackAluno(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("feedback"),
                            rs.getInt("aluno_id"),
                            rs.getInt("professor_id")
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

    public void atualizarFeedback(FeedbackAluno feedback) {
        String sql = "UPDATE feedbackaluno SET titulo = ?, feedback = ?, aluno_id = ?, professor_id = ? " +
                     "WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getTitulo());
            stmt.setString(2, feedback.getFeedback());
            stmt.setInt(3, feedback.getAlunoId());
            stmt.setInt(4, feedback.getProfessorId());
            stmt.setInt(5, feedback.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirFeedback(int id) {
        String sql = "DELETE FROM feedbackaluno WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FeedbackAluno getFeedbackPorId(int id) {
        String sql = "SELECT * FROM feedbackaluno WHERE id = ?";
        FeedbackAluno feedback = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    feedback = new FeedbackAluno(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("feedback"),
                            rs.getInt("aluno_id"),
                            rs.getInt("professor_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    public String getNomeProfessorPorFeedbackId(int feedbackId) {
        String nomeProfessor = null;
        String query = "SELECT p.nome FROM professor p JOIN feedbackaluno f ON p.id = f.professor_id WHERE f.id = ?";
        try (
            Connection conn = DatabaseUtil.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setInt(1, feedbackId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nomeProfessor = rs.getString("nome");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomeProfessor;
    }
    
    
    

   
}


