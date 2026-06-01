package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import config.DatabaseConfig;
import model.Usuario;

public class UsuarioRepository {

    public UsuarioRepository() {
        criarTabela();
    }

    private void criarTabela() {

        String sql = """
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INT PRIMARY KEY,
                    nome VARCHAR(100),
                    matricula VARCHAR(50) UNIQUE,
                    email VARCHAR(100) UNIQUE,
                    senha VARCHAR(100),
                    saldo DOUBLE
                )
                """;

        try (
                Connection conn = DatabaseConfig.getConnection();
                Statement stmt = conn.createStatement()
        ) {

            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salvar(Usuario usuario) {

        String sql =
                "INSERT INTO usuarios (id, nome, matricula, email, senha, saldo) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getMatricula());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.setDouble(6, usuario.getSaldo());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarPorEmail(String email) {

        String sql =
                "SELECT * FROM usuarios WHERE email = ?";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("matricula"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getDouble("saldo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Usuario buscarPorMatricula(String matricula) {

        String sql =
                "SELECT * FROM usuarios WHERE matricula = ?";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, matricula);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("matricula"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getDouble("saldo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Usuario buscarPorId(int id) {

        String sql =
                "SELECT * FROM usuarios WHERE id = ?";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("matricula"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getDouble("saldo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}