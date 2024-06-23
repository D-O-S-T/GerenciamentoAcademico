package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioCoordenador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCoordenadorDAO {

    public void adicionarRelatorioCoordenador(RelatorioCoordenador relatorioCoordenador) {
        String sql = "INSERT INTO relatoriocoordenador (titulo, relatorio, coordenador_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, relatorioCoordenador.getTitulo());
            stmt.setString(2, relatorioCoordenador.getRelatorio());
            stmt.setInt(3, relatorioCoordenador.getCoordenadorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RelatorioCoordenador> getRelatoriosPorCoordenador(int coordenadorId) {
        String sql = "SELECT * FROM relatoriocoordenador WHERE coordenador_id = ?";
        List<RelatorioCoordenador> relatorios = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, coordenadorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RelatorioCoordenador relatorio = new RelatorioCoordenador(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("relatorio"),
                            rs.getInt("coordenador_id")
                    );
                    relatorios.add(relatorio);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relatorios;
    }

    public RelatorioCoordenador getRelatorioPorId(int id) {
        String sql = "SELECT * FROM relatoriocoordenador WHERE id = ?";
        RelatorioCoordenador relatorio = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    relatorio = new RelatorioCoordenador(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("relatorio"),
                            rs.getInt("coordenador_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relatorio;
    }
    
    public List<RelatorioCoordenador> getTodosRelatorios() {
        String sql = "SELECT * FROM relatoriocoordenador";
        List<RelatorioCoordenador> relatorios = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RelatorioCoordenador relatorio = new RelatorioCoordenador(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("relatorio"),
                        rs.getInt("coordenador_id")
                );
                relatorios.add(relatorio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relatorios;
    }

    public void atualizarRelatorioCoordenador(RelatorioCoordenador relatorioCoordenador) {
        String sql = "UPDATE relatoriocoordenador SET titulo = ?, relatorio = ?, coordenador_id = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, relatorioCoordenador.getTitulo());
            stmt.setString(2, relatorioCoordenador.getRelatorio());
            stmt.setInt(3, relatorioCoordenador.getCoordenadorId());
            stmt.setInt(4, relatorioCoordenador.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirRelatorioCoordenador(int id) {
        String sql = "DELETE FROM relatoriocoordenador WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
