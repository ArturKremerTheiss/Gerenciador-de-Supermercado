package view;
import model.*;

import javax.swing.*;
import java.util.ArrayList;

public class TelaCompra extends JFrame {

    private Carrinho carrinho = new Carrinho();

    public TelaCompra(Usuario u) {
        setTitle("Compra");
        setSize(400,300);
        setLayout(null);

        JButton listar = new JButton("Listar Produtos");
        listar.setBounds(10,10,150,30);
        add(listar);

        JTextArea area = new JTextArea();
        area.setBounds(10,50,360,150);
        add(area);

        JButton finalizar = new JButton("Finalizar");
        finalizar.setBounds(10,210,150,30);
        add(finalizar);

        listar.addActionListener(e -> {
            try {
                ArrayList<Produto> lista = new ProdutoDAO().listar();
                area.setText("");

                for (Produto p : lista) {
                    area.append(p.getId()+" - "+p.getNome()+" R$"+p.getPreco()+"\n");
                    carrinho.adicionar(p); // simplificado
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        finalizar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                "Total: R$ " + carrinho.total());
        });

        setVisible(true);
    }
}