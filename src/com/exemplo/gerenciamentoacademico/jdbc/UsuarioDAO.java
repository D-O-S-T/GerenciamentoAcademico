package com.exemplo.gerenciamentoacademico.jdbc;



import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Método para buscar um usuário pelo ID
    public Usuario getUsuario(int usuarioId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "SELECT * FROM usuario WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, usuarioId);
            myRs = myStmt.executeQuery();

            if (myRs.next()) {
                String login = myRs.getString("login");
                String email = myRs.getString("email");
                String senha = myRs.getString("senha");
                String tipoUsuario = myRs.getString("tipo_usuario");

                return new Usuario(usuarioId, login, email, senha, tipoUsuario);
            } else {
                throw new SQLException("Não foi possível encontrar o usuário com ID: " + usuarioId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
			databaseUtil.close(myConn, myStmt, myRs);
        }
    }

    // Método para listar todos os usuários
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "SELECT * FROM usuario";
            myStmt = myConn.prepareStatement(sql);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                int id = myRs.getInt("id");
                String login = myRs.getString("login");
                String email = myRs.getString("email");
                String senha = myRs.getString("senha");
                String tipo_usuario = myRs.getString("tipo_usuario");

                Usuario inputUsuario = new Usuario(id, login, email, senha, tipo_usuario);
                usuarios.add(inputUsuario);
            }

            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
			databaseUtil.close(myConn, myStmt, myRs);
        }

        return null;
    }

    // Método para adicionar um novo usuário
    public void addUsuario(Usuario usuario) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "INSERT INTO usuario (login, email, senha, tipo_usuario) VALUES (?, ?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, usuario.getLogin());
            myStmt.setString(2, usuario.getEmail());
            myStmt.setString(3, usuario.getSenha());
            myStmt.setString(4, usuario.gettipoUsuario());

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
			databaseUtil.close(myConn, myStmt, null);
        }
    }

    // Método para deletar um usuário pelo ID
    public void deletarUsuario(int usuarioId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "DELETE FROM usuario WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, usuarioId);
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
			databaseUtil.close(myConn, myStmt, null);
        }
    }

    // Método para atualizar um usuário
    public void updateUsuario(Usuario usuario) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = DatabaseUtil.getConexao();
            String sql = "UPDATE usuario SET login=?, email=?, senha=?, tipo_usuario=? WHERE id=?";
            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, usuario.getLogin());
            myStmt.setString(2, usuario.getEmail());
            myStmt.setString(3, usuario.getSenha());
            myStmt.setString(4, usuario.gettipoUsuario());
            myStmt.setInt(5, usuario.getId());

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil databaseUtil = new DatabaseUtil();
			databaseUtil.close(myConn, myStmt, null);
        }
    }
}
