import java.util.Scanner;

import controller.UniFoodController;
import model.Usuario;
import repository.HistoricoRepository;
import repository.RefeicaoRepository;
import repository.UsuarioRepository;
import service.ConsumoService;
import service.LoginService;
import service.UsuarioService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioRepository usuarioRepository =
                new UsuarioRepository();

        HistoricoRepository historicoRepository =
                new HistoricoRepository();

        RefeicaoRepository refeicaoRepository =
                new RefeicaoRepository();

        UsuarioService usuarioService =
                new UsuarioService(
                        usuarioRepository
                );

        LoginService loginService =
                new LoginService(
                        usuarioRepository
                );

        ConsumoService consumoService =
                new ConsumoService();

        UniFoodController controller =
                new UniFoodController(
                        usuarioService,
                        loginService,
                        consumoService,
                        historicoRepository,
                        refeicaoRepository
                );

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
            System.out.println("5 - Adicionar saldo");
            System.out.println("6 - Ver saldo");
            System.out.println("7 - Relatório");
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

                        controller.cadastrarUsuario(
                                usuario
                        );

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
                            controller.fazerLogin(
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

                    controller.exibirCardapio();

                    break;

                case 4:

                    if (usuarioLogado == null) {

                        System.out.println(
                                "Faça login primeiro."
                        );

                        break;
                    }

                    controller.exibirCardapio();

                    System.out.print(
                            "Escolha a refeição: "
                    );

                    int escolha =
                            scanner.nextInt();

                    scanner.nextLine();

                    boolean sucesso =
                            controller.consumirRefeicao(
                                    usuarioLogado,
                                    escolha - 1
                            );

                    if (!sucesso) {

                        System.out.println(
                                "Não foi possível realizar o consumo."
                        );
                    }

                    break;

                case 5:

                    if (usuarioLogado == null) {

                        System.out.println(
                                "Faça login primeiro."
                        );

                        break;
                    }

                    try {

                        System.out.print(
                                "Valor para adicionar: R$ "
                        );

                        double valor =
                                scanner.nextDouble();

                        scanner.nextLine();

                        usuarioService.adicionarSaldo(
                                usuarioLogado,
                                valor
                        );

                        System.out.println(
                                "Novo saldo: R$ "
                                + usuarioLogado.getSaldo()
                        );

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage()
                        );
                    }

                    break;

                case 6:

                    if (usuarioLogado == null) {

                        System.out.println(
                                "Faça login primeiro."
                        );

                    } else {

                        System.out.println(
                                "Saldo atual: R$ "
                                + usuarioLogado.getSaldo()
                        );
                    }

                    break;

                case 7:

                    controller.exibirRelatorio();

                    break;

                case 0:

                    executando = false;

                    System.out.println(
                            "Sistema encerrado."
                    );

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