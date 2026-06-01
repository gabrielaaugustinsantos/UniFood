import handler.CardapioHandler;
import model.Refeicao;
import model.Usuario;
import service.ConsumoService;
import service.LoginService;
import service.UsuarioService;

public class Main {

    public static void main(String[] args) {

        UsuarioService service = new UsuarioService();

        Usuario usuario1 = new Usuario(
                1,
                "Gabriela",
                "123",
                "gabriela@email.com",
                "123",
                30.0
        );

        Usuario usuario2 = new Usuario(
                2,
                "Luize",
                "456",
                "luize@email.com",
                "456",
                20.0
        );

        service.cadastrarUsuario(usuario1);

        service.cadastrarUsuario(usuario2);

        LoginService loginService = new LoginService();

        boolean login = loginService.validarLogin(
                "gabriela@email.com",
                "123"
        );

        System.out.println("Login realizado: " + login);

        // Teste do cardápio

        CardapioHandler cardapio = new CardapioHandler();

        cardapio.listarCardapio();

        // Teste de consumo de refeição

        Refeicao refeicao = new Refeicao(
                "Almoço",
                "Arroz, feijão e carne",
                5.0,
                10
        );

        ConsumoService consumoService = new ConsumoService();

        consumoService.registrarConsumo(
                usuario1,
                refeicao
        );

    }

}