 feature/cadastro-usuario
import model.Usuario;
import service.UsuarioService;

 main
public class Main {

    public static void main(String[] args) {

 feature/cadastro-usuario
        UsuarioService service = new UsuarioService();

        Usuario usuario1 = new Usuario(
                1,
                "Gabriela",
                "123",
                "gabriela@email.com",
                "123"
        );

        Usuario usuario2 = new Usuario(
                2,
                "Luize",
                "124",
                "luize@email.com",
                "456"
        );

        service.cadastrarUsuario(usuario1);

        service.cadastrarUsuario(usuario2);

        System.out.println("UniFood iniciado com sucesso!");
 main

    }

}