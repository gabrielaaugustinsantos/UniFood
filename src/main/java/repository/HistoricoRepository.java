package repository;

import java.util.ArrayList;
import java.util.List;

import model.HistoricoConsumo;

public class HistoricoRepository {

    private List<HistoricoConsumo> historicos = new ArrayList<>();

    public void adicionarHistorico(HistoricoConsumo historico) {
        historicos.add(historico);
    }

    public List<HistoricoConsumo> listarHistorico() {
        return historicos;
    }
}