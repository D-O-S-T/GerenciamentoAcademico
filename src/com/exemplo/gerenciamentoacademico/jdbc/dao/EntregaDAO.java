package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

    public List<Entrega> getTodasEntregas() {
        String sql = "SELECT * FROM entrega";
        List<Entrega> entregas = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Entrega entrega = new Entrega(
                        rs.getInt("id"),
                        rs.getString("conteudo"),
                        rs.getDate("dataEntrega").toLocalDate(),
                        rs.getInt("professor_id"),
                        rs.getInt("alunoDaEntrega_id"),
                        rs.getInt("atividade_id")
                );
                entregas.add(entrega);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entregas;
    }

    public List<Entrega> getEntregasPorProfessor(int professorId) {
        String sql = "SELECT * FROM entrega WHERE professor_id = ?";
        List<Entrega> entregas = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Entrega entrega = new Entrega(
                            rs.getInt("id"),
                            rs.getString("conteudo"),
                            rs.getDate("dataEntrega").toLocalDate(),
                            rs.getInt("professor_id"),
                            rs.getInt("alunoDaEntrega_id"),
                            rs.getInt("atividade_id")
                    );
                    entregas.add(entrega);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entregas;
    }

    public void inserirEntrega(Entrega entrega) throws SQLException {
        String sql = "INSERT INTO entrega (conteudo, dataEntrega, professor_id, alunoDaEntrega_id, atividade_id) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entrega.getConteudo());
            stmt.setDate(2, java.sql.Date.valueOf(entrega.getDataEntrega()));
            stmt.setInt(3, entrega.getProfessorId());
            stmt.setInt(4, entrega.getAlunoDaEntregaId());
            stmt.setInt(5, entrega.getAtividadeId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void atualizarEntrega(Entrega entrega) throws SQLException {
        String sql = "UPDATE entrega SET conteudo = ?, dataEntrega = ?, professor_id = ?, alunoDaEntrega_id = ?, atividade_id = ? " +
                     "WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entrega.getConteudo());
            stmt.setDate(2, java.sql.Date.valueOf(entrega.getDataEntrega()));
            stmt.setInt(3, entrega.getProfessorId());
            stmt.setInt(4, entrega.getAlunoDaEntregaId());
            stmt.setInt(5, entrega.getAtividadeId());
            stmt.setInt(6, entrega.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void excluirEntrega(int id) {
        String sql = "DELETE FROM entrega WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Entrega getEntregaPorId(int id) {
        String sql = "SELECT * FROM entrega WHERE id = ?";
        Entrega entrega = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    entrega = new Entrega(
                            rs.getInt("id"),
                            rs.getString("conteudo"),
                            rs.getDate("dataEntrega").toLocalDate(),
                            rs.getInt("professor_id"),
                            rs.getInt("alunoDaEntrega_id"),
                            rs.getInt("atividade_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entrega;
    }
}
