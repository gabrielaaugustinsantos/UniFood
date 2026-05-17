import model.Usuario;
import service.UsuarioService;

public class Main {

    public static void main(String[] args) {

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

    }

}