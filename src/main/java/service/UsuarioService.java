package service;

import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(
            UsuarioRepository repository
    ) {
        this.repository = repository;
    }

    public void cadastrarUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Usuário não pode ser nulo."
            );
        }

        if (
                usuario.getNome() == null ||
                usuario.getMatricula() == null ||
                usuario.getEmail() == null ||
                usuario.getSenha() == null ||
                usuario.getNome().isBlank() ||
                usuario.getMatricula().isBlank() ||
                usuario.getEmail().isBlank() ||
                usuario.getSenha().isBlank()
        ) {

            throw new IllegalArgumentException(
                    "Campos obrigatórios vazios."
            );
        }

        if (
                repository.buscarPorMatricula(
                        usuario.getMatricula()
                ) != null
        ) {

            throw new IllegalArgumentException(
                    "Matrícula já cadastrada."
            );
        }

        if (
                repository.buscarPorEmail(
                        usuario.getEmail()
                ) != null
        ) {

            throw new IllegalArgumentException(
                    "Email já cadastrado."
            );
        }

        if (
                repository.buscarPorId(
                        usuario.getId()
                ) != null
        ) {

            throw new IllegalArgumentException(
                    "ID já cadastrado."
            );
        }

        repository.salvar(usuario);

        System.out.println(
                "Usuário cadastrado com sucesso!"
        );
    }

    public Usuario buscarPorEmail(String email) {

        if (email == null || email.isBlank()) {
            return null;
        }

        return repository.buscarPorEmail(email);
    }

    public void adicionarSaldo(
        Usuario usuario,
        double valor
        ) {

        if (valor <= 0) {

                throw new IllegalArgumentException(
                        "O valor deve ser maior que zero."
                );
        }

        usuario.setSaldo(
                usuario.getSaldo() + valor
        );

        System.out.println(
                "Saldo adicionado com sucesso!"
        );
        }
}