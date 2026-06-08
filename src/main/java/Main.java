import java.time.LocalDate;
import java.util.Scanner;

import handler.CardapioHandler;
import handler.RelatorioHandler;
import model.HistoricoConsumo;
import model.Refeicao;
import model.Usuario;
import repository.HistoricoRepository;
import repository.RefeicaoRepository;
import service.ConsumoService;
import service.LoginService;
import service.RelatorioService;
import service.UsuarioService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioService usuarioService =
                new UsuarioService();

        LoginService loginService =
                new LoginService();

        ConsumoService consumoService =
                new ConsumoService();

        HistoricoRepository historicoRepository =
                new HistoricoRepository();

        RefeicaoRepository refeicaoRepository =
                new RefeicaoRepository();

        Usuario usuarioLogado = null;

        boolean executando = true;

        while (executando) {

            System.out.println("\n===== UNIFOOD =====");

            if (usuarioLogado != null) {

                System.out.println(
                        "Usuário logado: "
                        + usuarioLogado.getNome()
                );
            }

            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Login");
            System.out.println("3 - Ver cardápio");
            System.out.println("4 - Consumir refeição");
            System.out.println("5 - Ver saldo");
            System.out.println("6 - Relatório");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    try {

                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome =
                                scanner.nextLine();

                        System.out.print("Matrícula: ");
                        String matricula =
                                scanner.nextLine();

                        System.out.print("Email: ");
                        String email =
                                scanner.nextLine();

                        System.out.print("Senha: ");
                        String senha =
                                scanner.nextLine();

                        System.out.print("Saldo: ");
                        double saldo =
                                scanner.nextDouble();
                        scanner.nextLine();

                        Usuario usuario =
                                new Usuario(
                                        id,
                                        nome,
                                        matricula,
                                        email,
                                        senha,
                                        saldo
                                );

                        usuarioService
                                .cadastrarUsuario(usuario);

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage()
                        );
                    }

                    break;

                case 2:

                    System.out.print("Email: ");
                    String emailLogin =
                            scanner.nextLine();

                    System.out.print("Senha: ");
                    String senhaLogin =
                            scanner.nextLine();

                    usuarioLogado =
                            loginService.autenticar(
                                    emailLogin,
                                    senhaLogin
                            );

                    if (usuarioLogado != null) {

                        System.out.println(
                                "Login realizado!"
                        );

                    } else {

                        System.out.println(
                                "Credenciais inválidas."
                        );
                    }

                    break;

                case 3:

                    CardapioHandler cardapio =
                            new CardapioHandler();

                    cardapio.listarCardapio();

                    break;

                case 4:

                    if (usuarioLogado == null) {

                        System.out.println(
                                "Faça login primeiro."
                        );

                        break;
                    }

                    CardapioHandler cardapioConsumo =
                            new CardapioHandler();

                    cardapioConsumo.listarCardapio();

                    System.out.print(
                            "Escolha a refeição: "
                    );

                    int escolha =
                            scanner.nextInt();

                    scanner.nextLine();

                    Refeicao refeicao =
                            refeicaoRepository
                                    .buscarPorIndice(
                                            escolha - 1
                                    );

                    if (refeicao == null) {

                        System.out.println(
                                "Refeição inválida."
                        );

                        break;
                    }

                    boolean sucesso =
                            consumoService
                                    .registrarConsumo(
                                            usuarioLogado,
                                            refeicao
                                    );

                    if (sucesso) {

                        historicoRepository
                                .adicionarHistorico(
                                        new HistoricoConsumo(
                                                usuarioLogado
                                                        .getNome(),
                                                refeicao
                                                        .getNome(),
                                                LocalDate.now()
                                                        .toString()
                                        )
                                );
                    }

                    break;

                case 5:

                    if (usuarioLogado == null) {

                        System.out.println(
                                "Faça login primeiro."
                        );

                    } else {

                        System.out.println(
                                "Saldo atual: R$ "
                                + usuarioLogado
                                .getSaldo()
                        );
                    }

                    break;

                case 6:

                    RelatorioService relatorioService =
                            new RelatorioService(
                                    historicoRepository
                            );

                    RelatorioHandler relatorioHandler =
                            new RelatorioHandler(
                                    relatorioService
                            );

                    relatorioHandler.exibirRelatorio();

                    break;

                case 0:

                    executando = false;

                    break;

                default:

                    System.out.println(
                            "Opção inválida."
                    );
            }
        }

        scanner.close();
    }
}