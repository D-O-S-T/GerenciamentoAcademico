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

    public void adicionarFeedbackAluno(FeedbackAluno feedback) {
        String sql = "INSERT INTO feedbackaluno (titulo, feedback, aluno_id, professor_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getTitulo());
            stmt.setString(2, feedback.getFeedback());
            stmt.setInt(3, feedback.getAlunoId());
            stmt.setInt(4, feedback.getProfessorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FeedbackAluno> getTodosFeedbacksAlunos() {
        String sql = "SELECT fa.id, fa.titulo, fa.feedback, fa.aluno_id, fa.professor_id, " +
                     "a.nome AS alunoNome, p.nome AS professorNome " +
                     "FROM feedbackaluno fa " +
                     "JOIN aluno a ON fa.aluno_id = a.id " +
                     "JOIN professor p ON fa.professor_id = p.id";
        List<FeedbackAluno> listaFeedbacks = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FeedbackAluno feedback = new FeedbackAluno(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("feedback"),
                        rs.getInt("aluno_id"),
                        rs.getInt("professor_id"),
                        rs.getString("alunoNome"),
                        rs.getString("professorNome")
                );
                listaFeedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFeedbacks;
    }

    public FeedbackAluno getFeedbackAlunoPorId(int id) {
        String sql = "SELECT fa.id, fa.titulo, fa.feedback, fa.aluno_id, fa.professor_id, " +
                     "a.nome AS alunoNome, p.nome AS professorNome " +
                     "FROM feedbackaluno fa " +
                     "JOIN aluno a ON fa.aluno_id = a.id " +
                     "JOIN professor p ON fa.professor_id = p.id " +
                     "WHERE fa.id = ?";
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
                            rs.getInt("professor_id"),
                            rs.getString("alunoNome"),
                            rs.getString("professorNome")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    public void atualizarFeedbackAluno(FeedbackAluno feedback) {
        String sql = "UPDATE feedbackaluno SET titulo = ?, feedback = ?, aluno_id = ?, professor_id = ? WHERE id = ?";
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

    public void excluirFeedbackAluno(int id) {
        String sql = "DELETE FROM feedbackaluno WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
