package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IndexDAO {

    // Método para validar o login de professor
    public boolean validarProfessor(String login, String senha) {
        String query = "SELECT * FROM professor WHERE login = ? AND senha = ?";
        try (
            Connection conn = DatabaseUtil.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se encontrou algum registro
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para validar o login de aluno
    public boolean validarAluno(String login, String senha) {
        String query = "SELECT * FROM aluno WHERE login = ? AND senha = ?";
        try (
            Connection conn = DatabaseUtil.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se encontrou algum registro
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para validar o login de coordenador
    public boolean validarCoordenador(String login, String senha) {
        String query = "SELECT * FROM coordenador WHERE login = ? AND senha = ?";
        try (
            Connection conn = DatabaseUtil.getConexao();
            PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se encontrou algum registro
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
