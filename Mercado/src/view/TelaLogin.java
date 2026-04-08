package view;

import controller.LoginController;
import model.Usuario;

import javax.swing.*;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Login");
        setSize(300,200);
        setLayout(null);

        JLabel l1 = new JLabel("Nome:");
        l1.setBounds(10,10,100,20);
        add(l1);

        JTextField nome = new JTextField();
        nome.setBounds(100,10,150,20);
        add(nome);

        JLabel l2 = new JLabel("CPF:");
        l2.setBounds(10,40,100,20);
        add(l2);

        JTextField cpf = new JTextField();
        cpf.setBounds(100,40,150,20);
        add(cpf);

        JButton entrar = new JButton("Entrar");
        entrar.setBounds(80,80,100,30);
        add(entrar);

        entrar.addActionListener(e -> {
            LoginController c = new LoginController();
            Usuario u = c.login(nome.getText(), cpf.getText());

            if (u != null) {
                if (u.isAdmin()) {
                    new TelaProdutos(u);
                } else {
                    new TelaCompra(u);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro no login");
            }
        });

        setVisible(true);
    }
}