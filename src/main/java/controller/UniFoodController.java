package controller;

import java.time.LocalDate;

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

public class UniFoodController {

    private UsuarioService usuarioService;
    private LoginService loginService;
    private ConsumoService consumoService;

    private HistoricoRepository historicoRepository;
    private RefeicaoRepository refeicaoRepository;

    public UniFoodController(
            UsuarioService usuarioService,
            LoginService loginService,
            ConsumoService consumoService,
            HistoricoRepository historicoRepository,
            RefeicaoRepository refeicaoRepository
    ) {

        this.usuarioService = usuarioService;
        this.loginService = loginService;
        this.consumoService = consumoService;
        this.historicoRepository = historicoRepository;
        this.refeicaoRepository = refeicaoRepository;
    }

    public void cadastrarUsuario(Usuario usuario) {

        usuarioService.cadastrarUsuario(usuario);
    }

    public Usuario fazerLogin(
            String email,
            String senha
    ) {

        return loginService.autenticar(
                email,
                senha
        );
    }

    public void exibirCardapio() {

        CardapioHandler handler =
                new CardapioHandler(refeicaoRepository);

        handler.listarCardapio();
    }

    public boolean consumirRefeicao(
            Usuario usuario,
            int indice
    ) {

        Refeicao refeicao =
                refeicaoRepository.buscarPorIndice(
                        indice
                );

        if (refeicao == null) {
            return false;
        }

        boolean sucesso =
                consumoService.registrarConsumo(
                        usuario,
                        refeicao
                );

        if (sucesso) {

            historicoRepository.adicionarHistorico(
                    new HistoricoConsumo(
                            usuario.getNome(),
                            refeicao.getNome(),
                            LocalDate.now().toString()
                    )
            );
        }

        return sucesso;
    }

    public void exibirRelatorio() {

        RelatorioService relatorioService =
                new RelatorioService(
                        historicoRepository
                );

        RelatorioHandler handler =
                new RelatorioHandler(
                        relatorioService
                );

        handler.exibirRelatorio();
    }
}