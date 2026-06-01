package model;

public class Refeicao {

    private String nome;
    private String descricao;
    private double valor;
    private int quantidade;

    public Refeicao(
            String nome,
            String descricao,
            double valor,
            int quantidade
    ) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}