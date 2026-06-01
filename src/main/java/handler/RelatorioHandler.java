package handler;

import service.RelatorioService;

public class RelatorioHandler {

    private RelatorioService service;

    public RelatorioHandler(RelatorioService service) {
        this.service = service;
    }

    public void exibirRelatorio() {
        service.gerarRelatorio();
    }
}