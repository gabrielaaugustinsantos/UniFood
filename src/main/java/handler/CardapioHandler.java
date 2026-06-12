package handler;

import java.util.List;

import model.Refeicao;
import repository.RefeicaoRepository;

public class CardapioHandler {

    private RefeicaoRepository repository;

    public CardapioHandler(
            RefeicaoRepository repository
    ) {
        this.repository = repository;
    }

    public void listarCardapio() {

        List<Refeicao> refeicoes =
                repository.listarRefeicoes();

        System.out.println(
                "\n===== CARDÁPIO ====="
        );

        for (
                int i = 0;
                i < refeicoes.size();
                i++
        ) {

            Refeicao r =
                    refeicoes.get(i);

            System.out.println(
                    "\n" +
                    (i + 1) +
                    " - " +
                    r.getNome()
            );

            System.out.println(
                    "Descrição: "
                    + r.getDescricao()
            );

            System.out.println(
                    "Valor: R$ "
                    + r.getValor()
            );

            System.out.println(
                    "Disponível: "
                    + r.getQuantidade()
            );
        }
    }
}