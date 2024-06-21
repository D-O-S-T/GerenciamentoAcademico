package com.exemplo.gerenciamentoacademico.jdbc.dao;

package com.exemplo.gerenciamentoacademico.jdbc.dao;

import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection connection;

    public AlunoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (matricula, nome, email, lattes, login, senha) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getLattes());
            stmt.setString(5, aluno.getLogin());
            stmt.setString(6, aluno.getSenha());
            stmt.executeUpdate();
        }
    }

    public Aluno obterPorId(int id) throws SQLException {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aluno(
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
        return null;
    }

    public List<Aluno> obterTodos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
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
        }
        return alunos;
    }

    public List<Aluno> obterLoginSenhaEId() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT id, login, senha FROM aluno";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        null,  // matricula não incluída
                        null,  // nome não incluído
                        null,  // email não incluído
                        null,  // lattes não incluído
                        rs.getString("login"),
                        rs.getString("senha")
                );
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public List<Aluno> obterNomeEEmail() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT nome, email FROM aluno";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Aluno aluno = new Aluno(
                        null,  // id não incluído
                        null,  // matricula não incluída
                        rs.getString("nome"),
                        rs.getString("email"),
                        null,  // lattes não incluído
                        null,  // login não incluído
                        null   // senha não incluída
                );
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE aluno SET matricula = ?, nome = ?, email = ?, lattes = ?, login = ?, senha = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getLattes());
            stmt.setString(5, aluno.getLogin());
            stmt.setString(6, aluno.getSenha());
            stmt.setInt(7, aluno.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
