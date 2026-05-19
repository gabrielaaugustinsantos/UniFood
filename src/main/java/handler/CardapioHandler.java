package handler;

import model.Refeicao;
import repository.RefeicaoRepository;

public class CardapioHandler {

    private RefeicaoRepository repository = new RefeicaoRepository();

    public void listarCardapio() {

        for (Refeicao refeicao : repository.listarRefeicoes()) {

            System.out.println("Nome: " + refeicao.getNome());
            System.out.println("Descrição: " + refeicao.getDescricao());
            System.out.println("Valor: " + refeicao.getValor());
            System.out.println("Quantidade: " + refeicao.getQuantidade());
            System.out.println("----------------------");
        }
    }
}