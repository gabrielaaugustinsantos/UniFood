package service;

import model.Usuario;
import repository.UsuarioRepository;

public class LoginService {

    private UsuarioRepository repository =
            new UsuarioRepository();

    public Usuario autenticar(
            String email,
            String senha
    ) {

        Usuario usuario =
                repository.buscarPorEmail(email);

        if (usuario == null) {
            return null;
        }

        if (!usuario.getSenha().equals(senha)) {
            return null;
        }

        return usuario;
    }
}