package repository;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public void salvar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarPorEmail(String email) {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equals(email)) {
                return usuario;
            }

        }

        return null;
    }

    public Usuario buscarPorMatricula(String matricula) {

        for (Usuario usuario : usuarios) {

            if (usuario.getMatricula().equals(matricula)) {
                return usuario;
            }

        }

        return null;
    }
}