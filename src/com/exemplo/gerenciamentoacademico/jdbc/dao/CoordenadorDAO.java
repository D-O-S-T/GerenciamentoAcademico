package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.model.Coordenador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoordenadorDAO {
    private Connection connection;

    public CoordenadorDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Coordenador coordenador) throws SQLException {
        String sql = "INSERT INTO coordenador (nome, email, login, senha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, coordenador.getNome());
            stmt.setString(2, coordenador.getEmail());
            stmt.setString(3, coordenador.getLogin());
            stmt.setString(4, coordenador.getSenha());
            stmt.executeUpdate();
        }
    }

    public Coordenador obterPorId(int id) throws SQLException {
        String sql = "SELECT * FROM coordenador WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Coordenador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("login"),
                        rs.getString("senha")
                );
            }
        }
        return null;
    }

    public List<Coordenador> obterTodos() throws SQLException {
        List<Coordenador> coordenadores = new ArrayList<>();
        String sql = "SELECT * FROM coordenador";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Coordenador coordenador = new Coordenador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("login"),
                        rs.getString("senha")
                );
                coordenadores.add(coordenador);
            }
        }
        return coordenadores;
    }

    public List<Coordenador> obterLoginSenhaEId() throws SQLException {
        List<Coordenador> coordenadores = new ArrayList<>();
        String sql = "SELECT id, login, senha FROM coordenador";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Coordenador coordenador = new Coordenador(
                        rs.getInt("id"),
                        null,  // nome não incluído
                        null,  // email não incluído
                        rs.getString("login"),
                        rs.getString("senha")
                );
                coordenadores.add(coordenador);
            }
        }
        return coordenadores;
    }

    public List<Coordenador> obterNomeEEmail() throws SQLException {
        List<Coordenador> coordenadores = new ArrayList<>();
        String sql = "SELECT nome, email FROM coordenador";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Coordenador coordenador = new Coordenador(
                        rs.getString("nome"),
                        rs.getString("email")
                );
                coordenadores.add(coordenador);
            }
        }
        return coordenadores;
    }

    public void atualizar(Coordenador coordenador) throws SQLException {
        String sql = "UPDATE coordenador SET nome = ?, email = ?, login = ?, senha = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, coordenador.getNome());
            stmt.setString(2, coordenador.getEmail());
            stmt.setString(3, coordenador.getLogin());
            stmt.setString(4, coordenador.getSenha());
            stmt.setInt(5, coordenador.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM coordenador WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

