package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.DatabaseUtil;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void adicionarAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno (matricula, nome, email, lattes, login, senha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getLattes());
            stmt.setString(5, aluno.getLogin());
            stmt.setString(6, aluno.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> getTodosAlunos() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> alunos = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("matricula"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("lattes"),
                        rs.getString("login"),
                        rs.getString("senha")
                );
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public List<Aluno> getTodosAlunosSemId() {
        String sql = "SELECT matricula, nome, email, lattes, login, senha FROM aluno";
        List<Aluno> alunos = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getString("matricula"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("lattes"),
                        rs.getString("login"),
                        rs.getString("senha")
                );
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public List<Aluno> getTodosAlunosSemIdSenhaLogin() {
        String sql = "SELECT matricula, nome, email, lattes FROM aluno";
        List<Aluno> alunos = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getString("matricula"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("lattes")
                );
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
    
    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET matricula = ?, nome = ?, email = ?, lattes = ?, login = ?, senha = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getLattes());
            stmt.setString(5, aluno.getLogin());
            stmt.setString(6, aluno.getSenha());
            stmt.setInt(7, aluno.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirAluno(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Aluno getAlunoPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        Aluno aluno = null;
        try (Connection conn = DatabaseUtil.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    aluno = new Aluno(
                            rs.getInt("id"),
                            rs.getString("matricula"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("lattes"),
                            rs.getString("login"),
                            rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aluno;
    }
}
