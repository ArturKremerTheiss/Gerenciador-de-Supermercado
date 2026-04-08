package dao;

import model.Usuario;
import java.sql.*;

public class UsuarioDAO {

    public void inserir(Usuario u) throws Exception {
        Connection c = conexao.conectar();
        String sql = "INSERT INTO usuario (nome, cpf, admin) VALUES (?, ?, ?)";

        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, u.getNome());
        ps.setString(2, u.getCpf());
        ps.setBoolean(3, u.isAdmin());
        ps.execute();
    }

    public Usuario login(String nome, String cpf) throws Exception {
        Connection c = conexao.conectar();
        String sql = "SELECT * FROM usuario WHERE nome=? AND cpf=?";

        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, cpf);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Usuario(
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getBoolean("admin")
            );
        }

        return null;
    }
}