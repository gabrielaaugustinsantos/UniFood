package service;

import model.HistoricoConsumo;
import repository.HistoricoRepository;

public class RelatorioService {

    private HistoricoRepository repository;

    public RelatorioService(HistoricoRepository repository) {
        this.repository = repository;
    }

    public void gerarRelatorio() {

        System.out.println("\n===== RELATÓRIO DO RU =====");

        int totalRefeicoes = repository.listarHistorico().size();

        System.out.println("Total de refeições consumidas: "
                + totalRefeicoes);

        System.out.println("\nHistórico:");

        for (HistoricoConsumo historico :
                repository.listarHistorico()) {

            System.out.println(historico);
        }
    }
}