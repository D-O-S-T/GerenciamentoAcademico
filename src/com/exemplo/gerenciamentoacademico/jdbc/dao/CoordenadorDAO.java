package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Coordenador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoordenadorDAO {

    public void adicionarCoordenador(Coordenador coordenador) {
        String sql = "INSERT INTO coordenador (nome, email, login, senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, coordenador.getNome());
            stmt.setString(2, coordenador.getEmail());
            stmt.setString(3, coordenador.getLogin());
            stmt.setString(4, coordenador.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Coordenador> getTodosCoordenadores() {
        String sql = "SELECT * FROM coordenador";
        List<Coordenador> coordenadores = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coordenadores;
    }

    public List<Coordenador> getTodosCoordenadoresSemIdSenhaLogin() {
        String sql = "SELECT nome, email FROM coordenador";
        List<Coordenador> coordenadores = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Coordenador coordenador = new Coordenador(
                        rs.getString("nome"),
                        rs.getString("email")
                );
                coordenadores.add(coordenador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coordenadores;
    }

    public void atualizarCoordenador(Coordenador coordenador) {
        String sql = "UPDATE coordenador SET nome = ?, email = ?, login = ?, senha = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, coordenador.getNome());
            stmt.setString(2, coordenador.getEmail());
            stmt.setString(3, coordenador.getLogin());
            stmt.setString(4, coordenador.getSenha());
            stmt.setInt(5, coordenador.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCoordenador(int id) {
        String sql = "DELETE FROM coordenador WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Coordenador getCoordenadorPorId(int id) {
        String sql = "SELECT * FROM coordenador WHERE id = ?";
        Coordenador coordenador = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    coordenador = new Coordenador(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("login"),
                            rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coordenador;
    }
}

