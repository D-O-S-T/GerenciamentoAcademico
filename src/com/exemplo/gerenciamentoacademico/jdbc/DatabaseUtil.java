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
    private static final String password = "senha1234@sim";

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
    public void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {
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
