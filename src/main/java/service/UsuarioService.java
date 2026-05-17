package service;

import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository repository = new UsuarioRepository();

    public void cadastrarUsuario(Usuario usuario) {

        if (
                usuario.getNome().isEmpty() ||
                usuario.getMatricula().isEmpty() ||
                usuario.getEmail().isEmpty() ||
                usuario.getSenha().isEmpty()
        ) {

            throw new IllegalArgumentException("Campos obrigatórios vazios.");
        }

        if (repository.buscarPorMatricula(usuario.getMatricula()) != null) {

            throw new IllegalArgumentException("Matrícula já cadastrada.");
        }

        if (repository.buscarPorEmail(usuario.getEmail()) != null) {

            throw new IllegalArgumentException("Email já cadastrado.");
        }

        repository.salvar(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }
}