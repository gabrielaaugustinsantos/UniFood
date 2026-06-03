package repository;

import java.util.ArrayList;
import java.util.List;

import model.Refeicao;

public class RefeicaoRepository {

    private static List<Refeicao> refeicoes = new ArrayList<>();

    static {

        refeicoes.add(
                new Refeicao(
                        "Almoço Tradicional",
                        "Arroz, feijão, carne bovina, salada e sobremesa",
                        5.00,
                        50
                )
        );

        refeicoes.add(
                new Refeicao(
                        "Almoço Vegetariano",
                        "Arroz, feijão, hambúrguer de grão-de-bico, salada e sobremesa",
                        5.00,
                        30
                )
        );

        refeicoes.add(
                new Refeicao(
                        "Janta Tradicional",
                        "Arroz, feijão, frango grelhado, legumes refogados e fruta",
                        4.50,
                        40
                )
        );

        refeicoes.add(
                new Refeicao(
                        "Janta Vegana",
                        "Arroz integral, lentilha, legumes assados e salada",
                        4.50,
                        25
                )
        );
    }

    public List<Refeicao> listarRefeicoes() {
        return refeicoes;
    }

    public Refeicao buscarPorIndice(int indice) {

        if (indice < 0 || indice >= refeicoes.size()) {
            return null;
        }

        return refeicoes.get(indice);
    }
}