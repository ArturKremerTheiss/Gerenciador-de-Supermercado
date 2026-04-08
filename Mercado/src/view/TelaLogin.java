package view;

import controller.LoginController;
import model.Usuario;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Login");
        setSize(1017,629);
        getContentPane().setLayout(new MigLayout("", "[240px][][][][][][][][][][][][][][][][][][][][][][][]", "[20px][20px][30px][][][][][][][][][][][][][][][][]"));
                                                
                                                        JLabel l1 = new JLabel("Nome:");
                                                        getContentPane().add(l1, "cell 2 2 2 1,alignx left,growy");
                                        
                                                JTextField nome = new JTextField();
                                                getContentPane().add(nome, "cell 4 2 10 1,growx,aligny top");
                                        
                                                JLabel l2 = new JLabel("CPF:");
                                                getContentPane().add(l2, "cell 2 3,alignx left,growy");
                                        
                                                JTextField cpf = new JTextField();
                                                getContentPane().add(cpf, "cell 4 3 10 1,growx,aligny top");
                                
                                        JButton entrar = new JButton("Entrar");
                                        getContentPane().add(entrar, "cell 7 9 8 4,alignx center,growy");

        entrar.addActionListener(e -> {
            LoginController c = new LoginController();
            Usuario u = c.login(nome.getText(), cpf.getText());

            
            if (u != null) {
                if (u.isAdmin()) {
                    new TelaProduto(u);
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