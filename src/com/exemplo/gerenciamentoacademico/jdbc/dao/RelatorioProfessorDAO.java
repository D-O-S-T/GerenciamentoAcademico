package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioProfessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioProfessorDAO {

    public void adicionarRelatorioProfessor(RelatorioProfessor relatorioProfessor) {
        String sql = "INSERT INTO relatorioprofessor (titulo, relatorio, professor_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, relatorioProfessor.getTitulo());
            stmt.setString(2, relatorioProfessor.getRelatorio());
            stmt.setInt(3, relatorioProfessor.getProfessorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public List<RelatorioProfessor> getTodosRelatoriosProfessor() {
        String sql = "SELECT * FROM relatorioprofessor";
        List<RelatorioProfessor> relatorios = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RelatorioProfessor relatorioProfessor = new RelatorioProfessor(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("relatorio"),
                        rs.getInt("professor_id")
                );
                relatorios.add(relatorioProfessor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relatorios;
    }

    public List<RelatorioProfessor> getTodosRelatoriosProfessorSemId() {
        String sql = "SELECT titulo, relatorio, professor_id FROM relatorioprofessor";
        List<RelatorioProfessor> relatorios = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RelatorioProfessor relatorioProfessor = new RelatorioProfessor(
                        rs.getString("titulo"),
                        rs.getString("relatorio"),
                        rs.getInt("professor_id")
                );
                relatorios.add(relatorioProfessor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relatorios;
    }
    
    public void atualizarRelatorioProfessor(RelatorioProfessor relatorioProfessor) {
        String sql = "UPDATE relatorioprofessor SET titulo = ?, relatorio = ?, professor_id = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, relatorioProfessor.getTitulo());
            stmt.setString(2, relatorioProfessor.getRelatorio());
            stmt.setInt(3, relatorioProfessor.getProfessorId());
            stmt.setInt(4, relatorioProfessor.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirRelatorioProfessor(int id) {
        String sql = "DELETE FROM relatorioprofessor WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public RelatorioProfessor getRelatorioProfessorPorId(int id) {
        String sql = "SELECT * FROM relatorioprofessor WHERE id = ?";
        RelatorioProfessor relatorioProfessor = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    relatorioProfessor = new RelatorioProfessor(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("relatorio"),
                            rs.getInt("professor_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relatorioProfessor;
    }
}
