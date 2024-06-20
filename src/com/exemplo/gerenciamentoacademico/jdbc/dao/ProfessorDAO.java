package com.exemplo.gerenciamentoacademico.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

public class ProfessorDAO {

	private Connection conn;

	public ProfessorDAO(Connection conn) {
		this.conn = conn;
	}

	// Método para buscar um Professor pelo ID
	public Professor buscarPorId(int id) throws SQLException {
		Professor professor = null;
		String sql = "SELECT * FROM professor WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					professor = new Professor(rs.getInt("id"), rs.getInt("usuario_id"), rs.getString("area_atuacao"),
							rs.getString("nome"), rs.getString("email"), rs.getString("lattes"));
				}
			}
		}
		return professor;
	}

	// Método para inserir um Professor no banco de dados
	public void inserir(Professor professor) throws SQLException {
		String sql = "INSERT INTO professor (usuario_id, area_atuacao, nome, email, lattes) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, professor.getUsuarioId());
			stmt.setString(2, professor.getAreaAtuacao());
			stmt.setString(3, professor.getNome());
			stmt.setString(4, professor.getEmail());
			stmt.setString(5, professor.getLattes());
			stmt.executeUpdate();
		}
	}

	// Método para listar todos os Professores
	public List<Professor> listarTodos() throws SQLException {
		List<Professor> professores = new ArrayList<>();
		String sql = "SELECT * FROM professor";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Professor professor = new Professor(rs.getInt("id"), rs.getInt("usuario_id"),
						rs.getString("area_atuacao"), rs.getString("nome"), rs.getString("email"),
						rs.getString("lattes"));
				professores.add(professor);
			}
		}
		return professores;
	}

	// Método para atualizar um Professor no banco de dados
	public void atualizar(Professor professor) throws SQLException {
		String sql = "UPDATE professor SET usuario_id = ?, area_atuacao = ?, nome = ?, email = ?, lattes = ? WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, professor.getUsuarioId());
			stmt.setString(2, professor.getAreaAtuacao());
			stmt.setString(3, professor.getNome());
			stmt.setString(4, professor.getEmail());
			stmt.setString(5, professor.getLattes());
			stmt.setInt(6, professor.getId());
			stmt.executeUpdate();
		}
	}

	// Método para excluir um Professor do banco de dados
	public void excluir(int id) throws SQLException {
		String sql = "DELETE FROM professor WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}
}
