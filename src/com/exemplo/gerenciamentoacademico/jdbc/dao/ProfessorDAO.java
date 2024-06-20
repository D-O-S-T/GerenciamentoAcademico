package com.exemplo.gerenciamentoacademico.jdbc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

public class ProfessorDAO {
	

    // Método para buscar um professor pelo ID
    public Professor getProfessor(int professorId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "SELECT * FROM professor WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, professorId);
            myRs = myStmt.executeQuery();

            if (myRs.next()) {
                int usuarioId = myRs.getInt("usuario_id");
                String areaAtuacao = myRs.getString("area_atuacao");
                String nome = myRs.getString("nome");
                String email = myRs.getString("email");
                String lattes = myRs.getString("lattes");

                return new Professor(professorId, usuarioId, areaAtuacao, nome, email, lattes);
            } else {
                throw new SQLException("Não foi possível encontrar o professor com ID: " + professorId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, myRs);
        }
    }

    // Método para listar todos os professores
    public List<Professor> getProfessores() {
        List<Professor> professores = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "SELECT * FROM professor";
            myStmt = myConn.prepareStatement(sql);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                int id = myRs.getInt("id");
                int usuarioId = myRs.getInt("usuario_id");
                String areaAtuacao = myRs.getString("area_atuacao");
                String nome = myRs.getString("nome");
                String email = myRs.getString("email");
                String lattes = myRs.getString("lattes");

                Professor inputProfessor = new Professor(id, usuarioId, areaAtuacao, nome, email, lattes);
                professores.add(inputProfessor);
            }

            return professores;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, myRs);
        }

        return null;
    }

    public void addProfessor(Professor professor) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();

            // Verificar se o usuarioId existe na tabela de usuarios
            if (!usuarioExists(professor.getUsuarioId(), myConn)) {
                throw new SQLException("O ID do usuário não existe: " + professor.getUsuarioId());
            }

            String sql = "INSERT INTO professor (usuario_id, area_atuacao, nome, email, lattes) VALUES (?, ?, ?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, professor.getUsuarioId());
            myStmt.setString(2, professor.getAreaAtuacao());
            myStmt.setString(3, professor.getNome());
            myStmt.setString(4, professor.getEmail());
            myStmt.setString(5, professor.getLattes());

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }



    // Método para verificar se um usuarioId existe na tabela de usuarios
    private boolean usuarioExists(int usuarioId, Connection myConn) throws SQLException {
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            String sql = "SELECT id FROM usuario WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, usuarioId);
            myRs = myStmt.executeQuery();

            return myRs.next();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(null, myStmt, myRs);
        }
    }

    // Método para deletar um professor pelo ID
    public void deletarProfessor(int professorId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "DELETE FROM professor WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, professorId);
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }

    // Método para atualizar um professor
    public void updateProfessor(Professor professor) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            
            // Verificar se o usuarioId existe na tabela de usuarios
            if (!usuarioExists(professor.getUsuarioId(), myConn)) {
                throw new SQLException("O ID do usuário não existe: " + professor.getUsuarioId());
            }
            
            String sql = "UPDATE professor SET usuario_id=?, area_atuacao=?, nome=?, email=?, lattes=? WHERE id=?";
            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, professor.getUsuarioId());
            myStmt.setString(2, professor.getAreaAtuacao());
            myStmt.setString(3, professor.getNome());
            myStmt.setString(4, professor.getEmail());
            myStmt.setString(5, professor.getLattes());
            myStmt.setInt(6, professor.getId());

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }
}
