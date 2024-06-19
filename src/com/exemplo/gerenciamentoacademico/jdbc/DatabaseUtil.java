package com.exemplo.gerenciamentoacademico.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    private static final String url = "jdbc:mysql://localhost:3306/gerenciamento_academico?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "Aluna";

    private static Connection conn;

    public static Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
            }
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao carregar o driver JDBC");
            e.printStackTrace();
            return null;
        }
    }

    // Método para fechar recursos JDBC
    private static void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    public Usuario getUsuario(int usuarioId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = getConexao();
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
            close(myConn, myStmt, myRs);
        }
    }


    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = getConexao();
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
            close(myConn, myStmt, myRs);
        }

        return null;
    }

    public void addUsuario(Usuario usuario) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = getConexao();
            String sql = "INSERT INTO usuario (login, email, senha, tipo_usuario) VALUES (?, ?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            // Define os parâmetros do PreparedStatement
            myStmt.setString(1, usuario.getLogin());
            myStmt.setString(2, usuario.getEmail());
            myStmt.setString(3, usuario.getSenha());
            myStmt.setString(4, usuario.gettipoUsuario());

            // Executa a inserção
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(myConn, myStmt, null);
        }
    }

    public void deletarUsuario(int usuarioId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = getConexao();
            String sql = "DELETE FROM usuario WHERE id = ?";
            myStmt = myConn.prepareStatement(sql);

            // Define o parâmetro do PreparedStatement
            myStmt.setInt(1, usuarioId);

            // Executa a exclusão
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(myConn, myStmt, null);
        }
    }
    
    public void updateUsuario(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConexao();
            String sql = "UPDATE usuario SET login=?, email=?, senha=?, tipo_usuario=? WHERE id=?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.gettipoUsuario());
            stmt.setInt(5, usuario.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, null);
        }
    }
    

    public static void main(String[] args) {
        // Testar a conexão no método main
        Connection conexao = DatabaseUtil.getConexao();

        if (conexao != null) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
            try {
                conexao.close(); // Fechar a conexão após o teste
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Falha ao conectar com o banco de dados.");
        }
    }

    
}
