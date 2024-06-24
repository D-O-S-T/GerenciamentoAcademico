package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public void adicionarProfessor(Professor professor) {
        String sql = "INSERT INTO professor (nome, email, lattes, login, senha, areaAtuacao) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getLattes());
            stmt.setString(4, professor.getLogin());
            stmt.setString(5, professor.getSenha());
            stmt.setString(6, professor.getAreaAtuacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Professor> getTodosProfessores() {
        String sql = "SELECT * FROM professor";
        List<Professor> professores = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor professor = new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("lattes"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("areaAtuacao")
                );
                professores.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professores;
    }

    public List<Professor> getTodosProfessoresSemId() {
        String sql = "SELECT nome, email, lattes, login, senha, areaAtuacao FROM professor";
        List<Professor> professores = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor professor = new Professor(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("lattes"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("areaAtuacao")
                );
                professores.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professores;
    }

    public void atualizarProfessor(Professor professor) {
        String sql = "UPDATE professor SET nome = ?, email = ?, lattes = ?, login = ?, senha = ?, areaAtuacao = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getLattes());
            stmt.setString(4, professor.getLogin());
            stmt.setString(5, professor.getSenha());
            stmt.setString(6, professor.getAreaAtuacao());
            stmt.setInt(7, professor.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirProfessor(int id) {
        String sql = "DELETE FROM professor WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Professor getProfessorPorId(int id) {
        String sql = "SELECT * FROM professor WHERE id = ?";
        Professor professor = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    professor = new Professor(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("lattes"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getString("areaAtuacao")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professor;
    }
    
    public List<Professor> getTodosProfessoresSemIdSenhaLogin() {
        String sql = "SELECT nome, email, lattes, areaAtuacao FROM professor";
        List<Professor> professores = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor professor = new Professor(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("lattes"),
                        rs.getString("areaAtuacao")
                );
                professores.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professores;
    }
    
    public String getNomeProfessorPorId(int professorId) {
        String nomeProfessor = null;
        String sql = "SELECT nome FROM professor WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professorId);
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
