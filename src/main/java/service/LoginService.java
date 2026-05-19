package service;

import model.Usuario;
import repository.UsuarioRepository;

public class LoginService {

    private UsuarioRepository repository = new UsuarioRepository();

    public boolean validarLogin(String email, String senha) {

        Usuario usuario = repository.buscarPorEmail(email);

        if (usuario == null) {

            return false;
        }

        return usuario.getSenha().equals(senha);
    }
}