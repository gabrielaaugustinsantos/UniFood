import model.Usuario;
import service.UsuarioService;

public class Main {

    public static void main(String[] args) {

        UsuarioService service = new UsuarioService();

        Usuario usuario = new Usuario(
                1,
                "Gabriela",
                "12345",
                "gabriela@email.com",
                "123"
        );

        service.cadastrarUsuario(usuario);

    }

}