package view;
import model.Produto;
import model.Usuario;

import javax.swing.*;

public class TelaProduto extends JFrame {

    public TelaProduto(Usuario u) {
        setTitle("Produtos");
        setSize(300,250);
        setLayout(null);

        JTextField nome = new JTextField();
        nome.setBounds(10,10,150,20);
        add(nome);

        JTextField preco = new JTextField();
        preco.setBounds(10,40,150,20);
        add(preco);

        JTextField estoque = new JTextField();
        estoque.setBounds(10,70,150,20);
        add(estoque);

        JButton salvar = new JButton("Salvar");
        salvar.setBounds(10,100,100,30);
        add(salvar);

        salvar.addActionListener(e -> {
            try {
                Produto p = new Produto(
                    0,
                    nome.getText(),
                    Double.parseDouble(preco.getText()),
                    Integer.parseInt(estoque.getText())
                );

                model.Supermercado.Produto.add(p);
                JOptionPane.showMessageDialog(null, "Salvo!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }
}