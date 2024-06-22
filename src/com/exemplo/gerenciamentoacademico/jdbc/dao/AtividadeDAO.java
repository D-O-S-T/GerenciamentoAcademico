package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Atividade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {

    public void adicionarAtividade(Atividade atividade) {
        String sql = "INSERT INTO atividade (titulo, conteudo, dataInicial, dataFinal, projeto_id) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atividade.getTitulo());
            stmt.setString(2, atividade.getConteudo());
            stmt.setDate(3, java.sql.Date.valueOf(atividade.getDataInicial()));
            stmt.setDate(4, java.sql.Date.valueOf(atividade.getDataFinal()));
            stmt.setInt(5, atividade.getProjetoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Atividade> getTodasAtividades() {
        String sql = "SELECT a.*, p.titulo AS projetoTitulo " +
                     "FROM atividade a " +
                     "JOIN projeto p ON a.projeto_id = p.id";
        List<Atividade> atividades = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Atividade atividade = new Atividade(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("conteudo"),
                        rs.getDate("dataInicial").toLocalDate(),
                        rs.getDate("dataFinal").toLocalDate(),
                        rs.getInt("projeto_id"),
                        rs.getString("projetoTitulo")
                );
                atividades.add(atividade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atividades;
    }

    public void atualizarAtividade(Atividade atividade) {
        String sql = "UPDATE atividade SET titulo = ?, conteudo = ?, dataInicial = ?, dataFinal = ?, projeto_id = ? " +
                     "WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, atividade.getTitulo());
            stmt.setString(2, atividade.getConteudo());
            stmt.setDate(3, java.sql.Date.valueOf(atividade.getDataInicial()));
            stmt.setDate(4, java.sql.Date.valueOf(atividade.getDataFinal()));
            stmt.setInt(5, atividade.getProjetoId());
            stmt.setInt(6, atividade.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirAtividade(int id) {
        String sql = "DELETE FROM atividade WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Atividade getAtividadePorId(int id) {
        String sql = "SELECT * FROM atividade WHERE id = ?";
        Atividade atividade = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    atividade = new Atividade(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("conteudo"),
                            rs.getDate("dataInicial").toLocalDate(),
                            rs.getDate("dataFinal").toLocalDate(),
                            rs.getInt("projeto_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atividade;
    }
}

