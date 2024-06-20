package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // Método para buscar um aluno pelo ID
    public Aluno getAluno(int alunoId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "SELECT * FROM aluno WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, alunoId);
            myRs = myStmt.executeQuery();

            if (myRs.next()) {
                int usuarioId = myRs.getInt("usuario_id");
                String matricula = myRs.getString("matricula");
                String curso = myRs.getString("curso");
                String nome = myRs.getString("nome");
                String email = myRs.getString("email");
                String lattes = myRs.getString("lattes");

                return new Aluno(alunoId, usuarioId, matricula, curso, nome, email, lattes);
            } else {
                throw new SQLException("Não foi possível encontrar o aluno com ID: " + alunoId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, myRs);
        }
    }

    // Método para listar todos os alunos
    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "SELECT * FROM aluno";
            myStmt = myConn.prepareStatement(sql);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                int id = myRs.getInt("id");
                int usuarioId = myRs.getInt("usuario_id");
                String matricula = myRs.getString("matricula");
                String curso = myRs.getString("curso");
                String nome = myRs.getString("nome");
                String email = myRs.getString("email");
                String lattes = myRs.getString("lattes");

                Aluno inputAluno = new Aluno(id, usuarioId, matricula, curso, nome, email, lattes);
                alunos.add(inputAluno);
            }

            return alunos;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, myRs);
        }

        return null;
    }

    // Método para adicionar um novo aluno
    public void addAluno(Aluno aluno) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "INSERT INTO aluno (usuario_id, matricula, curso, nome, email, lattes) VALUES (?, ?, ?, ?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, aluno.getUsuarioId());
            myStmt.setString(2, aluno.getMatricula());
            myStmt.setString(3, aluno.getCurso());
            myStmt.setString(4, aluno.getNome());
            myStmt.setString(5, aluno.getEmail());
            myStmt.setString(6, aluno.getLattes());

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }

    // Método para deletar um aluno pelo ID
    public void deletarAluno(int alunoId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "DELETE FROM aluno WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, alunoId);
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }

    // Método para atualizar um aluno
    public void updateAluno(Aluno aluno) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "UPDATE aluno SET usuario_id=?, matricula=?, curso=?, nome=?, email=?, lattes=? WHERE id=?";
            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, aluno.getUsuarioId());
            myStmt.setString(2, aluno.getMatricula());
            myStmt.setString(3, aluno.getCurso());
            myStmt.setString(4, aluno.getNome());
            myStmt.setString(5, aluno.getEmail());
            myStmt.setString(6, aluno.getLattes());
            myStmt.setInt(7, aluno.getId());

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }
}

