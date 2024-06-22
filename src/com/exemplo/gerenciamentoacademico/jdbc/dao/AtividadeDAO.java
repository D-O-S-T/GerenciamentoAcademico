package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Atividade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {

    public void adicionarAtividade(Atividade atividade) {
        String sql = "INSERT INTO atividade (titulo, conteudo, dataInicial, dataFinal, professor_id, alunoBolsista_id, alunoVoluntario_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atividade.getTitulo());
            stmt.setString(2, atividade.getConteudo());
            stmt.setDate(3, atividade.getDataInicial());
            stmt.setDate(4, atividade.getDataFinal());
            stmt.setInt(5, atividade.getProfessorId());
            stmt.setInt(6, atividade.getAlunoBolsistaId());
            stmt.setInt(7, atividade.getAlunoVoluntarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Atividade> getTodasAtividades() {
        String sql = "SELECT a.*, p.nome AS professorNome, ab.nome AS alunoBolsistaNome, av.nome AS alunoVoluntarioNome " +
                     "FROM atividade a " +
                     "JOIN professor p ON a.professor_id = p.id " +
                     "JOIN aluno ab ON a.alunoBolsista_id = ab.id " +
                     "JOIN aluno av ON a.alunoVoluntario_id = av.id";
        List<Atividade> atividades = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Atividade atividade = new Atividade(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("conteudo"),
                        rs.getDate("dataInicial"),
                        rs.getDate("dataFinal"),
                        rs.getInt("professor_id"),
                        rs.getInt("alunoBolsista_id"),
                        rs.getInt("alunoVoluntario_id"),
                        rs.getString("professorNome"),         // Nome do professor
                        rs.getString("alunoBolsistaNome"),     // Nome do aluno bolsista
                        rs.getString("alunoVoluntarioNome")    // Nome do aluno voluntário
                );
                atividades.add(atividade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atividades;
    }

    public void atualizarAtividade(Atividade atividade) {
        String sql = "UPDATE atividade SET titulo = ?, conteudo = ?, dataInicial = ?, dataFinal = ?, professor_id = ?, alunoBolsista_id = ?, alunoVoluntario_id = ? " +
                     "WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, atividade.getTitulo());
            stmt.setString(2, atividade.getConteudo());
            stmt.setDate(3, atividade.getDataInicial());
            stmt.setDate(4, atividade.getDataFinal());
            stmt.setInt(5, atividade.getProfessorId());
            stmt.setInt(6, atividade.getAlunoBolsistaId());
            stmt.setInt(7, atividade.getAlunoVoluntarioId());
            stmt.setInt(8, atividade.getId());

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
                            rs.getDate("dataInicial"),
                            rs.getDate("dataFinal"),
                            rs.getInt("professor_id"),
                            rs.getInt("alunoBolsista_id"),
                            rs.getInt("alunoVoluntario_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atividade;
    }
    
    public List<Atividade> getTodosAtividadesSemId() {
        String sql = "SELECT titulo, conteudo, dataInicial, dataFinal, professor_id, alunoBolsista_id, alunoVoluntario_id FROM atividade";
        List<Atividade> atividades = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Atividade atividade = new Atividade(
                        rs.getString("titulo"),
                        rs.getString("conteudo"),
                        rs.getDate("dataInicial"),
                        rs.getDate("dataFinal"),
                        rs.getInt("professor_id"),
                        rs.getInt("alunoBolsista_id"),
                        rs.getInt("alunoVoluntario_id")
                );
                atividades.add(atividade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atividades;
    }
}
