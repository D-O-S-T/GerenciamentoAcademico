package com.exemplo.gerenciamentoacademico.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises;

public class RelatorioAnalisesDAO {

    public RelatorioAnalises getRelatorioAnalises() throws SQLException {
        RelatorioAnalises relatorio = new RelatorioAnalises();
        Connection connection = DatabaseUtil.getConexao();

        String totalUsuariosQuery = "SELECT " +
            "(SELECT COUNT(*) FROM professor) + " +
            "(SELECT COUNT(*) FROM aluno) + " +
            "(SELECT COUNT(*) FROM coordenador) AS totalUsuarios";

        String totalProfessoresQuery = "SELECT COUNT(*) AS total FROM professor";
        String totalAlunosQuery = "SELECT COUNT(*) AS total FROM aluno";
        String totalCoordenadoresQuery = "SELECT COUNT(*) AS total FROM coordenador";
        String totalAtividadesQuery = "SELECT COUNT(*) AS total FROM atividade";
        String totalProjetosQuery = "SELECT COUNT(*) AS total FROM projeto";
        String totalEntregasQuery = "SELECT COUNT(*) AS total FROM entrega";

        try (PreparedStatement psTotalUsuarios = connection.prepareStatement(totalUsuariosQuery);
             PreparedStatement psTotalProfessores = connection.prepareStatement(totalProfessoresQuery);
             PreparedStatement psTotalAlunos = connection.prepareStatement(totalAlunosQuery);
             PreparedStatement psTotalCoordenadores = connection.prepareStatement(totalCoordenadoresQuery);
             PreparedStatement psTotalAtividades = connection.prepareStatement(totalAtividadesQuery);
             PreparedStatement psTotalProjetos = connection.prepareStatement(totalProjetosQuery);
             PreparedStatement psTotalEntregas = connection.prepareStatement(totalEntregasQuery)) {

            ResultSet rs = psTotalUsuarios.executeQuery();
            if (rs.next()) {
                int totalUsuarios = rs.getInt("totalUsuarios");
                relatorio.setTotalUsuarios(totalUsuarios);
            }

            rs = psTotalProfessores.executeQuery();
            if (rs.next()) {
                int totalProfessores = rs.getInt("total");
                relatorio.setTotalProfessores(totalProfessores);
            }

            rs = psTotalAlunos.executeQuery();
            if (rs.next()) {
                int totalAlunos = rs.getInt("total");
                relatorio.setTotalAlunos(totalAlunos);
            }

            rs = psTotalCoordenadores.executeQuery();
            if (rs.next()) {
                int totalCoordenadores = rs.getInt("total");
                relatorio.setTotalCoordenadores(totalCoordenadores);
            }

            rs = psTotalAtividades.executeQuery();
            if (rs.next()) {
                int totalAtividades = rs.getInt("total");
                relatorio.setTotalAtividades(totalAtividades);
            }

            rs = psTotalProjetos.executeQuery();
            if (rs.next()) {
                int totalProjetos = rs.getInt("total");
                relatorio.setTotalProjetos(totalProjetos);
            }

            rs = psTotalEntregas.executeQuery();
            if (rs.next()) {
                int totalEntregas = rs.getInt("total");
                relatorio.setTotalEntregas(totalEntregas);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return relatorio;
    }
}





