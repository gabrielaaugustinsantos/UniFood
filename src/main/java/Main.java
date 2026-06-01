import handler.CardapioHandler;
import handler.RelatorioHandler;
import model.HistoricoConsumo;
import model.Refeicao;
import model.Usuario;
import repository.HistoricoRepository;
import service.ConsumoService;
import service.LoginService;
import service.RelatorioService;
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

        // Teste de Login

        LoginService loginService = new LoginService();

        boolean login = loginService.validarLogin(
                "gabriela@email.com",
                "123"
        );

        System.out.println("Login realizado: " + login);

        // Teste do Cardápio

        CardapioHandler cardapio = new CardapioHandler();

        cardapio.listarCardapio();

        // Teste de Consumo de Refeição

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

        // Teste do Histórico e Relatório

        HistoricoRepository historicoRepository =
                new HistoricoRepository();

        historicoRepository.adicionarHistorico(
                new HistoricoConsumo(
                        "Gabriela",
                        "Almoço",
                        "20/05/2026"
                )
        );

        historicoRepository.adicionarHistorico(
                new HistoricoConsumo(
                        "Luize",
                        "Jantar",
                        "20/05/2026"
                )
        );

        RelatorioService relatorioService =
                new RelatorioService(historicoRepository);

        RelatorioHandler relatorioHandler =
                new RelatorioHandler(relatorioService);

        relatorioHandler.exibirRelatorio();

    }

}