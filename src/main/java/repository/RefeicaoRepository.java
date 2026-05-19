package repository;

import java.util.ArrayList;
import java.util.List;

import model.Refeicao;

public class RefeicaoRepository {

    public List<Refeicao> listarRefeicoes() {

        List<Refeicao> lista = new ArrayList<>();

        lista.add(
            new Refeicao(
                "Arroz e Feijão",
                "Prato tradicional",
                3.50,
                20
            )
        );

        lista.add(
            new Refeicao(
                "Frango Grelhado",
                "Frango com legumes",
                5.00,
                15
            )
        );

        return lista;
    }

}