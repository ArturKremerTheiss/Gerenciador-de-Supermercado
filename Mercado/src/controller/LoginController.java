package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginController {

    public Usuario login(String nome, String cpf) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            return dao.login(nome, cpf);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}