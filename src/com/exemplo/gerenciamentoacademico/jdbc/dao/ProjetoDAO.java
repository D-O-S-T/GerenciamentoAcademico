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

    // Método para buscar um projeto pelo ID
    public Projeto getProjeto(int projetoId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        Projeto projeto = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "SELECT * FROM projeto WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, projetoId);
            myRs = myStmt.executeQuery();

            if (myRs.next()) {
                String titulo = myRs.getString("titulo");
                java.sql.Date dataInicial = myRs.getDate("dataInicial");
                java.sql.Date dataFinal = myRs.getDate("dataFinal");
                int qtdAulas = myRs.getInt("qtdAulas");

                projeto = new Projeto(projetoId, titulo, dataInicial, dataFinal, qtdAulas);
            } else {
                throw new SQLException("Não foi possível encontrar o projeto com ID: " + projetoId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, myRs);
        }

        return projeto;
    }

    // Método para listar todos os projetos
    public List<Projeto> getProjetos() {
        List<Projeto> projetos = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "SELECT * FROM projeto";
            myStmt = myConn.prepareStatement(sql);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                int id = myRs.getInt("id");
                String titulo = myRs.getString("titulo");
                java.sql.Date dataInicial = myRs.getDate("dataInicial");
                java.sql.Date dataFinal = myRs.getDate("dataFinal");
                int qtdAulas = myRs.getInt("qtdAulas");

                Projeto projeto = new Projeto(id, titulo, dataInicial, dataFinal, qtdAulas);
                projetos.add(projeto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, myRs);
        }

        return projetos;
    }

    // Método para adicionar um novo projeto
    public void addProjeto(Projeto projeto) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "INSERT INTO projeto (id, titulo, dataInicial, dataFinal, qtdAulas) VALUES (?, ?, ?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, projeto.getId());
            myStmt.setString(2, projeto.getTitulo());
            myStmt.setDate(3, new java.sql.Date(projeto.getDataInicial().getTime()));
            myStmt.setDate(4, new java.sql.Date(projeto.getDataFinal().getTime()));
            myStmt.setInt(5, projeto.getQtdAulas());

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }

    // Método para deletar um projeto pelo ID
    public void deletarProjeto(int projetoId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "DELETE FROM projeto WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, projetoId);
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }

    // Método para atualizar um projeto
    public void updateProjeto(Projeto projeto) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "UPDATE projeto SET titulo=?, dataInicial=?, dataFinal=?, qtdAulas=? WHERE id=?";
            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, projeto.getTitulo());
            myStmt.setDate(2, new java.sql.Date(projeto.getDataInicial().getTime()));
            myStmt.setDate(3, new java.sql.Date(projeto.getDataFinal().getTime()));
            myStmt.setInt(4, projeto.getQtdAulas());
            myStmt.setInt(5, projeto.getId());

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
            databaseUtil.close(myConn, myStmt, null);
        }
    }
}
