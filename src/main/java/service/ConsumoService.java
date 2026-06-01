package service;

import model.Usuario;
import model.Refeicao;

public class ConsumoService {

    public boolean registrarConsumo(
            Usuario usuario,
            Refeicao refeicao
    ) {

        if (usuario.getSaldo() < refeicao.getValor()) {
            System.out.println("Saldo insuficiente.");
            return false;
        }

        if (refeicao.getQuantidade() <= 0) {
            System.out.println("Refeição indisponível.");
            return false;
        }

        usuario.setSaldo(
                usuario.getSaldo() - refeicao.getValor()
        );

        refeicao.setQuantidade(
                refeicao.getQuantidade() - 1
        );

        System.out.println("Consumo registrado com sucesso.");

        System.out.println(
                "Novo saldo: R$ " + usuario.getSaldo()
        );

        System.out.println(
                "Quantidade restante: " +
                refeicao.getQuantidade()
        );

        return true;
    }
}