package com.exemplo.gerenciamentoacademico.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	                String nome = myRs.getString("nome");
	                String email = myRs.getString("email");
	                String lattes = myRs.getString("lattes");
	                String login = myRs.getString("login");
	                String senha = myRs.getString("senha");

	                return new Professor(professorId, nome, email, lattes, login, senha);
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
	                String nome = myRs.getString("nome");
	                String email = myRs.getString("email");
	                String lattes = myRs.getString("lattes");
	                String login = myRs.getString("login");
	                String senha = myRs.getString("senha");

	                Professor professor = new Professor(id, nome, email, lattes, login, senha);
	                professores.add(professor);
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

	    // Método para adicionar um novo professor
//	    public void insertProfessor(Professor professor) throws SQLException {
//	    	String sql = "INSERT INTO PROFESSOR VALUES (?,?,?,?,?)";
//	        try (Connection connection = DatabaseUtil.getConexao();
//	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//	            preparedStatement.setString(1, professor.getNome());
//	            preparedStatement.setString(2, professor.getEmail());
//	            preparedStatement.setString(3, professor.getLattes());
//	            preparedStatement.setString(4, professor.getLogin());
//	            preparedStatement.setString(5, professor.getSenha());
//	            preparedStatement.executeUpdate();
//	        } catch (SQLException e) {
//	            printSQLException(e);
//	        }
//	    }
	    
	    public void insertProfessor(Professor professor) throws SQLException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        String sql = "INSERT INTO PROFESSOR VALUES (?,?,?,?,?)";
	        
	        try {
	            connection = DatabaseUtil.getConexao();
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, professor.getNome());
	            preparedStatement.setString(2, professor.getEmail());
	            preparedStatement.setString(3, professor.getLattes());
	            preparedStatement.setString(4, professor.getLogin());
	            preparedStatement.setString(5, professor.getSenha());
	            
	            preparedStatement.executeUpdate();
	        } finally {
	            close(connection, preparedStatement);
	        }
	    }

	    private void close(Connection myConn, PreparedStatement myStmt) {
	        try {
	            if (myStmt != null) {
	                myStmt.close();
	            }
	            if (myConn != null) {
	                myConn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
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
	            String sql = "UPDATE professor SET nome=?, email=?, lattes=?, login=?, senha=? WHERE id=?";
	            myStmt = myConn.prepareStatement(sql);

	            myStmt.setString(1, professor.getNome());
	            myStmt.setString(2, professor.getEmail());
	            myStmt.setString(3, professor.getLattes());
	            myStmt.setString(4, professor.getLogin());
	            myStmt.setString(5, professor.getSenha());
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
	    
	    
	    public void printSQLException(SQLException ex) {
	        for (Throwable e : ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}


