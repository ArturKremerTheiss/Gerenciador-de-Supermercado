import model.Produto;
import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {

    public void inserir(Produto p) throws Exception {
        Connection c = Conexao.conectar();
        String sql = "INSERT INTO produto (nome, preco, estoque) VALUES (?, ?, ?)";

        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setDouble(2, p.getPreco());
        ps.setInt(3, p.getEstoque());
        ps.execute();
    }

    public ArrayList<Produto> listar() throws Exception {
        ArrayList<Produto> lista = new ArrayList<>();
        Connection c = Conexao.conectar();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM produto");

        while (rs.next()) {
            lista.add(new Produto(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getDouble("preco"),
                rs.getInt("estoque")
            ));
        }

        return lista;
    }

    public void atualizarEstoque(int id, int novo) throws Exception {
        Connection c = Conexao.conectar();
        String sql = "UPDATE produto SET estoque=? WHERE id=?";

        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, novo);
        ps.setInt(2, id);
        ps.execute();
    }
}